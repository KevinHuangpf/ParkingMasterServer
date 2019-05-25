package com.pfhuang.service;

import com.pfhuang.common.ServerResponse;
import org.springframework.stereotype.Service;



public interface ILotService {
    ServerResponse lotManage(String lotMSG);
}
