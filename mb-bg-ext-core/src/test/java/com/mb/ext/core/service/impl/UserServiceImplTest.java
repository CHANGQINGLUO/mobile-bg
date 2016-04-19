package com.mb.ext.core.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.ext.core.constant.Constants;
import com.mb.ext.core.service.UserService;
import com.mb.ext.core.service.spec.IncomeDTO;
import com.mb.ext.core.service.spec.NewsArticleMessageDTO;
import com.mb.ext.core.service.spec.OrderDTO;
import com.mb.ext.core.service.spec.ProductDTO;
import com.mb.ext.core.service.spec.TransferDTO;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.util.log.LogHelper;


/**
 * 
 * @author SPA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public UserService userService;
	
	/**
	 * 
	 * This method is used for test add Message entity
	 */
	@Test
	public void testRegisterUser()
	{
		try {
			userService.registerUser("mytest1", "123456", "a@bc.com", "1988388383", "jianhui", "advisor","address 1","company 1");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	public void testRegisterUserByAdvisor()
	{
		try {
			userService.registerUserByAdvisor("qiao", "test1", "123456", "a@bc.com", "183737873873", "test1", "customer", "address 1", "company 1");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	public void testRegisterAdvisor()
	{
		try {
			userService.registerUserByAdvisor("company_user_1", "13908172896", "13908172896", "a@bc.com", "183737873873", "test1", "customer", "address 1", "company 1");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testLogin(){
		try {
			boolean result = userService.login("qiao", "123456");
			Assert.assertTrue(result);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	
	@Test
	public void testResetPassword(){
		try {
			String result = userService.resetPassword("qiao");
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	
	@Test
	public void testChangePassword(){
		try {
			boolean result = userService.changePassword("qiao","Sg5gqA","password1");
			Assert.assertTrue(result);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	@Test
	public void testUpdateUserDetail(){
		try {
			String id="qiao";
			String email = "my@my.com";
			String Handphone = "my";
			String name = "my";
			String address = "my";
			String company = "my";
			boolean result = userService.updateUserDetail(id, email, Handphone, name, address, company);
			Assert.assertTrue(result);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	
	@Test
	public void testGetRole(){
		try {
			
			userService.getRole("qiao");
		
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	
	@Test
	public void testGetCustomerList(){
		try {
			
			userService.getCustomerList("qiao");
		
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	@Test
	public void testGetAdvisor(){
		try {
			
			userService.getAdvisor("test");
		
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	@Test
	public void testAddNews(){
		try {
			NewsArticleMessageDTO newsDTO = new NewsArticleMessageDTO();
			newsDTO.setTitle("Title1");
			newsDTO.setContent("Content1");
			userService.addNews(newsDTO);
		
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testAddMessage(){
		try {
			NewsArticleMessageDTO messageDTO = new NewsArticleMessageDTO();
			messageDTO.setContent("Content1");
			userService.addMessage(messageDTO);
		
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testArticle(){
		try {
			NewsArticleMessageDTO articleDTO = new NewsArticleMessageDTO();
			articleDTO.setTitle("Title1");
			articleDTO.setContent("Content1");
			articleDTO.setUrl("url1");
			userService.addArticle(articleDTO);
		
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetNews(){
		try {

			List<NewsArticleMessageDTO> newsList = userService.getNews();
			Assert.assertNotEquals(0, newsList);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetMessages(){
		try {

			List<NewsArticleMessageDTO> messageList = userService.getMessages();
			Assert.assertNotEquals(0, messageList);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetArticles(){
		try {

			List<NewsArticleMessageDTO> newsList = userService.getArticles();
			Assert.assertNotEquals(0, newsList);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetArticlesByType(){
		try {

			List<NewsArticleMessageDTO> newsList = userService.getArticlesByType("1");
			Assert.assertNotEquals(0, newsList);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetArticleByUUID(){
		try {

			NewsArticleMessageDTO entity = userService.getArticleByUUID("8a85cb8452f43a200152f43a24270000");
			Assert.assertNotNull(entity);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	
	@Test
	public void testAddProduct(){
		try {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId("001");
			productDTO.setDescription("一套三");
			productDTO.setName("一套三");
			productDTO.setPrice(new BigDecimal(400));
			productDTO.setType("1");
			userService.addProduct(productDTO);
		
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetProduct(){
		try {
			ProductDTO dto = userService.getProductById("F1");
			Assert.assertNotNull(dto);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	
	@Test
	public void testGetProductsByType(){
		try {
			List<ProductDTO> dtoList = userService.getProductsByType("F");
			Assert.assertNotNull(dtoList);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testAddOrder(){
		try {
			
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setUserUuid("402880e8533fea8701533fef87f10000");
			orderDTO.setProductUuid("39932e0e-e505-11e5-ae62-02004c4f4f50");
			orderDTO.setCount(1);
			orderDTO.setAmount(new BigDecimal(1200));
			orderDTO.setCustomerName("Customer");
			orderDTO.setMailAddress("468");
			orderDTO.setPhone("18428396582");
			orderDTO.setStatus(Constants.ORDER_STATUS_CREATED);
			userService.addOrder(orderDTO);
		
			} catch (Exception e) {
				Assert.fail();
			}
		}
	@Test
	public void testGetOrderByUserAndStatus(){
		try {
			List<OrderDTO> list = userService.getOrderByUserAndStatus("CUSTOMER", Constants.ORDER_STATUS_CREATED);
			Assert.assertNotNull(list);
		} catch (BusinessException e) {
			Assert.fail();
		}
	}
	@Test
	public void testUpdateOrderStatus(){
		try {
			userService.updateOrderStatus("402880e85374c9f1015374ca0b1e0000", Constants.ORDER_STATUS_PAYED);
		} catch (BusinessException e) {
			Assert.fail();
		}
	}
	
/*	@Test
	public void testGetIncome(){
		try {
			BigDecimal income = userService.getIncome("advisor");
		} catch (BusinessException e) {
			Assert.fail();
		}
	}*/
	
	@Test
	public void testAddIncome(){
		try {
			IncomeDTO incomeDTO = new IncomeDTO();
			incomeDTO.setLoginId("customer");
			incomeDTO.setUserUuid("402880e8533fea8701533fef87f10000");
			incomeDTO.setOrderUuid("402880e8537ec9fe01537ef54fa70002");
			incomeDTO.setRate(new BigDecimal(0.3));
			incomeDTO.setAmount(new BigDecimal(300));
			userService.addIncome(incomeDTO);
		} catch (BusinessException e) {
			Assert.fail();
		}
	}
	@Test
	public void testGetTotalIncome(){
		try {
			
			BigDecimal totalIncome = userService.getTotalIncomeByUser("customer");
			Assert.assertNotEquals(new BigDecimal(0), totalIncome);
		} catch (BusinessException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testAddTransfer(){
		try {
			TransferDTO transferDTO = new TransferDTO();
			transferDTO.setToLoginId("customer");
			transferDTO.setAmount(new BigDecimal(3000));
			userService.addTransfer(transferDTO);
		} catch (BusinessException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetTotalAmount(){
		try {
			
			BigDecimal totalIncome = userService.getTotalTransferAmountByUser("customer");
			Assert.assertNotEquals(new BigDecimal(0), totalIncome);
		} catch (BusinessException e) {
			Assert.fail();
		}
	}
}
