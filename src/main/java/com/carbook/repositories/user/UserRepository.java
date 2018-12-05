package com.carbook.repositories.user;

import com.carbook.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by gsimic on 12/1/2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("select u from users u where u.email=:email")
    User findByEmail(@Param("email") String email);
}
