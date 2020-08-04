package com.objcom.supreme.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "config")
public class LoadConfigController {

    @Value("${test.message}")
    private String msg;

    /**
     * 读取配置文件中的数据
     * @return msg
     */
    @RequestMapping(value = "load")
    private String load(){
        return msg;
    }
}
