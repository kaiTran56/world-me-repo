package com.tranquyet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "video_public")
@Getter
@Setter
public class PublicVideoEntity extends BasedEntity{
    @Column
    private String titleVideo;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column
    private String duration;
    @Column(columnDefinition = "TEXT")
    private String linkVideo;
    @Column(columnDefinition = "TEXT")
    private String linkImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    @JsonBackReference
    private TopicEntity topicEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="love_id")
    @JsonBackReference
    private LoveEntity loveEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    @JsonBackReference
    private CommentEntity commentEntity;
}
