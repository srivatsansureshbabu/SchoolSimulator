import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClickPopUp <Thing extends Person> extends Thread{
	
	JButton button;
	JLabel label = new JLabel();
	Thing thing;
	int x;
	int y;
	private ArrayList<Thing> teacher;
	public ClickPopUp(JButton button, Thing thing, ArrayList<Thing> teacher, JLabel label, JFrame frame) {
		this.button = button;
		this.thing = thing;
		this.label = label;
		x = button.getX()+125;
		y = button.getY()-200;
		label.setText("+"+thing.getAssignments());
		label.setVisible(true);
		label.setBounds(x, y, 500, 500);
		this.teacher = teacher;
		frame.add(label);
		this.start();
	}
	
	@Override
	public void run() {
		while(true) {
		for(int i = 0; i <= 1; i++) {
			y-=1;
			label.setBounds(x,y,500	,500);
			label.setText("+"+teacher.size());
			if(y == button.getY()-350) {
				label.setVisible(false);
				this.stop();
			}
		}
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	
}
