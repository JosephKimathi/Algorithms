package Tuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeDeleteTest {

	TreeDelete tree;

	private void createList(String expected, int... elements) {
		tree = new TreeDelete();
		for (int i = 0; i < elements.length; i++) {
			tree.insert(elements[i]);
			assertEquals(i + 1, tree.getSize());
		}
		assertEquals(expected, tree.toString());
	}

	private void addToList(String expected, int... elements) {
		int n = tree.getSize();
		for (int i = 0; i < elements.length; i++) {
			tree.insert(elements[i]);
			assertEquals(n + i + 1, tree.getSize());
		}
		assertEquals(expected, tree.toString());
	}

	private void delete(int element, String expected) {
		tree.delete(element);
		assertEquals(expected, tree.toString());
	}

	@Test
	public void test01() {
		createList("(10)", 10);
		addToList("((5) 10)", 5);
		addToList("((5) 10 (20))", 20);
		addToList("(((3) 5) 10 (20))", 3);
		addToList("(((3) 5 (7)) 10 (20))", 7);
	}

	@Test
	public void test02() {
		createList("(((3) 5 (7)) 10 (20))", 10, 5, 20, 3, 7);
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(7));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(20));
		assertFalse(tree.contains(1));
		assertFalse(tree.contains(4));
		assertFalse(tree.contains(8));
		assertFalse(tree.contains(11));
		assertFalse(tree.contains(21));
	}
	
	@Test
	public void test03() {
		createList("()");
		delete(9, "()");
	}
	
	@Test
	public void test04() {
		createList("(10)", 10);
		delete(9, "(10)");
		delete(10, "()");
		delete(9, "()");
	}
	
	@Test
	public void test05() {
		createList("((5) 10)", 10, 5);
		delete(9, "((5) 10)");
		delete(10, "(5)");
		delete(9, "(5)");
	}
	
	@Test
	public void test06() {
		createList("((5) 10)", 10, 5);
		delete(9, "((5) 10)");
		delete(5, "(10)");
		delete(9, "(10)");
	}
	
	@Test
	public void test07() {
		createList("(10 (20))", 10, 20);
		delete(9, "(10 (20))");
		delete(10, "(20)");
		delete(9, "(20)");
	}
	
	@Test
	public void test08() {
		createList("(10 (20))", 10, 20);
		delete(9, "(10 (20))");
		delete(20, "(10)");
		delete(9, "(10)");
	}
	
	@Test
	public void test09() {
		createList("((5) 10 (20))", 10, 5, 20);
		delete(9, "((5) 10 (20))");
		delete(10, "(5 (20))");
		delete(9, "(5 (20))");
	}
	
	@Test
	public void test10() {
		createList("((5) 10 (20))", 10, 5, 20);
		delete(9, "((5) 10 (20))");
		delete(5, "(10 (20))");
		delete(9, "(10 (20))");
	}
	
	@Test
	public void test11() {
		createList("((5) 10 (20))", 10, 5, 20);
		delete(9, "((5) 10 (20))");
		delete(20, "((5) 10)");
		delete(9, "((5) 10)");
	}
	
	@Test
	public void test12() {
		createList("((5 (7)) 10 (20))", 10, 5, 20, 7);
		delete(9, "((5 (7)) 10 (20))");
		delete(10, "((5) 7 (20))");
		delete(9, "((5) 7 (20))");
	}
	
	@Test
	public void test13() {
		createList("((5 (7)) 10 (20))", 10, 5, 20, 7);
		delete(9, "((5 (7)) 10 (20))");
		delete(5, "((7) 10 (20))");
		delete(9, "((7) 10 (20))");
	}
	
	@Test
	public void test14() {
		createList("((5 (7)) 10 (20))", 10, 5, 20, 7);
		delete(9, "((5 (7)) 10 (20))");
		delete(20, "((5 (7)) 10)");
		delete(9, "((5 (7)) 10)");
	}
	
	@Test
	public void test15() {
		createList("(((3) 5) 10 (20))", 10, 5, 20, 3);
		delete(9, "(((3) 5) 10 (20))");
		delete(10, "((3) 5 (20))");
		delete(9, "((3) 5 (20))");
	}
	
	@Test
	public void test16() {
		createList("(((3) 5) 10 (20))", 10, 5, 20, 3);
		delete(9, "(((3) 5) 10 (20))");
		delete(5, "((3) 10 (20))");
		delete(9, "((3) 10 (20))");
	}
	
	@Test
	public void test17() {
		createList("(((3) 5) 10 (20))", 10, 5, 20, 3);
		delete(9, "(((3) 5) 10 (20))");
		delete(20, "(((3) 5) 10)");
		delete(9, "(((3) 5) 10)");
	}
	
	@Test
	public void test18() {
		createList("((32 ((40 ((42 (43)) 44)) 48)) 64)", 64, 32, 48, 40, 44, 42, 43);
		delete(99, "((32 ((40 ((42 (43)) 44)) 48)) 64)");
		delete(64, "((32 ((40 ((42) 43)) 44)) 48)");
	}
	
}
