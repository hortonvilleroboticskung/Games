package Games;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Checkers {

	String color;
	int position;
	JLabel icon;
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel(new GridLayout(8,8));
	
	public Checkers(String color) {
		this.color = color;
		this.icon = new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\ConnectFour\\"+color+".png"));
	}
	
	public int move() {
		
		return 0;
	}
	
	public void piecePlace() {
		
	}
	
	
	public static void main(String[] args) {
		
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				panel.add(new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\CheckerBoard\\white.png")));
				panel.add(new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\CheckerBoard\\black.png")));
			}
			for (int i = 0; i < 4; i++) {
				panel.add(new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\CheckerBoard\\black.png")));
				panel.add(new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\CheckerBoard\\white.png")));
			}
		}
		JLabel a = (JLabel) panel.getComponent(0);
		a.setIcon(new ImageIcon("C:\\Users\\kungl\\Pictures\\ConnectFour\\red.png"));
		frame.add(panel);
		frame.setResizable(false);
		frame.setLocation(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
	}
	
}
