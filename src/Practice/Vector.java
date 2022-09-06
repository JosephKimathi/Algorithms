package Practice;

public class Vector {
	private double[] coords;

	public Vector(double[] a) {
		coords = a;
	}
	public double cartesian(int i) {
		return coords[i];
	}
	@Override
	public String toString() {
		return coords[0]+"i "+ coords[1]+"j "+coords[2]+"k ";
	}
	public Vector plus(Vector b){
		int n= Math.max(coords.length, b.length());
		double [] temp = new double[n];
		double []hold =new double[n];
		if(coords.length<n)
			for(int i=0;i<coords.length;i++) {
				temp[i] = coords[i];
			}
		coords =temp;
		for(int i=0;i<n;i++) {
			hold[i] = coords[i]+b.coords[i];
		}
		return new Vector(hold);
	}

	public Vector minus(Vector b) {
		int n= Math.max(coords.length, b.length());
		double [] temp = new double[n];
		double []hold =new double[n];
		if(coords.length<n)
			for(int i=0;i<coords.length;i++) {
				temp[i] = coords[i];
			}
		coords =temp;
		for(int i=0;i<n;i++) {
			hold[i] = coords[i]-b.coords[i];
		}
		return new Vector(hold);
		
	}

	public Vector times(double t) {
		double hold[] = new double[coords.length];
		for(int i=0;i<coords.length;i++)
			hold[i] = coords[i]*t;
		return new Vector(hold);
	}
	public double dot(Vector b) {
		double ans =0;
		for(int i=0;i<coords.length;i++) {
			ans += coords[i]*b.coords[i];
		}
		return ans;
	}
	public Vector direction() {
		Vector ans = new Vector(coords);
		ans = ans.times(1/ans.magnitude());
		return ans;
	}
	public double magnitude() {
		double ans = 0;
		for(int i=0;i<coords.length;i++)
			ans+= Math.pow(coords[i], 2);
		return Math.sqrt(ans);
	}
	public int length() {
		return coords.length;
	}

}
