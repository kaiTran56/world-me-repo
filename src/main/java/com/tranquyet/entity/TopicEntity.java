package com.tranquyet.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
@Getter
@Setter
public class TopicEntity extends BasedEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "topicEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PublicVideoEntity> publicVideoEntityList = new ArrayList<>();
}
