package com.skilldistillery.cards.common;

public class BlackJackApp {
	User user = new User("Jimbo");
	Dealer dealer = new Dealer("Dealer");
	Deck deck = new Deck();
	
	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.launch();
	}
	
	

public void launch() {
	System.out.println("Welcome to BlackJack");
	
	deck.createDeck();
	System.out.println("Dealing Cards");
	user.getHand().addCard(deck.dealCard());
	user.getHand().addCard(deck.dealCard());
	dealer.getHand().addCard(deck.dealCard());
	dealer.getHand().addCard(deck.dealCard());
	
	System.out.println(user.getName() + user.getHand());
	System.out.println();
	System.out.println(dealer.getName() + dealer.getHand());
	
	if(user.getHand().isBlackjack()) {
		System.out.println("Blackjack! you win!");
	}
	
	if (user.getHand().isBust()) {
		System.out.println("Bust you loss");
	}
	if(dealer.getHand().isBlackjack()) {
		System.out.println("Blackjack! you win!");
	}
	
	if (dealer.getHand().isBust()) {
		System.out.println("Bust you loss");
	}
	
	System.out.println();
	
}

}