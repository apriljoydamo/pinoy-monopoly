import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

/**
 * 
 */

//VS4E -- DO NOT REMOVE THIS LINE!
public class PlayersGui extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton NewGameButton;
	private JButton ExitButton;
	private JLabel MonopolyLabel;
	private JPanel StartUpPanel;
	private JPanel PlayPanel;
	private JPanel SoloPanel;
	private JPanel MultiPanel;
	private JLabel GameTypeLabel;
	private JButton SoloButton;
	private JButton MultiButton;
	private JTextField EnterNameField;
	private JLabel EnterNameLabel;
	private JLabel ChooseTokenLabel;
	private JLabel EnterPlayerLabel;
	private JTextField EnterPlayerField;
	private JButton MultiEnterButton;
	private JButton MultiClearButton;
	private JPanel EnterPlayerPanel;
	private JRadioButton BaporRadioButton;
	private JRadioButton AzkalRadioButton;
	private JRadioButton IronRadioButton;
	private JRadioButton ShoeRadioButton;
	private JRadioButton MoneyBagRadioButton;
	private JRadioButton TrainRadioButton;
	private JRadioButton ThimbleRadioButton;
	private JRadioButton ManOnHorseRadioButton;
	private JPanel PlayerSoloPanel;
	private JButton PlayButton;
	private JButton BackToMenuButton;
	private JButton EnterNameSoloButton;
	private JButton ClearNameSoloButton;
	
	boolean Pressed = false;
	boolean Token = false;
	int NumPlayers;
	String name, StringPlayers;
	
	Players players = new Players();
	private ButtonGroup buttonGroup1;
	private JPanel EnterPlayer1Panel;
	private JComboBox Player1ComboBox;
	private JButton EnterPlayer1Button;
	private JButton ClearPlayer1Button;
	private JTextField Player1Textfield;
	private JPanel EnterPlayer8Panel;
	private JPanel EnterPlayer7Panel;
	private JPanel EnterPlayer6Panel;
	private JPanel EnterPlayer5Panel;
	private JPanel EnterPlayer4Panel;
	private JPanel EnterPlayer3Panel;
	private JPanel EnterPlayer2Panel;
	private JTextField Player8Textfield;
	private JComboBox Player8ComboBox;
	private JButton EnterPlayer8Button;
	private JButton ClearPlayer8Button;
	private JTextField Player7Textfield;
	private JComboBox Player7ComboBox;
	private JButton EnterPlayer7Button;
	private JButton ClearPlayer7Button;
	private JTextField Player6Textfield;
	private JComboBox Player6ComboBox;
	private JButton EnterPlayer6Button;
	private JButton ClearPlayer6Button;
	private JTextField Player5Textfield;
	private JComboBox Player5ComboBox;
	private JButton EnterPlayer5Button;
	private JButton ClearPlayer5Button;
	private JTextField Player4Textfield;
	private JComboBox Player4ComboBox;
	private JButton EnterPlayer4Button;
	private JButton ClearPlayer4Button;
	private JTextField Player3Textfield;
	private JComboBox Player3ComboBox;
	private JButton EnterPlayer3Button;
	private JButton ClearPlayer3Button;
	private JTextField Player2Textfield;
	private JComboBox Player2ComboBox;
	private JButton EnterPlayer2Button;
	private JButton ClearPlayer2Button;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public PlayersGui() {
		initComponents();
		
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getStartUpPanel(), new Constraints(new Bilateral(0, 0, 0), new Bilateral(0, 0, 0)));
		add(getPlayPanel(), new Constraints(new Leading(0, 1043, 759, 759), new Leading(575, 100, 10, 10)));
		add(getMultiPanel(), new Constraints(new Leading(540, 503, 759, 759), new Leading(0, 576, 401, 401)));
		add(getSoloPanel(), new Constraints(new Leading(0, 536, 10, 10), new Leading(0, 576, 10, 10)));
		initButtonGroup1();
		setSize(1045, 677);
	}

	private JButton getClearPlayer2Button() {
		if (ClearPlayer2Button == null) {
			ClearPlayer2Button = new JButton();
			ClearPlayer2Button.setText("Clear");
			ClearPlayer2Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer2ButtonActionActionPerformed(event);
					Player2Textfield.setText("");
				}
			});
		}
		return ClearPlayer2Button;
	}

	private JButton getEnterPlayer2Button() {
		if (EnterPlayer2Button == null) {
			EnterPlayer2Button = new JButton();
			EnterPlayer2Button.setText("Enter");
		}
		return EnterPlayer2Button;
	}

	private JComboBox getPlayer2ComboBox() {
		if (Player2ComboBox == null) {
			Player2ComboBox = new JComboBox();
			Player2ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Shoe", "Iron", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player2ComboBox.setDoubleBuffered(false);
			Player2ComboBox.setBorder(null);
		}
		return Player2ComboBox;
	}

	private JTextField getPlayer2Textfield() {
		if (Player2Textfield == null) {
			Player2Textfield = new JTextField();
			Player2Textfield.setText("");
		}
		return Player2Textfield;
	}

	private JButton getClearPlayer3Button() {
		if (ClearPlayer3Button == null) {
			ClearPlayer3Button = new JButton();
			ClearPlayer3Button.setText("Clear");
			ClearPlayer3Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer3ButtonActionActionPerformed(event);
					
					Player3Textfield.setText("");
				}
			});
		}
		return ClearPlayer3Button;
	}

	private JButton getEnterPlayer3Button() {
		if (EnterPlayer3Button == null) {
			EnterPlayer3Button = new JButton();
			EnterPlayer3Button.setText("Enter");
		}
		return EnterPlayer3Button;
	}

	private JComboBox getPlayer3ComboBox() {
		if (Player3ComboBox == null) {
			Player3ComboBox = new JComboBox();
			Player3ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player3ComboBox.setDoubleBuffered(false);
			Player3ComboBox.setBorder(null);
		}
		return Player3ComboBox;
	}

	private JTextField getPlayer3Textfield() {
		if (Player3Textfield == null) {
			Player3Textfield = new JTextField();
			Player3Textfield.setText("");
		}
		return Player3Textfield;
	}

	private JButton getClearPlayer4Button() {
		if (ClearPlayer4Button == null) {
			ClearPlayer4Button = new JButton();
			ClearPlayer4Button.setText("Clear");
			ClearPlayer4Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer4ButtonActionActionPerformed(event);
					
					Player4Textfield.setText("");
				}
			});
		}
		return ClearPlayer4Button;
	}

	private JButton getEnterPlayer4Button() {
		if (EnterPlayer4Button == null) {
			EnterPlayer4Button = new JButton();
			EnterPlayer4Button.setText("Enter");
		}
		return EnterPlayer4Button;
	}

	private JComboBox getPlayer4ComboBox() {
		if (Player4ComboBox == null) {
			Player4ComboBox = new JComboBox();
			Player4ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player4ComboBox.setDoubleBuffered(false);
			Player4ComboBox.setBorder(null);
		}
		return Player4ComboBox;
	}

	private JTextField getPlayer4Textfield() {
		if (Player4Textfield == null) {
			Player4Textfield = new JTextField();
			Player4Textfield.setText("");
		}
		return Player4Textfield;
	}

	private JButton getClearPlayer5Button() {
		if (ClearPlayer5Button == null) {
			ClearPlayer5Button = new JButton();
			ClearPlayer5Button.setText("Clear");
			ClearPlayer5Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer5ButtonActionActionPerformed(event);
					
					Player5Textfield.setText("");
				}
			});
		}
		return ClearPlayer5Button;
	}

	private JButton getEnterPlayer5Button() {
		if (EnterPlayer5Button == null) {
			EnterPlayer5Button = new JButton();
			EnterPlayer5Button.setText("Enter");
		}
		return EnterPlayer5Button;
	}

	private JComboBox getPlayer5ComboBox() {
		if (Player5ComboBox == null) {
			Player5ComboBox = new JComboBox();
			Player5ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player5ComboBox.setDoubleBuffered(false);
			Player5ComboBox.setBorder(null);
		}
		return Player5ComboBox;
	}

	private JTextField getPlayer5Textfield() {
		if (Player5Textfield == null) {
			Player5Textfield = new JTextField();
			Player5Textfield.setText("");
		}
		return Player5Textfield;
	}

	private JButton getClearPlayer6Button() {
		if (ClearPlayer6Button == null) {
			ClearPlayer6Button = new JButton();
			ClearPlayer6Button.setText("Clear");
			ClearPlayer6Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer6ButtonActionActionPerformed(event);
					
					Player6Textfield.setText("");
				}
			});
		}
		return ClearPlayer6Button;
	}

	private JButton getEnterPlayer6Button() {
		if (EnterPlayer6Button == null) {
			EnterPlayer6Button = new JButton();
			EnterPlayer6Button.setText("Enter");
		}
		return EnterPlayer6Button;
	}

	private JComboBox getPlayer6ComboBox() {
		if (Player6ComboBox == null) {
			Player6ComboBox = new JComboBox();
			Player6ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player6ComboBox.setDoubleBuffered(false);
			Player6ComboBox.setBorder(null);
		}
		return Player6ComboBox;
	}

	private JTextField getPlayer6Textfield() {
		if (Player6Textfield == null) {
			Player6Textfield = new JTextField();
			Player6Textfield.setText("");
		}
		return Player6Textfield;
	}

	private JButton getClearPlayer7Button() {
		if (ClearPlayer7Button == null) {
			ClearPlayer7Button = new JButton();
			ClearPlayer7Button.setText("Clear");
			ClearPlayer7Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer7ButtonActionActionPerformed(event);
					
					Player7Textfield.setText("");
				}
			});
		}
		return ClearPlayer7Button;
	}

	private JButton getEnterPlayer7Button() {
		if (EnterPlayer7Button == null) {
			EnterPlayer7Button = new JButton();
			EnterPlayer7Button.setText("Enter");
		}
		return EnterPlayer7Button;
	}

	private JComboBox getPlayer7ComboBox() {
		if (Player7ComboBox == null) {
			Player7ComboBox = new JComboBox();
			Player7ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player7ComboBox.setDoubleBuffered(false);
			Player7ComboBox.setBorder(null);
		}
		return Player7ComboBox;
	}

	private JTextField getPlayer7Textfield() {
		if (Player7Textfield == null) {
			Player7Textfield = new JTextField();
			Player7Textfield.setText("");
		}
		return Player7Textfield;
	}

	private JButton getClearPlayer8Button() {
		if (ClearPlayer8Button == null) {
			ClearPlayer8Button = new JButton();
			ClearPlayer8Button.setText("Clear");
			ClearPlayer8Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer8ButtonActionActionPerformed(event);
					
					Player8Textfield.setText("");
				}
			});
		}
		return ClearPlayer8Button;
	}

	private JButton getEnterPlayer8Button() {
		if (EnterPlayer8Button == null) {
			EnterPlayer8Button = new JButton();
			EnterPlayer8Button.setText("Enter");
		}
		return EnterPlayer8Button;
	}

	private JComboBox getPlayer8ComboBox() {
		if (Player8ComboBox == null) {
			Player8ComboBox = new JComboBox();
			Player8ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player8ComboBox.setDoubleBuffered(false);
			Player8ComboBox.setBorder(null);
		}
		return Player8ComboBox;
	}

	private JTextField getPlayer8Textfield() {
		if (Player8Textfield == null) {
			Player8Textfield = new JTextField();
			Player8Textfield.setText("");
		}
		return Player8Textfield;
	}

	private JPanel getEnterPlayer2Panel() {
		if (EnterPlayer2Panel == null) {
			EnterPlayer2Panel = new JPanel();
			EnterPlayer2Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer2Panel.setVisible(false);
			EnterPlayer2Panel.setLayout(new GroupLayout());
			EnterPlayer2Panel.add(getPlayer2Textfield(), new Constraints(new Leading(7, 161, 10, 10), new Leading(8, 10, 10)));
			EnterPlayer2Panel.add(getPlayer2ComboBox(), new Constraints(new Leading(174, 127, 10, 10), new Leading(6, 12, 12)));
			EnterPlayer2Panel.add(getEnterPlayer2Button(), new Constraints(new Leading(307, 81, 12, 12), new Leading(5, 12, 12)));
			EnterPlayer2Panel.add(getClearPlayer2Button(), new Constraints(new Leading(394, 82, 10, 10), new Leading(5, 12, 12)));
		}
		return EnterPlayer2Panel;
	}

	private JPanel getEnterPlayer3Panel() {
		if (EnterPlayer3Panel == null) {
			EnterPlayer3Panel = new JPanel();
			EnterPlayer3Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer3Panel.setVisible(false);
			EnterPlayer3Panel.setLayout(new GroupLayout());
			EnterPlayer3Panel.add(getPlayer3Textfield(), new Constraints(new Leading(7, 160, 10, 10), new Leading(8, 19, 10, 10)));
			EnterPlayer3Panel.add(getPlayer3ComboBox(), new Constraints(new Leading(173, 128, 10, 10), new Leading(5, 12, 12)));
			EnterPlayer3Panel.add(getEnterPlayer3Button(), new Constraints(new Leading(307, 81, 12, 12), new Leading(5, 12, 12)));
			EnterPlayer3Panel.add(getClearPlayer3Button(), new Constraints(new Leading(394, 82, 10, 10), new Leading(5, 12, 12)));
		}
		return EnterPlayer3Panel;
	}

	private JPanel getEnterPlayer4Panel() {
		if (EnterPlayer4Panel == null) {
			EnterPlayer4Panel = new JPanel();
			EnterPlayer4Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer4Panel.setVisible(false);
			EnterPlayer4Panel.setLayout(new GroupLayout());
			EnterPlayer4Panel.add(getPlayer4Textfield(), new Constraints(new Leading(7, 160, 10, 10), new Leading(8, 10, 10)));
			EnterPlayer4Panel.add(getPlayer4ComboBox(), new Constraints(new Leading(173, 129, 10, 10), new Leading(6, 12, 12)));
			EnterPlayer4Panel.add(getEnterPlayer4Button(), new Constraints(new Leading(308, 81, 12, 12), new Leading(5, 12, 12)));
			EnterPlayer4Panel.add(getClearPlayer4Button(), new Constraints(new Leading(395, 81, 10, 10), new Leading(5, 12, 12)));
		}
		return EnterPlayer4Panel;
	}

	private JPanel getEnterPlayer5Panel() {
		if (EnterPlayer5Panel == null) {
			EnterPlayer5Panel = new JPanel();
			EnterPlayer5Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer5Panel.setVisible(false);
			EnterPlayer5Panel.setLayout(new GroupLayout());
			EnterPlayer5Panel.add(getPlayer5Textfield(), new Constraints(new Leading(7, 160, 10, 10), new Leading(8, 10, 10)));
			EnterPlayer5Panel.add(getPlayer5ComboBox(), new Constraints(new Leading(173, 129, 10, 10), new Leading(6, 12, 12)));
			EnterPlayer5Panel.add(getEnterPlayer5Button(), new Constraints(new Leading(308, 81, 12, 12), new Leading(5, 12, 12)));
			EnterPlayer5Panel.add(getClearPlayer5Button(), new Constraints(new Leading(395, 82, 10, 10), new Leading(5, 12, 12)));
		}
		return EnterPlayer5Panel;
	}

	private JPanel getEnterPlayer6Panel() {
		if (EnterPlayer6Panel == null) {
			EnterPlayer6Panel = new JPanel();
			EnterPlayer6Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer6Panel.setVisible(false);
			EnterPlayer6Panel.setLayout(new GroupLayout());
			EnterPlayer6Panel.add(getPlayer6Textfield(), new Constraints(new Leading(7, 160, 10, 10), new Leading(8, 10, 10)));
			EnterPlayer6Panel.add(getPlayer6ComboBox(), new Constraints(new Leading(173, 129, 10, 10), new Leading(6, 12, 12)));
			EnterPlayer6Panel.add(getEnterPlayer6Button(), new Constraints(new Leading(308, 82, 12, 12), new Leading(5, 12, 12)));
			EnterPlayer6Panel.add(getClearPlayer6Button(), new Constraints(new Leading(396, 80, 10, 10), new Leading(5, 12, 12)));
		}
		return EnterPlayer6Panel;
	}

	private JPanel getEnterPlayer7Panel() {
		if (EnterPlayer7Panel == null) {
			EnterPlayer7Panel = new JPanel();
			EnterPlayer7Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer7Panel.setVisible(false);
			EnterPlayer7Panel.setLayout(new GroupLayout());
			EnterPlayer7Panel.add(getPlayer7Textfield(), new Constraints(new Leading(7, 160, 10, 10), new Leading(7, 10, 10)));
			EnterPlayer7Panel.add(getPlayer7ComboBox(), new Constraints(new Leading(173, 130, 10, 10), new Leading(5, 12, 12)));
			EnterPlayer7Panel.add(getEnterPlayer7Button(), new Constraints(new Leading(309, 81, 10, 10), new Leading(5, 12, 12)));
			EnterPlayer7Panel.add(getClearPlayer7Button(), new Constraints(new Leading(396, 80, 10, 10), new Leading(5, 12, 12)));
		}
		return EnterPlayer7Panel;
	}

	private JPanel getEnterPlayer8Panel() {
		if (EnterPlayer8Panel == null) {
			EnterPlayer8Panel = new JPanel();
			EnterPlayer8Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer8Panel.setVisible(false);
			EnterPlayer8Panel.setLayout(new GroupLayout());
			EnterPlayer8Panel.add(getPlayer8Textfield(), new Constraints(new Leading(8, 160, 10, 10), new Leading(8, 10, 10)));
			EnterPlayer8Panel.add(getPlayer8ComboBox(), new Constraints(new Leading(174, 131, 10, 10), new Leading(6, 12, 12)));
			EnterPlayer8Panel.add(getEnterPlayer8Button(), new Constraints(new Leading(311, 80, 10, 10), new Leading(5, 12, 12)));
			EnterPlayer8Panel.add(getClearPlayer8Button(), new Constraints(new Leading(397, 78, 12, 12), new Leading(5, 12, 12)));
		}
		return EnterPlayer8Panel;
	}

	private JTextField getPlayer1Textfield() {
		if (Player1Textfield == null) {
			Player1Textfield = new JTextField();
			Player1Textfield.setText("");
		}
		return Player1Textfield;
	}

	private JButton getEnterPlayer1Button() {
		if (EnterPlayer1Button == null) {
			EnterPlayer1Button = new JButton();
			EnterPlayer1Button.setText("Enter");
		}
		return EnterPlayer1Button;
	}

	private JButton getClearPlayer1Button() {
		if (ClearPlayer1Button == null) {
			ClearPlayer1Button = new JButton();
			ClearPlayer1Button.setText("Clear");
			ClearPlayer1Button.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ClearPlayer1ButtonActionActionPerformed(event);
					
					Player1Textfield.setText("");
				}
			});
		}
		return ClearPlayer1Button;
	}

	private JComboBox getPlayer1ComboBox() {
		if (Player1ComboBox == null) {
			Player1ComboBox = new JComboBox();
			Player1ComboBox.setModel(new DefaultComboBoxModel(new Object[] { "Bapor", "Azkal", "Iron", "Shoe", "Money Bag", "Train", "Thimble", "Man On HorseBack" }));
			Player1ComboBox.setDoubleBuffered(false);
			Player1ComboBox.setBorder(null);
		}
		return Player1ComboBox;
	}

	private JPanel getEnterPlayer1Panel() {
		if (EnterPlayer1Panel == null) {
			EnterPlayer1Panel = new JPanel();
			EnterPlayer1Panel.setBackground(new Color(255, 0, 128));
			EnterPlayer1Panel.setVisible(false);
			EnterPlayer1Panel.setLayout(new GroupLayout());
			EnterPlayer1Panel.add(getPlayer1ComboBox(), new Constraints(new Leading(174, 126, 10, 10), new Leading(7, 12, 12)));
			EnterPlayer1Panel.add(getPlayer1Textfield(), new Constraints(new Leading(6, 162, 12, 12), new Leading(9, 12, 12)));
			EnterPlayer1Panel.add(getEnterPlayer1Button(), new Constraints(new Leading(306, 81, 12, 12), new Leading(6, 12, 12)));
			EnterPlayer1Panel.add(getClearPlayer1Button(), new Constraints(new Leading(393, 83, 10, 10), new Leading(6, 12, 12)));
		}
		return EnterPlayer1Panel;
	}

	private void initButtonGroup1() {
		buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(getBaporRadioButton());
		buttonGroup1.add(getAzkalRadioButton());
		buttonGroup1.add(getIronRadioButton());
		buttonGroup1.add(getShoeRadioButton());
		buttonGroup1.add(getMoneyBagRadioButton());
		buttonGroup1.add(getTrainRadioButton());
		buttonGroup1.add(getThimbleRadioButton());
		buttonGroup1.add(getManOnHorseRadioButton());
	}

	private JButton getClearNameSoloButton() {
		if (ClearNameSoloButton == null) {
			ClearNameSoloButton = new JButton();
			ClearNameSoloButton.setText("Clear");
			ClearNameSoloButton.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					ClearNameSoloButtonMouseMouseClicked(event);
					
				EnterNameField.setText(" ");
				BaporRadioButton.setSelected(false);
				AzkalRadioButton.setSelected(false);
				IronRadioButton.setSelected(false);
				ShoeRadioButton.setSelected(false);
				MoneyBagRadioButton.setSelected(false);
				TrainRadioButton.setSelected(false);
				ThimbleRadioButton.setSelected(false);
				ManOnHorseRadioButton.setSelected(false);
				}
			});
		}
		return ClearNameSoloButton;
	}
	

	private JButton getEnterNameSoloButton() {
		if (EnterNameSoloButton == null) {
			EnterNameSoloButton = new JButton();
			EnterNameSoloButton.setText("Enter");
			EnterNameSoloButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						name = EnterNameField.getText();
						players.addPlayerName(name);
						//players.printChosenToken();
						//System.out.println(" woof " + name);
					}
			});
		}
		return EnterNameSoloButton;
	}

	private JButton getBackToMenuButton() {
		if (BackToMenuButton == null) {
			BackToMenuButton = new JButton();
			BackToMenuButton.setText("Back to Menu");
			BackToMenuButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					StartUpPanel.setVisible(true);
					SoloPanel.setVisible(false);
					MultiPanel.setVisible(false);
					PlayPanel.setVisible(false);
				}
			});
			
		}
		return BackToMenuButton;
	}

	private JButton getPlayButton() {
		if (PlayButton == null) {
			PlayButton = new JButton();
			PlayButton.setText("Play");
			PlayButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					SwingUtilities.invokeLater(new Runnable(){
						public void run(){	
							Board frame = new Board();
							frame.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
							frame.getContentPane().setPreferredSize(frame.getSize());
							frame.pack();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
											}
					});
					
					
				}
			});
		}
		return PlayButton;
	}

	private JPanel getPlayerSoloPanel() {
		if (PlayerSoloPanel == null) {
			PlayerSoloPanel = new JPanel();
			PlayerSoloPanel.setVisible(false);
			PlayerSoloPanel.setLayout(new GroupLayout());
			PlayerSoloPanel.add(getBaporRadioButton(), new Constraints(new Leading(56, 8, 8), new Leading(132, 10, 10)));
			PlayerSoloPanel.add(getAzkalRadioButton(), new Constraints(new Leading(58, 8, 8), new Leading(188, 10, 10)));
			PlayerSoloPanel.add(getIronRadioButton(), new Constraints(new Leading(56, 8, 8), new Leading(244, 10, 10)));
			PlayerSoloPanel.add(getShoeRadioButton(), new Constraints(new Leading(56, 8, 8), new Leading(310, 10, 10)));
			PlayerSoloPanel.add(getMoneyBagRadioButton(), new Constraints(new Leading(320, 10, 10), new Leading(132, 8, 8)));
			PlayerSoloPanel.add(getTrainRadioButton(), new Constraints(new Leading(320, 8, 8), new Leading(188, 8, 8)));
			PlayerSoloPanel.add(getThimbleRadioButton(), new Constraints(new Leading(320, 8, 8), new Leading(244, 8, 8)));
			PlayerSoloPanel.add(getManOnHorseRadioButton(), new Constraints(new Leading(320, 8, 8), new Leading(306, 10, 10)));
			PlayerSoloPanel.add(getChooseTokenLabel(), new Constraints(new Leading(58, 12, 12), new Leading(90, 10, 10)));
			PlayerSoloPanel.add(getEnterNameLabel(), new Constraints(new Leading(29, 10, 10), new Leading(36, 12, 12)));
			PlayerSoloPanel.add(getEnterNameField(), new Constraints(new Leading(116, 199, 12, 12), new Leading(33, 23, 12, 12)));
			PlayerSoloPanel.add(getEnterNameSoloButton(), new Constraints(new Leading(341, 12, 12), new Leading(31, 12, 12)));
			PlayerSoloPanel.add(getClearNameSoloButton(), new Constraints(new Leading(417, 12, 12), new Leading(31, 12, 12)));
		}
		return PlayerSoloPanel;
	}

	private JRadioButton getManOnHorseRadioButton() {
		if (ManOnHorseRadioButton == null) {
			ManOnHorseRadioButton = new JRadioButton();
			ManOnHorseRadioButton.setText("Man On Horse");
			ManOnHorseRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
						players.LabelToken = 8;
					}
			});
		}
		return ManOnHorseRadioButton;
	}

	private JRadioButton getThimbleRadioButton() {
		if (ThimbleRadioButton == null) {
			ThimbleRadioButton = new JRadioButton();
			ThimbleRadioButton.setText("Thimble");
			ThimbleRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
						players.LabelToken = 7;
				}
			});
		}
		return ThimbleRadioButton;
	}

	private JRadioButton getTrainRadioButton() {
		if (TrainRadioButton == null) {
			TrainRadioButton = new JRadioButton();
			TrainRadioButton.setText("Train");
			TrainRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
						players.LabelToken = 6;
					}
			});
		}
		return TrainRadioButton;
	}

	private JRadioButton getMoneyBagRadioButton() {
		if (MoneyBagRadioButton == null) {
			MoneyBagRadioButton = new JRadioButton();
			MoneyBagRadioButton.setText("Money Bag");
			MoneyBagRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					players.LabelToken = 5;
				}
			});
		}
		return MoneyBagRadioButton;
	}

	private JRadioButton getShoeRadioButton() {
		if (ShoeRadioButton == null) {
			ShoeRadioButton = new JRadioButton();
			ShoeRadioButton.setText("Shoe");
			ShoeRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					players.LabelToken = 4;
				}
			});
		}
		return ShoeRadioButton;
	}

	private JRadioButton getIronRadioButton() {
		if (IronRadioButton == null) {
			IronRadioButton = new JRadioButton();
			IronRadioButton.setText("Iron");
			IronRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
						players.LabelToken = 3;
				}
			});
		}
		return IronRadioButton;
	}

	private JRadioButton getAzkalRadioButton() {
		if (AzkalRadioButton == null) {
			AzkalRadioButton = new JRadioButton();
			AzkalRadioButton.setText("Azkal");
			AzkalRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					players.LabelToken = 2;
				}
			});
		}
		return AzkalRadioButton;
	}

	private JRadioButton getBaporRadioButton() {
		if (BaporRadioButton == null) {
			BaporRadioButton = new JRadioButton();
			BaporRadioButton.setSelected(false);
			BaporRadioButton.setText("Bapor");
			BaporRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
						players.LabelToken = 1;
				}
			});
		}
		return BaporRadioButton;
	}

	private JPanel getEnterPlayerPanel() {
		if (EnterPlayerPanel == null) {
			EnterPlayerPanel = new JPanel();
			EnterPlayerPanel.setVisible(true);
			EnterPlayerPanel.setLayout(new GroupLayout());
			EnterPlayerPanel.add(getMultiEnterButton(), new Constraints(new Leading(333, 10, 10), new Leading(9, 12, 12)));
			EnterPlayerPanel.add(getMultiClearButton(), new Constraints(new Leading(412, 10, 10), new Leading(9, 12, 12)));
			EnterPlayerPanel.add(getEnterPlayerField(), new Constraints(new Leading(213, 74, 10, 10), new Leading(14, 12, 12)));
			EnterPlayerPanel.add(getEnterPlayerLabel(), new Constraints(new Leading(37, 10, 10), new Leading(16, 12, 12)));
		}
		return EnterPlayerPanel;
	}

	private JButton getMultiClearButton() {
		if (MultiClearButton == null) {
			MultiClearButton = new JButton();
			MultiClearButton.setText("Clear");
			MultiClearButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					EnterPlayerField.setText(" ");
				}
			});
		
		}
		return MultiClearButton;
	}

	private JButton getMultiEnterButton() {
		if (MultiEnterButton == null) {
			MultiEnterButton = new JButton();
			MultiEnterButton.setText("Enter");
			MultiEnterButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					StringPlayers = EnterPlayerField.getText();
					NumPlayers = Integer.parseInt(StringPlayers);
					players.EnterNumberPlayers(NumPlayers);
					//System.out.println(NumPlayers);
					if(NumPlayers == 1){
						EnterPlayer1Panel.setVisible(true);
					}
					if(NumPlayers == 2){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
					}
					if(NumPlayers == 3){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
						EnterPlayer3Panel.setVisible(true);
					}
					if(NumPlayers == 4){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
						EnterPlayer3Panel.setVisible(true);
						EnterPlayer4Panel.setVisible(true);
					}
					if(NumPlayers == 5){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
						EnterPlayer3Panel.setVisible(true);
						EnterPlayer4Panel.setVisible(true);
						EnterPlayer5Panel.setVisible(true);
					}
					if(NumPlayers == 6){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
						EnterPlayer3Panel.setVisible(true);
						EnterPlayer4Panel.setVisible(true);
						EnterPlayer5Panel.setVisible(true);
						EnterPlayer6Panel.setVisible(true);
					}
					if(NumPlayers == 7){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
						EnterPlayer3Panel.setVisible(true);
						EnterPlayer4Panel.setVisible(true);
						EnterPlayer5Panel.setVisible(true);
						EnterPlayer6Panel.setVisible(true);
						EnterPlayer7Panel.setVisible(true);
					}
					if(NumPlayers == 8){
						EnterPlayer1Panel.setVisible(true);
						EnterPlayer2Panel.setVisible(true);
						EnterPlayer3Panel.setVisible(true);
						EnterPlayer4Panel.setVisible(true);
						EnterPlayer5Panel.setVisible(true);
						EnterPlayer6Panel.setVisible(true);
						EnterPlayer7Panel.setVisible(true);
						EnterPlayer8Panel.setVisible(true);
					}
					if(NumPlayers > 8 && NumPlayers < 0){
						System.out.println("Error!");
					}
				}
			});
			//StringPlayers = EnterPlayerField.getText();
			//NumPlayers = Integer.parseInt(StringPlayers);
			//players.EnterNumberPlayers(NumPlayers);
			//players.EnterNumberPlayers(Integer.parseInt(EnterPlayerField.getText(StringPlayers));	
		}
		return MultiEnterButton;
	}

	private JTextField getEnterPlayerField() {
		if (EnterPlayerField == null) {
			EnterPlayerField = new JTextField();
			EnterPlayerField.setVisible(true);
			EnterPlayerField.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					EnterPlayerField.setText(StringPlayers);
					//StringPlayers = EnterPlayerField.getText();
					
				}
			});
		}
		return EnterPlayerField;
	}

	private JLabel getEnterPlayerLabel() {
		if (EnterPlayerLabel == null) {
			EnterPlayerLabel = new JLabel();
			EnterPlayerLabel.setText("Enter Number of Players:");
		}
		return EnterPlayerLabel;
	}

	private JLabel getChooseTokenLabel() {
		if (ChooseTokenLabel == null) {
			ChooseTokenLabel = new JLabel();
			ChooseTokenLabel.setText("Choose Token:");
			ChooseTokenLabel.setVisible(true);
		}
		return ChooseTokenLabel;
	}

	private JLabel getEnterNameLabel() {
		if (EnterNameLabel == null) {
			EnterNameLabel = new JLabel();
			EnterNameLabel.setText("Enter Name:");
			EnterNameLabel.setVisible(true);
		}
		return EnterNameLabel;
	}

	private JTextField getEnterNameField() {
		if (EnterNameField == null) {
			EnterNameField = new JTextField(20);
			EnterNameField.setText(" ");
			EnterNameField.setVisible(true);
			EnterNameField.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					EnterNameField.setText(name);
				}
			});
		}
		return EnterNameField;
	}

	private JButton getMultiButton() {
		if (MultiButton == null) {
			MultiButton = new JButton();
			MultiButton.setText("Multiplayer Mode");
			MultiButton.setVisible(true);
			MultiButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					if (Pressed != true) {
						Pressed = true;
						players.chooseMulti();
						EnterPlayerPanel.setVisible(true);
					}
				}
			});
		}
		return MultiButton;
	}

	private JButton getSoloButton() {
		if (SoloButton == null) {
			SoloButton = new JButton();
			SoloButton.setText("Solo Test Mode");
			SoloButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Pressed != true){
					Pressed = true;	
					players.chooseSolo();
					PlayerSoloPanel.setVisible(true);
					}
					
				}
			});
		}
		return SoloButton;
	}
	/*public void SoloButtonEvent(ActionEvent e){
		EnterNameLabel.setVisible(true);
		EnterNameField.setVisible(true);
		ChooseTokenLabel.setVisible(true);
		PictureOfToken.setVisible(true);
	}*/

	private JLabel getGameTypeLabel() {
		if (GameTypeLabel == null) {
			GameTypeLabel = new JLabel();
			GameTypeLabel.setText("Choose the game type that you wish to play:");
		}
		return GameTypeLabel;
	}

	private JPanel getMultiPanel() {
		if (MultiPanel == null) {
			MultiPanel = new JPanel();
			MultiPanel.setBackground(new Color(255, 128, 255));
			MultiPanel.setLayout(new GroupLayout());
			MultiPanel.add(getMultiButton(), new Constraints(new Leading(200, 12, 12), new Leading(54, 10, 10)));
			MultiPanel.add(getEnterPlayerPanel(), new Constraints(new Leading(0, 503, 12, 12), new Leading(92, 54, 12, 12)));
			MultiPanel.add(getEnterPlayer1Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(156, 38, 10, 10)));
			MultiPanel.add(getEnterPlayer8Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(488, 36, 10, 10)));
			MultiPanel.add(getEnterPlayer7Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(440, 36, 12, 12)));
			MultiPanel.add(getEnterPlayer6Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(394, 36, 10, 10)));
			MultiPanel.add(getEnterPlayer5Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(348, 36, 10, 10)));
			MultiPanel.add(getEnterPlayer4Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(300, 36, 12, 12)));
			MultiPanel.add(getEnterPlayer3Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(252, 36, 12, 12)));
			MultiPanel.add(getEnterPlayer2Panel(), new Constraints(new Leading(12, 482, 12, 12), new Leading(206, 36, 12, 12)));
			MultiPanel.setVisible(true);
		}
		return MultiPanel;
	}

	private JPanel getSoloPanel() {
		if (SoloPanel == null) {
			SoloPanel = new JPanel();
			SoloPanel.setBackground(new Color(128, 128, 255));
			SoloPanel.setLayout(new GroupLayout());
			SoloPanel.add(getGameTypeLabel(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
			SoloPanel.add(getSoloButton(), new Constraints(new Leading(208, 10, 10), new Leading(54, 10, 10)));
			SoloPanel.add(getPlayerSoloPanel(), new Constraints(new Leading(-2, 540, 12, 12), new Leading(92, 374, 10, 10)));
			SoloPanel.setVisible(true);
		}
		return SoloPanel;
	}

	private JPanel getPlayPanel() {
		if (PlayPanel == null) {
			PlayPanel = new JPanel();
			PlayPanel.setVisible(false);
			PlayPanel.setBackground(new Color(64, 128, 128));
			PlayPanel.setLayout(new GroupLayout());
			PlayPanel.add(getPlayButton(), new Constraints(new Leading(138, 226, 10, 10), new Leading(24, 50, 10, 10)));
			PlayPanel.add(getBackToMenuButton(), new Constraints(new Leading(689, 237, 10, 10), new Leading(24, 47, 12, 12)));
		}
		return PlayPanel;
	}

	private JPanel getStartUpPanel() {
		if (StartUpPanel == null) {
			StartUpPanel = new JPanel();
			StartUpPanel.setBackground(new Color(170, 170, 255));
			StartUpPanel.setVisible(false);
			StartUpPanel.setLayout(new GroupLayout());
			StartUpPanel.add(getNewGameButton(), new Constraints(new Leading(257, 102, 10, 10), new Leading(560, 29, 10, 10)));
			StartUpPanel.add(getExitButton(), new Constraints(new Leading(660, 97, 10, 10), new Leading(559, 30, 12, 12)));
			StartUpPanel.add(getMonopolyLabel(), new Constraints(new Leading(126, 812, 10, 10), new Leading(108, 343, 10, 10)));
		}
		return StartUpPanel;
	}

	private JLabel getMonopolyLabel() {
		if (MonopolyLabel == null) {
			MonopolyLabel = new JLabel();
			MonopolyLabel.setFont(new Font("Impact", Font.BOLD, 48));
			MonopolyLabel.setIcon(new ImageIcon(getClass().getResource("/Logo.png")));
		}
		return MonopolyLabel;
	}

	private JButton getExitButton() {
		if (ExitButton == null) {
			ExitButton = new JButton();
			ExitButton.setText("Exit");
			ExitButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					ExitButtonActionActionPerformed(event);
					System.exit(0);
				}
			});
		}
		return ExitButton;
	}

	private JButton getNewGameButton() {
		if (NewGameButton == null) {
			NewGameButton = new JButton();
			NewGameButton.setText("New Game");
			NewGameButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					StartUpPanel.setVisible(false);
					SoloPanel.setVisible(true);
					MultiPanel.setVisible(true);
					PlayPanel.setVisible(true);
				}
			});
		}
		return NewGameButton;
	}

	/*FOR ALL BACK TO MENU BUTTON
	 * public void actionPerformed(ActionEvent e){
		StartUpPanel.setVisible(true);
		SoloPanel.setVisible(false);
		MultiPanel.setVisible(false);
		PlayPanel.setVisible(false);
		
	}*/
	
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

	private void ClearNameSoloButtonMouseMouseClicked(MouseEvent event) {
		
	}

	private void ExitButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer2ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer1ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer3ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer4ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer5ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer6ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer7ButtonActionActionPerformed(ActionEvent event) {
	}

	private void ClearPlayer8ButtonActionActionPerformed(ActionEvent event) {
	}

}
