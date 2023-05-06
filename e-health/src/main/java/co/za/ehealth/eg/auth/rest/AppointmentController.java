package co.za.ehealth.eg.auth.rest;


import co.za.ehealth.eg.auth.entity.Appointment;
import co.za.ehealth.eg.auth.rest.impl.GenericController;
import co.za.ehealth.eg.auth.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("patient")
public class AppointmentController extends GenericController<AppointmentService, Appointment> {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        super(appointmentService);
        this.appointmentService = appointmentService;
    }

    @GetMapping("/doctor/{email}/{flag}")
    private List<Appointment> getDoctor(@PathVariable String email, @PathVariable char flag) {
        return this.appointmentService.findByEmail(email, flag);
    }
}
