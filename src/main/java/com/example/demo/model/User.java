package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "lastname")
    private String administrator;

    protected User(){}


    public User(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;

    }

    public User(String firstName, String lastName, String login, String administrator){

        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.administrator = administrator;

    }



}
