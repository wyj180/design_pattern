package com.study.ppt_demo.test01;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

/**
 * 使用模板导出ppt，测试设置样式，合并单元格
 *
 */
public class TestCreatePPT5_mergecell {

	public static void main(String[] args) throws Exception {

		// create a new empty slide show
		InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\Report02.pptx");
		XMLSlideShow ppt = new XMLSlideShow(inputStream);

		// add first slide
		
		List<XSLFSlide> slides = ppt.getSlides();

		// 创建表格
		handleFirstSlide(slides.get(2));

		// save changes in a file
		FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test16.ppt");

		ppt.write(out);
		out.close();
		ppt.close();
		System.out.println("运行完毕");
	}

	// 找出slide中的table
	// 操作slide中的table数据，XSLFTable属于XSLFShape的一个子类
	public static void handleFirstSlide(XSLFSlide slide) {
		XSLFTable table = null;
		List<XSLFShape> shapes = slide.getShapes();
		List<XSLFTextBox> textBoxList = new ArrayList<>();
		for (XSLFShape part : shapes) {
			if (part instanceof XSLFTable) {
				table = (XSLFTable) part;
				// 设置数据
				setDataToTable(table);
			}
			if (part instanceof XSLFTextBox) {
				XSLFTextBox textBox = (XSLFTextBox) part;
				textBoxList.add(textBox);
			}
		}
		
		// 合并单元格
		table.mergeCells(7, 9, 2, 2);
	}

	/**
	 * 修改table中的值，成功
	 */
	public static void setDataToTable(XSLFTable table) {
		// 插入数据
		Object[][] datas = { { "station_value1", "defect_value1", "Analysis1 & Actions1" },
				{ "station_value2", "defect_value2", "Analysis1 & Actions2" },
				{ "station_value3", "defect_value3", "Analysis1 & Actions3" } };

		for (int i = 0; i < datas.length; i++) {
			XSLFTableRow tableRow = table.addRow(); // 创建表格行
			for (int j = 0; j < datas[i].length; j++) {
				XSLFTableCell tableCell = tableRow.addCell();// 创建表格单元格
				XSLFTextParagraph p = tableCell.addNewTextParagraph();
				XSLFTextRun tr = p.addNewTextRun();
				tr.setText(String.valueOf(datas[i][j]));
				
				// 设置单元格样式
				tableCell.setBorderColor(BorderEdge.left, new Color(0));
				tableCell.setBorderColor(BorderEdge.right, new Color(0));
				tableCell.setBorderColor(BorderEdge.bottom, new Color(0));
				tableCell.setBorderColor(BorderEdge.top, new Color(0));

				/** 设置单元格边框宽度 **/
				tableCell.setBorderWidth(BorderEdge.left, 1);
				tableCell.setBorderWidth(BorderEdge.right, 1);
				tableCell.setBorderWidth(BorderEdge.bottom, 1);
				tableCell.setBorderWidth(BorderEdge.top, 1);
			}
		}
	}

}
