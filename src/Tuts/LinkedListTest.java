package Tuts;

import static org.junit.Assert.*;

import org.junit.Test;
public class LinkedListTest {

	LinkedList list;

	private void createList(String expected, int... elements) {
		list = new LinkedList();
		for (int i = 0; i < elements.length; i++) {
			list.insert(elements[i]);
			assertEquals(i + 1, list.getSize());
		}
		assertEquals(expected, list.toString());
	}

	private void addToList(String expected, int... elements) {
		int n = list.getSize();
		for (int i = 0; i < elements.length; i++) {
			list.insert(elements[i]);
			assertEquals(n + i + 1, list.getSize());
		}
		assertEquals(expected, list.toString());
	}

	private void delete(int element, String expected) {
		list.delete(element);
		assertEquals(expected, list.toString());
	}

	@Test
	public void test01() {
		createList("[1 2 3 4]", 1, 2, 3, 4);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test02() {
		createList("[1 2 3 4]", 1, 2, 4, 3);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test03() {
		createList("[1 2 3 4]", 1, 3, 2, 4);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test04() {
		createList("[1 2 3 4]", 1, 3, 4, 2);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test05() {
		createList("[1 2 3 4]", 1, 4, 2, 3);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test06() {
		createList("[1 2 3 4]", 1, 4, 3, 2);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test07() {
		createList("[1 2 3 4]", 3, 1, 2, 4);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test08() {
		createList("[1 2 3 4]", 3, 1, 4, 2);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test09() {
		createList("[1 2 3 4]", 3, 2, 1, 4);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test10() {
		createList("[1 2 3 4]", 4, 3, 2, 1);
		delete(5, "[1 2 3 4]");
		delete(4, "[1 2 3]");
	}

	@Test
	public void test11() {
		createList("[1 2 3 4 5 6 7]", 7, 1, 6, 2, 5, 3, 4);
		delete(8, "[1 2 3 4 5 6 7]");
		delete(6, "[1 2 3 4 5 7]");
		delete(6, "[1 2 3 4 5 7]");
		delete(1, "[2 3 4 5 7]");
		delete(1, "[2 3 4 5 7]");
		addToList("[1 2 3 4 5 7]", 1);
		delete(1, "[2 3 4 5 7]");
		delete(1, "[2 3 4 5 7]");
		delete(4, "[2 3 5 7]");
		delete(4, "[2 3 5 7]");
		delete(7, "[2 3 5]");
	}

}
