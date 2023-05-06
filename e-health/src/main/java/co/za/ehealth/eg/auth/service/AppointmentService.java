package co.za.ehealth.eg.auth.service;

import co.za.ehealth.eg.auth.entity.Appointment;
import co.za.ehealth.eg.auth.repo.AppointmentRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService extends GenericService<AppointmentRepository, Appointment> {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        super(appointmentRepository);
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findByEmail(String email, char type) {
        if (type == 'p') {
            return this.appointmentRepository.findAllByDoctor_Email(email);
        } else {
            return this.appointmentRepository.findAllByPatient_Email(email);
        }
    }

}
