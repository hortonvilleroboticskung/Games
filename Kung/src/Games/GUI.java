package Games;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new GridLayout(3,1));

	public GUI() {
		
		JButton fish = new JButton("Go Fish");
		fish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel = new JPanel();
				frame.dispose();
				new Fish();
			}
			
		});
		
		JButton tacs = new JButton("Tic-Tac-Toe");
		tacs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				frame.dispose();
				new TicTac();
			}
			
		});
		
		JButton fours = new JButton("Connect Four");
		fours.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				frame.dispose();
				new ConnectFour();
			}
			
		});
		
		panel.add(fish);
		panel.add(tacs);
		panel.add(fours);
		frame.add(panel);
		frame.setSize(300,300);
		frame.setLocation(800, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
