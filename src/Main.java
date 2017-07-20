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
	}
}
