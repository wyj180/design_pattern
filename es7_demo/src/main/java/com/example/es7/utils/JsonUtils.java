/*
 * 文件名：JsonUtils.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 功能描述：<code>JsonUtils</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/4/29 12:34
 */
public final class JsonUtils {

	private JsonUtils(){}

	public static String toJSONStringIgnoreTransient(Object object) {
		try(SerializeWriter out = new SerializeWriter()) {
			JSONSerializer serializer = new JSONSerializer(out);
			serializer.config(SerializerFeature.SkipTransientField, false);
			serializer.config(SerializerFeature.WriteClassName, true);
			serializer.write(object);
			return out.toString();
		}
	}

	/**
	 * @param jsonArray
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> parseJson(List<String> jsonArray,Class<T> clazz) {
		return jsonArray.stream()
				.map(json -> JSON.parseObject(json, clazz))
				.collect(Collectors.toList());
	}

	/**
	 * @param param
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T mapToObject(Map<String, Object> param, Class<T> clazz) {
		return JSON.parseObject(JSON.toJSONString(param), clazz);
	}

	/**
	 * @param params
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> mapToObjects(List<Map<String, Object>> params, Class<T> clazz) {
		return params.stream().map(param -> mapToObject(param, clazz)).collect(Collectors.toList());
	}

}
