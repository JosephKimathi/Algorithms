package Practice;

//Driver class to test above 
class Main {
	public static void main(String[] args) {
		// instance of Integer type
		Test<Integer> iObj = new Test<Integer>(15);
		System.out.println(iObj.getObject());

		// instance of String type
		Test<String> sObj = new Test<String>("GeeksForGeeks");
		System.out.println(sObj.getObject());
		Vector v = new Vector(new double[10]);
		Test.genericDisplay(v);
	}
}