import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

//import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame implements Observer{

	private JButton button[][] = new JButton[3][3];
	private JPanel game;
	//private JPanel info;
	private JLabel turn;
	private JLabel winner;
	private JButton reset;
	
	public View(Controller controller) {
		super("Tic Tac Toe");
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 600));
		game = new JPanel(new GridLayout(3, 3));
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				button[row][col] = new JButton(" ");
				button[row][col].addActionListener(controller);
				button[row][col].setPreferredSize(new Dimension(30,30));
				button[row][col].putClientProperty("index", new Point(row, col));
				game.add(button[row][col]);
			}
		}
		this.add(game, BorderLayout.CENTER);
		turn = new JLabel("The current turn is X");
		winner = new JLabel("");
		reset = new JButton("reset");
		reset.addActionListener(controller);
		this.add(turn, BorderLayout.NORTH);
		this.add(winner, BorderLayout.SOUTH);
		this.add(reset, BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
		
	}
	@Override
	public void update(Observable game, Object index) {
		// TODO Auto-generated method stub
		if(game instanceof Model) {
			if(((Model)game).isGameOver()) {
				winner.setText("The winner is: " + ((Model)game).getWinner());
				for(int row = 0; row < 3; row++) {
					for(int col = 0; col < 3; col++) {
						button[row][col].setEnabled(false);
					}
				}
			}
			if(index instanceof Point) {
				Point pos = (Point)index;
				button[pos.x][pos.y].setEnabled(false);
				button[pos.x][pos.y].setText(((Model)game).getTurnString());
				turn.setText("The current turn is " +  ((Model)game).getReverseTurn());
			}
		}
	}
	public void resetGame() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				button[row][col].setText(" ");
				button[row][col].setEnabled(true);
			}
		}
		winner.setText("");
	}
	public JButton getResetButton() {
		return reset;
	}

}
