package Tuts;

public class TreeDelete {
	private class Node {
		int value;
		Node left;
		Node right;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private Node root = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node node, int value) {
		if (node == null) {
			return false;
		} else if (value == node.value) {
			return true;
		} else if (value < node.value) {
			return contains(node.left, value);
		} else {
			return contains(node.right, value);
		}
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	public int getMin(Node node) {
		if (node == null) {
			// No minimum!
			return Integer.MIN_VALUE;
		} else {
			while (node.left != null) {
				node = node.left;
			}
			return node.value;
		}
	}

	public int getMax(Node node) {
		if (node == null) {
			// No maximum!
			return Integer.MAX_VALUE;
		} else {
			while (node.right != null) {
				node = node.right;
			}
			return node.value;
		}
	}

	public void delete(int value) {
		root = delete(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			size++;
			return new Node(value, null, null);
		} else if (value == node.value) {
			// Value already there!
			return node;
		} else if (value < node.value) {
			node.left = insert(node.left, value);
			return node;
		} else {
			node.right = insert(node.right, value);
			return node;
		}
	}

	private Node delete(Node node, int value) {
		// ... Fill this in
		
		if (node !=null && size == 1 && value == node.value) {
			size--;
			Node n = new Node(node.value, node.left, node.right);
			node = null;
			return n;}
		else if (size == 0) // nothing to delete
			return node;
		else if(node==null)
			return node;
		else if (node !=null && value < node.value)
			return delete(node.left, value);
		else if(node !=null && value>node.value)
			return delete(node.right, value);
		else return node;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(toString(root));
		return b.toString();
	}

	private String toString(Node node) {
		StringBuilder b = new StringBuilder();
		b.append('(');
		if (node != null) {
			if (node.left != null) {
				b.append(toString(node.left));
				b.append(' ');
			}
			b.append(node.value);
			if (node.right != null) {
				b.append(' ');
				b.append(toString(node.right));
			}
		}
		b.append(')');
		return b.toString();
	}

}
