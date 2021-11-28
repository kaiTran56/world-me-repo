package com.tranquyet.service;

import com.tranquyet.dto.TopicDTO;

import java.util.List;

public interface TopicService {
    List<TopicDTO> findAll();

    TopicDTO getById(Long id);

    TopicDTO save(TopicDTO dto);

    void delete(Long[] ids);
}
