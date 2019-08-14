package com.taichi.cfm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
@EnableSpringConfigured
@ComponentScan({"com.taichi.cfm"})
@PropertySource("${config.file:classpath:config.properties}")
public class CfmMain extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(CfmMain.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CfmMain.class);
        app.setBannerMode(Banner.Mode.OFF);

        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        app.setAdditionalProfiles(getDefaultProfile(source));
        // app.setAdditionalProfiles("xtest2");

        app.run(args);
    }

    private static String getDefaultProfile(SimpleCommandLinePropertySource source) {
        if (source.containsProperty("spring.profiles.active")) {
            log.info("Running with Spring profile(s) : {}", source.getProperty("spring.profiles.active"));
            return source.getProperty("spring.profiles.active");
        }

        log.warn("No Spring profile configured, running with default configuration: local.");
        return "local";
    }
}
