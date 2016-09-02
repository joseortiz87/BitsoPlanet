package com.planet;


/**
 * Island defined by location
 * @author joseortiz
 *
 */
public class Island {
	private Coordenate coordenate;
	public Island(double x,double y) {
		super();
		this.coordenate = new Coordenate(x,y);
	}
	public Coordenate getCoordenate() {
		return coordenate;
	}
	public void setCoordenate(Coordenate coordenate) {
		this.coordenate = coordenate;
	}
	/**
	 * 
	 * @param island
	 * @return boolean
	 */
	public boolean isNeighbor(Island island){
		double diffX = Math.abs(this.coordenate.getX()-island.getCoordenate().getX());
		double diffY = Math.abs(this.coordenate.getY()-island.getCoordenate().getY());
		if(diffX == 1){
			return this.coordenate.getY() == island.getCoordenate().getY();
		}else if(diffY == 1){
			return this.coordenate.getX() == island.getCoordenate().getX();
		}
		return false;
	}
	public String toString(){
		return "(" + coordenate.getX() + "," + coordenate.getY() + ")";
	}
}
