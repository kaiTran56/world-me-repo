package com.tranquyet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BasedEntity {

    @Column
    private String name;

    @ManyToMany(mappedBy = "roleEntityList")
    @JsonBackReference
    private List<UserEntity> userEntityList = new ArrayList<>();

}
