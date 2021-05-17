package br.com.petz.upp.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
@Entity
public class CustomerOptins {

    @JsonIgnore
    @EmbeddedId
    private CustomerOptinsId id;

    private Boolean flagOption;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
