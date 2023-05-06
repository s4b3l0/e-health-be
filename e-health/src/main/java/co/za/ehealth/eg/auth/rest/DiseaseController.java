package co.za.ehealth.eg.auth.rest;


import co.za.ehealth.eg.auth.entity.Disease;
import co.za.ehealth.eg.auth.rest.impl.GenericController;
import co.za.ehealth.eg.auth.service.DiseaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("disease")
public class DiseaseController extends GenericController<DiseaseService, Disease> {

    private DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        super(diseaseService);
        this.diseaseService = diseaseService;
    }
}
