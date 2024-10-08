package beans;

import jakarta.persistence.*;

@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double unitValue;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "tipster_id", nullable = false)
    private Tipster tipster;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Tipster getTipster() {
        return tipster;
    }

    public void setTipster(Tipster tipster) {
        this.tipster = tipster;
    }
}
