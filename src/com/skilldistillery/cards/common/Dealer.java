package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.blackjack.BlackJackHand;

public class Dealer {
	private String name;
	private BlackJackHand hand = new BlackJackHand();
	
	public Dealer(String name) {
		super();
		this.name = name;
	}
	
	public boolean check17() {
		boolean check = true;
		if(hand.getHandValue() < 17) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	

	public Card dealCard() { 									// get one card
		return dealCard();
	}
	
	public void displayHand() {
			System.out.println(hand.getHand().get(0));		
		
	}

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
