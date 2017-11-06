package com.zhy.vo;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@XmlRootElement
public class Member implements Serializable {
    private Integer mid;
    private String name;
    private Double salary;
    private Date hirdate;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHirdate() {
        return hirdate;
    }

    public void setHirdate(Date hirdate) {
        this.hirdate = hirdate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", hirdate=" + hirdate +
                '}';
    }
}
