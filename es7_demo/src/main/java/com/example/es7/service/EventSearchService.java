/*
 * 文件名：EventSearchService.java
 * 版权：Copyright 1984-2019 Lenovo Group. All Rights Reserved.
 * 描述：
 * 修改人：
 * 修改时间：
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.example.es7.service;

import com.example.es7.entity.EventOnePageVO;
import com.example.es7.query.EventListPageQuery;
import com.example.es7.query.EventOnePageQuery;
import com.github.pagehelper.Page;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：<code>EventSearchService</code>
 * </p>
 *
 * @author heqiang7
 * @version [1.0.0], 2019/6/10 18:18
 */
public interface EventSearchService {


    /**
     * 根据ID删除SIF Doc
     *
     * @param id
     * @return
     */
    boolean deleteSifById(BigInteger id);

    /**
     * 根据ID删除One Page Doc
     *
     * @param id
     * @return
     */
    boolean deleteOnePageById(BigInteger id);

    /**
     * es中分页查询onePage
     *
     * @param pageQuery
     * @return
     */
    Page<EventOnePageVO> searchOnePageByPage(EventOnePageQuery pageQuery);

    /**
     * 根据条件查询onePage的id
     *
     * @param query
     * @return
     */
    List<EventOnePageVO> searchOnePageId(EventOnePageQuery query);

    /**
     * 复杂分页查询Map类型结果集
     *
     * @param pageQuery
     * @return
     */
    Page<Map<String,Object>> compositeSearchMapByPage(EventListPageQuery pageQuery, String index);
}
