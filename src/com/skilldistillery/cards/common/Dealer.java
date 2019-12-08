package com.skilldistillery.cards.common;

import com.skilldistillery.cards.blackjack.BlackJackHand;

public class Dealer {
	// Fields
	private String name;

	// Constructors
	private BlackJackHand hand = new BlackJackHand();

	public Dealer(String name) {
		super();
		this.name = name;
	}

	// Methods
	public boolean check17() {
		boolean check = true;
		if (hand.getHandValue() < 17) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public Card dealCard() {
		return dealCard();
	}

	public Card displayHand() {
		return (hand.getHand().get(0));

	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

}
