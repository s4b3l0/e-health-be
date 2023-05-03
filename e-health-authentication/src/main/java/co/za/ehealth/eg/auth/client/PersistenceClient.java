package co.za.ehealth.eg.auth.client;

import co.za.ehealth.eg.auth.config.Config;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.health.eg.eheathservice.model.AuthDetails;

@Service
public class PersistenceClient {

    private Config config;
    private RestTemplate restTemplate;

    public PersistenceClient(Config config, RestTemplate restTemplate) {
        this.config = config;
        this.restTemplate = restTemplate;
    }

    public AuthDetails getUser(String username) {
        String url = String.format("%s%s/%s", config.getPersistenceUrl(), "users",username);
        final ResponseEntity<AuthDetails> authDetailsResponseEntity = restTemplate.getForEntity(url, AuthDetails.class);
        if (!authDetailsResponseEntity.getStatusCode().is2xxSuccessful()) {
            throw new InternalError(String.valueOf(authDetailsResponseEntity.getStatusCode()));
        }
        return authDetailsResponseEntity.getBody();
    }

    public AuthDetails createUser(AuthDetails authDetails) {
        String url = String.format("%s%s", config.getPersistenceUrl(), "users");
        final ResponseEntity<AuthDetails> authDetailsResponseEntity = restTemplate.postForEntity(url, authDetails, AuthDetails.class);
        if (!authDetailsResponseEntity.getStatusCode().is2xxSuccessful()) {
            throw new InternalError(String.valueOf(authDetailsResponseEntity.getStatusCode()));
        }
        return authDetailsResponseEntity.getBody();
    }
}
