package com.study.ppt_demo.test01;


import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
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
public class TestCreatePPT11 {

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
        InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\SQM_template\\newTemplate\\onePage_template_new.pptx");
        //InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test28.ppt");
        XMLSlideShow ppt = new XMLSlideShow(inputStream);

        // 根据两个模板创建多页ppt
        String templateFile = createNewSlideByTemplate(ppt);

        InputStream templateInputStream = new FileInputStream(templateFile);
        XMLSlideShow templatePpt = new XMLSlideShow(templateInputStream);

        // add first slide
        List<XSLFSlide> slides = templatePpt.getSlides();

        // 处理ppt中的数据
        handleSlide(slides.get(0));

        // 处理ppt中的数据
        handleSlide(slides.get(2));

        // save changes in a file
        FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test38.ppt");

        templatePpt.write(out);
        out.flush();
        //        out.close();

//        ppt.close();
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

        setSlideTextboxValue(textBoxList, baseInfo, slide);
    }

    private static void setSlideTextboxValue(List<XSLFTextBox> textBoxList, Map<String, Object> baseInfo, XSLFSlide slide) {
        for (XSLFTextBox textBox : textBoxList) {
            String text = textBox.getText();
            if (!text.startsWith("${")) {
                continue;
            }

            XSLFTextBox textBox1 = slide.createTextBox();

            if (text.equals(VAR_PRODUCT)) {
                textBox1.appendText("testValue", false);
                textBox1.setAnchor(textBox.getAnchor());
                slide.removeShape(textBox);
            } else if (text.equals(VAR_SUPPLIER)) {
                textBox1.appendText(SUPPLIER_PREFIX + "supplier_v", false);
            } else if (text.equals(VAR_SOURCE)) {
                textBox.setText(SOURCE_PREFIX + baseInfo.get("source"));
                textBox.setTextAutofit(TextShape.TextAutofit.SHAPE);
            } else if (text.equals(VAR_INHOUSE)) {
                textBox1.appendText(INHOUSE_PREFIX + baseInfo.get("inhouse"), false);
            } else if (text.equals(VAR_CATEGORY)) {
                textBox1.appendText(CATEGORY_PREFIX + baseInfo.get("category"), false);
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
    private static String createNewSlideByTemplate(XMLSlideShow ppt) {
        try {
            XSLFSlide slide1 = ppt.getSlides().get(0);
            XSLFSlide slide2 = ppt.getSlides().get(1);

            System.out.println("ppt页数：" + ppt.getSlides().size());
            // blank slide
            copySlide(slide1, ppt);
            copySlide(slide2, ppt);

            copySlide(slide1, ppt);
            copySlide(slide2, ppt);
            copySlide(slide1, ppt);
            copySlide(slide2, ppt);
            copySlide(slide1, ppt);
            copySlide(slide2, ppt);

            System.out.println("ppt页数：" + ppt.getSlides().size());

            File tempFile = new File("D:\\testDir\\PPT\\1_onepage\\onepage_test35.ppt");
            FileOutputStream out = new FileOutputStream(tempFile);
            ppt.write(out);
            out.close();

            return tempFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void copySlide(XSLFSlide slide, XMLSlideShow ppt) {
        XSLFSlide s1 = ppt.createSlide(slide.getSlideLayout());
        s1.importContent(slide);
    }

//    private static XSLFSlide copySlide(XSLFSlide template, XMLSlideShow ppt) throws IOException {
//        XSLFSlide newSlide = ppt.createSlide(template.getSlideLayout());
//        List<XSLFShape> shapes = slide.getSlideShow().getSlides().get(0).getShapes();
//        for (XSLFShape shape : shapes) {
//            newSlide.addShape(shape);
//        }
//        return newSlide;
//    }

//    private static Slide copySlide(Slide slide) {
//        Slide s1 = slide.getSlideShow().createSlide();
//        Shape[] shapes = slide.getShapes();
//        for (Shape shape : shapes) {
//            s1.addShape(shape);
//        }
//        return s1;
//    }

}
