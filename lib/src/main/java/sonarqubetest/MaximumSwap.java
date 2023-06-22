package sonarqubetest;

public class MaximumSwap {
	
	private static boolean charIsLarger(char largerCharCandidate, char smallerCharCandidate) {
		if(largerCharCandidate > smallerCharCandidate) {
			return true;
		}
		return false;
	}
	
	public static String swapTwoIndicesOfString(String originalString, int indexOfCharOne, int indexOfCharTwo) {
		int leftMostIndex = Math.min(indexOfCharOne, indexOfCharTwo);
		int rightMostIndex = Math.max(indexOfCharOne, indexOfCharTwo);
		
		String leftMostCharacterAsString = String.valueOf(originalString.charAt(leftMostIndex));
		String rightMostCharacterAsString = String.valueOf(originalString.charAt(rightMostIndex));
		return originalString.substring(0,leftMostIndex) + rightMostCharacterAsString + originalString.substring(leftMostIndex+1,rightMostIndex) + leftMostCharacterAsString + originalString.substring(rightMostIndex+1,originalString.length());
	}
	
	public static int convertStringToInt(String givenString) {
		return Integer.parseInt(givenString);
	}
	
	private static void checkIfSmallerThanZero(int number) throws InputLessThanZeroException {
		if(number == 0){
			throw new InputLessThanZeroException("Input needs to be greater than 0.");
		}
	}
	
	private boolean swapIncreasesOriginalNumber(String digitString, int indexOfLargestDigitLeftOfCharIndex, int charIndex) {
		char currentChar = digitString.charAt(charIndex);
		char valueOfLargestDigitLeftOfCharIndex = digitString.charAt(indexOfLargestDigitLeftOfCharIndex);
		if(charIsLarger(valueOfLargestDigitLeftOfCharIndex, currentChar)) {
			return true;
		}
		return false;
	}
	
	public int findMaximumNumberWithAtMostOneSwap(int numberBeforeSwap) throws InputLessThanZeroException {
		try {
			checkIfSmallerThanZero(numberBeforeSwap);
		} catch (InputLessThanZeroException e) {
			// TODO Auto-generated catch block
			throw new InputLessThanZeroException(e.getMessage());
		}
		
		
		String numberToSwapAsString = convertIntToString(numberBeforeSwap);
		String maxNumberWithAtMostOneSwap = "";
		
		for(int charIndex = 0; charIndex < numberToSwapAsString.length(); charIndex++) {
			int indexOfLargestDigitLeftOfCharIndex = getIndexOfLargestDigitLeftOfCharIndex(charIndex, numberToSwapAsString);
			if(swapIncreasesOriginalNumber(numberToSwapAsString, indexOfLargestDigitLeftOfCharIndex, charIndex)) {
				maxNumberWithAtMostOneSwap = swapTwoIndicesOfString(numberToSwapAsString, indexOfLargestDigitLeftOfCharIndex, charIndex);
				return convertStringToInt(maxNumberWithAtMostOneSwap);
			}
		}
		
		return convertStringToInt(numberToSwapAsString);
	}
	
	
	
	private static int getIndexOfLargestDigitLeftOfCharIndex(int charIndex, String numberToSwapAsString) {
		int lenOfNumToSwap = numberToSwapAsString.length();
		int currentIndexOfLeftLargestNumber = charIndex;
		char currentLargestValueLeftOfCharIndex= numberToSwapAsString.charAt(currentIndexOfLeftLargestNumber);
		
		for(int leftIndex = charIndex; leftIndex < lenOfNumToSwap; leftIndex++) {
			if(numberToSwapAsString.charAt(leftIndex) >= currentLargestValueLeftOfCharIndex) {
				currentIndexOfLeftLargestNumber = leftIndex;
				currentLargestValueLeftOfCharIndex = numberToSwapAsString.charAt(leftIndex);
			}
		}
		return currentIndexOfLeftLargestNumber;
	}
	
	private static String convertIntToString(int numberToConvertToString) {
		return Integer.toString(numberToConvertToString);
	}
}
