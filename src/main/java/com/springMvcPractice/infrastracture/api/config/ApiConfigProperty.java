package com.springMvcPractice.infrastracture.api.config;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("api")
@Setter
public class ApiConfigProperty {
    private Map<String,ApiProperty> mono;

    @Bean
    public ApiProperty getMonoJust(){return this.mono.get("mono-just");}
    @Bean
    public ApiProperty getMonoZip(){return this.mono.get("mono-zip");}
    @Bean
    public ApiProperty getFluxJust(){return this.mono.get("flux-just");}
    @Bean
    public ApiProperty getFluxZip(){return this.mono.get("flux-zip");}

    @Bean
    public ApiProperty getFluxInterval(){return this.mono.get("flux-interval");}

    @Data
    public static class ApiProperty{
        private String url;
    }
}
