package com.cardinal.yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGame {
	
	private List<Integer> userInputs = new ArrayList<Integer>();
	private final String CAT = "CATEGORY";
	private int readUserCategory ;
	private int userScore;
	
	
	private void readUserInput() {
		
		Scanner sc = new Scanner(System.in);
		
		int userInput;
		
		System.out.println("Roll the dice, enter the value and hit enter. You can enter upto 5 values");
		for(int i = 0;i<5;i++){
			
			userInput = Integer.parseInt(sc.nextLine().trim());
			this.userInputs.add(userInput);
			
		}
		for(Integer i :this.userInputs){
			System.out.println("Dice values you entered are : "+i+"\n\n");
			
		}
		
		
		
	}
	
	private void explainRules() {
		StringBuffer sBuf = new StringBuffer();
		int[] catId = {1,2,3,4,5,6};
		System.out.println("Please choose your category, the rules for each category are explained below");
		System.out.println("\n\n");
		
		sBuf.append(this.CAT+"\t"+catId[0]+"----------->"+ "THREE OF A KIND :\n" + "If there are three dice with the same number, the player scores the sum of these dice. Otherwise, the player scores 0. For example, 3, 3, 3, 4, 5 gives 9. "+"\n\n ");
		sBuf.append(this.CAT+"\t"+catId[1]+"----------->" +"FOUR OF A KIND :\n" + "If there are four dice with the same number, the player scores the sum of these dice. Otherwise, the player scores 0. For example, 2, 2, 2, 2, 5 gives 8."+"\n\n ");
		sBuf.append(this.CAT+"\t"+catId[2]+"----------->" + "SMALL STRAIGHT :\n" +" If the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice), otherwise 0."+"\n\n ");
		sBuf.append(this.CAT+"\t"+catId[3]+"----------->" +"YAHTZEE :\n" + "If there are four dice with the same number, the player scores the sum of these dice. Otherwise, the player scores 0. For example, 2, 2, 2, 2, 5 gives 8."+"\n\n ");
		sBuf.append(this.CAT+"\t"+catId[4]+"----------->" +"TWO PAIRS :\n" + "If there are two pairs of dice with the same number, the player scores the sum of these dice. If not, the player scores 0. For example, 1, 1, 2, 3, 3 placed on two pairs gives 8"+"\n\n ");
		sBuf.append(this.CAT+"\t"+catId[5]+"----------->" +"CHANCE :\n" + " The player gets the sum of all dice, no matter what they read."+"\n ");
		
		System.out.println(sBuf.toString());
		
		
		
	}

	private void readUserCategory() {
		Scanner sc = new Scanner(System.in);
		this.readUserCategory = Integer.parseInt(sc.nextLine().trim());
		
	}
	
	private void computeScores() {
		CategoryRules objCatRules = null;
		switch(readUserCategory){
		
		case 1 :
			objCatRules = new CategoryRules();
			this.userScore = objCatRules.returnThreeOfAKind(userInputs);
			break;
		case 2 :
			objCatRules = new CategoryRules();
			this.userScore = objCatRules.returnFourOfAKind(userInputs);
			break;
		case 3 :
			objCatRules = new CategoryRules();
			if(userInputs.get(0)==1){
			this.userScore = objCatRules.returnSmallStraight(userInputs);
			}
			
			break;
		case 4 :
			objCatRules = new CategoryRules();
			this.userScore = objCatRules.returnYahtzee(userInputs);
			break;
		case 5 :
			objCatRules = new CategoryRules();
			this.userScore = objCatRules.returnTwoPairs(userInputs);
			break;
		case 6 :
			objCatRules = new CategoryRules();
			this.userScore = objCatRules.returnChance(userInputs);
			break;
		default:
			System.out.println("USER CATEGORY INVALID!!");
			break;
		}
		
		
		System.out.println("You scored --->"+userScore);
		
	}


	
	
	
	
	
	public static void main(String args[]){
		
		DiceGame objDg = new DiceGame();
		objDg.readUserInput();
		objDg.explainRules();
		objDg.readUserCategory();
		objDg.computeScores();
		
		
	}

	

	





	
	
}
