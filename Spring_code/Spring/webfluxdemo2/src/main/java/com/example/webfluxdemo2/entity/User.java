package com.example.webfluxdemo2.entity;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-02 23:56:29
 */
//实体类
public class User {
    private String name;
    private String gender;
    private Integer age;

    public User() {
    }

    public User(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }
}
