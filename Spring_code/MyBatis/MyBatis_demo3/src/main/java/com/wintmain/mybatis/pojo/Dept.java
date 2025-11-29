package com.wintmain.mybatis.pojo;

import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-01 21:40:13
 */
public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> emps;

    public Integer getDid() {
        return did;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public Dept() {
    }

    public Dept(Integer did, String deptName, List<Emp> emps) {
        this.did = did;
        this.deptName = deptName;
        this.emps = emps;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
