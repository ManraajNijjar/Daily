import java.lang.reflect.Field;

public class consCarCDR {

	/*
	 cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
	 For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

	Given this implementation of cons:
	
	def cons(a, b):
	    def pair(f):
	        return f(a, b)
	    return pair
	Implement car and cdr.
	 */
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Object x = cons(3, 4);
		System.out.println(car(x));
		System.out.println(cdr(x));
	}
	
	//Defines and returns the Pair class as an Object
	public static Object cons(int a, int b) {
		class Pair extends Object{
			public int first;
			public int last;
			Pair(int a, int b){
				first = a;
				last = b;
			}
			
			
		}
		return new Pair(a, b);
	}
	
	//Goes through the object and returns the value by accessing the right field
	public static int car(Object p) throws IllegalArgumentException, IllegalAccessException {
		
		Class <? extends Object> Pair = p.getClass();
		
	    Field[] fields = Pair.getDeclaredFields();
	    fields[0].setAccessible(true);
        Object value = fields[0].get(p);

		
		return (int) value;
	}
	
	public static int cdr(Object p) throws IllegalArgumentException, IllegalAccessException {
		Class <? extends Object> Pair = p.getClass();
		
	    Field[] fields = Pair.getDeclaredFields();
	    fields[1].setAccessible(true);
        Object value = fields[1].get(p);

		
		return (int) value;
	}
	
	/*
	Part of solution from misunderstanding question
	static int cdr(Cons con) {
		return con.pair.last;
	}
	
	static int car(Cons con) {
		return con.pair.first;
	} */

}


/*
Part of solution from when I misunderstood question
class Cons {
	
	Pair pair;
	
	Cons(int a, int b){
		pair = new Pair(a, b);
	}
	
	class Pair{
		int first;
		int last;
		Pair(int a, int b){
			first = a;
			last = b;
		}
	}
}
*/