package co.za.ehealth.eg.auth.service;

import co.za.ehealth.eg.auth.entity.Patient;
import co.za.ehealth.eg.auth.repo.PatientRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PatientService extends GenericService<PatientRepository ,Patient, String> {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository repository) {
        super(repository);
        this.patientRepository = repository;
    }


    public Object createUser(String password, Patient item) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] pwd = messageDigest.digest(password.getBytes());
        item.getUserAccount().setPassword(pwd);
        return super.create(item);
    }

    @Override
    public Patient getOne(String s) throws Exception {
        return patientRepository.getAllByEmail(s).orElseThrow();
    }
}
