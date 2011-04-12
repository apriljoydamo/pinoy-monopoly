

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
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
        ImageIcon icon;
        
        Dice dice[] = new Dice[2];
        Players playerOrder[] = new Players[8];
        Random random = new Random();
        Chance chance = new Chance();
        CommunityChest Cchest = new CommunityChest();
        BoardBlock bblock = new BoardBlock();
        static int numberOfPlayers;
        public int randomChance, ccRandom;
        int x = 0, rent, intTD, b=0, c=0;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        Thread t;
                private JPanel pClicktoPlay;
                private JLabel lClicktoPlay;
                private JLabel lPlayerPanelImage;
                private JLabel ldicebg;
                private JLabel lTitleDeedImageLabel;
                private JButton btdAyalaAve;
                boolean isEstate, isUtility, isStation;
                private JButton bTDMakatiAve;
                                private JButton bTDPuregold;
                                private JButton bTDRizalPark;
                                private JButton bTDdlaRsaSt;
                                private JButton bTDShopwise;
                                private JButton bTDSlex;
                                private JButton bTDWalterMart;
                                private JButton bTDIntramuros;
                                private JButton bTDC5;
                                private JButton bTDChinaTown;
                                private JButton bTDNlex;
                                private JButton bTDNationalbs;
                                private JButton bTDTrinoma;
                                private JButton bTDEdsa;
                                private JButton bTDMagsaysayBrdge;
                                private JButton bTDStarCity;
                                private JButton bDTLandmark;
                                private JButton bTDGlorietta;
                                private JButton bDTGreenbelt;
                                private JButton bTDBoracay;
                                private JButton bTDMoa;
                                private JButton bTDMeralco;
								private JButton bTDMaynilad;
								private JButton bTDAyalaStation;
								private JButton bTDBuendiaStation;
								private JButton bDTNorthStation;
								private JButton bDTTaftStation;

		
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
									setSize(820, 595);
								}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////THIS IS FOR TITLEDEED//////////////////////////////////////////       
