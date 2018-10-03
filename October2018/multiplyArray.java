import java.util.ArrayList;
import java.util.Collections;

public class multiplyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] valueList = new int[] {1, 2, 3, 4, 5};
		//valueList = multiplyArrayBruteForce(valueList);
		ArrayList<Integer> results = bestSol(valueList);
		System.out.println(results);
		//printArray(valueList);
		
	}
	
	//Given an array of integers, return a new array such that each element at index i of the new array 
	//is the product of all the numbers in the original array except the one at i.
	//Follow-up: what if you can't use division?


	
	//Quick brute force solution with O(N^2) not using the division 
	public static int[] multiplyArrayBruteForce(int[] valueList ) {
		int[] bigArray = new int[valueList.length];
		for(int x = 0; x < valueList.length; x++) {
			int bigNumber = 1;
			for(int y = 0; y < valueList.length; y++) {
				if(y != x) {
					bigNumber = bigNumber * valueList[y];
				}
			}
			bigArray[x] = bigNumber;
		}
		
		return bigArray;
	}
	
	
	//Best solution implemented in Java
	public static ArrayList<Integer> bestSol(int[] valueList) {
		//Create arrays with all the values multiplied up to the point X in the array
		//Both going forwards and then backwards
		
		//Creates the forward value * each new number by the results of the last ones
		ArrayList<Integer> productArray = new ArrayList<Integer>();
		for(int x = 0; x < valueList.length; x++) {
			if(!productArray.isEmpty()) {
				productArray.add(productArray.get(x - 1) * valueList[x]);
			} else {
				productArray.add(valueList[x]);
			}
		}
		
		//Creates the backwards array
		ArrayList<Integer> suffixArray = new ArrayList<Integer>();
		int[] reverseValues = reversedArray(valueList);
		for(int x = 0; x < reverseValues.length; x++) {
			if(!suffixArray.isEmpty()) {
				suffixArray.add(suffixArray.get(x - 1) * reverseValues[x]);
			} else {
				suffixArray.add(reverseValues[x]);
			}
		}
		
		//Flips the backwards array
		Collections.reverse(suffixArray);
		
		//Does the calculation
		//The two if conditions could be moved out of the loop however
		//They just do the calculation for the first and the last part of the loop.
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		for(int x = 0; x < valueList.length; x++) {
			if(x == 0) {
				results.add(suffixArray.get(x + 1));
			} else if (x == valueList.length - 1) {
				results.add(productArray.get(x - 1));
			} else {
				// x = forwardArray[x-1] * backwardArray[x+1] to get the totals of each end
				results.add(productArray.get(x - 1) * suffixArray.get(x + 1));
			}
		}
		
		return results;
	}
	
	
	//Helper method to reverse array
	static int[] reversedArray(int[] valueList) {
		int[] reverseList = new int[valueList.length];
		for(int x = valueList.length - 1; x >= 0; x--) {
			reverseList[-x + valueList.length - 1] = valueList[x];
		}
		return reverseList;
	}
	//Helper method for testing
	static void printArray(int[] array) {
		for(int x = 0; x < array.length; x++) {
			System.out.println(array[x]);
		}
	}

}
