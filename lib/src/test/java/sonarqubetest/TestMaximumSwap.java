package sonarqubetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestMaximumSwap {

	MaximumSwap maximumSwapper = new MaximumSwap();
	
	int lessThanZeroExeptionCase = 0;
	int noSwapCase = 4321;
	int easySwapCase = 12;
	int mediumSwapCase = 1993;
	int hardSwapCase = 98234234;
	
	@Test
	void testNoSwapCase() throws InputLessThanZeroException {
		assertEquals(4321, maximumSwapper.findMaximumNumberWithAtMostOneSwap(noSwapCase));
	}
	
	@Test 
	void lessThanZeroExceptionCase(){
		Assertions.assertThrows(InputLessThanZeroException.class, () -> {maximumSwapper.findMaximumNumberWithAtMostOneSwap(lessThanZeroExeptionCase);});
	}

	@Test
	void testEasySwap() throws InputLessThanZeroException {
		assertEquals(21, maximumSwapper.findMaximumNumberWithAtMostOneSwap(easySwapCase));
	}

	
	@Test
	void testMediumSwap() throws InputLessThanZeroException {
		assertEquals(9913, maximumSwapper.findMaximumNumberWithAtMostOneSwap(mediumSwapCase));
	}

	@Test
	void testHardSwap() throws InputLessThanZeroException {
		assertEquals(98434232, maximumSwapper.findMaximumNumberWithAtMostOneSwap(hardSwapCase));
	}

}
