package com.myz.wxapp.wxappserver.dubbo.service;

import com.myz.wxapp.ticket.service.TicketService;
import com.myz.wxapp.api.DemoService;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private TicketService ticketService;

    @Override
    public String sayHello(String name) {
        long newId = 0;
        try {
            long[] testIds = ticketService.batchFetch("test_id", 1);
            if(testIds!=null && testIds.length>0) {
                newId = testIds[0];
            }
        } catch (Exception e) {
            logger.error("fetch id error:", e);
        }
        logger.info("invoked name=" + name +", newId=" + newId);
        return "Hello " + name + ", newId=" + newId;
    }
}