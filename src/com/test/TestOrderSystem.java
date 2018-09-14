package com.test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import com.box.FlexBoxPriceQuote;

class TestOrderSystem {

	@Test
	void testMenu() {
		FlexBoxPriceQuote tester = new FlexBoxPriceQuote();
        double result = 7.2;
		assertEquals("Result",result,tester.menu(),0.2);
	}


}
