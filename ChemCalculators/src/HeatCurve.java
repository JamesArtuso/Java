import java.util.Scanner;

public class HeatCurve {

	static double m;
	static double n;
	static double mass;
	static double[] T;

	static Scanner io = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Mass: ");
		String mString = io.nextLine();
		System.out.println("Enter moles: ");
		String nString = io.nextLine();
		System.out.println("Enter atomic mass: ");
		String massString = io.nextLine();
		mass = Double.parseDouble(massString);
		try {
			m = Double.parseDouble(mString);
			n = m / mass;
		} catch (Exception e) {
			n = Double.parseDouble(nString);
			m = n * mass;
		}

		System.out.println("Enter phase a Change Temp: ");
		String temp = io.nextLine();
		T = new double[] { Double.parseDouble(temp) };

		System.out.println("Enter phase a Change Temp: ");
		temp = io.nextLine();
		while (temp.compareTo("") != 0) {

			T = addVal(Double.parseDouble(temp), T);
			System.out.println("Enter phase a Change Temp: ");
			temp = io.nextLine();
		}

		System.out.println("Enter Initial Temp: ");
		String tempIString = io.nextLine();
		double tempI = Double.parseDouble(tempIString);
		System.out.println("Enter Final Temp: ");
		String tempFString = io.nextLine();
		double tempF = Double.parseDouble(tempFString);
		boolean negative = false;
		if (tempI > tempF) {
			negative = true;
			double temper = tempF;
			tempF = tempI;
			tempI = temper;
		}

		T = addVal(tempF, T);

		for (int i = 0; i < T.length; i++) {
			System.out.println(T[i]);
		}

		double total = 0;

		System.out.println("Start At Solid C and continue onwards to gas");
		for (int i = 0; i < T.length; i++) {
			System.out.println("Enter C: ");
			String cString = io.nextLine();
			double c = Double.parseDouble(cString);
			total += samePhase(m, c, tempI, T[i]);

			if (i != T.length - 1) {
				System.out.println("Enter H: ");
				String hString = io.nextLine();
				double h = Double.parseDouble(hString);
				total += diffPhase(n, h);
			}
			tempI = T[i];
		}

		if (negative) {
			total = -total;
		}

		System.out.println(total + " J");
		System.out.println("");
		System.out.println(total / 1000 + " kJ");
	}

	public static double samePhase(double m, double c, double ti, double tf) {
		double ans = m * c * (tf - ti);
		return ans;
	}

	public static double diffPhase(double n, double delH) {
		double ans = n * delH;
		return ans;
	}

	public static double[] addVal(double obj, double[] arr) {
		double[] returnarr = new double[arr.length + 1];
		double hold = arr[0];
		for (int i = 0; i < arr.length; i++) {
			hold = arr[i];
			if (arr[i] > obj) {
				returnarr[i] = obj;
				obj = hold;
			} else {
				returnarr[i] = arr[i];
			}
		}
		returnarr[returnarr.length - 1] = obj;
		return returnarr;
	}

}
