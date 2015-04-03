package edu.bsu.cs222;

import junit.framework.TestCase;

public class ScoreKeeperTest extends TestCase{

	private ScoreKeeper scoreKeeper;
	
	protected void setUp(){
		scoreKeeper = new ScoreKeeper();
	}
	
	public void testScoreCanBeUpdated(){
		scoreKeeper.updateMoves(12);
		scoreKeeper.updateMoves(24);
		Integer actual = scoreKeeper.getScore();
		Integer expected = 1984;
		assertEquals(expected, actual);
	}
}
