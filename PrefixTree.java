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
	}
	
}
