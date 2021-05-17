package br.com.petz.upp.domain.service;

import br.com.petz.upp.domain.exception.BusinessException;
import br.com.petz.upp.domain.exception.EntityNotFoundException;
import br.com.petz.upp.domain.model.CustomerOptins;
import br.com.petz.upp.domain.model.CustomerOptinsId;
import br.com.petz.upp.domain.model.GroupOptins;
import br.com.petz.upp.domain.model.Optins;
import br.com.petz.upp.domain.repository.CustomerOptinsRepository;
import br.com.petz.upp.domain.repository.GroupOptinsRepository;
import br.com.petz.upp.domain.repository.OptinsRepository;
import br.com.petz.upp.input.FlagInput;
import br.com.petz.upp.input.GroupOptinsInput;
import br.com.petz.upp.input.OptinsInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OptinsService extends BaseService{

    @Autowired
    GroupOptinsRepository groupOptinsRepository;

    @Autowired
    CustomerOptinsRepository customerOptinsRepository;

    @Autowired
    OptinsRepository optinsRepository;

    @Autowired
    ObjectMapper objectMapper;

    public GroupOptins getGroupOptins(String groupId) {
        return groupOptinsRepository
                .findById(UUID.fromString(groupId))
                .orElseThrow(() -> new EntityNotFoundException(
                        getMessageBundle("groupOptins.record", groupId)));
    }

    public Optins getOptins(String optinsId) {
        return optinsRepository
                .findById(UUID.fromString(optinsId))
                .orElseThrow(() -> new EntityNotFoundException(
                        getMessageBundle("optins.record", optinsId)));
    }

    public GroupOptins createGroupOptins(GroupOptinsInput  groupOptinsInput) throws BusinessException {

        groupOptinsRepository.findByGroupNameIgnoreCase(groupOptinsInput.getGroupName()).ifPresent(group -> {
            throw new BusinessException(getMessageBundle(
                    "groupOptins.name.exists", groupOptinsInput.getGroupName()));
        });

        GroupOptins groupOptins = objectMapper.convertValue(groupOptinsInput, GroupOptins.class);
        groupOptins.setActive(Boolean.TRUE);
        groupOptins.setCreateDate(LocalDateTime.now());
        groupOptinsRepository.save(groupOptins);

        return groupOptins;
    }

    public void updateGroupOptins(String groupOptinsId, GroupOptinsInput  groupOptinsInput) {

        UUID groupId = UUID.fromString(groupOptinsId);

        groupOptinsRepository.findById(groupId).ifPresentOrElse(group -> {

            BeanUtils.copyProperties(groupOptinsInput, group, "id");

            group.setUpdateDate(LocalDateTime.now());
            groupOptinsRepository.save(group);
        },
        () -> {
            throw new BusinessException(getMessageBundle("groupOptins.id.notExists", groupOptinsId));
        });
    }


    public Optins createOptins(OptinsInput optinsInput) {

        UUID groupId = UUID.fromString(optinsInput.getGroupId());

        Optins optins = new Optins();

        // Verifica a existencia do groupId informado
        groupOptinsRepository.findById(groupId).ifPresentOrElse(group ->
            {
                //optins.setGroupOptins(group);
                optins.setGroupId(group.getId());
            },
            () -> {
                throw new BusinessException(getMessageBundle("groupOptins.id.notExists", optinsInput.getGroupId()));
            }
        );

        // Verifica a existe o optinsName informado, se sim, não deixa criar
        optinsRepository.findByOptinsNameIgnoreCaseAndGroupId(optinsInput.getOptinsName(), groupId)
                .ifPresent(opt -> {
            throw new BusinessException(getMessageBundle("optins.name.exists", opt.getOptinsName(),
                    optinsInput.getGroupId()));
        });

        BeanUtils.copyProperties(optinsInput, optins, "groupOptinsId");
        optins.setActive(Boolean.TRUE);
        optins.setCreateDate(LocalDateTime.now());
        optinsRepository.save(optins);

        return optins;
    }


    public void updateOptins(String optId, OptinsInput optinsInput) {

        UUID groupId = UUID.fromString(optinsInput.getGroupId());
        UUID optinsId = UUID.fromString(optId);

        groupOptinsRepository.findById(groupId).ifPresentOrElse(
                group -> {

                    optinsRepository.findById(optinsId).ifPresentOrElse(optins -> {

                        BeanUtils.copyProperties(optinsInput, optins,  "id");
                        optins.setGroupId(groupId);
                        optins.setUpdateDate(LocalDateTime.now());
                        optinsRepository.save(optins);

                    },() -> {
                        throw new BusinessException(getMessageBundle("optins.not.exists", optId));
                    });
                },() -> {
                    throw new BusinessException(
                            getMessageBundle("groupOptins.id.notExists", optinsInput.getGroupId()));
                });
    }


}

