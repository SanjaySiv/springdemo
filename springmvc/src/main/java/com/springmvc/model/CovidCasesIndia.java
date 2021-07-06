package com.springmvc.model;

public class CovidCasesIndia {
	int activeCases;
	int activeCasesNew;
	int recovered;
	int recoveredNew;
	int deaths;
	int deathsNew;
	int previousDayTests;
	int totalCases;
	StateWiseCovid[] regionData;
	public int getActiveCases() {
		return activeCases;
	}
	public void setActiveCases(int activeCases) {
		this.activeCases = activeCases;
	}
	public int getActiveCasesNew() {
		return activeCasesNew;
	}
	public void setActiveCasesNew(int activeCasesNew) {
		this.activeCasesNew = activeCasesNew;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public int getRecoveredNew() {
		return recoveredNew;
	}
	public void setRecoveredNew(int recoveredNew) {
		this.recoveredNew = recoveredNew;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getDeathsNew() {
		return deathsNew;
	}
	public void setDeathsNew(int deathsNew) {
		this.deathsNew = deathsNew;
	}
	public int getPreviousDayTests() {
		return previousDayTests;
	}
	public void setPreviousDayTests(int previousDayTests) {
		this.previousDayTests = previousDayTests;
	}
	public int getTotalCases() {
		return totalCases;
	}
	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}
	
	public StateWiseCovid[] getRegionData() {
		return regionData;
	}
	public void setRegionData(StateWiseCovid[] regionData) {
		this.regionData = regionData;
	}
}
