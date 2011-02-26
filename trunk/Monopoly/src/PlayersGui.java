import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	private JButton HighScoresButton;
	private JButton InstructionsButton;
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
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public PlayersGui() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getStartUpPanel(), new Constraints(new Bilateral(0, 0, 0), new Bilateral(0, 0, 0)));
		add(getPlayPanel(), new Constraints(new Leading(0, 1043, 759, 759), new Leading(575, 100, 10, 10)));
		add(getSoloPanel(), new Constraints(new Leading(0, 540, 10, 10), new Leading(0, 576, 10, 10)));
		add(getMultiPanel(), new Constraints(new Leading(540, 503, 759, 759), new Leading(0, 576, 401, 401)));
		setSize(1045, 677);
	}

	private JButton getClearNameSoloButton() {
		if (ClearNameSoloButton == null) {
			ClearNameSoloButton = new JButton();
			ClearNameSoloButton.setText("Clear");
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
		}
		return BackToMenuButton;
	}

	private JButton getPlayButton() {
		if (PlayButton == null) {
			PlayButton = new JButton();
			PlayButton.setText("Play");
		}
		return PlayButton;
	}

	private JPanel getPlayerSoloPanel() {
		if (PlayerSoloPanel == null) {
			PlayerSoloPanel = new JPanel();
			PlayerSoloPanel.setLayout(new GroupLayout());
			PlayerSoloPanel.setVisible(false);
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
			ManOnHorseRadioButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (Token == false){
						Token = true;
						players.LabelToken = 8;
						//players.choosePlayerToken(a);
					}
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
					if (Token == false) {
						Token = true;
						players.LabelToken = 7;
						//players.choosePlayerToken(a);
					}
				}
			});
		}
		return ThimbleRadioButton;
	}

	private JRadioButton getTrainRadioButton() {
		if (TrainRadioButton == null) {
			TrainRadioButton = new JRadioButton();
			TrainRadioButton.setText("Train");
			TrainRadioButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Token == false){
						Token = true;
						players.LabelToken = 6;
						//players.choosePlayerToken(a);
					}
				}
			});
		}
		return TrainRadioButton;
	}

	private JRadioButton getMoneyBagRadioButton() {
		if (MoneyBagRadioButton == null) {
			MoneyBagRadioButton = new JRadioButton();
			MoneyBagRadioButton.setText("Money Bag");
			MoneyBagRadioButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Token == false){
						Token = true;
						players.LabelToken = 5;
						//players.choosePlayerToken(a);
					}
				}
			});
		}
		return MoneyBagRadioButton;
	}

	private JRadioButton getShoeRadioButton() {
		if (ShoeRadioButton == null) {
			ShoeRadioButton = new JRadioButton();
			ShoeRadioButton.setText("Shoe");
			ShoeRadioButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Token == false){
						Token = true;
						players.LabelToken = 4;
						//players.choosePlayerToken(a);
					}
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
					if (Token == false) {
						Token = true;
						players.LabelToken = 3;
						//players.choosePlayerToken(a);
					}
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
					if (Token == false) {
						Token = true;
						players.LabelToken = 2;
						//players.choosePlayerToken(a);
					}
				}
			});
		}
		return AzkalRadioButton;
	}

	private JRadioButton getBaporRadioButton() {
		if (BaporRadioButton == null) {
			BaporRadioButton = new JRadioButton();
			BaporRadioButton.setText("Bapor");
			BaporRadioButton.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					if (Token == false) {
						Token = true;
						players.LabelToken = 1;
						//players.choosePlayerToken(a);
					}
				}
			});
		}
		return BaporRadioButton;
	}

	private JPanel getEnterPlayerPanel() {
		if (EnterPlayerPanel == null) {
			EnterPlayerPanel = new JPanel();
			EnterPlayerPanel.setLayout(new GroupLayout());
			EnterPlayerPanel.add(getMultiEnterButton(), new Constraints(new Leading(333, 10, 10), new Leading(9, 12, 12)));
			EnterPlayerPanel.add(getMultiClearButton(), new Constraints(new Leading(412, 10, 10), new Leading(9, 12, 12)));
			EnterPlayerPanel.add(getEnterPlayerField(), new Constraints(new Leading(213, 74, 10, 10), new Leading(14, 12, 12)));
			EnterPlayerPanel.add(getEnterPlayerLabel(), new Constraints(new Leading(37, 10, 10), new Leading(16, 12, 12)));
			EnterPlayerPanel.setVisible(false);
		}
		return EnterPlayerPanel;
	}

	private JButton getMultiClearButton() {
		if (MultiClearButton == null) {
			MultiClearButton = new JButton();
			MultiClearButton.setText("Clear");
		
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
			MultiButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(Pressed != true){
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
			MultiPanel.setVisible(true);
			MultiPanel.setBackground(new Color(255, 128, 255));
			MultiPanel.setLayout(new GroupLayout());
			MultiPanel.add(getMultiButton(), new Constraints(new Leading(200, 12, 12), new Leading(54, 10, 10)));
			MultiPanel.add(getEnterPlayerPanel(), new Constraints(new Leading(0, 503, 12, 12), new Leading(92, 54, 12, 12)));
		}
		return MultiPanel;
	}

	private JPanel getSoloPanel() {
		if (SoloPanel == null) {
			SoloPanel = new JPanel();
			SoloPanel.setVisible(true);
			SoloPanel.setBackground(new Color(128, 128, 255));
			SoloPanel.setLayout(new GroupLayout());
			SoloPanel.add(getGameTypeLabel(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
			SoloPanel.add(getSoloButton(), new Constraints(new Leading(208, 10, 10), new Leading(54, 10, 10)));
			SoloPanel.add(getPlayerSoloPanel(), new Constraints(new Leading(-2, 540, 12, 12), new Leading(92, 374, 10, 10)));
		}
		return SoloPanel;
	}

	private JPanel getPlayPanel() {
		if (PlayPanel == null) {
			PlayPanel = new JPanel();
			PlayPanel.setBackground(new Color(64, 128, 128));
			PlayPanel.setLayout(new GroupLayout());
			PlayPanel.add(getPlayButton(), new Constraints(new Leading(138, 226, 10, 10), new Leading(24, 50, 10, 10)));
			PlayPanel.add(getBackToMenuButton(), new Constraints(new Leading(689, 237, 10, 10), new Leading(24, 47, 12, 12)));
		}
		return PlayPanel;
	}

	private JButton getInstructionsButton() {
		if (InstructionsButton == null) {
			InstructionsButton = new JButton();
			InstructionsButton.setText("Instructions");
		}
		return InstructionsButton;
	}

	private JButton getHighScoresButton() {
		if (HighScoresButton == null) {
			HighScoresButton = new JButton();
			HighScoresButton.setText("High Scores");
		}
		return HighScoresButton;
	}

	private JPanel getStartUpPanel() {
		if (StartUpPanel == null) {
			StartUpPanel = new JPanel();
			StartUpPanel.setBackground(new Color(170, 170, 255));
			StartUpPanel.setVisible(true);
			StartUpPanel.setLayout(new GroupLayout());
			StartUpPanel.add(getMonopolyLabel(), new Constraints(new Leading(437, 10, 10), new Leading(65, 10, 10)));
			StartUpPanel.add(getHighScoresButton(), new Constraints(new Leading(346, 12, 12), new Leading(357, 10, 10)));
			StartUpPanel.add(getInstructionsButton(), new Constraints(new Leading(639, 12, 12), new Leading(357, 12, 12)));
			StartUpPanel.add(getExitButton(), new Constraints(new Leading(639, 97, 10, 10), new Leading(236, 30, 12, 12)));
			StartUpPanel.add(getNewGameButton(), new Constraints(new Leading(346, 102, 12, 12), new Leading(237, 29, 12, 12)));
		}
		return StartUpPanel;
	}

	private JLabel getMonopolyLabel() {
		if (MonopolyLabel == null) {
			MonopolyLabel = new JLabel();
			MonopolyLabel.setFont(new Font("Impact", Font.BOLD, 48));
			MonopolyLabel.setText("Monopoly");
		}
		return MonopolyLabel;
	}

	private JButton getExitButton() {
		if (ExitButton == null) {
			ExitButton = new JButton();
			ExitButton.setText("Exit");
			//ExitButton.addActionListener(this);
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
			}
		});
	}

}
