package com.task.monitorsensors.controller;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.exception.ElementNotFoundException;
import com.task.monitorsensors.service.SensorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sensors")
@Tag(name = "Sensor controller", description = "Perform CRUD operation with sensors")
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATOR', 'VIEWER')")
    @Operation(summary = "Retrieve all sensors from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = SensorDto.class)),
                    mediaType = "application/json")),
            @ApiResponse(responseCode = "403", content = @Content, description = "User not authorized")
    })
    public ResponseEntity<List<SensorDto>> getAll() {
        return new ResponseEntity<>(sensorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR', 'VIEWER')")
    @Operation(summary = "Retrieve a sensor by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = SensorDto.class),
                    mediaType = "application/json")),
            @ApiResponse(responseCode = "403", content = @Content, description = "User not authorized"),
            @ApiResponse(responseCode = "404", content = @Content, description = "Element not found")
    })
    public ResponseEntity<SensorDto> getById(@Parameter(name = "id", description = "Sensor's id")
                                                 @PathVariable UUID id) throws ElementNotFoundException {
        return new ResponseEntity<>(sensorService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}/{model}")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR', 'VIEWER')")
    @Operation(summary = "Retrieve a sensor list corresponding to the search parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = SensorDto.class)),
                    mediaType = "application/json")),
            @ApiResponse(responseCode = "403", content = @Content, description = "User not authorized")
    })
    public ResponseEntity<List<SensorDto>> searchByNameAndModel(
            @Parameter(name = "name", description = "First search parameter") @PathVariable String name,
            @Parameter(name = "model", description = "Second search parameter") @PathVariable String model) {
        return new ResponseEntity<>(sensorService.searchByNameAndModel(name, model), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @Operation(summary = "Add sensor to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    content = @Content(schema = @Schema(implementation = SensorDto.class),
                    mediaType = "application/json")),
            @ApiResponse(responseCode = "400", content = @Content, description = "Validation error"),
            @ApiResponse(responseCode = "403", content = @Content, description = "User not authorized")
    })
    public ResponseEntity<SensorDto> add(@Parameter(name = "dto", content = @Content(schema = @Schema(implementation = SensorDto.class)))
                                             @RequestBody SensorDto dto) {
        return new ResponseEntity<>(sensorService.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @Operation(summary = "Delete sensor from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", content = @Content),
            @ApiResponse(responseCode = "403", content = @Content)
    })
    public ResponseEntity<Void> delete(@Parameter(name = "id", description = "Sensor's id") @PathVariable UUID id) {
        sensorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
