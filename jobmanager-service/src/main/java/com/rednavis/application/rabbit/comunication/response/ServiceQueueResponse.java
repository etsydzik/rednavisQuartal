package com.rednavis.application.rabbit.comunication.response;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This class is a parent for for other classes which is used to create response to queue.
 * All responses must contain IP address of current service in payload.
 *
 * @autor Arthur Kushner
 */
public abstract class ServiceQueueResponse {

    private String IP;

    {
        try {
            this.IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        }
    }


    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }


}
