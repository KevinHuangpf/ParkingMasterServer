package com.pfhuang.controller.backend;

import com.pfhuang.common.ServerResponse;
import com.pfhuang.service.ILotService;
import com.pfhuang.service.IPakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/backend/manage")

public class LotManagerController {

    @Autowired
    private ILotService iLotService;

    @Autowired
    private IPakService iPakService;

    @RequestMapping("lot.do")
    @ResponseBody
    public ServerResponse lotMSG(String LOTMSG){
        return iLotService.lotManage(LOTMSG);
    }

    @RequestMapping(value = "pak.do")
    @ResponseBody
    public ServerResponse pakMSG(String PAKMSG){

        return  iPakService.pakManage(PAKMSG);
    }

}
