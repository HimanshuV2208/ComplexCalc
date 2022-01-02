package complex;

import complex.Main.Operate;

public class EqnSolver {
	
	private Rectangular f1, f2, f3, f4, f5, f6;
	private Rectangular z1, z2;
	
	public EqnSolver(Rectangular f1, Rectangular f2, Rectangular f3, Rectangular f4,
			Rectangular f5, Rectangular f6) {
		this.f1=f1;
		this.f2=f2;
		this.f3=f3;
		this.f4=f4;
		this.f5=f5;
		this.f6=f6;
	}
	
	private void solve() {
		z1 = Operate.multiply(Operate.add(Operate.multiply(f3, f5, true), Operate.multiply(f6, f2, true), false)
				,(Operate.add(Operate.multiply(f1, f5, true),(Operate.multiply(f4,  f2, true)), false)), false); 
		z2 = Operate.multiply(Operate.add(Operate.multiply(f3, f4, true), Operate.multiply(f6, f1, true), false)
				,(Operate.add(Operate.multiply(f2, f4, true),(Operate.multiply(f5,  f1, true)), false)), false); 
	}
	
	public void display(boolean rec) {
		this.solve();
		System.out.print("z1 = ");
		if(rec)	z1.displayRec(); else z1.getPolar().displayPol();
		System.out.print("z2 = ");
		if(rec)	z2.displayRec(); else z2.getPolar().displayPol();
	}
	
}
