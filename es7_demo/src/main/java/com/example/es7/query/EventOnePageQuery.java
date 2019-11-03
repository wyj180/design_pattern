package com.example.es7.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "One Page查询对象")
@Getter
@Setter
@ToString
public class EventOnePageQuery extends EventListPageQuery {

    @ApiModelProperty("型号")
    private List<Object> products;

    @ApiModelProperty("分类")
    private List<Object> categories;

    @ApiModelProperty("供应商")
    private List<Object> suppliers;

    @ApiModelProperty("pe")
    private String pe;

    @ApiModelProperty("Supplier Contact")
    private String supplierContact;

    @ApiModelProperty("多个id")
    private List<Integer> ids;

    public EventOnePageQuery buildEsConditions() {
        inConditions = (inConditions == null) ? new HashMap<>() : inConditions;
        if (!CollectionUtils.isEmpty(products)) {
            inConditions.put("product", products.toArray(new Object[products.size()]));
        }
        if (!CollectionUtils.isEmpty(categories)) {
            inConditions.put("category", categories.toArray(new Object[categories.size()]));
        }
        if (!CollectionUtils.isEmpty(suppliers)) {
            inConditions.put("supplier", suppliers.toArray(new Object[suppliers.size()]));
        }
        if (StringUtils.isNotBlank(pe)) {
            inConditions.put("pe", new Object[]{pe});
        }
        if (StringUtils.isNotBlank(supplierContact)) {
            inConditions.put("supplier_contact", new Object[]{supplierContact});
        }
        return this;
    }

}
