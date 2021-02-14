package com.springcloud.scg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class RefreshListener implements ApplicationListener<EnvironmentChangeEvent> {
    @Autowired
    Resilience4jConfig resilience4jConfig;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        //if (event.getKeys().contains("tps")) {
        resilience4jConfig.refresh();
        //}
    }
}