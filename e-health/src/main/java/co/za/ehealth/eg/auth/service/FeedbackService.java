package co.za.ehealth.eg.auth.service;

import co.za.ehealth.eg.auth.entity.Feedback;
import co.za.ehealth.eg.auth.repo.FeedbackRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService extends GenericService<FeedbackRepository, Feedback> {

    private FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        super(feedbackRepository);
        this.feedbackRepository = feedbackRepository;
    }


    public List<Feedback> getByPatient(String email) {
        return feedbackRepository.findAllByPatient_Email(email);
    }

    public List<Feedback> getByDoctor(String email) {
        return feedbackRepository.findAllByDoctor_Email(email);
    }
}
