package br.com.petz.upp.domain.service;

import br.com.petz.upp.domain.exception.BusinessException;
import br.com.petz.upp.domain.exception.EntityNotFoundException;
import br.com.petz.upp.domain.model.CustomerOptins;
import br.com.petz.upp.domain.model.CustomerOptinsId;
import br.com.petz.upp.domain.model.Optins;
import br.com.petz.upp.domain.repository.CustomerOptinsRepository;
import br.com.petz.upp.domain.repository.OptinsRepository;
import br.com.petz.upp.input.FlagInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FlagOptinsService extends BaseService{

    @Autowired
    CustomerOptinsRepository customerOptinsRepository;

    @Autowired
    OptinsRepository optinsRepository;


    public CustomerOptins getFlag(String idCustomer, String idOptins) {

        UUID customerId = UUID.fromString(idCustomer);
        UUID optinsId = UUID.fromString(idOptins);

        return customerOptinsRepository.findById(new CustomerOptinsId(customerId, optinsId))
                .orElseThrow(() ->
                    new EntityNotFoundException(getMessageBundle("customerOptins.notFound", idCustomer, idOptins))
                );
    }


    /**
     * Atualiza um Optins ou cria uma novo
     *
     * @param flagInput
     */
    public void flagCustomerOptinsComplet(FlagInput flagInput) {

        UUID optinsId = UUID.fromString(flagInput.getOptinsId());
        UUID customerId = UUID.fromString(flagInput.getCustomerId());

        customerOptinsRepository.findById(new CustomerOptinsId(customerId, optinsId))
                .ifPresentOrElse(
                    (customerOptins) -> {
                        customerOptins.setUpdateDate(LocalDateTime.now());
                        customerOptins.setFlagOption(flagInput.getFlagOptions());
                        customerOptinsRepository.save(customerOptins);
                    },
                    () -> {
                        Optins optins = optinsRepository.findById(optinsId)
                                .orElseThrow(() -> new EntityNotFoundException(
                                        getMessageBundle("customerOptins.record", flagInput.getOptinsId())));
                        CustomerOptins customerOptins = new CustomerOptins();
                        customerOptins.setFlagOption(Boolean.TRUE);
                        customerOptins.setCreateDate(LocalDateTime.now());
                        customerOptins.setId(new CustomerOptinsId(customerId, optins.getId()));
                        customerOptinsRepository.save(customerOptins);
                    });


    }

    /**
     * Cria uma novo Optins
     *
     * @param flagInput
     */
    public void createCustomerOptinsComplet(FlagInput flagInput) {

        UUID optinsId = UUID.fromString(flagInput.getOptinsId());
        UUID customerId = UUID.fromString(flagInput.getCustomerId());

        customerOptinsRepository.findById(new CustomerOptinsId(customerId, optinsId))
                .ifPresentOrElse(
                        (customerOptins) -> {
                            throw new BusinessException(getMessageBundle("customerOptins.registered"));
                        },
                        () -> {
                            Optins optins = optinsRepository.findById(optinsId)
                                    .orElseThrow(() -> new EntityNotFoundException(
                                            getMessageBundle("customerOptins.record", flagInput.getOptinsId())));
                            CustomerOptins customerOptins = new CustomerOptins();
                            customerOptins.setFlagOption(Boolean.TRUE);
                            customerOptins.setCreateDate(LocalDateTime.now());
                            customerOptins.setId(new CustomerOptinsId(customerId, optins.getId()));
                            customerOptinsRepository.save(customerOptins);
                        });


    }


    /**
     * Atualiza um Optins ou cria uma novo
     *
     * @param flagInput
     */
    public void flagCustomerOptins(FlagInput flagInput) {

        UUID optinsId = UUID.fromString(flagInput.getOptinsId());
        UUID customerId = UUID.fromString(flagInput.getCustomerId());

        customerOptinsRepository.findById(new CustomerOptinsId(customerId, optinsId))
                .ifPresentOrElse(
                        (customerOptins) -> {
                            customerOptins.setUpdateDate(LocalDateTime.now());
                            customerOptins.setFlagOption(flagInput.getFlagOptions());
                            customerOptinsRepository.save(customerOptins);
                        },
                        () -> {
                             throw new EntityNotFoundException(
                                     getMessageBundle("customerOptins.register.notFound", flagInput.getOptinsId()));
                        });


    }


}
