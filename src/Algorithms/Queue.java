package Algorithms;

public class Queue {
	private Node first, last;

	public Queue() {
		first = null;
		last = null;
	}

	private class Node {
		private String item;
		private Node next;

	}

	private boolean isEmpty() {
		return false;
	};

	void add(String item) {
		first = new Node();
		first.item = "s";
		Node old = null;
		if (last != null)
			old = last;
		else {
			old = new Node();
			old.item = "";
		}
		last = new Node();
		last.item = item;
		last.next = null;
		if (first == last)
			first = last;
		else
			old.next = last;
	}

	public void printInReverseUsingAStack() {
		if (isEmpty()) {
			System.out.print("Empty queue");
			return;
		}
		String s = "";
		for (Node i = first; i != null; i = i.next) {
			if (i.equals(first))
				s = i.item + " " + s;
			else
				s = i.item + ", " + s;
		}
		System.out.print(s);
	}

	public void printInReverseRecursively(Node n) {
		if (isEmpty()) {
			System.out.print("Empty queue");
			return;
		} else if (n == null)
			return;
		printInReverseRecursively(n.next);
		if (n.next == null)
			System.out.print(n.item + "");
		else
			System.out.print(n.item + ", ");
	}

	public static void main(String[] args) {
		String c = "c";
		String a = "a";
		System.out.println("c comp "+c.compareTo(a));
		System.out.println("a comp: "+a.compareTo(c));
	}
}
