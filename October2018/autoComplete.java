
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

class AlphaTree{
	boolean isRoot;
	boolean isWord;
	public char nodeValue;
	public AlphaTree[] subTrees = new AlphaTree[26];
	int emptyTree = 0;
	AlphaTree(){
		isRoot = true;
	}
	AlphaTree(char check){
		isRoot = false;
		nodeValue = check;
	}
	void insert(String value) {
		char currValue = value.charAt(0);
		int index = searchLevel(currValue);
		if(index != -1) {
			subTrees[index].insert(value.substring(1));
		} else {
			AlphaTree newTree = new AlphaTree(currValue);
			newTree.insert(value.substring(1));
			subTrees[emptyTree] = newTree;
			emptyTree++;
		}
		if(value.length() == 1) {
			isWord = true;
		}
	}
	
	String[] search(String searchPhrase) {
		String[] results = new String[10];
		int next = searchLevel(searchPhrase.charAt(0));
		if(next != -1) {
			//Recursively search through the system after getting to the end of the search phrase
		} 
		return results;
		
	}
	
	int searchLevel(char value) {
		for(int x = 0; x < subTrees.length; x++) {
			if(subTrees[x].nodeValue == value) return x;
		}
		return -1;
	}
}
