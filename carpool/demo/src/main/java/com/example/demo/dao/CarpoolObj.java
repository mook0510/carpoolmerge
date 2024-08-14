package com.example.demo.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CarpoolObj {

    private int id;
    private String title;
    private String cnt;
    private int reg_seq;
    private String reg_dt;
    private int mod_seq;
    private String mod_dt;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCnt() {
        return cnt;
    }

    public int getReg_seq() {
        return reg_seq;
    }

    public String getReg_dt() {
        return reg_dt;
    }

    public int getMod_seq() {
        return mod_seq;
    }

    public String getMod_dt() {
        return mod_dt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public void setReg_seq(int reg_seq) {
        this.reg_seq = reg_seq;
    }

    public void setReg_dt(String reg_dt) {
        this.reg_dt = reg_dt;
    }

    public void setMod_seq(int mod_seq) {
        this.mod_seq = mod_seq;
    }

    public void setMod_dt(String mod_dt) {
        this.mod_dt = mod_dt;
    }
}
