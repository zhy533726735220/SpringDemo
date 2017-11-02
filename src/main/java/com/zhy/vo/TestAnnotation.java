package com.zhy.vo;

public class TestAnnotation {

    private String sA;

    private Integer Ib;

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public Integer getIb() {
        return Ib;
    }

    public void setIb(Integer ib) {
        Ib = ib;
    }

    @Override
    public String toString() {
        return "TestAnnotation{" +
                "sA='" + sA + '\'' +
                ", Ib=" + Ib +
                '}';
    }
}
