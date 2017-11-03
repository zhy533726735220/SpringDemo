package com.zhy.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class VoTest implements Serializable{
    private Integer empno;
    private String ename;
    private Double sal;
    private Date hiredate;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "VoTest{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                ", hiredate=" + hiredate +
                '}';
    }
}
