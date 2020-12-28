package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriterResultToFile implements ISymptomWriter {

	
	private String outputFile;
	private TreeMap<String, Integer> nbrCas = new TreeMap<String, Integer>();
	
	
	
	
	public WriterResultToFile(String outputFile) {
		super();
		this.outputFile = outputFile;
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
