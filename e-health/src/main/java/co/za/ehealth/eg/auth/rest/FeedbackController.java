package co.za.ehealth.eg.auth.rest;

import co.za.ehealth.eg.auth.entity.Feedback;
import co.za.ehealth.eg.auth.rest.impl.GenericController;
import co.za.ehealth.eg.auth.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("feedback")
public class FeedbackController extends GenericController<FeedbackService, Feedback> {
    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        super(feedbackService);
        this.feedbackService = feedbackService;
    }

    @GetMapping ("/doctor/{email}")
    private List<Feedback> getDoctor(@PathVariable String email) {
        return this.feedbackService.getByDoctor(email);
    }

    @GetMapping ("/patient/{email}")
    private List<Feedback> getPatient(@PathVariable String email) {
        return this.feedbackService.getByPatient(email);
    }

}