////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        private JButton getBDTTaftStation() {
			if (bDTTaftStation == null) {
				bDTTaftStation = new JButton();
				bDTTaftStation.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_train.png")));
				bDTTaftStation.setBorderPainted(false);
				bDTTaftStation.setOpaque(false);
				bDTTaftStation.setContentAreaFilled(false);
				bDTTaftStation.addActionListener(new ActionListener() {
                  	
                    public void actionPerformed(ActionEvent event) {
                    		intTD = 25;
                            runTitleDeedImage(x, intTD);
                    }
            });
			}
			return bDTTaftStation;
		}

		private JButton getBDTNorthStation() {
			if (bDTNorthStation == null) {
				bDTNorthStation = new JButton();
				bDTNorthStation.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_train.png")));
				bDTNorthStation.setBorderPainted(false);
				bDTNorthStation.setOpaque(false);
				bDTNorthStation.setContentAreaFilled(false);
				bDTNorthStation.addActionListener(new ActionListener() {
                  	
                    public void actionPerformed(ActionEvent event) {
                    		intTD = 35;
                            runTitleDeedImage(x, intTD);
                    }
            });
			}
			return bDTNorthStation;
		}

		private JButton getBTDBuendiaStation() {
			if (bTDBuendiaStation == null) {
				bTDBuendiaStation = new JButton();
				bTDBuendiaStation.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_train.png")));
				bTDBuendiaStation.setBorderPainted(false);
				bTDBuendiaStation.setOpaque(false);
				bTDBuendiaStation.setContentAreaFilled(false);
				bTDBuendiaStation.addActionListener(new ActionListener() {
                  	
                    public void actionPerformed(ActionEvent event) {
                    		intTD = 15;
                            runTitleDeedImage(x, intTD);
                    }
            });
			}
			return bTDBuendiaStation;
		}

				private JButton getBTDAyalaStation() {
			if (bTDAyalaStation == null) {
				bTDAyalaStation = new JButton();
				bTDAyalaStation.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_train.png")));
				bTDAyalaStation.setBorderPainted(false);
				bTDAyalaStation.setOpaque(false);
				bTDAyalaStation.setContentAreaFilled(false);
				bTDAyalaStation.addActionListener(new ActionListener() {
                  	
                    public void actionPerformed(ActionEvent event) {
                    		intTD = 5;
                            runTitleDeedImage(x, intTD);
                    }
            });
			}
			return bTDAyalaStation;
		}

				private JButton getBTDMaynilad() {
			if (bTDMaynilad == null) {
				bTDMaynilad = new JButton();
				bTDMaynilad.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_maynilad.png")));
				bTDMaynilad.setBorderPainted(false);
				bTDMaynilad.setOpaque(false);
				bTDMaynilad.setContentAreaFilled(false);
				bTDMaynilad.addActionListener(new ActionListener() {
                  	
                    public void actionPerformed(ActionEvent event) {
                    		intTD = 28;
                            runTitleDeedImage(x, intTD);
                    }
            });
			}
			return bTDMaynilad;
		}

				private JButton getBTDMeralco() {
			if (bTDMeralco == null) {
				bTDMeralco = new JButton();
				bTDMeralco.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_meralco.png")));
				bTDMeralco.setBorderPainted(false);
				bTDMeralco.setOpaque(false);
				bTDMeralco.setContentAreaFilled(false);
				bTDMeralco.addActionListener(new ActionListener() {
                  	
                      public void actionPerformed(ActionEvent event) {
                      		intTD = 12;
                              runTitleDeedImage(x, intTD);
                      }
              });
			}
			return bTDMeralco;
		}

				private JButton getBTDMoa() {
                        if (bTDMoa == null) {
                                bTDMoa = new JButton();
                                bTDMoa.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_darkblue.png")));
                                bTDMoa.setBorderPainted(false);
                                bTDMoa.setOpaque(false);
                                bTDMoa.setContentAreaFilled(false);
                                bTDMoa.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 39;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDMoa;
                }

                                private JButton getBTDBoracay() {
                        if (bTDBoracay == null) {
                                bTDBoracay = new JButton();
                                bTDBoracay.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_darkblue.png")));
                                bTDBoracay.setBorderPainted(false);
                                bTDBoracay.setOpaque(false);
                                bTDBoracay.setContentAreaFilled(false);
                                bTDBoracay.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 37;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDBoracay;
                }

                                private JButton getBDTGreenbelt() {
                        if (bDTGreenbelt == null) {
                                bDTGreenbelt = new JButton();
                                bDTGreenbelt.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_green.png")));
                                bDTGreenbelt.setBorderPainted(false);
                                bDTGreenbelt.setOpaque(false);
                                bDTGreenbelt.setContentAreaFilled(false);
                                bDTGreenbelt.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 34;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bDTGreenbelt;
                }

                                private JButton getBTDGlorietta() {
                        if (bTDGlorietta == null) {
                                bTDGlorietta = new JButton();
                                bTDGlorietta.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_green.png")));
                                bTDGlorietta.setBorderPainted(false);
                                bTDGlorietta.setOpaque(false);
                                bTDGlorietta.setContentAreaFilled(false);
                                bTDGlorietta.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 32;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDGlorietta;
                }

                                private JButton getBDTLandmark() {
                        if (bDTLandmark == null) {
                                bDTLandmark = new JButton();
                                bDTLandmark.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_green.png")));
                                bDTLandmark.setBorderPainted(false);
                                bDTLandmark.setOpaque(false);
                                bDTLandmark.setContentAreaFilled(false);
                                bDTLandmark.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 31;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bDTLandmark;
                }

                                private JButton getBTDStarCity() {
                        if (bTDStarCity == null) {
                                bTDStarCity = new JButton();
                                bTDStarCity.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_yellow.png")));
                                bTDStarCity.setBorderPainted(false);
                                bTDStarCity.setOpaque(false);
                                bTDStarCity.setContentAreaFilled(false);
                                bTDStarCity.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 29;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDStarCity;
                }

                                private JButton getBTDMagsaysayBrdge() {
                        if (bTDMagsaysayBrdge == null) {
                                bTDMagsaysayBrdge = new JButton();
                                bTDMagsaysayBrdge.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_yellow.png")));
                                bTDMagsaysayBrdge.setBorderPainted(false);
                                bTDMagsaysayBrdge.setOpaque(false);
                                bTDMagsaysayBrdge.setContentAreaFilled(false);
                                bTDMagsaysayBrdge.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 27;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDMagsaysayBrdge;
                }

                                private JButton getBTDEdsa() {
                        if (bTDEdsa == null) {
                                bTDEdsa = new JButton();
                                bTDEdsa.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_yellow.png")));
                                bTDEdsa.setBorderPainted(false);
                                bTDEdsa.setOpaque(false);
                                bTDEdsa.setContentAreaFilled(false);
                                bTDEdsa.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 26;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDEdsa;
                }

                                private JButton getBTDTrinoma() {
                        if (bTDTrinoma == null) {
                                bTDTrinoma = new JButton();
                                bTDTrinoma.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_red.png")));
                                bTDTrinoma.setBorderPainted(false);
                                bTDTrinoma.setOpaque(false);
                                bTDTrinoma.setContentAreaFilled(false);
                                bTDTrinoma.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 24;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDTrinoma;
                }

                                private JButton getBTDNationalbs() {
                        if (bTDNationalbs == null) {
                                bTDNationalbs = new JButton();
                                bTDNationalbs.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_red.png")));
                                bTDNationalbs.setBorderPainted(false);
                                bTDNationalbs.setOpaque(false);
                                bTDNationalbs.setContentAreaFilled(false);
                                bTDNationalbs.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 23;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDNationalbs;
                }

                                private JButton getBTDNlex() {
                        if (bTDNlex == null) {
                                bTDNlex = new JButton();
                                bTDNlex.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_red.png")));
                                bTDNlex.setBorderPainted(false);
                                bTDNlex.setOpaque(false);
                                bTDNlex.setContentAreaFilled(false);
                                bTDNlex.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 21;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDNlex;
                }

                                private JButton getBTDChinaTown() {
                        if (bTDChinaTown == null) {
                                bTDChinaTown = new JButton();
                                bTDChinaTown.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_orange.png")));
                                bTDChinaTown.setBorderPainted(false);
                                bTDChinaTown.setOpaque(false);
                                bTDChinaTown.setContentAreaFilled(false);
                                bTDChinaTown.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 19;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDChinaTown;
                }

                                private JButton getBTDC5() {
                        if (bTDC5 == null) {
                                bTDC5 = new JButton();
                                bTDC5.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_orange.png")));
                                bTDC5.setBorderPainted(false);
                                bTDC5.setOpaque(false);
                                bTDC5.setContentAreaFilled(false);
                                bTDC5.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 18;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDC5;
                }

                                private JButton getBTDIntramuros() {
                        if (bTDIntramuros == null) {
                                bTDIntramuros = new JButton();
                                bTDIntramuros.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_orange.png")));
                                bTDIntramuros.setBorderPainted(false);
                                bTDIntramuros.setOpaque(false);
                                bTDIntramuros.setContentAreaFilled(false);
                                bTDIntramuros.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 16;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDIntramuros;
                }

                                private JButton getBTDWalterMart() {
                        if (bTDWalterMart == null) {
                                bTDWalterMart = new JButton();
                                bTDWalterMart.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_pink.png")));
                                bTDWalterMart.setBorderPainted(false);
                                bTDWalterMart.setOpaque(false);
                                bTDWalterMart.setContentAreaFilled(false);
                                bTDWalterMart.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 14;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDWalterMart;
                }

                                private JButton getBTDSlex() {
                        if (bTDSlex == null) {
                                bTDSlex = new JButton();
                                bTDSlex.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_pink.png")));
                                bTDSlex.setBorderPainted(false);
                                bTDSlex.setOpaque(false);
                                bTDSlex.setContentAreaFilled(false);
                                bTDSlex.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 13;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDSlex;
                }

                                private JButton getBTDShopwise() {
                        if (bTDShopwise == null) {
                                bTDShopwise = new JButton();
                                bTDShopwise.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_pink.png")));
                                bTDShopwise.setBorderPainted(false);
                                bTDShopwise.setOpaque(false);
                                bTDShopwise.setContentAreaFilled(false);
                                bTDShopwise.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 11;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDShopwise;
                }

                                private JButton getBTDdlaRsaSt() {
                        if (bTDdlaRsaSt == null) {
                                bTDdlaRsaSt = new JButton();
                                bTDdlaRsaSt.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_skyblue.png")));
                                bTDdlaRsaSt.setBorderPainted(false);
                                bTDdlaRsaSt.setOpaque(false);
                                bTDdlaRsaSt.setContentAreaFilled(false);
                                bTDdlaRsaSt.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 9;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDdlaRsaSt;
                }

                                private JButton getBTDRizalPark() {
                        if (bTDRizalPark == null) {
                                bTDRizalPark = new JButton();
                                bTDRizalPark.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_skyblue.png")));
                                bTDRizalPark.setBorderPainted(false);
                                bTDRizalPark.setOpaque(false);
                                bTDRizalPark.setContentAreaFilled(false);
                                bTDRizalPark.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 8;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDRizalPark;
                }

                                private JButton getBTDPuregold() {
                        if (bTDPuregold == null) {
                                bTDPuregold = new JButton();
                                bTDPuregold.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_skyblue.png")));
                                bTDPuregold.setBorderPainted(false);
                                bTDPuregold.setOpaque(false);
                                bTDPuregold.setContentAreaFilled(false);
                                bTDPuregold.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 6;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDPuregold;
                }

                                private JButton getBTDMakatiAve() {
                        if (bTDMakatiAve == null) {
                                bTDMakatiAve = new JButton();
                                bTDMakatiAve.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_brown.png")));
                                bTDMakatiAve.setBorderPainted(false);
                                bTDMakatiAve.addActionListener(new ActionListener() {
                                	
                                    public void actionPerformed(ActionEvent event) {
                                    		intTD = 3;
                                            runTitleDeedImage(x, intTD);
                                    }
                            });
                        }
                        return bTDMakatiAve;
                }

                private JButton gettdAyalaAveButton() {
                	if (btdAyalaAve == null) {
                		btdAyalaAve = new JButton();
                        btdAyalaAve.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_brown.png")));
                        btdAyalaAve.setBorderPainted(false);
                        btdAyalaAve.setOpaque(false);
                        btdAyalaAve.setContentAreaFilled(false);
                        btdAyalaAve.setFocusable(false);
                        btdAyalaAve.addActionListener(new ActionListener() {
                                            	
                        	public void actionPerformed(ActionEvent event) {
                        		intTD = 1;
                                runTitleDeedImage(x, intTD);
                            }
                        });
                	}
                    return btdAyalaAve;
                 }
                                
           
////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////THIS IS FOR OTHER BUTTONS////////////////////////////////////////       
////////////////////////////////////////////////////////////////////////////////////////////////////////////
                private JLabel getDicebgLabel() {

                        if (ldicebg == null) {
                                ldicebg = new JLabel();
                                ldicebg.setHorizontalAlignment(SwingConstants.TRAILING);
                                ldicebg.setIcon(new ImageIcon(getClass().getResource("/Designs/rollDice_bg.png")));
                        }
                        return ldicebg;
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
                
                                        public void actionPerformed(ActionEvent event) {                //next player
                                                
                                        		x++;
                                                if (x == numberOfPlayers) {
                                                        x = 0;
                                                }
                                                fPlayerName.setText(playerOrder[x].getPlayerName());
                                                fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
                                                bRollDice.setEnabled(true);
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
                
                                        public void actionPerformed(ActionEvent event) {                        //hides what is not needed and shows all tokens used by the players
                                                bPlay.setVisible(false);
                                                pClicktoPlay.setVisible(false);
                                                bRollDice.setEnabled(true);
                                                pBoard.setVisible(true);
                                                pDice.setVisible(true);
                                                pPlayer.setVisible(true);
                                                
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
                                                bRollDice.setEnabled(false);
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
     
           

//////////////////////////////////////////TEXT FIELDS//////////////////////////////////////////

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
        
//////////////////////////////////////////////LABELS////////////////////////////////////////////////
        
      
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

//////////////////////////////////////////////////////PANELS ////////////////////////////////////////////////

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
		pTitleDeeds.add(getBTDMakatiAve(), new Constraints(new Leading(35, 17, 10, 10), new Leading(46, 17, 12, 12)));
		pTitleDeeds.add(getBTDPuregold(), new Constraints(new Leading(11, 18, 12, 12), new Leading(71, 16, 10, 10)));
		pTitleDeeds.add(getBTDRizalPark(), new Constraints(new Leading(34, 18, 12, 12), new Leading(71, 16, 12, 12)));
		pTitleDeeds.add(getBTDdlaRsaSt(), new Constraints(new Leading(58, 17, 12, 12), new Leading(71, 16, 12, 12)));
		pTitleDeeds.add(getTitleDeedImageLabel(), new Constraints(new Leading(0, 12, 12), new Leading(0, 185, 12, 12)));
		pTitleDeeds.add(getBTDShopwise(), new Constraints(new Leading(12, 20, 10, 10), new Leading(93, 19, 10, 10)));
		pTitleDeeds.add(getBTDSlex(), new Constraints(new Leading(35, 20, 10, 10), new Leading(93, 19, 12, 12)));
		pTitleDeeds.add(getBTDWalterMart(), new Constraints(new Leading(58, 20, 10, 10), new Leading(93, 19, 12, 12)));
		pTitleDeeds.add(getBTDIntramuros(), new Constraints(new Leading(12, 20, 12, 12), new Leading(118, 19, 10, 10)));
		pTitleDeeds.add(getBTDC5(), new Constraints(new Leading(35, 20, 12, 12), new Leading(118, 19, 12, 12)));
		pTitleDeeds.add(getBTDChinaTown(), new Constraints(new Leading(58, 20, 12, 12), new Leading(118, 19, 12, 12)));
		pTitleDeeds.add(getBTDNlex(), new Constraints(new Leading(12, 20, 12, 12), new Leading(143, 17, 10, 10)));
		pTitleDeeds.add(getBTDNationalbs(), new Constraints(new Leading(35, 20, 12, 12), new Leading(143, 17, 12, 12)));
		pTitleDeeds.add(getBTDTrinoma(), new Constraints(new Leading(58, 20, 12, 12), new Leading(143, 17, 12, 12)));
		pTitleDeeds.add(getBTDEdsa(), new Constraints(new Leading(90, 18, 10, 10), new Leading(46, 19, 12, 12)));
		pTitleDeeds.add(getBTDMagsaysayBrdge(), new Constraints(new Leading(112, 19, 10, 10), new Leading(46, 19, 12, 12)));
		pTitleDeeds.add(getBTDStarCity(), new Constraints(new Leading(135, 19, 10, 10), new Leading(46, 19, 12, 12)));
		pTitleDeeds.add(getBDTLandmark(), new Constraints(new Leading(90, 18, 12, 12), new Leading(69, 18, 12, 12)));
		pTitleDeeds.add(getBTDGlorietta(), new Constraints(new Leading(112, 18, 12, 12), new Leading(69, 18, 12, 12)));
		pTitleDeeds.add(getBDTGreenbelt(), new Constraints(new Leading(135, 18, 12, 12), new Leading(69, 18, 12, 12)));
		pTitleDeeds.add(getBTDBoracay(), new Constraints(new Leading(90, 18, 12, 12), new Leading(93, 19, 12, 12)));
		pTitleDeeds.add(getBTDMoa(), new Constraints(new Leading(112, 18, 12, 12), new Leading(93, 19, 12, 12)));
		pTitleDeeds.add(getBTDMeralco(), new Constraints(new Leading(90, 18, 12, 12), new Leading(118, 19, 12, 12)));
		pTitleDeeds.add(getBTDMaynilad(), new Constraints(new Leading(112, 18, 12, 12), new Leading(118, 19, 12, 12)));
		pTitleDeeds.add(getBTDAyalaStation(), new Constraints(new Leading(90, 18, 12, 12), new Leading(143, 17, 12, 12)));
		pTitleDeeds.add(getBTDBuendiaStation(), new Constraints(new Leading(114, 17, 12, 12), new Leading(143, 17, 12, 12)));
		pTitleDeeds.add(getBDTTaftStation(), new Constraints(new Leading(135, 18, 12, 12), new Leading(143, 17, 12, 12)));
		pTitleDeeds.add(getBDTNorthStation(), new Constraints(new Leading(161, 16, 10, 10), new Leading(143, 17, 12, 12)));
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
                pPlayer.add(getTitleDeedsPanel(), new Constraints(new Leading(0, 12, 12), new Leading(172, 185, 12, 12)));
                pPlayer.add(getEndTurnButton(), new Constraints(new Leading(21, 163, 12, 12), new Leading(365, 51, 10, 10)));
                pPlayer.add(getPlayerPanelImageLabel(), new Constraints(new Leading(0, 12, 12), new Leading(12, 12, 12)));
                pPlayer.setVisible(true);
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
       
        @SuppressWarnings({ "static-access"})
                public void run(){      
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
                        chance.shuffleChance();
                        switch (chance.getChanceRandom()){
                        //switch (3){
                        case 1:
                                        //chance.speedingFine();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 15);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;                                          
                        case 2:
                                        //chance.bankDividend();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 3:
                                        //chance.advanceToTrinoma();
                                        playerOrder[x].getToken().setxLocation(227);
                                        playerOrder[x].getToken().setyLocation(23);
                                        playerOrder[x].setPosition(24);
                                        updateTokenPosition();
                                        
                                        if(playerOrder[x].getPosition() == 36){
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        }       
                                        
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        System.out.println("Advance to Trinoma. If you pass GO collect P200. " +playerOrder[x].getStartMoney());
                                        break;
                        case 4:
                                        playerOrder[x].getToken().setxLocation(525);
                                        playerOrder[x].getToken().setyLocation(525);
                                        playerOrder[x].setPosition(40);
                                        updateTokenPosition();
                                        passedGo();
                                        System.out.println("Pass Go.");
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 5:
                                        //chance.paySchoolFees();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 150);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 6:
                                        //chance.advanceToMoa();
                                        playerOrder[x].getToken().setxLocation(525);
                                        playerOrder[x].getToken().setyLocation(462);
                                        playerOrder[x].setPosition(39);
                                        updateTokenPosition();
                                        System.out.println("Advance to SM Mall of Asia.");
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 7:
                                        playerOrder[x].setHasJailKey(true);
                                        //System.out.println("Get out of Jail Free Key.");
                                        updateTokenPosition();
                                        System.out.println("HasJailKey: "+playerOrder[x].hasJailKey());
                                        break;
                        case 8:
                                        //chance.streetRepairs();
                                        updateTokenPosition();
                                        System.out.println("Your are assessed for street repairs. Pay 50 to the bank.");
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                        fPlayerMoney.setText("P" + playerOrder[x].getStartMoney());
                                        System.out.println("Money: " + playerOrder[x].getStartMoney());
                                        break;
                        case 9:
                                        //chance.generalRepairs();
                                        updateTokenPosition();
                                        System.out.println("Make general repairs on all of your buildings. Pay 50 to the bank.");
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                        fPlayerMoney.setText("P" + playerOrder[x].getStartMoney());
                                        System.out.println("Money: " + playerOrder[x].getStartMoney());
                                        break;
                        case 10:
                                        //chance.advanceToShopwise();
                                        playerOrder[x].getToken().setxLocation(23);
                                        playerOrder[x].getToken().setyLocation(462);
                                        playerOrder[x].setPosition(11);
                                        updateTokenPosition();
                                        
                                        if(playerOrder[x].getPosition() == 22 || playerOrder[x].getPosition() == 36){
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        }       
                                        System.out.println("Advance to Shopwise. If you pass GO collect P200. ");
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 11:
                                        //chance.tripToBuendiaStation();
                                        playerOrder[x].getToken().setxLocation(23);
                                        playerOrder[x].getToken().setyLocation(274);
                                        playerOrder[x].setPosition(15);
                                        updateTokenPosition();
                                        
                                        if(playerOrder[x].getPosition() == 22 || playerOrder[x].getPosition() == 36){
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        }       
                                        System.out.println("Take a trip to Buendia Station. If you pass GO collect P200. " +playerOrder[x].getStartMoney());
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 12:
                                        //chance.buildingMatures();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 150);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 13:
                                        goToJail();
                                        System.out.println("GO TO JAIL.");
                                        break;
                        case 14:
                                        //chance.goBackThreeSteps();
                                                if(playerOrder[x].getPosition()==7){
                                                        playerOrder[x].getToken().setxLocation(321);
                                                        playerOrder[x].getToken().setyLocation(525);
                                                        updateTokenPosition();
                                                        playerOrder[x].setPosition(4);
                                                        
                                                }else if(playerOrder[x].getPosition()==22){
                                                        playerOrder[x].getToken().setxLocation(23);
                                                        playerOrder[x].getToken().setyLocation(86);
                                                        updateTokenPosition();
                                                        playerOrder[x].setPosition(19);
                                                        
                                                }else if(playerOrder[x].getPosition()==36){
                                                        playerOrder[x].getToken().setxLocation(525);
                                                        playerOrder[x].getToken().setyLocation(274);
                                                        updateTokenPosition();
                                                        playerOrder[x].setPosition(33);
                                                        
                                                }
                                        System.out.println("Go back three spaces.");
                                        break;
                        case 15:
                                        //chance.drunkInCharge();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 20);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        case 16:
                                        //chance.wonCrosswordCompetition();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChanceMoney: "+playerOrder[x].getStartMoney());
                                        break;
                        }
                
        }
        
        
        
        public void cChestRandom(){
        			Cchest.shuffleCchest();
                        
                        switch (Cchest.getcChestRandom()){
                        
                                case 1:
                                        //Cchest.bankError();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 2:
                                        //Cchest.payHospital();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 3:
                                        //Cchest.wonBeautyContest();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 10);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 4:
                                        //Cchest.taxRefund();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 20);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 5:
                                        //pPayOrChance.setVisible(true);
                                        //Cchest.payOrChance();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 10);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 6:
                                        //Cchest.payInsurance();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 7:
                                        //Cchest.saleOfStock();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 8:
                                        //Cchest.recieveInterest();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 25);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 9:
                                        playerOrder[x].getToken().setxLocation(525);
                                        playerOrder[x].getToken().setyLocation(525);
                                        playerOrder[x].setPosition(40);
                                        updateTokenPosition();
                                        passedGo();
                                        updateTokenPosition();
                                        System.out.println("Pass Go.");
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 10:
                                        playerOrder[x].getToken().setxLocation(462);
                                        playerOrder[x].getToken().setyLocation(525);
                                        playerOrder[x].setPosition(1);
                                        updateTokenPosition();
                                        
                                        System.out.println("Go back to Ayala Ave.");
                                        break;
                                case 11:
                                        playerOrder[x].setHasJailKey(true);
                                        updateTokenPosition();
                                        System.out.println("HasJailKey: "+playerOrder[x].hasJailKey());
                                        break;
                                case 12:
                                        //Cchest.yourBirthday();
                                        for(int a = 0; a <= numberOfPlayers; a++){
                                                playerOrder[a].setStartMoney(playerOrder[a].getStartMoney()-10);
                                                //fPlayerMoney.setText("P "+playerOrder[a].getStartMoney());
                                                System.out.println("OtherPlayerMoney: "+playerOrder[a].getStartMoney());
                                                
                                                if(playerOrder[a] == playerOrder[x]){
                                                        playerOrder[a].setStartMoney(playerOrder[x].getStartMoney()+(numberOfPlayers*10));
                                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                        System.out.println("YourMoney: "+playerOrder[a].getStartMoney());
                                                }
                                        }
                                        updateTokenPosition();
                                        System.out.println("It is your birthday. Collect P10 from each player.");
                                        break;
                                case 13:
                                        //Cchest.doctorsFee();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 14:
                                        //Cchest.annuityMatures();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                case 15:
                                        goToJail();
                                        break;
                                case 16:
                                        //Cchest.inheritMoney();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        updateTokenPosition();
                                        System.out.println("ChestMoney: "+playerOrder[x].getStartMoney());
                                        break;
                                                                                                
                                        }
        }
        
        public void checkBoard(){
                //Random random = new Random();
                
                switch(playerOrder[x].getLastStep()){
                        
                        case 1:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/ayalaAvenue.gif"));
                        				int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                        if(res == JOptionPane.YES_OPTION){
                                        	isEstate = true;
                                        	isUtility = false;
                                        	isStation = false;
                                        	buy();
                                        }
                                        //buySomething(1);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                        } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                //System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                               
                                        }
                                }
                                break;
                                                     
                        case 2:
                        		updateTokenPosition();
	                            cChestRandom();
	                            b = chance.getChanceRandom();
	                            showCCT(b,0,0);
                                break;
                                
                        case 3:
	                        	updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/makatiAvenue.gif"));
	                            	int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                    if(res == JOptionPane.YES_OPTION){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        buy();
                                    }
                                       // buySomething(3);
                                        
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                        } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 4:
	                        	
                        		updateTokenPosition();
                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 200);
                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                System.out.println("Paid 200 tax!");
                                showCCT(0,0,2);
                                break;
                                
                        case 5:
	                        	updateTokenPosition();
	                          	if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
		                          		icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Ayala).gif"));
		                          		int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                    if(res == JOptionPane.YES_OPTION){
	                                    	isStation = true;
		                                    isEstate = false;
	                                        isUtility = false;
	                                        buy();
	                                    }
	                                        //buySomething(5);
                                        
                                }else{
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                    } 
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 6:
	                        	updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/puregold.gif"));
	                            	int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                    if(res == JOptionPane.YES_OPTION){
                                    	isEstate = true;
                                    	isUtility = false;
                                        isStation = false;
                                        buy();
                                    }
                                        //buySomething(6);
                                        
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                	//                         ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/pay_rent/puregold.gif")));
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 7:
	                        	updateTokenPosition();
	                            chanceRandom();
	                            c = chance.getChanceRandom();
	                            showCCT(0,c,0);
                                break;
                                
                        case 8:
	                        	updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/rizalPark.gif"));
                        			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                    if(res == JOptionPane.YES_OPTION){
                                    	isEstate = true;
                                    	isUtility = false;
                                        isStation = false;
                                        buy();
                                    }
                                        //buySomething(8);
                                        
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                        } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                        		rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 9:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/delarosaStreet.gif"));
                        			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                    if(res == JOptionPane.YES_OPTION){
                                    	isEstate = true;
                                    	isUtility = false;
                                        isStation = false;
                                        buy();
                                    }
                                        // buySomething(9);
                                        
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                        	//               ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/pay_rent/delarosaStreet.gif")));

                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 11:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/shopwise.gif"));
                        			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                    if(res == JOptionPane.YES_OPTION){
                                    	isEstate = true;
                                    	isUtility = false;
                                        isStation = false;
                                        buy();
                                    }
                                        
                                        //buySomething(11);
                                        
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                        } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 12:
                        	updateTokenPosition();
                            if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned() != true){
                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/meralco.gif"));
                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                if(res == JOptionPane.YES_OPTION){
                                	isUtility = true; 
                                	isEstate = false;
                                    isStation = false;     
                                    buy();
                                }
                                    
                                    //buySomething(12);
                            }else{
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() == x){
                                         System.out.println("This is your land!!! ");
                                         System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getOwnerName());
                                    } 
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() != x){
                                    	//                 ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/pay_rent/SLEX.gif")));
                                            rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                            playerOrder[x].payRent(playerOrder, x, rent);
                                            fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                            System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner());
                                    }
                            }
                            break;
                                
                        case 13:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/SLEX.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){        
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        //buySomething(13);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                        	//                 ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/pay_rent/SLEX.gif")));
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 14:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/walterMart.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){       
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                        //buySomething(14);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                        	//    ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/pay_rent/walterMart.gif")));
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 15:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Buendia).gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){   
	                                	isStation = true;
	                                	isEstate = false;
                                        isUtility = false;
                                        buy();
	                                }
                                        
                                        //buySomething(15);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 16:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/intramuros.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                       // buySomething(16);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 17:
                        		updateTokenPosition();
	                            cChestRandom();
	                            b = Cchest.getcChestRandom();
	                            showCCT(b,0,0);
	                            break;
                                
                        case 18:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/C5road.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true; 
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                       // buySomething(18);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 19:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/chinaTown.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true; 
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                        //buySomething(19);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 21:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/NLEX.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                       // buySomething(21);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 22:
	                        	updateTokenPosition();
	                            chanceRandom();
	                            c = chance.getChanceRandom();
	                            showCCT(0,c,0);
                                break;
                                
                        case 23:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/nationalBookstore.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true; 
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                       // buySomething(23);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 24:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/trinoma.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;   
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                     
                                       // buySomething(24);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 25:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Taft).gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isStation = true; 
	                                	isEstate = false;
                                        isUtility = false;
                                        buy();
	                                }
                                      
                                     //   buySomething(25);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 26:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/EDSA.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                       // buySomething(26);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 27:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/magsaysayBridge.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                       // buySomething(27);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 28:
                        	updateTokenPosition();
                            if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned() != true){
                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/maynilad.gif"));
                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
                                if(res == JOptionPane.YES_OPTION){  
                                	isUtility = true; 
                                	isEstate = false;
                                    isStation = false;    
                                    buy();
                                }
                                    
                                   // buySomething(12);
                            }else{
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() == x){
                                         System.out.println("This is your land!!! ");
                                         System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getOwnerName());
                                    } 
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() != x){
                                    		rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                            playerOrder[x].payRent(playerOrder, x, rent);
                                            fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                            System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner());
                                    }
                            }
                            break;
                                
                        case 29:
                        		updateTokenPosition();
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                	icon = new ImageIcon(getClass().getResource("/buyProperty_images/starCity.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true; 
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                       // buySomething(29);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                        case 30:
	                        	updateTokenPosition();
	                            goToJail();
	                            showCCT(0,13, 0);
                                break;
                                
                        case 31:
                        		updateTokenPosition();
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        			icon = new ImageIcon(getClass().getResource("/buyProperty_images/landmark.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true; 
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                        //buySomething(31);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                        		rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 32:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/glorietta.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                        //buySomething(32);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 33:
	                        	updateTokenPosition();
	                            cChestRandom();
	                            b = Cchest.getcChestRandom();
	                            showCCT(b,0,0);
                                break;
                                
                        case 34:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/greenbelt.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                       // buySomething(34);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 35:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(North).gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isStation = true; 
	                                	isEstate = false;
                                        isUtility = false;
                                        buy();
	                                }
                                       
                                        //buySomething(35);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 36:
                        		updateTokenPosition();
                                chanceRandom();
                                c = chance.getChanceRandom();
                                showCCT(0,c,0);
                                break;
                                
                        case 37:
                        		updateTokenPosition();
	                            if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
	                            	icon = new ImageIcon(getClass().getResource("/buyProperty_images/boracayIsland.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true;
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                        
                                        //buySomething(37);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 38:
                        		updateTokenPosition();
                        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                System.out.println("Paid 100 tax!");
                                showCCT(0,0,1);
                                break;
                                
                        case 39:
                        		updateTokenPosition();
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                	icon = new ImageIcon(getClass().getResource("/buyProperty_images/MOA.gif"));
	                    			int res = JOptionPane.showConfirmDialog(null, "", "Do you want to Buy this Property?", optionType, messageType, icon);
	                                if(res == JOptionPane.YES_OPTION){  
	                                	isEstate = true; 
	                                	isUtility = false;
                                        isStation = false;
                                        buy();
	                                }
                                       
                                       // buySomething(39);
                                }else{
                                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                                             System.out.println("This is your land!!! ");
                                             System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                } 
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
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
                         if(playerOrder[x].getPosition() == 40){                //position goes back to 0 if token passed GO
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
                            updateTokenPosition();
                            playerOrder[x].setJailed(true);
                            System.out.println("Jailed: "+playerOrder[x].isJailed());
       
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
        
        public void useJailKey(){
            playerOrder[x].setHasJailKey(false);
            playerOrder[x].setJailed(false);
            playerOrder[x].setBailOutDice(0);
            playerOrder[x].setDoubleDice(0);
            playerOrder[x].setTryForDice(0);
            System.out.println("Jailed: " +playerOrder[x].isJailed()+ playerOrder[x].getDoubleDice()+playerOrder[x].getBailOutDice()+playerOrder[x].getTryForDice()+playerOrder[x].hasJailKey());
       
        }

      public void runTitleDeedImage(final int x, final int intTD) {
                installLnF();
                SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                                TitleDeedImage frame = new TitleDeedImage(x, intTD);
                                TitleDeedImage.x = x;
                                TitleDeedImage.intTD = intTD;
                                frame.setDefaultCloseOperation(TitleDeedImage.HIDE_ON_CLOSE);
                                frame.setTitle("TitleDeedImage");
                                frame.getContentPane().setPreferredSize(frame.getSize());
                                frame.pack();
                                frame.setLocationRelativeTo(null);
                                frame.setResizable(false);
                                frame.setVisible(true);
                               
                                
                        }
                });
        }
      
      public void buySomething(final int a) {
  		installLnF();
  		SwingUtilities.invokeLater(new Runnable() {
			@Override
  			public void run() {
  				PropertyImages frame = new PropertyImages(a);
  				PropertyImages.a = a;
  				frame.setDefaultCloseOperation(PropertyImages.DISPOSE_ON_CLOSE);
  				frame.setTitle("PropertyImages");
  				frame.getContentPane().setPreferredSize(frame.getSize());
  				frame.pack();
  				frame.setLocationRelativeTo(null);
  				frame.setResizable(false);
  				frame.setVisible(true);
  			}
  		});
  	}
      
      public void showCCT(final int b, final int c, final int d) {
  		installLnF();
  		SwingUtilities.invokeLater(new Runnable() {
  			@Override
  			public void run() {
  				CCTImages frame = new CCTImages(b,c,d);
  				CCTImages.b = b;
  				CCTImages.c = c;
  				CCTImages.d = d;
  				frame.setDefaultCloseOperation(CCTImages.DISPOSE_ON_CLOSE);
  				frame.setTitle("CCTImages");
  				frame.getContentPane().setPreferredSize(frame.getSize());
  				frame.pack();
  				frame.setLocationRelativeTo(null);
  				frame.setResizable(false);
  				frame.setVisible(true);
  				
  				
  			}
  		});
  	}
    public void buy() {
                                       if (isEstate == true) {
                                               //bBuy.setIcon(new ImageIcon(getClass().getResource("/Designs/buyEstate.png")));
                                               playerOrder[x].buyEstate(bblock.getBlock()[playerOrder[x].getPosition()].getEstate(), playerOrder, x);
                                               //fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                               System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getName());
                                               System.out.println("Price: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getPrice());
                                               System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned());
                                               System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                               System.out.println("intOwner: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                       } 
                                       if (isUtility == true) {
                                              // bBuy.setIcon(new ImageIcon(getClass().getResource("/Designs/buyUtility.png")));
                                               playerOrder[x].buyUtility(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities(), playerOrder, x);
                                               //fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                               System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getName());
                                               System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getPrice());
                                               System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned());
                                               System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getOwnerName());
                                               System.out.println("intOwner: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner());
                                           
                                       }
                                       if (isStation == true) {
                                              // bBuy.setIcon(new ImageIcon(getClass().getResource("/Designs/buyStation.png")));
                                               playerOrder[x].buyStation(bblock.getBlock()[playerOrder[x].getPosition()].getStation(), playerOrder, x);
                                               //fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                               System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getName());
                                               System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getPrice());
                                               System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned());
                                               System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getOwnerName());
                                               System.out.println("intOwner: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());

                                       }
                                      
                       }
              

}