package com.skilldistillery.cards.common;

import com.skilldistillery.cards.blackjack.BlackJackHand;

public class User {
	// Fields
	private String name;

	// Constructors
	private BlackJackHand hand = new BlackJackHand();

	public User(String name) {
		super();
		this.name = name;
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
