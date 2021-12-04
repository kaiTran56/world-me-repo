package com.tranquyet.controller.client;

import com.tranquyet.domain.MessageDomain;
import com.tranquyet.service.WSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WSController {

    @Autowired
    private WSService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final MessageDomain message) {
//        log.info("WSController: "+message.toString());
        service.notifyFrontend(message.getMessageContent());
    }
}
