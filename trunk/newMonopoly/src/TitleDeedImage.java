import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
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
	static int intTD;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	
	@SuppressWarnings("static-access")
	public TitleDeedImage(int x,int intTD) {
		this.x = x;
		this.intTD = intTD;
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
			pOwned.setVisible(false);
		}
		return pOwned;
	}

	private JTextField getfOwner() {
		if (fOwner == null) {
			fOwner = new JTextField();
			fOwner.setBackground(new Color(0, 128, 64));
			fOwner.setEditable(false);
			fOwner.setFont(new Font("Stencil", Font.BOLD, 16));
			fOwner.setText("Owner: "+ intTD);
			fOwner.setOpaque(false);
			fOwner.setFocusable(false);
			fOwner.setRequestFocusEnabled(false);
		}
		return fOwner;
	}

	private JLabel getlTitleDeed() {
		if (lTitleDeed == null) {
			lTitleDeed = new JLabel();
			//lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Ayala Avenue.jpg")));
			switch(intTD){
			case 1:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Ayala Avenue.jpg")));
				System.out.println(intTD);
				break;
			case 3:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Makati Avenue.jpg")));
				System.out.println(intTD);
				break;
			case 5:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Ayala Avenue Station.jpg")));
				System.out.println(intTD);
				break;
			case 6:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Puregold.jpg")));
				System.out.println(intTD);
				break;
			case 8:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Rizal Park.jpg")));
				System.out.println(intTD);
				break;
			case 9:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Dela Rosa Street.jpg")));
				System.out.println(intTD);
				break;
			case 11:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Shopwise.jpg")));
				System.out.println(intTD);
				break;
			case 12:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Meralco corp.jpg")));
				System.out.println(intTD);
				break;
			case 13:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/SLEX.jpg")));
				System.out.println(intTD);
				break;
			case 14:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Walter Mart.jpg")));
				System.out.println(intTD);
				break;
			case 15:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Buendia Station.jpg")));
				System.out.println(intTD);
				break;
			case 16:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Intramuros.jpg")));
				System.out.println(intTD);
				break;
			case 18:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/C5 Road.jpg")));
				System.out.println(intTD);
				break;
			case 19:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/China town.jpg")));
				System.out.println(intTD);
				break;
			case 21:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/NLEX.jpg")));
				System.out.println(intTD);
				break;
			case 23:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/National Bookstore.jpg")));
				System.out.println(intTD);
				break;
			case 24:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Trinoma.jpg")));
				System.out.println(intTD);
				break;
			case 25:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Taft Avenue Station.jpg")));
				System.out.println(intTD);
				break;
			case 26:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/EDSA.jpg")));
				System.out.println(intTD);
				break;
			case 27:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Magsaysay Bridge.jpg")));
				System.out.println(intTD);
				break;
			case 28:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Maynilad.jpg")));
				System.out.println(intTD);
				break;
			case 29:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Star city.jpg")));
				System.out.println(intTD);
				break;
			case 31:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Landmark.jpg")));
				System.out.println(intTD);
				break;
			case 32:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Glorietta.jpg")));
				System.out.println(intTD);
				break;
			case 34:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Greenbelt.jpg")));
				System.out.println(intTD);
				break;
			case 35:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/North Edsa Station.jpg")));
				System.out.println(intTD);
				break;
			case 37:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/Boracay Island.jpg")));
				System.out.println(intTD);
				break;
			case 39:
				lTitleDeed.setIcon(new ImageIcon(getClass().getResource("/Cards (Resized)/MOA.jpg")));
				System.out.println(intTD);
				break;
			}
		}
		return lTitleDeed;
	}

	private JPanel getpNotOwned() {
		if (pNotOwned == null) {
			pNotOwned = new JPanel();
			pNotOwned.setBackground(new Color(128, 64, 64));
			pNotOwned.setLayout(new GroupLayout());
			pNotOwned.add(getpOwned(), new Constraints(new Leading(0, 306, 12, 12), new Trailing(0, 116, 125, 125)));
			pNotOwned.add(getlTitleDeed(), new Constraints(new Leading(41, 10, 10), new Leading(10, 10, 10)));
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
