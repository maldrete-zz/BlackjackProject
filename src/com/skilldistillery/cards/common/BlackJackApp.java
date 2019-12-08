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
		System.out.println();
		user.getHand().addCard(deck.dealCard());
		user.getHand().addCard(deck.dealCard());
		// print hand
		System.out.println(user.getName() + user.getHand() + "\tvalue: " + user.getHand().getHandValue());
		// check for blackjack
		boolean check = user.getHand().isBlackjack();
		if (check != true) {

			dealer.getHand().addCard(deck.dealCard());
			dealer.getHand().addCard(deck.dealCard());
			System.out.println(dealer.getName() + "[" + dealer.displayHand() + ", " + "Face Down Card]");
			// check for blackjack
			check = dealer.getHand().isBlackjack();
			if (check != true) {

				System.out.println();

				// hit option
				try {
					int hitOption = 0;
					do {

						System.out.println();
						System.out.println(user.getName() + " Would you like to hit?\n1. Yes\n2. No");
						hitOption = kb.nextInt();

						if (hitOption == 1) {
							user.getHand().addCard(deck.dealCard());
							System.out.println(
									user.getName() + user.getHand() + "\tvalue: " + user.getHand().getHandValue());
							// check for bust
							check = user.getHand().isBust();
							if (check == true) {
								System.out.println();
								System.out.println(user.getName() + " " + "Bust");
								break;
							}
						}

					} while (hitOption != 2);

				} catch (InputMismatchException e) {
					System.out.println("not a valid input");
				}

				// do not continue if user busted
				if (check != true) {

					System.out.println();

					System.out.println(dealer.getName() + " turn:");
					System.out.println(
							dealer.getName() + dealer.getHand() + "\tvalue: " + dealer.getHand().getHandValue());
					while (dealer.check17()) {
						System.out.print("Dealer Hit: ");
						dealer.getHand().addCard(deck.dealCard());
						System.out.println(
								dealer.getName() + dealer.getHand() + "\tvalue: " + dealer.getHand().getHandValue());
						// check for bust
						check = dealer.getHand().isBust();
						if (check == true) {
							System.out.println(dealer.getName() + "Bust");
							break;
						}
					}
				}

				while (check != true) {

					System.out.println();

					// System.out.println("Checking for winner!");

					if (dealer.getHand().getHandValue() == user.getHand().getHandValue()) {
						System.out.println("Tie\tPush.....");
						check = true;
						break;

					}
					if (dealer.getHand().getHandValue() > user.getHand().getHandValue()
							&& (!(dealer.getHand().getHandValue() > 21))) {
						System.out.println(
								dealer.getName() + " wins! with " + dealer.getHand().getHandValue() + " points");
						check = true;
						break;
					}

					if (user.getHand().getHandValue() > dealer.getHand().getHandValue()
							&& (!(user.getHand().getHandValue() > 21)));
					check = true;
					System.out.println(user.getName() + " wins! with " + user.getHand().getHandValue());
				}
			}
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

	public void printBothHands() {
		System.out.println(user.getName() + user.getHand());
		System.out.println();
		System.out.println(dealer.getName() + dealer.getHand());
	}

}