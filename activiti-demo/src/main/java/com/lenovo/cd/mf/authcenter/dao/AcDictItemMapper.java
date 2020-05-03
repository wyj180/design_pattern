package com.lenovo.cd.mf.authcenter.dao;

import com.lenovo.cd.mf.authcenter.domain.AcDictItem;
import com.lenovo.cd.mf.authcenter.domain.AcDictItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcDictItemMapper {
    long countByExample(AcDictItemExample example);

    int deleteByExample(AcDictItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcDictItem record);

    int insertSelective(AcDictItem record);

    List<AcDictItem> selectByExample(AcDictItemExample example);

    AcDictItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcDictItem record, @Param("example") AcDictItemExample example);

    int updateByExample(@Param("record") AcDictItem record, @Param("example") AcDictItemExample example);

    int updateByPrimaryKeySelective(AcDictItem record);

    int updateByPrimaryKey(AcDictItem record);
}