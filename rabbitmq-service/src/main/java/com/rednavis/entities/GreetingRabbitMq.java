package com.rednavis.entities;

/**
 * Created by Eugene Tsydzik
 * on 4/12/18.
 */
public class GreetingRabbitMq {
    private final long id;
    private final String content;

    public GreetingRabbitMq(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
