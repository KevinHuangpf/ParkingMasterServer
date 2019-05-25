package com.pfhuang.dao;

import com.pfhuang.pojo.Parkingspace;

public interface ParkingspaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parkingspace record);

    int insertSelective(Parkingspace record);

    Parkingspace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parkingspace record);

    int updateByPrimaryKey(Parkingspace record);
}