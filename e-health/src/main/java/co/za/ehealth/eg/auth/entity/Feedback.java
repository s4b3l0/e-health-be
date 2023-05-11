package co.za.ehealth.eg.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FEEDBACK", schema = "E_HEALTH")
public class Feedback implements Serializable {
    private Long id;
    private String title;

    private String text;
    private String doctor;
    private String patient;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
