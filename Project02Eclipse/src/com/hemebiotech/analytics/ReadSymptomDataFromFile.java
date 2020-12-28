package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private String inputFile;
	private List<String> symptomes = new ArrayList<>();
	
	

	public ReadSymptomDataFromFile(String inputFile) {
		super();
		this.inputFile = inputFile;
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
	
}
