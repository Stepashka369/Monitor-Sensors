package com.task.monitorsensors.controller;

import com.task.monitorsensors.dto.SensorDto;
import com.task.monitorsensors.mapper.SensorMapper;
import com.task.monitorsensors.repositopy.SensorRepository;
import com.task.monitorsensors.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity(sensorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}/{model}")
    public ResponseEntity<SensorDto> getByNameAndModel(@PathVariable String name, @PathVariable String model){
        return new ResponseEntity(sensorService.getByNameAndModel(name, model), HttpStatus.OK);
    }

    @GetMapping("search/{name}/{model}")
    public ResponseEntity<List<SensorDto>> searchByNameAndModel(@PathVariable String name, @PathVariable String model){
        return new ResponseEntity(sensorService.searchByNameAndModel(name, model), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SensorDto> add(@RequestBody SensorDto dto){
        return new ResponseEntity(sensorService.save(dto) , HttpStatus.CREATED);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable Long id){
//        return ;
//    }
}
