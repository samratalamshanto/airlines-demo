package com.samarat.airlinesdemoproject.service;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class BaseClassTest {
    @Container
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("default")
            .withUsername("admin")
            .withPassword("admin");

    static {
        postgreSQLContainer.start();
    }
}
