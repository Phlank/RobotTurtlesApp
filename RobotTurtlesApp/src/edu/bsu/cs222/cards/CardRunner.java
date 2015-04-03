package edu.bsu.cs222.cards;

import android.os.Handler;
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.enums.Command;

public class CardRunner {

	private MapTileSetter mapTileSetter;
	private Card card;
	private Integer cardCounter = 0;
	private CardList cardRunnerCardList;

	public CardRunner(MapTileSetter mapTileSetter) {
		this.mapTileSetter = mapTileSetter;
	}

	public void runList(CardList cardList) {
		this.cardRunnerCardList = cardList;
		if (cardCounter < cardRunnerCardList.getSize()) {
			runCardList();
		}else{
			mapTileSetter.updateScore();
		}
	}
	
	private void runCardList(){
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				executeCardList();
			}
		}, 500);
	}
	
	private void executeCardList(){
		card = cardRunnerCardList.getCard(cardCounter);
		runCard(card);
		cardCounter++;
		runList(cardRunnerCardList);
	}

	private void runCard(Card card) {
		Command command = card.getCommand();
		command.performTurtleAction(mapTileSetter);
	}
}
