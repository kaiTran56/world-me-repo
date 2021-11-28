package com.tranquyet.service.impl;

import com.tranquyet.converter.TopicConverter;
import com.tranquyet.dto.TopicDTO;
import com.tranquyet.entity.TopicEntity;
import com.tranquyet.repository.TopicRepository;
import com.tranquyet.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicConverter topicConverter;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<TopicDTO> findAll() {
        List<TopicDTO> topicDTOList = topicRepository.findAll().stream()
                .map(p->topicConverter.toDTO(p))
                .collect(Collectors.toList());
        return Optional.of(topicDTOList).orElse(null);
    }

    @Override
    public TopicDTO getById(Long id) {
        String temp = null;
        return null;
    }

    @Override
    public TopicDTO save(TopicDTO dto) {
        TopicEntity temp;
        if(dto.getId()!=null){
            TopicEntity oldEntity = topicRepository.findOneById(dto.getId());
            oldEntity = topicConverter.toEntity(dto);
            temp = oldEntity;
        }else{
            temp = topicConverter.toEntity(dto);
        }
        temp.setDeleteTag(1L);
        return topicConverter.toDTO(topicRepository.save(temp));
    }

    @Override
    public void delete(Long[] ids) {
        for(long id : ids){
            topicRepository.changeStatusOfDelete(id);
        }
    }
}
