package com.planet;

import java.util.*;

/**
 * A type of planet that contains islands
 * @author joseortiz
 *
 */
public class Bitso extends Planet {
	private List<Island> islands;
	private List<Archipelago> archipelagos;
	private Map<Island, List<Island>> neighbors;
	public Bitso(List<Island> islands) {
		super("Bitso");
		this.islands = islands;
	}
	public List<Island> getIslands() {
		return islands;
	}
	public void setIslands(List<Island> islands) {
		this.islands = islands;
	}
	public List<Archipelago> getArchipelagos() {
		return archipelagos;
	}
	public void setArchipelagos(List<Archipelago> archipelagos) {
		this.archipelagos = archipelagos;
	}
	
	/**
	 * Algorithm to find archipelagos in planet
	 * @author joseortiz
	 */
	public void searchForArchipelagos(){
		archipelagos = new ArrayList<Archipelago>();
		neighbors = new HashMap<Island, List<Island>>();
		
		//SEARCH FOR ISLAND NEIGHTBORDS FOR EACH ISLAND
		for(int i=0;i<islands.size();i++){
			Island tempIsland = islands.remove(0);
			for(Island tempIsland2 : islands){
				if(tempIsland.isNeighbor(tempIsland2)){
					List<Island> tmpListNeighbors = null;
					if(!neighbors.containsKey(tempIsland)){
						tmpListNeighbors = new ArrayList<Island>();
					}else{
						tmpListNeighbors = neighbors.get(tempIsland);
					}
					tmpListNeighbors.add(tempIsland2);
					neighbors.put(tempIsland, tmpListNeighbors);
				}
			}
			islands.add(tempIsland);
		}
		
		//SEARCH FOR ARCHIPELAGOS
		for(Island tempIsland : islands){
			findConnections(tempIsland,1,null);
		}
		
		System.out.println(archipelagos.size());
		//printArchipielago();
	}
	
	/**
	 * @author joseortiz
	 */
	public void printArchipielago(){
		for(Archipelago archipelago : archipelagos){
			System.out.println(archipelago.toString());
		}
	}
	
	/**
	 * Recursive algorithm to find Archipelago
	 * @author joseortiz
	 * @param island
	 * @param depth
	 * @param visited
	 */
	public void findConnections(Island island,int depth,Map<Island,Boolean> visited){
		List<Island> currentNeightbords = neighbors.get(island);
		if(visited == null){
			visited = new HashMap<Island,Boolean>();
		}
		visited.put(island,new Boolean(true));
		if(depth == 3){
			archipelagos.add(new Archipelago(visited));
		}else if(depth < 3 && currentNeightbords != null && currentNeightbords.size() > 0){
			for(Island islandNeightboar : currentNeightbords){
				if(!visited.containsKey(islandNeightboar)){
					findConnections(islandNeightboar,depth+1,visited);
					visited.remove(islandNeightboar);
				}
			}
		}
		return;
	}
}
