import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
        Random random = new Random();
        BoardBlock bblock = new BoardBlock();
        //Block block = new Block();
        static int numberOfPlayers;
        public int randomChance, ccRandom;
        int x = 0;
        Thread t;
		private JPanel pClicktoPlay;
		private JLabel lClicktoPlay;
		private JLabel lPlayerPanelImage;
		private JLabel ldicebg;
		private JLabel lTitleDeedImageLabel;
		private JButton bPay50;
		private JButton bTryForDice;
		private JButton btdAyalaAve;
		private JLabel lChanceImage;
		private JButton bBuy;
		boolean isEstate, isUtility, isStation;
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
        
		private JButton getbBuy() {
			if (bBuy == null) {
				bBuy = new JButton();
				bBuy.setText("bBuy");
				bBuy.setEnabled(false);
				bBuy.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {
						if (isEstate == true) {
							playerOrder[x].buyEstate(bblock.getBlock()[playerOrder[x].getPosition()].getEstate(), playerOrder, x);
							fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
							System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getName());
							System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getPrice());
							System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned());
							System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
						} 
						if (isUtility == true) {
							playerOrder[x].buyUtility(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities(), playerOrder, x);
							fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
							System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getName());
							System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getPrice());
							System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned());
							System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getOwnerName());
							
						}
						if (isStation == true) {
							playerOrder[x].buyStation(bblock.getBlock()[playerOrder[x].getPosition()].getStation(), playerOrder, x);
							fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
							System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getName());
							System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getPrice());
							System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned());
							System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getOwnerName());
							
						}
					}
				});
			}
			return bBuy;
		}

		private JLabel getlChanceImage() {
			if (lChanceImage == null) {
				lChanceImage = new JLabel();
				lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Advance to GO.png")));
				lChanceImage.setVisible(false);
			}
			return lChanceImage;
		}

		private JButton gettdAyalaAveButton() {
			if (btdAyalaAve == null) {
				btdAyalaAve = new JButton();
				btdAyalaAve.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_brown.png")));
				btdAyalaAve.setBorderPainted(false);
				btdAyalaAve.setOpaque(false);
				btdAyalaAve.setContentAreaFilled(false);
				btdAyalaAve.setFocusable(false);
			}
			return btdAyalaAve;
		}

		private JLabel getDicebgLabel() {
			if (ldicebg == null) {
				ldicebg = new JLabel();
				ldicebg.setHorizontalAlignment(SwingConstants.TRAILING);
				ldicebg.setIcon(new ImageIcon(getClass().getResource("/Designs/rollDice_bg.png")));
			}
			return ldicebg;
		}

		private JButton getbTryForDice() {
			if (bTryForDice == null) {
				bTryForDice = new JButton();
				bTryForDice.setText("Try for Dice");
				bTryForDice.setVisible(false);
				bTryForDice.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						playerOrder[x].getToken().setLocation(23, 525);
						
						bTryForDice.setVisible(false);
						bPay50.setVisible(false);
		     		    
					//	pChoosePayOrTryDice.setVisible(false);
					//	pBoard.setVisible(true);
					//	pPlayer.setVisible(true);
					//	pDice.setVisible(true);
						//you have chosen to try for dice... you have 3 try to roll for doubleDice...
					}
				});
				
			}
			return bTryForDice;
		}

		private JButton getbPay50() {
			if (bPay50 == null) {
				bPay50 = new JButton();
				bPay50.setText("Pay 50");
				bPay50.setVisible(false);
				bPay50.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						playerOrder[x].getToken().setLocation(23, 525);
		     		        
						playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()-50);
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
						System.out.println("Money: " +playerOrder[x].getStartMoney());
									
									playerOrder[x].setJailed(false);
         		        		  	playerOrder[x].setBailOutDice(0);
         		        		  	playerOrder[x].setDoubleDice(0);
         		        		  	playerOrder[x].setTryForDice(0);
         		        		  	
         		        bPay50.setVisible(false);
         		        bTryForDice.setVisible(false);
         		        		  	
         		        		//  	pChoosePayOrTryDice.setVisible(false);
         		        	//	  	pPlayer.setVisible(true);
         						//	pDice.setVisible(true);
         							//pBoard.setVisible(true);
						//show label that says: paid for getting out of jail! 
						
					}
				});
			}
			return bPay50;
		}

		private JLabel getTitleDeedImageLabel() {
			if (lTitleDeedImageLabel == null) {
				lTitleDeedImageLabel = new JLabel();
				lTitleDeedImageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				lTitleDeedImageLabel.setIcon(new ImageIcon(getClass().getResource("/Designs/TitleDeedsImage.png")));
			}
			return lTitleDeedImageLabel;
		}

		private JLabel getPlayerPanelImageLabel() {
			if (lPlayerPanelImage == null) {
				lPlayerPanelImage = new JLabel();
				lPlayerPanelImage.setIcon(new ImageIcon(getClass().getResource("/Designs/PlayerPanel.jpg")));
				//lPlayerPanelImage.setVisible(true);
			}
			return lPlayerPanelImage;
		}


		private JButton getEndTurnButton() {
			if (bEndTurn == null) {
				bEndTurn = new JButton();
				bEndTurn.setIcon(new ImageIcon(getClass().getResource("/Designs/endTurn_btn.png")));
				bEndTurn.setEnabled(false);
				bEndTurn.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {		//next player
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
		
					public void actionPerformed(ActionEvent event) {			//hides what is not needed and shows all tokens used by the players
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
				bRollDice.setFocusable(false);
				bRollDice.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {
						bBuy.setEnabled(false);
						lChanceImage.setVisible(false);
						dice[0].rollDiceResult1();
						dice[1].rollDiceResult2();
						
						bEndTurn.setEnabled(true);
						
						playerOrder[x].setTotalSteps(dice[0].getDice1stResult() + dice[1].getDice2ndResult());
                        System.out.println("Total Steps: "+playerOrder[x].getTotalSteps());
                  
                       
                        checkForDoubles();
                        if(playerOrder[x].isJailed() == true){
    	                	playerOrder[x].setTryForDice(playerOrder[x].getTryForDice()+1);
    	                	System.out.println("TryForDice: "+playerOrder[x].getTryForDice());
    	                	bailOutOfJail();
    	                }
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
				fPlayerMoney.setBackground(new Color(255, 193, 193));
				fPlayerMoney.setEditable(false);
				fPlayerMoney.setFont(new Font("Century Gothic", Font.BOLD, 16));
				fPlayerMoney.setForeground(Color.black);
				fPlayerMoney.setText("P 0000.00");
			}
			return fPlayerMoney;
		}

		private JTextField getPlayerNameField() {
			if (fPlayerName == null) {
				fPlayerName = new JTextField();
				fPlayerName.setBackground(new Color(255, 193, 193));
				fPlayerName.setEditable(false);
				fPlayerName.setFont(new Font("Century Gothic", Font.BOLD, 18));
				fPlayerName.setForeground(Color.black);
				fPlayerName.setText("Player");
				fPlayerName.setFocusable(false);
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
				lMonopoly.setHorizontalAlignment(SwingConstants.TRAILING);
				lMonopoly.setIcon(new ImageIcon(getClass().getResource("/b&dice/MonopolyBoardFinal.png")));
			}
			return lMonopoly;
		}

//////////////////////////////////////////PANELS //////////////////////////////////////////

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
		pTitleDeeds.setBackground(Color.white);
		pTitleDeeds.setLayout(new GroupLayout());
		pTitleDeeds.add(gettdAyalaAveButton(), new Constraints(new Leading(12, 17, 10, 10), new Leading(46, 17, 10, 10)));
		pTitleDeeds.add(getTitleDeedImageLabel(), new Constraints(new Leading(0, 12, 12), new Leading(0, 185, 12, 12)));
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
		pPlayer.add(getPlayerMoneyField(), new Constraints(new Leading(37, 151, 10, 10), new Leading(128, 32, 10, 10)));
		pPlayer.add(getPlayerNameField(), new Constraints(new Leading(36, 152, 12, 12), new Leading(51, 33, 10, 10)));
		pPlayer.add(getTitleDeedsPanel(), new Constraints(new Leading(0, 199, 12, 12), new Leading(172, 185, 12, 12)));
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
		pBoard.add(getbPay50(), new Constraints(new Leading(314, 166, 10, 10), new Leading(108, 114, 10, 10)));
		pBoard.add(getbTryForDice(), new Constraints(new Leading(314, 166, 12, 12), new Leading(281, 109, 10, 10)));
		pBoard.add(getlChanceImage(), new Constraints(new Leading(104, 12, 12), new Leading(184, 12, 12)));
		pBoard.add(getbBuy(), new Constraints(new Leading(243, 115, 12, 12), new Leading(263, 73, 12, 12)));
		pBoard.add(getBaporLabel(), new Constraints(new Leading(515, 10, 10), new Leading(527, 12, 12)));
		pBoard.add(getAzkalLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 10, 10)));
		pBoard.add(getIronLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
		pBoard.add(getShoeLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
		pBoard.add(getCarLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
		pBoard.add(getThimbleLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
		pBoard.add(getHatLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
		pBoard.add(getWheelBarrowLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
		pBoard.add(getMonopolyLabel(), new Constraints(new Leading(0, 12, 12), new Leading(0, 599, 12, 12)));
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
       
        @SuppressWarnings({ "static-access", "deprecation"})
		public void run(){      
        	if(playerOrder[x].isJailed() == true && playerOrder[x].getTryForDice()<3){
        		playerOrder[x].getToken().setLocation(23, 525);
     		    t.stop();
     		}
        		for(int a = 0; a < playerOrder[x].getTotalSteps(); a++){
                        
                		if(playerOrder[x].getPosition() <= 9){ // from go to just visiting
                                        try{
                                                        if(playerOrder[x].getPosition() == 0 || playerOrder[x].getPosition() == 9){
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                        }else{
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
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
                                                                t.sleep(250);
                                                        }else{
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                        }
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                        }catch(InterruptedException e){}
                                        
                                }else if(playerOrder[x].getPosition() >= 20 && playerOrder[x].getPosition() < 30){ //  from free parking to go to jail
                                        try{
                                                        if(playerOrder[x].getPosition() == 20 || playerOrder[x].getPosition() == 29){
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                        }else{
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                        }
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                        }catch(InterruptedException e){}
                                        
                                }else if(playerOrder[x].getPosition() >= 30 && playerOrder[x].getPosition() < 40){ // from  go to jail to go
                                        try{
                                                        if(playerOrder[x].getPosition() == 30 || playerOrder[x].getPosition() == 39){
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+63);
                                                                System.out.println(playerOrder[x].getToken().getxLocation() + " " + playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                        }else{
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                        }
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                                        
                                                        

                                        }catch(InterruptedException e){}
                                        
                                }
                				
                				passedGo();
    							if(playerOrder[x].getDoubleDice() == 3){
                					goToJail();
                				}
                				
                }
        		playerOrder[x].setLastStep(playerOrder[x].getPosition());
                System.out.println("Last Step: " +playerOrder[x].getLastStep());
                checkBoard();
        }

        
///////////////////////////////////////METHODS USED IN BOARD/////////////////////////////////////
        
        public void chanceRandom(){
        	Chance chance = new Chance();
			chance.shuffleChance();
			lChanceImage.setVisible(true);
			
			switch (chance.getChanceRandom()){
			
				case 1:
						//chance.speedingFine();
						lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Speeding fine P15.png")));
						playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 15);
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
		                break;				                
		        case 2:
		        		//chance.bankDividend();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Bank pays you dividend of P50.png")));
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
		        		break;
		        case 3:
		        		//chance.advanceToTrinoma();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Advance to Trinoma..png")));
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
		        		System.out.println("Advance to Trinoma. If you pass GO collect P200.");
		                break;
		        case 4:
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Advance to GO.png")));
			        	playerOrder[x].getToken().setLocation(525, 525);
		        		playerOrder[x].setPosition(40);
		        		passedGo();
		        		System.out.println("Pass Go.");
	        			break;
		        case 5:
		        		//chance.paySchoolFees();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Pay school fees of P150.png")));
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 150);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
		        		break;
		        case 6:
		        		//chance.advanceToMoa();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Advance to SM Mall of Asia.png")));
		        		playerOrder[x].getToken().setLocation(525, 462);
		        		playerOrder[x].setPosition(39);
		        		System.out.println("Advance to SM Mall of Asia.");
		        		break;
		        case 7:
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Get out of Jail Free Key.png")));
			        	playerOrder[x].setHasJailKey(true);
		        		//System.out.println("Get out of Jail Free Key.");
		        		System.out.println("HasJailKey: "+playerOrder[x].hasJailKey());
		        		
			    		break;
		        case 8:
		        		//chance.streetRepairs();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/street repairs.png")));
			    		System.out.println("Your are assessed for street rpairs. P40 per house, P115 per hotel.");
			    		break;
		        case 9:
		        		//chance.generalRepairs();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/General repairs for buildings.png")));
			    		System.out.println("Make general repairs on all of your buildings. For each house pay P25. For each hotel pay P100.");
			    		break;
		        case 10:
		        		//chance.advanceToShopwise();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Advance to Shopwise.png")));
			    		System.out.println("Advance to Shopwise. If you pass GO collect P200.");
			    		break;
		        case 11:
		        		//chance.tripToBuendiaStation();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/take_a_trip_to_beundia_station.png")));
			    		System.out.println("Take a trip to Buendia Station. If you pass GO collect P200.");
			    		break;
		        case 12:
		        		//chance.buildingMatures();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/building_laon_matures.png")));
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 150);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
			    		break;
		        case 13:
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/go_to_jail.png")));
		        		goToJail();
			    		System.out.println("GO TO JAIL.");
			    		break;
		        case 14:
		        		//chance.goBackThreeSteps();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Go back three spaces.png")));
		        		//playerOrder[x].getToken().setLocation();
		        		System.out.println("Go back three spaces.");
			    		break;
		        case 15:
		        		//chance.drunkInCharge();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/Drunk in Charge.png")));
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 20);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
			    		break;
		        case 16:
		        		//chance.wonCrosswordCompetition();
		        		lChanceImage.setIcon(new ImageIcon(getClass().getResource("/chances/crossword_competition.png")));
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
			    		break;
		        }
        	
        }
        
        
        
        public void cChestRandom(){
        	
        	CommunityChest Cchest = new CommunityChest();
			Cchest.shuffleCchest();
			
			switch (Cchest.getcChestRandom()){
			
				case 1:
						//Cchest.bankError();
						playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
						break;
		        case 2:
		        		//Cchest.payHospital();
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
				        break;
		        case 3:
		        		//Cchest.wonBeautyContest();
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 10);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
				        break;
		        case 4:
		    			//Cchest.taxRefund();
		    			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 20);
		    			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
				        break;
		        case 5:
		    			//pPayOrChance.setVisible(true);
		        		//Cchest.payOrChance();
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 10);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
		    			//there should be a PANEL...with a PAY 10 or TAKE CHANCE here...
		                break;
		        case 6:
		        		//Cchest.payInsurance();
		        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
		        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
		        		break;
		        case 7:
	        			//Cchest.saleOfStock();
	        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
	        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
	        			break;
		        case 8:
	        			//Cchest.recieveInterest();
	        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 25);
	        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
	        			break;
		        case 9:
		        		playerOrder[x].getToken().setLocation(525, 525);
		        		playerOrder[x].setPosition(40);
		        		passedGo();
		        		System.out.println("Pass Go.");
	        			break;
		        case 10:
	        			//Cchest.goBackToOldKentRoad();
			    		System.out.println("Go back to Old Kent Road.");
			    		break;
		        case 11:
		        		playerOrder[x].setHasJailKey(true);
		        		System.out.println("HasJailKey: "+playerOrder[x].hasJailKey());
		        		break;
		        case 12:
	        			//Cchest.yourBirthday();
			    	//	System.out.println("It is your birthday. Collect P10 from each player.");
			    		break;
		        case 13:
	        			//Cchest.doctorsFee();
	        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
	        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
	        			break;
		        case 14:
	        			//Cchest.annuityMatures();
	        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
	        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
	        			break;
		        case 15:
	        			goToJail();
	        			break;
		        case 16:
	        			//Cchest.inheritMoney();
	        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
	        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
	        			break;
												
					}
        	
        }
        
        public void checkBoard(){
        	//Random random = new Random();
        	
        	switch(playerOrder[x].getLastStep()){
			
			case 1:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				//lAyala.setIcon
				break;
			case 2:
				//ccRandom = (random.nextInt(16) + 1);
				cChestRandom();
				break;
			case 3:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 4:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 200);
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
					System.out.println("Paid 200 tax!");
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 5:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isStation = true;
					isEstate = false;
					isUtility = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 6:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 7:
				//randomChance = random.nextInt(16) + 1;
				chanceRandom();
				break;
			case 8:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 9:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 11:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 12:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isUtility = true;
					isEstate = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 13:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 14:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 15:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isStation = true;
					isEstate = false;
					isUtility = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 16:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 17:
				//ccRandom = (random.nextInt(16) + 1);
				cChestRandom();
				break;
			case 18:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 19:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 21:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 22:
				//randomChance = random.nextInt(16) + 1;
				chanceRandom();
				break;
			case 23:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 24:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 25:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isStation = true;
					isEstate = false;
					isUtility = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 26:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 27:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 28:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isUtility = true;
					isEstate = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 29:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 30:
				goToJail();
				break;
			case 31:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 32:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 33:
				//ccRandom = (random.nextInt(16) + 1);
				cChestRandom();
				break;
			case 34:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 35:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isStation = true;
					isEstate = false;
					isUtility = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 36:
				//randomChance = random.nextInt(16) + 1;
				chanceRandom();
				break;
			case 37:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 38:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
					System.out.println("Paid 100 tax!");
				}else{
					playerOrder[x].payRent();
				}
				break;
			case 39:
				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
					isEstate = true;
					isUtility = false;
					isStation = false;
					bBuy.setEnabled(true);
				}else{
					playerOrder[x].payRent();
				}
				break;

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
        
        
		//@SuppressWarnings("deprecation")
		public void passedGo(){
			 if(playerOrder[x].getPosition() == 40){		//position goes back to 0 if token passed GO
             			playerOrder[x].setPosition(0);   
			            playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
                        fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
             }	
        }
        
		
		@SuppressWarnings("deprecation")
		public void goToJail(){
         		    playerOrder[x].setPosition(10);
         		    playerOrder[x].getToken().setxLocation(23);
         		    playerOrder[x].getToken().setyLocation(525);
         		    playerOrder[x].setJailed(true);
         		    System.out.println("Jailed: "+playerOrder[x].isJailed());
         		    updateTokenPosition();
       				bPay50.setVisible(true);
       				bTryForDice.setVisible(true);
         		   // pBoard.setVisible(false);
         		   // pPlayer.setVisible(false);
         		   // pDice.setVisible(false);
         		    t.stop();
         		   
       }
					
         		        
		
        public void checkForDoubles(){
                if(dice[0].getDice1stResult() == dice[1].getDice2ndResult()){
                        playerOrder[x].setDoubleDice(playerOrder[x].getDoubleDice() + 1);
                        System.out.println("doubleDice of player"+ x + " = " + playerOrder[x].getDoubleDice());
                
	                if(playerOrder[x].isJailed() == true){
	                	playerOrder[x].setBailOutDice(playerOrder[x].getBailOutDice()+1);
	                	System.out.println("BailOutDice: "+playerOrder[x].getBailOutDice());
	                }
	           }
        }
         
        public void bailOutOfJail(){
        	if(playerOrder[x].getTryForDice() < 3){
        	    if(playerOrder[x].getBailOutDice() == 1){
        			playerOrder[x].setJailed(false);
        			playerOrder[x].setBailOutDice(0);
        			playerOrder[x].setDoubleDice(0);
        			playerOrder[x].setTryForDice(0);
        			System.out.println("Jailed: " +playerOrder[x].isJailed()+ playerOrder[x].getDoubleDice()+playerOrder[x].getBailOutDice()+playerOrder[x].getTryForDice());
        		}
        	}else if(playerOrder[x].getTryForDice() == 3 && playerOrder[x].getBailOutDice() == 0){
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()-50);
        		System.out.println("Money: "+playerOrder[x].getStartMoney());
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		playerOrder[x].setJailed(false);
        		playerOrder[x].setBailOutDice(0);
        		playerOrder[x].setDoubleDice(0);
        		playerOrder[x].setTryForDice(0);
        		System.out.println("Jailed: " +playerOrder[x].isJailed()+ playerOrder[x].getDoubleDice()+playerOrder[x].getBailOutDice()+playerOrder[x].getTryForDice());
        		                                      
        	}  
        }
}