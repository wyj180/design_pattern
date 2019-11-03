package com.neimeng.workflow.dao;

import com.neimeng.workflow.entity.pojo.DsProcessRelation;

public interface DsProcessRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DsProcessRelation record);

    int insertSelective(DsProcessRelation record);

    DsProcessRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DsProcessRelation record);

    int updateByPrimaryKey(DsProcessRelation record);
}