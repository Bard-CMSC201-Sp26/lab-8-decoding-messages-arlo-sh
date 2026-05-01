import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class PrefixTree {
	private Node root;

	private class Node {
		private Node left;
		private Node right;
		private Character c;
		public Node(Character c)
		{	this.c = c;		}
	}

	//		CONSTRUCTOR
	private int index = 0;	// current position in tree

	public PrefixTree(String preorder) {
		root = build(preorder);
	}

	//		Build the tree
	private Node build(String preorder) {
	    //		update the character at the new index to be c
		char c = preorder.charAt(index++);
	    Node node = new Node(c);
		// Pre-Order is root, left, right
	    if (c == '*') {						// root
	    	node.left = build(preorder);	// left
	        node.right = build(preorder);	// right
	    }
	    return node;							// final leaf (not '*')
	}

	public void getEncodings() {
		System.out.println("Character    bits    encoding");
		getEncodings(root, "");
	}

	private void getEncodings(Node node, String path) {
	    if (node == null) return;		//	BASE CASE
	
	    // Check if it's a leaf node
	    if (node.c != '*') {
	        System.out.println("    " + node.c + "         " + path.length() + "         " + path);
	        return;
	    }
	    getEncodings(node.left, path + "0");	// 0 = left
	    getEncodings(node.right, path + "1");	// 1 = right
	}

	public void decode(String bits) {
	    Node current = root;
	    StringBuilder decoded = new StringBuilder();
	
	    for (int i = 0; i < bits.length(); i++) {
	        char bit = bits.charAt(i);
	
	        if (bit == '0') {
	            current = current.left;
	        } else if (bit == '1') {
	            current = current.right;
	        } else {
				// if anything other than 0 or 1 is in "code"
	            throw new IllegalArgumentException("Invalid bit: " + bit);
	        }
	
	        // found leaf node
	        if (current.c != '*') {
	            decoded.append(current.c);
	            current = root; // reset
	        }
	    }
		
	    System.out.println("Decoded message:" + decoded.toString());	// OUTPUT
	
	    int numOfBitsRead = bits.length();
	    int numOfChars = decoded.length();
	    double compressionFactor = (double) bitsRead / charCount;
	
	    System.out.println("Bits read: " + bitsRead);
	    System.out.println("Characters: " + charCount);
	    System.out.printf("Compression factor: %.2f\n", compressionFactor);
	}
	
	public static void main(String[] args) {
		PrefixTree tree;			// new tree
		File preOrder = new File("abra.txt");
		String order = "";
		String code = "";
		try (Scanner Read = new Scanner(preOrder)) {
			order = Read.nextLine();
			code = Read.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}

		tree = new PrefixTree(order);	// builds new tree
		
		System.out.print("Order: ");
		System.out.println(order);
		System.out.print("Code: ");
		System.out.println(code);

		tree.getEncodings();
    }
}
