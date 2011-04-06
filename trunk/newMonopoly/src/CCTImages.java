import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class CCTImages extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lcChest;
	private JLabel lChance;
	private JLabel lTax;
	static int b, c, d;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	
	
	@SuppressWarnings("static-access")
	public CCTImages(int b, int c, int d) {
		this.b = b;
		this.c = c;
		this.d = d;
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(8, 10, 10), new Leading(6, 12, 12)));
		add(getJLabel1(), new Constraints(new Leading(8, 12, 12), new Leading(8, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(8, 12, 12), new Leading(6, 12, 12)));
		setSize(372, 379);
	}

	private JLabel getJLabel2() {
		if (lTax == null) {
			lTax = new JLabel();
			switch(d){
			case 0:
				break;
			case 1:
				lTax.setIcon(new ImageIcon(getClass().getResource("/tax/paid100.gif")));
				break;
			case 2:
				lTax.setIcon(new ImageIcon(getClass().getResource("/tax/paid200.gif")));
				break;
			}
			
		}
		return lTax;
	}

	private JLabel getJLabel1() {
		if (lChance == null) {
			lChance = new JLabel();
			switch(c){
			case 0:
				break;
			case 1:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Speeding-fine-P15.gif")));
				break;
			case 2:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Bank-pays-you-dividend-of-P50.gif")));
				break;
			case 3:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-Trinoma..gif")));
				break;
			case 4:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-GO.gif")));
				break;
			case 5:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Pay-school-fees-of-P150.gif")));
				break;
			case 6:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-SM-Mall-of-Asia.gif")));
				break;
			case 7:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Get-out-of-Jail-Free-Key.gif")));
				break;
			case 8:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/street-repairs.gif")));
				break;
			case 9:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/General-repairs-for-buildings.gif")));
				break;
			case 10:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Advance-to-Shopwise.gif")));
				break;
			case 11:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/take_a_trip_to_buendia_station.gif")));
				break;
			case 12:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/building_laon_matures.gif")));
				break;
			case 13:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/go_to_jail.gif")));
				break;
			case 14:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Go-back-three-spaces.gif")));
				break;
			case 15:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/Drunk-in-Charge.gif")));
				break;
			case 16:
				lChance.setIcon(new ImageIcon(getClass().getResource("/newChances/crossword_competition.gif")));
				break;
			
			}
			
		}
		return lChance;
	}

	private JLabel getJLabel0() {
		if (lcChest == null) {
			lcChest = new JLabel();
			switch(b){
			case 0:
				break;
			case 1:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/BankError.gif")));
				break;
			case 2:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/payHospital.gif")));
				break;
			case 3:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/beautyContest.gif")));
				break;
			case 4:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/incomeTax.gif")));
				break;
			case 5:
				//lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/BankError.gif")));
				break;
			case 6:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/payInsurance.gif")));
				break;
			case 7:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/saleOfStock.gif")));
				break;
			case 8:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/interestReceive.gif")));
				break;
			case 9:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/advanceToGo.gif")));
				break;
			case 10:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/ayalaAve.gif")));
				break;
			case 11:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/getOutOfJailKey.gif")));
				break;
			case 12:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/birthday.gif")));
				break;
			case 13:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/Doctorsfee.gif")));
				break;
			case 14:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/annuityMatures.gif")));
				break;
			case 15:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/goToJail.gif")));
				break;
			case 16:
				lcChest.setIcon(new ImageIcon(getClass().getResource("/Cchest/inherit.gif")));
				break;
			}
			
		}
		return lcChest;
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
