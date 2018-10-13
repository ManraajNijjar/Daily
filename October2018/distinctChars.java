import java.util.HashMap;

public class distinctChars {
	
	/*
	 * Given an integer k and a string s, find the length of the longest substring that contains 
	 * at most k distinct characters.
	 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDistinct("aaabbbbaaba", 1));

	}
	
	public static String findDistinct(String text, int charNumber) {
		int max = 0;
		String longString = "";
		
		for(int x = 0; x < text.length(); x++) {
			HashMap<Character, Boolean> didFind = new HashMap<Character, Boolean>();
			int current = 0;
			int index = x;
			while(current <= charNumber && index < text.length()) {
				char currChar = text.charAt(index);
				if(didFind.get(currChar) == null) {
					current++;
					didFind.put(currChar, true);
				} 
				if(current <= charNumber) {
					index++;
				}
				
			}
			if(index -x > max) {
				max = index -x;
				longString = text.substring(x, index);
			}
		}
		System.out.println(max);
		return longString;
	}

}
