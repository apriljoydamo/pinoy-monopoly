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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class GameBoard extends JFrame implements Runnable {

        private static final long serialVersionUID = 1L;
        private JPanel pBoard, pPlayer, pDice, pTitleDeeds;
        private JLabel lMonopoly, lDice2, lDice1;
        private JLabel lBapor, lAzkal, lIron, lShoe, lCar, lThimble, lHat,lWheelBarrow;
        private JButton bRollDice, bPlay, bEndTurn;
        private JTextField fPlayerName, fPlayerMoney;
        
        Dice dice[] = new Dice[2];
        Players playerOrder[] = new Players[8];
      //  Rules rules = new Rules();
        
        static int numberOfPlayers;
        int x = 0;
        Thread t;
		private JPanel pClicktoPlay;
		private JLabel lClicktoPlay;
		private JLabel lPlayerPanelImage;
		private JLabel ldicebg;
		private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
		public GameBoard() {
                dice[0] = new Dice();
                dice[1] = new Dice();
                initComponents();
        }

        private void initComponents() {
			setLayout(new GroupLayout());
			add(getBoardPanel(), new Constraints(new Leading(-3, 609, 10, 10), new Leading(0, 603, 12, 12)));
			add(getClickToPlayPanel(), new Constraints(new Bilateral(0, 0, 0), new Bilateral(0, 0, 0)));
			add(getPlayerPanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(-17, 443, 10, 10)));
			add(getDicePanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(420, 183, 10, 10)));
			setSize(805, 595);
		}

		private JLabel getDicebgLabel() {
			if (ldicebg == null) {
				ldicebg = new JLabel();
				ldicebg.setHorizontalAlignment(SwingConstants.TRAILING);
				ldicebg.setIcon(new ImageIcon(getClass().getResource("/Designs/rollDice_bg.png")));
			}
			return ldicebg;
		}

		private JLabel getPlayerPanelImageLabel() {
			if (lPlayerPanelImage == null) {
				lPlayerPanelImage = new JLabel();
				lPlayerPanelImage.setIcon(new ImageIcon(getClass().getResource("/Designs/PlayerPanel.jpg")));
			}
			return lPlayerPanelImage;
		}

		private JButton getEndTurnButton() {
			if (bEndTurn == null) {
				bEndTurn = new JButton();
				bEndTurn.setIcon(new ImageIcon(getClass().getResource("/Designs/endTurn_btn.png")));
				bEndTurn.setEnabled(false);
				bEndTurn.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {
						x++;
						if (x == numberOfPlayers) {
							x = 0;
						}
						fPlayerName.setText(playerOrder[x].getPlayerName());
						fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					}
				});
			}
			return bEndTurn;
		}

		private JButton getPlayButton() {
			if (bPlay == null) {
				bPlay = new JButton();
				bPlay.setIcon(new ImageIcon(getClass().getResource("/Designs/clcktoPlay_btn.png")));
				bPlay.setBorderPainted(false);
				bPlay.setOpaque(false);
				bPlay.setFocusPainted(false);
				bPlay.setBorder(null);
				bPlay.setContentAreaFilled(false);
				bPlay.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {
						bRollDice.setEnabled(true);
						bPlay.setVisible(false);
						pBoard.setVisible(true);
						pDice.setVisible(true);
						pPlayer.setVisible(true);
						pClicktoPlay.setVisible(false);
						fPlayerName.setText(playerOrder[x].getPlayerName());
						fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						for (int y = 0; y <= numberOfPlayers; y++) {
							if (playerOrder[y].getToken().getAssignedToken() == 1) {
								lBapor.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 2) {
								lAzkal.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 3) {
								lIron.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 4) {
								lShoe.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 5) {
								lCar.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 6) {
								lThimble.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 7) {
								lHat.setVisible(true);
							}
							if (playerOrder[y].getToken().getAssignedToken() == 8) {
								lWheelBarrow.setVisible(true);
							}
						}
					}
				});
			}
			return bPlay;
		}

		private JButton getRollDice() {
			if (bRollDice == null) {
				bRollDice = new JButton();
				bRollDice.setIcon(new ImageIcon(getClass().getResource("/Designs/rollDice_btn.png")));
				bRollDice.setBorderPainted(false);
				bRollDice.setOpaque(false);
				bRollDice.setContentAreaFilled(false);
				bRollDice.setEnabled(false);
				bRollDice.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {
						dice[0].rollDiceResult1();
						dice[1].rollDiceResult2();
						bEndTurn.setEnabled(true);
						playerOrder[x].setTotalSteps(dice[0].getDice1stResult() + dice[1].getDice2ndResult());
						System.out.println(playerOrder[x].getTotalSteps());
						checkForDoubles();
						startThread();
						switch (dice[0].getDice1stResult()) {
						case 1:
							lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceOne.png")));
							break;
						case 2:
							lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceTwo.png")));
							break;
						case 3:
							lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceThree.png")));
							break;
						case 4:
							lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceFour.png")));
							break;
						case 5:
							lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceFive.png")));
							break;
						case 6:
							lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceSix.png")));
							break;
						}
						switch (dice[1].getDice2ndResult()) {
						case 1:
							lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceOne.png")));
							break;
						case 2:
							lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceTwo.png")));
							break;
						case 3:
							lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceThree.png")));
							break;
						case 4:
							lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceFour.png")));
							break;
						case 5:
							lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceFive.png")));
							break;
						case 6:
							lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceSix.png")));
							break;
						}
					}
				});
			}
			return bRollDice;
		}

		/////////////////////////////TEXT FIELDS////////////////////////////////////
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

        
        
