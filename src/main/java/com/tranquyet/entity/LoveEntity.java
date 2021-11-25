package com.tranquyet.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "love")
@Entity
@Getter
@Setter
public class LoveEntity extends BasedEntity{
    @Column
    private int totalLove;
    @OneToMany(mappedBy = "loveEntity")
    @JsonManagedReference
    private List<PublicVideoEntity> publicVideoEntityList = new ArrayList<>();
}
