package com.focusorder.php;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.focusorder.php.model.TblProductBatchFormInformation;
import com.focusorder.php.model.TblProductBatchInformation;
import com.focusorder.php.utils.db.DBUtil;

public class ExportExcel {
	public static void main(String[] args) throws Exception {
		ExportExcel test = new ExportExcel();
		test.batchExport("d://input.xls", "d://final.xls", "10", "5", 3);
	}
	
	
	/**
	 * 导出批量表
	 * 数据库参数，配置
	 * @param templateFile	模版文件
	 * @param saveFile			保存地址
	 * @param formId			
	 * @param templateId
	 * @param index
	 * @return
	 */
	public String batchExport(String templateFile, String saveFile, String formId, String templateId, int index){

		try {
			long start = System.currentTimeMillis();
			Connection con = DBUtil.openConnection();
//			1、拿到Header
//			List<TblProductBatchItemTemplate> temps = DBUtil.queryBeanList(con, "select * from tbl_product_batch_item_template where template_id='"+templateId+"' order by no asc", TblProductBatchItemTemplate.class);
			
//			2、根据formId 查询Product 中间表
//			select * from tbl_product_batch_form_information where form_id=10;
			List<TblProductBatchFormInformation> forms = DBUtil.queryBeanList(con, "select product_id from tbl_product_batch_form_information where form_id='"+formId+"' order by product_id asc", TblProductBatchFormInformation.class);
			
			
			List<TblProductBatchFormInformation> parents = new LinkedList<TblProductBatchFormInformation>();
			List<TblProductBatchFormInformation> subs = new LinkedList<TblProductBatchFormInformation>();
			List<TblProductBatchFormInformation> results = new LinkedList<TblProductBatchFormInformation>();
			for (TblProductBatchFormInformation form : forms) {
//				3、根据ProductId 查询记录值
//				select * from tbl_product_batch_information where product_id='3328' order by no asc
				if(form == null) continue;
				
				//4、取父商品
				List<TblProductBatchInformation> infors = DBUtil.queryBeanList(con, "select product_id,parent_id,title,data_type_code,interger_value,char_value,decimal_value,date_value,boolean_value from tbl_product_batch_information where enabled = 1 and product_id='"+form.getProduct_id()+"' order by product_id, no asc", TblProductBatchInformation.class);
				if(infors.isEmpty()) continue;
				
				//5、取子商品
//				List<TblProductBatchInformation> sub = DBUtil.queryBeanList(con, "select product_id,parent_id,title,data_type_code,interger_value,char_value,decimal_value,date_value,boolean_value from tbl_product_batch_information where enabled = 1 and parent_id = '"+form.getProduct_id()+"' order by product_id, no asc", TblProductBatchInformation.class);
//				if(sub.isEmpty()) continue;
				
				form.setId(infors.get(0).getParent_id());
				form.setData(infors);
				/**
				 * 
				 */
				if(infors.get(0).getParent_id() == 0) parents.add(form);
				else subs.add(form);
				/**
				 * 
				 */
			}
			
			for (TblProductBatchFormInformation parent : parents) {
				results.add(parent);
				for (Iterator<TblProductBatchFormInformation> iterator = subs.iterator(); iterator.hasNext();) {
					TblProductBatchFormInformation sub = iterator.next();
					if(parent.getProduct_id().equals(sub.getId())) {
						results.add(sub);
						iterator.remove();
					}
				}
			}
			
			long end = System.currentTimeMillis();
			System.out.println("查询数据库耗时："+(end-start)/1000);
			ProductBatchWriterImpl.write03(templateFile , saveFile, index, results);
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage() == null || "null".equals(e.getMessage()) ? "0" : e.getMessage();
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "1";
	}
	
	public String singleExport(String templateFile, String saveFile, String formId, String templateId, int index){
		
		try {
			long start = System.currentTimeMillis();
			Connection con = DBUtil.openConnection();
//			1、拿到Header
//			List<TblProductBatchItemTemplate> temps = DBUtil.queryBeanList(con, "select * from tbl_product_batch_item_template where template_id='"+templateId+"' order by no asc", TblProductBatchItemTemplate.class);
			
//			2、根据formId 查询Product 中间表
//			select * from tbl_product_batch_form_information where form_id=10;
			List<TblProductBatchFormInformation> forms = DBUtil.queryBeanList(con, "select product_id from tbl_product_form_information where form_id='"+formId+"' order by product_id asc", TblProductBatchFormInformation.class);
			
			
			List<TblProductBatchFormInformation> parents = new LinkedList<TblProductBatchFormInformation>();
			List<TblProductBatchFormInformation> subs = new LinkedList<TblProductBatchFormInformation>();
			List<TblProductBatchFormInformation> results = new LinkedList<TblProductBatchFormInformation>();
			for (TblProductBatchFormInformation form : forms) {
//				3、根据ProductId 查询记录值
//				select * from tbl_product_batch_information where product_id='3328' order by no asc
				if(form == null) continue;
				
				//4、取父商品
				List<TblProductBatchInformation> infors = DBUtil.queryBeanList(con, "select product_id,parent_id,title,data_type_code,interger_value,char_value,decimal_value,date_value,boolean_value from tbl_product_information where enabled = 1 and product_id='"+form.getProduct_id()+"' order by product_id, no asc", TblProductBatchInformation.class);
				if(infors.isEmpty()) continue;
				
				//5、取子商品
//				List<TblProductBatchInformation> sub = DBUtil.queryBeanList(con, "select product_id,parent_id,title,data_type_code,interger_value,char_value,decimal_value,date_value,boolean_value from tbl_product_batch_information where enabled = 1 and parent_id = '"+form.getProduct_id()+"' order by product_id, no asc", TblProductBatchInformation.class);
//				if(sub.isEmpty()) continue;
				
				form.setId(infors.get(0).getParent_id());
				form.setData(infors);
				/**
				 * 
				 */
				if(infors.get(0).getParent_id() == 0) parents.add(form);
				else subs.add(form);
				/**
				 * 
				 */
			}
			
			for (TblProductBatchFormInformation parent : parents) {
				results.add(parent);
				for (Iterator<TblProductBatchFormInformation> iterator = subs.iterator(); iterator.hasNext();) {
					TblProductBatchFormInformation sub = iterator.next();
					if(parent.getProduct_id().equals(sub.getId())) {
						results.add(sub);
						iterator.remove();
					}
				}
			}
			
			long end = System.currentTimeMillis();
			System.out.println("查询数据库耗时："+(end-start)/1000);
			ProductBatchWriterImpl.write03(templateFile , saveFile, index, results);
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage() == null || "null".equals(e.getMessage()) ? "0" : e.getMessage();
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "1";
	}
	
}
