package com.greatlearning.services;

import java.util.Map;

public class StockReport {
	
	// Main function that sorts array[left...right] using merge()
	public void sortAscending(double[] stockValues, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;
			// Sort first and second halves
			sortAscending(stockValues, left, mid);
			sortAscending(stockValues, mid + 1, right);
			// Merge the sorted halves
			SortingLogic sortLogic = new SortingLogic();
			sortLogic.merge(stockValues, left, mid, right);
		}
	}
	
	public void sortDescending(double[] stockValues, int left, int right){
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;
			// Sort first and second halves
			sortDescending(stockValues, left, mid);
			sortDescending(stockValues, mid + 1, right);
			// Merge the sorted halves
			SortingLogic sortLogic = new SortingLogic();
			sortLogic.mergeReverse(stockValues, left, mid, right);
		}
	}
	
	public void displayRisingStocks(Map<Double, Boolean> stocks) {
		int count = 0;
		for (double key : stocks.keySet()) {
			if(stocks.get(key) == true) {
				count++;
			}
		}
		System.out.println("Total no of companies whose stock price rose today : "+count);
	}
	
	public void displayDecliningStocks(Map<Double, Boolean> stocks) {
		int count = 0;
		for (double key : stocks.keySet()) {
			if(stocks.get(key) == false) {
				count++;
			}
		}
		System.out.println("Total no of companies whose stock price declined today : "+count);
	}
}