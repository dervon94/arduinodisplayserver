package hu.miskolc.uni.iit.arduinodisplayserver.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MeasuringDevice {
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "measuringDevId", orphanRemoval = true)
    private final Set<SensorValues> senvalModel = new HashSet<>();
    @Id
    private String deviceId;
    private String ipAddres;
    private String position;

    public MeasuringDevice() {

    }

    MeasuringDevice(final String deviceId, final String ipAddres, final String position) {
        this.deviceId = deviceId;
        this.ipAddres = ipAddres;
        this.position = position;
    }

    public MeasuringDevice(final String deviceId, final String ipAddres, final String position, final SensorValues senvalModel) {
        this.deviceId = deviceId;
        this.ipAddres = ipAddres;
        this.position = position;
        this.senvalModel.add(senvalModel);
    }

    public MeasuringDevice(final String deviceId, final String ipAddres, final String position, final int rain, final int temperature, final int humidity, final int light) {
        this.deviceId = deviceId;
        this.ipAddres = ipAddres;
        this.position = position;
        senvalModel.add(new SensorValues(deviceId, rain, temperature, humidity, light));
    }

    @Override
    public String toString() {
        return "DevModel{" +
                "deviceId='" + deviceId + '\'' +
                ", ipAddres='" + ipAddres + '\'' +
                ", position='" + position + '\'' +
                ", senvalModel=" + senvalModel +
                '}';
    }
}