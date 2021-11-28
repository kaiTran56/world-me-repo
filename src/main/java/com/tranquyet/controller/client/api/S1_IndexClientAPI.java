package com.tranquyet.controller.client.api;

import com.tranquyet.dto.PublicVideoDTO;
import com.tranquyet.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin("*")
@RestController(value = "S1_IndexClientAPI")
@RequestMapping("/api/video")
public class S1_IndexClientAPI {
    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<PublicVideoDTO>> getListVideo(@RequestParam(value = "topic", required = false, defaultValue = "all") Optional<String> topic){
        final HttpStatus[] httpStatuses = {null};
        log.info(topic.get());
        List<PublicVideoDTO> publicVideoDTOList ;
        if(topic.get().isEmpty()==false && topic.get()!=null &&!topic.get().equals("all")){
            publicVideoDTOList = videoService.findByTopic(topic.get());
            httpStatuses[0]=HttpStatus.OK;
        }else{
            publicVideoDTOList = videoService.findAll();
            httpStatuses[0]=HttpStatus.OK;
        }
        return new ResponseEntity<>(publicVideoDTOList,
                Optional.of(httpStatuses[0]).orElse(HttpStatus.CONFLICT));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<PublicVideoDTO> getVideoById(@PathVariable(name = "id") Optional<Long> idVideo){
        final HttpStatus[] httpStatuses = {null};
        log.info("------------->"+idVideo.get());
        PublicVideoDTO publicVideoDTO = videoService.getById(idVideo.orElse(1L));
        Optional<PublicVideoDTO> optionalPublicVideoDTO = Optional.of(publicVideoDTO);
        optionalPublicVideoDTO.ifPresent(p->{
            httpStatuses[0] = HttpStatus.OK;
        });
        return new ResponseEntity<>(optionalPublicVideoDTO.orElse(null),
                Optional.of(httpStatuses[0]).orElse(HttpStatus.EXPECTATION_FAILED));
    }
}
