package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraitementSymptomData extends ReadSymptomDataFromFile implements ISymptomTraitement{

	private List<String> symptomes = new ArrayList<>();
	private HashMap<String, Integer> nbrCas = new HashMap<String, Integer>();

	/**
	 * @return  symptones et le nombre de cas
	 */
	public Map<String, Integer> getCasSymptoms(){
	
		int val;
		
			try {System.out.println("---------------------");
				for(String symptome: super.GetSymptoms()) {
					System.out.println(symptome);
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
