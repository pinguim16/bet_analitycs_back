package com.bets.betsApi.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sport")
    @JsonIgnore
    private List<Tipster> tipsters;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tipster> getTipsters() {
        return tipsters;
    }

    public void setTipsters(List<Tipster> tipsters) {
        this.tipsters = tipsters;
    }
}
