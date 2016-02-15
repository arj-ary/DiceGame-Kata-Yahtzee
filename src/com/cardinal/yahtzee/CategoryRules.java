package com.cardinal.yahtzee;

import java.util.List;

public class CategoryRules {

	private int userScore =0;
	
	public int returnChance(List<Integer> userInputs) {
		int sum = 0;
		for(int i:userInputs){
			sum+=i;
		}
		return sum;
	}
	
	public int returnThreeOfAKind(List<Integer> userInputs) {
		int matchFound;
		for(int i=0;i<=3;i++){
			matchFound=1;
			for(int j=i+1;j<5;j++){
				if(userInputs.get(i) == userInputs.get(j)){
					matchFound++;
					if(matchFound>2){
						this.userScore = 3*userInputs.get(i);
							break;					
					}
				}
				
			}
			
		}
		
		return userScore;
		
	}
	public int returnFourOfAKind(List<Integer> userInputs) {
		int matchFound;
		for(int i=0;i<=4;i++){
			matchFound=1;
			for(int j=i+1;j<5;j++){
				if(userInputs.get(i) == userInputs.get(j)){
					matchFound++;
					if(matchFound>3){
						this.userScore = 4*userInputs.get(i);
							break;					
					}
				}
				
			}
			
		}
		return userScore;
	}
	public int returnSmallStraight(List<Integer> userInputs) {
		int sumToBeReturned = 15;
		for(int i=0,j=1;i<5;i++){
			if(j<5){
				if((userInputs.get(j) - userInputs.get(i)) == 1){
				j++;
			}else{
				return this.userScore;
			}
			}else{
				return sumToBeReturned;
			}
		}
		return sumToBeReturned;
		
		
	}
	
	public int returnYahtzee(List<Integer> userInputs) {
		int scoreToBeReturned = 50;
		for(int i=0, j=1;j<5;j++){
			if(userInputs.get(i)== userInputs.get(j)){
				continue;
			}else{
				return this.userScore;
			}
			
		}
		return scoreToBeReturned;
	}
	public int returnTwoPairs(List<Integer> userInputs) {
		int score=0;
		int numberofMatches = 0;
		
		int outerIndex = 0;
		
		if(userInputs.get(0) == userInputs.get(1)){
			score = userInputs.get(0)+userInputs.get(1);
			numberofMatches++;
			outerIndex+=2;
		}
		
		for(int i=outerIndex;i<5;i++){
			for(int j=i+1;j<5;j++){
				if(userInputs.get(i) == userInputs.get(j)){
					
					int matchSum = userInputs.get(i)+userInputs.get(j);
					numberofMatches++;
					score+= matchSum;
					if(numberofMatches == 2){
						return score;
					}
				}
			}
		}
		return this.userScore;
	}
	
	
	

}
