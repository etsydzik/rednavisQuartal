package com.rednavis.application.services;

import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * Created by Eugene Tsydzik
 * on 4/14/18.
 */
public interface JobmanagerSessionService {

    void removeSession(WebSocketSession session);

    void addClientSession(WebSocketSession session);

    void newMessage(WebSocketSession session, WebSocketMessage<?> message) throws IOException;
}