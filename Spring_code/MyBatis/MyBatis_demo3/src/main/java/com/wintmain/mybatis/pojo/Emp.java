package com.wintmain.mybatis.pojo;

import java.io.Serializable;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-01 21:36:47
 */
public class Emp implements Serializable {

    private Integer eid;

    private String empName;

    private Integer age;

    private String sex;

    private String email;

    private Dept dept;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp() {
    }

    public Emp(Integer eid, String empName, Integer age, String sex, String email, Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }
}
