package br.com.petz.upp.controller.document;

import br.com.petz.upp.input.FlagInput;
import br.com.petz.upp.input.GroupOptinsInput;
import br.com.petz.upp.input.OptinsInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Opt-in/Opt-out ", description = "Sets customer acceptance flags")
public interface OptinsDocument {

    @Operation(summary = "You get a group of optins and their dependencies.")
    public ResponseEntity<?> group(
            @Parameter(description = "UUID for the upp.group_optins id") String groupId);


    @Operation(summary = "Get a certain optins.")
    public ResponseEntity<?> optins(
            @Parameter(description = "UUID for the upp.group_optins id")  String optinsId);


    @Operation(summary = "Creation of a new Opt-in / Opt-out group",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public  ResponseEntity<?> createGroup(
            @Parameter(description = "Object to insert a new Optins Group") GroupOptinsInput groupOptinsInput);


    @Operation(summary = "Updating an Opt-in / Opt-out group",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public  ResponseEntity<?> updateGroup(
            @Parameter(description = "UUID for the upp.group_optins id")  String groupOptinsId,
            @Parameter(description = "Object to update a new Optins Group")  GroupOptinsInput groupOptinsInput);


    @Operation(summary = "Creation of a new Opt-in / Opt-out",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public  ResponseEntity<?> createOptins(
            @Parameter(description = "Object to insert a new Optins")  OptinsInput optinsInput);


    @Operation(summary = "Updating an Opt-in / Opt-out",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseEntity<?> updateOptins(
            @Parameter(description = "UUID for the upp.optins id")  String optinsId,
            @Parameter(description = "Object to update a new Optins Group")  OptinsInput optinsInput);


    @Operation(summary = "Get the optins flag")
    public ResponseEntity<?> flagByCustomer(
            @Parameter(description = "UUID for the customer id") String customerId,
            @Parameter(description = "UUID for the optins id") String optinsId);


    @Operation(summary = "Creation of an Opt-in / Opt-out acceptance relationship",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseEntity<?> createFlag(
            @Parameter(description = "Object to insert a new customer acceptance with an optins.")  FlagInput flagInput);



    @Operation(summary = "Update of the Opt-in / Opt-out acceptance ratio",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)))
    public ResponseEntity<?> updateFlag(
            @Parameter(description = "Object to update an existing optins, also being able to deactivated.")  FlagInput flagInput);

}
