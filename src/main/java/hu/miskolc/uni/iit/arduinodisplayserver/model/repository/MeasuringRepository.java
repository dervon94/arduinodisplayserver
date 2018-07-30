package hu.miskolc.uni.iit.arduinodisplayserver.model.repository;

import hu.miskolc.uni.iit.arduinodisplayserver.model.MeasuringDevice;
import org.springframework.data.repository.CrudRepository;

public interface MeasuringRepository extends CrudRepository<MeasuringDevice, Integer> {
}
