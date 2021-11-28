package com.tranquyet.converter;

import com.tranquyet.domain.MessageDomain;
import com.tranquyet.dto.CommentDTO;
import com.tranquyet.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter implements IBasedConverter<CommentEntity, CommentDTO> {

    @Override
    public CommentEntity toEntity(CommentDTO dto){
        CommentEntity entity = new CommentEntity();
        entity.setId(dto.getId());
        entity.setContent(dto.getContent());
        return entity;
    }
    @Override
    public CommentDTO toDTO(CommentEntity entity){
        CommentDTO dto = new CommentDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setContent(entity.getContent());
        return dto;
    }

    public MessageDomain toDomain(CommentEntity entity){
        MessageDomain domain = new MessageDomain();
        domain.setIdVideo(Math.toIntExact(entity.getPublicVideoEntity().getId()));
        domain.setMessageContent(entity.getContent());
        domain.setCreatedDate(entity.getCreatedDate());
        return domain;
    }

    public CommentEntity toEntity(MessageDomain domain){
        CommentEntity entity = new CommentEntity();

        return null;
    }

}
