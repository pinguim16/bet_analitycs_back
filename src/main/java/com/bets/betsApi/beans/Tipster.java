package com.bets.betsApi.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tipster")
public class Tipster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tipster", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("tipster")
    private List<Unit> units;

    private Double bingos;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    @JsonIgnoreProperties("tipster")
    private Sport sport;  // Relacionamento Many-to-One com Sport

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

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public Double getBingos() {
        return bingos;
    }

    public void setBingos(Double bingos) {
        this.bingos = bingos;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }


}
