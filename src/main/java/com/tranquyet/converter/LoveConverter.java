package com.tranquyet.converter;

import com.tranquyet.dto.LoveDTO;
import com.tranquyet.entity.LoveEntity;
import org.springframework.stereotype.Component;

@Component
public class LoveConverter implements IBasedConverter<LoveEntity, LoveDTO> {
    @Override
    public LoveEntity toEntity(LoveDTO dto) {
        LoveEntity entity = new LoveEntity();
        entity.setId(dto.getId());
        entity.setTotalLove(dto.getTotalLove());
        return null;
    }

    @Override
    public LoveDTO toDTO(LoveEntity entity) {
        LoveDTO dto = new LoveDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setTotalLove(entity.getTotalLove());
        return dto;
    }


}
