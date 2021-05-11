package com.test.demo.models;

import java.util.ArrayList;

public class ApiResponse {
	private int reponseCode;
	private ArrayList<Result> results;
	
	public int getReponseCode() {
		return reponseCode;
	}
	public void setReponseCode(int reponseCode) {
		this.reponseCode = reponseCode;
	}
	public ArrayList<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
	
	
	
}
