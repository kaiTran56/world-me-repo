package com.tranquyet.service;

import com.tranquyet.domain.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WSService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyFrontend(final String message) {
//        log.info("WSService: "+message);
        ResponseMessage response = new ResponseMessage(message);
        messagingTemplate.convertAndSend("/topic/messages", response);
    }

}
