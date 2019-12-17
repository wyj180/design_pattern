package com.study.ppt_demo.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xslf.usermodel.XSLFChart;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.ppt_demo.entity.GraphData;
import com.study.ppt_demo.entity.StringKeyVo;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFGraphicFrame;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

/**
 *  * PPT公具类  *   
 */
public class PPTGraphUtils {

    private Logger logger = LoggerFactory.getLogger(PPTGraphUtils.class);

    /**
     * 生成新的ppt
     *
     * @param templateFile  模板ppt全路径
     * @param destFile      生成新在ppt保持全路径
     * @param graphDataList 数据图表数据
     * @return
     */
    public boolean createNewPPT(String templateFile, String destFile, GraphData[] graphDataList) {
        XMLSlideShow pptx = null; // 表示幻灯片，即整个ppt文档
        OutputStream out = null; // 输出流，用户保存修改后的幻灯片
        try {
            // 打开模板ppt
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(templateFile);
            pptx = new XMLSlideShow(inputStream);
            // 更新ppt内容
            updatePPTGraph(pptx, graphDataList);
            // 保存文件到指定目录
            out = new FileOutputStream(destFile);
            pptx.write(out);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建ppt出错", e);
            return false;
        } finally {
            CloseableUtils.close(out, pptx);
        }
        return true;
    }

    /**
     * 更新ppt中图表内容
     *
     * @param pptx
     * @param graphDataList
     * @throws IOException
     */
    public void updatePPTGraph(XMLSlideShow pptx, GraphData[] graphDataList) throws IOException {
        int dataIndex = 0; // 需要更新的ppt数据下标
        // 更新ppt页面内容
        breakHere:
        for (XSLFSlide slide : pptx.getSlides()) { // 一个Slide表示一页ppt
            List<POIXMLDocumentPart> relations = slide.getRelations(); // 获得一个幻灯片中的内容
            int curSlideGraphIndex = 0; // 当前ppt页面图表下标
            for (int i = 0; i < relations.size(); i++) {
                if (dataIndex > (graphDataList.length - 1)) { // 如果ppt图表数据添加完，则删除多余的模板图表
                    deleteSpareTemplate(slide, curSlideGraphIndex); // 删除当前页多余的图表模板
                    deleteSpareSlide(pptx, slide.getSlideNumber() + 1); // 删除剩余的ppt模板页面
                    break breakHere;
                } else {
                    POIXMLDocumentPart part = relations.get(i);
                    if (part instanceof XSLFChart) { // 修改柱状图内容
                        updateGraph((XSLFChart) part, graphDataList[dataIndex++]);
                        curSlideGraphIndex++;
                    }
                }
            }
        }
    }

    /**
     * @param slide
     * @param startIndex 删除图表的开始下标(不包含文本框等下标)
     */
    public void deleteSpareTemplate(XSLFSlide slide, int startIndex) {
        // List<POIXMLDocumentPart> relations = slide.getRelations();
        // List<XSLFShape> shapes = slide.getShapes();
        // 说明：relations数量和shapes数量一一对应，但是图表位置不对应

        List<XSLFShape> shapes = slide.getShapes(); // Shape包括了文本框等内容，图用XSLFGraphicFrame表示
        // 将所有图形放在一个list里
        List<XSLFShape> graphs = new ArrayList<>();
        for (XSLFShape shape : shapes) {
            if ((shape instanceof XSLFGraphicFrame)) {
                graphs.add(shape);
            }
        }
        // 删除多余的模板图表
        for (int i = 0; i < graphs.size(); i++) {
            if (i >= startIndex) {
                slide.removeShape(graphs.get(i));
            }
        }
    }

    /**
     * 删除多余的ppt模板页面
     *
     * @param pptx
     * @param slideNo
     */
    public void deleteSpareSlide(XMLSlideShow pptx, int slideNo) {
        if (slideNo != 0) {
            int delPages = pptx.getSlides().size() - slideNo + 1;
            while (delPages > 0) {
                pptx.removeSlide(slideNo - 1); // index从0开始
                delPages--;
            }
        }
    }

    // 更新一个柱状图
    public void updateGraph(XSLFChart chart, GraphData graphData) {
        String type = getGraphType(chart);
        if ("bar".equalsIgnoreCase(type)) { // 柱状图
            refreshBarGraph(chart, graphData);
        }
    }

    /**
     * 获得图表类型  
     */
    private String getGraphType(XSLFChart chart) {
        String graphTye = "noSupport";
        CTPlotArea plot = chart.getCTChart().getPlotArea();
        if (null != plot && plot.getBarChartList().size() > 0) { // 柱状图
            graphTye = "bar";
        }
        return graphTye;
    }

