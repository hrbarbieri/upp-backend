package br.com.petz.upp.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
@Entity
public class Optins extends BaseEntity {

    /*@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupOptins groupOptins;*/

    @Column(name = "group_id")
    private UUID groupId;

    private String optinsName;

    private String description;

}
