package co.za.ehealth.eg.auth.rest;

import co.za.ehealth.eg.auth.client.PersistenceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.health.eg.eheathservice.model.AccountType;
import za.co.health.eg.eheathservice.model.AuthDetails;

import java.security.MessageDigest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private PersistenceClient persistenceClient;

    public AuthenticationController(PersistenceClient persistenceClient) {
        this.persistenceClient = persistenceClient;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDetails> login(@RequestBody AuthDetails authDetails) throws Exception {
        final AuthDetails details = persistenceClient.getUser(authDetails.getUsername());
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] password = messageDigest.digest(authDetails.getPassword().getBytes());

        if (!password.equals(details.getPassword())) {
            return ResponseEntity.status(403).build();
        }
        //load permissions
        details.addPermissions(details.getAccountType());
        return ResponseEntity.ok(details);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthDetails> create(@RequestBody AuthDetails authDetails) {
        authDetails.setAccountType(AccountType.PATIENT);
        final AuthDetails authDetails1 = persistenceClient.createUser(authDetails);
        if (authDetails1 != null) {
            return ResponseEntity.ok(authDetails1);
        }
        return ResponseEntity.status(500).build();
    }
}
