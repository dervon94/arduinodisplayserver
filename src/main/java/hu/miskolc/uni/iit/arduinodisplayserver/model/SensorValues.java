package hu.miskolc.uni.iit.arduinodisplayserver.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
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

    public SensorValues() {
    }

    public SensorValues(int rain, int temperature, int humidity, int light, String measuringDevId) {
        this.rain = rain;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.measuringDevId = measuringDevId;
        this.measuringTime = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeasuringDevId() {
        return measuringDevId;
    }

    public void setMeasuringDevId(String measuringDevId) {
        this.measuringDevId = measuringDevId;
    }

    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

//    public Date getMeasuringTime() {
//        return measuringTime;
//    }
//
//    public void setMeasuringTime(Date measuringTime) {
//        this.measuringTime = measuringTime;
//    }

    public String toString() {
        return "\"SensorValues\":{" +
                "\"id:\"" + id +
                ", \"measuringTime\":" + measuringTime.getTime() +
                ", \"rain\"=" + rain +
                ", \"temperature\"=" + temperature +
                ", \"humidity\"=" + humidity +
                ", \"light\"=" + light +
                '}';
    }
}
