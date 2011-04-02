

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
        int x = 0, rent;
        Thread t;
                private JPanel pClicktoPlay;
                private JLabel lClicktoPlay;
                private JLabel lPlayerPanelImage;
                private JLabel ldicebg;
                private JLabel lTitleDeedImageLabel;
                private JButton bPay50;
                private JButton bTryForDice;
                private JButton btdAyalaAve;
                private JLabel ltransparentImage;
                private JButton bBuy;
                boolean isEstate, isUtility, isStation;
                private JLabel ltaranparenth;
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
        
                private JLabel getltaranparenthl() {
                        if (ltaranparenth == null) {
                                ltaranparenth = new JLabel();
                                ltaranparenth.setIcon(new ImageIcon(getClass().getResource("/Designs/transparenth.png")));
                        }
                        return ltaranparenth;
                } 


                private JButton getbBuy() {
        if (bBuy == null) {
                bBuy = new JButton();
                bBuy.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                bBuy.setBorderPainted(false);
                bBuy.setOpaque(false);
                bBuy.setContentAreaFilled(false);
               // bBuy.setEnabled(false);
                bBuy.setFocusable(false);
                //bBuy.setVisible(false);
                bBuy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                                                if (isEstate == true) {
                                                        playerOrder[x].buyEstate(bblock.getBlock()[playerOrder[x].getPosition()].getEstate(), playerOrder, x);
                                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                        System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getName());
                                                        System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getPrice());
                                                        System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned());
                                                        System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getOwnerName());
                                                        System.out.println("intOwner: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                                } 
                                                if (isUtility == true) {
                                                        playerOrder[x].buyUtility(bblock.getBlock()[playerOrder[x].getPosition()].getUtilities(), playerOrder, x);
                                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                        System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getName());
                                                        System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getPrice());
                                                        System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().isOwned());
                                                        System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getOwnerName());
                                                        System.out.println("intOwner: "+bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner());
                                                }
                                                if (isStation == true) {
                                                        playerOrder[x].buyStation(bblock.getBlock()[playerOrder[x].getPosition()].getStation(), playerOrder, x);
                                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                        System.out.println("Name: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getName());
                                                        System.out.println("price: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getPrice());
                                                        System.out.println("Owned: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned());
                                                        System.out.println("Owner: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getOwnerName());
                                                        System.out.println("intOwner: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                                }
                                }
                        });
                }
                return bBuy;
        }

                        private JLabel getltransparentImage() {
                        if (ltransparentImage == null) {
                                ltransparentImage = new JLabel();
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Designs/transparent.png")));
                        }
                        return ltransparentImage;
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
                                bTryForDice.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                bTryForDice.setBorderPainted(false);
                                bTryForDice.setOpaque(false);
                                bTryForDice.setFocusable(false);
                                bTryForDice.setEnabled(false);
                                bTryForDice.setContentAreaFilled(false);
                                bTryForDice.addActionListener(new ActionListener() {
                
                                        public void actionPerformed(ActionEvent event) {
                                                playerOrder[x].getToken().setLocation(23, 525);
                                                
                                                bPay50.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                                bTryForDice.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Designs/transparent.png")));
                                                bTryForDice.setEnabled(false);
                                               // bPay50.setEnabled(false);
                                        }
                                });
                        }
                        return bTryForDice;
                }

                private JButton getbPay50() {
                        if (bPay50 == null) {
                                bPay50 = new JButton();
                                bPay50.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                bPay50.setBorderPainted(false);
                                bPay50.setOpaque(false);
                                bPay50.setContentAreaFilled(false);
                                bPay50.setFocusable(false);
                              //  bPay50.setEnabled(false);
                                bPay50.addActionListener(new ActionListener() {
                
                                        public void actionPerformed(ActionEvent event) {
                                                playerOrder[x].getToken().setLocation(23, 525);
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                                fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
                                                System.out.println("Money: " + playerOrder[x].getStartMoney());
                                                playerOrder[x].setJailed(false);
                                                playerOrder[x].setBailOutDice(0);
                                                playerOrder[x].setDoubleDice(0);
                                                playerOrder[x].setTryForDice(0);
                                                
                                                bPay50.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                                bTryForDice.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Designs/transparent.png")));
                                               // bTryForDice.setEnabled(false);
                                               // bPay50.setEnabled(false);
                                        
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
                
                                        public void actionPerformed(ActionEvent event) {                //next player
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
                
                                        public void actionPerformed(ActionEvent event) {                        //hides what is not needed and shows all tokens used by the players
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
                                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Designs/transparent.png")));
                                                ltaranparenth.setIcon(new ImageIcon(getClass().getResource("/Designs/transparenth.png")));
                                                bTryForDice.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                                bPay50.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                                      
                                                bBuy.setIcon(new ImageIcon(getClass().getResource("/Designs/transparentv.png")));
                                               // bBuy.setEnabled(false);
                        
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
                pBoard.add(getBaporLabel(), new Constraints(new Leading(515, 10, 10), new Leading(527, 12, 12)));
                pBoard.add(getAzkalLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 10, 10)));
                pBoard.add(getIronLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                pBoard.add(getShoeLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                pBoard.add(getCarLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                pBoard.add(getThimbleLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                pBoard.add(getHatLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                pBoard.add(getWheelBarrowLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                pBoard.add(getltaranparenthl(), new Constraints(new Leading(104, 12, 12), new Leading(184, 12, 12)));
                pBoard.add(getbTryForDice(), new Constraints(new Leading(303, 160, 10, 10), new Leading(319, 106, 10, 10)));
                pBoard.add(getbPay50(), new Constraints(new Leading(314, 138, 12, 12), new Leading(238, 10, 10)));
                pBoard.add(getbBuy(), new Constraints(new Leading(190, 220, 12, 12), new Leading(426, 46, 12, 12)));
                pBoard.add(getltransparentImage(), new Constraints(new Leading(121, 10, 10), new Leading(101, 396, 12, 12)));
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
                        //for(int a = 0; a < 36; a++){      
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
                        switch (chance.getChanceRandom()){
                        //switch (3){
                        case 1:
                                        //chance.speedingFine();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Speeding-fine-P15.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 15);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;                                          
                        case 2:
                                        //chance.bankDividend();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Bank-pays-you-dividend-of-P50.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 3:
                                        //chance.advanceToTrinoma();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-Trinoma..gif")));
                                        playerOrder[x].getToken().setxLocation(227);
                                        playerOrder[x].getToken().setyLocation(23);
                                        playerOrder[x].setPosition(24);
                                        updateTokenPosition();
                                        
                                        if(playerOrder[x].getPosition() == 36){
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        }       
                                        
                                        System.out.println("Advance to Trinoma. If you pass GO collect P200. " +playerOrder[x].getStartMoney());
                                        break;
                        case 4:
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-GO.gif")));
                                        playerOrder[x].getToken().setxLocation(525);
                                        playerOrder[x].getToken().setyLocation(525);
                                        playerOrder[x].setPosition(40);
                                        updateTokenPosition();
                                        passedGo();
                                        System.out.println("Pass Go.");
                                        break;
                        case 5:
                                        //chance.paySchoolFees();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Pay-school-fees-of-P150.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 150);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 6:
                                        //chance.advanceToMoa();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-SM-Mall-of-Asia.gif")));
                                        playerOrder[x].getToken().setxLocation(525);
                                        playerOrder[x].getToken().setyLocation(462);
                                        playerOrder[x].setPosition(39);
                                        updateTokenPosition();
                                        System.out.println("Advance to SM Mall of Asia.");
                                        break;
                        case 7:
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Get-out-of-Jail-Free-Key.gif")));
                                        playerOrder[x].setHasJailKey(true);
                                        //System.out.println("Get out of Jail Free Key.");
                                        System.out.println("HasJailKey: "+playerOrder[x].hasJailKey());
                                        
                                        break;
                        case 8:
                                        //chance.streetRepairs();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/street-repairs.gif")));
                                        System.out.println("Your are assessed for street rpairs. P40 per house, P115 per hotel.");
                                        break;
                        case 9:
                                        //chance.generalRepairs();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/General-repairs-for-buildings.gif")));
                                        System.out.println("Make general repairs on all of your buildings. For each house pay P25. For each hotel pay P100.");
                                        break;
                        case 10:
                                        //chance.advanceToShopwise();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-Shopwise.gif")));
                                        playerOrder[x].getToken().setxLocation(23);
                                        playerOrder[x].getToken().setyLocation(462);
                                        playerOrder[x].setPosition(11);
                                        updateTokenPosition();
                                        
                                        if(playerOrder[x].getPosition() == 22 || playerOrder[x].getPosition() == 36){
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        }       
                                        System.out.println("Advance to Shopwise. If you pass GO collect P200. " + playerOrder[x].getStartMoney());
                                        break;
                        case 11:
                                        //chance.tripToBuendiaStation();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/take_a_trip_to_beundia_station.gif")));
                                        playerOrder[x].getToken().setxLocation(23);
                                        playerOrder[x].getToken().setyLocation(274);
                                        playerOrder[x].setPosition(15);
                                        updateTokenPosition();
                                        
                                        if(playerOrder[x].getPosition() == 22 || playerOrder[x].getPosition() == 36){
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney()+200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        }       
                                        System.out.println("Take a trip to Buendia Station. If you pass GO collect P200. " +playerOrder[x].getStartMoney());
                                        break;
                        case 12:
                                        //chance.buildingMatures();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/building_laon_matures.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 150);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 13:
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/go_to_jail.gif")));
                                        goToJail();
                                        System.out.println("GO TO JAIL.");
                                        break;
                        case 14:
                                        //chance.goBackThreeSteps();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Go-back-three-spaces.gif")));
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
                                                //playerOrder[x].getToken().setLocation();
                                        System.out.println("Go back three spaces.");
                                        break;
                        case 15:
                                        //chance.drunkInCharge();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/Drunk-in-Charge.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 20);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 16:
                                        //chance.wonCrosswordCompetition();
                                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/newChances/crossword_competition.gif")));
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
                                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/BankError.gif")));
                                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                break;
                        case 2:
                                        //Cchest.payHospital();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/payHospital.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 3:
                                        //Cchest.wonBeautyContest();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/beautyContest.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 10);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 4:
                                        //Cchest.taxRefund();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/incomeTax.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 20);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 5:
                                        //pPayOrChance.setVisible(true);
                                //ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/BankError.png")));
                                        //Cchest.payOrChance();
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 10);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        //there should be a PANEL...with a PAY 10 or TAKE CHANCE here...
                                break;
                        case 6:
                                        //Cchest.payInsurance();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/payInsurance.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 7:
                                        //Cchest.saleOfStock();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/saleOfStock.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 8:
                                        //Cchest.recieveInterest();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/interestReceive.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 25);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 9:
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/advanceToGo.gif")));
                                        playerOrder[x].getToken().setxLocation(525);
                                        playerOrder[x].getToken().setyLocation(525);
                                        playerOrder[x].setPosition(40);
                                        updateTokenPosition();
                                        passedGo();
                                        System.out.println("Pass Go.");
                                        break;
                        case 10:
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/ayalaAve.gif")));
                                        playerOrder[x].getToken().setxLocation(462);
                                        playerOrder[x].getToken().setyLocation(525);
                                        playerOrder[x].setPosition(1);
                                        updateTokenPosition();
                                        
                                        System.out.println("Go back to Ayala Ave.");
                                        break;
                        case 11:
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/getOutofJailKey.gif")));
                                        playerOrder[x].setHasJailKey(true);
                                        System.out.println("HasJailKey: "+playerOrder[x].hasJailKey());
                                        break;
                        case 12:
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/birthday.gif")));
                                        //Cchest.yourBirthday();
                                        for(int a = 0; a <= numberOfPlayers; a++){
                                                playerOrder[a].setStartMoney(playerOrder[a].getStartMoney()-10);
                                                //fPlayerMoney.setText("P "+playerOrder[a].getStartMoney());
                                                
                                                if(playerOrder[a] == playerOrder[x]){
                                                        playerOrder[a].setStartMoney(playerOrder[x].getStartMoney()+(numberOfPlayers*10));
                                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                }
                                        }
                                        System.out.println("It is your birthday. Collect P10 from each player.");
                                        break;
                        case 13:
                                        //Cchest.doctorsFee();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/Doctorsfee.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 14:
                                        //Cchest.annuityMatures();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/annuityMatures.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                        case 15:
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/goToJail.gif")));
                                        goToJail();
                                        break;
                        case 16:
                                        //Cchest.inheritMoney();
                        	ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/Cchest/inherit.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        break;
                                                                                                
                                        }
        }
        
        public void checkBoard(){
                //Random random = new Random();
                
                switch(playerOrder[x].getLastStep()){
                        
                        case 1:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/ayalaAvenue.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                                     
                        case 2:
                                cChestRandom();
                                break;
                                
                        case 3:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/makatiAvenue.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 4:
                                        ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/tax/paid200.gif")));
                                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 200);
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                        System.out.println("Paid 200 tax!");
                                break;
                                
                        case 5:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Ayala).gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                                        isStation = true;
                                        isEstate = false;
                                        isUtility = false;
                                        //bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 6:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/puregold.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        //bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 7:
                                chanceRandom();
                                break;
                                
                        case 8:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/rizalPark.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        //bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 9:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/delarosaStreet.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        //bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 11:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/shopwise.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 12:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/meralco.gif")));
                                        isUtility = true;
                                        isEstate = false;
                                        isStation = false;
                                        fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                       // bBuy.setEnabled(true);
                                break;
                                
                        case 13:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/SLEX.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 14:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/walterMart.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        //bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 15:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Buendia).gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                                        isStation = true;
                                        isEstate = false;
                                        isUtility = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 16:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/intramuros.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 17:
                                //ccRandom = (random.nextInt(16) + 1);
                                cChestRandom();
                                break;
                                
                        case 18:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/C5road.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 19:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/chinaTown.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 21:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/NLEX.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 22:
                                chanceRandom();
                                break;
                                
                        case 23:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/nationalBookstore.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 24:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/trinoma.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 25:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Taft).gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                                        isStation = true;
                                        isEstate = false;
                                        isUtility = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 26:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/EDSA.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                      //  bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 27:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/magsaysayBridge.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                        //bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 28:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/maynilad.gif")));
                                        isUtility = true;
                                        isEstate = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                break;
                                
                        case 29:
                                
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/starCity.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                        case 30:
                                goToJail();
                                break;
                                
                        case 31:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/landmark.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 32:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/glorietta.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                      //  bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 33:
                                cChestRandom();
                                break;
                                
                        case 34:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/greenbelt.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 35:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(North).gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().isOwned() != true){
                                        isStation = true;
                                        isEstate = false;
                                        isUtility = false;
                                      //  bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 36:
                                chanceRandom();
                                break;
                                
                        case 37:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/boracayIsland.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
                                        if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner() != x){
                                                rent = playerOrder[x].computeRent(playerOrder, playerOrder[x].getPosition(), x, playerOrder[x].getTotalSteps());
                                                playerOrder[x].payRent(playerOrder, x, rent);
                                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                                System.out.println("OwnedByPlayer: "+bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner());
                                        }
                                }
                                break;
                                
                        case 38:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/tax/paid100.gif")));
                                playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
                                fPlayerMoney.setText("P "+playerOrder[x].getStartMoney());
                                System.out.println("Paid 100 tax!");
                                break;
                                
                        case 39:
                                ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MOA.gif")));
                                if(bblock.getBlock()[playerOrder[x].getPosition()].getEstate().isOwned() != true){
                                        isEstate = true;
                                        isUtility = false;
                                        isStation = false;
                                       // bBuy.setEnabled(true);
                                }else{
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
                        
                                                
                                    ltransparentImage.setIcon(new ImageIcon(getClass().getResource("/designs/jail_panel.png")));
                                    bPay50.setIcon(new ImageIcon(getClass().getResource("/Designs/pay50_btn.png")));
                                   // bPay50.setEnabled(true);
                                    bTryForDice.setIcon(new ImageIcon(getClass().getResource("/Designs/try4doubles_btn.png")));
                                    bTryForDice.setEnabled(true);
                                
                            playerOrder[x].setPosition(10);
                            playerOrder[x].getToken().setxLocation(23);
                            playerOrder[x].getToken().setyLocation(525);
                            updateTokenPosition();
                            playerOrder[x].setJailed(true);
                            System.out.println("Jailed: "+playerOrder[x].isJailed());
                            
                           
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