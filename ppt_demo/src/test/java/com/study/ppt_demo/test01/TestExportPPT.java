package com.study.ppt_demo.test01;

import java.awt.Color;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

/**
 * 创建新的ppt和slide页，并插入table数据，成功，这里没有设置table样式
 */
public class TestExportPPT {

    public static void main(String[] args) throws Exception {

        // create a new empty slide show
        XMLSlideShow ppt = new XMLSlideShow();

        // add first slide
        XSLFSlide blankSlide = ppt.createSlide();

        // 创建表格
        createTable(blankSlide);

        // save changes in a file
        FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test01.ppt");

        ppt.write(out);
        out.close();
        System.out.println("运行完毕");
    }

    // 往slide页中添加数据，成功
    public static void createTable(XSLFSlide slide) {
        Object[][] datas = {{"区域", "总销售额(万元)", "总利润(万元)简单的表格"}, {"江苏省", 9045, 2256}, {"广东省", 3000, 690}};
        XSLFTable table = slide.createTable();

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

    // 设置表格样式，TODO
    public static void createTable(XSLFTableCell tableCell, XSLFTextParagraph p) {
        tableCell.setFillColor(Color.getColor("0xdd7e6b"));
        p.setTextAlign(TextAlign.CENTER);
        tableCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
    }

}
