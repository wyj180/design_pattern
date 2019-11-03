package com.example.demo.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class FileController {

    // 因为没有做别的配置，这里不能写为return "/index";
    @RequestMapping(value = "/")
    public String index(HttpServletResponse response) throws IOException {
        return "index.html"; // 正确，会转发到resources/static/ 目录下的index.html
        // return "/index.html";  // 正确，会转发到resources/static/ 目录下的index.html，注意这里在前面多加了 /
        // return "/templates/index.html";  // 错误，不会转发到resources/templates/index.html
        // return "redirect:/templates/index.html"; // 错误：浏览器的url会变为：http://localhost:8080/templates/index.html，但是还是找不到templates/index.html
    }

    /**
     * 使用ajax下载文件
     *
     * @param response
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public void uploadFile(HttpServletResponse response) {
        System.out.println("接收到的参数：");
        download(response);
    }

    /**
     * 下载文件
     *
     * @param response
     */
    public void download(HttpServletResponse response) {
        String path = "D:\\testDir\\PPT\\1_onepage\\template\\SQM_template\\onePage_template.pptx";
        try {
            // 设置强制下载不打开
            //response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode("文件名.pptx", "UTF-8"));

            FileInputStream inputStream = new FileInputStream(new File(path));
            OutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
