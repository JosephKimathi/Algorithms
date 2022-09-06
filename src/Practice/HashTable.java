package Practice;

public class HashTable<Key, Value>  {
	private final int m = 1024;
	private final Node[] table = new HashTable.Node[m]; // table
//
//	// A linked list data type
//	private class Node {
//		private final Key key;
//		private Value val;
//		private Node next;
//
//		private Node(Key k, Value val, Node next) {
//			key = k;
//			this.val = val;
//			this.next = next;
//		}
//	}

	private class Node {
		private final Object key;
		private Object val;
		private HashTable.Node next;

		private Node(Key k, Value v, HashTable.Node n) {
			// node x
			// x == hash(key), x = value, x points to n
			key = k;
			next = n;
			val = v;
		}
	}

	int hash(Key key) {
		// return integer x, 0<=x<=m-1, used in array
		return Math.abs(key.hashCode() % m);
	}

	@SuppressWarnings("unchecked")
	Value get(Key k) {
		int i = hash(k);
		Value ans = null;
		for (Node x = table[i]; x != null; x = x.next) 
			if(k.equals(x)) {
				ans = (Value) x.val;
				table [i]= x.next;
//				}
//			if(k.equals(x))
//				return (Value)x.val;
		}
//		return null;
//		end alternate code
		return ans;
	}

	@SuppressWarnings("unchecked")
	void put(Key k, Value v) {
		// first turn to hash value
		// i is reference in area
		int i = hash(k);
//		table[i] = uses hash conversion to allocate storage
//		linked list within  an array stored with hash codes
		/*
		 * Node x=table [i]; w
		 * hile(x!+null){ 
		 * if(k.equals(x.key)) 
		 * 		x.val = v; 
		 *	 	x = x.next;
		 * //if(x.next == null), loop breaks 
		 * } 
		 * //table = array of type nodes
		 *  table [i] = New Node(k, v, table [i]); 
		 *  //new table [i] points to old table[i]
		 *  //end of alternate code
		 */
		for (Node x = table[i]; x != null; x = x.next) {
			if (k.equals(x.key))
				x.val = v;
		}
		table[i] = new Node(k, v, table[i]);
	}
	public static void main(String []args) {
		HashTable<String, Double> h= new HashTable<>();
		
	}
}
