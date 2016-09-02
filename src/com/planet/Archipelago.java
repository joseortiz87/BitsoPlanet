package com.planet;

import java.util.*;

/**
 * The array of island form an archipelago
 * @author joseortiz
 *
 */
public class Archipelago {
	private Map<Island,Boolean> structure;

	public Archipelago(Map<Island, Boolean> structure) {
		super();
		this.structure = structure;
	}

	public Map<Island, Boolean> getStructure() {
		return structure;
	}

	public void setStructure(Map<Island, Boolean> structure) {
		this.structure = structure;
	}
	public String toString(){
		StringBuffer str = new StringBuffer();
		for(Island island : structure.keySet()){
			str.append(island.toString() + "\n");
		}
		return str.toString();
	}
}
