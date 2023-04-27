package za.co.health.eg.eheathservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Disease implements Serializable {
    private String diseaseName;
    private Long diseaseId;
    private String diseaseType;
}
