package com.tranquyet.service;

import com.tranquyet.domain.MessageDomain;
import com.tranquyet.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findAll();

    List<MessageDomain> findByVideo(int idVideo);

    void customSaveMessage(MessageDomain messageDomain);

}
