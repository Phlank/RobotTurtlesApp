package edu.bsu.cs222.cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardList implements Iterable<Card>{

	private List<Card> cardList = new ArrayList<Card>();

	public Card getCard(Integer cardValue){
		return cardList.get(cardValue);
	}
	
	public void addSingleCard(Card card) {
		cardList.add(card);
	}

	public void removeCardFromList(int i){
		cardList.remove(i);
	}
	
	public Integer getSize(){
		return cardList.size();
	}
	
	@Override
	public Iterator<Card> iterator() {
		return cardList.iterator();
	}
}
