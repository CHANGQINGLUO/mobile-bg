/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.ext.core.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mb.ext.core.constant.Constants;
import com.mb.ext.core.dao.ArticleDAO;
import com.mb.ext.core.dao.GroupDAO;
import com.mb.ext.core.dao.IMessageDAO;
import com.mb.ext.core.dao.IncomeDAO;
import com.mb.ext.core.dao.NewsDAO;
import com.mb.ext.core.dao.OrderDAO;
import com.mb.ext.core.dao.ProductDAO;
import com.mb.ext.core.dao.TransferDAO;
import com.mb.ext.core.dao.UserDAO;
import com.mb.ext.core.dao.UserGroupDAO;
import com.mb.ext.core.dao.UserUserDAO;
import com.mb.ext.core.entity.ArticleEntity;
import com.mb.ext.core.entity.GroupEntity;
import com.mb.ext.core.entity.IMessageEntity;
import com.mb.ext.core.entity.IncomeEntity;
import com.mb.ext.core.entity.NewsEntity;
import com.mb.ext.core.entity.OrderEntity;
import com.mb.ext.core.entity.ProductEntity;
import com.mb.ext.core.entity.TransferEntity;
import com.mb.ext.core.entity.UserEntity;
import com.mb.ext.core.entity.UserGroupEntity;
import com.mb.ext.core.entity.UserUserEntity;
import com.mb.ext.core.service.UserService;
import com.mb.ext.core.service.spec.IncomeDTO;
import com.mb.ext.core.service.spec.NewsArticleMessageDTO;
import com.mb.ext.core.service.spec.OrderDTO;
import com.mb.ext.core.service.spec.ProductDTO;
import com.mb.ext.core.service.spec.TransferDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.core.util.EPMapperUtil;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.exception.DAOException;
import com.mb.framework.service.AbstractService;
import com.mb.framework.util.SecurityUtil;
import com.mb.framework.util.log.LogHelper;

@Service
@Qualifier("ExampleService")
public class UserServiceImpl extends AbstractService implements UserService {
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;

	@Autowired
	@Qualifier("groupDAO")
	private GroupDAO groupDAO;

	@Autowired
	@Qualifier("userUserDAO")
	private UserUserDAO userUserDAO;

	@Autowired
	@Qualifier("userGroupDAO")
	private UserGroupDAO userGroupDAO;

	@Autowired
	@Qualifier("newsDAO")
	private NewsDAO newsDAO;

	@Autowired
	@Qualifier("iMessageDAO")
	private IMessageDAO iMessageDAO;

	@Autowired
	@Qualifier("articleDAO")
	private ArticleDAO articleDAO;

	@Autowired
	@Qualifier("productDAO")
	private ProductDAO productDAO;

	@Autowired
	@Qualifier("orderDAO")
	private OrderDAO orderDAO;

	@Autowired
	@Qualifier("incomeDAO")
	private IncomeDAO incomeDAO;

	@Autowired
	@Qualifier("transferDAO")
	private TransferDAO transferDAO;

	@Autowired
	private EPMapperUtil epMapperUtil;

	private final LogHelper logger = LogHelper.getInstance(this.getClass()
			.getName());

