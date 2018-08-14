package hu.miskolc.uni.iit.arduinodisplayserver.model.repository;


import hu.miskolc.uni.iit.arduinodisplayserver.DAO.ResultData;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface MeasuringDisplayRepository extends CrudRepository<MeasuringDevice, String> {



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

    @Query("SELECT DISTINCT DATE(v.measuringTime) FROM SensorValues v join v.device d where (d.deviceId =?1)")
    List<MeasuringDevice> getMeasuringDatesByDeviceId(String device_Id);

    @Query("SELECT deviceId FROM MeasuringDevice")
    List<String> getDeviceIds();

    @Query("SELECT distinct position FROM MeasuringDevice")
    List<String> getPositions();

    @Query("SELECT distinct ipAddress FROM MeasuringDevice")
    List<String> getIpAddresses();


    List<MeasuringDevice> getMeasuringDevicesByPositionOrderByDeviceId(@Param("Position") String Position);


}
