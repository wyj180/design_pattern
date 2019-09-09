package com.study.ppt_demo.test01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextBox;

/**
 * 使用模板导出ppt，替换table中的值，成功
 *
 */
public class TestCreatePPT3 {

	public static void main(String[] args) throws Exception {

		// create a new empty slide show
		InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\one_text.pptx");
		XMLSlideShow ppt = new XMLSlideShow(inputStream);

		// add first slide
		List<XSLFSlide> slides = ppt.getSlides();

		// 创建表格
		handleFirstSlide(slides.get(0));

		// save changes in a file
		FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test10.ppt");

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
		XSLFTextBox textBox = null;
		for (XSLFShape part : shapes) {
			if (part instanceof XSLFTable) {
				table = (XSLFTable) part;
				// 设置数据
				setDataToTable(table);
			}
			if (part instanceof XSLFTextBox) {
				textBox = (XSLFTextBox) part;
			}
		}
		String text = textBox.getText();
		System.out.println("文本框内容 ： " + text);
		textBox.setText("新的内容AABBCCDDSSDC");
		
	}

	/**
	 * 修改table中的值，成功
	 */
	public static void setDataToTable(XSLFTable table) {
		// 插入数据

		List<XSLFTableRow> rows = table.getRows();

		for (XSLFTableRow row : rows) {
			List<XSLFTableCell> cells = row.getCells();
			for (XSLFTableCell cell : cells) {
				cell.setText("新值");
			}
		}
	}

}
