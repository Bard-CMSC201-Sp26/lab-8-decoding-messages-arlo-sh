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
	
	public static void main(String[] args) {
		PrefixTree tree = new PrefixTree();				// new tree
		File preOrder = new File("abra.txt");
		
		try (Scanner Read = new Scanner(preOrder)) {
			String order = Read.nextLine();
			String code = Read.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
		System.out.println("Order: " + order);
		System.out.println("Code: " + code);
    }
}
