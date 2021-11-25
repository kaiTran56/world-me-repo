package com.tranquyet.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BasedEntity {

    @Column
    private String username;

    @Column
    private String idFacebook;

    @Column
    private String gmail;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id", columnDefinition = "INT"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<RoleEntity> roleEntityList = new ArrayList<>();

}
