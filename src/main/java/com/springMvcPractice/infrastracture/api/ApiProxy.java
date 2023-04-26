package com.springMvcPractice.infrastracture.api;

import com.springMvcPractice.infrastracture.api.config.ApiConfigProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class ApiProxy {

    private final ApiConfigProperty apiConfig;
    public WebClient baseWebClient() {
        return WebClient.builder().baseUrl(apiConfig.getBaseUrl()).build();
    }

    public Mono<String> getApiMonoJust() {
        return baseWebClient().get()
                .uri(apiConfig.getMonoJust().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiMonoZip() {
        return baseWebClient().get()
                .uri(apiConfig.getMonoZip().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiFluxJust() {
        return baseWebClient().get()
                .uri(apiConfig.getFluxJust().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiFluxZip() {
        return baseWebClient().get()
                .uri(apiConfig.getFluxZip().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiFluxInterval() {
        return baseWebClient().get()
                .uri(apiConfig.getFluxInterval().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

}
