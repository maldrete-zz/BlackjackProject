package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	// fields
	private List<Card> cards;

	// Constructors
	List<Card> deck = new ArrayList<>(52);

	public Deck() {
		cards = createDeck();
	}

	// Methods
	public List<Card> createDeck() {

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
			shuffle();
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

}
