package com.box;

import java.util.Scanner;

public class BoxTest {

	public static void main(String[] args) {
		double totalCost = 0.0;
                Scanner input = new Scanner(System.in);
                int choice = 0;
                do{
                   totalCost += new FlexBoxPriceQuote().menu();
                   System.out.println("Do you want to place an other order?");
                   System.out.println("Press 1 for yes.");
                   System.out.println("Press 2 to exit.");
                   choice = input.nextInt();
                }while(choice!=2);
                System.out.println("Total cost for your Order : "+totalCost);
	}

}
