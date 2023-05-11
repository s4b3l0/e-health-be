package co.za.ehealth.eg.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "PATIENT", schema="E_HEALTH")
public class Patient implements Serializable {
    private Long id;
    private String email;
    private UserAccount userAccount;
    private List<Disease> diseases;
    private List<EgService> egServices;
    private List<Feedback> feedbacks;
    private List<Appointment> appointments;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "S_EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<EgService> getEgServices() {
        return egServices;
    }

    public void setEgServices(List<EgService> egServices) {
        this.egServices = egServices;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}