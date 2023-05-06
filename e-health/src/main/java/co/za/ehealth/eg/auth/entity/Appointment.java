package co.za.ehealth.eg.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table( name = "APPOINTMENT", schema="E_HEALTH")
public class Appointment implements Serializable {
    private Long id;
    private ZonedDateTime effFrom;
    private ZonedDateTime effTo;
    private UserAccount patient;
    private UserAccount doctor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ZonedDateTime getEffFrom() {
        return effFrom;
    }

    public void setEffFrom(ZonedDateTime effFrom) {
        this.effFrom = effFrom;
    }

    public ZonedDateTime getEffTo() {
        return effTo;
    }

    public void setEffTo(ZonedDateTime effTo) {
        this.effTo = effTo;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public UserAccount getPatient() {
        return patient;
    }

    public void setPatient(UserAccount patient) {
        this.patient = patient;
    }


    @OneToOne(cascade =  CascadeType.ALL)
    public UserAccount getDoctor() {
        return doctor;
    }

    public void setDoctor(UserAccount doctor) {
        this.doctor = doctor;
    }
}
