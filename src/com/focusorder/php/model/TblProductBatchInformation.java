package com.focusorder.php.model;

import java.sql.Timestamp;

/**
 * TblProductBatchInformation entity. @author MyEclipse Persistence Tools
 */

public class TblProductBatchInformation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2769165038660646949L;
	private Integer id;
	private Integer category_id;
	private Integer template_id;
	private Integer product_id;
	private Integer parent_id;
	private Integer no;
	private String title;
	private String data_type_code;
	private Integer length;
	private Integer precision;
	private Integer interger_value;
	private String char_value;
	private Double decimal_value;
	private Timestamp date_value;
	private Integer boolean_value;
	private Integer enabled;
	private Integer creator_id;
	private Timestamp created_time;
	private Timestamp modified_time;

	// Constructors

	/** default constructor */
	public TblProductBatchInformation() {
	}

	/** minimal constructor */
	public TblProductBatchInformation(Integer id, Integer categoryId, Integer templateId, Integer productId, Integer parentId, Integer no, String title, String dataTypeCode, Integer length,
			Integer precision, Integer enabled, Integer creatorId, Timestamp createdTime, Timestamp modifiedTime) {
		this.id = id;
		this.category_id = categoryId;
		this.template_id = templateId;
		this.product_id = productId;
		this.parent_id = parentId;
		this.no = no;
		this.title = title;
		this.data_type_code = dataTypeCode;
		this.length = length;
		this.precision = precision;
		this.enabled = enabled;
		this.creator_id = creatorId;
		this.created_time = createdTime;
		this.modified_time = modifiedTime;
	}

	/** full constructor */
	public TblProductBatchInformation(Integer id, Integer categoryId, Integer templateId, Integer productId, Integer parentId, Integer no, String title, String dataTypeCode, Integer length,
			Integer precision, Integer intergerValue, String charValue, Double decimalValue, Timestamp dateValue, Integer booleanValue, Integer enabled, Integer creatorId, Timestamp createdTime,
			Timestamp modifiedTime) {
		this.id = id;
		this.category_id = categoryId;
		this.template_id = templateId;
		this.product_id = productId;
		this.parent_id = parentId;
		this.no = no;
		this.title = title;
		this.data_type_code = dataTypeCode;
		this.length = length;
		this.precision = precision;
		this.interger_value = intergerValue;
		this.char_value = charValue;
		this.decimal_value = decimalValue;
		this.date_value = dateValue;
		this.boolean_value = booleanValue;
		this.enabled = enabled;
		this.creator_id = creatorId;
		this.created_time = createdTime;
		this.modified_time = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getData_type_code() {
		return data_type_code;
	}

	public void setData_type_code(String data_type_code) {
		this.data_type_code = data_type_code;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	public Integer getInterger_value() {
		return interger_value;
	}

	public void setInterger_value(Integer interger_value) {
		this.interger_value = interger_value;
	}

	public String getChar_value() {
		return char_value;
	}

	public void setChar_value(String char_value) {
		this.char_value = char_value;
	}

	public Double getDecimal_value() {
		return decimal_value;
	}

	public void setDecimal_value(Double decimal_value) {
		this.decimal_value = decimal_value;
	}

	public Timestamp getDate_value() {
		return date_value;
	}

	public void setDate_value(Timestamp date_value) {
		this.date_value = date_value;
	}

	public Integer getBoolean_value() {
		return boolean_value;
	}

	public void setBoolean_value(Integer boolean_value) {
		this.boolean_value = boolean_value;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(Integer creator_id) {
		this.creator_id = creator_id;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

	public Timestamp getModified_time() {
		return modified_time;
	}

	public void setModified_time(Timestamp modified_time) {
		this.modified_time = modified_time;
	}

}