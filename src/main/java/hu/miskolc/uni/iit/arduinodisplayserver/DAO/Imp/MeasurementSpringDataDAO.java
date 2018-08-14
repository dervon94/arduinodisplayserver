package hu.miskolc.uni.iit.arduinodisplayserver.DAO.Imp;

import hu.miskolc.uni.iit.arduinodisplayserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData;
import hu.miskolc.uni.iit.arduinodisplayserver.controller.MeasuringType;
import hu.miskolc.uni.iit.arduinodisplayserver.model.repository.MeasuringDisplayRepository;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;


public class MeasurementSpringDataDAO implements MeasurementDAO {
    @Autowired
    MeasuringDisplayRepository measuringDisplayRepository;

    @Override
    public List<MeasuringDevice> listAllDevice() {
        return (List<MeasuringDevice>) measuringDisplayRepository.findAll();
    }

    @Override
    public List<SensorValues> listSensorValuesByIpAddress(final String ipAddress) {
        final List<SensorValues> result = measuringDisplayRepository.getAllSensorValues(ipAddress);
        return result;
    }

    @Override
    public List<ResultData> listSpecifiedSensorValueBetweenDates(final Calendar begin, final Calendar end, final String deviceId, final MeasuringType type) {
        end.add(Calendar.DAY_OF_MONTH, 1);
        switch (type)

        {
            case HUMIDITY: {
                return measuringDisplayRepository.getDeviceHumidityValuesBetweenDates(begin, end, deviceId);
            }
            case RAIN: {
                return measuringDisplayRepository.getDeviceRainValuesBetweenDates(begin, end, deviceId);
            }
            case LIGHT: {
                return measuringDisplayRepository.getDeviceLightValuesBetweenDates(begin, end, deviceId);
            }
            case TEMPERATURE: {
                return measuringDisplayRepository.getDeviceTemperatureValuesBetweenDates(begin, end, deviceId);
            }
        }

        return null;
    }
}
