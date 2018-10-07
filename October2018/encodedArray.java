
public class encodedArray {
	/*
	 Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
	 count the number of ways it can be decoded.

	For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

	You can assume that the messages are decodable. For example, '001' is not allowed.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "12210";
		System.out.println(possibleDecodes(message));
		//System.out.println(encodeArray(message));
	}
	
	//Recursive Method to find the decodable strings
	public static int possibleDecodes(String message){
		if(message.length() == 1 || message.length() == 0) {
			return 1;
		}
		
		int variations = 0;
		int value = Integer.parseInt(Character.toString(message.charAt(0)));
		int nextValue = Integer.parseInt(Character.toString(message.charAt(1)));
		if(value < 3) {
			if(value == 2) {
				if(nextValue < 7) {
					variations += possibleDecodes(message.substring(2));
				}
				if(nextValue != 0) {
					variations += possibleDecodes(message.substring(1));
				}
			}
			if(value == 1) {
				variations += possibleDecodes(message.substring(2));
				if(nextValue != 0) {
					variations += possibleDecodes(message.substring(1));
				}
			}
		} else {
			variations += possibleDecodes(message.substring(1));
		}
		return variations;
	}
	
	
	
	//Not the Answer, this just looks at the number of ways individual characters can be arranged in the string.
	//Thought it might help. It doesn't
	public static int encodeAllPossibleConversions(String message){
		char[] messageArray = message.toCharArray();
		int variations = 0;
		
		for(int x = 0; x < messageArray.length; x++) {
			int value = Integer.parseInt(Character.toString(messageArray[x]));
			if(value < 3 && x+1 < messageArray.length) {
				if(value == 2) {
					int nextValue = Integer.parseInt(Character.toString(messageArray[x+1]));
					if(nextValue < 7) {
						variations++;
					}
				}
				if(value == 1) {
					variations++;
				}
			}
			if(value != 0) {
				variations++;
			}
		}
		
		return variations;
	}

}
