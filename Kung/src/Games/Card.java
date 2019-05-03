package Games;

import javax.swing.*;
import java.util.*;

public class Card{

	public String symbol;
	public String suit; // Hearts Diamonds...
	public JLabel icon;

	public Card(String symbol, String suit) {
		this.symbol = symbol;
		this.suit = suit;
		this.icon = new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\Cards\\" + symbol + suit + ".PNG"));
	}

	public static ArrayList<Card> deckMaker(){
		ArrayList<Card> cards = new ArrayList<>();
		ArrayList<Card> deck = new ArrayList<>();
		String[] symbols = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String[] suits = { "Spades", "Clover", "Hearts", "Diamond" };

		for (int aa = 0; aa < symbols.length; aa++) {
			for (int ii = 0; ii < suits.length; ii++) {
				Card newone = new Card(symbols[aa],suits[ii]);
				cards.add(newone);
			}
		}
		int deckSize = symbols.length * suits.length;
		for (int i = 0; i < deckSize; i++) {
			Random ran = new Random();
			int index = ran.nextInt(cards.size());
			deck.add(cards.get(index));
			cards.remove(index);
		}
		return deck;
	}

	public String toString() {
		return symbol + " of " + suit;
	}
}
