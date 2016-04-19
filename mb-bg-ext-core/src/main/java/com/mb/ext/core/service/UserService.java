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
package com.mb.ext.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mb.ext.core.service.spec.IncomeDTO;
import com.mb.ext.core.service.spec.NewsArticleMessageDTO;
import com.mb.ext.core.service.spec.OrderDTO;
import com.mb.ext.core.service.spec.ProductDTO;
import com.mb.ext.core.service.spec.TransferDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface UserService
{

	boolean registerUser(String id, String password, String email, String handPhone, String name, String role, String address, String company) throws BusinessException;
	
	boolean registerAdvisor(String internal_user_id, String id, String password, String email, String handPhone, String name, String role, String address, String company) throws BusinessException;
	
	boolean registerUserByAdvisor(String advisor_id, String id, String password, String email, String handPhone, String name, String role, String address, String company) throws BusinessException;
	
	boolean updateUserDetail(String id, String email, String Handphone, String name, String address, String company) throws BusinessException;
	
	boolean login (String id, String password) throws BusinessException;
	
	String resetPassword (String id) throws BusinessException;
	
	boolean changePassword (String id, String oldPassword, String newPassword) throws BusinessException;
	
	String getRole (String id) throws BusinessException;
	
	List<UserDTO> getCustomerList(String id) throws BusinessException;
	
	List<UserDTO> getInternalUserList() throws BusinessException;
	
	List<UserDTO> getAdvisorsByInternalUser(String loginId) throws BusinessException;
	
	UserDTO getAdvisor(String id) throws BusinessException;
	
	List<UserDTO> getProxies() throws BusinessException;
	
	List<UserDTO> getCustomers() throws BusinessException;
	
	UserDTO getUser(String id) throws BusinessException;
	
	void addNews(NewsArticleMessageDTO newsDTO) throws BusinessException;
	
	List<NewsArticleMessageDTO> getNews() throws BusinessException;
	
	void addArticle(NewsArticleMessageDTO articleDTO) throws BusinessException;
	
	void deleteArticle(String id) throws BusinessException;
	
	void createArticle(NewsArticleMessageDTO articleDTO) throws BusinessException;
	
	void modifyArticle(NewsArticleMessageDTO articleDTO) throws BusinessException;
	
	List<NewsArticleMessageDTO> getArticles() throws BusinessException;
	
	List<NewsArticleMessageDTO> getRecommendedArticles() throws BusinessException;
	
	List<NewsArticleMessageDTO> getArticlesByType(String type) throws BusinessException;
	
	NewsArticleMessageDTO getArticleByUUID(String uuid) throws BusinessException;
	
	void addMessage(NewsArticleMessageDTO newsDTO) throws BusinessException;
	
	List<NewsArticleMessageDTO> getMessages() throws BusinessException;
	
	void addProduct(ProductDTO productDTO) throws BusinessException;
	
	void deleteProduct(String uuid) throws BusinessException;
	
	List<ProductDTO> getProductsByType(String type) throws BusinessException;
	
	ProductDTO getProductById(String id) throws BusinessException;
	
	ProductDTO getProductByName(String name) throws BusinessException;
	
	ProductDTO getProductByUUID(String uuid) throws BusinessException;
	
	void modifyProduct(ProductDTO productDTO) throws BusinessException;
	
	void addOrder(OrderDTO orderDTO) throws BusinessException;
	
	void addIncome(IncomeDTO incomeDTO) throws BusinessException;
	
	void addTransfer(TransferDTO transferDTO) throws BusinessException;
	
	OrderDTO getOrderById(String uuid) throws BusinessException;
	
	OrderDTO getOrderByNumber(String orderNumber) throws BusinessException;
	
	List<OrderDTO> getOrderByUserAndStatus(String loginId, String status) throws BusinessException;
	
	List<IncomeDTO> getIncomesByUser(String loginId) throws BusinessException;
	
	IncomeDTO getIncome(String uuid) throws BusinessException;
	
	List<TransferDTO> getTransfersByUser(String loginId) throws BusinessException;
	
	List<TransferDTO> getTransfers() throws BusinessException;
	
	BigDecimal getTotalTransferAmountByUser(String loginId) throws BusinessException;
	
	BigDecimal getTotalIncomeByUser(String loginId) throws BusinessException;
	
	List<OrderDTO> getOrderByUser(String loginId) throws BusinessException;
	
	List<OrderDTO> getOrdersByStatus(String status) throws BusinessException;
	
	List<OrderDTO> getOrders() throws BusinessException;
	
	void updateOrderStatus(String orderNumber, String status) throws BusinessException;
	
//	BigDecimal getIncome(String advisorId) throws BusinessException;
}
