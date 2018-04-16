package com.rednavis.application.rabbit.listeners;


import com.rednavis.application.rabbit.comunication.RabbitHttppConnector;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Alexander Sokolov
 */
@Log4j2
@EnableRabbit
@Component
public class RabbitMqListener {

    private HashMap<String,String> mapOfMessages=new HashMap<>();

    @Inject
    private RabbitHttppConnector rabbitHttppConnector;

    @RabbitListener(queues = {"logmessages", "basResponseQueue", "simResponseQueue"})
    public void processQueue1(Message message) {
        mapOfMessages.put(getKey(message.getMessageProperties().getReceivedRoutingKey()),decodeUTF8(message.getBody()));
        log.info("Received from queue: "+message.getMessageProperties().toString() + "  with body"+ decodeUTF8(message.getBody()));
        try {
            rabbitHttppConnector.itit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    private String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    private String getKey(String receivedRoutingKey){
        return  receivedRoutingKey+UUID.randomUUID().toString();
    }

}
