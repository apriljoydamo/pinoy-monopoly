import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;


//VS4E -- DO NOT REMOVE THIS LINE!
public class GameBoard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pBoard;
	private JPanel pPlayer;
	private JPanel pDice;
	private JLabel lMonopoly;
	private JLabel lDice2;
	private JLabel lDice1;
	private JButton bRollDice;
	Dice dice = new Dice();
	private JLabel lBapor;
	private JLabel lAzkal;
	private JLabel lIron;
	private JLabel lShoe;
	private JLabel lCar;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public GameBoard() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getBoardPanel(), new Constraints(new Leading(-3, 609, 10, 10), new Leading(0, 603, 12, 12)));
		add(getDicePanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(485, 118, 10, 10)));
		add(getPlayerPanel(), new Constraints(new Leading(605, 210, 10, 10), new Leading(-17, 500, 10, 10)));
		setSize(817, 605);
	}

	private JLabel getCarLabel() {
		if (lCar == null) {
			lCar = new JLabel();
			lCar.setVisible(false);
			lCar.setIcon(new ImageIcon(getClass().getResource("/car_token.png")));
		}
		return lCar;
	}

	private JLabel getShoeLabel() {
		if (lShoe == null) {
			lShoe = new JLabel();
			lShoe.setVisible(false);
			lShoe.setIcon(new ImageIcon(getClass().getResource("/shoe_token.png")));
		}
		return lShoe;
	}

	private JLabel getIronLabel() {
		if (lIron == null) {
			lIron = new JLabel();
			lIron.setVisible(false);
			lIron.setIcon(new ImageIcon(getClass().getResource("/iron_token.png")));
		}
		return lIron;
	}

	private JLabel getAzkalLabel() {
		if (lAzkal == null) {
			lAzkal = new JLabel();
			lAzkal.setVisible(false);
			lAzkal.setIcon(new ImageIcon(getClass().getResource("/dog_token.png")));
		}
		return lAzkal;
	}

	private JLabel getBaporLabel() {
		if (lBapor == null) {
			lBapor = new JLabel();
			lBapor.setVisible(false);
			lBapor.setIcon(new ImageIcon(getClass().getResource("/ship_token.png")));
		}
		return lBapor;
	}

	private JButton getRollDice() {
		if (bRollDice == null) {
			bRollDice = new JButton();
			bRollDice.setText("Roll Button");
			bRollDice.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dice.rollDiceResult1();
					dice.rollDiceResult2();
			
			switch(dice.getDice1stResult()){
			case 1:
				lDice1.setIcon(new ImageIcon(getClass().getResource("/diceOne.png")));
				break;
			case 2:
				lDice1.setIcon(new ImageIcon(getClass().getResource("/diceTwo.png")));
				break;
			case 3:
				lDice1.setIcon(new ImageIcon(getClass().getResource("/diceThree.png")));
				break;
			case 4:
				lDice1.setIcon(new ImageIcon(getClass().getResource("/diceFour.png")));
				break;
			case 5:
				lDice1.setIcon(new ImageIcon(getClass().getResource("/diceFive.png")));
				break;
			case 6:
				lDice1.setIcon(new ImageIcon(getClass().getResource("/diceSix.png")));
				break;
			}
			
			switch(dice.getDice2ndResult()){
			case 1:
				lDice2.setIcon(new ImageIcon(getClass().getResource("/diceOne.png")));
				break;
			case 2:
				lDice2.setIcon(new ImageIcon(getClass().getResource("/diceTwo.png")));
				break;
			case 3:
				lDice2.setIcon(new ImageIcon(getClass().getResource("/diceThree.png")));
				break;
			case 4:
				lDice2.setIcon(new ImageIcon(getClass().getResource("/diceFour.png")));
				break;
			case 5:
				lDice2.setIcon(new ImageIcon(getClass().getResource("/diceFive.png")));
				break;
			case 6:
				lDice2.setIcon(new ImageIcon(getClass().getResource("/diceSix.png")));
				break;
			}
					
				}
			});
		}
		return bRollDice;
	}

	private JLabel getDice1Label() {
		if (lDice1 == null) {
			lDice1 = new JLabel();
			lDice1.setIcon(new ImageIcon(getClass().getResource("/diceOne.png")));
			
		}
		return lDice1;
	}

	private JLabel getDice2Label() {
		if (lDice2 == null) {
			lDice2 = new JLabel();
			lDice2.setIcon(new ImageIcon(getClass().getResource("/diceOne.png")));
		}
		return lDice2;
	}

	private JLabel getMonopolyLabel() {
		if (lMonopoly == null) {
			lMonopoly = new JLabel();
			lMonopoly.setIcon(new ImageIcon(getClass().getResource("/MonopolyBoardFinal.png")));
		}
		return lMonopoly;
	}

	private JPanel getDicePanel() {
		if (pDice == null) {
			pDice = new JPanel();
			pDice.setBackground(new Color(128, 0, 255));
			pDice.setLayout(new GroupLayout());
			pDice.add(getDice1Label(), new Constraints(new Leading(49, 10, 10), new Leading(28, 10, 10)));
			pDice.add(getDice2Label(), new Constraints(new Leading(124, 10, 10), new Leading(28, 12, 12)));
			pDice.add(getRollDice(), new Constraints(new Leading(64, 10, 10), new Leading(73, 10, 10)));
		}
		return pDice;
	}

	private JPanel getPlayerPanel() {
		if (pPlayer == null) {
			pPlayer = new JPanel();
			pPlayer.setBackground(new Color(128, 0, 128));
			pPlayer.setLayout(new GroupLayout());
		}
		return pPlayer;
	}

	private JPanel getBoardPanel() {
		if (pBoard == null) {
			pBoard = new JPanel();
			pBoard.setBackground(new Color(64, 0, 64));
			pBoard.setLayout(new GroupLayout());
			pBoard.add(getCarLabel(), new Constraints(new Leading(521, 10, 10), new Leading(514, 10, 10)));
			pBoard.add(getShoeLabel(), new Constraints(new Leading(555, 10, 10), new Leading(516, 10, 10)));
			pBoard.add(getIronLabel(), new Constraints(new Leading(554, 12, 12), new Trailing(12, 613, 613)));
			pBoard.add(getAzkalLabel(), new Constraints(new Leading(518, 12, 12), new Trailing(8, 613, 613)));
			pBoard.add(getBaporLabel(), new Constraints(new Leading(534, 10, 10), new Trailing(8, 613, 613)));
			pBoard.add(getMonopolyLabel(), new Constraints(new Leading(5, 10, 10), new Leading(2, 599, 10, 10)));
			}
		return pBoard;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameBoard frame = new GameBoard();
				frame.setDefaultCloseOperation(GameBoard.EXIT_ON_CLOSE);
				frame.setTitle("GameBoard");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
