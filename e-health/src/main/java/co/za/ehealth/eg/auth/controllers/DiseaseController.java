package co.za.ehealth.eg.auth.controllers;


import co.za.ehealth.eg.auth.entity.Disease;
import co.za.ehealth.eg.auth.controllers.impl.GenericController;
import co.za.ehealth.eg.auth.service.DiseaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("disease")
public class DiseaseController extends GenericController<DiseaseService, Disease, Long> {

    private DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        super(diseaseService);
        this.diseaseService = diseaseService;
    }

    @GetMapping("patient/{email}")
    public ResponseEntity<List<Disease>> getByPatientEmail(@PathVariable String email) {
        return ResponseEntity.ok(this.diseaseService.getByEmail(email));
    }
}
