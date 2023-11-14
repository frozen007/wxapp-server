package com.myz.wxapp;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

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

    public static void main(String[] args) {
        //SpringApplication.run(WxappServerApplication.class, args);
        new WxappServerApplication().run(args);
    }

}
