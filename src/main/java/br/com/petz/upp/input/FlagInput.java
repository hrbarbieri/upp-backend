package br.com.petz.upp.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FlagInput implements Serializable {

    @NotBlank
    private String optinsId;

    @NotBlank
    private String customerId;

    @NotNull
    private Boolean flagOptions;

}
