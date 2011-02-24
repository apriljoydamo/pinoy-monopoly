import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class MultiplayerGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JLabel multiLabel;
	private JPanel jPanel0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public MultiplayerGui() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Leading(-6, 737, 10, 10), new Leading(-2, 409, 10, 10)));
		setSize(737, 409);
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBackground(new Color(0, 255, 128));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJPanel1(), new Constraints(new Leading(0, 739, 12, 12), new Bilateral(337, 0, 0)));
			jPanel0.add(getJLabel0(), new Constraints(new Leading(27, 10, 10), new Leading(21, 10, 10)));
		}
		return jPanel0;
	}

	private JLabel getJLabel0() {
		if (multiLabel == null) {
			multiLabel = new JLabel();
			multiLabel.setText("Multiplayer");
		}
		return multiLabel;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBackground(new Color(255, 128, 255));
			jPanel1.setLayout(new GroupLayout());
		}
		return jPanel1;
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
				MultiplayerGui frame = new MultiplayerGui();
				frame.setDefaultCloseOperation(MultiplayerGui.EXIT_ON_CLOSE);
				frame.setTitle("MultiplayerGui");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
