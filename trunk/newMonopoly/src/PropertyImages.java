import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class PropertyImages extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lBuyGIF;
	static int a;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	
	
	@SuppressWarnings("static-access")
	public PropertyImages(int a) {
		this.a = a;
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(8, 10, 10), new Leading(4, 10, 10)));
		setSize(372, 375);
	}

	private JLabel getJLabel0() {
		if (lBuyGIF == null) {
			lBuyGIF = new JLabel();
			switch(a){
			case 1:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/ayalaAvenue.gif")));
				System.out.println(a);
				break;
			case 3:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/makatiAvenue.gif")));
				System.out.println(a);
				break;
			case 5:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Ayala).gif")));
				System.out.println(a);
				break;
			case 6:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/puregold.gif")));
				System.out.println(a);
				break;
			case 8:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/rizalPark.gif")));
				System.out.println(a);
				break;
			case 9:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/delarosaStreet.gif")));
				System.out.println(a);
				break;
			case 11:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/shopwise.gif")));
				System.out.println(a);
				break;
			case 12:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/meralco.gif")));
				System.out.println(a);
				break;
			case 13:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/SLEX.gif")));
				System.out.println(a);
				break;
			case 14:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/walterMart.gif")));
				System.out.println(a);
				break;
			case 15:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Buendia).gif")));
				System.out.println(a);
				break;
			case 16:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/intramuros.gif")));
				System.out.println(a);
				break;
			case 18:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/C5road.gif")));
				System.out.println(a);
				break;
			case 19:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/chinaTown.gif")));
				System.out.println(a);
				break;
			case 21:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/NLEX.gif")));
				System.out.println(a);
				break;
			case 23:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/nationalBookstore.gif")));
				System.out.println(a);
				break;
			case 24:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/trinoma.gif")));
				System.out.println(a);
				break;
			case 25:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(Taft).gif")));
				System.out.println(a);
				break;
			case 26:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/EDSA.gif")));
				System.out.println(a);
				break;
			case 27:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/magsaysayBridge.gif")));
				System.out.println(a);
				break;
			case 28:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/maynilad.gif")));
				System.out.println(a);
				break;
			case 29:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/starCity.gif")));
				System.out.println(a);
				break;
			case 31:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/landmark.gif")));
				System.out.println(a);
				break;
			case 32:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/glorietta.gif")));
				System.out.println(a);
				break;
			case 34:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/greenbelt.gif")));
				System.out.println(a);
				break;
			case 35:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MRT(North).gif")));
				System.out.println(a);
				break;
			case 37:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/boracayIsland.gif")));
				System.out.println(a);
				break;
			case 39:
				lBuyGIF.setIcon(new ImageIcon(getClass().getResource("/buyProperty_images/MOA.gif")));
				System.out.println(a);
				break;
			}
		}
		return lBuyGIF;
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
