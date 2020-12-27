package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomTraitement {
	public List<String> getSymptoms();
	public void writeSymptoms(Map<String,Integer> mapSymptoms);

}
