package hu.miskolc.uni.iit.arduinodisplayserver.DAO.Imp;

import hu.miskolc.uni.iit.arduinodisplayserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.arduinodisplayserver.model.repository.MeasuringDisplayRepository;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
        final Calendar begin = new GregorianCalendar(2018, 7, 1);
        final Calendar end = new GregorianCalendar(2018, 7, 1);
        end.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(begin.getTime());
        System.out.println(end.getTime());

        System.out.println(measuringDisplayRepository.getDeviceHumidityValueBetweenDates(begin, end, "arduinoSensor1"));
        final List<SensorValues> result = measuringDisplayRepository.getAllSensorValues(ipAddress);
        return result;
//        return null;
    }
}
