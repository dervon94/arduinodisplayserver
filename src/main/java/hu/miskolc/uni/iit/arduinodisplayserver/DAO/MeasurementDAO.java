package hu.miskolc.uni.iit.arduinodisplayserver.DAO;

import hu.miskolc.uni.iit.arduinodisplayserver.controller.MeasuringType;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;

import java.util.Calendar;
import java.util.List;

public interface MeasurementDAO {
    List<MeasuringDevice> listAllDevice();

    List<SensorValues> listSensorValuesByIpAddress(String ipAddress);

    List<ResultData> listSpecifiedSensorValueBetweenDates(Calendar begin, Calendar end, String deviceId, MeasuringType type);
}
