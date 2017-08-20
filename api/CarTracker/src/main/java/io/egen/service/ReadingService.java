package io.egen.service;

import io.egen.entity.Readings;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReadingService {
     void create(Readings readings);
     List<Readings> getReadings();
     List<Readings> findById(String vId);
     //void createAlerts( List<Readings> readings);
}
