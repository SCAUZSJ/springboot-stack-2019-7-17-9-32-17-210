package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courtId;
    @Column(length = 50,nullable = false,unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="court_id")
    private List<Procurator> procurators = new ArrayList<>();

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

    public List<Procurator> getProcurators() {
        return procurators;
    }

    public void setProcurators(List<Procurator> procurators) {
        this.procurators = procurators;
    }
}
