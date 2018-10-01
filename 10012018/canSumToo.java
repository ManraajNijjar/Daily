
public class canSumToo {
	
	//Prompt: Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valueToCheck = 18;
		int[] valueList = new int[] {10, 15, 3, 7};
		//System.out.println(canSum(valueToCheck, valueList));
		System.out.println(matrixSum(valueToCheck, valueList));
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
			for(int z = 0; z < values.length; z++) {
				valueMatrix[z][x] += values[x];
			}
			
			for(int y = 0; y < values.length; y++) {
				valueMatrix[x][y] += values[x];
				if(valueMatrix[x][y] == K && x != y) {
					return true;
				}
			}
		}
		
		
		return false;
	}

}
