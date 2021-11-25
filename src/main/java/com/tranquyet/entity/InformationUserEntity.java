package com.tranquyet.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


public class InformationUserEntity extends BasedEntity {

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String dob;
}
