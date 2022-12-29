import java.util.Scanner;

public class Stoichiochemistry {
	static Scanner io = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double g1;
		double n1;
		double c1;
		double c2;

		System.out.print("g1: ");
		String g1s = io.nextLine();
		System.out.print("n1: ");
		;
		String n1s = io.nextLine();
		System.out.print("mm1: ");
		String mm1s = io.nextLine();
		System.out.print("mm2: ");
		String mm2s = io.nextLine();
		System.out.print("Coeff1: ");
		String c1s = io.nextLine();
		System.out.print("Coeff2: ");
		String c2s = io.nextLine();

		double n2;
		double g2;

		double mm1 = Double.parseDouble(mm1s);
		double mm2 = Double.parseDouble(mm2s);

		if (c1s.compareTo("") == 0) {
			c1 = 1;
		} else {
			c1 = Double.parseDouble(c1s);
		}
		if (c2s.compareTo("") == 0) {
			c2 = 1;
		} else {
			c2 = Double.parseDouble(c2s);
		}

		if (g1s.compareTo("") == 0) {
			n1 = Double.parseDouble(n1s);
			n2 = n1 * (c2 / c1);
			g2 = n2 * mm2;
		} else {
			g1 = Double.parseDouble(g1s);
			g2 = g1 * ((c2 * mm2) / (c1 * mm1));
			n2 = g2 / mm2;
		}

		System.out.println("Gram: " + g2 + "\nMoles: " + n2);

	}

}
