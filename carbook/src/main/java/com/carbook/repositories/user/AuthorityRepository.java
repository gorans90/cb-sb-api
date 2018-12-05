package com.carbook.repositories.user;

import com.carbook.models.user.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by simic_000 on 4/15/2017.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
