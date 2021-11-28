package com.tranquyet.controller.admin;

import com.tranquyet.dto.TopicDTO;
import com.tranquyet.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "VideoManagementController")
@RequestMapping("/admin/video")
@Slf4j
public class VideoManagementController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public String getScreen(Model model){
        List<TopicDTO> topicDTOList = topicService.findAll();
        model.addAttribute("topics",topicDTOList);
        return "admin/s1-video-admin";
    }

    @GetMapping("/add")
    public String getAddScreen(Model model){
        List<TopicDTO> topicDTOList = topicService.findAll();
        model.addAttribute("topics",topicDTOList);
        return "admin/s2-add-video-admin";
    }

}
