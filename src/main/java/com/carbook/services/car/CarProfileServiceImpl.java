package com.carbook.services.car;

import com.carbook.models.car.CarProfile;
import com.carbook.repositories.car.CarProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by simic_000 on 3/19/2017.
 */

@Service
public class CarProfileServiceImpl implements CarProfileService {

    @Autowired
    CarProfileRepository carProfileRepository;

    @Override
    public CarProfileRepository getRepository() {
        return carProfileRepository;
    }

    @Override
    public List<CarProfile> findAllForLoggedInUser(Integer userId) {
        return carProfileRepository.findAllByLoggedInUser(userId);
    }
}
