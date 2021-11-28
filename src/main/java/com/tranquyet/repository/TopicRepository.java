package com.tranquyet.repository;

import com.tranquyet.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TopicRepository extends JpaRepository<TopicEntity, Long>, JpaSpecificationExecutor {

    TopicEntity findOneByName(String name);

}
