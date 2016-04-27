/*     CircleDriver.java
 * A test driver for the Circle.java class.
 * Place both files in the same directory.
 * Compiling this class will also compile the Circle.java class
 */
public class CircleDriver {

	public static void main(String[] args) {

		Circle[] circles = new Circle[10];
		try{
		circles[1] = new Circle();
		circles[2] = new Circle(2.0);
		circles[3] = new Circle(3.5);
		circles[4] = new Circle(5.0);
		circles[5] = new Circle(10.0);
		circles[6] = new Circle(15.123);
		circles[7] = new Circle(25);
		circles[8] = new Circle(-7);
		circles[9] = new Circle(0.0);
		}
		catch (IllegalArgumentException ex){
			System.out.println("********  " + ex.getMessage() + "  *********");
		}
		System.out.println("Initial call to toString():");
		for(Circle c : circles)
			System.out.println("\t" + c);

		System.out.println("\nCall to getRadius (should be same as above):");
		for(Circle r : circles)
			if(r != null)
				System.out.println("\t" + r.getRadius());

		System.out.println("\nCall to getDiameter (should be twice the value shown above):");
		for(Circle d : circles)
			if(d != null)
		System.out.println("\t" + d.getDiameter());

		System.out.println("\nCalls to getCircumference:");
		System.out.println("\tShould be 6.28:  " + circles[1].getCircumference());
		System.out.println("\tShould be 31.42:  " + circles[4].getCircumference());

		System.out.println("\nCall to getArea:");
		System.out.println("\tShould be PI:  " + circles[1].getArea());
		System.out.println("\tShould be 314.16:  " + circles[5].getArea());

		System.out.println("\nTesting out the setRadius method:");
		for(int i = 0; i < circles.length/2; i++)
			if(circles[i] != null)
				circles[i].setRadius(i);

		System.out.println("\nCall to toString after setting the first half of the objects:");
		for(Circle c : circles)
			System.out.println("\t" + c);
	}
}
