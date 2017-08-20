package io.egen.service;

import io.egen.entity.Alerts;
import io.egen.entity.Readings;

import java.util.List;

public interface AlertService {
     List<Alerts> getAlerts();
     List<Alerts> findAlerts(String vehicleId);
}
