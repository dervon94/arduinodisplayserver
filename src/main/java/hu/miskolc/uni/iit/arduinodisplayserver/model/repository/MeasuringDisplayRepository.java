package hu.miskolc.uni.iit.arduinodisplayserver.model.repository;


import hu.miskolc.uni.iit.model.MeasuringDevice;
import hu.miskolc.uni.iit.model.SensorValues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeasuringDisplayRepository extends CrudRepository<MeasuringDevice, Integer> {

    //public List<MeasuringDevice> findMeasuringDevicesByipAddres(@Param("ipAddres") String ipadress);
//    @Query("SELECT v FROM SensorValues v inner join MeasuringDevice d on device_id=measuring_dev_id where ip_addres=?1")
//    List<SensorValues> getAllSensorValues(String ipAddres);


    @Query("SELECT v FROM SensorValues v join MeasuringDevice d where ip_addres=?1")
    List<SensorValues> getAllSensorValues(String ipAddres);


}
