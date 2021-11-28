package com.tranquyet.controller.admin;

import com.tranquyet.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "TopicManagementController")
@RequestMapping(value = "/admin/topic")
public class TopicManagementController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public String getScreen(){
        return "admin/s3-topic-admin";
    }

}
