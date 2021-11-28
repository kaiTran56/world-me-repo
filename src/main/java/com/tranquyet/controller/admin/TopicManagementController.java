package com.tranquyet.controller.admin;

import com.tranquyet.dto.CommentDTO;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.service.CommentService;
import com.tranquyet.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "TopicManagementController")
@RequestMapping(value = "/admin/topic")
public class TopicManagementController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String getScreen(Model model){
        List<TopicDTO> topicDTOList = topicService.findAll();
        List<CommentDTO> commentDTOList = commentService.findAll();
        model.addAttribute("comments", commentDTOList);
        model.addAttribute("topics", topicDTOList);
        return "admin/s3-topic-admin";
    }

}
