package complex;

public class Rectangular {
	private double x, y;

	public Rectangular(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void displayRec() {
		System.out.println(x+" + i"+y);
	}
	
	public Polar getPolar() {
		double r = Math.sqrt(x*x+y*y);
		double theta = Math.atan2(y, x);
		return new Polar(r, theta);
	}
	
}
