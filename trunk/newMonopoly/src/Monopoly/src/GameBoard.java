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
import org.dyno.visual.swing.layouts.Trailing;


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
      //  CommunityChest chest = new CommunityChest();
      //  Chance chance = new Chance();
        BoardBlock bblock = new BoardBlock();
        
        static int numberOfPlayers;
        public int randomChance, ccRandom;
        int x = 0;
        Thread t;
		private JPanel pClicktoPlay;
		private JLabel lClicktoPlay;
		private JLabel lPlayerPanelImage;
		private JLabel ldicebg;
		private JLabel lTitleDeedImageLabel;
		private JPanel pChoosePayOrTryDice;
		private JButton bPay50;
		private JButton bTryForDice;
		private JButton btdAyalaAve;
		private JPanel pChance;
		private JButton bShuffleChance;
		private JPanel pCchest;
		private JButton bShuffleCchest;
		//private JPanel pTryForDice;
		private JPanel pCchestPayOrChance;
		private JButton bTakeaChance;
		private JButton bPay10;
		private JPanel pBuyProperty;
		private JLabel lMessage;
		private JTextField lPropertyName;
		private JTextField lPrice;
		private JButton bBuy;
		private JButton bCancel;
		
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
			add(getPChance(), new Constraints(new Leading(0, 806, 835, 835), new Bilateral(0, -20, 295)));
			add(getPCchest(), new Constraints(new Leading(-3, 812, 835, 835), new Leading(0, 596, 623, 623)));
			add(getpChoosePayOrTryDice(), new Constraints(new Leading(-3, 813, 835, 835), new Leading(-2, 601, 10, 10)));
			add(getpCchestPayOrChance(), new Constraints(new Leading(126, 437, 835, 835), new Leading(63, 261, 10, 10)));
			add(getpBuyProperty(), new Constraints(new Leading(159, 386, 10, 10), new Leading(12, 194, 10, 10)));
			setSize(805, 595);
		}
        
        private JButton getbTakeAChance() {
        	if(bTakeaChance == null){
        		bTakeaChance = new JButton();
        		bTakeaChance.setText("Take A Chance");
        		
        	}
        	return bTakeaChance;
        }
        
        private JButton getbPay10() {
        	if(bPay10 == null){
        		bPay10 = new JButton();
        		bPay10.setText("Pay 10");
        		bPay10.addActionListener(new ActionListener() {
        			
        			public void actionPerformed(ActionEvent event){
        				
        				playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 10);
        				fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
        			}
        		});
        	}
			return bPay10;
        }
        
        private JPanel getpCchestPayOrChance() {
        	if(pCchestPayOrChance == null) {
        		pCchestPayOrChance = new JPanel();
        		pCchestPayOrChance.setBackground(new Color(255, 128, 0));
        		pCchestPayOrChance.setLayout(new GroupLayout());
        		pCchestPayOrChance.add(getbPay10(), new Constraints(new Leading(75, 10, 10), new Leading(202, 10, 10)));
        		pCchestPayOrChance.add(getbTakeAChance(), new Constraints(new Leading(324, 10, 10), new Leading(200, 10, 10)));
        		pCchestPayOrChance.setVisible(true);
        		
        	}
        	return pCchestPayOrChance;
        }

		private JButton getbCancel() {
			if (bCancel == null) {
				bCancel = new JButton();
				bCancel.setText("Cancel");
				bCancel.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent event){
						pBoard.setVisible(true);
						pDice.setVisible(true);
						pPlayer.setVisible(true);
						playerOrder[x].setPosition(playerOrder[x].getLastStep());
						
					}
				});
			}
			return bCancel;
		}

		private JButton getbBuy() {
			if (bBuy == null) {
				bBuy = new JButton();
				bBuy.setText("Buy Now!");
				bBuy.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent event){
						
					}
				});
			}
			return bBuy;
		}

		private JTextField getlPrice() {
			if (lPrice == null) {
				lPrice = new JTextField();
				lPrice.setText(null);
				lPrice.setEditable(false);
			}
			return lPrice;
		}

		private JTextField getlPropertyName() {
			if (lPropertyName == null) {
				lPropertyName = new JTextField();
				lPropertyName.setText(null);
				lPropertyName.setEditable(false);
			}
			return lPropertyName;
		}

		private JLabel getlMessage() {
			if (lMessage == null) {
				lMessage = new JLabel();
				lMessage.setText("Do you want to buy this property?");
			}
			return lMessage;
		}

		private JPanel getpBuyProperty() {
			if (pBuyProperty == null) {
				pBuyProperty = new JPanel();
				pBuyProperty.setLayout(new GroupLayout());
				pBuyProperty.setBackground(Color.magenta);
				pBuyProperty.add(getlMessage(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
				pBuyProperty.add(getlPropertyName(), new Constraints(new Leading(41, 10, 10), new Leading(46, 12, 12)));
				pBuyProperty.add(getlPrice(), new Constraints(new Leading(41, 12, 12), new Leading(80, 12, 12)));
				pBuyProperty.add(getbBuy(), new Constraints(new Leading(21, 12, 12), new Leading(149, 10, 10)));
				pBuyProperty.add(getbCancel(), new Constraints(new Trailing(12, 114, 114), new Trailing(12, 12, 12)));
				pBuyProperty.setVisible(false);
			}
			return pBuyProperty;
		}

		private JButton getShuffleChestButton() {
			if (bShuffleCchest == null) {
				bShuffleCchest = new JButton();
				bShuffleCchest.setText("Shuffle");
				bShuffleCchest.setEnabled(false);
				bShuffleCchest.addActionListener(new ActionListener() {
		
					public void actionPerformed(ActionEvent event) {
						CommunityChest Cchest = new CommunityChest();
						
						Cchest.shuffleCchest();
						
						switch (Cchest.getcChestRandom()){
						
							case 1:
									Cchest.bankError();
									playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
									fPlayerMoney.setText("P" + playerOrder[x].getStartMoney());
					                break;
					        case 2:
					        		Cchest.payHospital();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					                break;
					        case 3:
					        		Cchest.wonBeautyContest();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 10);
					        		fPlayerMoney.setText("P" + playerOrder[x].getStartMoney());
					                break;
					        case 4:
					    			Cchest.taxRefund();
					    			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 20);
					    			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					                break;
					        case 5:
					        		//pPayOrChance.setVisible(true);
					    			Cchest.payOrChance();
					    			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 10);
					    			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					    			//there should be a PANEL...with PAY 10 or TAKE CHANCE here...
					    			//System.out.println("Pay a P10 fine or take a CHANCE")
					                break;
					        case 6:
					        		Cchest.payInsurance();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					        		break;
					        case 7:
				        			Cchest.saleOfStock();
				        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
				        			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					    			break;
					        case 8:
				        			Cchest.recieveInterest();
				        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 25);
				        			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						    		break;
					        case 9:
				        			playerOrder[x].getToken().setLocation(525, 525);
				        			playerOrder[x].setPosition(40);
				        			passedGo();
				        			System.out.println("Pass Go.");
						    		break;
					        case 10:
				        		//	Cchest.goBackToOldKentRoad();
						    	//	System.out.println("Go back to Old Kent Road.");
						    		break;
					        case 11:
					        		playerOrder[x].setHasJailKey(true);
					        		System.out.println("HasJailKey: " + playerOrder[x].hasJailKey());
							    	break;
					        case 12:
				        			Cchest.yourBirthday();
						    	//	System.out.println("It is your birthday. Collect P10 from each player.");
						    		break;
					        case 13:
				        			Cchest.doctorsFee();
				        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
				        			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						    		break;
					        case 14:
				        			Cchest.annuityMatures();
				        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
				        			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						    		break;
					        case 15:
				        			goToJail();
						    		break;
					        case 16:
				        			Cchest.inheritMoney();
				        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
				        			fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						    		break;
															
								}
						pCchest.setVisible(false);
						pBoard.setVisible(true);
						pPlayer.setVisible(true);
						pDice.setVisible(true);
						
					}
				});
			}
			return bShuffleCchest;
		}

		

		private JButton getShuffleChanceButton() {
			if (bShuffleChance == null) {
				bShuffleChance = new JButton();
				bShuffleChance.setText("Shuffle");
				bShuffleChance.setEnabled(false);
				//bShuffleChance.setVisible(false);
				bShuffleChance.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent event) {
						Chance chance = new Chance();
						
						chance.shuffleChance();
						
						switch (chance.getChanceRandom()){
						
							case 1:
									chance.speedingFine();
					                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 15);
					                fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					                break;				                
					        case 2:
					        		chance.bankDividend();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					        		break;
					        case 3:
					        		//chance.advanceToTrinoma();
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					        		System.out.println("Advance to Trinoma. If you pass GO collect P200.");
					                break;
					        case 4:
					        		playerOrder[x].getToken().setLocation(525, 525);
					        		playerOrder[x].setPosition(40);
					        		passedGo();
					        		System.out.println("Pass Go.");
					                break;
					        case 5:
					        		chance.paySchoolFees();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 150);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
					        		break;
					        case 6:
					        		//chance.advanceToMoa();
					        		System.out.println("Advance to SM Mall of Asia.");
					        		break;
					        case 7:
					        		playerOrder[x].setHasJailKey(true);
					        		System.out.println("Get out of Jail Free Key.");
					        		System.out.println("HasJailKey: " + playerOrder[x].hasJailKey());
					        		break;
					        case 8:
					        		//chance.streetRepairs();
						    		System.out.println("Your are assessed forr street rpairs. P40 per house, P115 per hotel.");
						    		break;
					        case 9:
					        		//chance.generalRepairs();
						    		System.out.println("Make general repairs on all of your buildings. For each house pay P25. For each hotel pay P100.");
						    		break;
					        case 10:
					        		//chance.advanceToShopwise();
						    		System.out.println("Advance to Shopwise. If you pass GO collect P200.");
						    		break;
					        case 11:
					        		//chance.tripToBuendiaStation();
						    		System.out.println("Take a trip to Buendia Station. If you pass GO collect P200.");
						    		break;
					        case 12:
					        		chance.buildingMatures();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 150);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						    		break;
					        case 13:
					        		goToJail();
						    		System.out.println("GO TO JAIL.");
						    		break;
					        case 14:
					        		//chance.goBackThreeSteps();
					        		//playerOrder[x].getToken().setLocation();
						    		System.out.println("Go back three spaces.");
						    		break;
					        case 15:
					        		chance.drunkInCharge();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 200);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());						    		
						    		break;
					        case 16:
					        		chance.wonCrosswordCompetition();
					        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
					        		fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
						    		break;
					        }
						pChance.setVisible(false);
						pBoard.setVisible(true);
						pPlayer.setVisible(true);
						pDice.setVisible(true);
					}
				});
			}
			return bShuffleChance;
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
				bTryForDice.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						playerOrder[x].getToken().setLocation(23, 525);
						
						pChoosePayOrTryDice.setVisible(false);
						pPlayer.setVisible(true);
						pBoard.setVisible(true);
						pDice.setVisible(true);
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
         		        		  	
         		        		  	pChoosePayOrTryDice.setVisible(false);
         		        		  	pPlayer.setVisible(true);
         							pDice.setVisible(true);
         							pBoard.setVisible(true);
						//show label that says: paid for getting out of jail! w
						
					}
				});
			}
			return bPay50;
		}

		private JPanel getpChoosePayOrTryDice() {
			if (pChoosePayOrTryDice == null) {
				pChoosePayOrTryDice = new JPanel();
				pChoosePayOrTryDice.setVisible(false);
				pChoosePayOrTryDice.setBackground(new Color(64, 0, 128));
				pChoosePayOrTryDice.setForeground(new Color(64, 0, 128));
				pChoosePayOrTryDice.setLayout(new GroupLayout());
				pChoosePayOrTryDice.add(getbPay50(), new Constraints(new Leading(314, 166, 10, 10), new Leading(108, 114, 10, 10)));
				pChoosePayOrTryDice.add(getbTryForDice(), new Constraints(new Leading(314, 166, 12, 12), new Leading(281, 109, 10, 10)));
				//pChoosePayOrTryDice.add(getpTryForDice(), new Constraints(new Bilateral(12, 12, 0), new Bilateral(12, 12, 0)));
			}
			return pChoosePayOrTryDice;
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
						dice[0].rollDiceResult1();
						dice[1].rollDiceResult2();
						
						bEndTurn.setEnabled(true);
						
						playerOrder[x].setTotalSteps(dice[0].getDice1stResult() + dice[1].getDice2ndResult());
                        System.out.println("Total Steps: "+playerOrder[x].getTotalSteps());
                  
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
			}
			return pClicktoPlay;
		}

