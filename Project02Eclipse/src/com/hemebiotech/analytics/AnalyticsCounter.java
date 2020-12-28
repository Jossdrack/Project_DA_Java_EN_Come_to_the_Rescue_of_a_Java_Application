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
			
			AnalyseCounter analyseCounter = new AnalyseCounter(new ReadSymptomDataFromFile(root), new WriterResultToFile(resultOut), new CountSymptomFromList());
			/*
			 * Récuperation des symptomes du fichier root
			 */
			List<String> lstSymptom =  analyseCounter.getSymptoms();
			
			/*
			 * Récuppération des symptomes et de leur nombre de cas
			 */
			TreeMap<String, Integer> mapSymptoms = analyseCounter.countSymptoms(lstSymptom);
			
			/*
			 * Inscription des symptomes dans le fichier resultOut
			 */
			analyseCounter.writeSymptoms(mapSymptoms);
		
	}
		
}
