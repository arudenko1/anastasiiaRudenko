package com.company.poker;

import java.util.Random;

public class Deck {

    private static int numberOfCards = 52;
    private static int numberOfPlayers = 4;

    private static boolean deckIsShuffled;
    private static Card[] deck;

    public static void createDeck() {

        String[] cardValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] cardSuits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        deck = new Card[numberOfCards];
        int count = 0;
        for (String suite : cardSuits) {
            for (String value : cardValues) {
                deck[count++] = new Card(value, suite);
            }
        }
        deckIsShuffled = false;
    }

    public static void shuffleDeck() throws DeckNotFoundException {
        if (deck == null) {
            throw new DeckNotFoundException();
        }

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int in = random.nextInt(numberOfCards);
            int out = random.nextInt(numberOfCards);
            Card card = deck[in];
            deck[in] = deck[out];
            deck[out] = card;
        }
        deckIsShuffled = true;
    }

    public static void serveDeck() throws DeckNotFoundException, DeckNotShuffledException {
        if (deck == null) {
            throw new DeckNotFoundException();
        }
        if (deckIsShuffled == false) {
            throw new DeckNotShuffledException();
        }
        int count = 0;
        for (int round = 1; round < 6; round++) {
            System.out.println("Round " + round);

            for (int player = 1; player < numberOfPlayers + 1; player++) {
                Card card = deck[count++];
                System.out.printf("Player %d gets card %s%n", player, String.format("%s of %s", card.cardValue, card.cardSuit));
            }
            System.out.println("");
        }
    }
}
