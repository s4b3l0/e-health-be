package co.za.ehealth.eg.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FEEDBACK", schema = "E_HEALTH")
public class Feedback implements Serializable {
    private Long id;
    private String name;
    private UserAccount doctor;
    private UserAccount patient;


    @Id
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

    @OneToOne(cascade = CascadeType.ALL)
    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public UserAccount getPatient() {
        return patient;
    }

    public void setPatient(UserAccount patient) {
        this.patient = patient;
    }
}
