package com.skilldistillery.cards.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackApp {
	Scanner kb = new Scanner(System.in);
	User user = new User("Jimbo");
	Dealer dealer = new Dealer("Dealer");
	Deck deck = new Deck();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.launch();
	}

	public void launch() {
		System.out.println("Welcome to BlackJack");

		// Deals cards to start game
		deck.createDeck();
		System.out.println("Dealing Cards");
		user.getHand().addCard(deck.dealCard());
		user.getHand().addCard(deck.dealCard());
		// check for blackjack
		checkForWinOrLose();

		dealer.getHand().addCard(deck.dealCard());
		dealer.getHand().addCard(deck.dealCard());
		// check for blackjack
		checkForWinOrLose();
		System.out.println();

		System.out.println(user.getName() + user.getHand());
		System.out.println();
		System.out.println(dealer.getName() + dealer.getHand());

		// check for blackjack
		checkForWinOrLose();

		// hit option
		try {
			int hitOption = 0;
			do {


			System.out.println();
			System.out.println(user.getName() + " Would you like to hit?\n1. Yes\n2. No");
			hitOption = kb.nextInt();

			if (hitOption == 1) {
				user.getHand().addCard(deck.dealCard());
				System.out.println(user.getName() + user.getHand());
				// check cards win or lose
				checkForWinOrLose();
				
			}

		} while (hitOption != 2);

		} catch (InputMismatchException e) {
			System.out.println("no a valid input");
		}

		System.out.println();
		System.out.println(dealer.getName() + " turn:");
		while (dealer.check17()) {
			System.out.print("Dealer Hit:\t");
			dealer.getHand().addCard(deck.dealCard());
			System.out.println(dealer.getHand());
		}

		System.out.println();
		System.out.println("Checking for winner!");
		if (dealer.getHand().getHandValue() == user.getHand().getHandValue()) {
			System.out.println("Tie\tPush.....");

		}
		if (dealer.getHand().getHandValue() > user.getHand().getHandValue()) {
			System.out.println(dealer.getName() + " wins! with " + dealer.getHand().getHandValue() + " points");
		}

		if (dealer.getHand().isBust()) {
			System.out.println(user.getName() + " wins! with " + user.getHand().getHandValue() + " points");

		}
	
	}

		
		
		
		
		
		
		
	public void checkForWinOrLose() {
		if (user.getHand().isBlackjack()) {
			System.out.println("Blackjack! you win!");
		}

		if (user.getHand().isBust()) {
			System.out.println("Bust you loss");
			System.exit(1);
		}
		if (dealer.getHand().isBlackjack()) {
			System.out.println("Blackjack! you win!");
		}

		if (dealer.getHand().isBust()) {
			System.out.println("Bust you loss");
		}
	}

}