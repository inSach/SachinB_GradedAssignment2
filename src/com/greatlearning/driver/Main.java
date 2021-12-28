package com.greatlearning.driver;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import com.greatlearning.services.StockReport;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the no of companies");
		int companiesCount=0;
		try {
			companiesCount = scan.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Please enter valid Integer value.");
		}
		Map<Double, Boolean> stocks = new HashMap<Double, Boolean>();
		double stockValue;
		boolean increased;
		for(int i=1; i<=companiesCount; i++) {
			System.out.println("Enter current stock price of the company "+i);
			stockValue = scan.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			increased = scan.nextBoolean();
			stocks.put(stockValue, increased);
		}
		int input = -1;
		double displayStock;
		StockReport stockReport = new StockReport();
		double[] stockValues = new double[stocks.size()];
		while(input!=0) {
			System.out.println("\n-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform\r\n"
					+ "1. Display the companies stock prices in ascending order\r\n"
					+ "2. Display the companies stock prices in descending order\r\n"
					+ "3. Display the total no of companies for which stock prices rose today\r\n"
					+ "4. Display the total no of companies for which stock prices declined today\r\n"
					+ "5. Search a specific stock price\r\n"
					+ "0. press 0 to exit");
			System.out.println("-----------------------------------------------");
			input = scan.nextInt();
			switch (input) {
			case 0:
				System.out.println("Exited successfully");
				break;
				
			case 1:
				stockValues = new double[stocks.size()];
				int i =0;
				for (double d : stocks.keySet()) {
					stockValues[i]=d;
					i++;
				}
				stockReport.sortAscending(stockValues, 0, stockValues.length-1);
				System.out.println("Stock prices in ascending order are :");
				for(int j=0; j<stockValues.length; j++) {
					System.out.println(stockValues[j]);
				}
				break;
				
			case 2:
				stockValues = new double[stocks.size()];
				int r =0;
				for (double d : stocks.keySet()) {
					stockValues[r]=d;
					r++;
				}
				stockReport.sortDescending(stockValues, 0, stockValues.length-1);
				System.out.println("Stock prices in descending order are :");
				for(int j=0; j<stockValues.length; j++) {
					System.out.println(stockValues[j]);
				}
				break;
				
			case 3:
				stockReport.displayRisingStocks(stocks);
				break;
				
			case 4:
				stockReport.displayDecliningStocks(stocks);
				break;
				
			case 5:
				System.out.println("Input Stock price");
				displayStock = scan.nextDouble();
				if(stocks.containsKey(displayStock)) {
					System.out.println("Stock of value "+displayStock+" is present.");
				}else {
					System.out.println("Stock of value "+displayStock+" is not present.");
				}
				break;
			}
		}
			
		
	}
}
