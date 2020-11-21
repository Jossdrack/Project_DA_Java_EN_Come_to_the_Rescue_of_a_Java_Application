package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private List<String> symptomes = new ArrayList<>();
	private HashMap<String, Integer> nbrCas = new HashMap<String, Integer>();
	
	
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public List<String> getSymptomes() {
		return symptomes;
	}

	public void setSymptomes(List<String> symptomes) {
		symptomes = symptomes;
	}

	public HashMap<String, Integer> getNbrCas() {
		return nbrCas;
	}

	public void setNbrCas(HashMap<String, Integer> nbrCas) {
		this.nbrCas = nbrCas;
	}


	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * @return List de symptomes du fichier transmis en paramètre à la class
	 */
	@Override
	public List<String> GetSymptoms() {

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
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
		
		Collections.sort(this.symptomes);
		
		return this.symptomes;
	}
	
	
	/**
	 * @return  symptones et le nombre de cas
	 */
	public Map<String, Integer> getCasSymptoms(){
	
		int val;
		
			try {
				for(String symptome: this.symptomes) {
					
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
}
