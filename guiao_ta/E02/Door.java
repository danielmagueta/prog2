package GTA.E02;


public class Door {
	
  private int r1,r2;
	
  public Door(int r1, int r2, double w, double h) {
	this.r1 = r1;
	this.r2 = r2;
  }
  
  public int getr1() {
	  return r1;
  }
  
  public int getr2() {
	  return r2;
  }
  
  public double area(double w, double h) {
	  return w*h;
  }

}

