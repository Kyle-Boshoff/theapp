package com.teamConfiguration.teamConfiguration.users.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="team")
    private Integer team;

    @ManyToOne
    @JoinColumn(name="team",insertable = false,updatable = false)
    private Team teamDetails;

    public void setId(Integer id) {
        this.id = id;
    }
}
