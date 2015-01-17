package com.my.DB.DAO;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by azu on 15.01.2015.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "userid")
    Long userID;
    @Column(name = "name")
    String name;
    @Column(name = "info")
    String info;
    @Column(name = "password")
    String password;


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
