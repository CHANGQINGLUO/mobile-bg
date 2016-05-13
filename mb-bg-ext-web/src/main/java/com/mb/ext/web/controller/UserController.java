/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 22 Jul, 2014 3:51:37 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 22 Jul, 2014 3:51:37 pm
 * @author SPA
 * @mb-bg-ext-web
 * ConnectionTestController.java
 *
 */
package com.mb.ext.web.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mb.ext.core.constant.Constants;
import com.mb.ext.core.constant.WechatConstants;
import com.mb.ext.core.service.UserService;
import com.mb.ext.core.service.spec.IncomeDTO;
import com.mb.ext.core.service.spec.NewsArticleMessageDTO;
import com.mb.ext.core.service.spec.OrderDTO;
import com.mb.ext.core.service.spec.PayDTO;
import com.mb.ext.core.service.spec.PayRequest;
import com.mb.ext.core.service.spec.PayResponse;
import com.mb.ext.core.service.spec.PayResultResponse;
import com.mb.ext.core.service.spec.ProductDTO;
import com.mb.ext.core.service.spec.ResultDTO;
import com.mb.ext.core.service.spec.SummaryDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.session.SessionContainer;
import com.mb.ext.web.util.MailSenderUtil;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @author SPA
 * 
 */
@Controller
public class UserController {
	private static int refreshCount = 0;

	private static final int TOTAL_ALLOWED_REFRESH_COUNT = 200;

	private final LogHelper logger = LogHelper.getInstance(this.getClass()
			.getName());

	@Autowired
	private UserService userService;

	@Autowired
	private MailSenderUtil mailSenderUtil;

	@Autowired
	private PropertyRepository propertyRepository;

