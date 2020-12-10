package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

abstract class SymptomData {

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
	
}
