package co.za.ehealth.eg.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "DISEASE", schema="E_HEALTH")
public class Disease implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String patient;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
