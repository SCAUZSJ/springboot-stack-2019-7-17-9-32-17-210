package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courtId;
    @Column(length = 50)
    private String name;

    public Court(){}

    public Court(String name) {
        this.name = name;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
