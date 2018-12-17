package com.ag.todoservices;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by AMK on 17/12/18.
 */
@Configuration
public class ServletContainerCustomizer {
    
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        
        factory.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "(){}[]"));
        
        return factory;
    }       
}
