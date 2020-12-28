package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class CountSymptomFromList implements ISymptomCounter {

	private TreeMap<String, Integer> nbrCas = new TreeMap<String, Integer>();
	
	

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
	
	
}
