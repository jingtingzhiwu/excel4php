package com.focusorder.php.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * TblProductBatchFormInformation entity. @author MyEclipse Persistence Tools
 */

public class TblProductBatchFormInformation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2443319325531603284L;
	private Integer id;
	private Integer form_id;
	private Integer product_id;
	private Timestamp created_time;

	private List<TblProductBatchInformation> data;

	// Constructors

	public List<TblProductBatchInformation> getData() {
		return data;
	}

	public void setData(List<TblProductBatchInformation> data) {
		this.data = data;
	}

	/** default constructor */
	public TblProductBatchFormInformation() {
	}

	/** full constructor */
	public TblProductBatchFormInformation(Integer id, Integer formId, Integer productId, Timestamp createdTime) {
		this.id = id;
		this.form_id = formId;
		this.product_id = productId;
		this.created_time = createdTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getForm_id() {
		return form_id;
	}

	public void setForm_id(Integer form_id) {
		this.form_id = form_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Timestamp getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}

}