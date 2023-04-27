package za.co.health.eg.eheathservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class Service implements Serializable {
    private String serviceName;
    private String serviceType;
    private String serviceId;

}
