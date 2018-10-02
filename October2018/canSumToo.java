
public class canSumToo {
	
	//Prompt: Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valueToCheck = 17;
		int[] valueList = new int[] {10, 15, 3, 7, 2};
		//System.out.println(canSum(valueToCheck, valueList));
		//System.out.println(matrixSum(valueToCheck, valueList));
		System.out.println(bestSol(valueToCheck, valueList));
	}
	
	public static boolean canSum(int K, int[] values) {
		for(int x = 0; x < values.length; x++) {
			int check = K - values[x];
			//Could also remove this value and then does a values.contains(check) but this will make it process less
			for(int y = x; y < values.length; y++) {
				if(values[y] == check) return true;
			}
		}
		
		return false;
	}
	
	//Takes up more memory and isn't really a single pass but I just wanted to implement it
	public static boolean matrixSum(int K, int[] values) {
		int[][] valueMatrix = new int[values.length][values.length];
		for(int x = 0; x < values.length; x++) {
			for(int y = 0; y < values.length; y++) {
				valueMatrix[x][y] += values[x];
				valueMatrix[y][x] += values[x];
				if(valueMatrix[x][y] == K && x != y) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	//Best solution
	//The best sol was to use binary search on a sorted array, I've made some small adjustments to the algorithm
	//to make it a bit faster
	public static boolean bestSol(int K, int[] values) {
		values = sortList(values);
		for(int x = 0; x < values.length; x++) {
			int innerTarget = K - values[x];
			int location = binarySearch(values, x+1, values.length, innerTarget);
			
			if(location != -1) {
				return true;
			}
		}
		
		return false;
	}
	
	//Standard bubble sort
	public static int[] sortList(int[] values) {
		for (int x = 0; x < values.length - 1; x++) {
			for (int y = 0; y < values.length-x-1; y++) {
           	 if (values[y] > values[y+1]) { 
                    int temp = values[y]; 
                    values[y] = values[y+1]; 
                    values[y+1] = temp; 
                }
           }
		}
		return values;
	}
	
	//Standard binary search
	public static int binarySearch(int[] values, int left, int right, int target) {
		if (right >= left && right <= values.length) { 
            int middle = left + (right - left)/2; 
            if (values[middle] == target) {
                return middle; 
            }

            if (values[middle] > target) {
            	return binarySearch(values, left, middle - 1, target);  
            }
            return binarySearch(values, middle + 1, right, target); 
        }  
        return -1;
	}

}
