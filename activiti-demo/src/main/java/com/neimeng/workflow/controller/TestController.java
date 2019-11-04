package com.neimeng.workflow.controller;

import com.neimeng.workflow.dao.DsProcessRelationMapper;
import com.neimeng.workflow.entity.pojo.DsProcessRelation;
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

    @Autowired
    private DsProcessRelationMapper dsProcessRelationMapper;

    @RequestMapping("test01")
    @ResponseBody
    public Response test01() {
        String result = "success";
        return Response.success(result);
    }

    @RequestMapping("test02")
    @ResponseBody
    public Response test02() {
        DsProcessRelation dsProcessRelation = dsProcessRelationMapper.selectByPrimaryKey(1);
        return Response.success(dsProcessRelation);
    }

}
