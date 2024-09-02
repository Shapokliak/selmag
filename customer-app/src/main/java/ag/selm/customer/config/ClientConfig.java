package ag.selm.customer.config;

import ag.selm.customer.client.WebClientProdutsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

    @Bean
    public WebClientProdutsClient webClientProdutsClient(@Value("${selmag.services.catalogue.uri:http://localhost:8080}") String baseUrl) {
        return new WebClientProdutsClient(WebClient.builder()
                .baseUrl(baseUrl)
                .build());
    }
}
