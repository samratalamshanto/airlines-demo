package com.samarat.airlinesdemoproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AirlinesDemoProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
