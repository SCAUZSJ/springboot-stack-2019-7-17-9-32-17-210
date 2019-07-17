package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table
public class Procurator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long procuratorId;
    @Column(length = 255,nullable = false)
    private String name;

    public Procurator(){}
    public Procurator(String name) {
        this.name = name;
    }

    public Long getProcuratorId() {
        return procuratorId;
    }

    public void setProcuratorId(Long procuratorId) {
        this.procuratorId = procuratorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
