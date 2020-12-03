package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaisiSymptom extends ReadSymptomDataFromFile implements ISymptomWriter, ISymptomGestion{
	
	
	
	@Override
	public void writerSymptom(String symptom, String path) {
		
	
		
		try {
			if(path == null) {   
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(super.getFilepath())));
				
				for(String symp: super.GetSymptoms()) {
					bw.write(symp.toString());
					bw.newLine();
				}
				
				bw.write(symptom);
				bw.newLine();
			}else {
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
				
				for(String symp: super.GetSymptoms()) {
					System.out.println(symp.toString());
					bw.write(symp.toString());
					bw.newLine();
				}
				
				bw.write(symptom);
				bw.newLine();
			}
			

			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  }catch (IOException e) {
				// TODO: handle exception
				  e.printStackTrace();
			}
			
	}

	@Override
	public void addSymptom(String symptom) {
		// TODO Auto-generated method stub
		this.symptomes.add(symptom);
	} 
	
	
	

}
