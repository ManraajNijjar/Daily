
public class multiplyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] valueList = new int[] {1, 2, 3, 4, 5};
		valueList = multiplyArrayBruteForce(valueList);
		
		printArray(valueList);
		
	}
	
	
	//Quick brute force solution with O(N^2)
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
	
	
	//Helper method for testing
	static void printArray(int[] array) {
		for(int x = 0; x < array.length; x++) {
			System.out.println(array[x]);
		}
	}

}
