package Exercise3;

public class Circle extends Shape{

	private Point center;
	private double radius;
	
	public Circle(int a, int b, double c) {
		super("Circle");
		center = new Point(a,b);
		radius = c;
		
	}
	
	public void setRadius(double r) {
		
		radius = r;
	}
	public double getradius() {
		return radius;
	}
	
	public void setCenter(double a, double b) {
		center = new Point(a,b);
	}
	
		public Point getCenter() {
			return center;
		}

		@Override
		public double getArea() {
			return Math.PI * Math.pow(radius,2);
		}
		
		public String toString() {
			return center.toString();
		}
		
		
		
		
		
		
}
