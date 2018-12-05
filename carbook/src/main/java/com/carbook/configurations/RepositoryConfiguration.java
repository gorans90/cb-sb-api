package com.carbook.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by gsimic on 11/29/2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.carbook.models"})
@EnableJpaRepositories(basePackages = {"com.carbook.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}