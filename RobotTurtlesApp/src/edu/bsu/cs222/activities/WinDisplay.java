package edu.bsu.cs222.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.R;
import edu.bsu.cs222.bot.GraphSolverTurtleBot;
import edu.bsu.cs222.game.maps.GameMapSelecter;

public class WinDisplay extends ActionBarActivity {

	protected MapTileSetter mapTileSetter = new MapTileSetter(this);
	public GameMapSelecter gameMapSelector = new GameMapSelecter(mapTileSetter);
	private AlertDialog.Builder builder;
	private static final Integer FINAL_MAP = 15;
	private static final Integer FIRST_MAP = 1;
	private static final Integer INCREMENT_MAP = 1;
	protected GraphSolverTurtleBot bot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win_display);
		builder = new AlertDialog.Builder(WinDisplay.this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.win_display, menu);
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

	public void displayWin(Integer score) {
		setMessages(score);
		builder.setPositiveButton(R.string.reset,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pickMap();
					}
				});
		AlertDialog winScreen = builder.create();
		winScreen.show();
	}

	private void pickMap() {
		Integer currentMap = gameMapSelector.getCurrentMap();
		if (currentMap.equals(FINAL_MAP)) {
			gameMapSelector.mapSelecter(new MapMenuItem(FIRST_MAP));
		} else {
			gameMapSelector.mapSelecter(new MapMenuItem(currentMap
					+ INCREMENT_MAP));
		}
		bot = new GraphSolverTurtleBot(mapTileSetter, mapTileSetter.getGameMap());

	}

	public void setMessages(Integer score) {
		Integer currentMap = gameMapSelector.getCurrentMap();
		if (currentMap.equals(FINAL_MAP)) {
			setFinalMessage(score);
		} else {
			setRegularMessage(score);
		}
	}

	private void setFinalMessage(Integer score) {
		builder.setMessage("You Found the Last Jewel! \n Your Score is: "
				+ score + "\n Do You Want to Play Again?");
		builder.setTitle(R.string.win_message_title);
	}

	private void setRegularMessage(Integer score) {
		builder.setMessage("Nice Job! You Found the Jewel! \n Your Score is: "
				+ score);
		builder.setTitle(R.string.replay_message_title);
	}
}
