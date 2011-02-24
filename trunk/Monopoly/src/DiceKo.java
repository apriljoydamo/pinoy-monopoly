import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;


//VS4E -- DO NOT REMOVE THIS LINE!
public class DiceKo extends JFrame {
	
	Random generator = new Random();
	public int thro;
	public int length = 6;
	private static final long serialVersionUID = 1L;
	private static JLabel jlDice1o1, jlDice2o1, jlDice1o2, jlDice2o2, jlDice1o3, jlDice2o3, jlDice1o4, jlDice2o4, jlDice1o5, jlDice2o5, jlDice1o6, jlDice2o6;
	private JButton jButtonRollDice;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public DiceKo() {
		initComponents();
	}
	
	public int returnRandomValue(){
		return thro = 1 + generator.nextInt ( length );
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getjButtonRollDice(), new Constraints(new Leading(117, 10, 10), new Leading(193, 10, 10)));
		add(getjlDice1o1(), new Constraints(new Leading(43, 10, 10), new Leading(45, 10, 10)));
		add(getjlDice2o1(), new Constraints(new Leading(179, 10, 10), new Leading(45, 12, 12)));
		add(getjlDice1o2(), new Constraints(new Leading(43, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice2o2(), new Constraints(new Leading(179, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice1o3(), new Constraints(new Leading(43, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice2o3(), new Constraints(new Leading(179, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice1o4(), new Constraints(new Leading(43, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice2o4(), new Constraints(new Leading(179, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice1o5(), new Constraints(new Leading(43, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice2o5(), new Constraints(new Leading(179, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice1o6(), new Constraints(new Leading(43, 12, 12), new Leading(45, 12, 12)));
		add(getjlDice2o6(), new Constraints(new Leading(179, 12, 12), new Leading(45, 12, 12)));
		setSize(320, 240);
	}

	private JLabel getjlDice2o6() {
		if (jlDice2o6 == null) {
			jlDice2o6 = new JLabel();
			jlDice2o6.setIcon(new ImageIcon(getClass().getResource("/dice6.jpg")));
			jlDice2o6.setVisible(false);
		}
		return jlDice2o6;
	}

	private JLabel getjlDice1o6() {
		if (jlDice1o6 == null) {
			jlDice1o6 = new JLabel();
			jlDice1o6.setText("jLabel0");
			jlDice1o6.setVisible(false);
		}
		return jlDice1o6;
	}

	private JLabel getjlDice2o5() {
		if (jlDice2o5 == null) {
			jlDice2o5 = new JLabel();
			jlDice2o5.setIcon(new ImageIcon(getClass().getResource("/dice5.jpg")));
			jlDice2o5.setVisible(false);
		}
		return jlDice2o5;
	}

	private JLabel getjlDice1o5() {
		if (jlDice1o5 == null) {
			jlDice1o5 = new JLabel();
			jlDice1o5.setIcon(new ImageIcon(getClass().getResource("/dice5.jpg")));
			jlDice1o5.setVisible(false);
		}
		return jlDice1o5;
	}

	private JLabel getjlDice2o4() {
		if (jlDice2o4 == null) {
			jlDice2o4 = new JLabel();
			jlDice2o4.setIcon(new ImageIcon(getClass().getResource("/dice4.jpg")));
			jlDice2o4.setVisible(false);
		}
		return jlDice2o4;
	}

	private JLabel getjlDice1o4() {
		if (jlDice1o4 == null) {
			jlDice1o4 = new JLabel();
			jlDice1o4.setIcon(new ImageIcon(getClass().getResource("/dice4.jpg")));
			jlDice1o4.setVisible(false);
		}
		return jlDice1o4;
	}

	private JLabel getjlDice2o3() {
		if (jlDice2o3 == null) {
			jlDice2o3 = new JLabel();
			jlDice2o3.setIcon(new ImageIcon(getClass().getResource("/dice3.jpg")));
			jlDice2o3.setVisible(false);
		}
		return jlDice2o3;
	}

	private JLabel getjlDice1o3() {
		if (jlDice1o3 == null) {
			jlDice1o3 = new JLabel();
			jlDice1o3.setIcon(new ImageIcon(getClass().getResource("/dice3.jpg")));
			jlDice1o3.setVisible(false);
		}
		return jlDice1o3;
	}
	
	private JLabel getjlDice2o2(){
		if(jlDice2o2 == null){
			jlDice2o2 = new JLabel();
			jlDice2o2.setIcon(new ImageIcon(getClass().getResource("/dice3.jpg")));
			jlDice2o2.setVisible(false);
		}
		return jlDice2o2;
	}

	private JLabel getjlDice1o2() {
		if (jlDice1o2 == null) {
			jlDice1o2 = new JLabel();
			jlDice1o2.setIcon(new ImageIcon(getClass().getResource("/dice2.jpg")));
			jlDice1o2.setVisible(false);
		}
		return jlDice1o2;
	}

	private JLabel getjlDice1o1() {
		if (jlDice1o1 == null) {
			jlDice1o1 = new JLabel();
			jlDice1o1.setIcon(new ImageIcon(getClass().getResource("/dice1.jpg")));
			jlDice1o1.setVisible(false);
		}
		return jlDice1o1;
	}

	private JLabel getjlDice2o1() {
		if (jlDice2o1 == null) {
			jlDice2o1 = new JLabel();
			jlDice2o1.setIcon(new ImageIcon(getClass().getResource("/dice1.jpg")));
			jlDice2o1.setVisible(false);
		}
		return jlDice2o1;
	}

	private JButton getjButtonRollDice() {
		if (jButtonRollDice == null) {
			jButtonRollDice = new JButton();
			jButtonRollDice.setText("Roll Dice");
			jButtonRollDice.setActionCommand("Roll Dice");
			
			jButtonRollDice.addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent event) {
					jButtonRollDiceActionActionPerformed(event);
				}
			});
		}
		return jButtonRollDice;
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
	 * @param event 
	 */
	public static void main(String[] args) {
		
		DiceKo di = new DiceKo();
		di.initComponents();
		
		ActionEvent event = null;
		di.jButtonRollDiceActionActionPerformed(event);
		/*
		int total;
		int s = 0, t = 0;
		
			for(int i = 0; i < 1; ++i ){
				s = di.returnRandomValue();
				
				if(s == 1)
					jlDice1o1.setVisible(true);
				if(s == 2)
					jlDice1o2.setVisible(true);
				if(s == 3)
					jlDice1o3.setVisible(true);
				if(s ==4)
					jlDice1o4.setVisible(true);
				if(s == 5)
					jlDice1o5.setVisible(true);
				if(s == 6)
					jlDice1o6.setVisible(true);	
				
			}
			
			for(int i = 0; i < 1; ++i){
				t = di.returnRandomValue();
				if( t == 1)
					jlDice2o1.setVisible(true);
				if(t == 2)
					jlDice2o2.setVisible(true);
				if(t == 3)
					jlDice2o3.setVisible(true);
				if(t == 4)
					jlDice2o4.setVisible(true);
				if(t == 5)
					jlDice2o5.setVisible(true);
				if(t == 6)
					jlDice2o6.setVisible(true);
				
			}
			
			total = s + t;
			System.out.println("Total is " + total); */
			
			
		
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				DiceKo frame = new DiceKo();
				frame.setDefaultCloseOperation(DiceKo.EXIT_ON_CLOSE);
				frame.setTitle("DiceKo");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void jButtonRollDiceActionActionPerformed(ActionEvent event) {
		
		DiceKo di = new DiceKo();
		di.initComponents();
		
		int total;
		int s = 0, t = 0;
		
		for(int i = 0; i < 1; i++){
			s = di.returnRandomValue();
			
			if(s == 1)
				jlDice1o1.setVisible(true);
			if(s == 2)
				jlDice1o2.setVisible(true);
			if(s == 3)
				jlDice1o3.setVisible(true);
			if(s == 4)
				jlDice1o4.setVisible(true);
			if(s == 5)
				jlDice1o5.setVisible(true);
			if(s == 6)
				jlDice1o6.setVisible(true);
		}
		
		for(int i = 0; i < 1; i++){
			t = di.returnRandomValue();
			
			if(t == 1)
				jlDice2o1.setVisible(true);
			if(t == 2)
				jlDice2o2.setVisible(true);
			if(t == 3)
				jlDice2o3.setVisible(true);
			if(t == 4)
				jlDice2o4.setVisible(true);
			if(t == 5)
				jlDice2o5.setVisible(true);
			if(t == 6)
				jlDice2o6.setVisible(true);
		}
		
		total = s + t;
		System.out.println("Total is " + total);
	
	
	}
	}
 
