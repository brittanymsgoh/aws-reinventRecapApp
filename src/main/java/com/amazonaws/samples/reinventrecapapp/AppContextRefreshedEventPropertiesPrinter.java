package com.amazonaws.samples.reinventrecapapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AppContextRefreshedEventPropertiesPrinter {

    static final Logger logger = LoggerFactory.getLogger(ReinventRecapAppApplication.class);

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        ConfigurableEnvironment env = (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();
        env.getPropertySources()
                .stream()
                .filter(ps -> ps instanceof MapPropertySource && ps.getName().contains("application.properties"))
                .map(ps -> ((MapPropertySource) ps).getSource().keySet())
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .forEach(key -> logger.info("{}={}", key, env.getProperty(key)));
    }
}
