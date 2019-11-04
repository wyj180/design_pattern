package com.neimeng.workflow.controller;

import com.neimeng.workflow.service.ProcessHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class ProcessTaskController {

    @Autowired
    private ProcessHistoryService processHistoryService;

    /**
     * Purpose：获取流程图并显示
     *
     * @param processInstanceId 流程定义id
     * @param response
     * @return
     */
    @RequestMapping(value = "/getProcessImg/{processInstanceId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public void getProcessImg(@PathVariable String processInstanceId, HttpServletResponse response) {
        try {
            processHistoryService.getProccessImage(processInstanceId, response);
        } catch (Exception e) {
            log.debug("获取流程图出错", e);
        }
    }
}
