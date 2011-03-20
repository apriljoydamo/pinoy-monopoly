import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class PlayersGui extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	
	private static Players playerArray[] = new Players[8];
	private static Players playerOrder[] = new Players[8];
	private static int[] tempOrder = new int[8];
	Players players = new Players();
	
	boolean willRepeat; 
	int x = 0, tokenUsed, randomNumber, numberOfPlayers, initialNumPlayer;
	
	private JPanel pMonopoly, pSolo, pPlay;
	private JLabel lMonopolyLogo, lTypeOfGame;
	private JButton bNewGame, bExit, bPlay, bBackToMenu;
	private JLabel baporLabel, azkalLabel, shoeLabel, ironLabel, carLabel, thimbleLabel, hatLabel, wheelBarrowLabel;
	private JTextField baporNameField, azkalNameField, ironNameField, shoeNameField, carNameField, thimbleNameField, hatNameField, wheelBarrowNameField;
	private JButton baporEnterButton, azkalEnterButton, ironEnterButton, shoeEnterButton, carEnterButton, thimbleEnterButton, hatEnterButton, wheelBarrowEnterButton;
	
	public PlayersGui() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getpMonopoly(), new Constraints(new Leading(-6, 1245, 10, 10), new Leading(0, 655, 501, 501)));
		add(getpSolo(), new Constraints(new Bilateral(0, 0, 826), new Leading(0, 702, 12, 12)));
		setSize(890, 550);
	}

///////////////////////////////BUTTONS////////////////////////////////////////////////
	private JButton getWheelBarrowEnterButton() {
		if (wheelBarrowEnterButton == null) {
			wheelBarrowEnterButton = new JButton();
			wheelBarrowEnterButton.setText("Enter");
			wheelBarrowEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(wheelBarrowNameField.getText());
					playerArray[x].getToken().setAssignedToken(8);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					wheelBarrowEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});
		}
		return wheelBarrowEnterButton;
	}

	private JButton getHatEnterButton() {
		if (hatEnterButton == null) {
			hatEnterButton = new JButton();
			hatEnterButton.setText("Enter");
			hatEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(hatNameField.getText());
					playerArray[x].getToken().setAssignedToken(7);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					hatEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});
		}
		return hatEnterButton;
	}

	private JButton getThimbleEnterButton() {
		if (thimbleEnterButton == null) {
			thimbleEnterButton = new JButton();
			thimbleEnterButton.setText("Enter");
			thimbleEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(thimbleNameField.getText());
					playerArray[x].getToken().setAssignedToken(6);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					thimbleEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});
		}
		return thimbleEnterButton;
	}

	private JButton getCarEnterButton() {
		if (carEnterButton == null) {
			carEnterButton = new JButton();
			carEnterButton.setText("Enter");
			carEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(carNameField.getText());
					playerArray[x].getToken().setAssignedToken(5);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					carEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});
		}
		return carEnterButton;
	}

	private JButton getShoeEnterButton() {
		if (shoeEnterButton == null) {
			shoeEnterButton = new JButton();
			shoeEnterButton.setText("Enter");
			shoeEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(shoeNameField.getText());
					playerArray[x].getToken().setAssignedToken(4);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					shoeEnterButton.setEnabled(false);		
					bPlay.setEnabled(true);
				}
			});
		}
		return shoeEnterButton;
	}

	private JButton getIronEnterButton() {
		if (ironEnterButton == null) {
			ironEnterButton = new JButton();
			ironEnterButton.setText("Enter");
			ironEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(ironNameField.getText());
					playerArray[x].getToken().setAssignedToken(3);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					ironEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});
		}
		return ironEnterButton;
	}

	private JButton getAzkalEnterButton() {
		if (azkalEnterButton == null) {
			azkalEnterButton = new JButton();
			azkalEnterButton.setText("Enter");
			azkalEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(azkalNameField.getText());
					playerArray[x].getToken().setAssignedToken(2);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					azkalEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});
		}
		return azkalEnterButton;
	}

	private JButton getBaporEnterButton() {
		if (baporEnterButton == null) {
			baporEnterButton = new JButton();
			baporEnterButton.setText("Enter");
			baporEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					playerArray[x] = players.createPlayer(baporNameField.getText());
					playerArray[x].getToken().setAssignedToken(1);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
					//System.out.println("labelToken " + players.getLabelToken());
					baporEnterButton.setEnabled(false);
					bPlay.setEnabled(true);
				}
			});

		}
		return baporEnterButton;
	}
	
	private JButton getbBackToMenu() {
		if (bBackToMenu == null) {
			bBackToMenu = new JButton();
			bBackToMenu.setText("Back to Menu");
			bBackToMenu.setEnabled(false);
			bBackToMenu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					baporNameField.setText("");
					azkalNameField.setText("");
					ironNameField.setText("");
					shoeNameField.setText("");
					carNameField.setText("");
					thimbleNameField.setText("");
					hatNameField.setText("");
					wheelBarrowNameField.setText("");
					baporEnterButton.setEnabled(true);
					azkalEnterButton.setEnabled(true);
					ironEnterButton.setEnabled(true);
					shoeEnterButton.setEnabled(true);
					carEnterButton.setEnabled(true);
					thimbleEnterButton.setEnabled(true);
					hatEnterButton.setEnabled(true);
					wheelBarrowEnterButton.setEnabled(true);
					pSolo.setVisible(false);
					pPlay.setVisible(false);
					pMonopoly.setVisible(true);
				}
			});
		}
		return bBackToMenu;
	}

	private JButton getbPlay() {
		if (bPlay == null) {
			bPlay = new JButton();
			bPlay.setText("Play");
			bPlay.setEnabled(false);
			bPlay.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						insertOrder(initialNumPlayer);
						rearrangeArray(initialNumPlayer);
						runBoard();
					}
			});
		}
		return bPlay;
	}

	private JButton getbExit() {
		if (bExit == null) {
			bExit = new JButton();
			bExit.setText("Exit");
			bExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
		}
		return bExit;
	}

	private JButton getbNewGame() {
		if (bNewGame == null) {
			bNewGame = new JButton();
			bNewGame.setText("New Game");
			bNewGame.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					pMonopoly.setVisible(false);
					pSolo.setVisible(true);
					//pMulti.setVisible(true);
					pPlay.setVisible(true);
				}
			});
		}
		return bNewGame;
	}

