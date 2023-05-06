package co.za.ehealth.eg.auth.repo;

import co.za.ehealth.eg.auth.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByDoctor_Email(String email);
    List<Feedback> findAllByPatient_Email(String email);
}
