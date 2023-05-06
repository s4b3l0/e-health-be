package co.za.ehealth.eg.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USER_ACCOUNT", schema = "E_HEALTH")
public class UserAccount implements Serializable {
    private String userName;
    private String password;

    private String email;

    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private AccountType accountType;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public enum AccountType {
        DOCTOR('D'),
        ADMIN('A'),
        PATIENT('P');

        private final char id;
        AccountType(char id) {
            this.id = id;
        }
        public char getId() {
            return id;
        }

        public static AccountType getById(char id) {
            for (AccountType a: values()) {
                if (a.id == id) {
                    return a;
                }
            }
            return null;
        }
    }
}
