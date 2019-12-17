package com.study.ppt_demo.test01;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.study.ppt_demo.utils.CloseableUtils;
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
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 使用模板导出ppt，测试设置样式
 */
public class SQM_Create_PPT2 {

    private static Logger logger = LoggerFactory.getLogger(SQM_Create_PPT2.class);

    // ppt第一页下标
    private final static int FIRST_SLIDE_INDEX = 0;

    // 本地临时文件目录
    private final static String template_path = "D:/testDir/PPT/1_onepage/";

    // 需要替换的变量前缀
    private final static String PPT_VARIABLE_PREFIX = "${var_";

    @Test
    public void test01() {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        XMLSlideShow ppt = null;
        try {
            // 根据模板获取ppt
            //inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\one_text.pptx");
            inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\Report04.pptx");
            ppt = new XMLSlideShow(inputStream);
            // 获取ppt第一页
            XSLFSlide slide = ppt.getSlides().get(FIRST_SLIDE_INDEX);

            // 处理ppt第一页的数据
            handleFirstSlide(slide);

            // 将文件保存到本地指定位置
            String savefileName = "onepage_test15.ppt";
            outputStream = new FileOutputStream(template_path + savefileName);
            ppt.write(outputStream);
            logger.info("ppt成功导出到本地");
        } catch (Exception e) {
            logger.error("根据ppt模板导出出错", e);
        } finally {
            // 关闭流
            CloseableUtils.close(ppt, outputStream, inputStream);
        }
    }

    // 找出slide中的table
    public void handleFirstSlide(XSLFSlide slide) {
        // 1、获取slide中的所有表格和文本框
        List<XSLFTable> tableList = new ArrayList<>();
        List<XSLFTextBox> textBoxList = new ArrayList<>();

        getTableAndTextbox(slide, tableList, textBoxList);

        // 2、设置表格的值
        for (XSLFTable table : tableList) {
            String shapeName = table.getShapeName();
            CTTable ctTable = table.getCTTable();
            CTTableProperties tblPr = ctTable.getTblPr();
            String nodeValue = tblPr.getDomNode().getNodeValue();
            setDataToTable(table);
        }

        // 3、设置文本框的值
        for (XSLFTextBox textBox : textBoxList) {
            String text = "1、AAA \r\n 2、BBB \r 3、CCC \n 4、DDD";
            textBox.setText(text);
        }
    }

    // 从slide中获取table和textbox
    // XSLFTable和XSLFTextBox属于XSLFShape的一个子类
    private void getTableAndTextbox(XSLFSlide slide, List<XSLFTable> tableList, List<XSLFTextBox> textBoxList) {
        for (XSLFShape part : slide.getShapes()) {
            if (part instanceof XSLFTable) {
                XSLFTable table = (XSLFTable) part;
                tableList.add(table);
            } else if (part instanceof XSLFTextBox) {
                XSLFTextBox textBox = (XSLFTextBox) part;
                if (textBox.getText().startsWith(PPT_VARIABLE_PREFIX)) {
                    textBoxList.add(textBox);
                }
            }
        }
    }

    /**
     * 修改table中的值，成功
     */
    public void setDataToTable(XSLFTable table) {
        // 插入数据
        String[][] datas = {{"station_value1", "defect_value1", "Analysis1 & Actions1"},
                {"station_value2", "defect_value2", "Analysis1 & Actions2"},
                {"station_value3", "defect_value3", "Analysis1 & Actions3"}};

        for (int i = 0; i < datas.length; i++) {
            // 创建表格行
            XSLFTableRow tableRow = table.addRow();
            for (int j = 0; j < datas[i].length; j++) {
                // 创建表格单元格并设置值
                XSLFTableCell tableCell = setCellValue(tableRow, datas[i][j]);
                // 设置边框样式
                setTableCellStyle(tableCell);
            }
        }
    }

    /**
     * 创建单元格并设置值
     *
     * @param tableRow
     * @param cellValue
     * @return
     */
    private XSLFTableCell setCellValue(XSLFTableRow tableRow, String cellValue) {
        // 创建单元格
        XSLFTableCell tableCell = tableRow.addCell();
        XSLFTextParagraph p = tableCell.addNewTextParagraph();
        XSLFTextRun tr = p.addNewTextRun();
        // 设置单元格的值
        tr.setText(cellValue);
        return tableCell;
    }

    /**
     * 设置单元格边框颜色和大小
     *
     * @param tableCell
     */
    private void setTableCellStyle(XSLFTableCell tableCell) {
        // 设置单元格边框颜色
        tableCell.setBorderColor(BorderEdge.left, new Color(0));
        tableCell.setBorderColor(BorderEdge.right, new Color(0));
        tableCell.setBorderColor(BorderEdge.bottom, new Color(0));
        tableCell.setBorderColor(BorderEdge.top, new Color(0));

        // 设置单元格边框大小
        tableCell.setBorderWidth(BorderEdge.left, 1);
        tableCell.setBorderWidth(BorderEdge.right, 1);
        tableCell.setBorderWidth(BorderEdge.bottom, 1);
        tableCell.setBorderWidth(BorderEdge.top, 1);
    }

}
