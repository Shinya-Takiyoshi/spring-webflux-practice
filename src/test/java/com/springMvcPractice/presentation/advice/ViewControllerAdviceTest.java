package com.springMvcPractice.presentation.advice;

import com.springMvcPractice.infrastracture.api.ApiProxy;
import com.springMvcPractice.infrastracture.api.config.ApiConfigProperty;
import mockwebserver3.MockResponse;
import mockwebserver3.MockWebServer;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Ignore
class ApiProxyTest {
    private WebTestClient webClient;
    @Autowired
    private ApplicationContext context;
    private ApiProxy apiProxy;
    private ApiConfigProperty apiConfigProperty;

    public static MockWebServer mockServer;
    private static String baseUrl;

    @BeforeAll
    static void setUp() throws IOException {
        mockServer = new MockWebServer();
        mockServer.start();
        baseUrl = "http://localhost:" + mockServer.getPort();
    }

    @AfterAll
    static void tearDown() throws IOException {
        if (mockServer != null) {
            mockServer.shutdown();
        }
    }

    @BeforeEach
    void beforeEach() {
        this.webClient = WebTestClient.bindToApplicationContext(this.context).configureClient().baseUrl(baseUrl).build();
        apiConfigProperty = new ApiConfigProperty();
        apiConfigProperty.setBaseUrl(baseUrl);
        apiProxy = new ApiProxy(apiConfigProperty);
    }

    @Test
    void test() {
        mockServer.enqueue(new MockResponse()
                .setBody("mono-just"));
        Mono<String> response = apiProxy.getApiMonoJust();

        StepVerifier.create(response)
                // 要素の検証(fluxの場合には、メソッドチェーンで複数回実行)
                .expectNext("mono-just")
                // 要素がもうないことを検証
                .expectComplete()
                // 検証実行
                .verify();
    }
    @Test
    void monoJustReceive() {
    }

    @Test
    void monoZipReceive() {
    }

    @Test
    void fluxJustReceive() {
    }

    @Test
    void fluxZipReceive() {
    }
}