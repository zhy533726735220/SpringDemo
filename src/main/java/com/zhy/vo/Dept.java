package com.zhy.vo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    private List<String> groups;
    private Map<Integer, String> testMap;

    private Properties testProperties;


    private List<Emp> testEmps;
    public Dept() {

    }

    public void setTestEmps(List<Emp> testEmps) {
        this.testEmps = testEmps;
    }

    public List<Emp> getTestEmps() {
        return testEmps;
    }

    public void setTestProperties(Properties testProperties) {
        this.testProperties = testProperties;
    }

    public Properties getTestProperties() {
        return testProperties;
    }

    public Map<Integer, String> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<Integer, String> testMap) {
        this.testMap = testMap;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", groups=" + groups +
                ", testMap=" + testMap +
                ", testProperties=" + testProperties +
                ", testEmps=" + testEmps +
                '}';
    }
}
