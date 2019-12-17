package com.study.ppt_demo.test01;


import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.study.ppt_demo.test01.EventOnePageConstant.*;


/**
 * 1_使用两个模板导出ppt，修改textBox的值时出现错误
 * <p>
 * 报错：在处理复制出来的ppt页面中的textBox时，报错
 * Exception in thread "main" org.apache.xmlbeans.impl.values.XmlValueDisconnectedException
 */
public class TestCreatePPT9 {

    static Map<String, Object> baseInfo = new HashMap<>();

    static {
        baseInfo.put(VAR_PRODUCT, "var_product");
        baseInfo.put(VAR_SUPPLIER, "var_supplier");
        baseInfo.put(VAR_SOURCE, "var_source");
        baseInfo.put(VAR_INHOUSE, "var_inhouse");
        baseInfo.put(VAR_CATEGORY, "var_category");
        baseInfo.put(VAR_PE, "var_pe");
        baseInfo.put(VAR_UPDATE_TIME, "var_updateTime");
        baseInfo.put(VAR_OVERALL_STATUS, "var_overallStatus");
    }

    public static void main(String[] args) throws Exception {
        //InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\SQM_template\\newTemplate\\new_report_test.pptx");
        InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test28.ppt");
        XMLSlideShow ppt = new XMLSlideShow(inputStream);

        // 根据两个模板创建多页ppt
        createNewSlideByTemplate(ppt);

        // add first slide
        List<XSLFSlide> slides = ppt.getSlides();

        // 处理ppt中的数据
        handleSlide(slides.get(0));

        // 处理ppt中的数据
        handleSlide(slides.get(4));

        // save changes in a file
        FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test30.ppt");

        ppt.write(out);
        out.close();
        ppt.close();
        System.out.println("运行完毕");
    }

    // 找出slide中的table
    // 操作slide中的table数据，XSLFTable属于XSLFShape的一个子类
    public static void handleSlide(XSLFSlide slide) {
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

        setSlideTextboxValue(textBoxList, baseInfo);
    }

    private static void setSlideTextboxValue(List<XSLFTextBox> textBoxList, Map<String, Object> baseInfo) {
        for (XSLFTextBox textBox : textBoxList) {
            String text = textBox.getText();
            if (text.equals(VAR_PRODUCT)) {
                textBox.setText(PRODUCT_PREFIX + "product_v");
            } else if (text.equals(VAR_SUPPLIER)) {
                textBox.setText(SUPPLIER_PREFIX + "supplier_v");
            } else if (text.equals(VAR_SOURCE)) {
                textBox.setText(SOURCE_PREFIX + baseInfo.get("source"));
            } else if (text.equals(VAR_INHOUSE)) {
                textBox.setText(INHOUSE_PREFIX + baseInfo.get("inhouse"));
            } else if (text.equals(VAR_CATEGORY)) {
                textBox.setText(CATEGORY_PREFIX + baseInfo.get("category"));
            } else if (text.equals(VAR_PE)) {
                textBox.setText(PE_PREFIX + baseInfo.get("pe"));
            } else if (text.equals(VAR_UPDATE_TIME)) {
                textBox.setText(UPDATE_TIME_PREFIX + baseInfo.get("update_time"));
            } else if (text.equals(VAR_OVERALL_STATUS)) {
                textBox.setText(OVERALL_STATUS_PREFIX + baseInfo.get("overall_status"));
            }
        }
    }

    /**
     * 修改table中的值，成功
     */
    public static void setDataToTable(XSLFTable table) {

        // 根据表格第一个单元格的值，来对表格填充不同的内容
        String firstCellValue = table.getCell(0, 0).getText();
        if (!firstCellValue.equals("NUDD")) {
            return;
        }

        // 插入数据
        Object[][] datas = {{"station_value1", "defect_value1", "Analysis1 & Actions1"},
                {"station_value2", "defect_value2", "Analysis1 & Actions2"},
                {"station_value3", "defect_value3", "Analysis1 & Actions3"}};

        for (int i = 0; i < datas.length; i++) {
            XSLFTableRow tableRow = table.addRow(); // 创建表格行
            for (int j = 0; j < datas[i].length; j++) {
                XSLFTableCell tableCell = tableRow.addCell();
                XSLFTextParagraph p = tableCell.addNewTextParagraph();
                XSLFTextRun tr = p.addNewTextRun();
                tr.setText(String.valueOf(datas[i][j]));
                XSLFHyperlink hyperlink = tr.createHyperlink();
                hyperlink.linkToUrl("http://sqm.test.com/sqm/common/downloadFile?showFileName=Yield_Report_V20190723_0001(33).xlsx");
                hyperlink.setLabel("点机下载文件");

                // 设置单元格样式
                setCellStyle(tableCell);
            }
        }

        deleteRow(table);
    }

    /**
     * 删除表格第一行
     *
     * @param table
     */
    private static void deleteRow(XSLFTable table) {
        table.removeRow(0);
    }

    /**
     * 设置单元格样式
     *
     * @param tableCell
     */
    private static void setCellStyle(XSLFTableCell tableCell) {
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

    /**
     * 根据模板创建PPT
     *
     * @param ppt
     */
    private static void createNewSlideByTemplate(XMLSlideShow ppt) {
        XSLFSlide slide1 = ppt.getSlides().get(0);
        XSLFSlide slide2 = ppt.getSlides().get(1);

        // blank slide
        XSLFSlide blankSlide = ppt.createSlide();
        blankSlide.importContent(slide1);

        XSLFSlide blankSlide2 = ppt.createSlide();
        blankSlide2.importContent(slide2);

        // blank slide
        XSLFSlide blankSlide3 = ppt.createSlide();
        blankSlide3.importContent(slide1);

        XSLFSlide blankSlide4 = ppt.createSlide();
        blankSlide4.importContent(slide2);

        // blank slide
        XSLFSlide blankSlide5 = ppt.createSlide();
        blankSlide5.importContent(slide1);

        XSLFSlide blankSlide6 = ppt.createSlide();
        blankSlide6.importContent(slide2);
    }

}
