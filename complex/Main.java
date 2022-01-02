package complex;

import java.util.Scanner;

public class Main {

	private static final Scanner sc = new Scanner(System.in);

	static class Operate{

		static Rectangular add(Rectangular z1, Rectangular z2, boolean plus) {
			if(plus)
				return new Rectangular(z1.getX()+z2.getX(), z1.getY()+z2.getY());
			else
				return new Rectangular(z1.getX()-z2.getX(), z1.getY()-z2.getY());
		}

		static Polar add(Polar z1, Polar z2, boolean plus) {
			Rectangular ans = add(z1.getRec(), z2.getRec(), plus);
			return ans.getPolar();
		}

		static Polar multiply(Polar z1, Polar z2, boolean mul) {
			if(mul)
				return new Polar(z1.getR()*z2.getR(), z1.getTheta()+z2.getTheta());
			else
				return new Polar(z1.getR()/z2.getR(), z1.getTheta()-z2.getTheta());
		}

		static Rectangular multiply(Rectangular z1, Rectangular z2, boolean mul) {
			Polar ans = multiply(z1.getPolar(), z2.getPolar(), mul);
			return ans.getRec();
		}

	}
	
	static int displayOptions() {
		System.out.println("Enter your choice : ");
		System.out.println("1 - Convert rectangular to polar form");
		System.out.println("2 - Convert polar to rectangular form");
		System.out.println("3 - Add rectangular complex");
		System.out.println("4 - Subtract rectangular complex");
		System.out.println("5 - Multiply rectangular complex");
		System.out.println("6 - Divide rectangular complex");
		System.out.println("7 - Add polar complex");
		System.out.println("8 - Subtract polar complex");
		System.out.println("9 - Multiply polar complex");
		System.out.println("10 - Divide polar complex");
		System.out.println("11 - Equation Solver (Rectangular)");
		System.out.println("12 - Equation Solver (Polar)");
		System.out.println("13 - Exit");

		int choice = sc.nextInt();
		if(choice<1 || choice>13) {
			System.out.println("Invalid input");
			return -1;
		} else if(choice == 13) {
			System.out.println("Thank you for using this application");
			System.exit(0);
		}
		return choice;
	}

	static Rectangular inputRect() {
		System.out.println("Enter values X+iY :");
		System.out.print("X : ");
		double x = sc.nextDouble();
		System.out.print("Y : ");
		double y = sc.nextDouble();
		return new Rectangular(x, y);
	}

	static Polar inputPol() {
		System.out.println("Enter values r∠θ :");
		System.out.print("r : ");
		double r = sc.nextDouble();
		System.out.print("θ (in degrees) : ");
		double theta = Math.toRadians(sc.nextDouble());
		return new Polar(r, theta);
	}

	static void option1() {
		Polar z = inputRect().getPolar();
		System.out.print("Polar form : ");
		z.displayPol();
	}

	static void option2() {
		Rectangular z = inputPol().getRec();
		System.out.print("Rectangular form : ");
		z.displayRec();
	}

	static void option3() {
		Rectangular z1 = inputRect();
		Rectangular z2 = inputRect();
		Rectangular z = Operate.add(z1, z2, true);
		System.out.print("Answer : ");
		z.displayRec();
	}

	static void option4() {
		Rectangular z1 = inputRect();
		Rectangular z2 = inputRect();
		Rectangular z = Operate.add(z1, z2, false);
		System.out.print("Answer : ");
		z.displayRec();
	}
	
	static void option5() {
		Rectangular z1 = inputRect();
		Rectangular z2 = inputRect();
		Rectangular z = Operate.multiply(z1, z2, true);
		System.out.print("Answer : ");
		z.displayRec();
	}
	
	static void option6() {
		Rectangular z1 = inputRect();
		Rectangular z2 = inputRect();
		Rectangular z = Operate.multiply(z1, z2, false);
		System.out.print("Answer : ");
		z.displayRec();
	}
	
	static void option7() {
		Polar z1 = inputPol();
		Polar z2 = inputPol();
		Polar z = Operate.add(z1, z2, true);
		System.out.print("Answer : ");
		z.displayPol();
	}
	
	static void option8() {
		Polar z1 = inputPol();
		Polar z2 = inputPol();
		Polar z = Operate.add(z1, z2, false);
		System.out.print("Answer : ");
		z.displayPol();
	}
	
	static void option9() {
		Polar z1 = inputPol();
		Polar z2 = inputPol();
		Polar z = Operate.multiply(z1, z2, true);
		System.out.print("Answer : ");
		z.displayPol();
	}
	
	static void option10() {
		Polar z1 = inputPol();
		Polar z2 = inputPol();
		Polar z = Operate.multiply(z1, z2, false);
		System.out.print("Answer : ");
		z.displayPol();
	}
	
	static void option11() {
		System.out.println("For equations: f1*z1 + f2*z2 = f3 & f4*z1 + f5*z2 = f6");
		System.out.print("Enter f1 : ");
		Rectangular f1 = inputRect();
		System.out.print("Enter f2 : ");
		Rectangular f2 = inputRect();
		System.out.print("Enter f3 : ");
		Rectangular f3 = inputRect();
		System.out.print("Enter f4 : ");
		Rectangular f4 = inputRect();
		System.out.print("Enter f5 : ");
		Rectangular f5 = inputRect();
		System.out.print("Enter f6 : ");
		Rectangular f6 = inputRect();
		EqnSolver solver = new EqnSolver(f1, f2, f3, f4, f5, f6);
		solver.display(true);
	}
	
	static void option12() {
		System.out.println("For equations: f1*z1 + f2*z2 = f3 & f4*z1 + f5*z2 = f6");
		System.out.print("Enter f1 : ");
		Rectangular f1 = inputPol().getRec();
		System.out.print("Enter f2 : ");
		Rectangular f2 = inputPol().getRec();
		System.out.print("Enter f3 : ");
		Rectangular f3 = inputPol().getRec();
		System.out.print("Enter f4 : ");
		Rectangular f4 = inputPol().getRec();
		System.out.print("Enter f5 : ");
		Rectangular f5 = inputPol().getRec();
		System.out.print("Enter f6 : ");
		Rectangular f6 = inputPol().getRec();
		EqnSolver solver = new EqnSolver(f1, f2, f3, f4, f5, f6);
		solver.display(false);
	}

	public static void main(String[] args) {
		String ch = "Y";
		while(ch.equalsIgnoreCase("Y")) {
			switch(displayOptions()) {
			case 1:
				option1(); break;
			case 2:
				option2(); break;
			case 3:
				option3(); break;
			case 4:
				option4(); break;
			case 5:
				option5(); break;
			case 6:
				option6(); break;
			case 7:
				option7(); break;
			case 8:
				option8(); break;
			case 9:
				option9(); break;
			case 10:
				option10(); break;
			case 11:
				option11(); break;
			case 12:
				option12(); break;
			case -1:
				break;
			}
			System.out.println("More inputs? (Y/N)");
			ch = sc.next();
		}
		System.out.println("Thank you for using this application");
	}

}
