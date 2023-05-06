package co.za.ehealth.eg.auth.repo;

import co.za.ehealth.eg.auth.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByPatient_Email(String email);
    List<Appointment> findAllByDoctor_Email(String email);
}
