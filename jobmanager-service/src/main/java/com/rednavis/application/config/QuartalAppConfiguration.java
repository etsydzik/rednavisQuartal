package com.rednavis.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Eugene Tsydzik
 * on 4/14/18.
 */
@Configuration
@ComponentScan("com.rednavis.application")
@EnableScheduling
@Import(PropertiesConfig.class)
public class QuartalAppConfiguration {
}