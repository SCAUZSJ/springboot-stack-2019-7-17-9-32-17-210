package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class LawCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long caseId;

    @Column(length = 255)
    private String name;

    private Timestamp happenTime;

    public LawCase(){}

    public LawCase(String name, Timestamp happenTime) {
        this.name = name;
        this.happenTime = happenTime;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Timestamp happenTime) {
        this.happenTime = happenTime;
    }
}
