package com.gitmuts.apachecamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CBRRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/cbr/a?noop=true")
                .choice()
                .when(xpath("/Order/Number=15")).to("file:files/cbr/ar")
                .when(xpath("/Order/Number=30")).to("file:files/cbr/br")
                .otherwise().to("file:files/cbr/aa")
                .end();
    }
}
