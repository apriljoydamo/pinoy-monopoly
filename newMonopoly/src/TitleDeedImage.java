import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;


//VS4E -- DO NOT REMOVE THIS LINE!
public class TitleDeedImage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pNotOwned;
	private JLabel lTitleDeed;
	private JTextField fOwner;
	private JPanel pOwned;
	private JTextField fHotels;
	private JTextField fHouses;
	Players playerOrder[] = new Players[8];
	BoardBlock bblock = new BoardBlock();
	static int x;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public TitleDeedImage() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getpNotOwned(), new Constraints(new Bilateral(-4, 0, 0), new Leading(-6, 453, 10, 10)));
		setSize(303, 445);
	}

	private JTextField getfHouses() {
		if (fHouses == null) {
			fHouses = new JTextField();
			fHouses.setBackground(new Color(0, 128, 64));
			fHouses.setEditable(false);
			fHouses.setFont(new Font("Stencil", Font.PLAIN, 16));
			fHouses.setText("Houses: ");
			fHouses.setCaretColor(Color.black);
		}
		return fHouses;
	}

	private JTextField getfHotels() {
		if (fHotels == null) {
			fHotels = new JTextField();
			fHotels.setBackground(new Color(0, 128, 64));
			fHotels.setEditable(false);
			fHotels.setFont(new Font("Stencil", Font.PLAIN, 16));
			fHotels.setText("Hotels: ");
		}
		return fHotels;
	}

	private JPanel getpOwned() {
		if (pOwned == null) {
			pOwned = new JPanel();
			pOwned.setBackground(new Color(0, 128, 64));
			pOwned.setLayout(new GroupLayout());
			pOwned.add(getfHotels(), new Constraints(new Leading(189, 10, 10), new Leading(77, 12, 12)));
			pOwned.add(getfOwner(), new Constraints(new Leading(32, 220, 12, 12), new Leading(24, 10, 10)));
			pOwned.add(getfHouses(), new Constraints(new Leading(32, 12, 12), new Leading(77, 12, 12)));
		}
		return pOwned;
	}

	private JTextField getfOwner() {
		if (fOwner == null) {
			fOwner = new JTextField();
			fOwner.setBackground(new Color(0, 128, 64));
			fOwner.setEditable(false);
			fOwner.setFont(new Font("Stencil", Font.BOLD, 16));
			fOwner.setText("Owner: ");
			fOwner.setOpaque(false);
			fOwner.setFocusable(false);
			fOwner.setRequestFocusEnabled(false);
		}
		return fOwner;
	}

	private JLabel getlTitleDeed() {
		if (lTitleDeed == null) {
			lTitleDeed = new JLabel();
			lTitleDeed.setText("lTitleDeed");
		}
		return lTitleDeed;
	}

	private JPanel getpNotOwned() {
		if (pNotOwned == null) {
			pNotOwned = new JPanel();
			pNotOwned.setBackground(new Color(128, 64, 64));
			pNotOwned.setLayout(new GroupLayout());
			pNotOwned.add(getlTitleDeed(), new Constraints(new Leading(133, 12, 12), new Leading(97, 10, 10)));
			pNotOwned.add(getpOwned(), new Constraints(new Leading(0, 306, 12, 12), new Trailing(0, 116, 125, 125)));
		}
		return pNotOwned;
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

}
