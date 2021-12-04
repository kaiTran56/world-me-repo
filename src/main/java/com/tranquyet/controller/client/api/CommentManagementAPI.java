package com.tranquyet.controller.client.api;

import com.tranquyet.domain.MessageDomain;
import com.tranquyet.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/comment")
public class CommentManagementAPI {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{idVideo}")
    public ResponseEntity<List<MessageDomain>> getMessageByVideo(@PathVariable(name = "idVideo") Optional<Integer> idVideo){
        final HttpStatus[] httpStatuses = {null};
        List<MessageDomain> messageDomainList = commentService.findByVideo(idVideo.orElse(1));
//        log.info("---->"+messageDomainList);
        Optional<List<MessageDomain>> idVideoTemp = Optional.of(messageDomainList);
        idVideoTemp.ifPresent(p->{
            httpStatuses[0] = HttpStatus.OK;
        });
        return new ResponseEntity<>(idVideoTemp.orElse(null),
                Optional.of(httpStatuses[0]).orElse(HttpStatus.CONFLICT));
    }

}
