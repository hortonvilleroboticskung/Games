package Games;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fish {

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public JFrame logger = new JFrame();
	public JPanel logPanel = new JPanel();
	public ArrayList<Card> deck = Card.deckMaker();
	public ArrayList<Card> p1 = startHand(5);
	public ArrayList<Card> com = startHand(5);
	public int point = 0;

	public Fish() {
		for (int i = 0; i < p1.size(); i++) {
			Card c = p1.get(i);
			fishyListener(c);
			panel.add(c.icon);
		}
		frame.add(panel);
		frame.pack();
		frame.setLocation(800, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logger.add(logPanel);
		logger.setLocation(400, 200);
		logger.setSize(400, 400);
		logger.setVisible(true);
		logger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ArrayList<Card> startHand(int startNum) {
		ArrayList<Card> hand = new ArrayList<>();
		for (int ii = 0; ii < startNum; ii++) {
			hand.add(deck.get(0));
			deck.remove(0);
		}

		pairing(hand);

		return hand;
	}

	public void pairing(ArrayList<Card> hand) {
		
		HashMap<String, Card> symbols = new HashMap<>();
		for (int aa = 0; aa < hand.size(); aa++) {
			if (!symbols.containsKey(hand.get(aa).symbol)) {
				symbols.put(hand.get(aa).symbol, hand.get(aa));
			} else {
				Card storedCard = symbols.get(hand.get(aa).symbol);
				symbols.remove(storedCard.symbol);
				if(hand.equals(p1)) {
				logPanel.add(new JLabel("You paired a " + storedCard + " with a " + hand.get(aa) + " in your hand"));
				logPanel.revalidate();
				point++;
				}
				hand.remove(aa);
				hand.remove(storedCard);
				aa -= 2;
			}
		}
	}

	public void comControl() {
		boolean paired = false;
		Random ran = new Random();
		int choice = ran.nextInt(com.size());
		//System.out.println("Computer Asked for: " + com.get(choice).symbol);
		for (int i = 0; i < p1.size(); i++) {
			if (com.get(choice).symbol.equals(p1.get(i).symbol)) {
				com.remove(choice);
				//System.out.println("and you had a " + p1.get(i));
				p1.remove(i);
				paired = true;
				break;
			}
		}

		if ((deck.size() != 0) && !paired) {
			com.add(deck.get(0));
			deck.remove(0);
		}

		pairing(com);
	}

	void fishyListener(Card c) {

		c.icon.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				boolean paired = false;
				for (int i = 0; i < com.size(); i++) {
					if (c.symbol.equals(com.get(i).symbol)) {
						logPanel.add(new JLabel("You stole a "+com.get(i) +" with your "+ c ));
						logPanel.revalidate();
						com.remove(i);
						p1.remove(c);
						paired = true;
						point++;
						break;
					}
				}

				if (!paired) {
					//System.out.println("You drew a " + deck.get(0));
					p1.add(deck.get(0));
					deck.remove(0);
					pairing(p1);
				}
				
				if (p1.size() == 0) {
					JOptionPane p = new JOptionPane();
					JOptionPane.showMessageDialog(frame, "YOU WON!!! with a total of " + point, "Congradulations!!! :)",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					logger.dispose();
				}
				//Computers Turn Now!
				if (com.size() != 0) {
					comControl();
				}

				if (com.size() == 0) {
					JOptionPane p = new JOptionPane();
					JOptionPane.showMessageDialog(frame, "You lost to a robot loser ", "Beep-Boop",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					logger.dispose();
				}

				panel.removeAll();
				for (int i = 0; i < p1.size(); i++) {
					Card just = p1.get(i);
					if (just.icon.getMouseListeners().length == 0) {
						fishyListener(just);
					}
					panel.add(just.icon);
				}

				//panel.validate();
				panel.repaint();
				frame.pack();
				frame.setTitle("Pairs:" + point);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

	public static void main(String[] args) {
		new Fish();
	}

}
