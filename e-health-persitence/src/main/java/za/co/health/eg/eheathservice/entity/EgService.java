package za.co.health.eg.eheathservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "EGSERVICE", schema = "E_HEALTH")
public class EgService {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