	@Override
	public boolean registerUser(String id, String password, String email,
			String handPhone, String name, String role, String address,
			String company) throws BusinessException {

		UserEntity userEntity = new UserEntity();
		userEntity.setLoginId(id);
		userEntity.setName(name);
		try {
			userEntity.setPassword(SecurityUtil.encryptMd5(password));
		} catch (Exception e1) {
			throw new BusinessException(e1);
		}
		userEntity.setEmail(email);
		userEntity.setContactHm(handPhone);
		userEntity.setAddress(address);
		userEntity.setCompany(company);
		userEntity.setCreateBy(id);
		userEntity.setUpdateBy(id);
		userEntity.setClientCode(RandomStringUtils.randomNumeric(8));
		try {
			userDAO.addUser(userEntity);

			UserEntity pUserEntity = userDAO.getUser(id);

			GroupEntity pGroupEntity = groupDAO.getGroup(role);

			UserGroupEntity userGroupEntity = new UserGroupEntity();
			userGroupEntity.setUser(pUserEntity);
			userGroupEntity.setGroup(pGroupEntity);
			userGroupEntity.setCreateBy(id);
			userGroupEntity.setUpdateBy(id);
			userGroupDAO.addUserGroup(userGroupEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
		return true;
	}

	@Override
	public boolean login(String id, String password) throws BusinessException {
		try {

			UserEntity userEntity = userDAO.getUser(id);
			if (userEntity == null)
				return false;
			else
				return SecurityUtil.encryptMd5(password).equals(
						userEntity.getPassword());

		} catch (DAOException e) {
			throw new BusinessException(e);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getRole(String id) throws BusinessException {
		try {

			UserEntity userEntity = userDAO.getUser(id);
			if (userEntity == null)
				throw new BusinessException();
			else
				return userEntity.getUserGroupEntity().get(0).getGroup()
						.getName();

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<UserDTO> getCustomerList(String id) throws BusinessException {
		try {
			List<UserDTO> customerList = new ArrayList<UserDTO>();
			UserEntity userEntity = userDAO.getUser(id);
			if (userEntity == null)
				throw new BusinessException();
			else {
				for (Iterator<UserUserEntity> iterator = userEntity
						.getCustomerEntityList().iterator(); iterator.hasNext();) {
					UserDTO nUserDTO = new UserDTO();
					UserEntity pUserEntity = iterator.next().getUser();
					nUserDTO.setLoginId(pUserEntity.getLoginId());
					nUserDTO.setName(pUserEntity.getName());
					nUserDTO.setHp(pUserEntity.getContactHm());
					nUserDTO.setEmail(pUserEntity.getEmail());
					nUserDTO.setAddress(pUserEntity.getAddress());
					nUserDTO.setCompany(pUserEntity.getCompany());
					customerList.add(nUserDTO);

				}
			}
			return customerList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public UserDTO getAdvisor(String id) throws BusinessException {
		try {

			UserEntity userEntity = userDAO.getUser(id);
			if (userEntity == null)
				throw new BusinessException("no such user");
			else {
				List<UserUserEntity> userUserEntityList = userEntity
						.getAdvisorEntityList();
				if (userUserEntityList.size() > 0) {
					UserDTO nUserDTO = new UserDTO();
					UserEntity pUserEntity = userUserEntityList.get(0)
							.getBaseUser();
					nUserDTO.setLoginId(pUserEntity.getLoginId());
					nUserDTO.setName(pUserEntity.getName());
					nUserDTO.setHp(pUserEntity.getContactHm());
					nUserDTO.setEmail(pUserEntity.getEmail());
					nUserDTO.setAddress(pUserEntity.getAddress());
					nUserDTO.setCompany(pUserEntity.getCompany());
					return nUserDTO;
				}
				throw new BusinessException("no advisor found");
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public boolean registerUserByAdvisor(String advisor_clientCode, String id,
			String password, String email, String handPhone, String name,
			String role, String address, String company)
			throws BusinessException {

		try {
			if (this.registerUser(id, password, email, handPhone, name, role,
					address, company)) {
				UserEntity advisor = userDAO
						.getUserByClientCode(advisor_clientCode);
				if (advisor != null) {
					UserEntity customer = userDAO.getUser(id);

					UserUserEntity userUserEntity = new UserUserEntity();
					userUserEntity.setBaseUser(advisor);
					userUserEntity.setUser(customer);
					userUserEntity.setCreateBy(id);
					userUserEntity.setUpdateBy(id);
					userUserEntity.setRelType("ATOC");
					userUserDAO.addUserUser(userUserEntity);
				}
				return true;
			} else
				return false;
		} catch (DAOException e) {
			throw new BusinessException(e);
		} catch (BusinessException e) {
			throw e;
		}
	}

	@Override
	public boolean registerAdvisor(String internal_user_id, String advisor_id,
			String password, String email, String handPhone, String name,
			String role, String address, String company)
			throws BusinessException {

		try {
			if (this.registerUser(advisor_id, password, email, handPhone, name,
					role, address, company)) {
				UserEntity internal_user = userDAO.getUser(internal_user_id);
				if (internal_user != null) {
					UserEntity advisor = userDAO.getUser(advisor_id);

					UserUserEntity userUserEntity = new UserUserEntity();
					userUserEntity.setBaseUser(internal_user);
					userUserEntity.setUser(advisor);
					userUserEntity.setCreateBy(internal_user_id);
					userUserEntity.setUpdateBy(internal_user_id);
					userUserEntity.setRelType("ITOA");
					userUserDAO.addUserUser(userUserEntity);
				}
				return true;
			} else
				return false;
		} catch (DAOException e) {
			throw new BusinessException(e);
		} catch (BusinessException e) {
			throw e;
		}
	}

	@Override
	public List<NewsArticleMessageDTO> getNews() throws BusinessException {
		try {
			List<NewsArticleMessageDTO> newsList = new ArrayList<NewsArticleMessageDTO>();
			List<NewsEntity> newsEntityList = newsDAO.getNews();

			for (Iterator<NewsEntity> iterator = newsEntityList.iterator(); iterator
					.hasNext();) {
				NewsArticleMessageDTO newsArticleDTO = new NewsArticleMessageDTO();
				NewsEntity newsEntity = iterator.next();
				newsArticleDTO.setId(newsEntity.getNewsUuid());
				newsArticleDTO.setContent(newsEntity.getContent());
				newsArticleDTO.setTitle(newsEntity.getTitle());
				newsArticleDTO.setUrl(newsEntity.getUrl());
				newsArticleDTO.setCreationDate(new SimpleDateFormat(
						Constants.DATE_FORMAT).format(newsEntity
						.getCreateDate()));
				newsList.add(newsArticleDTO);

			}
			return newsList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<NewsArticleMessageDTO> getArticles() throws BusinessException {
		try {
			List<NewsArticleMessageDTO> articleList = new ArrayList<NewsArticleMessageDTO>();
			List<ArticleEntity> articleEntityList = articleDAO.getArticles();

			for (Iterator<ArticleEntity> iterator = articleEntityList
					.iterator(); iterator.hasNext();) {
				NewsArticleMessageDTO newsArticleDTO = new NewsArticleMessageDTO();
				ArticleEntity articleEntity = iterator.next();
				newsArticleDTO.setId(articleEntity.getArticleUuid());
				newsArticleDTO.setContent(articleEntity.getContent());
				newsArticleDTO.setTitle(articleEntity.getTitle());
				newsArticleDTO.setCreationDate(new SimpleDateFormat(
						Constants.DATE_FORMAT).format(articleEntity
						.getCreateDate()));
				newsArticleDTO.setUrl(articleEntity.getUrl());
				newsArticleDTO.setIsRecommended(articleEntity
						.getIsRecommended());
				articleList.add(newsArticleDTO);

			}
			return articleList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<NewsArticleMessageDTO> getArticlesByType(String type)
			throws BusinessException {
		try {
			List<NewsArticleMessageDTO> articleList = new ArrayList<NewsArticleMessageDTO>();
			List<ArticleEntity> articleEntityList = articleDAO
					.getArticleByType(type);
			if (articleEntityList != null)
				for (Iterator<ArticleEntity> iterator = articleEntityList
						.iterator(); iterator.hasNext();) {
					NewsArticleMessageDTO newsArticleDTO = new NewsArticleMessageDTO();
					ArticleEntity articleEntity = iterator.next();
					newsArticleDTO.setId(articleEntity.getArticleUuid());
					newsArticleDTO.setContent(articleEntity.getContent());
					String title = articleEntity.getTitle();
					if (title != null && title.length() > 16) {
						title = title.substring(0, 15) + "...";
					}
					newsArticleDTO.setTitle(title);
					newsArticleDTO.setCreationDate(new SimpleDateFormat(
							Constants.DATE_FORMAT).format(articleEntity
							.getCreateDate()));
					newsArticleDTO.setUrl(articleEntity.getUrl());
					newsArticleDTO.setIsRecommended(articleEntity
							.getIsRecommended());
					articleList.add(newsArticleDTO);

				}
			return articleList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public NewsArticleMessageDTO getArticleByUUID(String uuid)
			throws BusinessException {
		try {
			NewsArticleMessageDTO newsArticleDTO = new NewsArticleMessageDTO();
			ArticleEntity articleEntity = articleDAO.getArticleByUUID(uuid);
			if (articleEntity != null) {
				newsArticleDTO.setId(articleEntity.getArticleUuid());
				newsArticleDTO.setContent(articleEntity.getContent());
				newsArticleDTO.setTitle(articleEntity.getTitle());
				newsArticleDTO.setCreationDate(new SimpleDateFormat(
						Constants.DATE_FORMAT).format(articleEntity
						.getCreateDate()));
				newsArticleDTO.setUrl(articleEntity.getUrl());
				newsArticleDTO.setType(articleEntity.getType());
				newsArticleDTO.setIsRecommended(articleEntity
						.getIsRecommended());
			}
			return newsArticleDTO;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void addNews(NewsArticleMessageDTO newsDTO) throws BusinessException {
		try {
			NewsEntity newsEntity = new NewsEntity();
			newsEntity.setContent(newsDTO.getContent());
			newsEntity.setTitle(newsDTO.getTitle());
			newsEntity.setStatus("P");
			newsEntity.setUpdateBy("Admin");
			newsEntity.setCreateBy("Admin");
			newsDAO.addNews(newsEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void createArticle(NewsArticleMessageDTO articleDTO)
			throws BusinessException {
		try {
			ArticleEntity articleEntity = new ArticleEntity();
			articleEntity.setContent(articleDTO.getContent());
			articleEntity.setTitle(articleDTO.getTitle());
			articleEntity.setType(articleDTO.getType());
			articleEntity.setIsRecommended(articleDTO.getIsRecommended());
			articleEntity.setStatus("P");
			articleEntity.setUpdateBy("Admin");
			articleEntity.setCreateBy("Admin");
			articleDAO.addArticle(articleEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteArticle(String uuid) throws BusinessException {
		try {

			ArticleEntity articleEntity = articleDAO.getArticleByUUID(uuid);
			articleDAO.deleteArticle(articleEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void modifyArticle(NewsArticleMessageDTO articleDTO)
			throws BusinessException {
		try {

			ArticleEntity articleEntity = articleDAO
					.getArticleByUUID(articleDTO.getId());
			articleEntity.setContent(articleDTO.getContent());
			articleEntity.setTitle(articleDTO.getTitle());
			articleEntity.setType(articleDTO.getType());
			articleEntity.setIsRecommended(articleDTO.getIsRecommended());
			articleDAO.updateArticle(articleEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void addArticle(NewsArticleMessageDTO articleDTO)
			throws BusinessException {
		try {
			ArticleEntity articleEntity = new ArticleEntity();
			articleEntity.setContent(articleDTO.getContent());
			articleEntity.setTitle(articleDTO.getTitle());
			articleEntity.setStatus("P");
			articleEntity.setUrl(articleDTO.getUrl());
			articleEntity.setUpdateBy("Admin");
			articleEntity.setCreateBy("Admin");
			articleDAO.addArticle(articleEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void addMessage(NewsArticleMessageDTO messageDTO)
			throws BusinessException {
		try {
			IMessageEntity messageEntity = new IMessageEntity();
			messageEntity.setContent(messageDTO.getContent());
			messageEntity.setStatus("P");
			messageEntity.setUpdateBy("Admin");
			messageEntity.setCreateBy("Admin");
			iMessageDAO.addMessage(messageEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<NewsArticleMessageDTO> getMessages() throws BusinessException {
		try {
			List<NewsArticleMessageDTO> messageList = new ArrayList<NewsArticleMessageDTO>();
			List<IMessageEntity> messageEntityList = iMessageDAO.getMessages();

			for (Iterator<IMessageEntity> iterator = messageEntityList
					.iterator(); iterator.hasNext();) {
				NewsArticleMessageDTO newsArticleDTO = new NewsArticleMessageDTO();
				IMessageEntity messageEntity = iterator.next();
				newsArticleDTO.setId(messageEntity.getMessageUuid());
				newsArticleDTO.setContent(messageEntity.getContent());
				newsArticleDTO.setCreationDate(new SimpleDateFormat(
						Constants.DATE_FORMAT).format(messageEntity
						.getCreateDate()));
				messageList.add(newsArticleDTO);

			}
			return messageList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public boolean updateUserDetail(String id, String email, String Handphone,
			String name, String address, String company)
			throws BusinessException {
		try {
			UserEntity entity = userDAO.getUser(id);
			if (entity == null) {
				logger.error("user not found");
				return false;
			} else {
				entity.setEmail(email);
				entity.setContactHm(Handphone);
				entity.setName(name);
				entity.setAddress(address);
				entity.setCompany(company);
				userDAO.addUser(entity);
				return true;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public String resetPassword(String id) throws BusinessException {

		try {
			UserEntity entity = userDAO.getUser(id);
			if (entity == null) {
				logger.error("user not found");
				throw new BusinessException("user not found");
			} else {
				String randomPassword = RandomStringUtils.randomAlphanumeric(6);
				entity.setPassword(SecurityUtil.encryptMd5(randomPassword));
				userDAO.addUser(entity);
				return randomPassword;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public boolean changePassword(String id, String oldPassword,
			String newPassword) throws BusinessException {
		try {
			UserEntity entity = userDAO.getUser(id);
			if (entity == null) {
				logger.error("user not found");
				return false;
			} else if (!entity.getPassword().equals(
					SecurityUtil.encryptMd5(oldPassword))) {
				logger.error("old password is incorrect");
				return false;
			} else {
				entity.setPassword(SecurityUtil.encryptMd5(newPassword));
				userDAO.addUser(entity);
				return true;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public UserDTO getUser(String id) throws BusinessException {

		try {

			UserEntity pUserEntity = userDAO.getUser(id);
			if (pUserEntity == null)
				throw new BusinessException("no such user");
			else {
				UserDTO nUserDTO = new UserDTO();
				nUserDTO.setLoginId(pUserEntity.getLoginId());
				nUserDTO.setName(pUserEntity.getName());
				nUserDTO.setHp(pUserEntity.getContactHm());
				nUserDTO.setEmail(pUserEntity.getEmail());
				nUserDTO.setAddress(pUserEntity.getAddress());
				nUserDTO.setCompany(pUserEntity.getCompany());
				nUserDTO.setRole(pUserEntity.getUserGroupEntity().get(0)
						.getGroup().getName());
				nUserDTO.setClientCode(pUserEntity.getClientCode());
				return nUserDTO;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void addProduct(ProductDTO productDTO) throws BusinessException {
		try {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setId(productDTO.getId());
			productEntity.setName(productDTO.getName());
			productEntity.setType(productDTO.getType());
			productEntity.setDescription(productDTO.getDescription());
			productEntity.setPrice(productDTO.getPrice());
			productEntity.setPrePrice(productDTO.getPrePrice());
			productEntity.setPoints(productDTO.getPoints());
			productEntity.setUpdateBy("Admin");
			productEntity.setCreateBy("Admin");
			productDAO.addProduct(productEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<ProductDTO> getProductsByType(String type)
			throws BusinessException {
		try {
			List<ProductDTO> productList = new ArrayList<ProductDTO>();
			List<ProductEntity> productEntityList = productDAO
					.getProductsByType(type);

			for (Iterator<ProductEntity> iterator = productEntityList
					.iterator(); iterator.hasNext();) {
				ProductDTO productDTO = new ProductDTO();
				ProductEntity pProductEntity = iterator.next();
				productDTO.setId(pProductEntity.getId());
				productDTO.setName(pProductEntity.getName());
				productDTO.setDescription(pProductEntity.getDescription());
				productDTO.setPrice(pProductEntity.getPrice());
				productDTO.setPrePrice(pProductEntity.getPrePrice());
				productDTO.setType(pProductEntity.getType());
				productDTO.setPoints(pProductEntity.getPoints());
				productDTO.setUuid(pProductEntity.getProductUuid());
				productDTO.setCreateDate(pProductEntity.getCreateDate());
				productList.add(productDTO);

			}
			return productList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public ProductDTO getProductById(String id) throws BusinessException {
		try {

			ProductEntity pProductEntity = productDAO.getProduct(id);
			if (pProductEntity == null)
				throw new BusinessException("no such product");
			else {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId(pProductEntity.getId());
				productDTO.setName(pProductEntity.getName());
				productDTO.setDescription(pProductEntity.getDescription());
				productDTO.setPrice(pProductEntity.getPrice());
				productDTO.setPrePrice(pProductEntity.getPrePrice());
				productDTO.setType(pProductEntity.getType());
				productDTO.setPoints(pProductEntity.getPoints());
				productDTO.setUuid(pProductEntity.getProductUuid());
				return productDTO;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public ProductDTO getProductByUUID(String uuid) throws BusinessException {
		try {

			ProductEntity pProductEntity = productDAO.getProductByUUID(uuid);
			if (pProductEntity == null)
				throw new BusinessException("no such product");
			else {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId(pProductEntity.getId());
				productDTO.setName(pProductEntity.getName());
				productDTO.setDescription(pProductEntity.getDescription());
				productDTO.setPrice(pProductEntity.getPrice());
				productDTO.setPrePrice(pProductEntity.getPrePrice());
				productDTO.setType(pProductEntity.getType());
				productDTO.setPoints(pProductEntity.getPoints());
				productDTO.setUuid(pProductEntity.getProductUuid());
				return productDTO;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void addOrder(OrderDTO orderDTO) throws BusinessException {
		try {
			OrderEntity orderEntity = new OrderEntity();
			String loginId = orderDTO.getLoginId();
			String productId = orderDTO.getProductId();
			UserEntity userEntity = userDAO.getUser(loginId);
			ProductEntity productEntity = productDAO.getProduct(productId);
			orderEntity.setUser(userEntity);
			orderEntity.setProduct(productEntity);
			orderEntity.setAmount(orderDTO.getAmount());
			orderEntity.setPreAmount(orderDTO.getPreAmount());
			orderEntity.setCount(orderDTO.getCount());
			orderEntity.setCustomerName(orderDTO.getCustomerName());
			orderEntity.setMailAddress(orderDTO.getMailAddress());
			orderEntity.setPhone(orderDTO.getPhone());
			orderEntity.setStatus(orderDTO.getStatus());
			orderEntity.setOrderNumber(orderDTO.getOrderNumber());
			orderEntity.setUpdateBy("Admin");
			orderEntity.setCreateBy("Admin");
			orderDAO.addOrder(orderEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public OrderDTO getOrderById(String uuid) throws BusinessException {
		try {

			OrderEntity pOrderEntity = orderDAO.getOrder(uuid);
			if (pOrderEntity == null)
				throw new BusinessException("no such order");
			else {
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setAmount(pOrderEntity.getAmount());
				orderDTO.setPreAmount(pOrderEntity.getPreAmount());
				orderDTO.setCount(pOrderEntity.getCount());
				orderDTO.setCustomerName(pOrderEntity.getCustomerName());
				orderDTO.setMailAddress(pOrderEntity.getMailAddress());
				orderDTO.setPhone(pOrderEntity.getPhone());
				orderDTO.setStatus(pOrderEntity.getStatus());
				orderDTO.setUuid(pOrderEntity.getOrderUuid());
				orderDTO.setUserUuid(pOrderEntity.getUser().getUserUuid());
				orderDTO.setProductUuid(pOrderEntity.getProduct()
						.getProductUuid());
				orderDTO.setProductName(pOrderEntity.getProduct().getName());
				orderDTO.setProductPrice(pOrderEntity.getProduct().getPrice());
				orderDTO.setProductDescription(pOrderEntity.getProduct()
						.getDescription());
				orderDTO.setCreateDate(pOrderEntity.getCreateDate());
				orderDTO.setLoginId(pOrderEntity.getUser().getLoginId());
				orderDTO.setOrderNumber(pOrderEntity.getOrderNumber());
				return orderDTO;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<OrderDTO> getOrderByUserAndStatus(String loginId, String status)
			throws BusinessException {
		try {
			List<OrderDTO> orderList = new ArrayList<OrderDTO>();
			List<OrderEntity> orderEntityList = userDAO.getUser(loginId)
					.getOrderEntityList();

			for (Iterator<OrderEntity> iterator = orderEntityList.iterator(); iterator
					.hasNext();) {
				OrderEntity pOrderEntity = iterator.next();
				if (pOrderEntity.getStatus().equals(status)) {
					OrderDTO orderDTO = new OrderDTO();
					orderDTO.setAmount(pOrderEntity.getAmount());
					orderDTO.setPreAmount(pOrderEntity.getPreAmount());
					orderDTO.setCount(pOrderEntity.getCount());
					orderDTO.setCustomerName(pOrderEntity.getCustomerName());
					orderDTO.setMailAddress(pOrderEntity.getMailAddress());
					orderDTO.setPhone(pOrderEntity.getPhone());
					orderDTO.setStatus(pOrderEntity.getStatus());
					orderDTO.setUuid(pOrderEntity.getOrderUuid());
					orderDTO.setUserUuid(pOrderEntity.getUser().getUserUuid());
					orderDTO.setProductUuid(pOrderEntity.getProduct()
							.getProductUuid());
					orderDTO.setProductName(pOrderEntity.getProduct().getName());
					orderDTO.setProductPrice(pOrderEntity.getProduct()
							.getPrice());
					orderDTO.setProductDescription(pOrderEntity.getProduct()
							.getDescription());
					orderDTO.setCreateDate(pOrderEntity.getCreateDate());
					orderDTO.setOrderNumber(pOrderEntity.getOrderNumber());
					orderList.add(orderDTO);
				}

			}
			return orderList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<OrderDTO> getOrderByUser(String loginId)
			throws BusinessException {
		try {
			List<OrderDTO> orderList = new ArrayList<OrderDTO>();
			List<OrderEntity> orderEntityList = userDAO.getUser(loginId)
					.getOrderEntityList();

			for (Iterator<OrderEntity> iterator = orderEntityList.iterator(); iterator
					.hasNext();) {
				OrderEntity pOrderEntity = iterator.next();
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setAmount(pOrderEntity.getAmount());
				orderDTO.setPreAmount(pOrderEntity.getPreAmount());
				orderDTO.setCount(pOrderEntity.getCount());
				orderDTO.setCustomerName(pOrderEntity.getCustomerName());
				orderDTO.setMailAddress(pOrderEntity.getMailAddress());
				orderDTO.setPhone(pOrderEntity.getPhone());
				orderDTO.setStatus(pOrderEntity.getStatus());
				orderDTO.setUuid(pOrderEntity.getOrderUuid());
				orderDTO.setUserUuid(pOrderEntity.getUser().getUserUuid());
				orderDTO.setProductUuid(pOrderEntity.getProduct()
						.getProductUuid());
				orderDTO.setProductName(pOrderEntity.getProduct().getName());
				orderDTO.setProductPrice(pOrderEntity.getProduct().getPrice());
				orderDTO.setProductDescription(pOrderEntity.getProduct()
						.getDescription());
				orderDTO.setCreateDate(pOrderEntity.getCreateDate());
				orderDTO.setOrderNumber(pOrderEntity.getOrderNumber());
				orderList.add(orderDTO);

			}
			return orderList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void updateOrderStatus(String orderNumber, String status)
			throws BusinessException {
		try {
			OrderEntity orderEntity = orderDAO.getOrderByNumber(orderNumber);
			if (orderEntity != null) {
				orderEntity.setStatus(status);
			}
			orderDAO.updateOrder(orderEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	/*
	 * @Override public BigDecimal getIncome(String advisorId) throws
	 * BusinessException { BigDecimal income = new BigDecimal(0); List<UserDTO>
	 * customerList = getCustomerList(advisorId); for (Iterator<UserDTO>
	 * iterator = customerList.iterator(); iterator .hasNext();) {
	 * 
	 * UserDTO userDTO = (UserDTO) iterator.next(); String customerId =
	 * userDTO.getLoginId(); List<OrderDTO> orderList =
	 * getOrderByUser(customerId); for (Iterator<OrderDTO> iterator2 =
	 * orderList.iterator(); iterator2 .hasNext();) { OrderDTO orderDTO =
	 * (OrderDTO) iterator2.next(); String status = orderDTO.getStatus();
	 * BigDecimal amount = orderDTO.getAmount(); if
	 * (Constants.ORDER_STATUS_COMPLETED.equals(status) && amount != null) {
	 * income = income.add(amount); } }
	 * 
	 * } return income; }
	 */

	@Override
	public List<OrderDTO> getOrders() throws BusinessException {
		try {
			List<OrderDTO> orderList = new ArrayList<OrderDTO>();
			List<OrderEntity> orderEntityList = orderDAO.getOrders();

			for (Iterator<OrderEntity> iterator = orderEntityList.iterator(); iterator
					.hasNext();) {
				OrderEntity pOrderEntity = iterator.next();
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setAmount(pOrderEntity.getAmount());
				orderDTO.setPreAmount(pOrderEntity.getPreAmount());
				orderDTO.setCount(pOrderEntity.getCount());
				orderDTO.setCustomerName(pOrderEntity.getCustomerName());
				orderDTO.setMailAddress(pOrderEntity.getMailAddress());
				orderDTO.setPhone(pOrderEntity.getPhone());
				orderDTO.setStatus(pOrderEntity.getStatus());
				orderDTO.setUuid(pOrderEntity.getOrderUuid());
				orderDTO.setUserUuid(pOrderEntity.getUser().getUserUuid());
				orderDTO.setProductUuid(pOrderEntity.getProduct()
						.getProductUuid());
				orderDTO.setProductName(pOrderEntity.getProduct().getName());
				orderDTO.setProductPrice(pOrderEntity.getProduct().getPrice());
				orderDTO.setProductDescription(pOrderEntity.getProduct()
						.getDescription());
				orderDTO.setCreateDate(pOrderEntity.getCreateDate());
				orderDTO.setOrderNumber(pOrderEntity.getOrderNumber());
				orderList.add(orderDTO);

			}
			return orderList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<NewsArticleMessageDTO> getRecommendedArticles()
			throws BusinessException {
		try {
			List<NewsArticleMessageDTO> articleList = new ArrayList<NewsArticleMessageDTO>();
			List<ArticleEntity> articleEntityList = articleDAO.getArticles();
			if (articleEntityList != null)
				for (Iterator<ArticleEntity> iterator = articleEntityList
						.iterator(); iterator.hasNext();) {
					ArticleEntity articleEntity = iterator.next();
					if (articleEntity.getIsRecommended().equals("1")) {

						NewsArticleMessageDTO newsArticleDTO = new NewsArticleMessageDTO();
						newsArticleDTO.setId(articleEntity.getArticleUuid());
						newsArticleDTO.setContent(articleEntity.getContent());
						String title = articleEntity.getTitle();
						if (title != null && title.length() > 15) {
							title = title.substring(0, 14) + "...";
						}
						newsArticleDTO.setTitle(title);
						newsArticleDTO.setCreationDate(new SimpleDateFormat(
								Constants.DATE_FORMAT).format(articleEntity
								.getCreateDate()));
						newsArticleDTO.setUrl(articleEntity.getUrl());
						newsArticleDTO.setIsRecommended(articleEntity
								.getIsRecommended());
						articleList.add(newsArticleDTO);
					}

				}
			return articleList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<UserDTO> getProxies() throws BusinessException {

		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		try {
			List<UserGroupEntity> userGroupList = groupDAO.getGroup("advisor")
					.getUserGroupEntity();
			for (Iterator<UserGroupEntity> iterator = userGroupList.iterator(); iterator
					.hasNext();) {
				UserGroupEntity userGroupEntity = (UserGroupEntity) iterator
						.next();
				UserEntity pUserEntity = userGroupEntity.getUser();
				UserDTO nUserDTO = new UserDTO();
				nUserDTO.setLoginId(pUserEntity.getLoginId());
				nUserDTO.setName(pUserEntity.getName());
				nUserDTO.setHp(pUserEntity.getContactHm());
				nUserDTO.setEmail(pUserEntity.getEmail());
				nUserDTO.setAddress(pUserEntity.getAddress());
				nUserDTO.setCompany(pUserEntity.getCompany());
				nUserDTO.setRole("advisor");
				nUserDTO.setClientCode(pUserEntity.getClientCode());
				userDTOList.add(nUserDTO);
			}
			return userDTOList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<UserDTO> getCustomers() throws BusinessException {

		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		try {
			List<UserGroupEntity> userGroupList = groupDAO.getGroup("customer")
					.getUserGroupEntity();
			for (Iterator<UserGroupEntity> iterator = userGroupList.iterator(); iterator
					.hasNext();) {
				UserGroupEntity userGroupEntity = (UserGroupEntity) iterator
						.next();
				UserEntity pUserEntity = userGroupEntity.getUser();
				UserDTO nUserDTO = new UserDTO();
				nUserDTO.setLoginId(pUserEntity.getLoginId());
				nUserDTO.setName(pUserEntity.getName());
				nUserDTO.setHp(pUserEntity.getContactHm());
				nUserDTO.setEmail(pUserEntity.getEmail());
				nUserDTO.setAddress(pUserEntity.getAddress());
				nUserDTO.setCompany(pUserEntity.getCompany());
				nUserDTO.setRole("customer");
				nUserDTO.setClientCode(pUserEntity.getClientCode());
				userDTOList.add(nUserDTO);
			}
			return userDTOList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<OrderDTO> getOrdersByStatus(String status)
			throws BusinessException {
		try {
			List<OrderDTO> orderList = new ArrayList<OrderDTO>();
			List<OrderEntity> orderEntityList = orderDAO.getOrders();

			for (Iterator<OrderEntity> iterator = orderEntityList.iterator(); iterator
					.hasNext();) {
				OrderEntity pOrderEntity = iterator.next();
				if (pOrderEntity.getStatus().equals(status)) {
					OrderDTO orderDTO = new OrderDTO();
					orderDTO.setAmount(pOrderEntity.getAmount());
					orderDTO.setPreAmount(pOrderEntity.getPreAmount());
					orderDTO.setCount(pOrderEntity.getCount());
					orderDTO.setCustomerName(pOrderEntity.getCustomerName());
					orderDTO.setMailAddress(pOrderEntity.getMailAddress());
					orderDTO.setPhone(pOrderEntity.getPhone());
					orderDTO.setStatus(pOrderEntity.getStatus());
					orderDTO.setUuid(pOrderEntity.getOrderUuid());
					orderDTO.setUserUuid(pOrderEntity.getUser().getUserUuid());
					orderDTO.setProductUuid(pOrderEntity.getProduct()
							.getProductUuid());
					orderDTO.setProductName(pOrderEntity.getProduct().getName());
					orderDTO.setProductPrice(pOrderEntity.getProduct()
							.getPrice());
					orderDTO.setProductDescription(pOrderEntity.getProduct()
							.getDescription());
					orderDTO.setOrderNumber(pOrderEntity.getOrderNumber());
					orderList.add(orderDTO);
				}

			}
			return orderList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void addIncome(IncomeDTO incomeDTO) throws BusinessException {
		try {
			IncomeEntity incomeEntity = new IncomeEntity();
			String loginId = incomeDTO.getLoginId();
			String orderUuid = incomeDTO.getOrderUuid();
			UserEntity userEntity = userDAO.getUser(loginId);
			OrderEntity orderEntity = orderDAO.getOrder(orderUuid);
			incomeEntity.setUser(userEntity);
			incomeEntity.setOrder(orderEntity);
			incomeEntity.setAmount(incomeDTO.getAmount());
			incomeEntity.setRate(incomeDTO.getRate());
			incomeEntity.setUpdateBy("Admin");
			incomeEntity.setCreateBy("Admin");
			incomeDAO.addIncome(incomeEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<IncomeDTO> getIncomesByUser(String loginId)
			throws BusinessException {
		try {
			List<IncomeDTO> incomeList = new ArrayList<IncomeDTO>();
			List<IncomeEntity> incomeEntityList = userDAO.getUser(loginId)
					.getIncomeEntityList();

			for (Iterator<IncomeEntity> iterator = incomeEntityList.iterator(); iterator
					.hasNext();) {
				IncomeEntity pIncomeEntity = iterator.next();
				IncomeDTO incomeDTO = new IncomeDTO();
				incomeDTO.setLoginId(loginId);
				incomeDTO.setUserUuid(pIncomeEntity.getUser().getUserUuid());
				incomeDTO.setOrderUuid(pIncomeEntity.getOrder().getOrderUuid());
				incomeDTO.setRate(pIncomeEntity.getRate());
				incomeDTO.setAmount(pIncomeEntity.getAmount());
				incomeDTO.setCreateDate(pIncomeEntity.getCreateDate());
				incomeDTO.setUuid(pIncomeEntity.getIncomeUuid());
				incomeList.add(incomeDTO);

			}
			return incomeList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public BigDecimal getTotalIncomeByUser(String loginId)
			throws BusinessException {
		BigDecimal totalIncome = new BigDecimal(0);
		try {
			List<IncomeDTO> incomeEntityList = getIncomesByUser(loginId);
			for (Iterator<IncomeDTO> iterator = incomeEntityList.iterator(); iterator
					.hasNext();) {
				BigDecimal amount = iterator.next().getAmount();
				totalIncome = totalIncome.add(amount);
			}

		} catch (BusinessException e) {
			throw e;
		}
		return totalIncome;

	}

	@Override
	public List<TransferDTO> getTransfersByUser(String loginId)
			throws BusinessException {
		try {
			List<TransferDTO> transferList = new ArrayList<TransferDTO>();
			List<TransferEntity> transferEntityList = userDAO.getUser(loginId)
					.getToUserEntityList();

			for (Iterator<TransferEntity> iterator = transferEntityList
					.iterator(); iterator.hasNext();) {
				TransferEntity pTransferEntity = iterator.next();
				TransferDTO transferDTO = new TransferDTO();
				transferDTO.setAmount(pTransferEntity.getAmount());
				UserEntity fromUserEntity = pTransferEntity.getFrom_user();
				UserEntity toUserEntity = pTransferEntity.getTo_user();
				if (fromUserEntity != null)
					transferDTO.setFromLoginId(fromUserEntity.getLoginId());
				if (toUserEntity != null)
					transferDTO.setToLoginId(toUserEntity.getLoginId());
				transferDTO.setTransferDate(pTransferEntity.getTransferDate());
				transferDTO.setToName(pTransferEntity.getTo_user().getName());
				transferList.add(transferDTO);

			}
			return transferList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public BigDecimal getTotalTransferAmountByUser(String loginId)
			throws BusinessException {
		BigDecimal totalAmount = new BigDecimal(0);
		try {
			List<TransferDTO> transferEntityList = getTransfersByUser(loginId);
			for (Iterator<TransferDTO> iterator = transferEntityList.iterator(); iterator
					.hasNext();) {
				BigDecimal amount = iterator.next().getAmount();
				totalAmount = totalAmount.add(amount);
			}

		} catch (BusinessException e) {
			throw e;
		}
		return totalAmount;
	}

	@Override
	public void addTransfer(TransferDTO transferDTO) throws BusinessException {
		try {
			TransferEntity transferEntity = new TransferEntity();
			String fromLoginId = transferDTO.getFromLoginId();
			String toLoginId = transferDTO.getToLoginId();
			if (fromLoginId != null) {
				UserEntity fromUserEntity = userDAO.getUser(fromLoginId);
				transferEntity.setFrom_user(fromUserEntity);
			}
			if (toLoginId != null) {
				UserEntity toUserEntity = userDAO.getUser(toLoginId);
				transferEntity.setTo_user(toUserEntity);
			}
			transferEntity.setAmount(transferDTO.getAmount());
			transferEntity.setTransferDate(transferDTO.getTransferDate());
			transferEntity.setUpdateBy("Admin");
			transferEntity.setCreateBy("Admin");
			transferDAO.addTransfer(transferEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<TransferDTO> getTransfers() throws BusinessException {
		try {
			List<TransferDTO> transferList = new ArrayList<TransferDTO>();
			List<TransferEntity> transferEntityList = transferDAO
					.getTransfers();

			for (Iterator<TransferEntity> iterator = transferEntityList
					.iterator(); iterator.hasNext();) {
				TransferEntity pTransferEntity = iterator.next();
				TransferDTO transferDTO = new TransferDTO();
				transferDTO.setAmount(pTransferEntity.getAmount());
				UserEntity fromUserEntity = pTransferEntity.getFrom_user();
				UserEntity toUserEntity = pTransferEntity.getTo_user();
				if (fromUserEntity != null)
					transferDTO.setFromLoginId(fromUserEntity.getLoginId());
				if (toUserEntity != null)
					transferDTO.setToLoginId(toUserEntity.getLoginId());
				transferDTO.setTransferDate(pTransferEntity.getTransferDate());
				transferDTO.setToName(pTransferEntity.getTo_user().getName());
				transferList.add(transferDTO);

			}
			return transferList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public IncomeDTO getIncome(String uuid) throws BusinessException {
		IncomeDTO incomeDTO = new IncomeDTO();
		try {
			IncomeEntity pIncomeEntity = incomeDAO.getIncome(uuid);

			incomeDTO.setLoginId(pIncomeEntity.getUser().getLoginId());
			incomeDTO.setUserUuid(pIncomeEntity.getUser().getUserUuid());
			incomeDTO.setOrderUuid(pIncomeEntity.getOrder().getOrderUuid());
			incomeDTO.setRate(pIncomeEntity.getRate());
			incomeDTO.setAmount(pIncomeEntity.getAmount());
			incomeDTO.setCreateDate(pIncomeEntity.getCreateDate());
			incomeDTO.setUuid(pIncomeEntity.getIncomeUuid());

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
		return incomeDTO;
	}

	@Override
	public List<UserDTO> getInternalUserList() throws BusinessException {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		try {
			List<UserGroupEntity> userGroupList = groupDAO.getGroup("internal")
					.getUserGroupEntity();
			for (Iterator<UserGroupEntity> iterator = userGroupList.iterator(); iterator
					.hasNext();) {
				UserGroupEntity userGroupEntity = (UserGroupEntity) iterator
						.next();
				UserEntity pUserEntity = userGroupEntity.getUser();
				UserDTO nUserDTO = new UserDTO();
				nUserDTO.setLoginId(pUserEntity.getLoginId());
				nUserDTO.setName(pUserEntity.getName());
				nUserDTO.setHp(pUserEntity.getContactHm());
				nUserDTO.setEmail(pUserEntity.getEmail());
				nUserDTO.setAddress(pUserEntity.getAddress());
				nUserDTO.setCompany(pUserEntity.getCompany());
				nUserDTO.setRole("internal");
				nUserDTO.setClientCode(pUserEntity.getClientCode());
				userDTOList.add(nUserDTO);
			}
			return userDTOList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<UserDTO> getAdvisorsByInternalUser(String loginId)
			throws BusinessException {
		try {
			List<UserDTO> customerList = new ArrayList<UserDTO>();
			UserEntity userEntity = userDAO.getUser(loginId);
			if (userEntity == null)
				throw new BusinessException();
			else {
				for (Iterator<UserUserEntity> iterator = userEntity
						.getCustomerEntityList().iterator(); iterator.hasNext();) {
					UserDTO nUserDTO = new UserDTO();
					UserEntity pUserEntity = iterator.next().getUser();
					nUserDTO.setLoginId(pUserEntity.getLoginId());
					nUserDTO.setName(pUserEntity.getName());
					nUserDTO.setHp(pUserEntity.getContactHm());
					nUserDTO.setEmail(pUserEntity.getEmail());
					nUserDTO.setAddress(pUserEntity.getAddress());
					nUserDTO.setCompany(pUserEntity.getCompany());
					customerList.add(nUserDTO);

				}
			}
			return customerList;

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void modifyProduct(ProductDTO productDTO) throws BusinessException {
		try {

			ProductEntity productEntity = productDAO.getProductByUUID(productDTO.getUuid());
			productEntity.setName(productDTO.getName());
			productEntity.setPrice(productDTO.getPrice());
			productEntity.setPrePrice(productDTO.getPrePrice());
			productEntity.setPoints(productDTO.getPoints());
			productEntity.setDescription(productDTO.getDescription());
			productEntity.setType(productDTO.getType());
			productDAO.updateProduct(productEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteProduct(String uuid) throws BusinessException {
		try {

			ProductEntity productEntity = productDAO.getProductByUUID(uuid);
			productDAO.deleteProduct(productEntity);

		} catch (DAOException e) {
			throw new BusinessException(e);
		}
		
	}

	@Override
	public ProductDTO getProductByName(String name) throws BusinessException {
		try {

			ProductEntity pProductEntity = productDAO.getProductByName(name);
			if (pProductEntity == null)
				throw new BusinessException("no such product");
			else {
				ProductDTO productDTO = new ProductDTO();
				productDTO.setId(pProductEntity.getId());
				productDTO.setName(pProductEntity.getName());
				productDTO.setDescription(pProductEntity.getDescription());
				productDTO.setPrice(pProductEntity.getPrice());
				productDTO.setPrePrice(pProductEntity.getPrePrice());
				productDTO.setType(pProductEntity.getType());
				productDTO.setPoints(pProductEntity.getPoints());
				productDTO.setUuid(pProductEntity.getProductUuid());
				return productDTO;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public OrderDTO getOrderByNumber(String orderNumber)
			throws BusinessException {
		try {

			OrderEntity pOrderEntity = orderDAO.getOrderByNumber(orderNumber);
			if (pOrderEntity == null)
				throw new BusinessException("no such order");
			else {
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setAmount(pOrderEntity.getAmount());
				orderDTO.setPreAmount(pOrderEntity.getPreAmount());
				orderDTO.setCount(pOrderEntity.getCount());
				orderDTO.setCustomerName(pOrderEntity.getCustomerName());
				orderDTO.setMailAddress(pOrderEntity.getMailAddress());
				orderDTO.setPhone(pOrderEntity.getPhone());
				orderDTO.setStatus(pOrderEntity.getStatus());
				orderDTO.setUuid(pOrderEntity.getOrderUuid());
				orderDTO.setUserUuid(pOrderEntity.getUser().getUserUuid());
				orderDTO.setProductUuid(pOrderEntity.getProduct()
						.getProductUuid());
				orderDTO.setProductName(pOrderEntity.getProduct().getName());
				orderDTO.setProductPrice(pOrderEntity.getProduct().getPrice());
				orderDTO.setProductDescription(pOrderEntity.getProduct()
						.getDescription());
				orderDTO.setCreateDate(pOrderEntity.getCreateDate());
				orderDTO.setLoginId(pOrderEntity.getUser().getLoginId());
				orderDTO.setOrderNumber(pOrderEntity.getOrderNumber());
				return orderDTO;
			}
		} catch (DAOException e) {
			throw new BusinessException(e);
		}
	}

}
