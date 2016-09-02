package com.planet.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.planet.Bitso;
import com.planet.Island;

public class BitsoTest {
	public static void main(String ags[]){
		boolean isFileReady = false;
		String filename = null;
		File inputFile = null;
		Scanner reader = null;
		Scanner scanner = new Scanner(System.in);
		
		//ASK FOR FILE PATH IN THE SYSTEM
		while(!isFileReady){
			System.out.print("Map File path:");
			filename = scanner.nextLine();
			if(filename != null){
				inputFile = new File(filename);
				try {
					reader = new Scanner(inputFile);
					isFileReady = true;
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("File not found!");
				}
			}
		}
		
		//Start reading file
		int testCases = reader.nextInt();
		List<Bitso> bitsoCases = new ArrayList<Bitso>();
		List<Island> islands = null;
		//For each test case create a new bitso planet with islands
		while(testCases > 0){
			int numberIslands = reader.nextInt();
			islands = new ArrayList<Island>();
			for(int i=0;i<numberIslands;i++){
				islands.add(new Island(reader.nextDouble(),reader.nextDouble()));
			}
			bitsoCases.add(new Bitso(islands));
			testCases--;
		}
				
		//close reader
		if(reader != null)
			reader.close();
		
		//Search archipelagos in each bitso planet
		for(Bitso bitso : bitsoCases){
			bitso.searchForArchipelagos();
		}
		
		//END OF THE PROGRAM
		scanner.close();
	}
}
