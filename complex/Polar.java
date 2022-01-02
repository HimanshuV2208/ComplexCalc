package complex;

public class Polar {
	private double r, theta;
	
	public Polar(double r, double theta) {
		this.r=r;
		this.theta=theta;
	}

	public double getR() {
		return r;
	}

	public double getTheta() {
		return theta;
	}
	
	public void displayPol() {
		System.out.println(r+" ∠"+Math.toDegrees(theta));
	}
	
	public Rectangular getRec() {
		return new Rectangular((r*Math.cos(theta)), (r*Math.sin(theta)));
	}
	
}
