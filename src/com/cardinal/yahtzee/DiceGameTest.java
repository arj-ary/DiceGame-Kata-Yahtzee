package com.cardinal.yahtzee;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DiceGameTest {
	
	List<Integer> diceValues;
	int testScore;
	int score;
	CategoryRules rules;

	@Before
	public void setup() {
		diceValues = new ArrayList<Integer>();
		rules = new CategoryRules();
	}

	// Testing Return chance category
	@Test
	public void returnChanceTest() {
		// Test Data - 6 5 4 3 2
		// Result is 6+5+4+3+2 = 20
		this.diceValues.clear();

		this.diceValues.add(6);
		this.diceValues.add(5);
		this.diceValues.add(4);
		this.diceValues.add(3);
		this.diceValues.add(2);

		this.testScore = 20;

		this.score = rules.returnChance(diceValues);

		assertEquals(this.testScore, this.score);
	}
	
	@Test
	public void returnThreeOfAKindTest() {
		// Test Data -  4 4 4 2 1
		// Result is 4 + 4 + 4 = 12
		this.diceValues.clear();

		this.diceValues.add(4);
		this.diceValues.add(4);
		this.diceValues.add(4);
		this.diceValues.add(2);
		this.diceValues.add(1);

		this.testScore = 12;

		this.score = rules.returnThreeOfAKind(diceValues);

		assertEquals(this.testScore, this.score);
	}
	
	@Test
	public void returnFourOfAKindTest() {
		// Test Data - 4 4 4 4 1
		// Result is 4 + 4 + 4 + 4 = 16
		this.diceValues.clear();

		this.diceValues.add(4);
		this.diceValues.add(4);
		this.diceValues.add(4);
		this.diceValues.add(4);
		this.diceValues.add(1);

		this.testScore = 16;

		this.score = rules.returnFourOfAKind(diceValues);

		assertEquals(this.testScore, this.score);
	}
	
	@Test
	public void returnSmallStraightTest() {
		// Test Data - 1 2 3 4 5
		// Result is 1 + 2 + 3 + 4 + 5 = 15
		this.diceValues.clear();

		this.diceValues.add(1);
		this.diceValues.add(2);
		this.diceValues.add(3);
		this.diceValues.add(4);
		this.diceValues.add(5);

		this.testScore = 15;

		this.score = rules.returnSmallStraight(diceValues);

		assertEquals(this.testScore, this.score);
	}
	
	@Test
	public void returnYahtzeeTest() {
		// Test Data - 5 5 5 5 5
		// Result = 50
		this.diceValues.clear();

		this.diceValues.add(5);
		this.diceValues.add(5);
		this.diceValues.add(5);
		this.diceValues.add(5);
		this.diceValues.add(5);

		this.testScore = 50;

		this.score = rules.returnYahtzee(diceValues);

		assertEquals(this.testScore, this.score);
	}
	
	@Test
	public void returnTwoPairsTest() {
		// Test Data - 2 2 4 5 5
		// Result = 2 + 2 + 5 + 5 = 14
		this.diceValues.clear();

		this.diceValues.add(2);
		this.diceValues.add(2);
		this.diceValues.add(4);
		this.diceValues.add(5);
		this.diceValues.add(5);

		this.testScore = 14;

		this.score = rules.returnTwoPairs(diceValues);

		assertEquals(this.testScore, this.score);
	}
	
}
