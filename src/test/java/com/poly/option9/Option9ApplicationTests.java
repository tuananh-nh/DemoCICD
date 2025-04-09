package com.poly.option9;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.TestNG;

@SpringBootTest
class Option9ApplicationTests {

	@Test
	void contextLoads() {
		TestNG testNG = new TestNG();
		testNG.setTestSuites(
				List.of("F:\\Polytechnic\\option9\\src\\test\\java\\com\\poly\\option9\\Parallel\\TestParallel.xml"));
		testNG.run();
		// TestNG testNG = new TestNG();
		// testNG.setTestSuites(
		// List.of("F:\\Polytechnic\\option9\\src\\test\\java\\com\\poly\\option6\\TestParallel.xml"));
		// testNG.run();
	}

}
