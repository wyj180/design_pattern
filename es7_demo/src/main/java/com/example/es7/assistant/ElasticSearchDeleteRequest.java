/*
 * 文件名：ElasticSearchDeleteRequest.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.assistant;

import lombok.Getter;

/**
 * 功能描述：<code>ElasticSearchDeleteRequest</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/8/5 10:25
 */
@Getter
public class ElasticSearchDeleteRequest {

	private String indices[];
	private String field;
	private Object value;

	private ElasticSearchDeleteRequest() {
	}

	private ElasticSearchDeleteRequest(String... indices) {
		this.indices = indices;
	}

	public static final ElasticSearchDeleteRequest of(String... indices){
		return new ElasticSearchDeleteRequest(indices);
	}

	public void setField(String field,Object value){
		this.field = field;
		this.value = value;
	}

}
