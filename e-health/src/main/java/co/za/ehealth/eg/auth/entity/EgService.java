package co.za.ehealth.eg.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EGSERVICE", schema = "E_HEALTH")
public class EgService implements Serializable {
    private Long id;
    private String name;
    private String type;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
