
public class univalTree {

	/*
	A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

	Given the root to a binary tree, count the number of unival subtrees.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode root = new treeNode(1, new treeNode(1), new treeNode(1, new treeNode(0)));
		System.out.print(univalCounter(root));
	}
	
	static boolean univalCheck(treeNode root, int valueToCheck) {
		if(root.left == null && root.right == null) {
			return true;
		}
		if(root.value == valueToCheck) {
			if(root.right != null) {
				return univalCheck(root.left, valueToCheck) && univalCheck(root.right, valueToCheck);
			} else {
				return univalCheck(root.left, valueToCheck);
			}
		}
		return false;
	}
	
	static int univalCounter(treeNode root) {
		int sum = 0;
		if(root.left != null) {
			sum += univalCounter(root.left);
		}
		if(root.right != null) {
			sum += univalCounter(root.right);
		}
		
		if(univalCheck(root, root.value)) {
			return 1 + sum;
		} else {
			return sum;
		}
	}

}

class treeNode{
	int value;
	treeNode left;
	treeNode right;
	
	treeNode(int a, treeNode l, treeNode r){
		value = a;
		left = l;
		right = r;
	}
	treeNode(int a, treeNode l){
		value = a;
		left = l;
	}
	treeNode(int a){
		value = a;
	}
}
