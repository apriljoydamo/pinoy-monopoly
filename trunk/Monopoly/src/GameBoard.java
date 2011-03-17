import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;


//VS4E -- DO NOT REMOVE THIS LINE!
public class GameBoard extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel pBoard;
	private JPanel pPlayer;
	private JPanel pDice;
	private JLabel lMonopoly;
	private JLabel lDice2;
	private JLabel lDice1;
	private JButton bRollDice;
	Dice dice = new Dice();
	Players playerOrder[] = new Players[8];
	int x = 0;
	private JLabel lBapor;
	private JLabel lAzkal;
	private JLabel lIron;
	private JLabel lShoe;
	private JLabel lCar;
	private JLabel lThimble;
	private JLabel lHat;
	private JLabel lWheelBarrow;
	private JPanel pTitleDeeds;
	private JButton bPlay;
	private JTextField fPlayerName;
	private JTextField fPlayerMoney;
	static int numberOfPlayers;
	Thread t;
	boolean isRolling, isRunning;
	private JButton bEndTurn;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public GameBoard() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getBoardPanel(), new Constraints(new Leading(-3, 609, 10, 10), new Leading(0, 603, 12, 12)));
		add(getDicePanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(485, 118, 10, 10)));
		add(getPlayerPanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(-17, 500, 10, 10)));
		setSize(810, 600);
	}

	private JButton getEndTurnButton() {
		if (bEndTurn == null) {
			bEndTurn = new JButton();
			bEndTurn.setEnabled(false);
			bEndTurn.setText("End Turn");
			bEndTurn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					 x++;
				        if(x==numberOfPlayers){
				                x = 0;
				        }
				        fPlayerName.setText(playerOrder[x].getPlayerName());
					}
			});
		}
		return bEndTurn;
	}

	private JTextField getPlayerMoneyField() {
		if (fPlayerMoney == null) {
			fPlayerMoney = new JTextField();
			fPlayerMoney.setBackground(new Color(128, 0, 128));
			fPlayerMoney.setEditable(false);
			fPlayerMoney.setFont(new Font("Broadway", Font.BOLD, 16));
			fPlayerMoney.setForeground(new Color(255, 155, 55));
			fPlayerMoney.setText("P 0000.00");
		}
		return fPlayerMoney;
	}

	private JTextField getPlayerNameField() {
		if (fPlayerName == null) {
			fPlayerName = new JTextField();
			fPlayerName.setBackground(new Color(128, 0, 128));
			fPlayerName.setEditable(false);
			fPlayerName.setFont(new Font("Ravie", Font.BOLD, 18));
			fPlayerName.setForeground(new Color(255, 255, 66));
			fPlayerName.setText("Player");
		}
		return fPlayerName;
	}

	private JButton getPlayButton() {
		if (bPlay == null) {
			bPlay = new JButton();
			bPlay.setText("CLICK TO PLAY");
			bPlay.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					bRollDice.setEnabled(true);
					bPlay.setVisible(false);
					fPlayerName.setText(playerOrder[x].getPlayerName());
					fPlayerMoney.setText("$ " + playerOrder[x].getStartMoney());
					
					for(int y = 0; y <= numberOfPlayers; y++){
						if(playerOrder[y].getToken().getAssignedToken() == 1){
							lBapor.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 2){
							lAzkal.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 3){
							lIron.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 4){
							lShoe.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 5){
							lCar.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 6){
							lThimble.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 7){
							lHat.setVisible(true);
						}
						if(playerOrder[y].getToken().getAssignedToken() == 8){
							lWheelBarrow.setVisible(true);
							
						}
						//updateTokenUsed();
					}
				}
			});
		}
		return bPlay;
	}

	private JPanel getTitleDeedsPanel() {
		if (pTitleDeeds == null) {
			pTitleDeeds = new JPanel();
			pTitleDeeds.setVisible(false);
			pTitleDeeds.setBackground(new Color(221, 149, 227));
			pTitleDeeds.setLayout(new GroupLayout());
		}
		return pTitleDeeds;
	}

	private JLabel getWheelBarrowLabel() {
		if (lWheelBarrow == null) {
			lWheelBarrow = new JLabel();
			lWheelBarrow.setVisible(false);
			lWheelBarrow.setBounds(500,500,50,50);
			lWheelBarrow.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/wheelbarrow_token.png")));
		}
		return lWheelBarrow;
	}

	private JLabel getHatLabel() {
		if (lHat == null) {
			lHat = new JLabel();
			lHat.setVisible(false);
			lHat.setBounds(500,500,50,50);
			lHat.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/hat_token.png")));
		}
		return lHat;
	}

	private JLabel getThimbleLabel() {
		if (lThimble == null) {
			lThimble = new JLabel();
			lThimble.setVisible(false);
			lThimble.setBounds(500,500,50,50);
			lThimble.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/thimble_token.png")));
		}
		return lThimble;
	}

	private JLabel getCarLabel() {
		if (lCar == null) {
			lCar = new JLabel();
			lCar.setVisible(false);
			lCar.setBounds(500,500,50,50);
			lCar.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/car_token.png")));
		}
		return lCar;
	}

	private JLabel getShoeLabel() {
		if (lShoe == null) {
			lShoe = new JLabel();
			lShoe.setVisible(false);
			lShoe.setBounds(500,500,50,50);
			lShoe.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/shoe_token.png")));
		}
		return lShoe;
	}

	private JLabel getIronLabel() {
		if (lIron == null) {
			lIron = new JLabel();
			lIron.setVisible(false);
			lIron.setBounds(500,500,50,50);
			lIron.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/iron_token.png")));
		}
		return lIron;
	}

	private JLabel getAzkalLabel() {
		if (lAzkal == null) {
			lAzkal = new JLabel();
			lAzkal.setVisible(false);
			lAzkal.setBounds(500,500,50,50);
			lAzkal.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/dog_token.png")));
		}
		return lAzkal;
	}

	private JLabel getBaporLabel() {
		if (lBapor == null) {
			lBapor = new JLabel();
			lBapor.setVisible(false);
			lBapor.setBounds(500, 500, 50, 50);
			lBapor.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/ship_token.png")));
		}
		return lBapor;
	}

	private JButton getRollDice() {
		if (bRollDice == null) {
			bRollDice = new JButton();
			bRollDice.setText("Roll Button");
			bRollDice.setEnabled(false);
			bRollDice.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dice.rollDiceResult1();
					dice.rollDiceResult2();
					bEndTurn.setEnabled(true);
					playerOrder[x].setTotalSteps((dice.getDice1stResult() + dice.getDice2ndResult())*3);
					System.out.println(playerOrder[x].getTotalSteps());
					isRolling = true;
					isRunning = true;
					startThread();
					
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
			pDice.add(getRollDice(), new Constraints(new Leading(54, 10, 10), new Leading(75, 12, 12)));
		}
		return pDice;
	}

	private JPanel getPlayerPanel() {
		if (pPlayer == null) {
			pPlayer = new JPanel();
			pPlayer.setBackground(new Color(128, 0, 128));
			pPlayer.setLayout(new GroupLayout());
			pPlayer.add(getTitleDeedsPanel(), new Constraints(new Leading(3, 199, 10, 10), new Leading(109, 388, 10, 10)));
			pPlayer.add(getPlayerNameField(), new Constraints(new Leading(10, 171, 10, 10), new Leading(32, 30, 10, 10)));
			pPlayer.add(getPlayerMoneyField(), new Constraints(new Leading(32, 149, 12, 12), new Leading(74, 12, 12)));
			pPlayer.add(getPlayButton(), new Constraints(new Leading(8, 188, 12, 12), new Leading(111, 146, 10, 10)));
			pPlayer.add(getEndTurnButton(), new Constraints(new Trailing(12, 15, 214), new Leading(468, 10, 10)));
		}
		return pPlayer;
	}

	private JPanel getBoardPanel() {
		if (pBoard == null) {
			pBoard = new JPanel();
			pBoard.setBackground(new Color(64, 0, 64));
			pBoard.setLayout(new GroupLayout());
			pBoard.add(getIronLabel(), new Constraints(new Leading(524, 12, 12), new Leading(514, 12, 12)));
			pBoard.add(getShoeLabel(), new Constraints(new Leading(539, 10, 10), new Leading(518, 12, 12)));
			pBoard.add(getThimbleLabel(), new Constraints(new Leading(532, 10, 10), new Leading(518, 10, 10)));
			pBoard.add(getHatLabel(), new Constraints(new Leading(534, 12, 12), new Leading(522, 10, 10)));
			pBoard.add(getWheelBarrowLabel(), new Constraints(new Leading(524, 12, 12), new Leading(527, 12, 12)));
			pBoard.add(getCarLabel(), new Constraints(new Leading(521, 10, 10), new Leading(514, 10, 10)));
			pBoard.add(getAzkalLabel(), new Constraints(new Leading(518, 12, 12), new Leading(515, 10, 10)));
			pBoard.add(getBaporLabel(), new Constraints(new Leading(534, 10, 10), new Leading(514, 10, 10)));
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
//METHods
/*	public void updatePlayerToken(){
		if(playerOrder[x].getToken().getAssignedLabel()==1)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token1_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==2)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token2_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==3)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token3_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==4)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token4_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==5)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token5_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==6)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token6_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==7)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token7_b.png")));
		if(orderedPlayer[counter].getAssignedLabel()==8)
             currentToken.setIcon(new ImageIcon(getClass().getResource("/images/token8_b.png")));
}
	}*/
//THIS IS WHERE THREAD STARTS
	public void startThread(){
		t = new Thread(this);
		t.start();
	}
	@SuppressWarnings("static-access")
	public void run(){
				if(playerOrder[x].getToken().getxLocation() > 27 && playerOrder[x].getToken().getyLocation() == 520){ // from go to just visiting
					try{
						for(int a = 0; a < 29; a++){
							playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-17);
							System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
							updateTokenPosition();
							t.sleep(250);
							System.out.println("okei! " + a);
						}
					}
					catch(InterruptedException e){}
				}
				
				else if(playerOrder[x].getToken().getxLocation() == 27 && playerOrder[x].getToken().getyLocation() > 10){ // from just visiting to free parking
					try{
						for(int a = 0; a < 30; a++){
							playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-17);
							System.out.println(playerOrder[x].getToken().getxLocation()+" "+ playerOrder[x].getToken().getyLocation());
							updateTokenPosition();
							t.sleep(250);
						}
					}catch(InterruptedException e){}
				}
				
				else if(playerOrder[x].getToken().getxLocation() < 500 && playerOrder[x].getToken().getyLocation() == 10){ //  from free parking to go to jail
					try{
						for(int a = 0; a < 29; a++){
							playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+17);
							System.out.println(playerOrder[x].getToken().getxLocation()+" "+ playerOrder[x].getToken().getyLocation());
							updateTokenPosition();
							t.sleep(250);
						}
					}catch(InterruptedException e){}
				}
				

				else if(playerOrder[x].getToken().getxLocation() == 520 && playerOrder[x].getToken().getyLocation() >= 10){ // from  go to jail to go
					try{
						for(int a = 0; a < 30; a++){
							playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+17);
							System.out.println(playerOrder[x].getToken().getxLocation()+" "+ playerOrder[x].getToken().getyLocation());
							updateTokenPosition();
							t.sleep(250);
						}
					}catch(InterruptedException e){}
					
				}
			
	}
	
	public void updateTokenPosition(){
				if(playerOrder[x].getToken().getAssignedToken() == 1){
					lBapor.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 2){
					lAzkal.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 3){
					lIron.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 4){
					lShoe.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 5){
					lCar.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 6){
					lThimble.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 7){
					lHat.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}if(playerOrder[x].getToken().getAssignedToken() == 8){
					lWheelBarrow.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
				}
	}

}