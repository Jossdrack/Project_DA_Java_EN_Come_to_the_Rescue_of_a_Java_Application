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

	protected String filepath;
	protected List<String> symptomes = new ArrayList<>();
	
	
	
	
	protected List<String> getSymptomes() {
		return symptomes;
	}


	protected void setSymptomes(List<String> symptomes) {
		this.symptomes = symptomes;
	}


	public String getFilepath() {
		return filepath;
	}
	

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	public ReadSymptomDataFromFile () {}

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
				String line;  
				
				while ((line = reader.readLine()) != null) {
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
	
}
