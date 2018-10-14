
public class monteCarloPi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(monteCarlo(10000));
	}
	
	public static double monteCarlo(double N) {
		double hit = 0;
		
		for(int x = 0; x < N; x++) {
			double value1 = Math.random();
			double value2 = Math.random();
			if((value1 * value1) + (value2 * value2) <= 1) {
				hit++;
			}
		}
		return 4*hit/N;
	}

}
