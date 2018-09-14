package com.box;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class FlexBoxPriceQuote {

    private ArrayList<Box> boxes = new ArrayList<>(); 
    
    private final double ONECOLOUR = 0.12;
    private final double TWOCOLOURS = 0.15;
    private final double REINFORCEDBOTTOM = 0.10;
    private final double REINFORCEDCORNOR = 0.07;
    private final double SEALABLETOP = 0.05;
    
    double [] basicCosts = {0.45,0.59,0.68,0.92,1.30};
    
    private Integer length;
    private Integer width;
    private Integer height;
    Scanner input = new Scanner(System.in);
    private String gradeOfCard;
    private Integer color;
    private boolean reinforcedBottom;
    private boolean reinforcedCornors;
    private boolean sealableTop;
    private Integer quantityOfBoxes;
    
    private Box box1 =  new Box();
    private Box box2 =  new Box();
    private Box box3 =  new Box();
    private Box box4 =  new Box();
    private Box box5 =  new Box();
    
    public FlexBoxPriceQuote() {
        	
    	box1.setType("1");
    	box1.setGradeOfCard("1-3");
    	box1.setReinforcedBottom("No");
    	box1.setReinforcedCornor("No");
    	ColorPrint colorPrint = new ColorPrint();
    	colorPrint.setColorZero("Yes");
    	colorPrint.setColorOne("No");
    	colorPrint.setColorTwo("No");
    	box1.setColorPrint(colorPrint);
    	box1.setCost(basicCosts[0]);
    	boxes.add(box1);
    	
    	box2.setType("2");
    	box2.setGradeOfCard("2-4");
    	box2.setReinforcedBottom("No");
    	box2.setReinforcedCornor("No");
        ColorPrint colorPrint1 = new ColorPrint();
    	colorPrint1.setColorZero("No");
    	colorPrint1.setColorOne("Yes");
    	colorPrint1.setColorTwo("No");
    	box2.setCost(basicCosts[1]);
    	box2.setColorPrint(colorPrint1);
    	boxes.add(box2);
    	
    	box3.setType("3");
    	box3.setGradeOfCard("2-5");
    	box3.setReinforcedBottom("No");
    	box3.setReinforcedCornor("No");
        ColorPrint colorPrint2 = new ColorPrint();
    	colorPrint2.setColorZero("No");
    	colorPrint2.setColorOne("No");
    	colorPrint2.setColorTwo("Yes");
    	box3.setColorPrint(colorPrint2);
    	box3.setCost(basicCosts[2]);
    	boxes.add(box3);
    	
    	box4.setType("4");
    	box4.setGradeOfCard("2-5");
    	box4.setReinforcedBottom("Yes");
    	box4.setReinforcedCornor("No");
        ColorPrint colorPrint3 = new ColorPrint();
    	colorPrint3.setColorZero("No");
    	colorPrint3.setColorOne("No");
    	colorPrint3.setColorTwo("Yes");
    	box4.setColorPrint(colorPrint3);
    	box4.setCost(basicCosts[3]);
    	boxes.add(box4);
    	
    	box5.setType("5");
    	box5.setGradeOfCard("3-5");
    	box5.setReinforcedBottom("Yes");
    	box5.setReinforcedCornor("Yes");
        ColorPrint colorPrint4 = new ColorPrint();
    	colorPrint4.setColorZero("No");
    	colorPrint4.setColorOne("No");
    	colorPrint4.setColorTwo("Yes");
    	box5.setColorPrint(colorPrint4);
    	box1.setCost(basicCosts[4]);
    	boxes.add(box5);
    	
    }
    
    public double menu()
    {
        double totalCost = 0.0;
        
        System.out.println("********************** Welcome to FlexBox Shop **********************");
        
        System.out.println("Please enter your card details.");
        
        System.out.println("Enter length.");
        length = input.nextInt();
        System.out.println("Enter width.");
        width = input.nextInt();
        System.out.println("Enter height.");
        height = input.nextInt();
        System.out.println("Enter Grade Of Card from 1-5.");
        gradeOfCard = input.next();
        System.out.println("Do you want any colouring?\nPress 1 to no colouring.\nPress 2 for colouring.");
        int choice = input.nextInt();
        if(choice==1)
        {
            color = 0;
        }else if(choice==2)
        {
            System.out.println("Do you want 1 color or two?.");
            System.out.println("Press 1 for only one color.");
            System.out.println("Press 2 for two colors.");
            choice = input.nextInt();
            if(choice==1)
            {
                color = 1;
            }else if(choice==2)
            {
                color = 2;
            } 
        }else{
            System.out.println("Unexpected input.");
            System.exit(0);
        }
        
        System.out.println("Do you want any Reinforced bottom?");
        System.out.println("Press 1 for yes.");
        System.out.println("Press 2 for no.");
        choice = input.nextInt();
        if(choice==1)
        {
            reinforcedBottom = true;
        }else if(choice==2)
        {
            reinforcedBottom = false;            
        }else{
            System.out.println("Unexpected input.");
            System.exit(0);
        }
        
        System.out.println("Do you want any Reinforced Corner?");
        System.out.println("Press 1 for yes.");
        System.out.println("Press 2 for no.");
        choice = input.nextInt();
        if(choice==1)
        {
            reinforcedCornors = true;
        }else if(choice==2)
        {
            reinforcedCornors = false;            
        }else{
            System.out.println("Unexpected input.");
            System.exit(0);
        }
        System.out.println("Do you want sealable top?");
        System.out.println("Press 1 for yes.");
        System.out.println("Press 2 for no.");
        choice = input.nextInt();
        if(choice==1)
        {
            sealableTop = true;
        }else if(choice==2)
        {
            sealableTop = false;            
        }else{
            System.out.println("Unexpected input.");
            System.exit(0);
        }
        System.out.println("Enter quantity of boxes.");
        quantityOfBoxes = input.nextInt();    

        // For 1st type
        
        if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==1 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==2 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==0 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*0.1*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*REINFORCEDBOTTOM*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*REINFORCEDBOTTOM*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==0 && reinforcedBottom==false && reinforcedCornors==true && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*REINFORCEDCORNOR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*REINFORCEDCORNOR*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*REINFORCEDCORNOR*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*SEALABLETOP*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*SEALABLETOP*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("1") || gradeOfCard.equals("2") || gradeOfCard.equals("3") && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[0]*SEALABLETOP*TWOCOLOURS*quantityOfBoxes;
            
        }
        // For 2nd Type : 
        else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==1 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==2 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4")  && color==0 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*ONECOLOUR*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*REINFORCEDBOTTOM*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4")  && color==0 && reinforcedBottom==false && reinforcedCornors==true && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*REINFORCEDCORNOR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*REINFORCEDCORNOR*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4")  && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*REINFORCEDCORNOR*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*SEALABLETOP*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*SEALABLETOP*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4")  && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[1]*SEALABLETOP*TWOCOLOURS*quantityOfBoxes;
            
        }
        // Conditions for third grade
        else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5") && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==2 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==0 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*ONECOLOUR*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*REINFORCEDBOTTOM*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==0 && reinforcedBottom==false && reinforcedCornors==true && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*REINFORCEDCORNOR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*REINFORCEDCORNOR*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*REINFORCEDCORNOR*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*SEALABLETOP*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*SEALABLETOP*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[2]*SEALABLETOP*TWOCOLOURS*quantityOfBoxes;
            
        }
        // Conditions for 4th
        else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==2 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==0 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*ONECOLOUR*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*REINFORCEDBOTTOM*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==0 && reinforcedBottom==false && reinforcedCornors==true && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*REINFORCEDCORNOR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*REINFORCEDCORNOR*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*REINFORCEDCORNOR*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*SEALABLETOP*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*SEALABLETOP*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("2") || gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[3]*SEALABLETOP*TWOCOLOURS*quantityOfBoxes;
            
        }
        // Conditions for 5th
        else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*ONECOLOUR*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==2 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==0 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*ONECOLOUR*REINFORCEDBOTTOM*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[5]*REINFORCEDBOTTOM*TWOCOLOURS*quantityOfBoxes;
            
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==0 && reinforcedBottom==false && reinforcedCornors==true && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*REINFORCEDCORNOR*quantityOfBoxes;
           
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*REINFORCEDCORNOR*ONECOLOUR*quantityOfBoxes;
           
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==false)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*REINFORCEDCORNOR*TWOCOLOURS*quantityOfBoxes;
           
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==0 && reinforcedBottom==false && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*SEALABLETOP*quantityOfBoxes;
           
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")  && color==1 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*SEALABLETOP*ONECOLOUR*quantityOfBoxes;
           
        }else if(gradeOfCard.equals("3") || gradeOfCard.equals("4") || gradeOfCard.equals("5")   && color==2 && reinforcedBottom==true && reinforcedCornors==false && sealableTop==true)
        {
            int totalLength = length*width*height;
            totalCost = totalLength*basicCosts[4]*SEALABLETOP*TWOCOLOURS*quantityOfBoxes;
        }
        System.out.println(totalCost);
        return totalCost;
    }
}
