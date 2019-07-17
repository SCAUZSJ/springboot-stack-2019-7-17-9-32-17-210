package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table
public class CrimeDetailInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long crimeDetailId;

    private String subInfoDes;

    private String objInfoDes;

    public CrimeDetailInfo(){}

    public CrimeDetailInfo(String subInfoDes, String objInfoDes) {
        this.subInfoDes = subInfoDes;
        this.objInfoDes = objInfoDes;
    }

    public Long getCrimeDetailId() {
        return crimeDetailId;
    }

    public void setCrimeDetailId(Long crimeDetailId) {
        this.crimeDetailId = crimeDetailId;
    }

    public String getSubInfoDes() {
        return subInfoDes;
    }

    public void setSubInfoDes(String subInfoDes) {
        this.subInfoDes = subInfoDes;
    }

    public String getObjInfoDes() {
        return objInfoDes;
    }

    public void setObjInfoDes(String objInfoDes) {
        this.objInfoDes = objInfoDes;
    }
}
