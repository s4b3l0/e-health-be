package co.za.ehealth.eg.auth.service;


import co.za.ehealth.eg.auth.entity.Disease;
import co.za.ehealth.eg.auth.repo.DiseaseRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService extends GenericService<DiseaseRepository, Disease, String> {
    private DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        super(diseaseRepository);
        this.diseaseRepository = diseaseRepository;
    }

    public List<Disease> getByEmail(String email) {
        return diseaseRepository.getAllByPatient(email);
    }


}
