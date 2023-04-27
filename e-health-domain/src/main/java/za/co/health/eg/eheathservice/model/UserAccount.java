package za.co.health.eg.eheathservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserAccount implements Serializable {
    private String firstname;
}
