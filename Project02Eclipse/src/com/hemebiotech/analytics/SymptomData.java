package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;

abstract class SymptomData {

	protected abstract Map<String, Integer> countSymptoms(List<String> symptoms);
	
	
	
}
