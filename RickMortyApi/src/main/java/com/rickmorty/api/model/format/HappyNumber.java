package com.rickmorty.api.model.format;

public class HappyNumber {
	int number;
	boolean isHappy;
	
	public HappyNumber() {
		
	}
	
	public HappyNumber(int number, boolean isHappy) {
		this.number = number;
		this.isHappy = isHappy;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isHappy() {
		return isHappy;
	}
	public void setIsHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}
	
	
}
