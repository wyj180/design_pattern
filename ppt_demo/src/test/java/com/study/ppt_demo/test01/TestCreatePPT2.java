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

/**
 * 使用模板导出ppt，替换table中的值，成功
 *
 */
public class TestCreatePPT2 {

	public static void main(String[] args) throws Exception {

		// create a new empty slide show
		InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\Report01.pptx");
		XMLSlideShow ppt = new XMLSlideShow(inputStream);

		// add first slide
		List<XSLFSlide> slides = ppt.getSlides();

		// 创建表格
		handleFirstSlide(slides.get(2));

		// save changes in a file
		FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test07.ppt");

		ppt.write(out);
		out.close();
		ppt.close();
		System.out.println("运行完毕");
	}

	// 找出slide中的table
	// 操作slide中的table数据，XSLFTable属于XSLFShape的一个子类
	public static void handleFirstSlide(XSLFSlide slide) {
		XSLFTable table = null;
		for (XSLFShape part : slide.getShapes()) {
			if (part instanceof XSLFTable) {
				table = (XSLFTable) part;
				// 设置数据
				setDataToTable(table);
			}
		}
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
