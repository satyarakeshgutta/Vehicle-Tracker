package io.egen.controller;

import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    //POST & PUT Combined
    @CrossOrigin(origins ="http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody List<Vehicle> vehicle) {
        service.createOrUpdate(vehicle);
    }

    // GET all vehicles
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    //GET vehicle by id
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("id") String vehicleId) {
        return service.findOne(vehicleId);
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String vehicleId) {
        service.delete(vehicleId);
    }
}


