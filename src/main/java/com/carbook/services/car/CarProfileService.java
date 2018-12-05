package com.carbook.services.car;

import com.carbook.models.car.CarProfile;
import com.carbook.repositories.car.CarProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by simic_000 on 3/19/2017.
 */
public interface CarProfileService {

    CarProfileRepository getRepository();
    List<CarProfile> findAllForLoggedInUser(Integer userId);
}
