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
	
	

	public TraitementSymptomData(String file) {
		super.filepath = file;
	}


	/**
	 * @return  TreeMap symptones et le nombre de cas
	 */
	public TreeMap<String, Integer> getCasSymptoms(){
	
		int val;
		
			try {System.out.println("---------------------");
				for(String symptome: this.GetSymptoms()) {
					
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
	
	/**
	 * Lister nombre de symptome
	 * @param String resultOut
	 */
	public void consulterSymptom(String resultOut) {
		
		try {
			StringBuilder str = new StringBuilder();
			BufferedWriter bfwritr = new BufferedWriter( new FileWriter(resultOut));
			
		
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
	/**
	 * Ajouter symptome directement fichier existant
	 */
	public  void opendAndWriteFile(String s) {
		try
		{
			this.addSymptom(s);
			this.GetSymptoms();
			
			 FileWriter fw = new FileWriter(super.getFilepath(),true);
			 fw.write(s);
			 fw.close();
		}
		catch(IOException ioe)
		{
			 ioe.getMessage();
		}
	}
	/**
	 * Ajout symptom dans liste
	 * @param String symptom
	 */
	public void addSymptom(String symptom) {
		this.symptomes.add(symptom);
		//this.getCasSymptoms();
	}

}
