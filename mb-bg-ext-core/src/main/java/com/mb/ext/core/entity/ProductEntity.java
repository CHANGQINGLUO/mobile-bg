package com.mb.ext.core.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "PRODUCT")
@NamedQuery(name = "ProductEntity.findAll", query = "SELECT u FROM ProductEntity u")
public class ProductEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(generator = "PRODUCT_UUID")
	@GenericGenerator(name = "PRODUCT_UUID", strategy = "uuid")
	@Column(name = "PRODUCT_UUID", nullable = false, length = 100)
	private String productUuid;

	@Column(name = "NAME", length = 200)
	private String name;

	@Column(name = "TYPE", length = 1)
	private String type;
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Column(name = "POINTS")
	private int points;
	
	public String getProductUuid() {
		return productUuid;
	}

	public void setProductUuid(String productUuid) {
		this.productUuid = productUuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "ID", length = 3)
	private String id;
	
	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
	
	@Column(name = "PRICE", precision=12, scale=2)
	private BigDecimal price;
	
	@Column(name = "PREPRICE", precision=12, scale=2)
	private BigDecimal prePrice;

	public BigDecimal getPrePrice() {
		return prePrice;
	}

	public void setPrePrice(BigDecimal prePrice) {
		this.prePrice = prePrice;
	}

	

	
}