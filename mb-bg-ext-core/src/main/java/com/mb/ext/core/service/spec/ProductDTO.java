package com.mb.ext.core.service.spec;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mb.ext.core.constant.Constants;
import com.mb.framework.service.spec.AbstractBaseDTO;

public class ProductDTO extends AbstractBaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String name;
	private String id;
	private String type;
	private BigDecimal price;
	private BigDecimal prePrice;
	private String description;
	private Date createDate;
	
	public BigDecimal getPrePrice() {
		return prePrice;
	}
	public void setPrePrice(BigDecimal prePrice) {
		this.prePrice = prePrice;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateDateStr(){
		if (getCreateDate() == null)
			return "";
		else
			return new SimpleDateFormat(
				Constants.DATE_FORMAT).format(getCreateDate());
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	private int points;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
