package co.za.ehealth.eg.auth.service;

import co.za.ehealth.eg.auth.entity.UserAccount;
import co.za.ehealth.eg.auth.repo.UserAccountRepository;
import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.health.eg.eheathservice.model.AccountType;
import za.co.health.eg.eheathservice.model.AuthDetails;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class AuthService extends GenericService<UserAccountRepository, UserAccount> {

    private UserAccountRepository userAccountRepository;

    public AuthService( UserAccountRepository userAccountRepository) {
        super(userAccountRepository);
        this.userAccountRepository = userAccountRepository;
    }


    public ResponseEntity<AuthDetails> login(AuthDetails authDetails) throws Exception {
        final AuthDetails details = findUser(authDetails.getEmail());
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        byte[] password = messageDigest.digest(authDetails.getPassword().getBytes());


        if (!Arrays.equals(password, details.getPasswordMd5())) {
            return ResponseEntity.status(403).build();
        }
        //load permissions
        details.addPermissions(details.getAccountType());
        return ResponseEntity.ok(details);
    }


    private AuthDetails createMockUsers() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        final AuthDetails res = AuthDetails.builder()
                .username("John")
                .accountType(AccountType.ADMIN)
                .passwordMd5(md.digest("mock123".getBytes()))
                .build();
        return res;
    }


    public AuthDetails findUser(String email){
        try {
            if (email.contains("mock")) {
                return createMockUsers();
            }
            final Optional<UserAccount> userAccount = userAccountRepository.findById(email);
            if (!userAccount.isPresent()) {
                return null;
            }
            final AuthDetails res = AuthDetails.builder()
                    .username(userAccount.get().getUserName())
                    .accountType(AccountType.getById(userAccount.get().getAccountType().getId()))
                    .password(userAccount.get().getPassword())
                    .build();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<AuthDetails> updateUser(@RequestBody AuthDetails authDetails) {
        try{
            final UserAccount userAccount = userAccountRepository.getOne(authDetails.getUsername());
            userAccount.setAccountType(UserAccount.AccountType.getById(authDetails.getAccountType().getId()));
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            userAccount.setPassword(String.valueOf(messageDigest.digest(authDetails.getPassword().getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(500).build();
    }

}
