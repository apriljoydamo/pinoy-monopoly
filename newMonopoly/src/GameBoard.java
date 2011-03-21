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
		private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
        
        public GameBoard() {
                dice[0] = new Dice();
                dice[1] = new Dice();
                initComponents();
        }

        private void initComponents() {
                setLayout(new GroupLayout());
                add(getBoardPanel(), new Constraints(new Leading(-3, 609, 10, 10), new Leading(0, 603, 12, 12)));
                add(getDicePanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(485, 118, 10, 10)));
                add(getPlayerPanel(), new Constraints(new Leading(605, 210, 12, 12), new Leading(-17, 500, 10, 10)));
                setSize(810, 600);
        }
        
//////////////////////////////////BUTTONS///////////////////////////////////
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
                                        fPlayerMoney.setText("P "+ playerOrder[x].getStartMoney());
                                        }
                                
                        });
                }
                return bEndTurn;
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
                                        fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
                                        
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
                                        }
                                }
                        });
                }
                return bPlay;
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

        private JButton getRollDice() {
                if (bRollDice == null) {
                        bRollDice = new JButton();
                        bRollDice.setText("Roll Button");
                        bRollDice.setEnabled(false);
                        bRollDice.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                        dice[0].rollDiceResult1();
                                        dice[1].rollDiceResult2();
                                        bEndTurn.setEnabled(true);
                                        playerOrder[x].setTotalSteps(dice[0].getDice1stResult() + dice[1].getDice2ndResult());
                                        System.out.println(playerOrder[x].getTotalSteps());
                                        checkForDoubles();
                                        startThread();
                                        
                        switch(dice[0].getDice1stResult()){
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
                        
                        switch(dice[1].getDice2ndResult()){
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
        
////////////////////////////////////LABELS////////////////////////////////
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

////////////////////////////////PANELS////////////////////////////////
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
				pDice.setBackground(new Color(128, 0, 255));
				pDice.setLayout(new GroupLayout());
				pDice.add(getDice2Label(), new Constraints(new Leading(123, 10, 10), new Leading(19, 10, 10)));
				pDice.add(getDice1Label(), new Constraints(new Leading(50, 10, 10), new Leading(19, 12, 12)));
				pDice.add(getRollDice(), new Constraints(new Leading(62, 12, 12), new Leading(77, 12, 12)));
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
                        pBoard.add(getBaporLabel(), new Constraints(new Leading(515, 10, 10), new Leading(527, 12, 12)));
                        pBoard.add(getAzkalLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 10, 10)));
                        pBoard.add(getIronLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                        pBoard.add(getShoeLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                        pBoard.add(getCarLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                        pBoard.add(getThimbleLabel(), new Constraints(new Leading(515, 12, 12), new Leading(525, 12, 12)));
                        pBoard.add(getHatLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                        pBoard.add(getWheelBarrowLabel(), new Constraints(new Leading(515, 12, 12), new Leading(527, 12, 12)));
                        pBoard.add(getMonopolyLabel(), new Constraints(new Leading(5, 10, 10), new Leading(2, 599, 10, 10)));
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
                                                                t.sleep(250);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()-47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
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
                                                                t.sleep(250);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()-47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                                //System.out.println("else " + a);
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
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setxLocation(playerOrder[x].getToken().getxLocation()+47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
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
                                                                t.sleep(250);
                                                                //System.out.println("if " + a);
                                                        }else{
                                                                playerOrder[x].getToken().setyLocation(playerOrder[x].getToken().getyLocation()+47);
                                                                System.out.println(playerOrder[x].getToken().getxLocation()+" "+playerOrder[x].getToken().getyLocation());
                                                                updateTokenPosition();
                                                                t.sleep(250);
                                                                //System.out.println("else " + a);
                                                        }
                                                        playerOrder[x].setPosition(playerOrder[x].getPosition()+1);
                                                        System.out.println("updatedPosition "+playerOrder[x].getPosition());
                                                        passedGo();

                                        }catch(InterruptedException e){}
                                        
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
                        playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
                        fPlayerMoney.setText("P " + playerOrder[x].getStartMoney());
                }
        }
        
        public void goToJail(){
                 	if(playerOrder[x].getPosition() == 30 || playerOrder[x].getDoubleDice() == 3 ){
         	        			playerOrder[x].setPosition(10);
         		        		playerOrder[x].getToken().setxLocation(23);
         		        		playerOrder[x].getToken().setyLocation(525);
         		
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
         		        }
        
        public void checkForDoubles(){
                if(dice[0].getDice1stResult() == dice[1].getDice2ndResult()){
                        playerOrder[x].setDoubleDice(playerOrder[x].getDoubleDice() + 1);
                        System.out.println("doubleDice of "+ x + " = " + playerOrder[x].getDoubleDice());
                }
                
        }
        
}