/**
 * 
 */
package birch;

/**
 * @author tim
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReportItemSet ris = new ReportItemSet();

		// ris.read();
		// System.out.println(ris.toString());
		// System.out.println(ris.toHTML());

		try {
			ris.process();
		} catch (Exception x) {
			System.err.format("Exception: %s%n", x);
		}

		Bicycle bike = new Bicycle(100, 200, 300);
		MountainBike mtb = new MountainBike(10, 20, 30, 40);

		System.out.println(mtb.toString());
		System.out.println(bike.toString());



		Dog aDog = new Dog("Max");
		// we pass the object to foo
		fooA(aDog);
		// aDog variable is still pointing to the "Max" dog when foo(...)
		// returns
		if (!aDog.getName().equals("Name is: Max")) // true, java passes by value
		{
			System.out
					.println("Unexpected result from aDog.getName().equals(Max) A" + aDog.getName());
		}
 
		if (aDog.getName().equals("Name is: Fifi")) // false
		{
			System.out
					.println("Unexpected result from aDog.getName().equals(Fifi) A" + aDog.getName());
		}


		Dog bDog = new Dog("Max");
		fooB(bDog);
		// when foo(...) returns, the name of the dog has been changed to "Fifi"

		if (bDog.getName().equals("Name is: Max")) // false, java passes by value
		{
			System.out
					.println("Unexpected result from aDog.getName().equals(Max) B " + aDog.getName());
		}
		
		if (!bDog.getName().equals("Name is: Fifi")) // true
		{
			System.out
					.println("Unexpected result from aDog.getName().equals(Fifi) B " + aDog.getName());
		}
		
		String intString = "153a";

		int aaa = 0;

		/*
		 * If you want an Exception that is unchecked, you need to extend
		 * RuntimeException. Note: A checked Exception is one that requires you
		 * to either surround the Exception in a try/catch block or have a
		 * 'throws' clause on the method declaration. (like IOException)
		 * Unchecked Exceptions may be thrown just like checked Exceptions, but
		 * you aren't required to explicitly handle them in any way
		 * (IndexOutOfBoundsException).
		 */
		try {
			aaa = Integer.getInteger(intString);
		} catch (Exception x) {
			throw new TrmException("Invalid Integer Conversion");
		}

		System.out.println("aaa is: " + Integer.toString(aaa));
	}

	public static void fooA(Dog d) {
		d.getName().equals("Max"); // true
		// change d inside of foo() to point to a new Dog instance "Fifi"
		d = new Dog("Fifi");
		d.getName().equals("Fifi"); // true
	}

	public static void fooB(Dog d) {
		d.getName().equals("Max"); // true
		// this changes the name of d to be "Fifi"
		d.setName("Fifi");
	}
}