///////////////////////////TEXT FIELDS//////////////////////////////////////
	private JTextField getWheelBarrowNameField() {
		if (wheelBarrowNameField == null) {
			wheelBarrowNameField = new JTextField();
			wheelBarrowNameField.setText(" ");
		}
		return wheelBarrowNameField;
	}

	private JTextField getHatNameField() {
		if (hatNameField == null) {
			hatNameField = new JTextField();
			hatNameField.setText(" ");
		}
		return hatNameField;
	}

	private JTextField getThimbleNameField() {
		if (thimbleNameField == null) {
			thimbleNameField = new JTextField();
			thimbleNameField.setText(" ");
		}
		return thimbleNameField;
	}

	private JTextField getCarNameField() {
		if (carNameField == null) {
			carNameField = new JTextField();
			carNameField.setText(" ");
		}
		return carNameField;
	}

	private JTextField getShoeNameField() {
		if (shoeNameField == null) {
			shoeNameField = new JTextField();
			shoeNameField.setText(" ");
		}
		return shoeNameField;
	}

	private JTextField getIronNameField() {
		if (ironNameField == null) {
			ironNameField = new JTextField();
			ironNameField.setText(" ");
		}
		return ironNameField;
	}

	private JTextField getAzkalNameField() {
		if (azkalNameField == null) {
			azkalNameField = new JTextField();
			azkalNameField.setText(" ");
		}
		return azkalNameField;
	}

	private JTextField getBaporNameField() {
		if (baporNameField == null) {
			baporNameField = new JTextField();
			baporNameField.setText(" ");
		}
		return baporNameField;
	}

