package com.tranquyet.repository;

import com.tranquyet.entity.PublicVideoEntity;
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
public interface PublicVideoEntityRepository extends JpaRepository<PublicVideoEntity, Long>, JpaSpecificationExecutor {

    PublicVideoEntity findOneById(Long id);


    @Query(value = "update video_public as pub set delete_tag = 0 where pub.id = :idVideo", nativeQuery = true)
    @Modifying
    void changeDeleteStatus(@Param("idVideo") long idVideo);

    @Query(value = "select * from video_public as vi " +
            "inner join topic as top " +
            "On vi.topic_id = top.id " +
            "where top.name =:topicName and top.delete_tag = 1 and vi.delete_tag = 1 " +
            "order by vi.id", nativeQuery = true)
    List<PublicVideoEntity> findByTopic(@Param("topicName") String topicName);

    @Query(value = "select * from video_public where delete_tag = 1 order by id", nativeQuery = true)
    List<PublicVideoEntity> findAll();

}
