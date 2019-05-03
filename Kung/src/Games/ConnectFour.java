package Games;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class ConnectFour {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new GridLayout(6, 7));
	ArrayList<Integer> redChips = new ArrayList<>();
	ArrayList<Integer> yellowChips = new ArrayList<>();
	String empty = "C:\\Users\\kungl\\Pictures\\ConnectFour\\emptytwo.png";
	int turn = 0;

	public ConnectFour() {
		for (int i = 0; i < 42; i++) {
			JLabel open = new JLabel(new ImageIcon(empty));
			open.setName(i + "");
			frame.setTitle("Red's Turn");
			open.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					int thisOne = placeCheck(Integer.parseInt(open.getName()));

					if (thisOne < 0) {
						JOptionPane.showMessageDialog(frame, "Chip Stack Overflow Error!", "Stop That",
								JOptionPane.ERROR_MESSAGE);
					} else if (thisOne >= 0) {
						JLabel replace = (JLabel) panel.getComponent(thisOne);

						if (turn % 2 == 0) {
							replace.setIcon(new ImageIcon("C:\\Users\\kungl\\Pictures\\ConnectFour\\redBluetwo.png"));
							redChips.add(thisOne);
							frame.setTitle("Yellow's Turn");
						} else {
							replace.setIcon(new ImageIcon("C:\\Users\\kungl\\Pictures\\ConnectFour\\yellowBluetwo.png"));
							yellowChips.add(thisOne);
							frame.setTitle("Red's Turn");
						}
						turn++;
					}

					if (turn >= 7) {
						if (redChips.size() >= 4) {
							winCondition(redChips, "Red");
						}
						if (yellowChips.size() >= 4) {
							winCondition(yellowChips, "Yellow");
						}
					}
					if (turn == 42) {
						JOptionPane.showMessageDialog(frame, "Didn't know this was possible", "No Winner",
								JOptionPane.ERROR_MESSAGE);
						frame.dispose();
					}
				}

				@Override public void mouseEntered(MouseEvent arg0){}@Override public void mouseExited(MouseEvent arg0){}@Override public void mousePressed(MouseEvent arg0){}@Override public void mouseReleased(MouseEvent arg0){}

			});

			panel.add(open);
		}

		frame.add(panel);
		frame.setLocation(700, 200);
		frame.setSize(710, 640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	/*
	 * | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
	 * | 7 | 8 | 9 | 10| 11| 12| 13| 
	 * | 14| 15| 16| 17| 18| 19| 20| 
	 * | 21| 22| 23| 24| 25| 26| 27| 
	 * | 28| 29| 30| 31| 32| 33| 34| 
	 * | 35| 36| 37| 38| 39| 40| 41|
	 */

	private int placeCheck(int index) {

		if (index % 7 == 0)return labelCheck(35);
		if (index % 7 == 1)return labelCheck(36);
		if (index % 7 == 2)return labelCheck(37);
		if (index % 7 == 3)return labelCheck(38);
		if (index % 7 == 4)return labelCheck(39);
		if (index % 7 == 5)return labelCheck(40);
		if (index % 7 == 6)return labelCheck(41);

		return -1;
	}

	private int labelCheck(int bottom) {

		while (!((JLabel) panel.getComponent(bottom)).getIcon().toString().equals(empty)) {
			bottom = bottom - 7;
			if (bottom < 0) {
				return -1;
			}
		}
		return bottom;
	}

	private int rowCheck(int currentChip) {
		return (currentChip - currentChip % 7) / 7;
	}

	private void winCondition(ArrayList<Integer> chip, String color) {

		for (int i = 0; i < chip.size(); i++) {
			
			int currentChip = chip.get(i);
			int row = rowCheck(currentChip);
			
			if ((chip.contains(currentChip + 1) && rowCheck(currentChip + 1) == row)
					&& (chip.contains(currentChip + 2) && rowCheck(currentChip + 2) == row)
					&& (chip.contains(currentChip + 3) && rowCheck(currentChip + 3) == row)) { // -
				JOptionPane.showMessageDialog(frame, color + " has won the game", "Congrats!",
						JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				break;
			}
			if (chip.contains(currentChip + 7) && chip.contains(currentChip + 14) && chip.contains(currentChip + 21)) { // |
				JOptionPane.showMessageDialog(frame, color + " has won the game", "Congrats!",
						JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				break;
			}
			if ((chip.contains(currentChip + 8) && rowCheck(currentChip + 8) == row + 1)
					&& (chip.contains(currentChip + 16) && rowCheck(currentChip + 16) == row + 2)
					&& (chip.contains(currentChip + 24) && rowCheck(currentChip + 24) == row + 3)) { // \
				JOptionPane.showMessageDialog(frame, color + " has won the game", "Congrats!",
						JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				break;
			}
			if ((chip.contains(currentChip + 6) && rowCheck(currentChip + 6) == row + 1)
					&& (chip.contains(currentChip + 12) && rowCheck(currentChip + 12) == row + 2)
					&& (chip.contains(currentChip + 18) && rowCheck(currentChip + 18) == row + 3)) { // /
				JOptionPane.showMessageDialog(frame, color + " has won the game", "Congrats!",
						JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				break;
			}
		}
	}

	public static void main(String[] args) {
		new ConnectFour();
	}

}
