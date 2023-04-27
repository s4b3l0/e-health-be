package za.co.health.eg.eheathservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Appointment implements Serializable {
    private String appointmentDate;
    private String appointmentType;
}
