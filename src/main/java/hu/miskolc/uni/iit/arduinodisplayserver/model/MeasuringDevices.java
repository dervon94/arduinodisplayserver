package hu.miskolc.uni.iit.arduinodisplayserver.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MeasuringDevices {
    @Id
    private String deviceId;
    private String ipAddres;
    private String position;

    public MeasuringDevices() {
    }

    public MeasuringDevices(String deviceId, String ipAddress, String position) {
        this.deviceId = deviceId;
        this.ipAddres = ipAddress;
        this.position = position;
    }

    @Override
    public String toString() {
        return "MeasuringDevices{" +
                "deviceId='" + deviceId + '\'' +
                ", ipAddres='" + ipAddres + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


}
