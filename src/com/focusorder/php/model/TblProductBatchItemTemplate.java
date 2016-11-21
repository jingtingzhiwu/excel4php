package com.focusorder.php.model;

import java.sql.Timestamp;

/**
 * TblProductBatchItemTemplate entity. @author MyEclipse Persistence Tools
 */

public class TblProductBatchItemTemplate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4681503339444932161L;
	private Integer id;
	private Integer template_id;
	private Integer no;
	private String cn_name;
	private String en_name;
	private String title;
	private String data_type_code;
	private String form_type_code;
	private Integer length;
	private Integer precision;
	private String default_value;
	private Integer enabled;
	private Integer creator_id;
	private Timestamp created_time;
	private Timestamp modified_time;
	private Short filling_type;
	private Short value_requlation;

	// Constructors

	/** default constructor */
	public TblProductBatchItemTemplate() {
	}

	/** minimal constructor */
	public TblProductBatchItemTemplate(Integer id, Integer templateId, Integer no, String cnName, String title, String dataTypeCode, String formTypeCode, Integer enabled, Integer creatorId,
			Timestamp createdTime, Timestamp modifiedTime, Short fillingType) {
		this.id = id;
		this.template_id = templateId;
		this.no = no;
		this.cn_name = cnName;
		this.title = title;
		this.data_type_code = dataTypeCode;
		this.form_type_code = formTypeCode;
		this.enabled = enabled;
		this.creator_id = creatorId;
		this.created_time = createdTime;
		this.modified_time = modifiedTime;
		this.filling_type = fillingType;
	}

	/** full constructor */
	public TblProductBatchItemTemplate(Integer id, Integer templateId, Integer no, String cnName, String enName, String title, String dataTypeCode, String formTypeCode, Integer length,
			Integer precision, String defaultValue, Integer enabled, Integer creatorId, Timestamp createdTime, Timestamp modifiedTime, Short fillingType, Short valueRequlation) {
		this.id = id;
		this.template_id = templateId;
		this.no = no;
		this.cn_name = cnName;
		this.en_name = enName;
		this.title = title;
		this.data_type_code = dataTypeCode;
		this.form_type_code = formTypeCode;
		this.length = length;
		this.precision = precision;
		this.default_value = defaultValue;
		this.enabled = enabled;
		this.creator_id = creatorId;
		this.created_time = createdTime;
		this.modified_time = modifiedTime;
		this.filling_type = fillingType;
		this.value_requlation = valueRequlation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getCn_name() {
		return cn_name;
	}

	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}

	public String getEn_name() {
		return en_name;
	}

	public void setEn_name(String en_name) {
		this.en_name = en_name;
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

	public String getForm_type_code() {
		return form_type_code;
	}

	public void setForm_type_code(String form_type_code) {
		this.form_type_code = form_type_code;
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

	public String getDefault_value() {
		return default_value;
	}

	public void setDefault_value(String default_value) {
		this.default_value = default_value;
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

	public Short getFilling_type() {
		return filling_type;
	}

	public void setFilling_type(Short filling_type) {
		this.filling_type = filling_type;
	}

	public Short getValue_requlation() {
		return value_requlation;
	}

	public void setValue_requlation(Short value_requlation) {
		this.value_requlation = value_requlation;
	}

}