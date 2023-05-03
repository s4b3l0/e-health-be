package za.co.health.eg.eheathservice.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.health.eg.eheathservice.entity.UserAccount;
import za.co.health.eg.eheathservice.model.AccountType;
import za.co.health.eg.eheathservice.model.AuthDetails;
import za.co.health.eg.eheathservice.repo.UserAccountRepository;

import java.security.MessageDigest;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("users")
public class UserAccountController {

    private UserAccountRepository userAccountRepository;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @PutMapping("/update")
    public ResponseEntity<AuthDetails> updateUser(@RequestBody AuthDetails authDetails) {
        try {
            final UserAccount userAccount = userAccountRepository.getOne(authDetails.getUsername());
            userAccount.setAccountType(UserAccount.AccountType.getById(authDetails.getAccountType().getId()));
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            userAccount.setPassword(String.valueOf(messageDigest.digest(authDetails.getPassword().getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(500).build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<AuthDetails> findUser(@PathVariable("email") String email){
        try {

            final Optional<UserAccount> userAccount = userAccountRepository.findById(email);
            if (!userAccount.isPresent()) {
                return ResponseEntity.noContent().build();
            }
            final AuthDetails res = AuthDetails.builder()
                    .username(userAccount.get().getUserName())
                    .accountType(AccountType.getById(userAccount.get().getAccountType().getId()))
                    .password(userAccount.get().getPassword())
                    .build();
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(500).build();
    }


    @PostMapping("")
    public ResponseEntity createUser(@RequestBody AuthDetails authDetails) {
        try {
            final UserAccount userAccount = new UserAccount();
            userAccount.setPassword(authDetails.getPassword());
            userAccount.setUserName(authDetails.getUsername());
            userAccount.setEmail(authDetails.getEmail());
            userAccount.setAccountType(UserAccount.AccountType.getById(authDetails.getAccountType().getId()));
            final UserAccount res = userAccountRepository.save(userAccount);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(500).build();
    }

}
