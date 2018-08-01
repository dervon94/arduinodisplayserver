package hu.miskolc.uni.iit.arduinodisplayserver.service;


import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;

import java.util.List;

public interface DisplayService {
    List<MeasuringDevice> getallmeasureddata();

    List<SensorValues> getSensorValuesByIpAddress(String ipAdress);

}
