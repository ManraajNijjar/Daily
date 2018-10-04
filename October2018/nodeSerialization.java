
public class nodeSerialization {
	
	//Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, 
	//and deserialize(s), which deserializes the string back into the tree.

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
	
	//Their version is similar to mine but much cleaner both in legibility as a program as well as a string
	public static String bestSerialize(Node node) {
		if(node == null) {
			return "#";
		}
		return "(" + node.value + "(" + bestSerialize(node.left) + ")("+ bestSerialize(node.right)  +"))";
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