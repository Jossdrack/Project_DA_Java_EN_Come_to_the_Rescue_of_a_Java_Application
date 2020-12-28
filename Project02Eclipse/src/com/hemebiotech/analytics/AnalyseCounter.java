package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyseCounter {

	private ReadSymptomDataFromFile readSymptomDataFromFile;
	private ISymptomWriter symptomWriter;
	private ISymptomCounter symptomCounter;
	
	
	
	public AnalyseCounter(ReadSymptomDataFromFile readSymptomDataFromFile, ISymptomWriter symptomWriter, ISymptomCounter symptomCounter) {

		this.readSymptomDataFromFile = readSymptomDataFromFile;
		this.symptomWriter = symptomWriter;
		this.symptomCounter = symptomCounter;
	}
	


	public List<String> getSymptoms(){
		return readSymptomDataFromFile.getSymptoms();
	}
	
	public TreeMap<String, Integer> countSymptoms(List<String> listSymptoms){
		return symptomCounter.countSymptoms(listSymptoms);
	}
	
	public void writeSymptoms(Map<String, Integer> mapSymptoms) {
		
		symptomWriter.writeSymptoms(mapSymptoms);
	}
	
	
}
