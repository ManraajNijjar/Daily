import java.util.Arrays;

public class nonConSums {

	/*
	Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. 
	Numbers can be 0 or negative.

	For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. 
	[5, 1, 1, 5] should return 10, since we pick 5 and 5.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] firstSet = new int[] {2, 4, 6, 2, 5};
		int[] secondSet = new int[] {5, 1, 1, 5};
		System.out.println(nonConStart(firstSet));
		System.out.println(nonConStart(secondSet));
	}
	
	//Have to access the first value here in the array
	//The recursive method will need to grab the next ones
	static int nonConStart(int[] values) {
		int[] nextNum = Arrays.copyOfRange(values, 2, values.length);
		int startPointOne = values[0] + nonConSums(nextNum);
		nextNum = Arrays.copyOfRange(values, 3, values.length);
		int startPointTwo = values[1] + nonConSums(nextNum);
		
		if(startPointOne > startPointTwo) {
			return startPointOne;
		} else {
			return startPointTwo;
		}
	}
	
	static int nonConSums(int[] values) {
		if(values.length > 1) {
			int sequenceOne = 0;
			int sequenceTwo = 0;
			if(values.length >= 2) {
				int[] nextNum = Arrays.copyOfRange(values, 2, values.length);
				sequenceOne = values[0] + nonConSums(nextNum);
			} else {
				sequenceOne = values[0];
			}
			
			if(values.length >= 3) {
				int[] nextNum = Arrays.copyOfRange(values, 3, values.length);
				sequenceTwo = values[1] + nonConSums(nextNum);
			} else {
				sequenceOne = values[1];
			}
			
			if(sequenceOne > sequenceTwo) {
				return sequenceOne;
			} else {
				return sequenceTwo;
			}
		} else {
			if(values.length == 1) {
				return values[0];
			} else {
				return 0;
			}
		}
	}

}
