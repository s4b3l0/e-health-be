package za.co.health.eg.eheathservice.model;

import lombok.Getter;

@Getter
public enum AccountType {
    DOCTOR('D'),
    ADMIN('A'),
    PATIENT('P');

    private char id;
    AccountType(char id) {
        this.id = id;
    }

    public static AccountType getById(char id) {
        for (AccountType a : values()) {
            if (a.id == id) return a;
        }
        return null;
    }
}
