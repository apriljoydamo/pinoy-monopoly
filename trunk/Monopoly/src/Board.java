import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;


//VS4E -- DO NOT REMOVE THIS LINE!
public class Board extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel jlBoardPanel;
	private JLabel jlFreeParking;
	private JLabel jlMonopolyMiddle;
	private JLabel jlGotoJail, jlGo;
	private JLabel jlNlex;
	private JLabel jlChance1;
	private JLabel jlNationalBookStore;
	private JLabel jlTrinoma;
	private JLabel jlLrt;
	private JLabel jlEdsa;
	private JLabel jlMagsaysayBridge;
	private JLabel jlMaynilad;
	private JLabel jlStarCity;
	private JLabel jlLandMark;
	private JLabel jlGlorietta;
	private JLabel jlCommunityChest;
	private JLabel jlGreenBelt;
	private JLabel jlNorthEdsaStation;
	private JLabel jlChance2;
	private JLabel jlBoracayIsland;
	private JLabel jlSuperTax;
	private JLabel jlMoa;
	private JLabel jlAyalaAve;
	private JLabel jlCommunityChest1;
	private JLabel jlMakatiAve;
	private JLabel jlIncomeTax;
	private JLabel jlAyalaAveStation;
	private JLabel jlPuregold;
	private JLabel jlChance3;
	private JLabel jlRizalPark;
	private JLabel jlDelaRosaSt;
	private JLabel jlChinaTown;
	private JLabel jlC5Road;
	private JLabel jlCommunityChest2;
	private JLabel jlIntramuros;
	private JLabel jlBuendiaStation;
	private JLabel jlWalterMart;
	private JLabel jlSlex;
	private JLabel jlMeralco;
	private JLabel jlShopwise;
	private JPanel jDicePanel;
	private JButton jRollButton;
	private JLabel jlDice1o1, jlDice1o2, jlDice1o3, jlDice1o4, jlDice1o5, jlDice1o6, jlDice2o1, jlDice2o2, jlDice2o3, jlDice2o4, jlDice2o5, jlDice2o6;
	
	static Random generator = new  Random();
	private static int thro, length = 6;
	

	private JPanel jPlayersPanel;
	private JLabel jlJustVisiting;
	private JLabel jlInJail;
	private JPanel jPanel0;
	private JTabbedPane jTabbedPane0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public Board() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJlBoardPanel(), new Constraints(new Leading(0, 600, 10, 10), new Bilateral(0, 0, 0)));
		add(getJPlayersPanel(), new Constraints(new Bilateral(606, 1, 0), new Leading(0, 485, 117, 117)));
		add(getJDicePanel(), new Constraints(new Bilateral(606, 0, 0), new Bilateral(491, 0, 0)));
		setSize(827, 602);
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.setBackground(new Color(0, 255, 64));
			jTabbedPane0.addTab("jPanel0", getJPanel0());
		}
		return jTabbedPane0;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBackground(Color.lightGray);
			jPanel0.setLayout(new GroupLayout());
		}
		return jPanel0;
	}

	private JLabel getJLInJail() {
		if (jlInJail == null) {
			jlInJail = new JLabel();
			jlInJail.setIcon(new ImageIcon(getClass().getResource("/In Jail.png")));
		}
		return jlInJail;
	}

	private JLabel getJLJustVisiting() {
		if (jlJustVisiting == null) {
			jlJustVisiting = new JLabel();
			jlJustVisiting.setIcon(new ImageIcon(getClass().getResource("/Just Visiting.png")));
		}
		return jlJustVisiting;
	}

	private JPanel getJPlayersPanel() {
		if (jPlayersPanel == null) {
			jPlayersPanel = new JPanel();
			jPlayersPanel.setBackground(Color.black);
			jPlayersPanel.setLayout(new GroupLayout());
			jPlayersPanel.add(getJTabbedPane0(), new Constraints(new Bilateral(12, 12, 5), new Trailing(12, 465, 10, 10)));
		}
		return jPlayersPanel;
	}

	private JLabel getJLDice2o6() {
		if (jlDice2o6 == null) {
			jlDice2o6 = new JLabel();
			jlDice2o6.setIcon(new ImageIcon(getClass().getResource("/six.png")));
			jlDice2o6.setVisible(false);
		}
		return jlDice2o6;
	}

	private JLabel getJLDice1o6() {
		if (jlDice1o6 == null) {
			jlDice1o6 = new JLabel();
			jlDice1o6.setIcon(new ImageIcon(getClass().getResource("/six.png")));
			jlDice1o6.setVisible(false);
		}
		return jlDice1o6;
	}

	private JLabel getJLDice2o5() {
		if (jlDice2o5 == null) {
			jlDice2o5 = new JLabel();
			jlDice2o5.setIcon(new ImageIcon(getClass().getResource("/five.png")));
			jlDice2o5.setVisible(false);
		}
		return jlDice2o5;
	}

	private JLabel getJLDice1o5() {
		if (jlDice1o5 == null) {
			jlDice1o5 = new JLabel();
			jlDice1o5.setIcon(new ImageIcon(getClass().getResource("/five.png")));
			jlDice1o5.setVisible(false);
		}
		return jlDice1o5;
	}

	private JLabel getJLDice2o4() {
		if (jlDice2o4 == null) {
			jlDice2o4 = new JLabel();
			jlDice2o4.setIcon(new ImageIcon(getClass().getResource("/four.png")));
			jlDice2o4.setVisible(false);
		}
		return jlDice2o4;
	}

	private JLabel getJLDice1o4() {
		if (jlDice1o4 == null) {
			jlDice1o4 = new JLabel();
			jlDice1o4.setIcon(new ImageIcon(getClass().getResource("/four.png")));
			jlDice1o4.setVisible(false);
		}
		return jlDice1o4;
	}

	private JLabel getJLDice2o3() {
		if (jlDice2o3 == null) {
			jlDice2o3 = new JLabel();
			jlDice2o3.setIcon(new ImageIcon(getClass().getResource("/three.png")));
			jlDice2o3.setVisible(false);
		}
		return jlDice2o3;
	}

	private JLabel getJLDice1o3() {
		if (jlDice1o3 == null) {
			jlDice1o3 = new JLabel();
			jlDice1o3.setIcon(new ImageIcon(getClass().getResource("/three.png")));
			jlDice1o3.setVisible(false);
		}
		return jlDice1o3;
	}

	private JLabel getJLDice2o2() {
		if (jlDice2o2 == null) {
			jlDice2o2 = new JLabel();
			jlDice2o2.setIcon(new ImageIcon(getClass().getResource("/two.png")));
			jlDice2o2.setVisible(false);
		}
		return jlDice2o2;
	}

	private JLabel getJLDice1o2() {
		if (jlDice1o2 == null) {
			jlDice1o2 = new JLabel();
			jlDice1o2.setIcon(new ImageIcon(getClass().getResource("/two.png")));
			jlDice1o2.setVisible(false);
		}
		return jlDice1o2;
	}

	private JLabel getJLDice1o1() {
		if (jlDice1o1 == null) {
			jlDice1o1 = new JLabel();
			jlDice1o1.setIcon(new ImageIcon(getClass().getResource("/one.png")));
			jlDice1o1.setVisible(false);
		}
		return jlDice1o1;
	}

	private JLabel getJLDice2o1() {
		if (jlDice2o1 == null) {
			jlDice2o1 = new JLabel();
			jlDice2o1.setIcon(new ImageIcon(getClass().getResource("/one.png")));
			jlDice2o1.setVisible(false);
		}
		return jlDice2o1;
	}

	private JPanel getJDicePanel() {
		if (jDicePanel == null) {
			jDicePanel = new JPanel();
			jDicePanel.setBackground(Color.black);
			jDicePanel.setLayout(new GroupLayout());
			jDicePanel.add(getJRollButton(), new Constraints(new Leading(69, 10, 10), new Leading(73, 12, 12)));
			jDicePanel.add(getJLDice2o1(), new Constraints(new Leading(126, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice1o1(), new Constraints(new Leading(58, 10, 10), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice1o2(), new Constraints(new Leading(58, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice2o2(), new Constraints(new Leading(126, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice1o3(), new Constraints(new Leading(58, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice2o3(), new Constraints(new Leading(126, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice1o4(), new Constraints(new Leading(58, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice2o4(), new Constraints(new Leading(126, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice1o5(), new Constraints(new Leading(58, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice2o5(), new Constraints(new Leading(126, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice1o6(), new Constraints(new Leading(58, 12, 12), new Leading(15, 12, 12)));
			jDicePanel.add(getJLDice2o6(), new Constraints(new Leading(126, 12, 12), new Leading(15, 12, 12)));
		}
		return jDicePanel;
	}

	public static int returnRandomValue() {
		return thro = 1 + generator.nextInt(length);
	}

	private JButton getJRollButton() {
		if (jRollButton == null) {
			jRollButton = new JButton();
			jRollButton.setText("Roll Button");
			
		//	Board di = new Board();
		//	di.initComponents();
			
		//	int s = 0, t = 0;
		//	int total;
			
			jRollButton.addMouseListener(new MouseAdapter() {
	
				int s = 0, t = 0;
				int total;
	
				public void mouseClicked(MouseEvent event) {
					jRollButtonMouseMouseClicked(event);
					
						for (int i = 0; i < 1; ++i){
							s = Board.returnRandomValue();
							
							if (s == 1)
								jlDice1o1.setVisible(true);
							if (s == 2)
								jlDice1o2.setVisible(true);
							if (s == 3)
								jlDice1o3.setVisible(true);
							if (s == 4)
								jlDice1o4.setVisible(true);
							if (s == 5)
								jlDice1o5.setVisible(true);
							if (s == 6)
								jlDice1o6.setVisible(true);
						}
						
						for (int i = 0; i < 1; ++i) {
							t = Board.returnRandomValue();
						 	
							if (t == 1)
								jlDice2o1.setVisible(true);
							if (t == 2)
								jlDice2o2.setVisible(true);
							if (t == 3)	
								jlDice2o3.setVisible(true);
							if (t == 4)
								jlDice2o4.setVisible(true);
							if (t == 5)
								jlDice2o5.setVisible(true);
							if (t == 6)
								jlDice2o6.setVisible(true);
						}
						
						total = s + t;
						System.out.println("Total is" + total);
				}
			});
		}
		return jRollButton;
	}

	//public static int returnRandomValue() {
	//	return thro = 1 + generator.nextInt (length);
	//}
	
	
/*	public void actionPerformed(ActionEvent e) {
		
		Board di = new Board();
		di.initComponents();
		
		int s = 0, t = 0, total;
		
		
		if ("button1".equals(e.getActionCommand())) {
			
			for (int i = 0; i < 1; ++i ) {
				s = di.returnRandomValue();
				
				if (s == 1)
					jlDice1o1.setVisible(true);
				if (s == 2)
					jlDice1o2.setVisible(true);
				if (s == 3)
					jlDice1o3.setVisible(true);
				if (s == 4)
					jlDice1o4.setVisible(true);
				if (s == 5)
					jlDice1o5.setVisible(true);
				if (s == 6)
					jlDice1o6.setVisible(true);
			}
			
			for (int i = 0; i < 1; ++i) {
				t = di.returnRandomValue();
				
				if (t == 1)
					jlDice2o1.setVisible(true);
				if (t == 2)
					jlDice2o2.setVisible(true);
				if (t == 3)
					jlDice2o3.setVisible(true);
				if (t == 4)
					jlDice2o4.setVisible(true);
				if (t == 5)
					jlDice2o5.setVisible(true);
				if (t == 6)
					jlDice2o6.setVisible(true);
			}
		}
		
		total = s + t;
		System.out.println("Total is " + total );
	}
	
	/* -------------------------------------------------------------------------------------- */

	private JLabel getJLShopwise() {
		if (jlShopwise == null) {
			jlShopwise = new JLabel();
			jlShopwise.setIcon(new ImageIcon(getClass().getResource("/Shopwise.png")));
		}
		return jlShopwise;
	}

	private JLabel getJLMeralco() {
		if (jlMeralco == null) {
			jlMeralco = new JLabel();
			jlMeralco.setIcon(new ImageIcon(getClass().getResource("/Meralco.png")));
		}
		return jlMeralco;
	}

	private JLabel getJLSlex() {
		if (jlSlex == null) {
			jlSlex = new JLabel();
			jlSlex.setIcon(new ImageIcon(getClass().getResource("/SLEX.png")));
		}
		return jlSlex;
	}

	private JLabel getJLWalterMart() {
		if (jlWalterMart == null) {
			jlWalterMart = new JLabel();
			jlWalterMart.setIcon(new ImageIcon(getClass().getResource("/Walter Mart.png")));
		}
		return jlWalterMart;
	}

	private JLabel getJLBuendiaStation() {
		if (jlBuendiaStation == null) {
			jlBuendiaStation = new JLabel();
			jlBuendiaStation.setIcon(new ImageIcon(getClass().getResource("/Buendia Station.png")));
		}
		return jlBuendiaStation;
	}

	private JLabel getJLIntramuros() {
		if (jlIntramuros == null) {
			jlIntramuros = new JLabel();
			jlIntramuros.setIcon(new ImageIcon(getClass().getResource("/Intramuros.png")));
		}
		return jlIntramuros;
	}

	private JLabel getJLCommunityChest2() {
		if (jlCommunityChest2 == null) {
			jlCommunityChest2 = new JLabel();
			jlCommunityChest2.setIcon(new ImageIcon(getClass().getResource("/Community Chest 2.png")));
		}
		return jlCommunityChest2;
	}

	private JLabel getJLC5Road() {
		if (jlC5Road == null) {
			jlC5Road = new JLabel();
			jlC5Road.setIcon(new ImageIcon(getClass().getResource("/C-5 road.png")));
		}
		return jlC5Road;
	}

	private JLabel getJLChinaTown() {
		if (jlChinaTown == null) {
			jlChinaTown = new JLabel();
			jlChinaTown.setIcon(new ImageIcon(getClass().getResource("/China Town.png")));
		}
		return jlChinaTown;
	}

	private JLabel getJLDelaRosaSt() {
		if (jlDelaRosaSt == null) {
			jlDelaRosaSt = new JLabel();
			jlDelaRosaSt.setIcon(new ImageIcon(getClass().getResource("/Dela Rosa.png")));
		}
		return jlDelaRosaSt;
	}

	private JLabel getJLRizalPark() {
		if (jlRizalPark == null) {
			jlRizalPark = new JLabel();
			jlRizalPark.setIcon(new ImageIcon(getClass().getResource("/Rizal Park.png")));
		}
		return jlRizalPark;
	}

	private JLabel getJLChance3() {
		if (jlChance3 == null) {
			jlChance3 = new JLabel();
			jlChance3.setIcon(new ImageIcon(getClass().getResource("/Chance 1.png")));
		}
		return jlChance3;
	}

	private JLabel getJLPuregold() {
		if (jlPuregold == null) {
			jlPuregold = new JLabel();
			jlPuregold.setIcon(new ImageIcon(getClass().getResource("/Puregold.png")));
		}
		return jlPuregold;
	}

	private JLabel getJLAyalaAveStation() {
		if (jlAyalaAveStation == null) {
			jlAyalaAveStation = new JLabel();
			jlAyalaAveStation.setIcon(new ImageIcon(getClass().getResource("/Ayala Avenue Station.png")));
		}
		return jlAyalaAveStation;
	}

	private JLabel getJLIncomeTax() {
		if (jlIncomeTax == null) {
			jlIncomeTax = new JLabel();
			jlIncomeTax.setIcon(new ImageIcon(getClass().getResource("/Income Tax.png")));
		}
		return jlIncomeTax;
	}

	private JLabel getJLMakatiAve() {
		if (jlMakatiAve == null) {
			jlMakatiAve = new JLabel();
			jlMakatiAve.setIcon(new ImageIcon(getClass().getResource("/Makati Avenue.png")));
		}
		return jlMakatiAve;
	}

	private JLabel getJLCommunityChest1() {
		if (jlCommunityChest1 == null) {
			jlCommunityChest1 = new JLabel();
			jlCommunityChest1.setIcon(new ImageIcon(getClass().getResource("/Community Chest 1.png")));
		}
		return jlCommunityChest1;
	}
	
	private JLabel getJLAyalaAve() {
		if (jlAyalaAve == null) {
			jlAyalaAve = new JLabel();
			jlAyalaAve.setIcon(new ImageIcon(getClass().getResource("/Ayala Avenue.png")));
		}
		return jlAyalaAve;
	}

	private JLabel getJLMoa() {
		if (jlMoa == null) {
			jlMoa = new JLabel();
			jlMoa.setIcon(new ImageIcon(getClass().getResource("/SM Mall of Asia.png")));
		}
		return jlMoa;
	}

	private JLabel getJLSuperTax() {
		if (jlSuperTax == null) {
			jlSuperTax = new JLabel();
			jlSuperTax.setIcon(new ImageIcon(getClass().getResource("/Super Tax.png")));
		}
		return jlSuperTax;
	}

	private JLabel getJLBoracayIsland() {
		if (jlBoracayIsland == null) {
			jlBoracayIsland = new JLabel();
			jlBoracayIsland.setIcon(new ImageIcon(getClass().getResource("/Boracay Island.png")));
		}
		return jlBoracayIsland;
	}

	private JLabel getJLChance2() {
		if (jlChance2 == null) {
			jlChance2 = new JLabel();
			jlChance2.setIcon(new ImageIcon(getClass().getResource("/Chance 3.png")));
		}
		return jlChance2;
	}

	private JLabel getJLNorthEdsaStation() {
		if (jlNorthEdsaStation == null) {
			jlNorthEdsaStation = new JLabel();
			jlNorthEdsaStation.setIcon(new ImageIcon(getClass().getResource("/North Edsa Station.png")));
		}
		return jlNorthEdsaStation;
	}

	private JLabel getJLGreenbelt() {
		if (jlGreenBelt == null) {
			jlGreenBelt = new JLabel();
			jlGreenBelt.setIcon(new ImageIcon(getClass().getResource("/Greenbelt.png")));
		}
		return jlGreenBelt;
	}

	private JLabel getJLCommunityChest() {
		if (jlCommunityChest == null) {
			jlCommunityChest = new JLabel();
			jlCommunityChest.setIcon(new ImageIcon(getClass().getResource("/Community Chest 3.png")));
		}
		return jlCommunityChest;
	}

	private JLabel getJLGlorietta() {
		if (jlGlorietta == null) {
			jlGlorietta = new JLabel();
			jlGlorietta.setIcon(new ImageIcon(getClass().getResource("/Glorietta.png")));
		}
		return jlGlorietta;
	}

	private JLabel getJLLandMark() {
		if (jlLandMark == null) {
			jlLandMark = new JLabel();
			jlLandMark.setIcon(new ImageIcon(getClass().getResource("/Landmark.png")));
		}
		return jlLandMark;
	}
	
	private JLabel getJLStarCity() {
		if (jlStarCity == null) {
			jlStarCity = new JLabel();
			jlStarCity.setIcon(new ImageIcon(getClass().getResource("/Star City.png")));
		}
		return jlStarCity;
	}
	
	private JLabel getJLMagsaysayBridge() {
		if (jlMagsaysayBridge == null) {
			jlMagsaysayBridge = new JLabel();
			jlMagsaysayBridge.setIcon(new ImageIcon(getClass().getResource("/Magsaysay Bridge.png")));
		}
		return jlMagsaysayBridge;
	}

	private JLabel getJLEdsa() {
		if (jlEdsa == null) {
			jlEdsa = new JLabel();
			jlEdsa.setIcon(new ImageIcon(getClass().getResource("/EDSA.png")));
		}
		return jlEdsa;
	}
	
	private JLabel getJLLrt() {
		if (jlLrt == null) {
			jlLrt = new JLabel();
			jlLrt.setIcon(new ImageIcon(getClass().getResource("/Taft Avenue Station.png")));
		}
		return jlLrt;
	}

	private JLabel getJLMaynilad() {
		if (jlMaynilad == null) {
			jlMaynilad = new JLabel();
			jlMaynilad.setIcon(new ImageIcon(getClass().getResource("/Maynilad Water Station.png")));
		}
		return jlMaynilad;
	}

	private JLabel getJLTrinoma() {
		if (jlTrinoma == null) {
			jlTrinoma = new JLabel();
			jlTrinoma.setIcon(new ImageIcon(getClass().getResource("/Trinoma.png")));
		}
		return jlTrinoma;
	}

	private JLabel getJLNationalBookStore() {
		if (jlNationalBookStore == null) {
			jlNationalBookStore = new JLabel();
			jlNationalBookStore.setIcon(new ImageIcon(getClass().getResource("/National Bookstore.png")));
		}
		return jlNationalBookStore;
	}

	private JLabel getJLChance1() {
		if (jlChance1 == null) {
			jlChance1 = new JLabel();
			jlChance1.setIcon(new ImageIcon(getClass().getResource("/Chance 2.png")));
		}
		return jlChance1;
	}

	private JLabel getJLNlex() {
		if (jlNlex == null) {
			jlNlex = new JLabel();
			jlNlex.setIcon(new ImageIcon(getClass().getResource("/NLEX.png")));
		}
		return jlNlex;
	}

	private JLabel getJLGotoJail() {
		if (jlGotoJail == null) {
			jlGotoJail = new JLabel();
			jlGotoJail.setIcon(new ImageIcon(getClass().getResource("/Go to Jail.png")));
		}
		return jlGotoJail;
	}
	
	private JLabel getJLGo() {
		if(jlGo == null) {
			jlGo = new JLabel();
			jlGo.setIcon(new ImageIcon(getClass().getResource("/Go.png")));
		}
		return jlGo;
	}

	private JPanel getJlBoardPanel() {
		if (jlBoardPanel == null) {
			jlBoardPanel = new JPanel();
			jlBoardPanel.setBackground(Color.black);
			jlBoardPanel.setLayout(new GroupLayout());
			jlBoardPanel.add(getJLFreeParking(), new Constraints(new Leading(0, 12, 12), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLGo(), new Constraints(new Leading(508, 12, 12), new Leading(506, 10, 10)));
			jlBoardPanel.add(getJLNlex(), new Constraints(new Leading(92, 12, 12), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLMonopolyMiddle(), new Constraints(new Leading(92, 12, 12), new Leading(92, 10, 10)));
			jlBoardPanel.add(getJLChance1(), new Constraints(new Leading(139, 10, 10), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLNationalBookStore(), new Constraints(new Leading(185, 10, 10), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLTrinoma(), new Constraints(new Leading(231, 10, 10), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLLrt(), new Constraints(new Leading(277, 12, 12), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLEdsa(), new Constraints(new Leading(323, 10, 10), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLMagsaysayBridge(), new Constraints(new Leading(370, 10, 10), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLMaynilad(), new Constraints(new Leading(416, 10, 10), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLStarCity(), new Constraints(new Leading(462, 12, 12), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLGotoJail(), new Constraints(new Leading(508, 12, 12), new Leading(0, 12, 12)));
			jlBoardPanel.add(getJLLandMark(), new Constraints(new Leading(508, 12, 12), new Leading(92, 12, 12)));
			jlBoardPanel.add(getJLGlorietta(), new Constraints(new Leading(508, 12, 12), new Leading(138, 10, 10)));
			jlBoardPanel.add(getJLCommunityChest(), new Constraints(new Leading(508, 12, 12), new Leading(184, 10, 10)));
			jlBoardPanel.add(getJLGreenbelt(), new Constraints(new Leading(508, 12, 12), new Leading(231, 10, 10)));
			jlBoardPanel.add(getJLNorthEdsaStation(), new Constraints(new Leading(508, 12, 12), new Leading(276, 12, 12)));
			jlBoardPanel.add(getJLChance2(), new Constraints(new Leading(508, 12, 12), new Leading(322, 10, 10)));
			jlBoardPanel.add(getJLBoracayIsland(), new Constraints(new Leading(508, 12, 12), new Leading(368, 10, 10)));
			jlBoardPanel.add(getJLSuperTax(), new Constraints(new Leading(508, 12, 12), new Leading(414, 10, 10)));
			jlBoardPanel.add(getJLMoa(), new Constraints(new Leading(508, 12, 12), new Leading(462, 12, 12)));
			jlBoardPanel.add(getJLAyalaAve(), new Constraints(new Leading(462, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLCommunityChest1(), new Constraints(new Leading(416, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLMakatiAve(), new Constraints(new Leading(370, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLIncomeTax(), new Constraints(new Leading(323, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLAyalaAveStation(), new Constraints(new Leading(277, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLPuregold(), new Constraints(new Leading(231, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLChance3(), new Constraints(new Leading(185, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLRizalPark(), new Constraints(new Leading(139, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLChinaTown(), new Constraints(new Leading(0, 12, 12), new Leading(92, 12, 12)));
			jlBoardPanel.add(getJLC5Road(), new Constraints(new Leading(0, 12, 12), new Leading(138, 12, 12)));
			jlBoardPanel.add(getJLCommunityChest2(), new Constraints(new Leading(0, 12, 12), new Leading(184, 12, 12)));
			jlBoardPanel.add(getJLIntramuros(), new Constraints(new Leading(0, 12, 12), new Leading(231, 12, 12)));
			jlBoardPanel.add(getJLBuendiaStation(), new Constraints(new Leading(0, 12, 12), new Leading(276, 12, 12)));
			jlBoardPanel.add(getJLWalterMart(), new Constraints(new Leading(0, 12, 12), new Leading(322, 12, 12)));
			jlBoardPanel.add(getJLSlex(), new Constraints(new Leading(0, 12, 12), new Leading(368, 12, 12)));
			jlBoardPanel.add(getJLMeralco(), new Constraints(new Leading(0, 12, 12), new Leading(414, 12, 12)));
			jlBoardPanel.add(getJLShopwise(), new Constraints(new Leading(0, 12, 12), new Leading(462, 12, 12)));
			jlBoardPanel.add(getJLDelaRosaSt(), new Constraints(new Leading(92, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLJustVisiting(), new Constraints(new Leading(0, 12, 12), new Leading(506, 12, 12)));
			jlBoardPanel.add(getJLInJail(), new Constraints(new Leading(0, 12, 12), new Leading(506, 12, 12)));
		}
		return jlBoardPanel;
	}

	private JLabel getJLFreeParking() {
		if (jlFreeParking == null) {
			jlFreeParking = new JLabel();
			jlFreeParking.setIcon(new ImageIcon(getClass().getResource("/Free Parking.png")));
			jlFreeParking.setVisible(true);
		}
		return jlFreeParking;
	}

	private JLabel getJLMonopolyMiddle() {
		if(jlMonopolyMiddle == null) {
			jlMonopolyMiddle = new JLabel();
			jlMonopolyMiddle.setIcon(new ImageIcon(getClass().getResource("/Mid.png")));
			jlMonopolyMiddle.setVisible(true);
		}
		return jlMonopolyMiddle;
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
				Board frame = new Board();
				frame.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
				frame.setTitle("Board");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void jRollButtonMouseMouseClicked(MouseEvent event) {
	}

}
