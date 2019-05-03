package Games;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TicTac {

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel(new GridLayout(3, 3));
	private ArrayList<Integer> xPos = new ArrayList<>();
	private ArrayList<Integer> oPos = new ArrayList<>();
	private boolean single = false;
	private boolean done = false;
	private int turn = 2;

	public static void main(String[] arg) {
		new TicTac();
	}

	public TicTac() {
		JPanel decide = new JPanel(new GridLayout(2, 1));
		JButton one = new JButton("Single Player");
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				single = true;
				frame.remove(decide);
				startGame();
			}

		});
		JButton two = new JButton("Double player");
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.remove(decide);
				startGame();
			}

		});
		decide.add(one);
		decide.add(two);
		frame.add(decide);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocation(800, 200);
		frame.setResizable(false);

	}

	private void winCheck(ArrayList<Integer> arr, String winner) {
		if (arr.contains(0) && arr.contains(1) && arr.contains(2)) { // Top row
			finished(winner);
		} else if (arr.contains(0) && arr.contains(3) && arr.contains(6)) { // Left Side
			finished(winner);
		} else if (arr.contains(0) && arr.contains(4) && arr.contains(8)) { // "\"
			finished(winner);
		} else if (arr.contains(1) && arr.contains(4) && arr.contains(7)) { // Middle Col
			finished(winner);
		} else if (arr.contains(2) && arr.contains(5) && arr.contains(8)) { // Right Side
			finished(winner);
		} else if (arr.contains(3) && arr.contains(4) && arr.contains(5)) { // Middle Row
			finished(winner);
		} else if (arr.contains(6) && arr.contains(7) && arr.contains(8)) { // Bottom Row
			finished(winner);
		} else if (arr.contains(2) && arr.contains(4) && arr.contains(6)) { // "/"
			finished(winner);
		}

	}

	private void startGame() {
		for (int i = 0; i < 9; i++) {
			JButton but = new JButton();
			but.setName(i + "");
			click(but);
			panel.add(but);
		}
		frame.add(panel);
		frame.validate();
	}

	private void finished(String winner) {
		JOptionPane.showMessageDialog(frame, "Winner is " + winner, "The Winner is...",
				JOptionPane.INFORMATION_MESSAGE);
		frame.dispose();
		done = true;
	}

	private void click(JButton b) {
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (b.getIcon() == null) {

					if (turn % 2 == 0) {
						b.setIcon(new ImageIcon("Pictures\\tictac\\x.png"));
						xPos.add(Integer.parseInt(b.getName()));
					} else {
						b.setIcon(new ImageIcon("C:\\Users\\kungl\\Pictures\\tictac\\o.png"));
						oPos.add(Integer.parseInt(b.getName()));
					}

					if (xPos.size() >= 3) {
						winCheck(xPos, "X");
					}
					if (oPos.size() >= 3) {
						winCheck(oPos, "O");
					}

					turn++;
					if (turn == 11 && !done) {
						JOptionPane.showMessageDialog(frame, "Nobody won losers", "Sad... :(",
								JOptionPane.ERROR_MESSAGE);
						frame.dispose();
					}

					if (single == true) {
						Random ran = new Random();
						int choice = ran.nextInt(9);
						
						while (xPos.contains(Integer.parseInt(panel.getComponent(choice).getName())) || oPos.contains(Integer.parseInt(panel.getComponent(choice).getName()))) {
							choice = ran.nextInt(9);
						}

						if(xPos.size() >= 2) {
							if(smartChoice(0,1,2)) choice = 2;
							else if(smartChoice(1,2,0)) choice = 0;
							else if(smartChoice(0,2,1)) choice = 1;
							
							if(smartChoice(3,4,5)) choice = 5;
							else if(smartChoice(5,4,3)) choice = 3; //Rows
							else if(smartChoice(3,5,4)) choice = 4;
							
							if(smartChoice(6,7,8)) choice = 8;
							else if(smartChoice(7,8,6)) choice = 6;
							else if(smartChoice(6,8,7)) choice = 7;
							////////////////////////////////////
							if(smartChoice(0,3,6)) choice = 6;
							else if(smartChoice(0,6,3)) choice = 3;
							else if(smartChoice(3,6,0)) choice = 0;
							
							if(smartChoice(1,4,7)) choice = 7;
							else if(smartChoice(4,7,1)) choice = 1;
							else if(smartChoice(1,7,4)) choice = 4; //Col
							
							if(smartChoice(2,5,8)) choice = 8;
							else if(smartChoice(2,8,5)) choice = 5;
							else if(smartChoice(5,8,2)) choice = 2;
							///////////////////////////////////
							if(smartChoice(0,4,8)) choice = 8;
							else if(smartChoice(0,8,4)) choice = 4;
							else if(smartChoice(8,4,0)) choice = 0; //Diags
							
							if(smartChoice(6,4,2)) choice = 2;
							else if(smartChoice(2,4,6)) choice = 6;
							else if(smartChoice(2,6,4)) choice = 4;
						}
						
						JButton but = (JButton) panel.getComponent(choice);
						but.setIcon(new ImageIcon("C:\\Users\\kungl\\Pictures\\tictac\\o.png"));
						oPos.add(Integer.parseInt(but.getName()));
						if (oPos.size() >= 3 && !done) {
							winCheck(oPos, "O");
						}
						turn++;
					}
				}
			}

		});
	}
	
	private boolean smartChoice(int contain1, int contain2, int checkOther) {
		
			if(xPos.contains(contain1) && xPos.contains(contain2) && ((JButton) panel.getComponent(checkOther)).getIcon() == null) {
				return true;
			}
		
		return false;
	}
	
}