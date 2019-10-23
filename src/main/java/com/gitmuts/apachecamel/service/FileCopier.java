package com.gitmuts.apachecamel.service;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FileCopier {

    @Autowired
    CamelContext context;

    @Bean
    private CamelContext configure() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(
                new RouteBuilder() {
                    public void configure() {
                        from("file:data/inbox?noop=true").to("file:data/outbox");
                    }
                }
        );

        context.start();
        return context;
    }

    @Scheduled(fixedRate = 10000)
    public boolean copyFile() throws Exception {
        Thread.sleep(10000);
        context.stop();
        return true;
    }
}
