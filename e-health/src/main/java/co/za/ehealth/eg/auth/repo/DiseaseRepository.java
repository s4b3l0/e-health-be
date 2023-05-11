package co.za.ehealth.eg.auth.repo;

import co.za.ehealth.eg.auth.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    List<Disease> getAllByPatient(String email);
}
