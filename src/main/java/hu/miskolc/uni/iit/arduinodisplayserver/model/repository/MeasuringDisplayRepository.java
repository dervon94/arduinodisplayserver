package hu.miskolc.uni.iit.arduinodisplayserver.model.repository;


import hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface MeasuringDisplayRepository extends CrudRepository<MeasuringDevice, Integer> {


    /*@Query("SELECT v.humidity FROM SensorValues v join MeasuringDevice  where  ip_address=?1")
    List<Integer> getAllSensorValues(String ipAddress);*/

    @Query("SELECT v FROM SensorValues v join v.device d where d.ipAddress=?1")
    List<SensorValues> getAllSensorValues(String ipAddress);


    @Query("SELECT v FROM SensorValues v join v.device d where( v.measuringTime>=?1 and v.measuringTime<=?2 and d.deviceId=?3)")
    List<SensorValues> getDeviceSensorValuesBetweenDates(Calendar start, Calendar end, String device_Id);

    @Query("SELECT new hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData (v.measuringTime, v.humidity) FROM SensorValues v join v.device d where( v.measuringTime>=?1 and v.measuringTime<?2 and d.deviceId=?3)")
    List<ResultData> getDeviceHumidityValuesBetweenDates(Calendar start, Calendar end, String device_Id);

    @Query("SELECT new hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData (v.measuringTime, v.rain) FROM SensorValues v join v.device d where( v.measuringTime>=?1 and v.measuringTime<?2 and d.deviceId=?3)")
    List<ResultData> getDeviceRainValuesBetweenDates(Calendar start, Calendar end, String device_Id);

    @Query("SELECT new hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData (v.measuringTime, v.light) FROM SensorValues v join v.device d where( v.measuringTime>=?1 and v.measuringTime<?2 and d.deviceId=?3)")
    List<ResultData> getDeviceLightValuesBetweenDates(Calendar start, Calendar end, String device_Id);

    @Query("SELECT new hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData (v.measuringTime, v.temperature) FROM SensorValues v join v.device d where( v.measuringTime>=?1 and v.measuringTime<?2 and d.deviceId=?3)")
    List<ResultData> getDeviceTemperatureValuesBetweenDates(Calendar start, Calendar end, String device_Id);

    List<MeasuringDevice> getMeasuringDevicesByPosition(@Param("Position") String Position);


}
