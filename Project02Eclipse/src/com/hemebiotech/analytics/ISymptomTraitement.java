package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomTraitement {
	public Map<String, Integer> getCasSymptoms();
	public  void opendAndWriteFile(String s);
	public List<String> GetSymptoms();

}