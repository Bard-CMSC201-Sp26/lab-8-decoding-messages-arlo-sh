import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

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
		PrefixTree tree = new PrefixTree();
		File preOrder = new File("abra.txt");
		String preOrderString = "";
		String wordString = "";
		try (Scanner Read = new Scanner(preOrder)) {
			while (Read.hasNextLine()) {
				String data = Read.nextLine();
				preOrderString = data;
				System.out.println(preOrderString);
			}
			wordString = data.nextLine();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		}
    }
}