////////////////////////////////////LABELS////////////////////////////////
        
        private JLabel getClicktoPlayLabel() {
			if (lClicktoPlay == null) {
				lClicktoPlay = new JLabel();
				lClicktoPlay.setHorizontalAlignment(SwingConstants.TRAILING);
				lClicktoPlay.setIcon(new ImageIcon(getClass().getResource("/Designs/clicktoplay_bg.jpg")));
			}
			return lClicktoPlay;
		}

		private JLabel getWheelBarrowLabel() {
                if (lWheelBarrow == null) {
                        lWheelBarrow = new JLabel();
                        lWheelBarrow.setVisible(false);
                        lWheelBarrow.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/wheelbarrow_token.png")));
                }
                return lWheelBarrow;
        }

        private JLabel getHatLabel() {
                if (lHat == null) {
                        lHat = new JLabel();
                        lHat.setVisible(false);
                        lHat.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/hat_token.png")));
                }
                return lHat;
        }

        private JLabel getThimbleLabel() {
                if (lThimble == null) {
                        lThimble = new JLabel();
                        lThimble.setVisible(false);
                        lThimble.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/thimble_token.png")));
                }
                return lThimble;
        }

        private JLabel getCarLabel() {
                if (lCar == null) {
                        lCar = new JLabel();
                        lCar.setVisible(false);
                        lCar.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/car_token.png")));
                }
                return lCar;
        }

        private JLabel getShoeLabel() {
                if (lShoe == null) {
                        lShoe = new JLabel();
                        lShoe.setVisible(false);
                        lShoe.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/shoe_token.png")));
                }
                return lShoe;
        }

        private JLabel getIronLabel() {
                if (lIron == null) {
                        lIron = new JLabel();
                        lIron.setVisible(false);
                        lIron.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/iron_token.png")));
                }
                return lIron;
        }

        private JLabel getAzkalLabel() {
                if (lAzkal == null) {
                        lAzkal = new JLabel();
                        lAzkal.setVisible(false);
                        lAzkal.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/dog_token.png")));
                }
                return lAzkal;
        }

        private JLabel getBaporLabel() {
                if (lBapor == null) {
                        lBapor = new JLabel();
                        lBapor.setVisible(false);
                        lBapor.setIcon(new ImageIcon(getClass().getResource("/latest_tokens/ship_token.png")));
                }
                return lBapor;
        }

        private JLabel getDice1Label() {
                if (lDice1 == null) {
                        lDice1 = new JLabel();
                        lDice1.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceOne.png")));
                        
                }
                return lDice1;
        }

        private JLabel getDice2Label() {
                if (lDice2 == null) {
                        lDice2 = new JLabel();
                        lDice2.setIcon(new ImageIcon(getClass().getResource("/b&dice/diceOne.png")));
                }
                return lDice2;
        }

        private JLabel getMonopolyLabel() {
                if (lMonopoly == null) {
                        lMonopoly = new JLabel();
                        lMonopoly.setIcon(new ImageIcon(getClass().getResource("/b&dice/MonopolyBoardFinal.png")));
                }
                return lMonopoly;
        }

