package com.mb.ext.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

/**
 * The persistent class for the ARTICLE database table.
 * 
 */
@Entity
@Table(name = "ARTICLE")
@NamedQuery(name = "ArticleEntity.findAll", query = "SELECT u FROM ArticleEntity u")
public class ArticleEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ARTICLE_UUID")
	@GenericGenerator(name = "ARTICLE_UUID", strategy = "uuid")
	@Column(name = "ARTICLE_UUID", nullable = false, length = 100)
	private String articleUuid;

	@Column(name = "TITLE", length = 100)
	private String title;

	@Column(name = "CONTENT", length = 10000)
	private String content;
	
	/**1 - Environment Knowledge; 2 - Decoration Knowledge*/
	@Column(name = "TYPE", length = 1)
	private String type;
	
	public String getIsRecommended() {
		return isRecommended;
	}


	public void setIsRecommended(String isRecommended) {
		this.isRecommended = isRecommended;
	}


	@Column(name = "IS_RECOMMENDED", length = 1)
	private String isRecommended;
	

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Column(name = "STATUS" , length = 1)
	private String status;
	
	@Column(name = "URL" , length = 100)
	private String url;




	public String getArticleUuid() {
		return articleUuid;
	}


	public void setArticleUuid(String articleUuid) {
		this.articleUuid = articleUuid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


}