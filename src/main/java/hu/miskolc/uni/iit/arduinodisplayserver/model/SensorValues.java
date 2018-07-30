package hu.miskolc.uni.iit.arduinodisplayserver.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "SensoreValuesTable")
public class SensorValues {
    @Id
    @GeneratedValue
    private int id;
    private String measuringDevId;
    private Calendar measuringTime = null;
    private int rain;
    private int temperature;
    private int humidity;
    private int light;
    @ManyToOne
    private MeasuringDevice devModel;

    public SensorValues() {
    }

    SensorValues(final String measuringDevId, final int rain, final int temperature, final int humidity, final int light) {
        this.measuringDevId = measuringDevId;
        measuringTime = Calendar.getInstance();
        this.rain = rain;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
    }

    public SensorValues(final String deviceId, final String ipAddres, final String position, final int rain, final int temperature, final int humidity, final int light) {
        measuringDevId = deviceId;
        measuringTime = Calendar.getInstance();
        this.rain = rain;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        devModel = new MeasuringDevice(deviceId, ipAddres, position);
    }


    @Override
    public String toString() {
        return "SenvalModel{" +
                "id=" + id +
                ", measuringDevId='" + measuringDevId + '\'' +
                ", measuringTime=" + measuringTime.getTime() +
                ", rain=" + rain +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", light=" + light +
                '}';
    }
}
