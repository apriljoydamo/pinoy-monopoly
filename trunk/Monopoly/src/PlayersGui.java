import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class PlayersGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton NewGameButton;
	private JButton ExitButton;
	private JLabel jLabel0;
	private JPanel jPanel0;
	private JButton HighScoresButton;
	private JButton InstructionsButton;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public PlayersGui() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Bilateral(0, 0, 0), new Bilateral(0, 0, 0)));
		setSize(1038, 677);
	}

	private JButton getJInstructionsButton() {
		if (InstructionsButton == null) {
			InstructionsButton = new JButton();
			InstructionsButton.setText("Instructions");
		}
		return InstructionsButton;
	}

	private JButton getJHighScoresButton() {
		if (HighScoresButton == null) {
			HighScoresButton = new JButton();
			HighScoresButton.setText("High Scores");
		}
		return HighScoresButton;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBackground(new Color(170, 170, 255));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJLabel0(), new Constraints(new Leading(437, 10, 10), new Leading(65, 10, 10)));
			jPanel0.add(getJHighScoresButton(), new Constraints(new Leading(346, 12, 12), new Leading(357, 10, 10)));
			jPanel0.add(getJInstructionsButton(), new Constraints(new Leading(639, 12, 12), new Leading(357, 12, 12)));
			jPanel0.add(getJExitButton(), new Constraints(new Leading(639, 97, 10, 10), new Leading(236, 30, 12, 12)));
			jPanel0.add(getJNewGameButton(), new Constraints(new Leading(346, 102, 12, 12), new Leading(237, 29, 12, 12)));
		}
		return jPanel0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setFont(new Font("Impact", Font.BOLD, 48));
			jLabel0.setText("Monopoly");
		}
		return jLabel0;
	}

	private JButton getJExitButton() {
		if (ExitButton == null) {
			ExitButton = new JButton();
			ExitButton.setText("Exit");
		}
		return ExitButton;
	}

	private JButton getJNewGameButton() {
		if (NewGameButton == null) {
			NewGameButton = new JButton();
			NewGameButton.setText("New Game");
		}
		return NewGameButton;
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
