package com.tranquyet.controller.client;

import com.tranquyet.domain.MessageDomain;
import com.tranquyet.domain.ResponseMessage;
import com.tranquyet.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller(value = "CommentController")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(final MessageDomain message) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Comment Controller: "+message.toString());
        commentService.customSaveMessage(message);
        return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
    }

}
