
public class autoComplete {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] exampleArray = new String[] {"indigo", "indie", "mindy", "indicated"};
		complete(exampleArray, "ind");
	}
	//Not the most efficient method but It'll suffice for now
	static String[] complete(String[] setOfWords, String searchTerm) {
		String[] matchedTerms = new String [setOfWords.length];
		int y = 0;
		for(int x = 0; x < setOfWords.length; x++) {
			String term = setOfWords[x];
			if(term.startsWith(searchTerm)) {
				matchedTerms[y] = term;
				y++;
			}
		}
		return matchedTerms;
	}

}
