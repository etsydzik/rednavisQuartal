package com.rednavis.application.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rednavis.application.services.JobManagerClientService;
import com.rednavis.application.services.JobmanagerSessionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene Tsydzik
 * on 4/14/18.
 */
@Service
@Log4j2
public class JobmanagerSessionServiceImpl implements JobmanagerSessionService {


    @Inject
    JobManagerClientService jobManagerClientService;

    /**
     * The session mapper.
     */
    private List<WebSocketSession> sessionList = new ArrayList<>();

    public void addClientSession(WebSocketSession session) {
        sessionList.add(session);
    }

    @Inject
    private ObjectMapper mapper;

    @Override
    public void newMessage(WebSocketSession session, WebSocketMessage<?> message) throws IOException {
        session.sendMessage(new TextMessage(mapper.writeValueAsString(jobManagerClientService.getBaselineJobs())));
    }


    @Override
    public void removeSession(WebSocketSession session) {
        sessionList.remove(session);
    }
}
