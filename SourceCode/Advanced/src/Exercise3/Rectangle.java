package Exercise3;

public class Rectangle extends Shape{
	private Point topleft;
	private double length;
	private double width;
	
	public Rectangle(double top,double left, double b, double c) {
		super("Rectangle");
		topleft = new Point(top,left);
		length = b;
		width = c;
		
	}
	
	public void setLength(double r) {
		
		length = r;
	}
	public double getLength() {
		return length;
	}
	
	public void setTopleft(double a, double b) {
		topleft = new Point(a,b);
	}
	
		public Point getTopleft() {
			return topleft;
		}
		
		public void setWidth(double r) {
			width = r;
		}
		public double getWidth() {
			return width;
		}
		

		@Override
		public double getArea() {
			return length * width;
		}
		
		public String toString() {
			return topleft.toString();
		}
}
