import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable{
	private int board[][] = new int[3][3];
	private int moveCounter;
	private boolean gameOver;
	private boolean xTurn = true;
	public Model(Observer o){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = 0;
			}
		}
		moveCounter = 0;
		gameOver = false;
		this.addObserver(o);
	}
	public void reset() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				board[row][col] = 0;
			}
		}
		moveCounter = 0;
		gameOver = false;
		this.setChanged();
		notifyObservers(false);
	}
	public void makeMove(Point pos) {
		makeMove(pos.x, pos.y);
	}
	public void makeMove(int row, int col){
		board[row][col] = this.getTurnVal();
		moveCounter++;
		if(moveCounter == 9 || this.getWinnerValue() != 0) {
			gameOver = true;
		}
		this.setChanged();
		notifyObservers(new Point(row, col));
		reverseTurn();
	}
	public String getWinner() {
		int val = this.getWinnerValue();
		if(val == -1) {
			return "X";
		}
		else if(val == 1) {
			return "O";
		}
		else {
			return "Tie";
		}
	}
	public int getWinnerValue() {
		int sum = 0;
		for(int row = 0; row < 3; row++) {
			sum = board[row][0] + board[row][1] + board[row][2];
			if(sum == -3) {
				return -1;
			}
			else if(sum == 3) {
				return 1;
			}
			sum = 0;
		}
		for (int col = 0; col < 3; col++) {
			sum = board[0][col] + board[1][col] + board[2][col];
			if(sum == -3) {
				return -1;
			}
			else if(sum == 3) {
				return 1;
			}
			sum = 0;
		}
		sum = board[0][0] + board[1][1] + board[2][2];
		if(sum == -3) {
			return -1;
		}
		else if(sum == 3) {
			return 1;
		}
		sum = 0;
		
		sum = board[0][2] + board[1][1] + board[2][0];
		
		if(sum == -3) {
			return -1;
		}
		else if(sum == 3) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public boolean isGameOver() {
		return gameOver;
	}
	public boolean isXTurn() {
		return xTurn;
	}
	public String getReverseTurn() {
		if(xTurn) {
			return "O";
		}
		else {
			return "X";
		}
	}
	public int getTurnVal() {
		if(xTurn) {
			return -1;
		}
		return 1;
	}
	public String getTurnString() {
		if(xTurn) {
			return "X";
		}
		return "O";
	}
	private void reverseTurn() {
		if(xTurn) {
			xTurn = false;
		}
		else 
		{
			xTurn = true;
		}
	}
}
