package io.egen.controller;

import io.egen.entity.Readings;
import io.egen.entity.Vehicle;
import io.egen.service.ReadingService;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class ReadingsController  {

    @Autowired
    private ReadingService readingService;

    @CrossOrigin(origins ="http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create( @RequestBody Readings readings) {
        readingService.create(readings);
        //readingService.getAlerts(readings);
    }

    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> getReadings() {
        return readingService.getReadings();
    }

    //GET readings by id
    @CrossOrigin(origins="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findReadingsByID(@PathVariable("id") String vehicleId) {
        return readingService.findById(vehicleId);
    }

}