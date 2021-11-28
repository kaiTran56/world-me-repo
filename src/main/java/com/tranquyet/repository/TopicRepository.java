package com.tranquyet.repository;

import com.tranquyet.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TopicRepository extends JpaRepository<TopicEntity, Long>, JpaSpecificationExecutor {

    TopicEntity findOneByName(String name);

    TopicEntity findOneById(Long id);

    @Query(value = "select * from topic where delete_tag = 1", nativeQuery = true)
    List<TopicEntity> findAll();

    @Modifying
    @Query(value = "update topic as top set delete_tag = 0 where top.id = :idTopic", nativeQuery = true)
    void changeStatusOfDelete(@Param("idTopic") long id);

}
