package com.mb.ext.core.service.spec;

import java.util.ArrayList;
import java.util.List;

import com.mb.framework.service.spec.AbstractBaseDTO;

public class SummaryDTO extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<NewsArticleMessageDTO> articleList1= new ArrayList<NewsArticleMessageDTO>();
	List<NewsArticleMessageDTO> articleList2= new ArrayList<NewsArticleMessageDTO>();
	List<NewsArticleMessageDTO> articleList3= new ArrayList<NewsArticleMessageDTO>();
	List<NewsArticleMessageDTO> articleList5= new ArrayList<NewsArticleMessageDTO>();
	public List<NewsArticleMessageDTO> getArticleList1() {
		return articleList1;
	}
	public void setArticleList1(List<NewsArticleMessageDTO> articleList1) {
		this.articleList1 = articleList1;
	}
	public List<NewsArticleMessageDTO> getArticleList2() {
		return articleList2;
	}
	public void setArticleList2(List<NewsArticleMessageDTO> articleList2) {
		this.articleList2 = articleList2;
	}
	public List<NewsArticleMessageDTO> getArticleList3() {
		return articleList3;
	}
	public void setArticleList3(List<NewsArticleMessageDTO> articleList3) {
		this.articleList3 = articleList3;
	}
	public List<NewsArticleMessageDTO> getArticleList4() {
		return articleList4;
	}
	public void setArticleList4(List<NewsArticleMessageDTO> articleList4) {
		this.articleList4 = articleList4;
	}
	public List<ProductDTO> getfProductList() {
		return fProductList;
	}
	public void setfProductList(List<ProductDTO> fProductList) {
		this.fProductList = fProductList;
	}
	public List<ProductDTO> getaProductList() {
		return aProductList;
	}
	public void setaProductList(List<ProductDTO> aProductList) {
		this.aProductList = aProductList;
	}
	public List<ProductDTO> getoProductList() {
		return oProductList;
	}
	public List<ProductDTO> getcProductList() {
		return cProductList;
	}
	public void setcProductList(List<ProductDTO> cProductList) {
		this.cProductList = cProductList;
	}
	public void setoProductList(List<ProductDTO> oProductList) {
		this.oProductList = oProductList;
	}
	public List<NewsArticleMessageDTO> getArticleList5() {
		return articleList5;
	}
	public void setArticleList5(List<NewsArticleMessageDTO> articleList5) {
		this.articleList5 = articleList5;
	}
	List<NewsArticleMessageDTO> articleList4= new ArrayList<NewsArticleMessageDTO>();
	List<ProductDTO> fProductList= new ArrayList<ProductDTO>();
	List<ProductDTO> aProductList= new ArrayList<ProductDTO>();
	List<ProductDTO> oProductList= new ArrayList<ProductDTO>();
	List<ProductDTO> cProductList= new ArrayList<ProductDTO>();
}
