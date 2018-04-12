package com.rednavis.application.controllers;

import com.rednavis.entities.GreetingRabbitMq;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Eugene Tsydzik
 * on 4/12/18.
 */
@RestController
public class GreetingRabbitController {

    private static final String template = "Hi, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetingRabbit")
    public GreetingRabbitMq greeting(@RequestParam(value="name", defaultValue="Man") String name) {
        return new GreetingRabbitMq(counter.incrementAndGet(),
                String.format(template, name));
    }
}