package com.tranquyet.service.impl;

import com.tranquyet.converter.PublicVideoConverter;
import com.tranquyet.dto.PublicVideoDTO;
import com.tranquyet.entity.PublicVideoEntity;
import com.tranquyet.entity.TopicEntity;
import com.tranquyet.repository.PublicVideoEntityRepository;
import com.tranquyet.repository.TopicRepository;
import com.tranquyet.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    @Autowired
    private PublicVideoEntityRepository publicVideoEntityRepository;

    @Autowired
    private PublicVideoConverter publicVideoConverter;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<PublicVideoDTO> findAll() {
        List<PublicVideoDTO> publicVideoDTOList = publicVideoEntityRepository.findAll()
                .stream().filter(p->p.getDeleteTag()==1)
                .map(p->publicVideoConverter.toDTO(p))
                .collect(Collectors.toList());
        return publicVideoDTOList;
    }

    @Override
    public List<PublicVideoDTO> findByTopic(String topicName) {
        List<PublicVideoDTO> publicVideoDTOList = publicVideoEntityRepository.findByTopic(topicName)
                .stream().map(p->publicVideoConverter.toDTO(p))
                .collect(Collectors.toList());
        return publicVideoDTOList;
    }

    @Override
    public PublicVideoDTO getById(Long id) {
        Optional<PublicVideoDTO> publicVideoDTO = Optional.of(publicVideoEntityRepository.findOneById(id))
                .map(p->publicVideoConverter.toDTO(p));
        return publicVideoDTO.get();
    }

    @Override
    public PublicVideoDTO save(PublicVideoDTO dto) {
        TopicEntity topicEntity =topicRepository.findOneByName(dto.getTopicDTO().getName());
        PublicVideoEntity tempPublicVideo ;
        if(dto.getId()!=null){
            PublicVideoEntity oldPublicVideo = publicVideoEntityRepository.findOneById(dto.getId());
            oldPublicVideo = publicVideoConverter.toEntity(dto);
            oldPublicVideo.setTopicEntity(topicEntity);
            oldPublicVideo.setDeleteTag(1L);
            tempPublicVideo = oldPublicVideo;
        }else{
            tempPublicVideo = publicVideoConverter.toEntity(dto);
            tempPublicVideo.setTopicEntity(topicEntity);
            tempPublicVideo.setDeleteTag(1L);
        }
        return publicVideoConverter.toDTO(publicVideoEntityRepository.save(tempPublicVideo));
    }

    @Override
    public void delete(Long[] ids) {

    }
}
