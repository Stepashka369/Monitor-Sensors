package com.task.monitorsensors.controller;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.exception.ElementNotFoundException;
import com.task.monitorsensors.service.SensorService;
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
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRATOR', 'VIEWER')")
    public ResponseEntity<List<SensorDto>> getAll() {
        return new ResponseEntity<>(sensorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR', 'VIEWER')")
    public ResponseEntity<SensorDto> getById(@PathVariable UUID id) throws ElementNotFoundException {
        return new ResponseEntity<>(sensorService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}/{model}")
    @PreAuthorize("hasAnyRole('ADMINISTRATOR', 'VIEWER')")
    public ResponseEntity<List<SensorDto>> searchByNameAndModel(@PathVariable String name, @PathVariable String model) {
        return new ResponseEntity<>(sensorService.searchByNameAndModel(name, model), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<SensorDto> add(@RequestBody SensorDto dto) {
        return new ResponseEntity<>(sensorService.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        sensorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
