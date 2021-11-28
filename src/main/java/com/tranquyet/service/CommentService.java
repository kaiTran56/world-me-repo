package com.tranquyet.service;

import com.tranquyet.domain.MessageDomain;

import java.util.List;

public interface CommentService {

    List<MessageDomain> findByVideo(int idVideo);

    void customSaveMessage(MessageDomain messageDomain);

}
