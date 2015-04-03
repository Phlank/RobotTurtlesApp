package edu.bsu.cs222;

import junit.framework.TestCase;
import edu.bsu.cs222.cards.Card;
import edu.bsu.cs222.cards.CardList;
import edu.bsu.cs222.enums.Command;

public class CardListTest extends TestCase{

	private CardList cardlist;
	private Card forwardCard = new Card(Command.FORWARD);
	private Card leftCard = new Card(Command.LEFT);
	private Card rightCard = new Card(Command.RIGHT);
	private static final Integer FIRST_CARD = 0;
	private static final Integer FOURTH_CARD = 3;
	private static final Integer CARD_LIST_SIZE = 5;
	private static final Integer REMOVED_CARD_LIST_SIZE = 4;
	
	public void setUp(){
		cardlist= new CardList();
	}
	
	public void testThatSingleCardAddsToList(){
		Card forwardCard = new Card(Command.FORWARD);
		cardlist.addSingleCard(forwardCard);
		Command actual = cardlist.getCard(FIRST_CARD).getCommand();
		Command expected = Command.FORWARD;
		assertEquals(expected,actual);
	}
	
	public void testThatMultipleCardsAddToList(){
		addMultipleCards();
		Integer actual = cardlist.getSize();
		Integer expected = CARD_LIST_SIZE;
		assertEquals(expected, actual);
	}
	
	public void testRemoveCardFromList(){
		addMultipleCards();
		cardlist.removeCardFromList(FOURTH_CARD);
		Integer actual = cardlist.getSize();
		Integer expected = REMOVED_CARD_LIST_SIZE;
		assertEquals(expected,actual);
	}
	
	private void addMultipleCards(){
		cardlist.addSingleCard(forwardCard);
		cardlist.addSingleCard(leftCard);
		cardlist.addSingleCard(rightCard);
		cardlist.addSingleCard(rightCard);
		cardlist.addSingleCard(leftCard);
	}
}
