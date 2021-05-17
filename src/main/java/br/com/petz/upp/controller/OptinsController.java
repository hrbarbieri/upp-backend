package br.com.petz.upp.controller;

import br.com.petz.upp.controller.document.OptinsDocument;
import br.com.petz.upp.domain.model.GroupOptins;
import br.com.petz.upp.domain.model.Optins;
import br.com.petz.upp.domain.service.FlagOptinsService;
import br.com.petz.upp.domain.service.OptinsService;
import br.com.petz.upp.input.FlagInput;
import br.com.petz.upp.input.GroupOptinsInput;
import br.com.petz.upp.input.OptinsInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/optins")
public class OptinsController implements OptinsDocument {

    @Autowired
    FlagOptinsService flagOptinsService;

    @Autowired
    OptinsService optinsService;

    @GetMapping("/group/{groupId}")
    public ResponseEntity<?> group(@PathVariable String groupId) {
        GroupOptins groupOptins = optinsService.getGroupOptins(groupId);

        if(groupOptins != null) {
            return ResponseEntity.ok(groupOptins);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{optinsId}")
    public ResponseEntity<?> optins(@PathVariable String optinsId) {
        Optins optins = optinsService.getOptins(optinsId);

        if(optins != null) {
            return ResponseEntity.ok(optins);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/group")
    public  ResponseEntity<?> createGroup(@RequestBody @Valid GroupOptinsInput groupOptinsInput) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    optinsService.createGroupOptins(groupOptinsInput)
                );
    }

    @PutMapping("/group/{groupOptinsId}")
    public  ResponseEntity<?> updateGroup(@PathVariable String groupOptinsId, @RequestBody @Valid GroupOptinsInput groupOptinsInput) {
        optinsService.updateGroupOptins(groupOptinsId, groupOptinsInput);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public  ResponseEntity<?> createOptins(@RequestBody @Valid OptinsInput optinsInput) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        optinsService.createOptins(optinsInput)
                );
    }

    @PutMapping("/{optinsId}")
    public  ResponseEntity<?> updateOptins(@PathVariable String optinsId, @RequestBody @Valid OptinsInput optinsInput) {
        optinsService.updateOptins(optinsId, optinsInput);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/flag/customer/{customerId}/optins/{optinsId}")
    public ResponseEntity<?> flagByCustomer(@PathVariable String customerId, @PathVariable String optinsId) {
        return ResponseEntity.ok(
                flagOptinsService.getFlag(customerId, optinsId)
        );
    }

    @PostMapping("/flag")
    public ResponseEntity<?> createFlag(@RequestBody @Valid FlagInput flagInput) {
        flagOptinsService.createCustomerOptinsComplet(flagInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(flagInput);
    }


    @PutMapping("/flag")
    public ResponseEntity<?> updateFlag(@RequestBody @Valid FlagInput flagInput) {
        flagOptinsService.flagCustomerOptins(flagInput);
        return ResponseEntity.ok().build();
    }

}
