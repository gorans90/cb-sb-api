package com.carbook.repositories.car;

import com.carbook.models.car.CarProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by gsimic on 12/1/2016.
 */
public interface CarProfileRepository extends JpaRepository<CarProfile, Integer> {

    @Query("select a from carprofile a where a.user.id=:userId")
    List<CarProfile> findAllByLoggedInUser(@Param("userId") Integer userId);
}
