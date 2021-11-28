package com.tranquyet.controller.client;

import com.tranquyet.dto.PublicVideoDTO;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.service.TopicService;
import com.tranquyet.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller(value = "S1_IndexClientController")
public class S1_IndexClientController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private VideoService videoService;

    @GetMapping(value = {"", "/home"})
    public String getIndex(Model model){
        List<TopicDTO> topicDTOList = topicService.findAll();
        List<PublicVideoDTO> publicVideoDTOList = videoService.findAll();
        model.addAttribute("topics_web",topicDTOList);
        model.addAttribute("videos_web", publicVideoDTOList);
        return "web/index/s1-index-web";
    }
}
