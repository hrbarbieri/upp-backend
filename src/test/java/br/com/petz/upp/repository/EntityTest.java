package br.com.petz.upp.repository;

import br.com.petz.upp.domain.model.*;
import br.com.petz.upp.domain.repository.CustomerOptinsRepository;
import br.com.petz.upp.domain.repository.CustomerOptionsHistoryRepository;
import br.com.petz.upp.domain.repository.GroupOptinsRepository;
import br.com.petz.upp.domain.repository.OptinsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
public class EntityTest {

    @Autowired
    private GroupOptinsRepository groupOptinsRepository;

    @Autowired
    private OptinsRepository optinsRepository;

    @Autowired
    private CustomerOptinsRepository customerOptinsRepository;

    @Autowired
    private CustomerOptionsHistoryRepository customerOptionsHistoryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void entity_mapping() {

        // Group Optins
        GroupOptins groupOptins = new GroupOptins();
        groupOptins.setActive(Boolean.TRUE);
        groupOptins.setCreateDate(LocalDateTime.now());
        groupOptins.setGroupName("New Group");
        groupOptins.setDescription("Grupo Novo");
        groupOptinsRepository.save(groupOptins);

        // Optins
        Optins optins = new Optins();
        optins.setOptinsName("Transacional");
        optins.setGroupId(groupOptins.getId()); //optins.setGroupOptins(groupOptins);
        optins.setDescription("Descrição do Optins");
        optins.setActive(Boolean.TRUE);
        optins.setCreateDate(LocalDateTime.now());
        optins.setUpdateDate(LocalDateTime.now());
        optinsRepository.save(optins);


        // Relação Customer com Optins
        CustomerOptins customerOptins = new CustomerOptins();
        customerOptins.setFlagOption(Boolean.TRUE);
        customerOptins.setCreateDate(LocalDateTime.now());
        customerOptins.setId(new CustomerOptinsId(UUID.randomUUID(), optins.getId()));
        customerOptinsRepository.save(customerOptins);

        // History
        CustomerOptinsHistory customerOptinsHistory = objectMapper.convertValue(
                customerOptins, CustomerOptinsHistory.class);
        customerOptionsHistoryRepository.save(customerOptinsHistory);


        Assert.assertNotNull(groupOptins.getId());
        Assert.assertNotNull(optins.getId());

        CustomerOptins customerOptins1 = customerOptinsRepository.findById(customerOptins.getId()).get();
        Assert.assertNotNull(customerOptins1);

        CustomerOptinsHistory customerOptinsHistory1 = customerOptionsHistoryRepository
                .findById(customerOptins.getId()).get();
        Assert.assertNotNull(customerOptinsHistory1);

        Optins Optins1 = optinsRepository.findById(optins.getId()).get();
        Assert.assertNotNull(Optins1.getGroupId());


        // Remove test
        customerOptionsHistoryRepository.delete(customerOptinsHistory);
        customerOptinsRepository.delete(customerOptins);
        optinsRepository.delete(optins);
        groupOptinsRepository.delete(groupOptins);
    }



}
