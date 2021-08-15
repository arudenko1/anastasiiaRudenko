package com.company.poker;

public class PokerGame {
    public static void main(String[] args) {
        Deck deck = new Deck();

        try {
            deck.createDeck();
            deck.shuffleDeck();
            deck.serveDeck();
        } catch (DeckNotFoundException e) {
            System.err.println("Deck is not created yet.");
        } catch (DeckNotShuffledException e) {
            System.err.println("Deck is not shuffled yet.");
        }
    }
}
