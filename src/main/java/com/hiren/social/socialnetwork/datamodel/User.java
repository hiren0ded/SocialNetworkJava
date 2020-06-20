package com.hiren.social.socialnetwork.datamodel;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "MYUSER")
@Builder
/**
 * User DAO Class
 * This uses builder design pattern to provide immutability
 */
public class User {
    @Id
    @GeneratedValue(strategy=  GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique=true)
    private String userid;

    private String firstName;
    private String lastName;

    @Column(unique=true)
    private String email;
    private String salt;
    private String hashedPassword;

    @Column(unique=true)
    private String uuid;
}
