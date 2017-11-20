import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener{
	private Model model;
	private View view;
	
	Controller(){
		view = new View(this);
		model = new Model(view);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JButton) {
			if(e.getSource() == view.getResetButton()) {
				view.resetGame();
				model.reset();
			}
			else {
				Point pos = (Point)((JButton)e.getSource()).getClientProperty("index");
				model.makeMove(pos);
			}
		}
		
	}
	public View getView() {
		return view;
	}
	
}
