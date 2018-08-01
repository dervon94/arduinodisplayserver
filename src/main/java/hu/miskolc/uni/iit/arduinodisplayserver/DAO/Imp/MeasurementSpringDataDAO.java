package hu.miskolc.uni.iit.arduinodisplayserver.DAO.Imp;

import hu.miskolc.uni.iit.arduinodisplayserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.arduinodisplayserver.model.repository.MeasuringDisplayRepository;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.beans.factory.annotation.Autowired;

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
        return measuringDisplayRepository.getAllSensorValues(ipAddress);
    }
}
