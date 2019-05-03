package Games;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BattleShip {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new GridLayout(11,11));
	String[][] pieces1 = {
			{"A1","A2"},//U-Boats
			{"","",""},//Subs
			{"","","",""},//Cruiser
			{"","","","",""}//Carrier
			};
	String[][] pieces2 = {
			{"A1","A2"},//U-Boats
			{"","",""},//Subs
			{"","","",""},//Cruiser
			{"","","","",""}//Carrier
			};
	
	public BattleShip() {
		String[] aplha = {"A","B","C","D","E","F","G","H","I","J"};
		String[] nums = {"1","2","3","4","5","6","7","8","9","10"};
		panel.add(new JLabel());
		for(int i = 0; i < 10; i++) {
			JLabel cords = new JLabel();
			cords.setText("       "+aplha[i]);
			panel.add(cords);
		}
		for(int i = 0; i < 100; i++) {
			if(i%10==0) {
				JLabel cords = new JLabel();
				cords.setText("        "+nums[i/10]);
				panel.add(cords);
			}
			JLabel wave = new JLabel(new ImageIcon("C:\\Users\\kungl\\Pictures\\BattleShip\\wave.png"));
			panel.add(wave);
		}
		
		frame.add(panel);
		frame.setSize(560,595);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 200);
		frame.setResizable(false);
		
		String boats = null; 
		while(boats==null) {
			boats = JOptionPane.showInputDialog(frame, "Pick a Boat A1-A2", "Champ Select", JOptionPane.OK_OPTION);
		}
		System.out.println(boats);
		
	}
	
	public static void main(String[] args) {
		new BattleShip();
	}
	
}
