

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

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class GameBoard extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel pBoard, pPlayer, pDice, pTitleDeeds, pClicktoPlay;
	private JLabel lMonopoly, lDice2, lDice1, lClicktoPlay, lPlayerPanelImage, ldicebg, lTitleDeedImageLabel;
	private JLabel lBapor, lAzkal, lIron, lShoe, lCar, lThimble, lHat,lWheelBarrow;
	private JButton bRollDice, bPlay, bEndTurn;
	private JTextField fPlayerName, fPlayerMoney;
	ImageIcon icon, lcChest, lChance, lTax;
	
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
               
	private JButton btdAyalaAve;
	boolean isEstate, isUtility, isStation;
	private JButton bTDMakatiAve, bTDPuregold, bTDRizalPark, bTDdlaRsaSt, bTDShopwise, bTDSlex, bTDWalterMart, bTDIntramuros;
	private JButton bTDC5, bTDChinaTown, bTDNlex, bTDNationalbs, bTDTrinoma, bTDEdsa, bTDMagsaysayBrdge, bTDStarCity, bDTLandmark;
	private JButton bTDGlorietta, bDTGreenbelt, bTDBoracay, bTDMoa, bTDMeralco, bTDMaynilad, bTDAyalaStation, bTDBuendiaStation, bDTNorthStation, bDTTaftStation;
	private JLabel lCtoMortage;
	
	
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
		setSize(805, 590);
			
	}	
      
	private JLabel getJLabel0() {
		if (lCtoMortage == null) {
			lCtoMortage = new JLabel();
			lCtoMortage.setFont(new Font("Century Gothic", Font.ITALIC, 10));
			lCtoMortage.setText("Click to mortage Title Deeds below.");
		}
		return lCtoMortage;
	}

	private JButton getBDTTaftStation() {
		if (bDTTaftStation == null) {
			bDTTaftStation = new JButton();
			bDTTaftStation.setIcon(new ImageIcon(getClass().getResource("/Designs/btn_train.png")));
			bDTTaftStation.setBorderPainted(false);
			bDTTaftStation.setOpaque(false);
			bDTTaftStation.setContentAreaFilled(false);
				
			bDTTaftStation.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent event) {
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Taft Avenue Station.jpg"));
					if(bblock.getBlock()[25].getStation().isOwned() && bblock.getBlock()[25].getStation().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageStation(bblock.getBlock()[25].getStation(), playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[25].getStation().isMortgaged() == true){
								playerOrder[x].redeemStation(bblock.getBlock()[25].getStation(), playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
  							}else{
  								JOptionPane.showMessageDialog(null, null, "Taft Station", JOptionPane.PLAIN_MESSAGE, icon);
  						}	
  						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/North Edsa Station.jpg"));
					if(bblock.getBlock()[35].getStation().isOwned() && bblock.getBlock()[35].getStation().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageStation(bblock.getBlock()[35].getStation(), playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[35].getStation().isMortgaged() == true){
								playerOrder[x].redeemStation(bblock.getBlock()[35].getStation(), playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
							JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
  					}else{
  						JOptionPane.showMessageDialog(null, null, "North Avenue Station", JOptionPane.PLAIN_MESSAGE, icon);
  					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Buendia Station.jpg"));
					if(bblock.getBlock()[15].getStation().isOwned() && bblock.getBlock()[15].getStation().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageStation(bblock.getBlock()[15].getStation(), playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[15].getStation().isMortgaged() == true){
								playerOrder[x].redeemStation(bblock.getBlock()[15].getStation(), playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}	
						}
  					}else{
  						JOptionPane.showMessageDialog(null, null, "Buendia Station", JOptionPane.PLAIN_MESSAGE, icon);
  					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Ayala Avenue Station.jpg"));
					if(bblock.getBlock()[5].getStation().isOwned() && bblock.getBlock()[5].getStation().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageStation(bblock.getBlock()[5].getStation(), playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[5].getStation().isMortgaged() == true){
								playerOrder[x].redeemStation(bblock.getBlock()[5].getStation(), playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Ayala Station", JOptionPane.PLAIN_MESSAGE, icon);
  					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Maynilad.jpg"));
					if(bblock.getBlock()[28].getUtilities().isOwned() && bblock.getBlock()[28].getUtilities().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageUtility(bblock.getBlock()[28].getUtilities(), playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[28].getUtilities().isMortgaged() == true){
								playerOrder[x].redeemUtility(bblock.getBlock()[28].getUtilities(), playerOrder, x);;
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
  					}else{
  						JOptionPane.showMessageDialog(null, null, "Maynilad", JOptionPane.PLAIN_MESSAGE, icon);
  					}
  					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Meralco corp.jpg"));
					if(bblock.getBlock()[12].getUtilities().isOwned() && bblock.getBlock()[12].getUtilities().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageUtility(bblock.getBlock()[12].getUtilities(), playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[12].getUtilities().isMortgaged() == true){
								playerOrder[x].redeemUtility(bblock.getBlock()[12].getUtilities(), playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
  					}else{
  						JOptionPane.showMessageDialog(null, null, "Meralco Corporation", JOptionPane.PLAIN_MESSAGE, icon);
  					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());	
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/MOA.jpg"));
					if(bblock.getBlock()[39].getEstate().isOwned() && bblock.getBlock()[39].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[39].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[39].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[39].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Mall of Asia", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Boracay Island.jpg"));
					if(bblock.getBlock()[37].getEstate().isOwned() && bblock.getBlock()[37].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[37].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[37].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[37].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Boracay Island", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Greenbelt.jpg"));
					if(bblock.getBlock()[34].getEstate().isOwned() && bblock.getBlock()[34].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[34].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[34].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[34].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Greenbelt", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Glorietta.jpg"));
					if(bblock.getBlock()[32].getEstate().isOwned() && bblock.getBlock()[32].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[32].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[32].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[32].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
							JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
					JOptionPane.showMessageDialog(null, null, "Glorietta", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Landmark.jpg"));
					if(bblock.getBlock()[31].getEstate().isOwned() && bblock.getBlock()[31].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[31].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[31].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[31].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Landmark", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Star city.jpg"));
					if(bblock.getBlock()[29].getEstate().isOwned() && bblock.getBlock()[29].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[29].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[29].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[29].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Star City", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
					icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Magsaysay Bridge.jpg"));
					if(bblock.getBlock()[27].getEstate().isOwned() && bblock.getBlock()[27].getEstate().getIntOwner() == x){	
						Object[] options = {"Mortgage" , "Redeem"};
						int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
						if(res == JOptionPane.YES_OPTION){  
							playerOrder[x].mortgageEstate(bblock.getBlock()[27].getEstate(),playerOrder, x);
							JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
						}
						if(res == JOptionPane.NO_OPTION){
							if(bblock.getBlock()[27].getEstate().isMortgaged() == true){
								playerOrder[x].redeemEstate(bblock.getBlock()[27].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, null, "Magsaysay Bridge", JOptionPane.PLAIN_MESSAGE, icon);
					}
					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/EDSA.jpg"));
						if(bblock.getBlock()[26].getEstate().isOwned() && bblock.getBlock()[26].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[26].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[26].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[26].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "EDSA", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Trinoma.jpg"));
						if(bblock.getBlock()[24].getEstate().isOwned() && bblock.getBlock()[24].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[24].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[24].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[24].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Trinoma", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/National Bookstore.jpg"));
						if(bblock.getBlock()[23].getEstate().isOwned() && bblock.getBlock()[23].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[23].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[23].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[23].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "National Bookstore", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/NLEX.jpg"));
						if(bblock.getBlock()[21].getEstate().isOwned() && bblock.getBlock()[21].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
								int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[21].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[21].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[21].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "NLEX", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/China town.jpg"));
						if(bblock.getBlock()[19].getEstate().isOwned() && bblock.getBlock()[19].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[19].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[19].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[19].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "China Town", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/C5 Road.jpg"));
						if(bblock.getBlock()[18].getEstate().isOwned() && bblock.getBlock()[18].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[18].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[18].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[18].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "C5", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Intramuros.jpg"));
						if(bblock.getBlock()[16].getEstate().isOwned() && bblock.getBlock()[16].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[16].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[16].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[16].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Intramuros", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Walter Mart.jpg"));
						if(bblock.getBlock()[14].getEstate().isOwned() && bblock.getBlock()[14].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[14].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[14].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[14].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Walter Mart", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/SLEX.jpg"));
						if(bblock.getBlock()[12].getEstate().isOwned() && bblock.getBlock()[12].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[12].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[12].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[12].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "SLEX", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Shopwise.jpg"));
						if(bblock.getBlock()[11].getEstate().isOwned() && bblock.getBlock()[11].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[11].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[11].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[11].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Shopwise", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Dela Rosa Street.jpg"));
						if(bblock.getBlock()[9].getEstate().isOwned() && bblock.getBlock()[9].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[91].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[9].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[9].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Dela Rosa St.", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Rizal Park.jpg"));
						if(bblock.getBlock()[8].getEstate().isOwned() && bblock.getBlock()[8].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
							int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[8].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[8].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[8].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Rizal Park", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Puregold.jpg"));
						if(bblock.getBlock()[6].getEstate().isOwned() && bblock.getBlock()[6].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
								int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[6].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[6].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[6].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Puregold", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Makati Avenue.jpg"));
						if(bblock.getBlock()[3].getEstate().isOwned() && bblock.getBlock()[3].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
								int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[3].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
								}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[3].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[3].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Makati Avenue", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
						icon = new ImageIcon(getClass().getResource("/Cards (Resized)/Ayala Avenue.jpg"));
						if(bblock.getBlock()[1].getEstate().isOwned() && bblock.getBlock()[1].getEstate().getIntOwner() == x){	
							Object[] options = {"Mortgage" , "Redeem"};
								int res = JOptionPane.showOptionDialog(null, null, "What do you want to do?" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
							if(res == JOptionPane.YES_OPTION){  
								playerOrder[x].mortgageEstate(bblock.getBlock()[1].getEstate(),playerOrder, x);
								JOptionPane.showMessageDialog(null, "You have mortgaged this property.", null, JOptionPane.PLAIN_MESSAGE);
							}
							if(res == JOptionPane.NO_OPTION){
								if(bblock.getBlock()[1].getEstate().isMortgaged() == true){
									playerOrder[x].redeemEstate(bblock.getBlock()[1].getEstate(),playerOrder, x);
									JOptionPane.showMessageDialog(null, "You have redeemed this property.", null, JOptionPane.PLAIN_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "You haven't mortgaged this property yet. ", null, JOptionPane.ERROR_MESSAGE);
								}
							}
						}else{
							JOptionPane.showMessageDialog(null, null, "Ayala Avenue", JOptionPane.PLAIN_MESSAGE, icon);
						}
						fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
					}
				});
			}
			return btdAyalaAve;
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
					
					public void actionPerformed(ActionEvent event) { 
						bPlay.setVisible(false);
						pClicktoPlay.setVisible(false);
						bRollDice.setEnabled(true);
						pBoard.setVisible(true);
						pDice.setVisible(true);
						pPlayer.setVisible(true);
						pTitleDeeds.setVisible(true);
						
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
						
						checkForDoubles();
                        	if(playerOrder[x].isJailed() == true){
                        		playerOrder[x].setTryForDice(playerOrder[x].getTryForDice()+1);
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
			}
			return lPlayerPanelImage;
		}
		
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
				pPlayer.add(getEndTurnButton(), new Constraints(new Leading(21, 163, 12, 12), new Leading(365, 51, 10, 10)));
				pPlayer.add(getTitleDeedsPanel(), new Constraints(new Leading(0, 12, 12), new Leading(185, 185, 10, 10)));
				pPlayer.add(getJLabel0(), new Constraints(new Leading(4, 187, 10, 10), new Leading(172, 12, 12)));
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
   
           public void startThread(){
        	t = new Thread(this);
        	t.start();
        }	
       
        @SuppressWarnings({ "static-access"})
        public void run(){      
        	for(int a = 0; a < playerOrder[x].getTotalSteps(); a++){
        		if(playerOrder[x].getPosition() <= 9){ 
        			try{
        				if(playerOrder[x].getPosition() == 0 || playerOrder[x].getPosition() == 9){
        					playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-63);
        					updateTokenPosition();
        					t.sleep(250);
        				}else{
        					playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-47);
        					updateTokenPosition();
        					t.sleep(250);
        				}
        				playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
        			}
        			catch(InterruptedException e){}
        			
        		}else if(playerOrder[x].getPosition() >= 10 && playerOrder[x].getPosition() < 20){ 
        			try{
        				if(playerOrder[x].getPosition() == 10 || playerOrder[x].getPosition() == 19){
        					playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-63);
        					updateTokenPosition();
        					t.sleep(250);
        				}else{
        					playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-47);
        					updateTokenPosition();
        					t.sleep(250);
        				}
        				playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
        			}catch(InterruptedException e){}
        			
        		}else if(playerOrder[x].getPosition() >= 20 && playerOrder[x].getPosition() < 30){ 
        			try{
        				if(playerOrder[x].getPosition() == 20 || playerOrder[x].getPosition() == 29){
        					playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+63);
        					updateTokenPosition();
        					t.sleep(250);
        				}else{
        					playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+47);
        					updateTokenPosition();
        					t.sleep(250);
        				}
        				playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
        			}catch(InterruptedException e){}
        			
        		}else if(playerOrder[x].getPosition() >= 30 && playerOrder[x].getPosition() < 40){ 
        			try{
        				if(playerOrder[x].getPosition() == 30 || playerOrder[x].getPosition() == 39){
        					playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+63);
        					updateTokenPosition();
        					t.sleep(250);
        				}else{
        					playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+47);
        					updateTokenPosition();
        					t.sleep(250);
        				}
        				playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
        			}catch(InterruptedException e){}
        		}
        		passedGo();
        		if(playerOrder[x].getDoubleDice() == 3){
        			goToJail();
        		}
        		
        	}
        		playerOrder[x].setLastStep(playerOrder[x].getPosition());
                checkBoard();
        }
   
        public void chanceRandom(){
        	chance.shuffleChance();
        	switch (chance.getChanceRandom()){
        	case 1:
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 15);
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		break;                                          
        	case 2:
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		break;
        	case 3:
        		playerOrder[x].getToken().setxLocation(227);
        		playerOrder[x].getToken().setyLocation(23);
        		playerOrder[x].setPosition(24);
        		updateTokenPosition();
        		
        		if(playerOrder[x].getPosition() == 36){
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		}       
        		break;
        	case 4:
        		playerOrder[x].getToken().setxLocation(525);
        		playerOrder[x].getToken().setyLocation(525);
        		playerOrder[x].setPosition(40);
        		updateTokenPosition();
        		passedGo();
        		break;
        	case 5:
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 150);
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		updateTokenPosition();
        		break;
        	case 6:
        		playerOrder[x].getToken().setxLocation(525);
        		playerOrder[x].getToken().setyLocation(462);
        		playerOrder[x].setPosition(39);
        		updateTokenPosition();
        		break;
        	case 7:
        		playerOrder[x].setHasJailKey(true);
        		break;
        	
        	case 8:
        		playerOrder[x].getToken().setxLocation(23);
        		playerOrder[x].getToken().setyLocation(462);
        		playerOrder[x].setPosition(11);
        		updateTokenPosition();
        		
        		if(playerOrder[x].getPosition() == 22 || playerOrder[x].getPosition() == 36){
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		}       
        		break;
        	case 9:
        		playerOrder[x].getToken().setxLocation(23);
        		playerOrder[x].getToken().setyLocation(274);
        		playerOrder[x].setPosition(15);
        		updateTokenPosition();
        		
        		if(playerOrder[x].getPosition() == 22 || playerOrder[x].getPosition() == 36){
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		}       
        		break;
        	case 10:
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 150);
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		updateTokenPosition();
        		break;
        	case 11:
        		goToJail();
        		break;
        	case 12:
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
        		break;
        	case 13:
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 20);
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		break;
        	case 14:
        		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
        		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        		break;
        	}
        	
        }	

        
        public void cChestRandom(){
        	Cchest.shuffleCchest();
        	
        	switch (Cchest.getcChestRandom()){
        		case 1:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 2:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 3:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 10);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 4:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 20);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		
        		case 5:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 6:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 7:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 25);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 8:
        			playerOrder[x].getToken().setxLocation(525);
        			playerOrder[x].getToken().setyLocation(525);
        			playerOrder[x].setPosition(40);
        			updateTokenPosition();
        			passedGo();
        			break;
        		case 9:
        			playerOrder[x].getToken().setxLocation(462);
        			playerOrder[x].getToken().setyLocation(525);
        			playerOrder[x].setPosition(1);
        			break;
        		case 10:
        			playerOrder[x].setHasJailKey(true);
        			break;
        		case 11:
        			for(int a = 0; a <= numberOfPlayers; a++){
        				playerOrder[a].setStartMoney(playerOrder[a].getStartMoney()-10);
        				if(playerOrder[a] == playerOrder[x]){
        					playerOrder[a].setStartMoney(playerOrder[a].getStartMoney()+(numberOfPlayers*10));
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        		case 12:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 13:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        		case 14:
        			goToJail();
        			break;
        		case 15:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			break;
        	}

        }
        
        public void checkBoard(){
        	switch(playerOrder[x].getLastStep()){
        		case 1:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/ayalaAvenue.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 2:
        			cChestRandom();
        			b = chance.getChanceRandom();
        			checkChest(b);
        			break;
        			
        		case 3:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/makatiAvenue.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
                                        
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 4:
        			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 200);
        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        			checkTax(2);
        			break;
                                
        		case 5:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Ayala).gif"));
        				Object[] options = {"Buy Station" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isStation = true;
        					isEstate = false;
        					isUtility = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 6:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/puregold.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 7:
        			chanceRandom();
        			c = chance.getChanceRandom();
        			checkChance(c);
        			break;
        			
        		case 8:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/rizalPark.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 9:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/delarosaStreet.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 11:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/shopwise.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 12:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/meralco.gif"));
        				Object[] options = {"Buy Utility" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);;
        				if(res == JOptionPane.YES_OPTION){
        					isUtility = true; 
        					isEstate = false;
        					isStation = false;     
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}	
        			break;
                                	
        		case 13:	
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/SLEX.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){        
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
        			
        		case 14:
        			if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
        				icon = new ImageIcon(getClass().getResource("/buyProperty_images/walterMart.gif"));
        				Object[] options = {"Buy Estate" , "Nevermind"};
        				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        				if(res == JOptionPane.YES_OPTION){       
        					isEstate = true;
        					isUtility = false;
        					isStation = false;
        					buy();
        				}
        				
        			}else{
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
        					JOptionPane.showMessageDialog(null, "This is your land!");
        				} 
        				if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
        					JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
        					rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
        					playerOrder[x].payRent(playerOrder, x, rent);
        					fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
        				}
        			}
        			break;
                                
                        case 15:
                        	updateTokenPosition();
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Buendia).gif"));
                        		Object[] options = {"Buy Station" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){   
                        			isStation = true;
                        			isEstate = false;
                        			isUtility = false;
                        			buy();
                        		}
                                        
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 16:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/intramuros.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                        	
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}	
                        	break;
                                
                        case 17:
                        	cChestRandom();
                        	b = Cchest.getcChestRandom();
                        	checkChest(b);
                        	break;
                        	
                        case 18:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/C5road.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true; 
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                       
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 19:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/chinaTown.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true; 
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                       	
                        	}else{	
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 21:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/NLEX.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                        		
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 22:
                        	chanceRandom();
                        	c = chance.getChanceRandom();
                        	checkChance(c);
                        	break;
                        	
                        case 23:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/nationalBookstore.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true; 
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                        		
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                        	
                        case 24:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/trinoma.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;   
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                        		
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 25:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Taft).gif"));
                        		Object[] options = {"Buy Station" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isStation = true; 
                        			isEstate = false;
                        			isUtility = false;
                        			buy();
                        		}
                        		
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 26:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/EDSA.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                        		
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 27:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/magsaysayBridge.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                        
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                        	
                        case 28:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/maynilad.gif"));
                        		Object[] options = {"Buy Utility" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                                if(res == JOptionPane.YES_OPTION){  
                                	isUtility = true; 
                                	isEstate = false;
                                    isStation = false;    
                                    buy();
                                }
                                    
                            }else{
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() == x){
                                    	JOptionPane.showMessageDialog(null, "This is your land!");
                                    } 
                                    if(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner() != x){
                                    	JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                                    	rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                    	playerOrder[x].payRent(playerOrder, x, rent);
                                    	fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                    }
                            }
                            break;
                                
                        case 29:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/starCity.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true; 
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                        		
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                        	
                        case 30:
                        	goToJail();
                        	checkChance(13);
                        	break;
          
                        case 31:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/landmark.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true; 
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                       
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 32:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/glorietta.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                        	
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                        	
                        case 33:
                        	cChestRandom();
                        	b = Cchest.getcChestRandom();
                        	checkChest(b);
                        	break;
                                
                        case 34:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/greenbelt.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                        
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        			} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 35:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/MRT(North).gif"));
                        		Object[] options = {"Buy Station" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isStation = true; 
                        			isEstate = false;
                        			isUtility = false;
                        			buy();
                        		}
                                       
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 36:
                        	chanceRandom();
                        	c = chance.getChanceRandom();
                        	checkChance(c);
                        	break;
                        	
                        case 37:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/boracayIsland.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true;
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                        
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        		}
                        	}
                        	break;
                                
                        case 38:
                        	playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
                        	fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                        	checkTax(1);
                        	break;
                        	
                        case 39:
                        	if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                        		icon = new ImageIcon(getClass().getResource("/buyProperty_images/MOA.gif"));
                        		Object[] options = {"Buy Estate" , "Nevermind"};
                				int res = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
                        		if(res == JOptionPane.YES_OPTION){  
                        			isEstate = true; 
                        			isUtility = false;
                        			isStation = false;
                        			buy();
                        		}
                                       
                        	}else{
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() == x){
                        			JOptionPane.showMessageDialog(null, "This is your land!");
                        		} 
                        		if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                        			JOptionPane.showMessageDialog(null, "Pay Rent whether you like it or not!");
                        			rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                        			playerOrder[x].payRent(playerOrder, x, rent);
                        			fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
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
               
       public void passedGo(){
    	   if(playerOrder[x].getPosition() == 40){ 
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
    	   		icon = new ImageIcon(getClass().getResource("/Designs/jail_panel.png"));
		   		Object[] optionsJail = {"Pay 50" , "Try for Doubles", "Use Jail Key"};
				int jail = JOptionPane.showOptionDialog(null, null, "Buy this Property" , JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon, optionsJail, optionsJail[2]);
		   		if(jail == JOptionPane.YES_OPTION){  
		   			playerOrder[x].getToken().setLocation(23, 525);
                    playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                    fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
                    playerOrder[x].setJailed(false);
                    playerOrder[x].setBailOutDice(0);
                    playerOrder[x].setDoubleDice(0);
                    playerOrder[x].setTryForDice(0);
		   		}
		   		
		   		if(jail == JOptionPane.NO_OPTION){
		   			playerOrder[x].getToken().setxLocation(23);
		   			playerOrder[x].getToken().setyLocation(525);
		   			updateTokenPosition();
		   			bailOutOfJail();
		   			bRollDice.setEnabled(true);
		   		}
		   		
		   		if(jail == JOptionPane.CANCEL_OPTION){
		   			playerOrder[x].getToken().setxLocation(23);
		   			playerOrder[x].getToken().setyLocation(525);
		   			updateTokenPosition();
		   			if(playerOrder[x].hasJailKey() == true){
		   				useJailKey();
		   			}
		   			if(playerOrder[x].hasJailKey() == false){
		   				JOptionPane.showMessageDialog(null, "weeeh? wala ka ngang Jail Key eh. :P", "Warning!", JOptionPane.WARNING_MESSAGE);
		   			}
		   			return;
		   		}
       	   t.stop();                   
       }
        
       public void checkForDoubles(){
    	   if(dice[0].getDice1stResult() == dice[1].getDice2ndResult()){
    		   playerOrder[x].setDoubleDice(playerOrder[x].getDoubleDice() + 1);
 		 
    		   if(playerOrder[x].isJailed() == true){
    			   playerOrder[x].setBailOutDice(playerOrder[x].getBailOutDice()+1);
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
        		}
               	}else if(playerOrder[x].getTryForDice() == 3 && playerOrder[x].getBailOutDice() == 0){
               		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()-50);
               		fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
               		playerOrder[x].setJailed(false);
               		playerOrder[x].setBailOutDice(0);
               		playerOrder[x].setDoubleDice(0);
               		playerOrder[x].setTryForDice(0);
               	}  
        }
        
        public void useJailKey(){
        	playerOrder[x].setHasJailKey(false);
            playerOrder[x].setJailed(false);
            playerOrder[x].setBailOutDice(0);
            playerOrder[x].setDoubleDice(0);
            playerOrder[x].setTryForDice(0);
           }

    public void buy() {
    	if (isEstate == true) {
    		playerOrder[x].buyEstate(bblock.getBlock()[playerOrder[x].getPosition()].getEstate(), playerOrder, x);
    	} 
    	if (isUtility == true) {
    		playerOrder[x].buyUtility(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities(), playerOrder, x);
    	}
    	if (isStation == true) {
    		playerOrder[x].buyStation(bblock.getBlock()[playerOrder[x].getPosition()].getStation(), playerOrder, x);
    	}
    	fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
    }

    public void checkChest(int b){
    	switch(b){
		case 1:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/BankError.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 2:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/payHospital.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 3:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/beautyContest.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 4:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/incomeTax.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 5:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/payInsurance.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 6:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/saleOfStock.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 7:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/interestReceive.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 8:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/advanceToGo.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 9:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/ayalaAve.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 10:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/getOutOfJailKey.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 11:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/birthday.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 12:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/Doctorsfee.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 13:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/annuityMatures.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 14:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/goToJail.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		case 15:
			lcChest = new ImageIcon(getClass().getResource("/Cchest/inherit.gif"));
			JOptionPane.showMessageDialog(null, lcChest, "Chest", messageType);
			break;
		}
    
    }
    
