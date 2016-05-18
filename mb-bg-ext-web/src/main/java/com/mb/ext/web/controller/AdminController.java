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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mb.ext.core.constant.Constants;
import com.mb.ext.core.service.UserService;
import com.mb.ext.core.service.spec.ImageDTO;
import com.mb.ext.core.service.spec.IncomeDTO;
import com.mb.ext.core.service.spec.NewsArticleMessageDTO;
import com.mb.ext.core.service.spec.OrderDTO;
import com.mb.ext.core.service.spec.ProductDTO;
import com.mb.ext.core.service.spec.ResultDTO;
import com.mb.ext.core.service.spec.TransferDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.web.util.MailSenderUtil;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;

/**
 * @author SPA
 * 
 */
@Controller
public class AdminController {
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
	 * login submit
	 */
	@RequestMapping(value = "/admin_login_submit", method = RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request, ModelMap model) {

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String viewName = "index";
		ResultDTO resultDTO = new ResultDTO();

		try {
			boolean result = userService.login(loginId, password);
			if (result) {
				UserDTO nUserDTO = userService.getUser(loginId);
				resultDTO.setBody(nUserDTO);
				// SessionContainer.addSession(loginId);
				request.getSession().setAttribute(request.getSession().getId(),
						loginId);
			} else {
				viewName = "login";
				model.addAttribute("error", "登录失败, 请稍候重试");
			}
		} catch (BusinessException e) {
			viewName = "login";
		}

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) {

		String viewName = "login";
		String sessionId = request.getSession().getId();
		request.getSession().removeAttribute(sessionId);

		return viewName;
	}