	/**
	 * 
	 * Register User
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO registerUser(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		boolean result;
		try {
			if (userDTO.getClientCode() == null
					|| userDTO.getClientCode().trim().equals(""))
				result = userService.registerUser(userDTO.getLoginId(),
						userDTO.getPassword(), userDTO.getEmail(),
						userDTO.getHp(), userDTO.getName(), userDTO.getRole(),
						userDTO.getAddress(), userDTO.getCompany());
			else
				result = userService.registerUserByAdvisor(
						userDTO.getClientCode(), userDTO.getLoginId(),
						userDTO.getPassword(), userDTO.getEmail(),
						userDTO.getHp(), userDTO.getName(), userDTO.getRole(),
						userDTO.getAddress(), userDTO.getCompany());
			if (result) {
				resultDTO.setCode("0");
				resultDTO.setMessage("Register successfully");
			} else {
				resultDTO.setCode("1");
				resultDTO.setMessage("Register failed");
			}
		} catch (BusinessException e) {
			resultDTO.setCode(e.getErrorCode());
			resultDTO.setMessage(e.getMessage());
		}

		return resultDTO;
	}

	/**
	 * 
	 * Register User
	 */
	@RequestMapping(value = "/registerAdvisor", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO registerAdvisor(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		try {
			boolean result = userService.registerAdvisor(
					userDTO.getInternalUserId(), userDTO.getLoginId(),
					userDTO.getPassword(), userDTO.getEmail(), userDTO.getHp(),
					userDTO.getName(), userDTO.getRole(), userDTO.getAddress(),
					userDTO.getCompany());
			if (result) {
				resultDTO.setCode("0");
				resultDTO.setMessage("Register successfully");
			} else {
				resultDTO.setCode("1");
				resultDTO.setMessage("Register failed");
			}
		} catch (BusinessException e) {
			resultDTO.setCode(e.getErrorCode());
			resultDTO.setMessage(e.getMessage());
		}

		return resultDTO;
	}

	/**
	 * 
	 * login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO login(@RequestBody UserDTO userDTO) {

		ResultDTO resultDTO = new ResultDTO();

		try {
			boolean result = userService.login(userDTO.getLoginId(),
					userDTO.getPassword());
			if (result) {
				resultDTO.setCode("0");
				resultDTO.setMessage("Login successfully");
				UserDTO nUserDTO = userService.getUser(userDTO.getLoginId());
				resultDTO.setBody(nUserDTO);
				SessionContainer.addSession(userDTO.getLoginId());
			} else {
				resultDTO.setCode("1");
				resultDTO.setMessage("Login failed");
			}
		} catch (BusinessException e) {
			resultDTO.setCode(e.getErrorCode());
			resultDTO.setMessage(e.getMessage());
		}

		return resultDTO;
	}

	/**
	 * 
	 * logout
	 * 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO logout(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		boolean result = true;
		// TODO do some business related activities
		if (result) {
			SessionContainer.removeSession(userDTO.getLoginId());
			resultDTO.setCode("0");
			resultDTO.setMessage("logout successfully");
		} else {
			resultDTO.setCode("1");
			resultDTO.setMessage("logout failed");
		}

		return resultDTO;
	}

	/**
	 * 
	 * 
	 * 
	 */
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO resetPassword(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		try {
			String password = userService.resetPassword(userDTO.getLoginId());
			UserDTO nUserDTO = userService.getUser(userDTO.getLoginId());
			String subject = propertyRepository
					.getProperty("mail.resetpassword.subject");
			String body = propertyRepository.getProperty(
					"mail.resetpassword.body").replace("{1}", password);
			String sentTo = nUserDTO.getEmail();
			mailSenderUtil.sendMail(subject, body, sentTo, "", null);
			resultDTO.setCode("0");
			resultDTO.setMessage("reset password successfully");
			SessionContainer.addSession(userDTO.getLoginId());
		} catch (BusinessException e) {
			resultDTO.setCode(e.getErrorCode());
			resultDTO.setMessage(e.getMessage());
		}

		return resultDTO;
	}

	/**
	 * 
	 * change password
	 * 
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO changePassword(@RequestBody UserDTO userDTO) {

		ResultDTO resultDTO = new ResultDTO();
		try {
			boolean result = userService.changePassword(userDTO.getLoginId(),
					userDTO.getPassword(), userDTO.getNewPassword());
			if (result) {
				resultDTO.setCode("0");
				resultDTO.setMessage("Change password successfully");
			} else {
				resultDTO.setCode("1");
				resultDTO.setMessage("Change password failed");
			}
		} catch (BusinessException e) {
			resultDTO.setCode(e.getErrorCode());
			resultDTO.setMessage(e.getMessage());
		}

		return resultDTO;
	}

	/**
	 * 
	 * logout
	 * 
	 */
	@RequestMapping(value = "/updateUserDetail", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO updateUserDetail(@RequestBody UserDTO userDTO) {

		ResultDTO resultDTO = new ResultDTO();
		try {
			boolean result = userService.updateUserDetail(userDTO.getLoginId(),
					userDTO.getEmail(), userDTO.getHp(), userDTO.getName(),
					userDTO.getAddress(), userDTO.getCompany());
			if (result) {
				resultDTO.setCode("0");
				resultDTO.setMessage("update user detail successfully");
			} else {
				resultDTO.setCode("1");
				resultDTO.setMessage("update user detail");
			}
		} catch (BusinessException e) {
			resultDTO.setCode(e.getErrorCode());
			resultDTO.setMessage(e.getMessage());
		}

		return resultDTO;
	}

	/**
	 * 
	 * get customer list by advisor
	 * 
	 */
	@RequestMapping(value = "/getCustomerListByAdvisor", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getCustomerListByAdvisor(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		List<UserDTO> customerList = new ArrayList<UserDTO>();
		try {
			customerList = userService.getCustomerList(userDTO.getLoginId());
			resultDTO.setCode("0");
			resultDTO.setMessage("Get customer list successfully");
			resultDTO.setBody(customerList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get customer list by advisor
	 * 
	 */
	@RequestMapping(value = "/getInternalUserList", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getCustomerListByAdvisor() {
		ResultDTO resultDTO = new ResultDTO();
		List<UserDTO> internalUserList = new ArrayList<UserDTO>();
		try {
			internalUserList = userService.getInternalUserList();
			resultDTO.setCode("0");
			resultDTO.setMessage("Get customer list successfully");
			resultDTO.setBody(internalUserList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get customer list by advisor
	 * 
	 */
	@RequestMapping(value = "/getAdvisorsByInternalUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getAdvisorsByInternalUser(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String loginId = userDTO.getLoginId();
		List<UserDTO> internalUserList = new ArrayList<UserDTO>();
		try {
			internalUserList = userService.getAdvisorsByInternalUser(loginId);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get advisor list successfully");
			resultDTO.setBody(internalUserList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get customer list by advisor
	 * 
	 */
	@RequestMapping(value = "/getAdvisor", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getAdvisor(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		UserDTO nUserDTO = new UserDTO();
		try {
			nUserDTO = userService.getAdvisor(userDTO.getLoginId());
			resultDTO.setCode("0");
			resultDTO.setMessage("Get advisor successfully");
			resultDTO.setBody(nUserDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get article
	 * 
	 */
	@RequestMapping(value = "/getArticles", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getArticles() {
		ResultDTO resultDTO = new ResultDTO();
		List<NewsArticleMessageDTO> articleList = new ArrayList<NewsArticleMessageDTO>();
		try {
			articleList = userService.getArticles();
			resultDTO.setCode("0");
			resultDTO.setMessage("Get articles successfully");
			resultDTO.setBody(articleList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get article
	 * 
	 */
	@RequestMapping(value = "/getRecommendedArticles", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getRecommendedArticles() {
		ResultDTO resultDTO = new ResultDTO();
		List<NewsArticleMessageDTO> articleList = new ArrayList<NewsArticleMessageDTO>();
		try {
			articleList = userService.getRecommendedArticles();
			resultDTO.setCode("0");
			resultDTO.setMessage("Get articles successfully");
			resultDTO.setBody(articleList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get article
	 * 
	 */
	@RequestMapping(value = "/getArticlesByType", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getArticlesByType(@RequestBody NewsArticleMessageDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		List<NewsArticleMessageDTO> articleList = new ArrayList<NewsArticleMessageDTO>();
		try {
			articleList = userService.getArticlesByType(rDTO.getType());
			resultDTO.setCode("0");
			resultDTO.setMessage("Get articles successfully");
			resultDTO.setBody(articleList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getNews", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getNews() {
		ResultDTO resultDTO = new ResultDTO();
		List<NewsArticleMessageDTO> newsList = new ArrayList<NewsArticleMessageDTO>();
		try {
			newsList = userService.getNews();
			resultDTO.setCode("0");
			resultDTO.setMessage("Get news successfully");
			resultDTO.setBody(newsList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getMessages", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getMessages() {
		ResultDTO resultDTO = new ResultDTO();
		List<NewsArticleMessageDTO> messageList = new ArrayList<NewsArticleMessageDTO>();
		try {
			messageList = userService.getMessages();
			resultDTO.setCode("0");
			resultDTO.setMessage("Get messages successfully");
			resultDTO.setBody(messageList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getProductListByType", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getProductListByType(@RequestBody ProductDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		try {
			productList = userService.getProductsByType(rDTO.getType());
			resultDTO.setCode("0");
			resultDTO.setMessage("Get product list successfully");
			resultDTO.setBody(productList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getProductByUUID", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getProductByUUID(@RequestBody ProductDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		ProductDTO productDTO = new ProductDTO();
		try {
			productDTO = userService.getProductByUUID(rDTO.getUuid());
			resultDTO.setCode("0");
			resultDTO.setMessage("Get product list successfully");
			resultDTO.setBody(productDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO addOrder(@RequestBody OrderDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		try {
			rDTO.setOrderNumber(RandomStringUtils.randomNumeric(32));
			userService.addOrder(rDTO);
			
			String subject = propertyRepository
					.getProperty("mail.addorder.subject");
			String body = propertyRepository.getProperty(
					"mail.addorder.body").
					replace("{1}", rDTO.getOrderNumber()).
					replace("{2}", rDTO.getCustomerName()).
					replace("{3}", rDTO.getPhone()).
					replace("{4}", rDTO.getMailAddress()).
					replace("{5}", rDTO.getProductName()).
					replace("{6}", rDTO.getAmount().toString()).
					replace("{7}", rDTO.getPreAmount().toString());
			String sentTo = propertyRepository
					.getProperty("mail.smtp.username");
			mailSenderUtil.sendMail(subject, body, sentTo, "", null);
			
			resultDTO.setCode("0");
			resultDTO.setMessage("Add order successfully");
			resultDTO.setBody(rDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getOrderList(@RequestBody OrderDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String loginId = rDTO.getLoginId();
		try {
			List<OrderDTO> orderList = userService.getOrderByUser(loginId);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get product list successfully");
			resultDTO.setBody(orderList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getOrderListByStatus", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getOrderListByStatus(@RequestBody OrderDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String loginId = rDTO.getLoginId();
		String status = rDTO.getStatus();
		try {
			List<OrderDTO> orderList = userService.getOrderByUserAndStatus(
					loginId, status);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get product list successfully");
			resultDTO.setBody(orderList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getOrderByUUID", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getOrderByUUID(@RequestBody OrderDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String uuid = rDTO.getUuid();
		try {
			OrderDTO orderDTO = userService.getOrderById(uuid);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get product list successfully");
			resultDTO.setBody(orderDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}
	
	@RequestMapping(value = "/getOrderByNumber", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getOrderByNumber(@RequestBody OrderDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String orderNumber = rDTO.getOrderNumber();
		try {
			OrderDTO orderDTO = userService.getOrderByNumber(orderNumber);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get order  successfully");
			resultDTO.setBody(orderDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getIncome", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getIncome(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String loginId = userDTO.getLoginId();
		IncomeDTO incomeDTO = new IncomeDTO();
		try {
			BigDecimal income = userService.getTotalIncomeByUser(loginId);
			BigDecimal payment = userService
					.getTotalTransferAmountByUser(loginId);
			incomeDTO.setTotalIncome(income);
			incomeDTO.setTotalPayment(payment);
			incomeDTO.setTotalOutstanding(income.subtract(payment));
			resultDTO.setCode("0");
			resultDTO.setMessage("Get product list successfully");
			resultDTO.setBody(incomeDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getIncomeList", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getIncomeList(@RequestBody UserDTO userDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String loginId = userDTO.getLoginId();
		try {
			List<IncomeDTO> incomeList = userService.getIncomesByUser(loginId);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get income list successfully");
			resultDTO.setBody(incomeList);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/getIncomeById", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getIncomeById(@RequestBody IncomeDTO incomeDTO) {
		ResultDTO resultDTO = new ResultDTO();
		String uuid = incomeDTO.getUuid();
		try {
			IncomeDTO cIncomeDTO = userService.getIncome(uuid);
			String orderUUID = cIncomeDTO.getOrderUuid();
			OrderDTO orderDTO = userService.getOrderById(orderUUID);
			String loginId = orderDTO.getLoginId();
			UserDTO userDTO = userService.getUser(loginId);
			cIncomeDTO.setOrderDTO(orderDTO);
			cIncomeDTO.setUserDTO(userDTO);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get income list successfully");
			resultDTO.setBody(cIncomeDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	/**
	 * 
	 * get article
	 * 
	 */
	@RequestMapping(value = "/getArticlesAndProducts", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getArticlesAndProducts(
			@RequestBody NewsArticleMessageDTO rDTO) {
		ResultDTO resultDTO = new ResultDTO();
		SummaryDTO summaryDTO = new SummaryDTO();
		List<NewsArticleMessageDTO> articleList1 = new ArrayList<NewsArticleMessageDTO>();
		List<NewsArticleMessageDTO> articleList2 = new ArrayList<NewsArticleMessageDTO>();
		List<NewsArticleMessageDTO> articleList3 = new ArrayList<NewsArticleMessageDTO>();
		List<NewsArticleMessageDTO> articleList4 = new ArrayList<NewsArticleMessageDTO>();
		List<NewsArticleMessageDTO> articleList5 = new ArrayList<NewsArticleMessageDTO>();
		List<ProductDTO> fProductList = new ArrayList<ProductDTO>();
		List<ProductDTO> aProductList = new ArrayList<ProductDTO>();
		List<ProductDTO> oProductList = new ArrayList<ProductDTO>();
		List<ProductDTO> cProductList = new ArrayList<ProductDTO>();

		try {
			articleList1 = userService.getArticlesByType("1");
			summaryDTO.setArticleList1(articleList1);
			articleList2 = userService.getArticlesByType("2");
			summaryDTO.setArticleList2(articleList2);
			articleList3 = userService.getArticlesByType("3");
			summaryDTO.setArticleList3(articleList3);
			articleList4 = userService.getArticlesByType("4");
			summaryDTO.setArticleList4(articleList4);
			articleList5 = userService.getArticlesByType("5");
			summaryDTO.setArticleList5(articleList5);
			fProductList = userService.getProductsByType("F");
			summaryDTO.setfProductList(fProductList);
			aProductList = userService.getProductsByType("A");
			summaryDTO.setaProductList(aProductList);
			oProductList = userService.getProductsByType("O");
			summaryDTO.setoProductList(oProductList);
			cProductList = userService.getProductsByType("C");
			summaryDTO.setcProductList(cProductList);
			resultDTO.setCode("0");
			resultDTO.setMessage("Get articles successfully");
			resultDTO.setBody(summaryDTO);
		} catch (BusinessException e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		return resultDTO;
	}

	@RequestMapping(value = "/getAirQuality", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO getAirQuality() {
		// AirQualityDTO airQualityDTO = new AirQualityDTO();
		ResultDTO resultDTO = new ResultDTO();
		String result = null;
		try {
			String httpUrl = Constants.WEATHER_URL;
			BufferedReader reader = null;
			InputStream is = null;
			StringBuffer sbf = new StringBuffer();
			try {
				URL url = new URL(httpUrl);
				HttpsURLConnection connection = (HttpsURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				is = connection.getInputStream();

				reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sbf.append(strRead);
					sbf.append("\r\n");
				}

				result = sbf.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				reader.close();
				is.close();
			}

			resultDTO.setCode("0");
			resultDTO.setMessage("Get air quality successfully");

		} catch (Exception e) {
			resultDTO.setCode("1");
			resultDTO.setMessage(e.getMessage());
		}
		resultDTO.setBody(result);
		return resultDTO;
	}

	/**
	 * 
	 * get news
	 * 
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResultDTO pay(@RequestBody PayDTO payDTO, HttpServletRequest request) {
		ResultDTO resultDTO = new ResultDTO();
		PayRequest payRequest = new PayRequest();
		payRequest.setAppid(WechatConstants.APPID_VALUE);
		payRequest.setMch_id(WechatConstants.MERCHANT_ID);
		payRequest.setNonce_str(RandomStringUtils.randomAlphanumeric(32));
		payRequest.setOut_trade_no(payDTO.getOut_trade_no());
		try {
			OrderDTO orderDTO = userService.getOrderByNumber(payDTO
					.getOut_trade_no());
			String productName = orderDTO.getProductName();
			BigDecimal amount = orderDTO.getPreAmount();
			payRequest.setBody(productName);
			payRequest.setTotal_fee(amount.multiply(new BigDecimal(100))
					.intValue());
			payRequest.setSpbill_create_ip(request.getRemoteAddr());
			payRequest.setNotify_url(WechatConstants.NOTIFY_URL);
			payRequest.setTrade_type("APP");
			payRequest.setAttach("ZHONGHUANBO");
		} catch (Exception e) {
			resultDTO.setCode("1");
			resultDTO.setMessage("下单失败");
			return resultDTO;
		}
		
		payRequest.setSign(getSign(payRequest));
		//������ת��������xml
		XStream xstreamRes = new XStream(new XppDriver() {
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					// ����CDATA���
					boolean cdata = true;

					@SuppressWarnings("rawtypes")
					public void startNode(String name, Class clazz) {
						super.startNode(name, clazz);
					}

					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write("<![CDATA[");
							writer.write(text);
							writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		});
		XStream xstreamReq = new XStream(new XppDriver() /*{
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out) {
					// ����CDATA���
					boolean cdata = true;

					@SuppressWarnings("rawtypes")
					public void startNode(String name, Class clazz) {
						super.startNode(name, clazz);
					}

					protected void writeText(QuickWriter writer, String text) {
						if (cdata) {
							writer.write("<![CDATA[");
							writer.write(text);
							writer.write("]]>");
						} else {
							writer.write(text);
						}
					}
				};
			}
		}*/);
		xstreamReq.alias("xml", payRequest.getClass());
		String requestXML = xstreamReq.toXML(payRequest).replace("\n", "").replace("__", "_");
		try {
			requestXML = new String(requestXML.getBytes("utf-8"),"iso-8859-1");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		//����΢�Žӿ�
		BufferedReader reader = null;
		InputStream is = null;
		DataOutputStream out = null;
		StringBuffer sbf = new StringBuffer();
		String wechatResponseStr = "";
		try {
			URL url = new URL(WechatConstants.UNIFIED_ORDER_URL);
			HttpsURLConnection connection = (HttpsURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			out = new DataOutputStream(connection.getOutputStream()); 
			out.writeBytes(requestXML);
			out.flush();
					
					
			is = connection.getInputStream();

			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			
			wechatResponseStr = sbf.toString();
		} catch (Exception e) {
			resultDTO.setCode("1");
			resultDTO.setMessage("下单失败");
			return resultDTO;
		} finally {
			try {
				reader.close();
				is.close();
				out.close();
			} catch (IOException e) {
				resultDTO.setCode("1");
				resultDTO.setMessage("下单失败");
				return resultDTO;
			}
			
		}
		
		//���?�����
		xstreamRes.alias("xml", PayResponse.class);
		PayResponse payResponse = (PayResponse) xstreamRes.fromXML(wechatResponseStr);
		//MOCK MODE
		/*PayResponse payResponse = new PayResponse();
		payResponse.setPrepay_id("WX123456789009876543211234567890");
		payResponse.setMch_id("6749328409382943");
		payResponse.setNonce_str("764932874987392");
		payResponse.setTrade_type("APP");
		payResponse.setReturn_code("SUCCESS");
		payResponse.setResult_code("SUCCESS");*/
		
		
		
		if("SUCCESS".equals(payResponse.getReturn_code()) && "SUCCESS".equals(payResponse.getResult_code())){
			payDTO.setMch_id(payResponse.getMch_id());
			payDTO.setNonce_str(payResponse.getNonce_str());
			payDTO.setPrepay_id(payResponse.getPrepay_id());
			payDTO.setTrade_type(payResponse.getTrade_type());
			payDTO.setTimestamp(String.valueOf(System.currentTimeMillis()/1000));
			payDTO.setSign(getSignForClient(payDTO));
			resultDTO.setBody(payDTO);
			resultDTO.setCode("0");
			resultDTO.setMessage("下单成功");
		}else{
			resultDTO.setCode("1");
			resultDTO.setMessage("下单失败");
			return resultDTO;
		}
		
		return resultDTO;
	}
	
	@RequestMapping(value = "/wechatPayResponse", method = RequestMethod.POST)
	@ResponseBody
	public String wechatPayResponse(HttpServletRequest request, HttpServletResponse response) {
		int length = request.getContentLength();
		byte[] bytes = new byte[length];
		InputStream inputStream;
		try {
			inputStream = request.getInputStream();
			inputStream.read(bytes);
			String responseStr = new String(bytes, "UTF-8");
			
			XStream xstream = new XStream(new XppDriver() {
				public HierarchicalStreamWriter createWriter(Writer out) {
					return new PrettyPrintWriter(out) {
						// ����CDATA���
						boolean cdata = true;

						@SuppressWarnings("rawtypes")
						public void startNode(String name, Class clazz) {
							super.startNode(name, clazz);
						}

						protected void writeText(QuickWriter writer, String text) {
							if (cdata) {
								writer.write("<![CDATA[");
								writer.write(text);
								writer.write("]]>");
							} else {
								writer.write(text);
							}
						}
					};
				}
			});
			
			xstream.alias("xml", PayResultResponse.class);
			PayResultResponse payResultResponse = (PayResultResponse) xstream.fromXML(responseStr);
			
			if(!"SUCCESS".equals(payResultResponse.getResult_code())||!"SUCCESS".equals(payResultResponse.getResult_code())){
				response.sendError(500);
			}else{
				String orderNumber = payResultResponse.getOut_trade_no();
				try {
					userService.updateOrderStatus(orderNumber, Constants.ORDER_STATUS_INPROGRESS);
					return WechatConstants.SUCCESS_RESPONSE;
				} catch (BusinessException e) {
					logger.error(e.getMessage());
					response.sendError(500);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			try {
				response.sendError(500);
			} catch (IOException e1) {
				logger.error(e1.getMessage());
			}
		}
		return "";
	}

	private String getSign(PayRequest payRequest) {
		String signTemp = "appid=" + payRequest.getAppid() + "&attach=" + payRequest.getAttach()
				+"&body="
				+ payRequest.getBody() + "&mch_id=" + payRequest.getMch_id()
				+ "&nonce_str=" + payRequest.getNonce_str() + "&notify_url="
				+ payRequest.getNotify_url() + "&out_trade_no="
				+ payRequest.getOut_trade_no() + "&spbill_create_ip="
				+ payRequest.getSpbill_create_ip() + "&total_fee="
				+ payRequest.getTotal_fee() + "&trade_type="
				+ payRequest.getTrade_type() + "&key=" + WechatConstants.KEY; 
		String sign = encodeMd5(signTemp).toUpperCase();
		return sign;
	}
	
	private String getSignForClient(PayDTO payDTO) {
		String signTemp = "appid=" + WechatConstants.APPID_VALUE
				+ "&noncestr=" + payDTO.getNonce_str()
				+ "&package=" + "Sign=WXPay"
				+ "&partnerid=" + payDTO.getMch_id()
				+ "&prepayid=" + payDTO.getPrepay_id()
				+ "&timestamp=" + payDTO.getTimestamp()
				+ "&key=" + WechatConstants.KEY; // 
		String sign = encodeMd5(signTemp).toUpperCase();
		return sign;
	}

	private String encodeMd5(String inStr) {
		StringBuffer hexValue = new StringBuffer();
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");

			byte[] byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = md5.digest(byteArray);

			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		return hexValue.toString();
	}
}
