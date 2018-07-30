package hu.miskolc.uni.iit.arduinodisplayserver.DAO;

import hu.miskolc.uni.iit.arduinodisplayserver.model.MeasuringDevice;
import hu.miskolc.uni.iit.arduinodisplayserver.model.SensorValues;

import java.util.List;

public interface MeasuerementDAO {
    List<MeasuringDevice> listAllDevice();

    List<MeasuringDevice> listAllMeasurementWithDevices();

    List<MeasuringDevice> listAllMeasurement();

    List<SensorValues> listSensorValuesByIpAdress(String ipAdress);
}
