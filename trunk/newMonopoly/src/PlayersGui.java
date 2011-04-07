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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class PlayersGui extends JFrame{
	private static final long serialVersionUID = 1L;
	private static Players playerArray[] = new Players[8];
	private static Players playerOrder[] = new Players[8];
	private static int[] tempOrder = new int[8];
	Players players = new Players();
	
	boolean willRepeat; 
	int x = 0, tokenUsed, randomNumber, numberOfPlayers, initialNumPlayer;
	
	private JPanel pMonopoly, pSolo, pPlay;
	private JLabel lMonopolyLogo, lTypeOfGame;
	private JButton bNewGame, bExit, bPlay, bBackToMenu;
	private JTextField baporNameField, azkalNameField, ironNameField, shoeNameField, carNameField, thimbleNameField, hatNameField, wheelBarrowNameField;
	private JButton baporEnterButton, azkalEnterButton, ironEnterButton, shoeEnterButton, carEnterButton, thimbleEnterButton, hatEnterButton, wheelBarrowEnterButton;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public PlayersGui() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getpSolo(), new Constraints(new Bilateral(0, 0, 826), new Leading(0, 702, 12, 12)));
		add(getpMonopoly(), new Constraints(new Leading(-6, 1245, 10, 10), new Leading(0, 10, 10)));
		setSize(890, 550);
	}

	private JButton getWheelBarrowEnterButton() {
		if (wheelBarrowEnterButton == null) {
			wheelBarrowEnterButton = new JButton();
			wheelBarrowEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			wheelBarrowEnterButton.setOpaque(false);
			wheelBarrowEnterButton.setContentAreaFilled(false);
			wheelBarrowEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(wheelBarrowNameField.getText());
					playerArray[x].getToken().setAssignedToken(8);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			hatEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			hatEnterButton.setOpaque(false);
			hatEnterButton.setContentAreaFilled(false);
			hatEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(hatNameField.getText());
					playerArray[x].getToken().setAssignedToken(7);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			thimbleEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			thimbleEnterButton.setOpaque(false);
			thimbleEnterButton.setContentAreaFilled(false);
			thimbleEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(thimbleNameField.getText());
					playerArray[x].getToken().setAssignedToken(6);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			carEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			carEnterButton.setOpaque(false);
			carEnterButton.setContentAreaFilled(false);
			carEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(carNameField.getText());
					playerArray[x].getToken().setAssignedToken(5);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			shoeEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			shoeEnterButton.setOpaque(false);
			shoeEnterButton.setContentAreaFilled(false);
			shoeEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(shoeNameField.getText());
					playerArray[x].getToken().setAssignedToken(4);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			ironEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			ironEnterButton.setOpaque(false);
			ironEnterButton.setContentAreaFilled(false);
			ironEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(ironNameField.getText());
					playerArray[x].getToken().setAssignedToken(3);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			azkalEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			azkalEnterButton.setOpaque(false);
			azkalEnterButton.setContentAreaFilled(false);
			azkalEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(azkalNameField.getText());
					playerArray[x].getToken().setAssignedToken(2);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			baporEnterButton.setIcon(new ImageIcon(getClass().getResource("/Designs/enter_btn.png")));
			baporEnterButton.setOpaque(false);
			baporEnterButton.setContentAreaFilled(false);
			baporEnterButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					playerArray[x] = players.createPlayer(baporNameField.getText());
					playerArray[x].getToken().setAssignedToken(1);
					System.out.println(playerArray[x].getToken().getAssignedToken());
					assignPlayerOrder();
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
			bBackToMenu.setIcon(new ImageIcon(getClass().getResource("/Designs/back_btn.png")));
			bBackToMenu.setBorderPainted(false);
			bBackToMenu.setOpaque(false);
			bBackToMenu.setContentAreaFilled(false);
			bBackToMenu.setEnabled(false);
			bBackToMenu.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
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
			bPlay.setIcon(new ImageIcon(getClass().getResource("/Designs/play_btn.png")));
			bPlay.setBorderPainted(false);
			bPlay.setOpaque(false);
			bPlay.setContentAreaFilled(false);
			bPlay.setEnabled(false);
			bPlay.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					insertOrder(initialNumPlayer);
					rearrangeArray(initialNumPlayer);
					runBoard(numberOfPlayers);
				}
			});
		}
		return bPlay;
	}

	private JButton getbExit() {
		if (bExit == null) {
			bExit = new JButton();
			bExit.setBackground(new Color(128, 255, 128));
			bExit.setIcon(new ImageIcon(getClass().getResource("/Designs/Exit_Button.png")));
			bExit.setBorderPainted(false);
			bExit.setOpaque(false);
			bExit.setContentAreaFilled(false);
			bExit.setFocusable(false);
			bExit.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			});
		}
		return bExit;
	}

	private JButton getbNewGame() {
		if (bNewGame == null) {
			bNewGame = new JButton();
			bNewGame.setBackground(new Color(7, 24, 235));
			bNewGame.setIcon(new ImageIcon(getClass().getResource("/Designs/Start_Button.png")));
			bNewGame.setOpaque(false);
			bNewGame.setContentAreaFilled(false);
			bNewGame.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					pMonopoly.setVisible(false);
					pSolo.setVisible(true);
				}
			});
		}
		return bNewGame;
	}

	private JTextField getWheelBarrowNameField() {
		if (wheelBarrowNameField == null) {
			wheelBarrowNameField = new JTextField();
			wheelBarrowNameField.setBackground(new Color(255, 193, 193));
			wheelBarrowNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return wheelBarrowNameField;
	}

	private JTextField getHatNameField() {
		if (hatNameField == null) {
			hatNameField = new JTextField();
			hatNameField.setBackground(new Color(255, 193, 193));
			hatNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return hatNameField;
	}

	private JTextField getThimbleNameField() {
		if (thimbleNameField == null) {
			thimbleNameField = new JTextField();
			thimbleNameField.setBackground(new Color(255, 193, 193));
			thimbleNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return thimbleNameField;
	}

	private JTextField getCarNameField() {
		if (carNameField == null) {
			carNameField = new JTextField();
			carNameField.setBackground(new Color(255, 193, 193));
			carNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return carNameField;
	}

	private JTextField getShoeNameField() {
		if (shoeNameField == null) {
			shoeNameField = new JTextField();
			shoeNameField.setBackground(new Color(255, 193, 193));
			shoeNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return shoeNameField;
	}

	private JTextField getIronNameField() {
		if (ironNameField == null) {
			ironNameField = new JTextField();
			ironNameField.setBackground(new Color(255, 193, 193));
			ironNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return ironNameField;
	}

	private JTextField getAzkalNameField() {
		if (azkalNameField == null) {
			azkalNameField = new JTextField();
			azkalNameField.setBackground(new Color(255, 193, 193));
			azkalNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return azkalNameField;
	}

	private JTextField getBaporNameField() {
		if (baporNameField == null) {
			baporNameField = new JTextField();
			baporNameField.setBackground(new Color(255, 193, 193));
			baporNameField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		}
		return baporNameField;
	}

	private JLabel getlTypeOfGame() {
		if (lTypeOfGame == null) {
			lTypeOfGame = new JLabel();
			lTypeOfGame.setIcon(new ImageIcon(getClass().getResource("/Designs/chooseToken_bg.jpg")));
		}
		return lTypeOfGame;
	}

	private JLabel getlMonopolyLogo() {
		if (lMonopolyLogo == null) {
			lMonopolyLogo = new JLabel();
			lMonopolyLogo.setHorizontalAlignment(SwingConstants.TRAILING);
			lMonopolyLogo.setIcon(new ImageIcon(getClass().getResource("/designs/welcome_screen.png")));
			lMonopolyLogo.setVisible(true);
		}
		return lMonopolyLogo;
	}

	private JPanel getpSolo() {
		if (pSolo == null) {
			pSolo = new JPanel();
			pSolo.setBackground(new Color(140, 255, 140));
			pSolo.setLayout(new GroupLayout());
			pSolo.add(getShoeEnterButton(), new Constraints(new Leading(273, 76, 10, 10), new Leading(495, 26, 10, 10)));
			pSolo.add(getIronEnterButton(), new Constraints(new Leading(273, 76, 12, 12), new Leading(388, 26, 10, 10)));
			pSolo.add(getAzkalEnterButton(), new Constraints(new Leading(273, 76, 12, 12), new Leading(281, 26, 10, 10)));
			pSolo.add(getBaporEnterButton(), new Constraints(new Leading(273, 76, 12, 12), new Leading(174, 25, 12, 12)));
			pSolo.add(getIronNameField(), new Constraints(new Leading(145, 198, 12, 12), new Leading(353, 29, 12, 12)));
			pSolo.add(getAzkalNameField(), new Constraints(new Leading(145, 198, 12, 12), new Leading(247, 28, 12, 12)));
			pSolo.add(getBaporNameField(), new Constraints(new Leading(145, 198, 12, 12), new Leading(141, 29, 10, 10)));
			pSolo.add(getHatNameField(), new Constraints(new Leading(477, 198, 12, 12), new Leading(353, 29, 12, 12)));
			pSolo.add(getThimbleNameField(), new Constraints(new Leading(477, 198, 12, 12), new Leading(247, 28, 12, 12)));
			pSolo.add(getWheelBarrowEnterButton(), new Constraints(new Leading(604, 76, 10, 10), new Leading(495, 25, 12, 12)));
			pSolo.add(getHatEnterButton(), new Constraints(new Leading(604, 76, 12, 12), new Leading(388, 26, 12, 12)));
			pSolo.add(getThimbleEnterButton(), new Constraints(new Leading(604, 76, 12, 12), new Leading(281, 26, 12, 12)));
			pSolo.add(getCarEnterButton(), new Constraints(new Leading(604, 77, 12, 12), new Leading(174, 26, 12, 12)));
			pSolo.add(getbPlay(), new Constraints(new Leading(726, 161, 10, 10), new Leading(101, 158, 10, 10)));
			pSolo.add(getbBackToMenu(), new Constraints(new Leading(845, 42, 12, 12), new Leading(501, 42, 12, 12)));
			pSolo.add(getCarNameField(), new Constraints(new Leading(477, 198, 12, 12), new Leading(141, 29, 12, 12)));
			pSolo.add(getShoeNameField(), new Constraints(new Leading(145, 198, 12, 12), new Leading(461, 28, 12, 12)));
			pSolo.add(getWheelBarrowNameField(), new Constraints(new Leading(477, 198, 12, 12), new Leading(461, 28, 12, 12)));
			pSolo.add(getlTypeOfGame(), new Constraints(new Leading(0, 12, 12), new Leading(0, 12, 12)));
			pSolo.setVisible(false);
		}
		return pSolo;
	}

	private JPanel getpMonopoly() {
		if (pMonopoly == null) {
			pMonopoly = new JPanel();
			pMonopoly.setBackground(new Color(215, 253, 187));
			pMonopoly.setLayout(new GroupLayout());
			pMonopoly.add(getbExit(), new Constraints(new Leading(832, 68, 10, 10), new Leading(-3, 64, 10, 10)));
			pMonopoly.add(getbNewGame(), new Constraints(new Leading(358, 200, 10, 10), new Leading(399, 93, 10, 10)));
			pMonopoly.add(getlMonopolyLogo(), new Constraints(new Leading(7, 12, 12), new Leading(0, 563, 12, 12)));
			pMonopoly.setVisible(true);
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
				frame.setDefaultCloseOperation(PlayersGui.DO_NOTHING_ON_CLOSE);
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
	
	public void runBoard(final int numberOfPlayers){
		this.setVisible(false);
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GameBoard frame = new GameBoard(numberOfPlayers);
				frame.playerOrder = playerOrder;
				GameBoard.numberOfPlayers = numberOfPlayers;
				frame.setDefaultCloseOperation(GameBoard.EXIT_ON_CLOSE);
				frame.setTitle("GameBoard");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
				
			}
		});
	}
}
	
