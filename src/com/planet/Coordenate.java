package com.planet;

/**
 * Pair x and y in the 2D world
 * @author joseortiz
 *
 */
public class Coordenate {
	private double x;
	private double y;
	public Coordenate(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