//////////////////////////////////////LABELS///////////////////////////////
	private JLabel getThimbleLabel() {
		if (thimbleLabel == null) {
			thimbleLabel = new JLabel();
			thimbleLabel.setIcon(new ImageIcon(getClass().getResource("/thimble_token.png")));
		}
		return thimbleLabel;
	}

	private JLabel getWheelBarrowLabel() {
		if (wheelBarrowLabel == null) {
			wheelBarrowLabel = new JLabel();
			wheelBarrowLabel.setIcon(new ImageIcon(getClass().getResource("/wheelbarrow_token.png")));
		}
		return wheelBarrowLabel;
	}

	private JLabel getHatLabel() {
		if (hatLabel == null) {
			hatLabel = new JLabel();
			hatLabel.setIcon(new ImageIcon(getClass().getResource("/hat_token.png")));
		}
		return hatLabel;
	}

	private JLabel getCarLabel() {
		if (carLabel == null) {
			carLabel = new JLabel();
			carLabel.setIcon(new ImageIcon(getClass().getResource("/car_token.png")));
		}
		return carLabel;
	}

	private JLabel getIronLabel() {
		if (ironLabel == null) {
			ironLabel = new JLabel();
			ironLabel.setIcon(new ImageIcon(getClass().getResource("/iron_token.png")));
		}
		return ironLabel;
	}
	private JLabel getShoeLabel() {
		if (shoeLabel == null) {
			shoeLabel = new JLabel();
			shoeLabel.setIcon(new ImageIcon(getClass().getResource("/shoe_token.png")));
		}
		return shoeLabel;
	}

	private JLabel getAzkalLabel() {
		if (azkalLabel == null) {
			azkalLabel = new JLabel();
			azkalLabel.setIcon(new ImageIcon(getClass().getResource("/dog_token.png")));
		}
		return azkalLabel;
	}

	private JLabel getBaporLabel() {
		if (baporLabel == null) {
			baporLabel = new JLabel();
			baporLabel.setIcon(new ImageIcon(getClass().getResource("/ship_token.png")));
		}
		return baporLabel;
	}

	private JLabel getlTypeOfGame() {
		if (lTypeOfGame == null) {
			lTypeOfGame = new JLabel();
			lTypeOfGame.setText("Choose Token:");
		}
		return lTypeOfGame;
	}

	private JLabel getlMonopolyLogo() {
		if (lMonopolyLogo == null) {
			lMonopolyLogo = new JLabel();
			lMonopolyLogo.setIcon(new ImageIcon(getClass().getResource("/pMonopoly.png")));
		}
		return lMonopolyLogo;
	}
	
