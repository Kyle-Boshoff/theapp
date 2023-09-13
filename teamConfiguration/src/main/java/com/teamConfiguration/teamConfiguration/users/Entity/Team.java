package com.teamConfiguration.teamConfiguration.users.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name="team")

public class Team {

    @Id

    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

}
