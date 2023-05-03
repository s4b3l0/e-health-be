package za.co.health.eg.eheathservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDetails {

    private String username;
    private String email;
    private String password;
    private List<AccountType> permissions = new ArrayList<>();
    //TODO: add data to tokens
    private String token;
    private String session;
    private AccountType accountType;

    public void addPermissions(AccountType accountType) {
        if (accountType == null) return;
        switch (accountType.getId()) {
            case 'A':
                this.permissions.add(AccountType.ADMIN);
            case 'D':
                this.permissions.add(AccountType.DOCTOR);
            case 'P' :
                this.permissions.add(AccountType.PATIENT);
                break;
            default:
                return;
        }
    }

}
