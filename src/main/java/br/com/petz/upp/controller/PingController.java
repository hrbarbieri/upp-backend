package br.com.petz.upp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Ping/Pong", description = "Basic test for a call on the controller.")
@RestController
@RequestMapping(value = "/v1/ping")
public class PingController {

    @GetMapping
    public String ping() {
        return "Pong!";
    }

}
