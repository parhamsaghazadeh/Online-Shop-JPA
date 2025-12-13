package com.parham.online_shop.model;

import com.parham.online_shop.entity.Gender;
import com.parham.online_shop.entity.Role;
import com.parham.online_shop.entity.User;

import java.util.Date;

public class PersonModel {
    private long id;
    private String name;
    private String lastName;
    private String birthday;
    private User userId;
    private Gender genderId;
    private Role roleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}

