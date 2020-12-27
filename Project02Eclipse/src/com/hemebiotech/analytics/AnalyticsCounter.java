package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private static String root = "../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
	private static String resultOut = "../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.out";
	
	public static void main(String args[]){

			/*
			 * Recupération des fichiers pour traitement 
			 */
			TraitementSymptomData  analyse = new TraitementSymptomData(root, resultOut);
			/*
			 * Récuperation des symptomes du fichier root
			 */
			List<String> result =  analyse.getSymptoms();
			
			/*
			 * Récuppération des symptomes et de leur nombre de cas
			 */
			TreeMap<String, Integer> mapSymptoms = analyse.countSymptoms(result);
			
			/*
			 * Inscription des symptomes dans le fichier resultOut
			 */
			analyse.writeSymptoms(mapSymptoms);
		
	}
		
}
