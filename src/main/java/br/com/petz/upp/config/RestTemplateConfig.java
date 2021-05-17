package br.com.petz.upp.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    private final CloseableHttpClient httpClient;

    String bearerToken = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJhc20iLCJzdWIiOiJjZG0iLCJjYWRwZXR6LVgtQXV0aG9yaXphdGlvbiI6ImI" +
            "2MGNmNjY5ZTVhOTYxM2ViYmY0MzMzNmQ5ZmFjYzEyIiwiaWF0IjoxNjIxMjY4OTI5LCJleHAiOjE2MjEzNTUzMjl9.fNpDhHUEED2LEXz" +
            "5VQjBcffGJIqPeb4TIv2xRgoGT9gafAu9PZt-1AFVcqMLIGgBkuWXaine_Rwww75vagmJv8PkVvfPt2BJNJ8ay4Ds88k7_EJaAvJgS1RS" +
            "zt6dk_kXNk2rxwnCUb-M22kWHW2oN8tz6EsfU4MO9FLfAzymnEzM-k3oYekBIDnrytJ1q1xiIDjs4eDxXTB8aROFcz0K5ed7dM7v5zyFU" +
            "7qb23w1UGaIVx_KN59cr3QNhatB3-FVcKrpNT6dlae7_TGHsW0P1PFsOLMjikmQBVgTC7dun84I8ftpoUoufqjjWF6mXcpsUELTMQrIGR" +
            "WNiGHymlMEF9J1IAmAWyRORX0d2rtEpquwFvef9UoQKhBDire9dKUXQlQ2t-kr-g-ycYAF6btjr1HH9YcPlxrRbebLXax4H19ZU5miP6P" +
            "41Q8lJwFn6E1SIUXhWZd12wGmO4-i1BgWHxPgsHjNg6r4Iq13ONhvjPP0W92Rz0AYksei01PvrxU2RH9gVtJHCsqml9-KPdTIcA1T5krX" +
            "LZ4XU4m9ptCJ4-n_vuAAM_3ETTafqKU-inQL318Qz9uWG0Vy_lIO-CrR0LupA3fkPeDyaAFYa9lrvmatBBdpwNVRzTFKPAShHCaKb46rJ" +
            "4D3dJaZTRSo_mnBI37MFqmKHC8pBIkMNs6jy0c";

    @Autowired
    public RestTemplateConfig(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClient);
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .requestFactory(this::clientHttpRequestFactory)
                .errorHandler(new CustomClientErrorHandler())
                .interceptors(new CustomClientHttpRequestInterceptor(getHeader()))
                .build();
    }

    public HttpHeaders getHeader() {
        String token = bearerToken.toLowerCase().startsWith("bearer") ? bearerToken : "Bearer " + bearerToken;
        HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", Collections.singletonList(token));
        return headers;
    }

}