public void checkChance(int c){
	switch(c){
		case 1:
			lChance=new ImageIcon(getClass().getResource("/newChances/Speeding-fine-P15.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 2:
			lChance=new ImageIcon(getClass().getResource("/newChances/Bank-pays-you-dividend-of-P50.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 3:
			lChance=new ImageIcon(getClass().getResource("/newChances/Advance-to-Trinoma..gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 4:
			lChance=new ImageIcon(getClass().getResource("/newChances/Advance-to-GO.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 5:
			lChance=new ImageIcon(getClass().getResource("/newChances/Pay-school-fees-of-P150.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 6:
			lChance=new ImageIcon(getClass().getResource("/newChances/Advance-to-SM-Mall-of-Asia.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 7:
			lChance=new ImageIcon(getClass().getResource("/newChances/Get-out-of-Jail-Free-Key.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 8:
			lChance=new ImageIcon(getClass().getResource("/newChances/Advance-to-Shopwise.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 9:
			lChance=new ImageIcon(getClass().getResource("/newChances/take_a_trip_to_buendia_station.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 10:
			lChance=new ImageIcon(getClass().getResource("/newChances/building_laon_matures.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 11:
			lChance=new ImageIcon(getClass().getResource("/newChances/go_to_jail.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 12:
			lChance=new ImageIcon(getClass().getResource("/newChances/Go-back-three-spaces.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 13:
			lChance=new ImageIcon(getClass().getResource("/newChances/Drunk-in-Charge.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		case 14:
			lChance=new ImageIcon(getClass().getResource("/newChances/crossword_competition.gif"));
			JOptionPane.showMessageDialog(null, lChance, "Chance", messageType);
			break;
		}
	}

	public void checkTax(int d){
		switch(d){
		case 1:
			lTax=new ImageIcon(getClass().getResource("/tax/paid100.gif"));
			JOptionPane.showMessageDialog(null, lTax, "Tax", messageType);
			break;
		case 2:
			lTax=new ImageIcon(getClass().getResource("/tax/paid200.gif"));
			JOptionPane.showMessageDialog(null, lTax, "Tax", messageType);
			break;
		}
	}
}