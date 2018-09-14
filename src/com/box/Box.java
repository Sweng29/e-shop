package com.box;

public class Box {

	private String type;
	private String gradeOfCard;
	private String reinforcedBottom;
	private String reinforcedCornor;
	private ColorPrint colorPrint = new ColorPrint();
	private double cost;
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ColorPrint getColorPrint() {
		return colorPrint;
	}
	public void setColorPrint(ColorPrint colorPrint) {
		this.colorPrint = colorPrint;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGradeOfCard() {
		return gradeOfCard;
	}
	public void setGradeOfCard(String gradeOfCard) {
		this.gradeOfCard = gradeOfCard;
	}
	public String getReinforcedBottom() {
		return reinforcedBottom;
	}
	public void setReinforcedBottom(String reinforcedBottom) {
		this.reinforcedBottom = reinforcedBottom;
	}
	public String getReinforcedCornor() {
		return reinforcedCornor;
	}
	public void setReinforcedCornor(String reinforcedCornor) {
		this.reinforcedCornor = reinforcedCornor;
	}
	
}
