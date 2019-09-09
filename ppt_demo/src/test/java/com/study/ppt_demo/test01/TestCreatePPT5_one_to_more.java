package com.study.ppt_demo.test01;

import org.apache.poi.sl.usermodel.TableCell.BorderEdge;
import org.apache.poi.xslf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * 使用模板导出ppt，copy一页成多页
 */
public class TestCreatePPT5_one_to_more {

    @Test
    public void test01() {
        try {
            InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\SQM_template\\onePage_template.pptx");
            XMLSlideShow ppt = new XMLSlideShow(inputStream);

            XSLFSlide slide = ppt.getSlides().get(0);

            // blank slide
            XSLFSlide blankSlide = ppt.createSlide();
            blankSlide.importContent(slide);

            XSLFSlide blankSlide2 = ppt.createSlide();
            blankSlide2.importContent(slide);

            // save changes in a file
            FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test18.ppt");

            ppt.write(out);
            out.close();
            ppt.close();
            System.out.println("运行完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        // create a new empty slide show
        InputStream inputStream = new FileInputStream("D:\\testDir\\PPT\\1_onepage\\template\\SQM_template\\onePage_template.pptx");
        XMLSlideShow ppt = new XMLSlideShow(inputStream);

        // add first slide

        List<XSLFSlide> slides = ppt.getSlides();

        // 根据第一个Slide创建多的页面
        createSlideByTemplate(ppt, slides.get(0));

        // save changes in a file
        FileOutputStream out = new FileOutputStream("D:\\testDir\\PPT\\1_onepage\\onepage_test17.ppt");

        ppt.write(out);
        out.close();
        ppt.close();
        System.out.println("运行完毕");
    }

    /**
     * 根据ppt模板页创建其他页面
     *
     * @param ppt
     * @param firstSlide
     */
    private static void createSlideByTemplate(XMLSlideShow ppt, XSLFSlide firstSlide) {
        XSLFSlideLayout slideLayout = firstSlide.getSlideLayout();


        ppt.createSlide(slideLayout); // 创建第二个Slide页
        ppt.createSlide(slideLayout); // 创建第三个Slide页
        ppt.createSlide(slideLayout); // 创建第四个Slide页
    }

}
