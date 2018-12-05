package com.carbook.repositories.user;

import com.carbook.models.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by simic_000 on 5/22/2017.
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    @Query("select u from userprofile u where u.user.id=:userId")
    UserProfile findByUserId(@Param("userId") Integer userId);
}
