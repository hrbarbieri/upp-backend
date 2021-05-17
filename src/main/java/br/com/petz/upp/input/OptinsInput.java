package br.com.petz.upp.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class OptinsInput implements Serializable {

    @NotBlank
    private String groupId;

    @Size(min = 4, max = 50)
    @NotBlank
    private String optinsName;

    @NotBlank
    private String description;

    private Boolean active;

}
