package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TraitementSymptomData extends SymptomData implements ISymptomTraitement{

	private List<String> symptomes = new ArrayList<>();
	private TreeMap<String, Integer> nbrCas = new TreeMap<String, Integer>();
	
	private String inputFile;
	private String outputFile;
	

	public TraitementSymptomData(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}


	/**
	 * @return  TreeMap symptones et le nombre de cas
	 */
	public TreeMap<String, Integer> countSymptoms(List<String> listSymptoms){
	
		int val;
		
			try {System.out.println("---------------------");
				for(String symptome: listSymptoms) {
					
					if(this.nbrCas.containsKey(symptome)) {
						val = this.nbrCas.get(symptome);
						val +=1;
						this.nbrCas.put(symptome, val);
						
					}else {
						this.nbrCas.put(symptome, 1);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		return this.nbrCas;
	}
	

	/**
	 * méthode permettant de récupérer les symptoms depuis un fichier texte
	 * @return List de symptomes du fichier transmis en paramètre à la class
	 */
	@Override
	public List<String> getSymptoms() {

		if (inputFile != null) {
			
			
			try {
				BufferedReader reader = new BufferedReader (new FileReader(inputFile));
				String line = reader.readLine();  
				
				while (line != null) {
					this.symptomes.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return this.symptomes;
	}
	
	/**
	 * Lister nombre de symptome
	 * @param String resultOut
	 */
	public void writeSymptoms(Map<String, Integer> mapSymptoms) {
		
		try {
			StringBuilder str = new StringBuilder();
			BufferedWriter bfwritr = new BufferedWriter( new FileWriter(outputFile));
			
		
			for(Map.Entry<String, Integer> ligne: nbrCas.entrySet()) {
				str.append(ligne.getKey() +" = " + ligne.getValue()+"\n");
			
			}
			
			 bfwritr.write(str.toString());
			
			 bfwritr.close(); 
		
		}catch(FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}

}
