package br.com.petz.upp.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class GroupOptinsInput implements Serializable {

    @Size(min = 4, max = 50)
    @NotBlank
    private String groupName;

    @NotBlank
    private String description;

    private Boolean active = Boolean.TRUE;

}
