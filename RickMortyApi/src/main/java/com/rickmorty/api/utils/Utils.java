package com.rickmorty.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.rickmorty.api.model.format.CalculateSumResponse;
import com.rickmorty.api.model.format.HappyNumber;
import com.rickmorty.api.model.format.HappyNumberRequest;
import com.rickmorty.api.model.format.HappyNumberResponse;

public class Utils {

	public Integer MAX_INTERATIONS = 20;
	
	public CalculateSumResponse calculateSum(Integer value) {
		CalculateSumResponse response = new CalculateSumResponse();
		response.setResult((value * (value + 1)) / 2);
		return response; 
	}
	
	public HappyNumberResponse getHappyNumbers(HappyNumberRequest request) {
		HappyNumberResponse response = new HappyNumberResponse();
		List<HappyNumber> list = new ArrayList<HappyNumber>();
		
		for (HappyNumber happyNumber : request.getNumbers()) {
			happyNumber.setIsHappy(isHappyNumber(happyNumber.getNumber()));
			list.add(happyNumber);
		}
		
		HappyNumber[] number = list.toArray(new HappyNumber[0]);
		response.setNumbers(number);
		return response;
	}
	
	public boolean isHappyNumber(Integer value) {
		int iteration = 0;
		boolean nextIteration = true;
		Integer iterationValue = value;
		while (nextIteration) {
			iteration++;
			
			ArrayList<Integer> numberPartList = getNumberParts(String.valueOf(iterationValue));
			Integer totalSumDigits = new Integer(0);
			
			for (Integer numberPart : numberPartList ) {
				totalSumDigits = totalSumDigits + (int)Math.pow(numberPart, 2);
			}
			
			if (totalSumDigits == 1) {
				return true;
			} else if (iteration > MAX_INTERATIONS){
				return false;
			}
			
			value = totalSumDigits;
		}
		
		return false;
		
	}
	
	public ArrayList<Integer> getNumberParts(String value) {
		ArrayList<Integer> numberPartList = new ArrayList<Integer>();
		char[] numberValueList = value.toCharArray();
		
		for (char numberPart : numberValueList) {
			numberPartList.add((Integer) java.lang.Character.digit(numberPart, 10));
		}
		
		return numberPartList;
	}
}
