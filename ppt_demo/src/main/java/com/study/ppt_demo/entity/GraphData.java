package com.study.ppt_demo.entity;

import java.util.List;

/**
 * ppt图表系列数据
 */
public class GraphData {

    // 图形标题
    private String title;

    // 系列值
    private List<StringKeyVo> serList;

    public GraphData(String title, List<StringKeyVo> serList) {
        super();
        this.title = title;
        this.serList = serList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StringKeyVo> getSerList() {
        return serList;
    }

    public void setSerList(List<StringKeyVo> serList) {
        this.serList = serList;
    }

    @Override
    public String toString() {
        return "GraphData [title=" + title + ", serList=" + serList + "]";
    }

}
