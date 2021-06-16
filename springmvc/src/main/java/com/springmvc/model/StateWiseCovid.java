package com.springmvc.model;

public class StateWiseCovid {
	String region;
	int activeCases;
	int newInfected;
    int recovered;
    int newRecovered;
    int deceased;
    int newDeceased;
    int totalInfected;
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}
	public int getNewInfected() {
		return newInfected;
	}
	public void setNewInfected(int newInfected) {
		this.newInfected = newInfected;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public int getNewRecovered() {
		return newRecovered;
	}
	public void setNewRecovered(int newRecovered) {
		this.newRecovered = newRecovered;
	}
	public int getDeceased() {
		return deceased;
	}
	public void setDeceased(int deceased) {
		this.deceased = deceased;
	}
	public int getNewDeceased() {
		return newDeceased;
	}
	public void setNewDeceased(int newDeceased) {
		this.newDeceased = newDeceased;
	}
	public int getTotalInfected() {
		return totalInfected;
	}
	public void setTotalInfected(int totalInfected) {
		this.totalInfected = totalInfected;
	}
    
}
