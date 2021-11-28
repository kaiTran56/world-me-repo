package com.tranquyet.service.impl;

import com.tranquyet.converter.CommentConverter;
import com.tranquyet.domain.MessageDomain;
import com.tranquyet.dto.CommentDTO;
import com.tranquyet.repository.CommentRepository;
import com.tranquyet.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentConverter commentConverter;

    @Override
    public List<CommentDTO> findAll() {
        List<CommentDTO> commentDTOList = commentRepository.findAll().stream()
                .map(p->commentConverter.toDTO(p)).collect(Collectors.toList());
        return commentDTOList;
    }

    @Override
    public List<MessageDomain> findByVideo(int idVideo) {
        List<MessageDomain> messageDomainList = commentRepository.findCommentByVideo(idVideo).stream().map(p->commentConverter.toDomain(p))
                .collect(Collectors.toList());
        return messageDomainList;
    }

    @Override
    public void customSaveMessage(MessageDomain messageDomain) {
        commentRepository.customInsert(1,messageDomain.getMessageContent(),
                messageDomain.getIdVideo(), messageDomain.getCreatedDate());
    }
}