    /**
     * 刷新柱状图
     */
    private boolean refreshBarGraph(XSLFChart sourceChart, GraphData graphData) {
        Workbook wb = null;
        OutputStream xlsOut = null;
        try {
            // 把图表绑定到Excel workbook中，并编辑数据
            // 创建excel
            wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();

            // 获得柱状图
            CTChart ctChart = sourceChart.getCTChart();
            CTPlotArea plotArea = ctChart.getPlotArea();
            CTBarChart chart = plotArea.getBarChartArray(0);

            // 获取图表的列
            CTBarSer ser = chart.getSerArray(0);

            // Series Text
            CTSerTx tx = ser.getTx();
            tx.getStrRef().getStrCache().getPtArray(0).setV(graphData.getTitle()); // 设置标题
            sheet.createRow(0).createCell(1).setCellValue(graphData.getTitle()); // 设置标题
            String titleRef = new CellReference(sheet.getSheetName(), 0, 1, true, true).formatAsString();
            tx.getStrRef().setF(titleRef); // 设置图表标题

            // Category Axis Data
            CTAxDataSource cat = ser.getCat();
            // 获取图表的值
            CTNumDataSource val = ser.getVal();
            refreshGraphContent(sheet, cat, val, graphData);

            // 更新嵌入的workbook(即更新这个柱状图)
            POIXMLDocumentPart xlsPart = sourceChart.getRelations().get(0);
            xlsOut = xlsPart.getPackagePart().getOutputStream();
            wb.write(xlsOut);
            xlsOut.flush();
        } catch (Exception e) {
            logger.error("更新ppt柱状图出错", e);
            return false;
        } finally {
            CloseableUtils.close(xlsOut, wb);
        }

        return true;
    }

    /**
     * 刷新图表内容
     *
     * @param sheet     表示图表对应的excel数据
     * @param cat       表示x轴的每个数据
     * @param val       表示y轴的每个数据
     * @param graphData 需要添加的数据
     */
    private void refreshGraphContent(Sheet sheet, CTAxDataSource cat, CTNumDataSource val, GraphData graphData) {
        CTStrData strData = cat.getStrRef().getStrCache(); // 原图表所有列名称
        CTNumData numData = val.getNumRef().getNumCache(); // 原图表所有列值
        // 设置原图表名称和值为null
        strData.setPtArray((CTStrVal[]) null); // unset old axis text
        numData.setPtArray((CTNumVal[]) null); // unset old values

        // set model
        long idx = 0;
        int rownum = 1;
        for (StringKeyVo seriesData : graphData.getSerList()) { // 将数据设置到图表中
            // 设置指定列数据值
            CTNumVal numVal = numData.addNewPt();
            numVal.setIdx(idx);
            numVal.setV(seriesData.getValue() + "");
            // 设置指定列名称
            CTStrVal sVal = strData.addNewPt();
            sVal.setIdx(idx);
            sVal.setV(seriesData.getName());

            idx++;
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(seriesData.getName()); // excel第一列数据，对应柱状图的name
            row.createCell(1).setCellValue(seriesData.getValue()); // excel第二列数据，对应柱状图的value
        }
        // 设置柱状图列数量
        numData.getPtCount().setVal(idx);
        strData.getPtCount().setVal(idx);

        // 设置单元格区域范围
        // (1, rownum - 1, 1, 1) 中前两位表示第二行到第rownum行; 后两个1表示第二列
        String numDataRange = new CellRangeAddress(1, rownum - 1, 1, 1).formatAsString(sheet.getSheetName(), true);
        val.getNumRef().setF(numDataRange);
        String axisDataRange = new CellRangeAddress(1, rownum - 1, 0, 0).formatAsString(sheet.getSheetName(), true);
        cat.getStrRef().setF(axisDataRange);
    }

    /**
     * 封装图表数据，没有值的项添加默认值
     *
     * @return
     */
    public static List<StringKeyVo> getStringKeyList(List<StringKeyVo> serList, String[] judgeKeys, String[] showKeys) {
        List<StringKeyVo> result = new ArrayList<StringKeyVo>();

        for (int i = 0; i < judgeKeys.length; i++) {
            StringKeyVo element = new StringKeyVo(showKeys[0], 0L); // 添加默认值
            for (StringKeyVo serVo : serList) {
                if (judgeKeys[i].equals(serVo.getName())) {
                    element.setValue(serVo.getValue());
                    break;
                }
            }
            result.add(element);
        }

        return result;
    }

}