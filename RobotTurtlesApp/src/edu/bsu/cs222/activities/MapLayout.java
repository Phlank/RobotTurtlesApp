package edu.bsu.cs222.activities;

import java.io.IOException;

import org.w3c.dom.Document;

import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.bsu.cs222.R;
import edu.bsu.cs222.cards.CardRunner;
import edu.bsu.cs222.enums.Command;
import edu.bsu.cs222.game.maps.GameMapDataParser;

public class MapLayout extends WinDisplay implements OnMenuItemClickListener {

	private Button left;
	private Button right;
	private Button forward;
	private Button laser;
	private Button menuButton;
	private PopupMenu menu;
	private Document document;
	private GameMapDataParser parser = new GameMapDataParser();
	private CardRunner cardRunner = new CardRunner(mapTileSetter);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.robot_turtles_map);
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
				cardRunner.run(Command.FORWARD);
			}
		});
	}

	public void addListenerLaserButton() {
		laser = (Button) findViewById(R.id.laser);
		laser.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				cardRunner.run(Command.LASER);
			}
		});
	}

	public void addListenerRightButton() {
		right = (Button) findViewById(R.id.right);
		right.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				cardRunner.run(Command.RIGHT);
			}
		});
	}

	public void addListenerLeftButton() {
		left = (Button) findViewById(R.id.left);
		left.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				cardRunner.run(Command.LEFT);
			}
		});
	}

	private void addButtons() {
		addListenerMenuButton();
		addListenerLeftButton();
		addListenerRightButton();
		addListenerForwardButton();
		addListenerLaserButton();
	}

	private void parsePlayerMap() {
		try {
			document = parser.parsePlayerMapData(getAssets().open(
					"playerMaps.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		gameMapSelecter.createInitialMap(document);
	}
}