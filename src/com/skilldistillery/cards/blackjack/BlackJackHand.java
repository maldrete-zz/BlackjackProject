package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstarctHand;

public class BlackJackHand extends AbstarctHand {

	// Fields

	// Constructors
	public void blackjackHand() {
	}

	// Methods
	@Override
	public int getHandValue() { // value of hand
		int totalValue = 0;
		for (int i = 0; i < getHand().size(); i++) {
			totalValue += getHand().get(i).getValue();
		}
		return totalValue;
	}

	public void displayHand() {
		for (int i = 0; i < getHand().size(); i++) {
			getHand().get(i);
		}

	}

	public boolean isBlackjack() {
		boolean choice = true;
		if (getHandValue() == 21) {
			choice = true;
			return choice;
		} else {
			choice = false;
			return choice;
		}
	}

	public boolean isBust() {
		boolean choice = true;
		if (getHandValue() > 21) {
			choice = true;
			return choice;
		} else {
			choice = false;
			return choice;
		}
	}
}
