package com.tranquyet.converter;

import com.tranquyet.dto.PublicVideoDTO;
import com.tranquyet.entity.PublicVideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicVideoConverter implements IBasedConverter<PublicVideoEntity, PublicVideoDTO> {

    @Autowired
    private TopicConverter topicConverter;

    @Override
    public PublicVideoEntity toEntity(PublicVideoDTO dto) {
        PublicVideoEntity entity = new PublicVideoEntity();
        entity.setId(dto.getId());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setModifiedBy(dto.getModifiedBy());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setTitleVideo(dto.getTitleVideo());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setLinkVideo(dto.getLinkVideo());
        entity.setLinkImage(dto.getLinkImage());
//        entity.setLoveEntity(loveConverter.toEntity(dto.getLoveDTO()));
        entity.setTopicEntity(topicConverter.toEntity(dto.getTopicDTO()));
        return entity;
    }

    @Override
    public PublicVideoDTO toDTO(PublicVideoEntity entity) {
        PublicVideoDTO dto = new PublicVideoDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setTitleVideo(entity.getTitleVideo());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setLinkVideo(entity.getLinkVideo());
        dto.setLinkImage(entity.getLinkImage());
        dto.setTopicDTO(topicConverter.toDTO(entity.getTopicEntity()));
//        dto.setLoveDTO(loveConverter.toDTO(entity.getLoveEntity()));
        return dto;
    }
}
