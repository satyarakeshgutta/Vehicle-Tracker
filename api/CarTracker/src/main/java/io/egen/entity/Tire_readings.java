
package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Tire_readings {

    @Id
    private String tId;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public Tire_readings() {
        this.tId= UUID.randomUUID().toString();
    }

    public String getTire_Readingid() {
        return tId;
    }
    public void setTire_Readingid(String tId) {
        this.tId = tId;
    }
    public int getFrontLeft() {
        return frontLeft;
    }
    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}

