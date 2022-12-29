import java.util.Scanner;

public class Molarity {
	static Scanner io = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("M1: ");
		String m1 = io.nextLine();
		System.out.print("L1: ");
		;
		String l1 = io.nextLine();
		System.out.print("M2: ");
		String m2 = io.nextLine();
		System.out.print("L2: ");
		String l2 = io.nextLine();

		String ans = "";
		if (m2.compareTo("") == 0) {
			ans = "m2: " + Double.parseDouble(m1) * Double.parseDouble(l1) / Double.parseDouble(l2);
		} else {
			ans = "mL: " + Double.parseDouble(m1) * Double.parseDouble(l1) / Double.parseDouble(m2);
		}

		System.out.println(ans);

	}

}
