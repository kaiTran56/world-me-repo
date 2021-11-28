package com.tranquyet.service.impl;

import com.tranquyet.converter.TopicConverter;
import com.tranquyet.dto.TopicDTO;
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
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
