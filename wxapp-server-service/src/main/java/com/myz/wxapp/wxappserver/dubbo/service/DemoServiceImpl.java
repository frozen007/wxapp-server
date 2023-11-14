package com.myz.wxapp.wxappserver.dubbo.service;

import com.myz.wxapp.wxappserver.dubbo.api.DemoService;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService
public class DemoServiceImpl implements DemoService {

    Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("invoked name=" + name);
        return "Hello " + name;
    }
}