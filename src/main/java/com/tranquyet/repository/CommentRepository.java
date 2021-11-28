package com.tranquyet.repository;

import com.tranquyet.entity.CommentEntity;
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
public interface CommentRepository extends JpaRepository<CommentEntity, Long>, JpaSpecificationExecutor {

    @Query(value = "insert into comments (delete_tag, content, video_id, created_date) " +
            "values (:deleteTag, :content, :idVideo, :createdDate)", nativeQuery = true)
    @Modifying
    void customInsert(@Param("deleteTag") int deleteTag,
                      @Param("content") String content,
                      @Param("idVideo") int idVideo,
                      @Param("createdDate") String createdDate);

    @Query(value = "select * from comments where video_id = :idVideo", nativeQuery = true)
    List<CommentEntity> findCommentByVideo(@Param("idVideo") int idVideo);

}
