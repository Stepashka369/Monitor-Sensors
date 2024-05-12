package com.task.monitorsensors.controller;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.exception.ElementAlreadyExistsException;
import com.task.monitorsensors.exception.ElementNotFoundException;
import com.task.monitorsensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService){
        this.sensorService = sensorService;
    }

    @GetMapping
    public ResponseEntity<List<SensorDto>> getAll(){
        return new ResponseEntity<>(sensorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}/{model}")
    public ResponseEntity<SensorDto> getByNameAndModel(@PathVariable String name,
                                                       @PathVariable String model) throws ElementNotFoundException {
        return new ResponseEntity<>(sensorService.getByNameAndModel(name, model), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<List<SensorDto>> searchByNameAndModel(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) String model){
        return new ResponseEntity<>(sensorService.searchByNameAndModel(name, model), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SensorDto> add(@RequestBody SensorDto dto) throws ElementAlreadyExistsException, MethodArgumentNotValidException {
        return new ResponseEntity<>(sensorService.save(dto) , HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}/{model}")
    public ResponseEntity<Void> delete(@PathVariable String name, @PathVariable String model){
        sensorService.deleteByNameAndModel(name, model);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
