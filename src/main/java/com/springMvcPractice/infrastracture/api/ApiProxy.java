package com.springMvcPractice.infrastracture.api;

import com.springMvcPractice.infrastracture.api.config.ApiConfigProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@RequiredArgsConstructor
public class ApiProxy {

    private final ApiConfigProperty apiConfig;

    public Mono<String> getApiMonoJust() {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(apiConfig.getMonoJust().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiMonoZip() {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(apiConfig.getMonoZip().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiFluxJust() {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(apiConfig.getFluxJust().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiFluxZip() {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(apiConfig.getFluxZip().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getApiFluxInterval() {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(apiConfig.getFluxInterval().getUrl())
                .retrieve()
                .bodyToMono(String.class);
    }

}
