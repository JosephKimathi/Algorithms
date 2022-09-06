package Practice;

import java.util.Iterator;

@SuppressWarnings("unused")
public class Test<S> {

	// An object of type T is declared
	S obj;

	// constructor
	Test(S obj) {
		this.obj = obj;
	}

	public S getObject() {
		return this.obj;
	} // A Generic method example

	static <S> void genericDisplay(S element) {
		System.out.println(element.getClass().getCanonicalName() + " = " + element);
	}
}
