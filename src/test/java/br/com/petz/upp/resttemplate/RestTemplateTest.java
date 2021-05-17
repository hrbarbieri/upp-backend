package br.com.petz.upp.resttemplate;

import br.com.petz.upp.domain.model.integration.Customers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RestTemplateTest {


    @Autowired
    RestTemplate restTemplate;


    @BeforeEach
    void setup() {
        assertNotNull(restTemplate);
    }

    @Test
    void call_cdm() {
        Customers customers = restTemplate.getForObject("https://dev-services.labpetz.com.br/cdm/v1/customers/{key}",
                Customers.class,
                "26412286888");

        Assert.assertNotNull(customers);
    }


}
