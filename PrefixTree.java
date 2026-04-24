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
		String order;
		String code;
		try (Scanner Read = new Scanner(preOrder)) {
			order = Read.nextLine();
			code = Read.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
		System.out.println("Order: ");
		System.out.print(order);
		System.out.println("Code: ");
		System.out.print(code);
    }
}
