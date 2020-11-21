package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	
	private static String root = "../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
	private static String resultOut = "../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.out";
	
	public static void main(String args[]){
		
		try {
			// first get input
			BufferedReader reader = new BufferedReader (new FileReader(root));
			String line = reader.readLine();
			
			ReadSymptomDataFromFile readSDFFile = new ReadSymptomDataFromFile(root);

			ArrayList<String> result = (ArrayList) readSDFFile.GetSymptoms();
			
			HashMap<String, Integer> nbrCas = (HashMap<String, Integer>) readSDFFile.getCasSymptoms();

			
			StringBuilder str = new StringBuilder();
			BufferedWriter bfwritr = new BufferedWriter( new FileWriter(resultOut));
			
		
			for(Map.Entry<String, Integer> ligne: nbrCas.entrySet()) {
				str.append(ligne.getKey() +" = " + ligne.getValue()+"\n");
			
			}
			
			 bfwritr.write(str.toString());
			
			 bfwritr.close();    
		
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	

		
	}
		
}
