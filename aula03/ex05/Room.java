package aula03.ex05;

public class Room {
	
	private String tipo;
	private Point bl, tr;
	
	public Room(Point bl, Point tr, String tipo) {
		this.tipo = tipo;
		this.bl = bl;
		this.tr = tr;
	}
	
	public String roomType() {
		return tipo;
	}
	
	public Point bottomLeft() {
		return bl;
	}
	
	public Point topRight() {
		return tr;
	}
	
	public Point geomCenter() {
		Point c = this.bottomLeft().halfWayTo(this.topRight());
		return c;
	}
	
	public double area() {
		double x = tr.x()-bl.x();
		double y = tr.y()-bl.y();
		return x*y;
	}
}
