package com.pfhuang.util;

import com.mysql.jdbc.StringUtils;
import com.pfhuang.common.ServerResponse;

public class CheckMSG {



    public  static boolean checkMSG(String MSG){
        String[] payload = MSG.split(",");
        // 核对payload在业务LOT的完整性
        boolean isPayloadSizeRight = payload.length==6; //是否是6个payload值

        boolean nullInPayload = false; //是否含有空值
        for(String payloadItem:payload){
            if(StringUtils.isNullOrEmpty(payloadItem)){
                nullInPayload=true;
                break;
            }
        }

/*        if((!isPayloadSizeRight)||nullInPayload){
            return false;
        }*/
        return !(!isPayloadSizeRight)||nullInPayload;


    }


}
