public class Rectangle {
    private double width;
    private double height;

    public Rectangle()
    {
      this.setWidth(1.0);
      this.setHeight(1.0);
    }
    public Rectangle(double side)
    {
      this.setWidth(side);
      this.setHeight(side);
    }
    public Rectangle(double w, double h)
    {
      this.setWidth(w);
      this.setHeight(h);
    }

    public void setWidth(double w) throws IllegalArgumentException
    {
      if (w <= 0) {
        throw new IllegalArgumentException("Width needs to be greater than 0");
      }
      this.width = w;
    }
    public void setHeight(double h) throws IllegalArgumentException
    {
      if (h <= 0) {
        throw new IllegalArgumentException("Height needs to be greater than 0");
      }
      this.height = h;
    }
    public double getWidth()
    {
      return this.format(this.width);
    }
    public double getHeight()
    {
      return this.format(this.height);
    }
    public double getPerimeter()
    {
      return 2 * (this.width + this.height);
    }
    public double getArea()
    {
      return this.width * this.height;
    }
    public boolean isSquare()
    {
      return this.width == this.height;
    }

    public String toString()
    {
      return "Width: " + this.getWidth() + " Height: " + this.getHeight();
    }

    // used to format to 2 decimal places...
    // based on the discussion board post of Erin Cochran
    private double format(double value)
    {
      return ((double)(int)(value * 100)) / 100;
    }
}
