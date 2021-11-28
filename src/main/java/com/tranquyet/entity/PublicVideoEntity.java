package com.tranquyet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "publicVideoEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CommentEntity> commentEntityList = new ArrayList<>();
}
