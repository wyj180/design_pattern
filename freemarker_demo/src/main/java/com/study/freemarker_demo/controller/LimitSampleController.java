package com.study.freemarker_demo.controller;

import com.study.freemarker_demo.entity.Info;
import com.study.freemarker_demo.entity.Item;
import com.study.freemarker_demo.entity.ItemExt;
import com.study.freemarker_demo.entity.SampleInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LimitSampleController {

    List<SampleInfo> sampleInfos = new ArrayList<>();

    {
        List<Item> items = new ArrayList<>();
        items.add(new Item("sample_id_A01", "Limit Sample"));
        items.add(new Item("sample_id_A02", "Limit Sample"));

        List<Item> itemsAA = new ArrayList<>();
        itemsAA.add(new Item("sample_id_AA01", "Golden Sample"));
        itemsAA.add(new Item("sample_id_AA02", "Golden Sample"));

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("sample_id_B01", "Limit Sample"));
        items2.add(new Item("sample_id_B02", "Limit Sample"));

        List<Item> items2BB = new ArrayList<>();
        items2BB.add(new Item("sample_id_B01_BB", "Golden Sample"));
        items2BB.add(new Item("sample_id_B02_BB", "Golden Sample"));

        Info infoA1 = new Info("Limit Sample", "HQ");
        Info infoA2 = new Info("Golden Sample", "HQ");
        Info infoB1 = new Info("Limit Sample", "WT");
        Info infoB2 = new Info("Golden Sample", "WT");

        sampleInfos.add(new SampleInfo(infoA1, items));
        sampleInfos.add(new SampleInfo(infoA2, itemsAA));
        sampleInfos.add(new SampleInfo(infoB1, items2));
        sampleInfos.add(new SampleInfo(infoB2, items2BB));

    }

    @RequestMapping(value = "limitSampleIndex")
    public String index(ModelMap map) {

        // 首先，根据供应商分组(一级分组)，再根据SampleCategory分组（二级分组）
        Map<String, Map<String, List<ItemExt>>> groupItems = groupBySampleCategory(sampleInfos);

        // 封装Freemarker模板数据
        // map.put("itemGroups", "AAA"); // freemarker中访问 ${itemGroups}

        Map<String, Object> info = new HashMap<>();
        info.put("supplier", "supplier");
        info.put("part", "part");

        map.put("info", info); // freemarker中访问${itemGroups} 时会报错，因为输出的值需要是String、int这种类型的
        map.put("itemGroups", groupItems); // freemarker中访问${itemGroups} 时会报错，因为输出的值需要是String、int这种类型的
        return "mail_Limit_sample";
    }

    private Map<String, Map<String, List<ItemExt>>> groupBySampleCategory(List<SampleInfo> sampleInfoList){
        List<ItemExt> itemExtList = sampleInfoList.stream().flatMap(x -> getItemExt(x).stream()).collect(Collectors.toList());
        Map<String, Map<String, List<ItemExt>>> itemGroups = itemExtList.stream()
                .collect(Collectors.groupingBy(ItemExt::getOdm_supplier, Collectors.groupingBy(ItemExt::getSample_category)));
        return itemGroups;
    }

    private List<ItemExt> getItemExt(SampleInfo sampleInfo) {
        List<Item> itemsList = sampleInfo.getItems();
        Info info = sampleInfo.getInfo();
        List<ItemExt> itemExts = itemsList.stream().map(item -> {
            ItemExt itemExt = new ItemExt();
            BeanUtils.copyProperties(item, itemExt);
            BeanUtils.copyProperties(info, itemExt);
            return itemExt;
        }).collect(Collectors.toList());
        return itemExts;
    }

    // Freemarker中如何輸出map的所有key？
    // 答案：使用?keys 示例
    // <#list itemGroups?keys as supplierName>
    //		${supplierName}
    // </#list>
    //

}
