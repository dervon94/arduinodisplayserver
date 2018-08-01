package hu.miskolc.uni.iit.arduinodisplayserver.model.repository;


import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;
import java.util.List;

public interface MeasuringDisplayRepository extends CrudRepository<MeasuringDevice, Integer> {


    /*@Query("SELECT v.humidity FROM SensorValues v join MeasuringDevice  where  ip_address=?1")
    List<Integer> getAllSensorValues(String ipAddress);*/

    @Query("SELECT v FROM SensorValues v join v.device d where d.ipAddress=?1")
    List<SensorValues> getAllSensorValues(String ipAddress);


    @Query("SELECT v FROM SensorValues v join v.device d where( v.measuringTime>=?1 and v.measuringTime<=?2 and d.deviceId=?3)")
    List<SensorValues> getDeviceHumidityValueBetweenDates(Calendar start, Calendar end, String device_Id);



}
