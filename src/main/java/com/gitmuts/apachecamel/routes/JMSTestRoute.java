package com.gitmuts.apachecamel.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JMSTestRoute extends RouteBuilder {

    static final Logger log = LoggerFactory.getLogger(JMSTestRoute.class);

    @Override
    public void configure() throws Exception {
        from("jms:testin")
                .log(LoggingLevel.DEBUG, log, "New message received")
                .process(exchange -> {
                    String message = exchange.getMessage().getBody()  + " updated";
                    exchange.getMessage().setBody(message);
                })
                .to("jms:testout")
                .log(LoggingLevel.DEBUG, log, "Message sent to queue")
                .end();
    }
}
