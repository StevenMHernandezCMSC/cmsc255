public class Circle {
    private double radius;

    public Circle()
    {
      this.setRadius(1.0);
    }
    public Circle(double r)
    {
      this.setRadius(r);
    }

    public void setRadius(double r) throws IllegalArgumentException
    {
      if (r <= 0) {
        throw new IllegalArgumentException("Radius needs to be greater than 0");
      }
      this.radius = r;
    }
    public double getRadius()
    {
      return this.format(this.radius);
    }

    public double getDiameter()
    {
      return this.format(2 * this.radius);
    }
    public double getCircumference()
    {
      return this.format(2 * Math.PI * this.radius);
    }
    public double getArea()
    {
      return this.format(Math.PI * Math.pow(this.radius, 2));
    }
    public String toString()
    {
      return "Radius: " + this.getRadius();
    }

    // used to format to 2 decimal places...
    // based on the discussion board post of Erin Cochran
    private double format(double value)
    {
      return ((double)(int)(value * 100)) / 100;
    }
}
