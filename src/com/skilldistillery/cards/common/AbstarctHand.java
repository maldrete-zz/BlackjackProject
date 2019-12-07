package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstarctHand {
	
	public abstract int getHandValue();
	
	
	private List<Card> cards = new ArrayList<>();
	
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clearHand() {
		cards.clear();
	}
	
	public List<Card> getHand() {
		return cards;
	}
	
	  @Override
	  public String toString() {
		  return getCards().toString();
	  }
	
	
}
