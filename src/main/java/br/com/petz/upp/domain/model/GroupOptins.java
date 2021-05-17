package br.com.petz.upp.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
@Entity
@Table(name ="group_optins")
public class GroupOptins extends BaseEntity{

    private String groupName;

    private String description;

    //@OneToMany(mappedBy = "groupOptins")
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Optins> optins;

}
