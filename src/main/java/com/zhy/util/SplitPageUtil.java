package com.zhy.util;

public class SplitPageUtil {
    private Integer cp = 1;
    private Integer ls = 5;
    private String col;
    private String kw;

    public void setCol(String col) {
        this.col = col;
    }

    public void setCp(String cp) {
        try {
            this.cp = Integer.parseInt(cp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public void setLs(String ls) {
        try {
            this.ls = Integer.parseInt(ls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getCurrentpage() {
        return cp;
    }

    public Integer getLineSize() {
        return ls;
    }

    public String getColumn() {
        return col;
    }

    public String getKeyword() {
        return kw;
    }
}
