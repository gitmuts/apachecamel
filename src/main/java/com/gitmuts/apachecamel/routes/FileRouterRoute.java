package com.gitmuts.apachecamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileRouterRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/inbox?noop=true").to("file:data/outbox");
    }
}
