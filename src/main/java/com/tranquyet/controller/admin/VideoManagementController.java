package com.tranquyet.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "VideoManagementController")
@RequestMapping("/admin/movie")
public class VideoManagementController {

    @GetMapping("/test")
    public ResponseEntity<?> getMovies(){
        return new ResponseEntity<>("admin/table", HttpStatus.OK);
    }

    @GetMapping
    public String getScreen(){
        return "admin/table";
    }

}
