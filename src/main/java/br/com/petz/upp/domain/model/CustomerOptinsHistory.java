package br.com.petz.upp.domain.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
public class CustomerOptinsHistory {

    @EmbeddedId
    private CustomerOptinsId id;

    private Boolean flagOption;

    private LocalDateTime createDate;

}
