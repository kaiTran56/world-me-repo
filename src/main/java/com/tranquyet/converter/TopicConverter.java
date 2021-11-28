package com.tranquyet.converter;

import com.tranquyet.dto.TopicDTO;
import com.tranquyet.entity.TopicEntity;
import org.springframework.stereotype.Component;

@Component
public class TopicConverter implements IBasedConverter<TopicEntity, TopicDTO> {
    @Override
    public TopicEntity toEntity(TopicDTO dto) {
        TopicEntity entity = new TopicEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public TopicDTO toDTO(TopicEntity entity) {
        TopicDTO dto = new TopicDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setName(entity.getName());
        return dto;
    }
}
