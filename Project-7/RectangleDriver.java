/*     RectangleDriver.java
 * A test driver for the Rectangle.java class.
 * Place both files in the same directory.
 * Compiling this class will also compile the Rectangle.java class
 */
public class RectangleDriver {

	public static void main(String[] args) {

		Rectangle[] rectangles = new Rectangle[10];
		try{
		rectangles[1] = new Rectangle();
		rectangles[2] = new Rectangle(2.0);
		rectangles[3] = new Rectangle(1,99.0);
		rectangles[4] = new Rectangle(3,3);
		rectangles[5] = new Rectangle(10.0,10.0);
		rectangles[6] = new Rectangle(-7);
		rectangles[7] = new Rectangle(-7,9);
		rectangles[8] = new Rectangle(-7,-7);
		rectangles[9] = new Rectangle(0.0, 0.0);
		}
		catch (IllegalArgumentException ex){
			System.out.println("********  " + ex.getMessage() + "  *********");
		}
		System.out.println("Initial call to toString():");
		for(Rectangle r : rectangles)
			System.out.println("\t" + r);

		System.out.println("\nCall to getWidth and getHeight (should be same values as above):");
		for(Rectangle r : rectangles)
			if(r != null)
				System.out.println("\tWidth: " + r.getWidth() + " Height: " + r.getHeight());

		System.out.println("\nCalls to getPerimeter:");
		System.out.println("\tShould be 12.0:  " + rectangles[4].getPerimeter());
		System.out.println("\tShould be 40.0:  " + rectangles[5].getPerimeter());

		System.out.println("\nCalls to getArea:");
		System.out.println("\tShould be 9.0:  " + rectangles[4].getArea());
		System.out.println("\tShould be 100.0:  " + rectangles[5].getArea());

		System.out.println("\nTesting out the setWidth method:");
		for(int i = 0; i < rectangles.length/2; i++)
			if(rectangles[i] != null)
				rectangles[i].setWidth(i);
		System.out.println("\nTesting out the setHeight method:");
		for(int i = 0; i < rectangles.length/2; i++)
			if(rectangles[i] != null)
				rectangles[i].setHeight(i);

		System.out.println("\nCall to toString after setting the first half of the objects:");
		for(Rectangle c : rectangles)
			System.out.println("\t" + c);
	}
}