private JPanel getClickToPlayPanel() {
			if (pClicktoPlay == null) {
				pClicktoPlay = new JPanel();
				pClicktoPlay.setBackground(Color.black);
				pClicktoPlay.setLayout(new GroupLayout());
				pClicktoPlay.add(getPlayButton(), new Constraints(new Leading(292, 233, 12, 12), new Leading(282, 227, 10, 10)));
				pClicktoPlay.add(getClicktoPlayLabel(), new Constraints(new Leading(0, 12, 12), new Leading(0, 12, 12)));
				pClicktoPlay.setVisible(true);
			}
			return pClicktoPlay;
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

        private JPanel getDicePanel() {
	if (pDice == null) {
		pDice = new JPanel();
		pDice.setBackground(Color.white);
		pDice.setLayout(new GroupLayout());
		pDice.add(getDice2Label(), new Constraints(new Leading(118, 10, 10), new Leading(44, 10, 10)));
		pDice.add(getDice1Label(), new Constraints(new Leading(46, 10, 10), new Leading(44, 77, 77)));
		pDice.add(getRollDice(), new Constraints(new Leading(26, 160, 12, 12), new Leading(102, 12, 12)));
		pDice.add(getDicebgLabel(), new Constraints(new Leading(12, 12, 12), new Leading(8, 10, 10)));
		pDice.setVisible(false);
	}
	return pDice;
}

		private JPanel getPlayerPanel() {
			if (pPlayer == null) {
				pPlayer = new JPanel();
				pPlayer.setBackground(Color.magenta);
				pPlayer.setLayout(new GroupLayout());
				pPlayer.add(getTitleDeedsPanel(), new Constraints(new Leading(3, 199, 10, 10), new Leading(109, 388, 10, 10)));
				pPlayer.add(getPlayerMoneyField(), new Constraints(new Leading(37, 151, 10, 10), new Leading(128, 32, 10, 10)));
				pPlayer.add(getPlayerNameField(), new Constraints(new Leading(36, 152, 12, 12), new Leading(51, 33, 10, 10)));
				pPlayer.add(getEndTurnButton(), new Constraints(new Leading(21, 163, 12, 12), new Leading(365, 51, 10, 10)));
				pPlayer.add(getPlayerPanelImageLabel(), new Constraints(new Leading(0, 12, 12), new Leading(12, 12, 12)));
				pPlayer.setVisible(false);
			}
			return pPlayer;
		}

		private JPanel getBoardPanel() {
                if (pBoard == null) {
                        pBoard = new JPanel();
                        pBoard.setBackground(new Color(64, 0, 64));
                        pBoard.setLayout(new GroupLayout());
                        pBoard.add(getBaporLabel(), new Constraints(new Leading(515, 10, 10), new Leading(527, 12, 12)));
                        pBoard.add(getAzkalLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 10, 10)));
                        pBoard.add(getIronLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                        pBoard.add(getShoeLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                        pBoard.add(getCarLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                        pBoard.add(getThimbleLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                        pBoard.add(getHatLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                        pBoard.add(getWheelBarrowLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                        pBoard.add(getMonopolyLabel(), new Constraints(new Leading(5, 10, 10), new Leading(2, 599, 10, 10)));
                        pBoard.setVisible(false);
                        }
                return pBoard;
        }

        @SuppressWarnings("unused")
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

//////////////////////////////////THIS IS WHERE THREAD STARTS/////////////////////////////////////
        public void startThread(){
                t = new Thread(this);
                t.start();
        }
        @SuppressWarnings("static-access")
        public void run(){      
                for(int a = 0; a < playerOrder[x].getTotalSteps(); a++){
                        
                		if(playerOrder[x].getPosition() <= 9){ // from go to just visiting
                                        try{
                                                        if(playerOrder[x].getPosition() == 0 || playerOrder[x].getPosition() == 9){
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("else " + a);
                                                        }
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                        }
                                        catch(InterruptedException e){}
                                }else if(playerOrder[x].getPosition() >= 10 && playerOrder[x].getPosition() < 20){ // from just visiting to free parking
                                        try{
                                                        if(playerOrder[x].getPosition() == 10 || playerOrder[x].getPosition() == 19){
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("else " + a);
                                                        }
                                                        playerOrder[x].setLastStep(playerOrder[x].getPosition()+playerOrder[x].getTotalSteps());
                                                        System.out.println(" Last Step: " +playerOrder[x].getLastStep());
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                        }catch(InterruptedException e){}
                                }else if(playerOrder[x].getPosition() >= 20 && playerOrder[x].getPosition() < 30){ //  from free parking to go to jail
                                        try{
                                                        if(playerOrder[x].getPosition() == 20 || playerOrder[x].getPosition() == 29){
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("else " + a);
                                                        }
                                                       playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                                        if(playerOrder[x].getPosition() == 30){
                                                        }
                                        }catch(InterruptedException e){}
                                }else if(playerOrder[x].getPosition() >= 30 && playerOrder[x].getPosition() < 40){ // from  go to jail to go
                                        try{
                                                        if(playerOrder[x].getPosition() == 30 || playerOrder[x].getPosition() == 39){
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(500);
                                                                //System.out.println("else " + a);
                                                        }
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                                        passedGo();
                                                        

                                        }catch(InterruptedException e){}
                                        
                                }
                		 ////////GO TO JAIL
    					if(playerOrder[x].getLastStep() == 30 || playerOrder[x].getDoubleDice() == 3){
    						playerOrder[x].setJailed(true);
    						System.out.println(playerOrder[x].isJailed());
    						while(playerOrder[x].getPosition() != 10){
    							if(playerOrder[x].getPosition() < 10){
    								playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation() - 50);
    								System.out.println("updatedPosition "+playerOrder[x].getPosition());
    								updateTokenPosition();
    								try {
										t.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
    							}else if(playerOrder[x].getPosition() > 10 && playerOrder[x].getPosition() < 20){
    								playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation() - 50);
    								System.out.println("updatedPosition "+playerOrder[x].getPosition());
									updateTokenPosition();
									try {
										t.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
    							}else if(playerOrder[x].getPosition() >= 20 && playerOrder[x].getPosition() < 30){
    								playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation() + 50);
    								System.out.println("updatedPosition "+playerOrder[x].getPosition());
									updateTokenPosition();
									try {
										t.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
    							}else if(playerOrder[x].getPosition() >= 30 && playerOrder[x].getPosition() < 40){
    								playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation() + 50);
    								System.out.println("updatedPosition "+playerOrder[x].getPosition());
									updateTokenPosition();
									try {
										t.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
    							}
    							playerOrder[x].setPosition(playerOrder[x].getPosition() + 1);
        						if(playerOrder[x].getPosition() == 40){
    								playerOrder[x].setPosition(0);
    							}
    						}
    					}
                }
        }

///////////////////////////////////////METHODS USED IN BOARD/////////////////////////////////////
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
        
        public void passedGo(){
                if(playerOrder[x].getPosition() == 40){
                        playerOrder[x].setPosition(0);
                        playerOrder[x].setLastStep(playerOrder[x].getLastStep()+playerOrder[x].getPosition());
                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
                        fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
                }
        }
        
        //@SuppressWarnings("static-access")
		public void goToJail(){
        
        }
                 /*	if(playerOrder[x].getPosition() == 30 || playerOrder[x].getDoubleDice() == 3 ){
         	        			playerOrder[x].setPosition(10);
         		        		playerOrder[x].getToken().setxLocation(23);
         		        		playerOrder[x].getToken().setyLocation(462);
                 				
         		        		if(playerOrder[x].getToken().getAssignedToken() == 1){
         		        			lBapor.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 2){
         		        			lAzkal.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 3){
         		        			lIron.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation() );
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 4){
         		        			lShoe.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation() );
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 5){
         		        			lCar.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 6){
         		        			lThimble.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 7){
         		        			lHat.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
         		        		}
         		        		if(playerOrder[x].getToken().getAssignedToken() == 8){
         		        			lWheelBarrow.setLocation(playerOrder[x].getToken().getxLocation(), playerOrder[x].getToken().getyLocation());
         		        		}
         		        	}
         		        
        }*/
        public void checkForDoubles(){
                if(dice[0].getDice1stResult() == dice[1].getDice2ndResult()){
                        playerOrder[x].setDoubleDice(playerOrder[x].getDoubleDice() + 1);
                        System.out.println("doubleDice of "+ x + " = " + playerOrder[x].getDoubleDice());
                }
                
        }
        
}