package ag.selm.manager.config;

import ag.selm.manager.client.RestClientProductsRestClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientProductsRestClientImpl productsRestClient(@Value("${selmag.services.catalogue.url:http://localhost:8081}") String catalogueBaseUri) {
        return new RestClientProductsRestClientImpl(RestClient.builder()
                .baseUrl(catalogueBaseUri)
                .build());
    }
}
