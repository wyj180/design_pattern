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
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;

/**
 * 使用模板导出ppt，往表格中插入数据，成功
 *
 */
public class TestCreatePPT {

	public static void main(String[] args) throws Exception {

		// create a new empty slide show
		InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\Report01.pptx");
		XMLSlideShow ppt = new XMLSlideShow(inputStream);

		// add first slide
		List<XSLFSlide> slides = ppt.getSlides();

		// 创建表格
		handleFirstSlide(slides.get(2));

		// save changes in a file
		FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test05.ppt");

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

				CTTable ctt = table.getCTTable();
				CTTableProperties tp = ctt.getTblPr();
				System.out.println(tp.getTableStyleId());

				// 设置样式
				tp.setFirstRow(true);
				tp.setBandRow(true);
				tp.setTableStyleId(tp.getTableStyleId());
			}
		}
	}

	/**
	 * 往表格中插入数据，注意此时还需要设置单元格的样式
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
			}
		}
	}
	
	

}
