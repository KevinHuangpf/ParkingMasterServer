package com.pfhuang.service.impl;

import com.pfhuang.common.ServerResponse;
import com.pfhuang.dao.ParkinglotMapper;
import com.pfhuang.pojo.ParkingMessage;
import com.pfhuang.pojo.Parkinglot;
import com.pfhuang.service.ILotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pfhuang.common.Const.*;
import static com.pfhuang.common.Const.Status.*;
import static com.pfhuang.util.CheckMSG.checkMSG;


@Service("iLotService")
public class LotServiceImpl implements ILotService {
    @Autowired
    private ParkinglotMapper parkinglotMapper;

    /**
     * lotManage
     * @param lotMSG
     * @return
     */
    public ServerResponse lotManage(String lotMSG){

        if(lotMSG==null){
            return ServerResponse.createByErrorMessage("数据为空");
        }

        if(!checkMSG(lotMSG)){
            return ServerResponse.createByErrorMessage("数据内容无效");
        }

        String[] payload = lotMSG.split(regexPayload);
        // parkingMessage对象并赋值
        final ParkingMessage parkingMessage = new ParkingMessage();
        parkingMessage.setZoneId(Integer.valueOf(payload[0]));
        parkingMessage.setParkinglotId(Integer.valueOf(payload[1]));
        parkingMessage.setFee(Double.valueOf(payload[2]));
        parkingMessage.setSpaceTotal(Integer.valueOf(payload[3]));
        parkingMessage.setSpaceAvailable(Integer.valueOf(payload[4]));
        String index=payload[5];

        if(index.equals(Status_SUCCESS)) {
            Parkinglot parkinglotTemp = parkinglotMapper.selectByParkinglotIdAndZoneId(parkingMessage.getParkinglotId(), parkingMessage.getZoneId());
            int rowCount;
            if (parkinglotTemp == null) {
                Parkinglot parkinglot = new Parkinglot();
                parkinglot.setParkinglotId(parkingMessage.getParkinglotId());
                parkinglot.setZoneId(parkingMessage.getZoneId());
                parkinglot.setFee(parkingMessage.getFee());
                parkinglot.setParkingspaceTotal(parkingMessage.getSpaceTotal());
                parkinglot.setParkingspaceAvailable(parkingMessage.getSpaceAvailable());
                rowCount = parkinglotMapper.insert(parkinglot);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("新增记录成功");
                }
            } else {
                parkinglotTemp.setParkinglotId(parkingMessage.getParkinglotId());
                parkinglotTemp.setZoneId(parkingMessage.getZoneId());
                parkinglotTemp.setFee(parkingMessage.getFee());
                parkinglotTemp.setParkingspaceTotal(parkingMessage.getSpaceTotal());
                parkinglotTemp.setParkingspaceAvailable(parkingMessage.getSpaceAvailable());
                rowCount = parkinglotMapper.updateByPrimaryKey(parkinglotTemp);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccessMessage("更新记录成功");
                }
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新车场数据失败");

    }

}
