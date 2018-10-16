
public class reservoirSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//This is based on the sample code given
	
	public static int reservoirSample(int[] tooBig) {
		int rand = 0;
		
		for(int x = 0; x < tooBig.length; x++) {
			if(Math.random() * ( 1 + x) == 1) {
				rand = tooBig[x];
			}
		}
		
		return rand;
	}
}
