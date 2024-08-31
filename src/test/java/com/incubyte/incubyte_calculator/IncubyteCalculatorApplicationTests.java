package com.incubyte.incubyte_calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IncubyteCalculatorApplicationTests {
	private static SimpleStringCal cal;

	@BeforeAll
	public static void setup() {
		if (cal == null) {
			cal = new SimpleStringCal();
		}
	}

	@Test
	public void nullCheck() {
		assertEquals(0, cal.add(null));
	}

	@Test
	public void emptyStringCheck() {
		assertEquals(0, cal.add(""));
	}

	@Test
	public void anyNumberCheck() {
		assertEquals(2, cal.add("2"));
	}

}
