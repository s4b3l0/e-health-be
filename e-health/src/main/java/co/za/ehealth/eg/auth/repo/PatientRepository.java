package co.za.ehealth.eg.auth.repo;

import co.za.ehealth.eg.auth.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
