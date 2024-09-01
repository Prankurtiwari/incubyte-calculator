package com.incubyte.incubyte_calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
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

	@Test
	public void anyNonNumberCheck() {
		assertEquals(Integer.MAX_VALUE, cal.add("A"));
	}

	@Test
	public void twoNumbersCheck() {
		assertEquals(5, cal.add("2,3"));
	}

	@Test
	public void twoNumbersSeparateByCommaCheck() {
		assertEquals(25, cal.add("12,13"));
	}

	@Test
	public void twoNumbersSeparateByAsteriskCheck() {
		assertEquals(1, cal.add("12*13"));
	}

	@Test
	public void twoNonNumbersSeparateByAsteriskCheck() {
		assertEquals(1, cal.add("A*13"));
	}

	@Test
	public void twoNonNumbersSeparateByCommaCheck() {
		assertEquals(Integer.MAX_VALUE, cal.add("12,B"));
	}


	@Test
	public void anyNumberSeparateByCommonCheck() {
		assertEquals(23, cal.add("12,4,7"));
	}

	@Test
	public void anyNumberSeparateByAsteriskCheck() {
		assertEquals(0, cal.add("12*4*7"));
	}

	@Test
	public void anyNonNumberSeparateByCommaCheck() {
		assertThrows(NumberFormatException.class, () -> cal.add("A,4,7"));
	}

	@Test
	public void anyNumberSeparateByCommonAndAsteriskCheck() {
		assertThrows(NumberFormatException.class, () -> cal.add("A,4,7"));
	}

	@Test
	public void anyNumberWithNewLineCheck() {
		assertEquals(10, cal.add("1\n,2,3,4\n"));
	}

	@Test
	public void anyNumberWithNewLineWithAsteriskCheck() {
		assertThrows(NumberFormatException.class, () -> cal.add("1\n,2*3*4\n"));
	}

}
