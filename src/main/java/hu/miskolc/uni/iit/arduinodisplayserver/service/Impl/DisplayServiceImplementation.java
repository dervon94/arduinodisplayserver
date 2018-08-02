package hu.miskolc.uni.iit.arduinodisplayserver.service.Impl;

import hu.miskolc.uni.iit.arduinodisplayserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData;
import hu.miskolc.uni.iit.arduinodisplayserver.controller.MeasuringType;
import hu.miskolc.uni.iit.arduinodisplayserver.service.DisplayService;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

public class DisplayServiceImplementation implements DisplayService {
    @Autowired
    MeasurementDAO measurementDAO;

    @Override
    public List<MeasuringDevice> getallmeasureddata() {
        return measurementDAO.listAllDevice();

    }

    @Override
    public List<SensorValues> getSensorValuesByIpAddress(final String ipAdress) {
        return measurementDAO.listSensorValuesByIpAddress(ipAdress);
    }

    @Override
    public List<ResultData> getMeasuredValuesBetweeenDates(final Calendar begin, final Calendar end, final String deviceId, final MeasuringType type) {
        return measurementDAO.listSpecifiedSensorValueBetweenDates(begin, end, deviceId, type);
    }
}
