package com.neimeng.workflow.controller;

import com.neimeng.workflow.entity.Response;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    public RepositoryService repositoryService;

    @RequestMapping("test01")
    @ResponseBody
    public Response test01() {
        String result = "success";
        return Response.success(result);
    }

}
