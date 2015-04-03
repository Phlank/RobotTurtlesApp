package edu.bsu.cs222.activities;

import java.io.IOException;

import org.w3c.dom.Document;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import edu.bsu.cs222.R;
import edu.bsu.cs222.cards.Card;
import edu.bsu.cs222.cards.CardList;
import edu.bsu.cs222.cards.CardRunner;
import edu.bsu.cs222.enums.Command;
import edu.bsu.cs222.game.maps.GameMapDataParser;

public class MapLayout extends WinDisplay implements OnMenuItemClickListener {

	private Button left;
	private Button right;
	private Button forward;
	private Button laser;
	private Button menuButton;
	private Button run;
	private PopupMenu menu;
	private Document document;
	private Card card;
	private GameMapDataParser parser = new GameMapDataParser();
	private CardList cardList = new CardList();
	private CardRunner cardRunner = new CardRunner(mapTileSetter);
	private LinearLayout cardHolder;
	private Button cardPlayed;
	private Activity activity = this;
	private Integer id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.robot_turtles_map);
		cardHolder = (LinearLayout) findViewById(R.id.CardHolder);
		addButtons();
		parsePlayerMap();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void showPopup(View v) {
		menu = new PopupMenu(this, v);
		MenuInflater inflater = menu.getMenuInflater();
		menu.setOnMenuItemClickListener(this);
		inflater.inflate(R.menu.map, menu.getMenu());
		menu.show();
	}

	public boolean onMenuItemClick(MenuItem item) {
		MapMenuItem mapMenuItem = new MapMenuItem(item.getOrder());
		gameMapSelecter.mapSelecter(mapMenuItem);
		return true;
	}

	public void addListenerMenuButton() {
		menuButton = (Button) findViewById(R.id.menu);
		menuButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				showPopup(menuButton);
			}
		});
	}

	public void addListenerForwardButton() {
		forward = (Button) findViewById(R.id.forward);
		forward.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				addCardButtons(Command.FORWARD);
				addCardButtonView();
			}
		});
	}
	
	public void addListenerLaserButton() {
		laser = (Button) findViewById(R.id.laser);
		laser.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				addCardButtons(Command.LASER);
				addCardButtonView();
			}
		});
	}

	public void addListenerRightButton() {
		right = (Button) findViewById(R.id.right);
		right.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				addCardButtons(Command.RIGHT);
				addCardButtonView();
			}
		});
	}

	public void addListenerLeftButton() {
		left = (Button) findViewById(R.id.left);
		left.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				addCardButtons(Command.LEFT);
				addCardButtonView();
			}
		});
	}
	
	public void addListenerRunButton() {
		run = (Button) findViewById(R.id.run);
		run.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				cardRunner.runList(cardList);
				cardHolder.removeAllViewsInLayout();
			}
		});
	}

	View.OnClickListener addListenerCardPlayed(final Button button,
			final Integer id) {
		return new View.OnClickListener() {
			public void onClick(View v) {
				cardHolder.removeView(button);
				cardList.removeCardFromList(id);
			}
		};
	}
	
	private void addButtons(){
		addListenerMenuButton();
		addListenerLeftButton();
		addListenerRightButton();
		addListenerForwardButton();
		addListenerLaserButton();
		addListenerRunButton();
	}
	
	private void parsePlayerMap(){
		try {
			document = parser.parsePlayerMapData(getAssets().open(
					"playerMaps.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		gameMapSelecter.createInitialMap(document);
	}
	
	private void addCardButtons(Command command){
		card = new Card(command);
		cardList.addSingleCard(card);
		cardPlayed = new Button(activity);
		cardPlayed.setBackgroundResource(card.getCardImage());
		id = cardList.getSize() - 1;
	}
	
	private void addCardButtonView(){
		cardPlayed.setOnClickListener(addListenerCardPlayed(cardPlayed,
				id));
		cardHolder.addView(cardPlayed);
	}
}