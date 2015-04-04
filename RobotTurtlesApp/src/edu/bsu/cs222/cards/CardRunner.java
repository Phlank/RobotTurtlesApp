package edu.bsu.cs222.cards;

import android.os.Handler;
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.enums.Command;

public class CardRunner {

	private MapTileSetter mapTileSetter;
	private boolean running = false;

	public CardRunner(MapTileSetter mapTileSetter) {
		this.mapTileSetter = mapTileSetter;
	}

	public void runList(CardList cardList) {
		System.out.println("runList hit");
		if (running) {
			return;
		}
		running = true;
		runCardList(cardList);
		mapTileSetter.updateScore();
		running = false;
	}

	private void runCardList(final CardList cardList) {
		System.out.println("runCardList hit");
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				for (Card card : cardList) {
					runCard(card);
				}
			}
		}, 100);
	}

	private void runCard(Card card) {
		System.out.println("runCard hit");
		Command command = card.getCommand();
		command.performTurtleAction(mapTileSetter);
	}
}
