package br.com.petz.upp.domain.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class CustomerOptinsId implements Serializable {

    @EqualsAndHashCode.Include
    private UUID customerId;

    @EqualsAndHashCode.Include
    private UUID optinsId;

}
