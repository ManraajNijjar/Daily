
public class nodeSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
		System.out.println(serialize(node));
	}
	

	public static String serialize(Node node) {
		String value = node.value;
		if(node.left != null) {
			value += "<" + serialize(node.left);
		}
		if(node.left != null && node.right != null) {
			value += "^";
		}
		if(node.right != null) {
			value += ">" + serialize(node.right);
		}
		
		return value;
	}
	
	
	//Not completed yet
	public static Node deserialize(String serial) {
		Node node;
		if(!serial.isEmpty()) {
			String value = "";
			for(int x = 0; x < serial.length(); x++) {
				 char charat = serial.charAt(x);
				 if(charat == '<' || charat == '>') {
					 for(int y = x + 1; y < serial.length(); y++) {
						 char charatTwo = serial.charAt(y);
						 if(charatTwo == charat) {
							 break;
						 }
						 if(charatTwo == '^') {
							 
						 }
					 }
					 
					 return new Node(value, deserialize(serial.substring(x)));
					
				 }
				 value += charat;
			}
		}
		return null;
	}

}

class Node{
	String value;
	Node left;
	Node right;
	
	Node(String val, Node l, Node r){
		value = val;
		left = l;
		right = r;
	}
	
	Node(String val, Node l){
		value = val;
		left = l;
	}
	
	Node(String val){
		value = val;
	}
	
}