private JPanel getPChance() {
	if (pChance == null) {
		pChance = new JPanel();
		pChance.setBackground(new Color(0, 255, 128));
		pChance.setLayout(new GroupLayout());
		pChance.add(getShuffleChanceButton(), new Constraints(new Leading(321, 10, 10), new Leading(259, 10, 10)));
		pChance.setVisible(false);
	}
	return pChance;
}


		
private JPanel getPCchest() {
	if (pCchest == null) {
		pCchest = new JPanel();
		pCchest.setBackground(new Color(0, 128, 255));
		pCchest.setLayout(new GroupLayout());
		pCchest.add(getShuffleChestButton(), new Constraints(new Leading(322, 10, 10), new Leading(287, 10, 10)));
	}
	return pCchest;
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
       
        @SuppressWarnings({ "static-access", "deprecation" })
		public void run(){      
        	if(playerOrder[x].isJailed() == true && playerOrder[x].getTryForDice() < 3){
				playerOrder[x].getToken().setLocation(23, 525);
				t.stop();
				pChoosePayOrTryDice.setVisible(true);
				
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
        
        public void checkBoard(){
        	//Random random = new Random();
        	
        	switch(playerOrder[x].getLastStep()){
			
			case 1:
				buyOrNotEstate();
				break;
			case 2:
				//ccRandom = (random.nextInt(16) + 1);
				pCchest.setVisible(true);
				bShuffleCchest.setEnabled(true);
				break;
			case 3:
				buyOrNotEstate();
				break;
			case 4:
				playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 200);
				System.out.println("Paid 200 tax!");
				break;
			case 5:
				buyOrNotStation();
				break;
			case 6:
				buyOrNotEstate();
				break;
			case 7:
			//	randomChance = random.nextInt(16) + 1;
				pChance.setVisible(true);
				bShuffleChance.setEnabled(true);
				break;
			case 8:
				buyOrNotEstate();
				break;
			case 9:
				buyOrNotEstate();
				break;
			case 11:
				buyOrNotEstate();
				break;
			case 12:
				buyOrNotUtility();
				break;
			case 13:
				buyOrNotEstate();
				break;
			case 14:
				buyOrNotEstate();
				break;
			case 15:
				buyOrNotStation();
				break;
			case 16:
				buyOrNotEstate();
				break;
			case 17:
				//ccRandom = (random.nextInt(16) + 1);
				pCchest.setVisible(true);
				bShuffleCchest.setEnabled(true);
				break;
			case 18:
				buyOrNotEstate();
				break;
			case 19:
				buyOrNotEstate();
				break;
			case 21:
				buyOrNotEstate();
				break;
			case 22:
			//	randomChance = random.nextInt(16) + 1;
				pChance.setVisible(true);
				bShuffleChance.setEnabled(true);
				break;
			case 23:
				buyOrNotEstate();
				break;
			case 24:
				buyOrNotEstate();
				break;
			case 25:
				buyOrNotStation();
				break;
			case 26:
				buyOrNotEstate();
				break;
			case 27:
				buyOrNotEstate();
				break;
			case 28:
				buyOrNotUtility();
				break;
			case 29:
				buyOrNotEstate();
				break;
			case 30:
				goToJail();
				break;
			case 31:
				buyOrNotEstate();
				break;
			case 32:
				buyOrNotEstate();
				break;
			case 33:
				//ccRandom = (random.nextInt(16) + 1);
				pCchest.setVisible(true);
				bShuffleCchest.setEnabled(true);
				break;
			case 34:
				buyOrNotEstate();
				break;
			case 35:
				buyOrNotStation();
				break;
			case 36:
				//randomChance = random.nextInt(16) + 1;
				pChance.setVisible(true);
				bShuffleChance.setEnabled(true);
				break;
			case 37:
				buyOrNotEstate();
				break;
			case 38:
				playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
				System.out.println("Paid 100 tax!");
				break;
			case 39:
				buyOrNotEstate();
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
			 
			 /*if(playerOrder[x].isJailed() == true){			// if player is jailed
             	if(playerOrder[x].getTryForDice() < 3){		// while still in jail
             		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney());	//money does not change
             		playerOrder[x].getToken().setLocation(23, 525);
             		playerOrder[x].setPosition(10);
             		t.stop();
             	}
            }*/
        }
        
		
		@SuppressWarnings("deprecation")
		public void goToJail(){
					playerOrder[x].setPosition(10);
         		    playerOrder[x].getToken().setxLocation(23);
         		    playerOrder[x].getToken().setyLocation(525);
         		    playerOrder[x].setJailed(true);
         		    updateTokenPosition(); 
         		    t.stop();
         		  /*  pChoosePayOrTryDice.setVisible(true);
         		    pPlayer.setVisible(false);
        			pDice.setVisible(false);
        			pBoard.setVisible(false);*/
         		  
        }
					
         		        
		
        public void checkForDoubles(){
                if(dice[0].getDice1stResult() == dice[1].getDice2ndResult()){
                        playerOrder[x].setDoubleDice(playerOrder[x].getDoubleDice() + 1);
                        System.out.println("doubleDice of player"+ x + " = " + playerOrder[x].getDoubleDice());
                
	                if(playerOrder[x].isJailed() == true){
	                	playerOrder[x].setBailOutDice(playerOrder[x].getBailOutDice()+1);
	                	playerOrder[x].setTryForDice(playerOrder[x].getTryForDice()+1);
	                	bailOutOfJail();
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
        			//pTryForDice.setVisible(false);
        			//pBoard.setVisible(true);
        			//pPlayer.setVisible(true);
        			//pDice.setVisible(true);
        			System.out.println("Jailed: " +playerOrder[x].isJailed()+ playerOrder[x].getDoubleDice()+playerOrder[x].getBailOutDice()+playerOrder[x].getTryForDice());
        		}
        	}else if(playerOrder[x].getTryForDice() == 3){
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()-50);
        		playerOrder[x].setJailed(false);
        		playerOrder[x].setBailOutDice(0);
        		playerOrder[x].setDoubleDice(0);
        		playerOrder[x].setTryForDice(0);
        		System.out.println("Jailed: " +playerOrder[x].isJailed()+ playerOrder[x].getDoubleDice()+playerOrder[x].getBailOutDice()+playerOrder[x].getTryForDice());
        		
        	}  
        		
        }
        
        public void buyOrNotEstate(){
        	//if(!(bblock.getBlock()[playerOrder[x].getLastStep()].getEstate().isOwned())){
	        	pBuyProperty.setVisible(true);
	        	lPropertyName.setText(bblock.getBlock()[playerOrder[x].getLastStep()].getEstate().getName());
	        	lPrice.setText("Php " + bblock.getBlock()[playerOrder[x].getLastStep()].getEstate().getPrice());
	        	pPlayer.setVisible(false);
	        	pDice.setVisible(false);
	        	pBoard.setVisible(false);
	        	pChance.setVisible(false);
	        	pCchest.setVisible(false);
        	//}
        }
        
        public void buyOrNotStation(){
        	pBuyProperty.setVisible(true);
        	lPropertyName.setText(bblock.getBlock()[playerOrder[x].getLastStep()].getStation().getName());
        	lPrice.setText("Php " + bblock.getBlock()[playerOrder[x].getLastStep()].getStation().getPrice());
        	pPlayer.setVisible(false);
        	pDice.setVisible(false);
        	pBoard.setVisible(false);
        	pChance.setVisible(false);
        	pCchest.setVisible(false);
        }
        
        public void buyOrNotUtility(){
        	pBuyProperty.setVisible(true);
        	lPropertyName.setText(bblock.getBlock()[playerOrder[x].getLastStep()].getUtilities().getName());
        	lPrice.setText("Php " + bblock.getBlock()[playerOrder[x].getLastStep()].getUtilities().getPrice());
        	pPlayer.setVisible(false);
        	pDice.setVisible(false);
        	pBoard.setVisible(false);
        	pChance.setVisible(false);
        	pCchest.setVisible(false);
        }

}