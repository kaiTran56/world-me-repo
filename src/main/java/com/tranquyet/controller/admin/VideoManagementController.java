package com.tranquyet.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "VideoManagementController")
@RequestMapping("/admin/movie")
public class VideoManagementController {

    @GetMapping
    public String getScreen(){
        return "admin/s1-movie-admin";
    }



}
