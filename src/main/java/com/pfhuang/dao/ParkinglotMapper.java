package com.pfhuang.dao;

import com.pfhuang.pojo.Parkinglot;
import org.apache.ibatis.annotations.Param;

public interface ParkinglotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parkinglot record);

    int insertSelective(Parkinglot record);

    Parkinglot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parkinglot record);

    int updateByPrimaryKey(Parkinglot record);

    Parkinglot selectByParkinglotIdAndZoneId( @Param("parkinglotId")Integer parkinglotId, @Param("zoneId") Integer zoneId);
}