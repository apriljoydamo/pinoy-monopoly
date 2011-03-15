import java.awt.Color;
import java.awt.Container;
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
	private JPanel jDicePanel;
	private JButton jRollButton;
	private JLabel jlDice1o1, jlDice1o2, jlDice1o3, jlDice1o4, jlDice1o5, jlDice1o6, jlDice2o1, jlDice2o2, jlDice2o3, jlDice2o4, jlDice2o5, jlDice2o6;
	
	static Random generator = new  Random();
	private static int thro, length = 6;
	public int total;
	Players players = new Players();
	private JPanel jPlayersPanel;
	private JPanel jPanel0;
	private JTabbedPane jTabbedPane0;
	private JButton jButton0;
	private JLabel jLabel0;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JButton jButton7;
	private JButton jButton8;
	private JButton jButton9;
	private JButton jButton10;
	private JButton jButton11;
	private JButton jButton12;
	private JButton jButton13;
	private JButton jButton14;
	private JButton jButton15;
	private JButton jButton16;
	private JButton jButton17;
	private JButton jButton18;
	private JButton jButton19;
	private JButton jButton20;
	private JButton jButton21;
	private JButton jButton22;
	private JButton jButton23;
	private JButton jButton24;
	private JButton jButton25;
	private JButton jButton26;
	private JButton jButton27;
	private JPanel jPanel1;
	//private Component panel;
	//private static String String = null;
	
	private JLabel BoardMonopoly;
	public boolean isRolled = false;
	private JLabel TokenImage;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public Board() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		//add(getJlBoardPanel(), new Constraints(new Leading(0, 600, 10, 10), new Bilateral(0, 0, 0)));
		add(getJPlayersPanel(), new Constraints(new Bilateral(606, 1, 0), new Leading(0, 485, 117, 117)));
		add(getJDicePanel(), new Constraints(new Bilateral(606, 0, 0), new Bilateral(491, 0, 0)));
		add(getJPanel1(), new Constraints(new Leading(0, 600, 36, 234), new Bilateral(0, 0, 0)));
		setSize(827, 602);
	}

	public JLabel getTokenImage() {
		if (TokenImage == null) {
			TokenImage = new JLabel();
			TokenImage.setVisible(true);
			TokenImage.setBounds(90, 80, 50, 50);
			
			switch(players.LabelToken){
			case 1:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/ship_token.png")));
				break;
			case 2:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/dog_token.png")));
				break;
			case 3:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/iron_token.png")));
				break;
			case 4: 
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/shoe_token.png")));
				break;
			case 5:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/car_token.png")));
				break;
			case 6:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/thimble_token.png")));
				break;
			case 7:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/hat_token.png")));
				break;
			case 8:
				TokenImage.setIcon(new ImageIcon(getClass().getResource("/wheelbarrow_token.png")));
				break;
			}
		}
		return TokenImage;
	}

	private JLabel getBoardMonopoly() {
		if (BoardMonopoly == null) {
			BoardMonopoly = new JLabel();
			BoardMonopoly.setIcon(new ImageIcon(getClass().getResource("/MonopolyBoardFinal.png")));
		}
		return BoardMonopoly;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBackground(Color.black);
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getTokenImage(), new Constraints(new Leading(521, 10, 10), new Leading(555, 10, 10)));
			jPanel1.add(getBoardMonopoly(), new Constraints(new Leading(0, 12, 12), new Leading(4, 10, 10)));
			}
		return jPanel1;
	}

	private JButton getJButton27() {
		if (jButton27 == null) {
			jButton27 = new JButton();
			jButton27.setText("jButton27");
		}
		return jButton27;
	}

	private JButton getJButton26() {
		if (jButton26 == null) {
			jButton26 = new JButton();
			jButton26.setText("jButton26");
		}
		return jButton26;
	}

	private JButton getJButton25() {
		if (jButton25 == null) {
			jButton25 = new JButton();
			jButton25.setText("jButton25");
		}
		return jButton25;
	}

	private JButton getJButton24() {
		if (jButton24 == null) {
			jButton24 = new JButton();
			jButton24.setText("jButton24");
		}
		return jButton24;
	}

	private JButton getJButton23() {
		if (jButton23 == null) {
			jButton23 = new JButton();
			jButton23.setText("jButton23");
		}
		return jButton23;
	}

	private JButton getJButton22() {
		if (jButton22 == null) {
			jButton22 = new JButton();
			jButton22.setText("jButton22");
		}
		return jButton22;
	}

	private JButton getJButton21() {
		if (jButton21 == null) {
			jButton21 = new JButton();
			jButton21.setText("jButton21");
		}
		return jButton21;
	}

	private JButton getJButton20() {
		if (jButton20 == null) {
			jButton20 = new JButton();
			jButton20.setText("jButton20");
		}
		return jButton20;
	}

	private JButton getJButton19() {
		if (jButton19 == null) {
			jButton19 = new JButton();
			jButton19.setText("jButton19");
		}
		return jButton19;
	}

	private JButton getJButton18() {
		if (jButton18 == null) {
			jButton18 = new JButton();
			jButton18.setText("jButton18");
		}
		return jButton18;
	}

	private JButton getJButton17() {
		if (jButton17 == null) {
			jButton17 = new JButton();
			jButton17.setText("jButton17");
		}
		return jButton17;
	}

	private JButton getJButton16() {
		if (jButton16 == null) {
			jButton16 = new JButton();
			jButton16.setText("jButton16");
		}
		return jButton16;
	}

	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setText("jButton15");
		}
		return jButton15;
	}

	private JButton getJButton14() {
		if (jButton14 == null) {
			jButton14 = new JButton();
			jButton14.setText("jButton14");
		}
		return jButton14;
	}

	private JButton getJButton13() {
		if (jButton13 == null) {
			jButton13 = new JButton();
			jButton13.setText("jButton13");
		}
		return jButton13;
	}

	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setText("jButton12");
		}
		return jButton12;
	}

	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setText("jButton11");
		}
		return jButton11;
	}

	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setText("jButton10");
		}
		return jButton10;
	}

	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setText("jButton9");
		}
		return jButton9;
	}

	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setText("jButton8");
		}
		return jButton8;
	}

	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setText("jButton7");
		}
		return jButton7;
	}

	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setText("jButton6");
		}
		return jButton6;
	}

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setText("jButton5");
		}
		return jButton5;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("jButton4");
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("jButton3");
		}
		return jButton3;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("jButton2");
		}
		return jButton2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("jButton1");
		}
		return jButton1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Money:");
		}
		return jLabel0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
					
					//System.out.println("hi");
					JFrame frame = new JFrame("Sample");
					JPanel panel = new JPanel();
					
					panel.setBackground(Color.CYAN);
					ImageIcon image = new ImageIcon("Ayala Avenue.png");
					JLabel label = new JLabel(image);
					label.setIcon(image);
					panel.add(label);
					this.getContentPane().add(panel);
					  
					frame.setSize(200,200);
					frame.getContentPane().add(panel);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.pack();
					
				}

				private Container getContentPane() {
					
					return jButton0 ;
				}
					
			});
		}
		return jButton0;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.setBackground(new Color(0, 255, 64));
			jTabbedPane0.addTab("Player " + players.getPlayerName(), getJPanel0());
			System.out.println(players.getPlayerName());
		}
		return jTabbedPane0;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBackground(Color.lightGray);
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJLabel0(), new Constraints(new Leading(12, 12, 12), new Leading(33, 12, 12)));
			jPanel0.add(getJButton2(), new Constraints(new Leading(6, 40, 10, 10), new Leading(99, 12, 12)));
			jPanel0.add(getJButton3(), new Constraints(new Leading(52, 40, 12, 12), new Leading(99, 12, 12)));
			jPanel0.add(getJButton4(), new Constraints(new Leading(98, 40, 12, 12), new Leading(99, 12, 12)));
			jPanel0.add(getJButton1(), new Constraints(new Leading(52, 40, 12, 12), new Leading(67, 12, 12)));
			jPanel0.add(getJButton5(), new Constraints(new Leading(6, 40, 12, 12), new Leading(131, 12, 12)));
			jPanel0.add(getJButton6(), new Constraints(new Leading(52, 40, 12, 12), new Leading(131, 12, 12)));
			jPanel0.add(getJButton7(), new Constraints(new Leading(98, 40, 12, 12), new Leading(131, 12, 12)));
			jPanel0.add(getJButton8(), new Constraints(new Leading(6, 40, 12, 12), new Leading(163, 12, 12)));
			jPanel0.add(getJButton9(), new Constraints(new Leading(52, 40, 12, 12), new Leading(163, 12, 12)));
			jPanel0.add(getJButton0(), new Constraints(new Leading(6, 40, 12, 12), new Leading(67, 26, 12, 12)));
			jPanel0.add(getJButton10(), new Constraints(new Leading(98, 40, 12, 12), new Leading(163, 12, 12)));
			jPanel0.add(getJButton11(), new Constraints(new Leading(6, 40, 12, 12), new Leading(195, 12, 12)));
			jPanel0.add(getJButton12(), new Constraints(new Leading(52, 40, 12, 12), new Leading(195, 12, 12)));
			jPanel0.add(getJButton13(), new Constraints(new Leading(98, 40, 12, 12), new Leading(195, 12, 12)));
			jPanel0.add(getJButton14(), new Constraints(new Leading(6, 40, 12, 12), new Leading(227, 12, 12)));
			jPanel0.add(getJButton15(), new Constraints(new Leading(52, 40, 12, 12), new Leading(227, 12, 12)));
			jPanel0.add(getJButton16(), new Constraints(new Leading(98, 40, 12, 12), new Leading(227, 12, 12)));
			jPanel0.add(getJButton17(), new Constraints(new Leading(6, 40, 12, 12), new Leading(259, 12, 12)));
			jPanel0.add(getJButton18(), new Constraints(new Leading(52, 40, 12, 12), new Leading(259, 12, 12)));
			jPanel0.add(getJButton19(), new Constraints(new Leading(98, 40, 12, 12), new Leading(259, 12, 12)));
			jPanel0.add(getJButton20(), new Constraints(new Leading(6, 40, 12, 12), new Leading(291, 12, 12)));
			jPanel0.add(getJButton21(), new Constraints(new Leading(52, 40, 12, 12), new Leading(291, 12, 12)));
			jPanel0.add(getJButton22(), new Constraints(new Leading(6, 40, 12, 12), new Leading(323, 12, 12)));
			jPanel0.add(getJButton23(), new Constraints(new Leading(54, 36, 12, 12), new Leading(323, 12, 12)));
			jPanel0.add(getJButton24(), new Constraints(new Leading(6, 40, 12, 12), new Leading(355, 12, 12)));
			jPanel0.add(getJButton25(), new Constraints(new Leading(54, 36, 12, 12), new Leading(355, 12, 12)));
			jPanel0.add(getJButton26(), new Constraints(new Leading(96, 44, 12, 12), new Leading(355, 12, 12)));
			jPanel0.add(getJButton27(), new Constraints(new Leading(146, 40, 12, 12), new Leading(355, 12, 12)));
		}
		return jPanel0;
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
			jlDice2o6.setIcon(new ImageIcon(getClass().getResource("/diceSix.png")));
			jlDice2o6.setVisible(false);
		}
		return jlDice2o6;
	}

	private JLabel getJLDice1o6() {
		if (jlDice1o6 == null) {
			jlDice1o6 = new JLabel();
			jlDice1o6.setIcon(new ImageIcon(getClass().getResource("/diceSix.png")));
			jlDice1o6.setVisible(false);
		}
		return jlDice1o6;
	}

	private JLabel getJLDice2o5() {
		if (jlDice2o5 == null) {
			jlDice2o5 = new JLabel();
			jlDice2o5.setIcon(new ImageIcon(getClass().getResource("/diceFive.png")));
			jlDice2o5.setVisible(false);
		}
		return jlDice2o5;
	}

	private JLabel getJLDice1o5() {
		if (jlDice1o5 == null) {
			jlDice1o5 = new JLabel();
			jlDice1o5.setIcon(new ImageIcon(getClass().getResource("/diceFive.png")));
			jlDice1o5.setVisible(false);
		}
		return jlDice1o5;
	}

	private JLabel getJLDice2o4() {
		if (jlDice2o4 == null) {
			jlDice2o4 = new JLabel();
			jlDice2o4.setIcon(new ImageIcon(getClass().getResource("/diceFour.png")));
			jlDice2o4.setVisible(false);
		}
		return jlDice2o4;
	}

	private JLabel getJLDice1o4() {
		if (jlDice1o4 == null) {
			jlDice1o4 = new JLabel();
			jlDice1o4.setIcon(new ImageIcon(getClass().getResource("/diceFour.png")));
			jlDice1o4.setVisible(false);
		}
		return jlDice1o4;
	}

	private JLabel getJLDice2o3() {
		if (jlDice2o3 == null) {
			jlDice2o3 = new JLabel();
			jlDice2o3.setIcon(new ImageIcon(getClass().getResource("/diceThree.png")));
			jlDice2o3.setVisible(false);
		}
		return jlDice2o3;
	}

	private JLabel getJLDice1o3() {
		if (jlDice1o3 == null) {
			jlDice1o3 = new JLabel();
			jlDice1o3.setIcon(new ImageIcon(getClass().getResource("/diceThree.png")));
			jlDice1o3.setVisible(false);
		}
		return jlDice1o3;
	}

	private JLabel getJLDice2o2() {
		if (jlDice2o2 == null) {
			jlDice2o2 = new JLabel();
			jlDice2o2.setIcon(new ImageIcon(getClass().getResource("/diceTwo.png")));
			jlDice2o2.setVisible(false);
		}
		return jlDice2o2;
	}

	private JLabel getJLDice1o2() {
		if (jlDice1o2 == null) {
			jlDice1o2 = new JLabel();
			jlDice1o2.setIcon(new ImageIcon(getClass().getResource("/diceTwo.png")));
			jlDice1o2.setVisible(false);
		}
		return jlDice1o2;
	}

	private JLabel getJLDice1o1() {
		if (jlDice1o1 == null) {
			jlDice1o1 = new JLabel();
			jlDice1o1.setIcon(new ImageIcon(getClass().getResource("/diceOne.png")));
			jlDice1o1.setVisible(false);
		}
		return jlDice1o1;
	}

	private JLabel getJLDice2o1() {
		if (jlDice2o1 == null) {
			jlDice2o1 = new JLabel();
			jlDice2o1.setIcon(new ImageIcon(getClass().getResource("/diceOne.png")));
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
		return setThro(1 + generator.nextInt(length));
	}

	private JButton getJRollButton() {
		if (jRollButton == null) {
			jRollButton = new JButton();
			jRollButton.setText("Roll Button");
			isRolled = true;
			
			
		//	Board di = new Board();
		//	di.initComponents();
			
		//	int s = 0, t = 0;
		//	int total;
			
			jRollButton.addMouseListener(new MouseAdapter() {
	
				int s = 0, t = 0;
				//public int total;
	
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
						System.out.println("Total is " + total);
						
				TokenImage.setLocation(getX() - total, getY());
				}
			});
			
		}
		return jRollButton;
	}

	
	/*private JPanel getJlBoardPanel() {
		if (jlBoardPanel == null) {
			jlBoardPanel = new JPanel();
			jlBoardPanel.setVisible(false);
			jlBoardPanel.setBackground(Color.black);
			jlBoardPanel.setLayout(new GroupLayout());
			jlBoardPanel.add(getJLFreeParking(), new Constraints(new Leading(0, 12, 12), new Leading(0,12,12)));
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

	public static int setThro(int thro) {
		Board.thro = thro;
		return thro;
	}

	public static int getThro() {
		return thro;
	}

	private void jButton0MouseMouseClicked(MouseEvent event) {
	}

	/*@Override
	public void run() {
		while(isRunning){
			while(isRolling){
				TokenImage.setLocation(getX() - total, getY());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
			}
			
		}
	}*/
}


