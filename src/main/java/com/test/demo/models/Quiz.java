package com.test.demo.models;

import java.util.ArrayList;

public class Quiz {
	private String category;
	private ArrayList<QuizResult> results;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<QuizResult> getResults() {
		return results;
	}

	public void setResults(ArrayList<QuizResult> results) {
		this.results = results;
	}

	
}
