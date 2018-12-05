package com.carbook.repositories.car;

import com.carbook.models.car.CarModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gsimic on 11/30/2016.
 */
@Repository("carModelRepository")
public interface CarModelRepository extends CrudRepository<CarModel, Integer> {
}
