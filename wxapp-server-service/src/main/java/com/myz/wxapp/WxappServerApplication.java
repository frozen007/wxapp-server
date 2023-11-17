package com.myz.wxapp;

import org.apache.dubbo.common.timer.HashedWheelTimer;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDubbo
public class WxappServerApplication extends SpringApplication {

    public WxappServerApplication() {
        super(WxappServerApplication.class);
    }

    @Override
    protected void configurePropertySources(ConfigurableEnvironment environment, String[] args) {
        super.configurePropertySources(environment, args);
    }

    @Qualifier("taskWheelTime")
    @Bean
    public HashedWheelTimer taskWheelTime() {
        HashedWheelTimer wheelTimer = new HashedWheelTimer(500, TimeUnit.MILLISECONDS, 120);
        wheelTimer.start();
        return wheelTimer;
    }

    public static void main(String[] args) {
        //SpringApplication.run(WxappServerApplication.class, args);
        new WxappServerApplication().run(args);
    }

}
