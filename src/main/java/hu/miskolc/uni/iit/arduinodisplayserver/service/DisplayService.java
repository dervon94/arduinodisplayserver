package hu.miskolc.uni.iit.arduinodisplayserver.service;


import hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData;
import hu.miskolc.uni.iit.arduinodisplayserver.controller.MeasuringType;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;

import java.util.Calendar;
import java.util.List;

public interface DisplayService {
    List<MeasuringDevice> getallmeasureddata();

    List<SensorValues> getSensorValuesByIpAddress(String ipAdress);

    List<ResultData> getMeasuredValuesBetweeenDates(Calendar begin, Calendar end, String deviceId, MeasuringType type);

}
