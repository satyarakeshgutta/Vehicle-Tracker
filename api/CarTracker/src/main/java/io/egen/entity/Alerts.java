package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Alerts.findAll",
                query = "SELECT alerts FROM Alerts alerts "),

        @NamedQuery(name = "Alerts.findById",
                query = "SELECT alerts FROM Alerts alerts WHERE alerts.vehicleId=:vehicle_id"),
})

public class Alerts {

    @Id
    private String alertId;
    private String priority_RPM;
    private String priority_fuelVolume;
    private String priority_tirePressure;
    private String priority_engineStatus;
    private String vehicleId;
    private String alertTime;

    public Alerts() {
        this.alertId= UUID.randomUUID().toString();
    }

    public String getPriority_RPM() {
        return priority_RPM;
    }

    public void setPriority_RPM(String priority_RPM) {
        this.priority_RPM = priority_RPM;
    }

    public String getPriority_fuelVolume() {
        return priority_fuelVolume;
    }

    public void setPriority_fuelVolume(String priority_fuelVolume) {
        this.priority_fuelVolume = priority_fuelVolume;
    }

    public String getPriority_tirePressure() {
        return priority_tirePressure;
    }

    public void setPriority_tirePressure(String priority_tirePressure) {
        this.priority_tirePressure = priority_tirePressure;
    }

    public String getPriority_engineStatus() {
        return priority_engineStatus;
    }

    public void setPriority_engineStatus(String priority_engineStatus) {
        this.priority_engineStatus = priority_engineStatus;
    }
    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime;
    }
}


