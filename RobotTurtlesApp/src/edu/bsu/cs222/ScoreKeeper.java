package edu.bsu.cs222;

public class ScoreKeeper {

	private Integer score = 0;
	private Integer totalMoves = 0;
	private final Integer PENALTY = 1;
	private final double DIVISOR = 1;
	private final double CONSTANT = 0.04;
	private final double MAX_SCORE = 5000;

	public void updateMoves(Integer moves) {
		totalMoves += moves + PENALTY;
		updateScore();
	}

	public Integer getScore() {
		return score;
	}

	private void updateScore() {
		score = (int) (MAX_SCORE / (DIVISOR + CONSTANT * totalMoves));
	}

	public void resetScore() {
		score = 0;
		totalMoves = 0;
	}
}
