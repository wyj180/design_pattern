package com.example.es7.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "Lesson Learn查询对象")
@Getter
@Setter
@ToString
public class EventLessonLearnQuery extends EventListPageQuery {

    @ApiModelProperty("LL type")
    private List<Object> llTypes;

    @ApiModelProperty("Root Couse Type")
    private List<Object> rootCauseTypes;

    @ApiModelProperty("Achievement")
    private List<Object> achievements;

    @ApiModelProperty("product")
    private List<Object> products;

    @ApiModelProperty("Severity Level")
    private List<Object> severityLevels;


    @ApiModelProperty("LL Status")
    private List<Object> llStatus;

    @ApiModelProperty("Design Type")
    private List<Object> designTypes;

    @ApiModelProperty("Issue type")
    private List<Object> issueTypes;

    @ApiModelProperty("KP Category")
    private List<Object> kpCategorys;

    @ApiModelProperty("Odm Name")
    private List<Object> odmNames;

//    @ApiModelProperty("开始查询时间")
//    private String startDate;
//
//    @ApiModelProperty("结束查询时间")
//    private String endDate;

    public void setQueryCondition() {
        System.out.println("EventLessonLearnQuery...");
    }

    public EventLessonLearnQuery buildEsConditions() {
        inConditions = (inConditions == null) ? new HashMap<>() : inConditions;
        if (!CollectionUtils.isEmpty(llTypes)) {
            inConditions.put("ll_type", llTypes.toArray(new Object[llTypes.size()]));
        }
        if (!CollectionUtils.isEmpty(achievements)) {
            inConditions.put("achievement", achievements.toArray(new Object[achievements.size()]));
        }
        if (!CollectionUtils.isEmpty(products)) {
            inConditions.put("product", products.toArray(new Object[products.size()]));
        }
        if (!CollectionUtils.isEmpty(severityLevels)) {
            inConditions.put("severity_level", severityLevels.toArray(new Object[severityLevels.size()]));
        }
        if (!CollectionUtils.isEmpty(llStatus)) {
            inConditions.put("process_en", llStatus.toArray(new Object[llStatus.size()]));
        }
        if (!CollectionUtils.isEmpty(designTypes)) {
            inConditions.put("design_type", designTypes.toArray(new Object[designTypes.size()]));
        }
        if (!CollectionUtils.isEmpty(issueTypes)) {
            inConditions.put("issue_type", issueTypes.toArray(new Object[issueTypes.size()]));
        }
        if (!CollectionUtils.isEmpty(kpCategorys)) {
            inConditions.put("kp_category", kpCategorys.toArray(new Object[kpCategorys.size()]));
        }
        if (!CollectionUtils.isEmpty(odmNames)) {
            inConditions.put("odm_name", odmNames.toArray(new Object[odmNames.size()]));
        }

        // TODO 时间范围

        return this;
    }

    public static void main(String[] args) {
        EventListPageQuery lessonLearnQuery = new EventLessonLearnQuery();
    }

}
