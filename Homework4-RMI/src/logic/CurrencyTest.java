package logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class CurrencyTest {

	@Test
	public void testConvertTo() {
		assertEquals("150*1.37=205.5", 205.5,
				Currency.EUR.convertTo(150, Currency.USD), 0.001);
		assertEquals("150=205.5/1.37", 150,
				Currency.USD.convertTo(205.5, Currency.EUR), 0.001);
		assertEquals("150*1(same rate)=150", 150,
				Currency.USD.convertTo(150, Currency.USD), 0.001);
	}
}
