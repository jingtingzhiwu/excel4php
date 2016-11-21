package com.focusorder.php;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.focusorder.php.model.TblProductBatchFormInformation;
import com.focusorder.php.model.TblProductBatchInformation;
import com.focusorder.php.utils.excel.AbstractExcel2007Writer;
import com.focusorder.php.utils.excel.ExcelReaderUtil;

public class ProductBatchWriterImpl extends AbstractExcel2007Writer{

	private static List<TblProductBatchFormInformation> list = null;
	private static final String CHAR_TYPE = "char";
	private static final String UPC_TYPE = "upc_code";
	private static final String PIC_TYPE = "pic";
	private static final String INT_TYPE = "int";
	private static final String DC_TYPE = "dc";
	private static final String DT_TYPE = "dt";
	private static final String BL_TYPE = "bl";
	
	/**
	 * test
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("............................");
		long start = System.currentTimeMillis();
		//构建excel2007写入器
		AbstractExcel2007Writer excel07Writer = new ProductBatchWriterImpl();
		//调用处理方法
		excel07Writer.process("d://test07.xlsx");
		long end = System.currentTimeMillis();
		System.out.println("....................."+(end-start)/1000);
	}
	
	/**
	 * 将数据写入Excel
	 * @param path	完整的路径，D:\\1.xls
	 */
	public static void write07(String path, int index, List<TblProductBatchFormInformation> forms) {
		try {
			long start = System.currentTimeMillis();
			list = forms;
			AbstractExcel2007Writer excel07Writer = new ProductBatchWriterImpl();
			excel07Writer.processOneSheet(path, index);
			long end = System.currentTimeMillis();
			System.out.println("写入Excel表格消耗："+(end-start)/1000 + " 秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/* 
	 * 可根据需求重写此方法，对于单元格的小数或者日期格式，会出现精度问题或者日期格式转化问题，建议使用字符串插入方法
	 * @see com.excel.ver2.AbstractExcel2007Writer#generate()
	 */
	@Override
	public void generate()throws Exception {
        //电子表格开始
        beginSheet();
        
        for (int i = 0; i < list.size(); i++) {
            insertRow(i+3);
			TblProductBatchFormInformation forms = list.get(i);
			List<TblProductBatchInformation> datas = forms.getData();
			for (int j = 0; j < datas.size(); j++) {
				TblProductBatchInformation data = datas.get(j);
				
				if(data.getData_type_code().equalsIgnoreCase(CHAR_TYPE) || data.getData_type_code().equalsIgnoreCase(UPC_TYPE) || data.getData_type_code().equalsIgnoreCase(PIC_TYPE))
					createCell(j, data.getChar_value() == null ? "" : data.getChar_value());
				else if(data.getData_type_code().equalsIgnoreCase(INT_TYPE))
					createCell(j, data.getInterger_value() == null ? "" : data.getInterger_value()+"");
				else if(data.getData_type_code().equalsIgnoreCase(DC_TYPE))
					createCell(j, data.getDecimal_value() == null ? "" : data.getDecimal_value()+"");
				else if(data.getData_type_code().equalsIgnoreCase(DT_TYPE))
					createCell(j, data.getDate_value() == null ? "" : new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(data.getDate_value()));
				else if(data.getData_type_code().equalsIgnoreCase(BL_TYPE))
					createCell(j, data.getBoolean_value() == null ? "" : data.getBoolean_value()+"");
				else
					createCell(j, "");
			}
            //结束行
            endRow();
		}
        //电子表格结束
        endSheet();
	}

	@SuppressWarnings("deprecation")
	public static void write03(String fileName, String saveFile, int index, List<TblProductBatchFormInformation> beans) throws Exception{

		// 设置文件放置路径和文件名
	    FileOutputStream fileOut = new FileOutputStream(saveFile);
	    Sheet sheet = null;
	    
			// 创建excel2003对象
		if (fileName.endsWith(ExcelReaderUtil.EXCEL03_EXTENSION)) {
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(fileName));
			sheet = wb.getSheetAt(index);
		    Cell cell = null;

			long start = System.currentTimeMillis();
	        for (int i = 0; i < beans.size(); i++) {
			    Row row = sheet.createRow(i+3);

			    /**
			     * 设置样式
			     */
			    CellStyle style = wb.createCellStyle();
			    Font font = wb.createFont();
			    font.setFontName("Cambria");
			    font.setFontHeightInPoints((short)12);
			    style.setFont(font);
		    	style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				List<TblProductBatchInformation> datas = beans.get(i).getData();
				for (int j = 0; j < datas.size(); j++) {
					cell = row.createCell(j);

				    if(beans.get(i).getId().equals("0") || beans.get(i).getId() == 0)
					    style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
				    else
				    	style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
				    
				    cell.setCellStyle(style);
					
					TblProductBatchInformation data = datas.get(j);
					
					if(data.getData_type_code().equalsIgnoreCase(CHAR_TYPE) || data.getData_type_code().equalsIgnoreCase(UPC_TYPE) || data.getData_type_code().equalsIgnoreCase(PIC_TYPE))
						cell.setCellValue(data.getChar_value() == null ? "" : data.getChar_value());
					else if(data.getData_type_code().equalsIgnoreCase(INT_TYPE))
						cell.setCellValue(data.getInterger_value() == null ? "" : data.getInterger_value()+"");
					else if(data.getData_type_code().equalsIgnoreCase(DC_TYPE))
						cell.setCellValue(data.getDecimal_value() == null ? "" : data.getDecimal_value()+"");
					else if(data.getData_type_code().equalsIgnoreCase(DT_TYPE))
						cell.setCellValue(data.getDate_value() == null ? "" : new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(data.getDate_value()));
					else if(data.getData_type_code().equalsIgnoreCase(BL_TYPE))
						cell.setCellValue(data.getBoolean_value() == null ? "" : data.getBoolean_value()+"");
					else
						cell.setCellValue("");
				}
	        }
			long end = System.currentTimeMillis();
			System.out.println("填充数据耗时："+(end-start)/1000);

			long start1 = System.currentTimeMillis();
		    wb.write(fileOut);
		    long end1 = System.currentTimeMillis();
		    System.out.println("写入文件耗时："+(end1-start1)/1000 + " , " + saveFile);
		    
		} else if(fileName.endsWith(ExcelReaderUtil.EXCEL07_EXTENSION)) {
			XSSFWorkbook wb = new XSSFWorkbook(fileName);
			sheet = wb.getSheetAt(index);
		    Cell cell = null;

			long start = System.currentTimeMillis();
	        for (int i = 0; i < beans.size(); i++) {
			    Row row = sheet.createRow(i+3);

			    /**
			     * 设置样式
			     */
			    CellStyle style = wb.createCellStyle();
			    Font font = wb.createFont();
			    font.setFontName("Cambria");
			    font.setFontHeightInPoints((short)12);
			    style.setFont(font);
		    	style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				List<TblProductBatchInformation> datas = beans.get(i).getData();
				for (int j = 0; j < datas.size(); j++) {
					cell = row.createCell(j);

				    if(beans.get(i).getId().equals("0") || beans.get(i).getId() == 0)
					    style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
				    else
				    	style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
				    
				    cell.setCellStyle(style);
					
					TblProductBatchInformation data = datas.get(j);
					
					if(data.getData_type_code().equalsIgnoreCase(CHAR_TYPE) || data.getData_type_code().equalsIgnoreCase(UPC_TYPE) || data.getData_type_code().equalsIgnoreCase(PIC_TYPE))
						cell.setCellValue(data.getChar_value() == null ? "" : data.getChar_value());
					else if(data.getData_type_code().equalsIgnoreCase(INT_TYPE))
						cell.setCellValue(data.getInterger_value() == null ? "" : data.getInterger_value()+"");
					else if(data.getData_type_code().equalsIgnoreCase(DC_TYPE))
						cell.setCellValue(data.getDecimal_value() == null ? "" : data.getDecimal_value()+"");
					else if(data.getData_type_code().equalsIgnoreCase(DT_TYPE))
						cell.setCellValue(data.getDate_value() == null ? "" : new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(data.getDate_value()));
					else if(data.getData_type_code().equalsIgnoreCase(BL_TYPE))
						cell.setCellValue(data.getBoolean_value() == null ? "" : data.getBoolean_value()+"");
					else
						cell.setCellValue("");
				}
	        }
			long end = System.currentTimeMillis();
			System.out.println("填充数据耗时："+(end-start)/1000);

			long start1 = System.currentTimeMillis();
		    wb.write(fileOut);
		    long end1 = System.currentTimeMillis();
		    System.out.println("写入文件耗时："+(end1-start1)/1000 + " , " + saveFile);
		} else {
		    fileOut.close();
			throw new  Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
		}
	    fileOut.close();
	}
}
