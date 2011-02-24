import java.awt.Color;

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
import org.dyno.visual.swing.layouts.Trailing;


//VS4E -- DO NOT REMOVE THIS LINE!
public class NewGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel soloPanel;
	private JPanel playPanel;
	private JPanel multiPanel;
	private JButton soloButton;
	private JButton multiButton;
	private JButton backMenuButton;
	private JButton playButton;
	private JLabel labelNewGame;
	private JLabel soloEnterNameL;
	private JTextField soloNameField;
	private JLabel multiEnternoPlayersL;
	private JTextField multiNoPlayersField;
	private JButton multiEnterButton;
	private JButton multiClearButton;
	private JTextField multiAddNameField1, multiAddNameField2, multiAddNameField3, multiAddNameField4, multiAddNameField5, multiAddNameField6, multiAddNameField7, multiAddNameField8;
	private JLabel multiAddNameLabel;
	private JButton multiAddNameEnterButton, multiAddNameClearButton;
	private JPanel multiAddNamesPanel;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public NewGame() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getSoloPanel(), new Constraints(new Bilateral(0, 384, 323), new Leading(0, 282, 10, 10)));
		add(getJmultiPanel(), new Constraints(new Trailing(0, 382, 10, 10), new Leading(0, 282, 12, 12)));
		add(getJplayPanel(), new Constraints(new Leading(0, 786, 12, 12), new Leading(286, 12, 12)));
		add(getMultiAddNamesPanel(), new Constraints(new Leading(2, 782, 781, 781), new Leading(2, 285, 10, 10)));
		setSize(786, 382);
	}

	private JPanel getMultiAddNamesPanel() {
		if (multiAddNamesPanel == null) {
			multiAddNamesPanel = new JPanel();
			multiAddNamesPanel.setBackground(new Color(0, 255, 128));
			multiAddNamesPanel.setLayout(new GroupLayout());
			multiAddNamesPanel.add(getmultiAddNameField1(), new Constraints(new Leading(18, 191, 10, 10), new Leading(62, 10, 10)));
			multiAddNamesPanel.add(getmultiAddNameLabel(), new Constraints(new Leading(20, 10, 10), new Leading(23, 10, 10)));
			multiAddNamesPanel.add(getmultiAddNameField2(), new Constraints(new Leading(18, 190, 12, 12), new Leading(100, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameField3(), new Constraints(new Leading(18, 190, 12, 12), new Leading(138, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameField4(), new Constraints(new Leading(18, 190, 12, 12), new Leading(176, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameField5(), new Constraints(new Leading(267, 186, 10, 10), new Leading(62, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameField6(), new Constraints(new Leading(267, 186, 12, 12), new Leading(100, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameField7(), new Constraints(new Leading(267, 186, 12, 12), new Leading(140, 10, 10)));
			multiAddNamesPanel.add(getmultiAddNameField8(), new Constraints(new Leading(267, 186, 12, 12), new Leading(178, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameEnterButton(), new Constraints(new Leading(596, 10, 10), new Leading(68, 12, 12)));
			multiAddNamesPanel.add(getmultiAddNameClearButton(), new Constraints(new Leading(596, 12, 12), new Leading(123, 10, 10)));
			multiAddNamesPanel.setVisible(false);
		}
		return multiAddNamesPanel;
	}

	private JButton getmultiAddNameClearButton() {
		if (multiAddNameClearButton == null) {
			multiAddNameClearButton = new JButton();
			multiAddNameClearButton.setText("Clear");
		}
		return multiAddNameClearButton;
	}
	
	private JButton getmultiAddNameEnterButton(){
		if(multiAddNameEnterButton == null){
			multiAddNameEnterButton = new JButton();
			multiAddNameEnterButton.setText("Enter");
		}
		return multiAddNameEnterButton;
	}

	private JLabel getmultiAddNameLabel() {
		if (multiAddNameLabel == null) {
			multiAddNameLabel = new JLabel();
			multiAddNameLabel.setText("Multiplayer");
		}
		return multiAddNameLabel;
	}

	private JTextField getmultiAddNameField1() {
		if (multiAddNameField1 == null) {
			multiAddNameField1 = new JTextField();
		}
		return multiAddNameField1;
	}

	private JTextField getmultiAddNameField2(){
		if(multiAddNameField2 == null){
			multiAddNameField2 = new JTextField();
		}
		return multiAddNameField2;
	}
	
	private JTextField getmultiAddNameField3() {
		if(multiAddNameField3 == null) {
			multiAddNameField3 = new JTextField();
		}
		return multiAddNameField3;
	}
	
	private JTextField getmultiAddNameField4() {
		if(multiAddNameField4 == null){
			multiAddNameField4 = new JTextField();
		}
		return multiAddNameField4;
	}
	
	private JTextField getmultiAddNameField5() {
		if(multiAddNameField5 == null) {
			multiAddNameField5 = new JTextField();
		}
		return multiAddNameField5;
	}
	
	private JTextField getmultiAddNameField6() {
		if(multiAddNameField6 == null) {
			multiAddNameField6 = new JTextField();
		}
		return multiAddNameField6;
	}
	
	private JTextField getmultiAddNameField7() {
		if(multiAddNameField7 == null) {
			multiAddNameField7 = new JTextField();
		}
		return multiAddNameField7;
	}
	
	private JTextField getmultiAddNameField8() {
		if(multiAddNameField8 == null){
			multiAddNameField8 = new JTextField();
		}
		return multiAddNameField8;
	}
	
	private JButton getMultiClearButton() {
		if (multiClearButton == null) {
			multiClearButton = new JButton();
			multiClearButton.setText("Clear");
		}
		return multiClearButton;
	}
	
	private JButton getMultiEnterButton() {
		if(multiEnterButton == null){
			multiEnterButton = new JButton();
			multiEnterButton.setText("Enter");
		}
		return multiEnterButton;
	}

	private JLabel getMultiEnternoPlayersL() {
		if (multiEnternoPlayersL == null) {
			multiEnternoPlayersL = new JLabel();
			multiEnternoPlayersL.setText("Enter no. of Players:");
		}
		return multiEnternoPlayersL;
	}

	private JTextField getMultiNoPlayersField() {
		if (multiNoPlayersField == null) {
			multiNoPlayersField = new JTextField();
		}
		return multiNoPlayersField;
	}

	private JLabel getSoloEnterNameL() {
		if (soloEnterNameL == null) {
			soloEnterNameL = new JLabel();
			soloEnterNameL.setForeground(Color.white);
			soloEnterNameL.setText("Enter Name:");
		}
		return soloEnterNameL;
	}
	
	private JTextField getSoloNameField(){
		if(soloNameField == null) {
			soloNameField = new JTextField();
		}
		return soloNameField;
	}

	private JLabel getJlabelNewGame() {
		if (labelNewGame == null) {
			labelNewGame = new JLabel();
			labelNewGame.setText("Choose the game type that you wish to play:");
			labelNewGame.setForeground(Color.white);
		}
		return labelNewGame;
	}

	private JButton getJplayButton() {
		if (playButton == null) {
			playButton = new JButton();
			playButton.setText("Game!");
		}
		return playButton;
	}

	private JPanel getJplayPanel() {
		if (playPanel == null) {
			playPanel= new JPanel();
			playPanel.setBackground(Color.gray);
			playPanel.setLayout(new GroupLayout());
			playPanel.add(getJbackMenuButton(), new Constraints(new Trailing(12, 91, 10, 10), new Leading(35, 52, 12, 12)));
			playPanel.add(getJplayButton(), new Constraints(new Leading(12, 90, 105, 115), new Trailing(12, 52, 12, 12)));
		}
		return playPanel;
	}

	private JButton getJbackMenuButton() {
		if (backMenuButton == null) {
			backMenuButton = new JButton();
			backMenuButton.setText("Back!");
		}
		return backMenuButton;
	}

	private JPanel getSoloPanel() {
		if (soloPanel == null) {
			soloPanel = new JPanel();
			soloPanel.setBackground(Color.black);
			soloPanel.setVisible(true);
			soloPanel.setLayout(new GroupLayout());
			soloPanel.add(getJlabelNewGame(), new Constraints(new Bilateral(22, 12, 41), new Leading(12, 45, 10, 10)));
			soloPanel.add(getJsoloButton(), new Constraints(new Leading(143, 118, 10, 10), new Leading(69, 28, 12, 12)));
			soloPanel.add(getSoloEnterNameL(), new Constraints(new Bilateral(166, 156, 69), new Leading(122, 10, 10)));
			soloPanel.add(getSoloNameField(), new Constraints(new Leading(110, 184, 12, 12), new Leading(159, 10, 10)));
		}
		return soloPanel;
	}

	private JButton getJmultiButton() {
		if (multiButton == null) {
			multiButton = new JButton();
			multiButton.setText("Multiplayer");
		}
		return multiButton;
	}

	private JButton getJsoloButton() {
		if (soloButton == null) {
			soloButton = new JButton();
			soloButton.setText("Solo Player");
		}
		return soloButton;
	}

	private JPanel getJmultiPanel() {
		if (multiPanel == null) {
			multiPanel = new JPanel();
			multiPanel.setBackground(Color.orange);
			multiPanel.setVisible(true);
			multiPanel.setLayout(new GroupLayout());
			multiPanel.add(getJmultiButton(), new Constraints(new Leading(141, 140, 10, 10), new Leading(64, 30, 10, 10)));
			multiPanel.add(getMultiEnternoPlayersL(), new Constraints(new Leading(155, 12, 12), new Leading(121, 10, 10)));
			multiPanel.add(getMultiNoPlayersField(), new Constraints(new Leading(174, 74, 12, 12), new Leading(155, 12, 12)));
			multiPanel.add(getMultiEnterButton(), new Constraints(new Leading(66, 10, 10), new Leading(221, 10, 10)));
			multiPanel.add(getMultiClearButton(), new Constraints(new Leading(285, 10, 10), new Leading(221, 12, 12)));
		
		}
		return multiPanel;
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
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				NewGame frame = new NewGame();
				frame.setDefaultCloseOperation(NewGame.EXIT_ON_CLOSE);
				frame.setTitle("NewGame");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
