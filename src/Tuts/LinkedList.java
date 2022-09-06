package Tuts;

public class LinkedList {
	private class Node {
		int value;
		Node next;
	}
	private Node first = null;
	private int size = 0; // size of the list


	public int getSize() {
		return size;
	}

	public boolean contains(int value) {
		if (first == null)
			return false;
		else {
			Node n = first;
			while (n != null) {
				if (value == n.value)
					return true;
				else if (value < n.value)
					break;
				n = n.next;
			}
			return false;
		}
	}

	public void insert(int value) {
		Node oldFirst = first;
		if (first == null) {
			first = new Node();
			first.value = value;
			first.next = null;
			size++;
		} else if (value < first.value) {
			first = new Node();
			first.value = value;
			first.next = oldFirst;
			size++;
		} else {
			Node n = first;
			while (n.next != null) {
				if (value < n.next.value) {
					break;
				}
				n = n.next;
			}
			Node m = new Node();
			m.value = value;
			m.next = n.next;
			n.next = m;
			size++;
		}
	}

	public void delete(int value) {
		// ... Fill this in
		if(size ==1 && first.value==value) {
			first.value =0;
			first =null;
		}
		else if(size>1 && first.value == value) {
			first.value =0;
			first =first.next;
		}
		else {
			Node n = first.next;
			Node old = first;
			while(n!=null) {
				if(value == n.value) {
					old.next = n.next;
					n.value=0;
					n = null;
					break;
				}
				old = n;
				n = n.next;
			}
		}
		size--;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('[');
		if (first != null) {
			b.append(first.value);
			for (Node n = first.next; n != null; n = n.next) {
				b.append(' ').append(n.value);
			}
		}
		b.append(']');
		return b.toString();
	}
	public static void main(String[]args) {
		System.out.println("hi");
	}

}
