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
 * The persistent class for the NEWS database table.
 * 
 */
@Entity
@Table(name = "NEWS")
@NamedQuery(name = "NewsEntity.findAll", query = "SELECT u FROM NewsEntity u")
public class NewsEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "NEWS_UUID")
	@GenericGenerator(name = "NEWS_UUID", strategy = "uuid")
	@Column(name = "NEWS_UUID", nullable = false, length = 100)
	private String newsUuid;

	@Column(name = "TITLE", length = 100)
	private String title;

	@Column(name = "CONTENT", length = 10000)
	private String content;


	@Column(name = "STATUS" , length = 1)
	private String status;
	
	@Column(name = "URL" , length = 100)
	private String url;


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getNewsUuid() {
		return newsUuid;
	}


	public void setNewsUuid(String newsUuid) {
		this.newsUuid = newsUuid;
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