
public class canSumToo {
	
	//Prompt: Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valueToCheck = 17;
		int[] valueList = new int[] {10, 15, 3};
		System.out.println(canSum(valueToCheck, valueList));
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
	
	

}
