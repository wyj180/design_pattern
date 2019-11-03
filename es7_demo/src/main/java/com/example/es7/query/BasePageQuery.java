/*
 * 文件名：BasePageQuery.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：<code>BasePageQuery</code>base query object
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/3/18 14:17
 */
@ApiModel
public class BasePageQuery {
	@ApiModelProperty(value = "页码",required = false)
	private int pageNum = 1;
	@ApiModelProperty(value = "每页条数",required = false)
	private int pageSize = 10;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
