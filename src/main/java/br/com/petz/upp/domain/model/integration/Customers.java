package br.com.petz.upp.domain.model.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

    private String uuid;

    private String creationDate;

    private String name;

    private String document;

    private String email;

    private String cellPhoneAreaCode;

    private String cellPhone;

    private String phoneAreaCode;

    private String phone;

    private String birthday;

    private String avatar;

    private Boolean subscriber;

}
