package com.mb.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;


/**
 * The persistent class for the APP_FIELD_DEF database table.
 * 
 */
@Entity
@Table(name="APP_FIELD_DEF")
public class AppFieldDefinitionEntity extends AbstractBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "FIELD_DEF_UUID")
	@GenericGenerator(name = "FIELD_DEF_UUID", strategy = "uuid")
	@Column(name="FIELD_DEF_UUID")
	private String fieldDefUuid;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="DISPLAY_DATA_TYPE")
	private String displayDataType;

	@Column(name="FIELD_TYPE")
	private String fieldType;
	
	@Column(name="FIELD_NAME")
	private String fieldName;

	@Column(name="STORED_DATA_TYPE")
	private String storedDataType;

	public AppFieldDefinitionEntity() {
	}

	public String getFieldDefUuid() {
		return this.fieldDefUuid;
	}

	public void setFieldDefUuid(String fieldDefUuid) {
		this.fieldDefUuid = fieldDefUuid;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayDataType() {
		return this.displayDataType;
	}

	public void setDisplayDataType(String displayDataType) {
		this.displayDataType = displayDataType;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getStoredDataType() {
		return this.storedDataType;
	}

	public void setStoredDataType(String storedDataType) {
		this.storedDataType = storedDataType;
	}

	/**
	 * @return the fieldType
	 */
	public final String getFieldType() {
		return fieldType;
	}

	/**
	 * @param fieldType the fieldType to set
	 */
	public final void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

}