package sonarqubetest;

public class NumberOfWaystoReorderArrayToGetSameBST {
	private long modFactor = (long)Math.pow(10, 9) + 7;
	
	private long[][] constructPascalsTriangle(long[] initialBSTOrdering){
		int lengthOfBSTOrdering = initialBSTOrdering.length;
		long[][] pascalsTriangle = new long[lengthOfBSTOrdering+1][lengthOfBSTOrdering+1];
				
		for(int row = 0; row <= lengthOfBSTOrdering; row++){
			pascalsTriangle[row][0] = 1;
			for(int col = 1; col <= row; col++) {
				pascalsTriangle[row][col] = (pascalsTriangle[row-1][col-1] + pascalsTriangle[row-1][col]) % modFactor;
			}
		}
		
		return pascalsTriangle;
	}
	
	private int getSizeOfRightSubtree(long[] bstOrdering) {
		long root = bstOrdering[0];
		int size = 0;
		for(int node = 1; node < bstOrdering.length; node++) {
			if(bstOrdering[node] > root) {
				size++;
			}
		}
		return size;
	}
	
	private long[] getRightSubtreeOfRoot(long[] bstOrdering) {
		int sizeOfRightSubtree = getSizeOfRightSubtree(bstOrdering);
		
		long[] rightSubtree = new long[sizeOfRightSubtree];
		int rightSubtreeIndex = 0;
		
		long root = bstOrdering[0];
		for(int node = 0; node < bstOrdering.length; node++) {
			if(bstOrdering[node] > root) {
				rightSubtree[rightSubtreeIndex] = bstOrdering[node];
				rightSubtreeIndex++;
			}
		}
		
		return rightSubtree;
	}
	
	private int getSizeOfLeftSubtree(long[] bstOrdering) {
		long root = bstOrdering[0];
		int size = 0;
		for(int node = 1; node < bstOrdering.length; node++) {
			if(bstOrdering[node] < root) {
				size++;
			}
		}
		return size;
	}
	
	private long[] getLeftSubtreeOfRoot(long[] bstOrdering) {
		int sizeOfLeftSubtree = getSizeOfLeftSubtree(bstOrdering);
		
		long[] leftSubtree = new long[sizeOfLeftSubtree];
		int leftSubtreeIndex = 0;
		
		long root = bstOrdering[0];
		for(int node = 0; node < bstOrdering.length; node++) {
			if(bstOrdering[node] < root) {
				leftSubtree[leftSubtreeIndex] = bstOrdering[node];
				leftSubtreeIndex++;
			}
		}
		
		return leftSubtree;
	}
	
	
	private long recursivelyCalculateOrderings(long[] bstOrdering, long[][] pascalsTriangle) {
		int lengthOfOrdering = bstOrdering.length;
		if(lengthOfOrdering < 3) {
			return 1;
		}
		long[] leftSubtree = getLeftSubtreeOfRoot(bstOrdering);
		long[] rightSubtree = getRightSubtreeOfRoot(bstOrdering);
		
		long allWaysToConstructLeftSubtree = recursivelyCalculateOrderings(leftSubtree, pascalsTriangle)%modFactor;
		long allWaysToConstructRightSubtree = recursivelyCalculateOrderings(rightSubtree, pascalsTriangle)%modFactor;
		
		long allPairsOfLeftandRightSubtreeOrderings = ((allWaysToConstructLeftSubtree * allWaysToConstructRightSubtree)%modFactor);
		long allInterleavingsOfLeftandRightSubtreeOrderings = (allPairsOfLeftandRightSubtreeOrderings * pascalsTriangle[lengthOfOrdering-1][leftSubtree.length])%modFactor;
		
		return allInterleavingsOfLeftandRightSubtreeOrderings;
	}
	
	public long calculateNumberOfReorderings(long[] initialBSTOrdering ){
		long[][] pascalsTraingle = constructPascalsTriangle(initialBSTOrdering);
		return recursivelyCalculateOrderings(initialBSTOrdering, pascalsTraingle)-1;
	}
	
}
