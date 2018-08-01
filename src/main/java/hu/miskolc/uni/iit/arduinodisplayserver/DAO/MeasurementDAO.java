package hu.miskolc.uni.iit.arduinodisplayserver.DAO;

import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;

import java.util.List;

public interface MeasurementDAO {
    List<MeasuringDevice> listAllDevice();

    List<SensorValues> listSensorValuesByIpAddress(String ipAddress);
}
