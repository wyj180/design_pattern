package com.study.freemarker_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckedTestController {

    @RequestMapping(value = "checkedIndex")
    public String index(ModelMap map) {
        map.put("factory", "WHAAA");
        map.put("name", "wangyj");
        map.put("age", "100");
        map.put("expiration_type", "短期-限时");
        map.put("expiration", 2);
        map.put("expiration_unit", "年");
        return "checkedIndex";
    }

}
