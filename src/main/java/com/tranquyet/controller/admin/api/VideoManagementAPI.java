package com.tranquyet.controller.admin.api;

import com.tranquyet.dto.PublicVideoDTO;
import com.tranquyet.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@CrossOrigin("*")
@RestController(value = "VideoManagementAPI")
@RequestMapping("/admin/api/video")
public class VideoManagementAPI {

    @Autowired
    private VideoService videoService;

    @PostMapping("/add")
    public ResponseEntity<PublicVideoDTO> saveVideo(@RequestBody PublicVideoDTO dto){
        final HttpStatus[] httpStatus = {null};
        Optional<PublicVideoDTO> checkDTO = Optional.of(dto);
        dto.setTopicDTO(dto.getTopicDTO());
        log.info(dto.toString());
        checkDTO.filter(p->p.getTitleVideo()!=null&&p.getTitleVideo().isEmpty()!=true)
                .ifPresent(p->{
            log.info(p.toString());
            videoService.save(dto);
            httpStatus[0] = HttpStatus.OK;
        });
        return new ResponseEntity<>(checkDTO.orElse(null),
                Optional.of(httpStatus[0]).orElse(HttpStatus.EXPECTATION_FAILED));
    }

    @DeleteMapping("/delete/{idVideo}")
    public ResponseEntity<Void> deleteVideo(@PathVariable("idVideo") long idVideo){
        Long[] ids = {idVideo};
        videoService.delete(ids);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
