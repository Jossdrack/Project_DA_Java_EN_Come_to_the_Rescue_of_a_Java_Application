package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private static String root = "../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";
	private static String resultOut = "../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.out";
	
	public static void main(String args[]){

			
			TraitementSymptomData readSDFFile = new TraitementSymptomData(root);

			List<String> result =  readSDFFile.GetSymptoms();
			
			TreeMap<String, Integer> nbrCas = readSDFFile.getCasSymptoms();
			//Set<String> symptomes = readSDFFile.getCasSymptoms().keySet();
			System.out.println(nbrCas);
			
			
			readSDFFile.addSymptom("Papa");
			readSDFFile.addSymptom("Test");
			readSDFFile.addSymptom("Test");
			
			
			
			result =  readSDFFile.GetSymptoms();
			nbrCas = readSDFFile.getCasSymptoms();
			
			readSDFFile.consulterSymptom(resultOut);
			

		
	}
		
}
