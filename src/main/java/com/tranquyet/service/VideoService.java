package com.tranquyet.service;

import com.tranquyet.dto.PublicVideoDTO;

import java.util.List;

public interface VideoService {

    List<PublicVideoDTO> findAll();

    List<PublicVideoDTO> findByTopic(String topicName);

    PublicVideoDTO getById(Long id);

    PublicVideoDTO save(PublicVideoDTO dto);

    void delete(Long[] ids);

}
