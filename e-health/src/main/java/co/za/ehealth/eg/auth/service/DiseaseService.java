package co.za.ehealth.eg.auth.service;


import co.za.ehealth.eg.auth.entity.Disease;
import co.za.ehealth.eg.auth.repo.DiseaseRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService extends GenericService<DiseaseRepository, Disease> {
    private DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        super(diseaseRepository);
        this.diseaseRepository = diseaseRepository;
    }

}
