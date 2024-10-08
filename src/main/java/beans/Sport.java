package beans;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sports")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "sports")
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
