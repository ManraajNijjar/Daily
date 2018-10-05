
public class lowestPositiveArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] valueList = new int[] {3, 4, -1, 1, 2};
		int missing = findLowestMissing(valueList);
		System.out.print(missing);
	}
	
	//Given an array of integers, find the first missing positive integer. 
	//In other words, find the lowest positive integer that does not exist in the array. 
	//The array can contain duplicates and negative numbers as well.
	
	//Sort and then Binary Search method
	//I wonder if it's possible to do this without sorting. I imagine so.
	public static int findLowestMissing(int[] valueList) {
		valueList = sortList(valueList);
		int startOfPositives = binarySearch(valueList, 0, valueList.length-1, 1);
		if(startOfPositives == -1) return 1;
		int searchFor = 2;
		for(int x = startOfPositives+1; x < valueList.length; x++) {
			if(valueList[x] == searchFor) searchFor++;
		}
		return searchFor;
	}
	
	//Standard Sort
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
	
	//Standard Search
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
