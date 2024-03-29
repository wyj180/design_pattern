package com.study.ppt_demo.test01;

import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用模板导出ppt，根据模板页新建页面，修改新页面内容
 */
public class TestCreatePPT6 {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\SQM_template\\onePage_template.pptx");
        XMLSlideShow ppt = new XMLSlideShow(inputStream);

        XSLFSlide slide = ppt.getSlides().get(0);

        // blank slide
        XSLFSlide blankSlide = ppt.createSlide();
        blankSlide.importContent(slide);

        XSLFSlide blankSlide2 = ppt.createSlide();
        blankSlide2.importContent(slide);

        // add first slide
        List<XSLFSlide> slides = ppt.getSlides();

        // 创建表格
        handleFirstSlide(slides.get(2));

        // save changes in a file
        FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test20.ppt");

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
    }

    /**
     * 修改table中的值，成功
     */
    public static void setDataToTable(XSLFTable table) {
        // 插入数据
        Object[][] datas = {{"station_value1", "defect_value1", "Analysis1 & Actions1"},
                {"station_value2", "defect_value2", "Analysis1 & Actions2"},
                {"station_value3", "defect_value3", "Analysis1 & Actions3"}};

        for (int i = 0; i < datas.length; i++) {
            XSLFTableRow tableRow = table.addRow(); // 创建表格行
            for (int j = 0; j < datas[i].length; j++) {
                XSLFTableCell tableCell = tableRow.addCell();// 创建表格单元格
                XSLFTextParagraph p = tableCell.addNewTextParagraph();
                XSLFTextRun tr = p.addNewTextRun();
                tr.setText(String.valueOf(datas[i][j]));
                XSLFHyperlink hyperlink = tr.createHyperlink();
                hyperlink.linkToUrl("http://sqm.test.com/sqm/common/downloadFile?showFileName=Yield_Report_V20190723_0001(33).xlsx");
                hyperlink.setLabel("点机下载文件");

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