	/**
	 * 
	 * login
	 */
	@RequestMapping(value = "/admin_login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		String viewName = "login";

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_article", method = RequestMethod.GET)
	public String listArticles(HttpServletRequest request, ModelMap model) {

		String type = request.getParameter("type");
		String viewName = "article-list";

		try {
			List<NewsArticleMessageDTO> list = userService
					.getArticlesByType(type);
			model.addAttribute("articleList", list);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_products", method = RequestMethod.GET)
	public String listProducts(HttpServletRequest request, ModelMap model) {

		// String type = request.getParameter("type");
		String viewName = "product-list";

		try {
			List<ProductDTO> fProductList = userService.getProductsByType("F");
			List<ProductDTO> aProductList = userService.getProductsByType("A");
			List<ProductDTO> oProductList = userService.getProductsByType("O");
			List<ProductDTO> cProductList = userService.getProductsByType("C");
			model.addAttribute("fProductList", fProductList);
			model.addAttribute("aProductList", aProductList);
			model.addAttribute("oProductList", oProductList);
			model.addAttribute("cProductList", cProductList);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_orders", method = RequestMethod.GET)
	public String listOrders(HttpServletRequest request, ModelMap model) {

		String viewName = "order-list";
		String status = request.getParameter("status");
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		try {
			if (status == null) {
				list = userService.getOrders();
			} else {
				list = userService.getOrdersByStatus(status);
			}
			model.addAttribute("orderList", list);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_list_transfers", method = RequestMethod.GET)
	public String listTransfers(HttpServletRequest request, ModelMap model) {

		String viewName = "transfer-list";
		String loginId = request.getParameter("loginId");
		List<TransferDTO> list = new ArrayList<TransferDTO>();
		try {
			if (loginId == null || "".equals(loginId.trim())) {
				list = userService.getTransfers();
			} else {
				list = userService.getTransfersByUser(loginId);
				;
			}
			model.addAttribute("transferList", list);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_create_transfer", method = RequestMethod.GET)
	public String createTransfer(HttpServletRequest request, ModelMap model) {
		String loginId = (String) request.getParameter("loginId");
		String viewName = "transfer-create";
		if (loginId != null && !loginId.trim().equals("")) {
			try {
				UserDTO dto = userService.getUser(loginId);
				if (dto == null||!"advisor".equals(dto.getRole()))
					model.addAttribute("message", "未找到代理商");
				else
					model.addAttribute("userDTO", dto);
			} catch (BusinessException e) {
				logger.error("query user error");
				model.addAttribute("message", "未找到代理商");
			}

		}
		return viewName;
	}

	@RequestMapping(value = "/admin_create_transfer_submit", method = RequestMethod.POST)
	public String createTransferSubmit(HttpServletRequest request,
			ModelMap model) {

		String viewName = "transfer-create";

		String customerLoginId = request.getParameter("customerLoginId");
		String amountStr = request.getParameter("amount");
		BigDecimal amount = null;

		if (customerLoginId == null || customerLoginId.trim().equals("")) {
			model.addAttribute("message", "请先查询客户");
			return viewName;
		}

		try {
			amount = new BigDecimal(amountStr);
		} catch (Exception e) {
			model.addAttribute("message", "错误的金额");
			return viewName;
		}
		try {
			TransferDTO dto = new TransferDTO();
			dto.setToLoginId(customerLoginId);
			dto.setAmount(amount);
			dto.setTransferDate(new Date());
			userService.addTransfer(dto);
			model.addAttribute("message", "转帐成功");
		} catch (BusinessException e1) {
			model.addAttribute("message", "转帐失败");
			return viewName;
		}

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_orders_for_user", method = RequestMethod.GET)
	public String listOrdersByUser(HttpServletRequest request, ModelMap model) {

		String viewName = "order-list";
		String loginId = request.getParameter("loginId");
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		try {
			list = userService.getOrderByUser(loginId);
			model.addAttribute("orderList", list);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_advisors", method = RequestMethod.GET)
	public String listAdvisors(HttpServletRequest request, ModelMap model) {

		String viewName = "advisor-list";

		try {
			List<UserDTO> list = userService.getProxies();
			model.addAttribute("advisorList", list);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_advisor_modify", method = RequestMethod.GET)
	public String modifyAdvisor(HttpServletRequest request, ModelMap model) {

		String loginId = request.getParameter("loginId");

		String viewName = "advisor-modify";

		try {
			UserDTO dto = userService.getUser(loginId);
			List<UserDTO> customerList = userService.getCustomerList(loginId);
			model.addAttribute("userDTO", dto);
			model.addAttribute("customerList", customerList);
		} catch (BusinessException e) {
			logger.error("modify order error: " + e.getMessage());
		}

		return viewName;
	}

	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_customers", method = RequestMethod.GET)
	public String listCustomers(HttpServletRequest request, ModelMap model) {

		String viewName = "customer-list";

		try {
			List<UserDTO> list = userService.getCustomers();
			model.addAttribute("customerList", list);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "index";
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_customer_modify", method = RequestMethod.GET)
	public String modifyCustomer(HttpServletRequest request, ModelMap model) {

		String loginId = request.getParameter("loginId");

		String viewName = "customer-modify";

		try {
			UserDTO dto = userService.getUser(loginId);
			model.addAttribute("userDTO", dto);
			
			UserDTO advisorDto = userService.getAdvisor(loginId);
			UserDTO customerDto = userService.getCustomerByCustomer(loginId);
			UserDTO internalDto = userService.getInternalUser(loginId);
			if(customerDto != null)
				model.addAttribute("advisorDTO", customerDto);
			else if(advisorDto != null)
				model.addAttribute("advisorDTO", advisorDto);
			else if(internalDto != null)
				model.addAttribute("advisorDTO", internalDto);
		} catch (BusinessException e) {
			logger.error("modify order error: " + e.getMessage());
		}

		return viewName;
	}

	
	@RequestMapping(value = "/admin_list_main_images", method = RequestMethod.GET)
	public String listMainImages(HttpServletRequest request, ModelMap model) {

		String viewName = "image-list";

		return viewName;
	}
	
	@RequestMapping(value = "/admin_article_image_create", method = RequestMethod.GET)
	public String createArticleImage(HttpServletRequest request, ModelMap model) {

		String viewName = "article-image-create";

		return viewName;
	}
	
	
	/**
	 * 
	 * login submit
	 */
	@RequestMapping(value = "/admin_list_article_images", method = RequestMethod.GET)
	public String listArticleImages(HttpServletRequest request, ModelMap model) {

		String viewName = "article-image-list";
		List<ImageDTO> imageDTOList = new ArrayList<ImageDTO>();
		try{
			File articleImageFolder = new File("c:\\project\\article-image\\");
			if(articleImageFolder.exists()){
				File[] files = articleImageFolder.listFiles();
				for (int i = 0; i < files.length; i++) {
					String fileName = files[i].getName();
					String referURL = "http://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getLocalPort()+request.getContextPath()+"/download/downloadArticleImage?name="+fileName;
					ImageDTO imageDTO = new ImageDTO();
					imageDTO.setFileName(fileName);	
					imageDTO.setReferURL(referURL);
					imageDTOList.add(imageDTO);
				}
			}
			model.addAttribute("fileList",imageDTOList);
		}catch(Exception e){
			
		}
		
		
		return viewName;
	}
	
	

	@RequestMapping(value = "/admin_article_create", method = RequestMethod.GET)
	public String createArticle(HttpServletRequest request, ModelMap model) {

		String viewName = "article-create";
		return viewName;
	}

	@RequestMapping(value = "/admin_product_create", method = RequestMethod.GET)
	public String createProduct(HttpServletRequest request, ModelMap model) {

		String viewName = "product-create";
		return viewName;
	}

	@RequestMapping(value = "/admin_product_create_submit", method = RequestMethod.POST)
	public String createProductSubmit(
			@RequestParam("image") MultipartFile image,
			HttpServletRequest request, ModelMap model) {

		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String priceStr = request.getParameter("price");
		String prePriceStr = request.getParameter("prePrice");
		String pointsStr = request.getParameter("points");
		String viewName = "product-list";
		ProductDTO dto = new ProductDTO();
		dto.setName(name);
		dto.setDescription(description);
		try{
			BigDecimal price = new BigDecimal(priceStr);
			BigDecimal prePrice = new BigDecimal(prePriceStr);
			dto.setPrice(price);
			dto.setPrePrice(prePrice);
		}catch(Exception e){
			viewName = "product-create";
			model.addAttribute("message", "价格格式不对");
			return viewName;
		}
		try{
			Integer points = new Integer(pointsStr);
			dto.setPoints(points);
		}catch(Exception e){
			viewName = "product-create";
			model.addAttribute("message", "点位数格式不对");
			return viewName;
		}
		
		dto.setType(type);
		try {
			userService.addProduct(dto);
			model.addAttribute("message", "创建产品成功");
		} catch (BusinessException e2) {
			logger.error("query articles error");
			viewName = "product-create";
		}

		OutputStream os = null;
		File imageFolder = null;
		File imageFile = null;
		try {
			ProductDTO productDTO = userService.getProductByName(name);
			imageFolder = new File("c:\\project\\product-image\\");
			imageFile = new File("c:\\project\\product-image\\image"
					+ productDTO.getUuid() + ".png");
			if (!imageFolder.exists())
				imageFolder.mkdirs();

			if (!imageFile.exists())
				imageFile.createNewFile();
			os = new FileOutputStream(imageFile);
			os.write(image.getBytes());
			os.flush();
		} catch (IOException e1) {
			logger.error("upload image error: " + e1.getMessage());
		} catch (BusinessException e) {
			logger.error("upload image error: " + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				logger.error("upload image error: " + e.getMessage());
			}
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_article_create_submit", method = RequestMethod.POST)
	public String createArticleSubmit(HttpServletRequest request, ModelMap model) {

		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isRecommended = request.getParameter("isRecommended");
		String viewName = "article-list";
		NewsArticleMessageDTO articleDTO = new NewsArticleMessageDTO();
		articleDTO.setContent(content);
		articleDTO.setTitle(title);
		articleDTO.setType(type);
		if (isRecommended == null)
			articleDTO.setIsRecommended("0");
		else
			articleDTO.setIsRecommended("1");
		try {
			userService.createArticle(articleDTO);
		} catch (BusinessException e) {
			logger.error("query articles error");
			viewName = "article-create";
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_article_delete", method = RequestMethod.POST)
	public String deleteArticle(HttpServletRequest request, ModelMap model) {

		String uuid = request.getParameter("uuid");
		String viewName = "article-list";

		try {
			userService.deleteArticle(uuid);
		} catch (BusinessException e) {
			logger.error("delete articles error: " + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_product_delete", method = RequestMethod.POST)
	public String deleteProduct(HttpServletRequest request, ModelMap model) {

		String uuid = request.getParameter("uuid");
		String viewName = "product-list";

		try {
			userService.deleteProduct(uuid);
			model.addAttribute("message", "删除产品成功");
		} catch (BusinessException e) {
			logger.error("delete product error: " + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_article_modify", method = RequestMethod.POST)
	public String modifyArticle(HttpServletRequest request, ModelMap model) {

		String uuid = request.getParameter("uuid");

		String viewName = "article-modify";

		try {
			NewsArticleMessageDTO dto = userService.getArticleByUUID(uuid);
			model.addAttribute("uuid", dto.getId());
			model.addAttribute("title", dto.getTitle());
			model.addAttribute("content", dto.getContent());
			model.addAttribute("type", dto.getType());
			model.addAttribute("isRecommended", dto.getIsRecommended());
		} catch (BusinessException e) {
			logger.error("modify articles error: " + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_product_modify", method = RequestMethod.POST)
	public String modifyProduct(HttpServletRequest request, ModelMap model) {

		String uuid = request.getParameter("uuid");

		String viewName = "product-modify";

		try {
			ProductDTO dto = userService.getProductByUUID(uuid);
			model.addAttribute("productDTO", dto);
		} catch (BusinessException e) {
			logger.error("modify product error: " + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_order_modify", method = RequestMethod.POST)
	public String modifyOrder(HttpServletRequest request, ModelMap model) {

		String orderNumber = request.getParameter("orderNumber");

		String viewName = "order-modify";

		try {
			OrderDTO dto = userService.getOrderByNumber(orderNumber);
			model.addAttribute("orderDTO", dto);
		} catch (BusinessException e) {
			logger.error("modify order error: " + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_order_upload_report", method = RequestMethod.POST)
	public String uploadReport(HttpServletRequest request,
			@RequestParam("report") MultipartFile file,
			@RequestParam("orderNumber") String orderNumber, ModelMap model) {

		String viewName = "order-list";
		OutputStream os = null;
		File reportFolder = new File("c:\\project\\report\\");
		File pdfFile = new File("c:\\project\\report\\" + orderNumber + ".pdf");
		try {
			if (!reportFolder.exists())
				reportFolder.mkdirs();

			if (!pdfFile.exists())
				pdfFile.createNewFile();
			os = new FileOutputStream(pdfFile);
			os.write(file.getBytes());
			os.flush();
		} catch (IOException e1) {
			logger.error("upload report error: " + e1.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				logger.error("upload report error: " + e.getMessage());
			}
		}
		try {
			userService.updateOrderStatus(orderNumber,
					Constants.ORDER_STATUS_COMPLETED);
		} catch (BusinessException e) {
			logger.error("update order status failure:" + e.getMessage());
		}

		try {
			OrderDTO orderDTO = userService.getOrderByNumber(orderNumber);
			String loginId = orderDTO.getLoginId();
			UserDTO advisor = userService.getAdvisor(loginId);
			UserDTO customer = userService.getCustomerByCustomer(loginId);
			UserDTO internalUser = userService.getInternalUser(loginId);
			if (advisor != null) {
				IncomeDTO incomeDTO = new IncomeDTO();

				incomeDTO.setOrderUuid(orderDTO.getUuid());
				incomeDTO.setLoginId(advisor.getLoginId());
				incomeDTO.setRate(Constants.ADVISOR_RATE);
				incomeDTO.setAmount(orderDTO.getAmount().multiply(
						Constants.ADVISOR_RATE));
				userService.addIncome(incomeDTO);
			}
			if (customer != null) {
				IncomeDTO incomeDTO = new IncomeDTO();

				incomeDTO.setOrderUuid(orderDTO.getUuid());
				incomeDTO.setLoginId(customer.getLoginId());
				incomeDTO.setRate(Constants.CUSTOMER_RATE);
				incomeDTO.setAmount(orderDTO.getAmount().multiply(
						Constants.CUSTOMER_RATE));
				userService.addIncome(incomeDTO);
			}
			if (internalUser != null) {
				IncomeDTO incomeDTO = new IncomeDTO();

				incomeDTO.setOrderUuid(orderDTO.getUuid());
				incomeDTO.setLoginId(internalUser.getLoginId());
				incomeDTO.setRate(Constants.INTERNAL_RATE);
				incomeDTO.setAmount(orderDTO.getAmount().multiply(
						Constants.INTERNAL_RATE));
				userService.addIncome(incomeDTO);
			}
		} catch (BusinessException e) {
			logger.error("update order status failure:" + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_upload_image", method = RequestMethod.POST)
	public String uploadImage(HttpServletRequest request,
			@RequestParam("image") MultipartFile image, ModelMap model) {

		String id = request.getParameter("id");
		String viewName = "image-list";
		OutputStream os = null;
		File imageFolder = new File("c:\\project\\main-image\\");
		File imageFile = new File("c:\\project\\main-image\\image" + id
				+ ".png");
		try {
			if (!imageFolder.exists())
				imageFolder.mkdirs();

			if (!imageFile.exists())
				imageFile.createNewFile();
			os = new FileOutputStream(imageFile);
			os.write(image.getBytes());
			os.flush();
		} catch (IOException e1) {
			logger.error("upload image error: " + e1.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				logger.error("upload image error: " + e.getMessage());
			}
		}

		return viewName;
	}
	
	@RequestMapping(value = "/admin_article_image_create_submit", method = RequestMethod.POST)
	public String uploadArticleImage(HttpServletRequest request,
			@RequestParam("image") MultipartFile image, ModelMap model) {
		String viewName = "article-image-list";
		OutputStream os = null;
		File imageFolder = new File("c:\\project\\article-image\\");
		File imageFile = new File("c:\\project\\article-image\\" + image.getOriginalFilename());
		try {
			if (!imageFolder.exists())
				imageFolder.mkdirs();

			if (!imageFile.exists())
				imageFile.createNewFile();
			os = new FileOutputStream(imageFile);
			os.write(image.getBytes());
			os.flush();
		} catch (IOException e1) {
			logger.error("upload image error: " + e1.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				logger.error("upload image error: " + e.getMessage());
			}
		}

		return viewName;
	}
	
	@RequestMapping(value = "/admin_article_image_delete", method = RequestMethod.POST)
	public String deleteArticleImage(HttpServletRequest request, ModelMap model) throws IOException {
		String fileName = request.getParameter("fileName");
		String viewName = "article-image-list";
		File imageFile = new File("c:\\project\\article-image\\" + fileName);
		if (imageFile.exists())
			imageFile.delete();

		return viewName;
	}

	@RequestMapping(value = "/admin_article_modify_submit", method = RequestMethod.POST)
	public String modifyArticleSubmit(HttpServletRequest request, ModelMap model) {

		String uuid = request.getParameter("uuid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		String isRecommended = request.getParameter("isRecommended");
		String viewName = "article-list";

		try {
			NewsArticleMessageDTO dto = new NewsArticleMessageDTO();
			dto.setId(uuid);
			dto.setContent(content);
			dto.setTitle(title);
			dto.setType(type);
			if (isRecommended == null)
				dto.setIsRecommended("0");
			else
				dto.setIsRecommended("1");
			userService.modifyArticle(dto);
		} catch (BusinessException e) {
			logger.error("modify articles error: " + e.getMessage());
		}

		return viewName;
	}

	@RequestMapping(value = "/admin_product_modify_submit", method = RequestMethod.POST)
	public String modifyProductSubmit(
			@RequestParam("image") MultipartFile image,
			HttpServletRequest request, ModelMap model) {

		String uuid = request.getParameter("uuid");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String priceStr = request.getParameter("price");
		String prePriceStr = request.getParameter("prePrice");
		String pointsStr = request.getParameter("points");
		String viewName = "product-list";
		ProductDTO dto = new ProductDTO();
		dto.setUuid(uuid);
		dto.setName(name);
		dto.setDescription(description);
		dto.setType(type);
		try{
			BigDecimal price = new BigDecimal(priceStr);
			BigDecimal prePrice = new BigDecimal(prePriceStr);
			dto.setPrice(price);
			dto.setPrePrice(prePrice);
		}catch(Exception e){
			viewName = "product-create";
			model.addAttribute("message", "价格格式不对");
			return viewName;
		}
		try{
			Integer points = new Integer(pointsStr);
			dto.setPoints(points);
		}catch(Exception e){
			viewName = "product-create";
			model.addAttribute("message", "点位数格式不对");
			return viewName;
		}

		try {
			userService.modifyProduct(dto);
			model.addAttribute("message", "修改产品成功");
		} catch (BusinessException e) {
			logger.error("modify product error: " + e.getMessage());
		}
		if (image.getSize() != 0) {
			OutputStream os = null;
			File imageFolder = null;
			File imageFile = null;
			try {
				imageFolder = new File("c:\\project\\product-image\\");
				imageFile = new File("c:\\project\\product-image\\image" + uuid
						+ ".png");
				if (!imageFolder.exists())
					imageFolder.mkdirs();

				if (!imageFile.exists())
					imageFile.createNewFile();
				os = new FileOutputStream(imageFile);
				os.write(image.getBytes());
				os.flush();
			} catch (IOException e1) {
				logger.error("upload image error: " + e1.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
				} catch (IOException e) {
					logger.error("upload image error: " + e.getMessage());
				}
			}
		}

		return viewName;
	}

	@RequestMapping(value = "/downloadReport", method = RequestMethod.GET)
	public void downloadReport(HttpServletRequest request,
			HttpServletResponse response) {

		String orderNumber = (String) request.getParameter("orderNumber");
		File reportFile = new File("c:\\project\\report\\" + orderNumber + ".pdf");
		response.setContentType("application/pdf");
		// 设置输出长度
		response.setHeader("Content-Length",
				String.valueOf(reportFile.length()));
		// 获取输入流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(reportFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();
			response.flushBuffer();
		} catch (FileNotFoundException e) {
			logger.error("no report found");
		} catch (IOException e) {
		} finally {

			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				logger.error("error occured when close stream");
			}

		}
	}

	@RequestMapping(value = "/downloadMainImage", method = RequestMethod.GET)
	public void downloadMainImage(HttpServletRequest request,
			HttpServletResponse response) {

		String id = (String) request.getParameter("id");
		File imageFile = new File("c:\\project\\main-image\\image" + id
				+ ".png");
		response.setContentType("image/png");
		// 设置输出长度
		response.setHeader("Content-Length", String.valueOf(imageFile.length()));
		// 获取输入流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(imageFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (FileNotFoundException e) {
			logger.error("no report found");
		} catch (IOException e) {
		} finally {

			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				logger.error("error occured when close stream");
			}

		}
	}
	
	@RequestMapping(value = "/downloadArticleImage", method = RequestMethod.GET)
	public void downloadArticleImage(HttpServletRequest request,
			HttpServletResponse response) {

		String name = (String) request.getParameter("name");
		File imageFile = new File("c:\\project\\article-image\\" + name);
		response.setContentType("image/png");
		// 设置输出长度
		response.setHeader("Content-Length", String.valueOf(imageFile.length()));
		// 获取输入流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(imageFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (FileNotFoundException e) {
			logger.error("no article image found");
		} catch (IOException e) {
		} finally {

			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				logger.error("error occured when close stream");
			}

		}
	}

	@RequestMapping(value = "/downloadProductImage", method = RequestMethod.GET)
	public void downloadProductImage(HttpServletRequest request,
			HttpServletResponse response) {

		String id = (String) request.getParameter("id");
		File imageFile = new File("c:\\project\\product-image\\image" + id
				+ ".png");
		response.setContentType("image/png");
		// 设置输出长度
		response.setHeader("Content-Length", String.valueOf(imageFile.length()));
		// 获取输入流
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(imageFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (FileNotFoundException e) {
			logger.error("no report found");
		} catch (IOException e) {
		} finally {

			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				logger.error("error occured when close stream");
			}

		}
	}

}
