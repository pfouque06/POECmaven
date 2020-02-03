package org.eclipse.exo;

public class Rectangle {

	private int l;
	private int p;
	private int Aire;

	public Rectangle(int l, int p) {
		super();
		this.l = l;
		this.p = p;
		this.Aire = l * p;
		System.out.println("Aire= " + this.Aire);
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getAire() {
		return Aire;
	}

	public void setAire(int aire) {
		Aire = aire;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle r = new Rectangle(2, 3);
		System.out.println(r.getAire() + "");
	}

}
