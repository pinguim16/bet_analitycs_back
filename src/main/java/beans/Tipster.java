package beans;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipsters")
public class Tipster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tipster", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Unit> units;

    private Double bingos;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
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