/////////////////////////////////////PANELS//////////////////////////////////		
	private JPanel getpPlay() {
		if (pPlay == null) {
			pPlay = new JPanel();
			pPlay.setBackground(new Color(60, 67, 162));
			pPlay.setLayout(new GroupLayout());
			pPlay.add(getbBackToMenu(), new Constraints(new Leading(550, 153, 10, 10), new Leading(54, 42, 10, 10)));
			pPlay.add(getbPlay(), new Constraints(new Leading(209, 144, 10, 10), new Leading(54, 43, 12, 12)));
		}
		return pPlay;
	}
	
	private JPanel getpSolo() {
		if (pSolo == null) {
			pSolo = new JPanel();
			pSolo.setBackground(new Color(140, 255, 140));
			pSolo.setLayout(new GroupLayout());
			pSolo.setVisible(false);
			pSolo.add(getlTypeOfGame(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
			pSolo.add(getBaporLabel(), new Constraints(new Leading(15, 10, 10), new Leading(65, 10, 10)));
			pSolo.add(getBaporNameField(), new Constraints(new Leading(83, 151, 10, 10), new Leading(72, 34, 10, 10)));
			pSolo.add(getBaporEnterButton(), new Constraints(new Leading(269, 10, 10), new Leading(75, 12, 12)));
			pSolo.add(getAzkalLabel(), new Constraints(new Leading(20, 12, 12), new Leading(149, 10, 10)));
			pSolo.add(getAzkalNameField(), new Constraints(new Leading(83, 150, 12, 12), new Leading(156, 34, 12, 12)));
			pSolo.add(getAzkalEnterButton(), new Constraints(new Leading(269, 12, 12), new Leading(164, 12, 12)));
			pSolo.add(getIronLabel(), new Constraints(new Leading(19, 12, 12), new Leading(252, 12, 12)));
			pSolo.add(getIronNameField(), new Constraints(new Leading(83, 150, 12, 12), new Leading(254, 34, 12, 12)));
			pSolo.add(getIronEnterButton(), new Constraints(new Leading(269, 12, 12), new Leading(258, 12, 12)));
			pSolo.add(getShoeLabel(), new Constraints(new Leading(24, 10, 10), new Leading(351, 10, 10)));
			pSolo.add(getShoeNameField(), new Constraints(new Leading(83, 150, 12, 12), new Leading(353, 34, 10, 10)));
			pSolo.add(getShoeEnterButton(), new Constraints(new Leading(269, 12, 12), new Leading(357, 12, 12)));
			pSolo.add(getThimbleLabel(), new Constraints(new Leading(481, 12, 12), new Leading(143, 10, 10)));
			pSolo.add(getCarLabel(), new Constraints(new Leading(473, 12, 12), new Leading(68, 12, 12)));
			pSolo.add(getCarNameField(), new Constraints(new Leading(545, 150, 12, 12), new Leading(68, 38, 12, 12)));
			pSolo.add(getCarEnterButton(), new Constraints(new Leading(733, 12, 12), new Leading(74, 12, 12)));
			pSolo.add(getThimbleNameField(), new Constraints(new Leading(545, 150, 12, 12), new Leading(152, 38, 12, 12)));
			pSolo.add(getThimbleEnterButton(), new Constraints(new Leading(733, 12, 12), new Leading(158, 12, 12)));
			pSolo.add(getHatLabel(), new Constraints(new Leading(483, 10, 10), new Leading(258, 12, 12)));
			pSolo.add(getHatNameField(), new Constraints(new Leading(546, 150, 12, 12), new Leading(253, 36, 12, 12)));
			pSolo.add(getHatEnterButton(), new Constraints(new Leading(733, 12, 12), new Leading(258, 12, 12)));
			pSolo.add(getWheelBarrowNameField(), new Constraints(new Leading(549, 150, 10, 10), new Leading(351, 38, 12, 12)));
			pSolo.add(getWheelBarrowLabel(), new Constraints(new Leading(484, 12, 12), new Leading(352, 12, 12)));
			pSolo.add(getWheelBarrowEnterButton(), new Constraints(new Leading(733, 12, 12), new Leading(360, 12, 12)));
			pSolo.add(getpPlay(), new Constraints(new Leading(0, 890, 10, 10), new Leading(424, 125, 10, 10)));
		}
		return pSolo;
	}

	private JPanel getpMonopoly() {
		if (pMonopoly == null) {
			pMonopoly = new JPanel();
			pMonopoly.setBackground(new Color(128, 128, 255));
			pMonopoly.setLayout(new GroupLayout());
			pMonopoly.setVisible(true);
			pMonopoly.add(getlMonopolyLogo(), new Constraints(new Leading(98, 717, 10, 10), new Leading(38, 313, 10, 10)));
			pMonopoly.add(getbNewGame(), new Constraints(new Leading(288, 134, 10, 10), new Leading(376, 64, 10, 10)));
			pMonopoly.add(getbExit(), new Constraints(new Leading(501, 129, 10, 10), new Leading(376, 64, 12, 12)));
		}
		return pMonopoly;
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
	
/////////////////////////MAIN///////////////////////////////
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PlayersGui frame = new PlayersGui();
				frame.setDefaultCloseOperation(PlayersGui.EXIT_ON_CLOSE);
				frame.setTitle("PlayersGui");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
	}

/////////////////////////METHODS///////////////////////////////////////
	public void assignPlayerOrder(){
		Random random = new Random();
		do{
            randomNumber = random.nextInt(8)+1;
            for(int y=0;y<=7;y++){
                    if(tempOrder[y] == randomNumber){
                            y=8;
                            willRepeat = true;                                                      
                            }
                    else{
                            willRepeat = false;
                    }
            }
	            tempOrder[x] = randomNumber;                                                   
	    }
	    while(willRepeat==true);
	    playerArray[x].setTempOrder(tempOrder[x]);
	    initialNumPlayer = x;
	    x++;
	    numberOfPlayers = x;
	    System.out.println("playerName " + playerArray[x-1].getPlayerName());
		System.out.println("tempOrder " +playerArray[x-1].getTempOrder());
	}
	
	 public static void insertOrder(int b){                              
         int y = 1;                                                                           
         for(int z = 1; z <= 8; z++){
                 for(int x = 0; x <= b; x++){
                         if(playerArray[x].getTempOrder() == z){
                                 playerArray[x].setOrder(y);
                                 y++;
                                 System.out.println("insertOrder " +playerArray[x].getOrder());
                         }
                 }
         }
 }
	public static void rearrangeArray(int a){                              
        int y = 0;
        for(int z = 1; z <= 8; z++){
                for(int x = 0; x <= a; x++){
                        if(playerArray[x].getOrder()==z){
                                playerOrder[y] = playerArray[x];
                                System.out.println("playerOrder " + playerOrder[y].getOrder());
                                y++;
                                
                        }
                }
        }
}
	
	public void runBoard(){
		this.setVisible(false);
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
				frame.setResizable(false);
				frame.setVisible(true);
				frame.playerOrder = playerOrder;
				GameBoard.numberOfPlayers = numberOfPlayers;
			}
		});
	}
}
	
