package Games;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckerBoard {

	public static void setup(JPanel panel) {
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
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(8, 8));
		setup(panel);
		frame.add(panel);
		frame.setLocation(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
	}

}
