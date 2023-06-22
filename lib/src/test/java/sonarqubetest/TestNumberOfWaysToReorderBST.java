package sonarqubetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import sonarqubetest.NumberOfWaystoReorderArrayToGetSameBST;

class TestNumberOfWaysToReorderBST {
	
	NumberOfWaystoReorderArrayToGetSameBST bstReorder = new NumberOfWaystoReorderArrayToGetSameBST();
	long[] bstOrderingEasy = {3,4,5,1,2};
	long[] bstOrderingMedium = {5,4,3,6,7,2,8,1};
	long[] bstOrderingHard = {5,4,3,16,17,14,8,1,20,11,6,7,2,13,12,15,18,19,9,10};

	@Test
	void calculateReorderingsEasy() {
		assertEquals(5, bstReorder.calculateNumberOfReorderings(bstOrderingEasy));
	}
	
//	@Test
//	void simpleTest() {
//		assertEquals(5, 5);
//	}
	
	@Test
	void calculateReorderingsMedium() {
		assertEquals(34, bstReorder.calculateNumberOfReorderings(bstOrderingMedium));
	}
	
	@Test
	void calculateReorderingsHard() {
		assertEquals(399779355, bstReorder.calculateNumberOfReorderings(bstOrderingHard));
	}

}
