

public class staircase {
	
	static int global = 0;

	public static void main(String[] args) {
		int N = 10;
		int[] values = new int[] {1, 3, 5};
		step(N, values);
		System.out.println(global);
		System.out.println(stepBetter(N, values));
	}
	
	public static void step(int N, int[] values) {
		if(N == 0) {
			global++;
		}
		for(int x = 0; x < values.length; x++) {
			int y = N - values[x];
			if(y >= 0) {
				step(y, values);
			}
		}
		
	}
	
	public static int stepBetter(int N, int[] values) {
		if (N < 0) {
			return 0;
		} else if (N == 0) {
			return 1;
		} 
		
		int value = 0;
		for(int x = 0; x < values.length; x++) {
			value += stepBetter(N - values[x], values);	
		}
		return value;
	}
		

}
