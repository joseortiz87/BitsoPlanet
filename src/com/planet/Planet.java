package com.planet;

/**
 * Father class
 * @author joseortiz
 *
 */
public class Planet {
	private String name;
	public Planet(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
