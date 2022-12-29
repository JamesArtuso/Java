import java.util.Scanner;

public class MMass {
	static Scanner io = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Moles: ");
		String moles = io.nextLine();
		System.out.print("Molar Mass: ");
		;
		String mMass = io.nextLine();
		System.out.print("Total Mass: ");
		String totalMass = io.nextLine();

		String ans = "";
		if (moles.compareTo("") == 0) {
			ans = "moles: " + Double.parseDouble(totalMass) / Double.parseDouble(mMass);
		} else if (mMass.compareTo("") == 0) {
			ans = "MolarMass: " + Double.parseDouble(totalMass) / Double.parseDouble(moles);
		} else {
			ans = "totalMass: " + Double.parseDouble(moles) * Double.parseDouble(mMass);
		}

		System.out.println(ans);

	}

}