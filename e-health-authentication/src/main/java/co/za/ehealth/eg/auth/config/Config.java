package co.za.ehealth.eg.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
@Setter
public class Config {

    @Value("${persistence.url}")
    private String persistenceUrl;

    @Bean
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

}
