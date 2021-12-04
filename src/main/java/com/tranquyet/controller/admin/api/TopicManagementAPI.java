package com.tranquyet.controller.admin.api;

import com.tranquyet.dto.TopicDTO;
import com.tranquyet.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/api/topic")
@Slf4j
public class TopicManagementAPI {

    @Autowired
    private TopicService topicService;

    @DeleteMapping("/delete/{idTopic}")
    public ResponseEntity<Void> deleteTopic(@PathVariable(name = "idTopic") long idTopic){
        Long[] idTopics = {idTopic};
//        log.info("------------>"+idTopic);
        topicService.delete(idTopics);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TopicDTO> saveTopic(@RequestBody TopicDTO topicDTO){
        final HttpStatus[] httpStatuses = {null};
        Optional<TopicDTO> dtoOptional = Optional.of(topicDTO);
        final TopicDTO[] temp = {null} ;
//        log.info("-----> "+topicDTO.toString());
        dtoOptional.ifPresent(p->{
            dtoOptional.get().setName(topicDTO.getName().replace(" ","").toLowerCase());
            temp[0] = topicService.save(p);
            httpStatuses[0] = HttpStatus.OK;
        });
        return new ResponseEntity<>(temp[0], Optional.of(httpStatuses[0]).orElse(HttpStatus.CONFLICT));
    }
}
