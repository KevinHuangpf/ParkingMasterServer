package com.pfhuang.dao;

import com.pfhuang.pojo.Parkingspace;
import org.apache.ibatis.annotations.Param;

public interface ParkingspaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parkingspace record);

    int insertSelective(Parkingspace record);

    Parkingspace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parkingspace record);

    int updateByPrimaryKey(Parkingspace record);

    Parkingspace selectByParkingSpaceIdAndParkinglotId(@Param("parkingSpaceId") Integer parkingSpaceId, @Param("parkinglotId") Integer parkinglotId);

}