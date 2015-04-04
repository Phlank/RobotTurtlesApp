package edu.bsu.cs222;

import android.app.Activity;
import android.widget.ImageView;
import edu.bsu.cs222.activities.MapLayout;
import edu.bsu.cs222.finders.JewelFinder;
import edu.bsu.cs222.finders.TileFinder;
import edu.bsu.cs222.finders.TurtleFinder;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.JewelTile;
import edu.bsu.cs222.tiles.Tile;

public class MapTileSetter {

	private JewelTile jewel;
	private GameMap gameMap;
	private TurtleTile turtleTile;
	private TurtleMover turtleMover;
	private Activity activity;
	private static final Integer BEGINNING_SCORE_COUNTER = 0;
	private Integer scoreCounter = BEGINNING_SCORE_COUNTER;
	private static final Integer FIRST_INDEX = 0;
	private Integer id = 0;
	private ScoreKeeper scoreKeeper = new ScoreKeeper();

	public MapTileSetter(Activity activity) {
		this.activity = activity;
	}

	public void setMap(GameMap map) {
		this.gameMap = map;
		TileFinder tileFinder = new TileFinder(new JewelFinder());
		jewel = (JewelTile) tileFinder.findTile(map);
		scoreKeeper.resetScore();
		turtleMover = new TurtleMover(gameMap);
	}

	public void setTiles() {
		findTurtleTile();
		for (Tile tile : gameMap) {
			Location location = tile.getLocation();
			setTileImages(location);
		}
	}

	private void findTurtleTile() {
		TileFinder tileFinder = new TileFinder(new TurtleFinder());
		turtleTile = (TurtleTile) tileFinder.findTile(gameMap);
	}

	private void setTileImages(Location location) {
		Integer key = location.getTileLocation();
		try {
			id = R.id.class.getField("ImageView" + key).getInt(FIRST_INDEX);
			ImageView image = (ImageView) activity.findViewById(id);
			image.setImageResource(gameMap.getTile(location).getImage());
		} catch (IllegalAccessException | IllegalArgumentException
				| NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	public void turnTurtleToLeft() {
		turtleTile.turnTurtleLeft();
		setTiles();
		scoreCounter++;
	}

	public void turnTurtleToRight() {
		turtleTile.turnTurtleRight();
		setTiles();
		scoreCounter++;
	}

	public void fireLaser() {
		gameMap = turtleMover.fireLaser();
		setTiles();
		scoreCounter++;
	}

	public void moveTurtleForward() {
		gameMap = turtleMover.moveForward();
		setTiles();
		if (isTurtleAtJewelLocation()) {
			updateScore();
			((MapLayout) activity).displayWin(scoreKeeper.getScore());
		}
		scoreCounter++;
	}

	public void updateScore() {
		scoreKeeper.updateMoves(scoreCounter);
		scoreCounter = BEGINNING_SCORE_COUNTER;
	}

	private boolean isTurtleAtJewelLocation() {
		return turtleTile.getLocation().equals(jewel.getLocation());
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public TurtleTile getTurtleTile() {
		return turtleTile;
	}

	public TurtleMover getTurtleMover() {
		return turtleMover;
	}
}
