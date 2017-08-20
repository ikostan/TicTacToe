import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameUI extends JFrame{
	
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	private JButton[] btnArray;
	
	private final String TITLE ="Tic Tac Toe";
	private final String START = "START";
	private final String RESET = "RESET";
	private final String CLOSE = "CLOSE";
	private final String BTN = "button";
	private final String SCORE = "Score:";
	private final String zeroLbl = "0:0";
	
	private final String closeMeessage = "Are you sure you want to exit?";
	private final String resetMeessage = "Are you sure you want to reset the game?";
	
	private JButton btnClose, btnReset, btnStart;
	private JLabel lblScore, lblHeader;
	private JComboBox comboBox;
	
	private final int btnSize = 90;
	private final int btnSpace = 30;
	private int X, Y;
	
	
	public GameUI() {
		
		this.setSize((4 * btnSpace) + (3 * btnSize), (4 * btnSpace) + (3 * btnSize) + (4 * btnSpace));
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(TITLE);
		getContentPane().setLayout(null);
		
		btnArray = new JButton[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
				
		setBtns();
		setCloseBtn();
		setResetBtn();
		setStartBtn();
		setComboBox();
		setHeaderLbl();
		setScoreLbl();
				
		this.setVisible(true);
	}
	
	
	//Set game buttons
	private void setBtns(){
		
		X = btnSpace;
		Y = btnSpace;
		int i = 0;
		
		for(JButton btn : btnArray){
			
			btn = new JButton("");
			btn.setBounds(X, Y, btnSize, btnSize);
			btn.setName(String.format("%d", i));
			btn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					System.out.println(((JButton) arg0.getSource()).getName());
				}
							
			});
			
			getContentPane().add(btn);
			
			if(X == btnSize * 3){
				
				X = btnSpace;
				Y += btnSize + btnSpace;
			}
			else{
				
				X += btnSize + btnSpace;				
			}
			
			i++;		
		}
		
		this.repaint();

	}
	
	//Set CLOSE button
	private void setCloseBtn(){
		
		btnClose = new JButton(CLOSE);
		btnClose.setBounds(270, 424, 90, 23);
		btnClose.setName(CLOSE + " " + BTN);
		btnClose.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());
				exit();
			}
						
		});
		getContentPane().add(btnClose);
	}
	
	//Close app
	protected void exit() {

		int dialogButton = JOptionPane.showConfirmDialog(this, closeMeessage, "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
		
		if(dialogButton == 0){
			
			System.exit(0);
		}		
	}

	//Set CLOSE button
	private void setResetBtn(){
			
		btnReset = new JButton(RESET);
		btnReset.setBounds(150, 424, 90, 23);
		btnReset.setName(RESET  + " " + BTN);
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());
				reset();
			}
						
		});
		getContentPane().add(btnReset);
	}
	
	//Reset dialog
	private void reset() {
		
		int dialogButton = JOptionPane.showConfirmDialog(this, resetMeessage, "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
		
		if(dialogButton == 0){
			
			setBtns();
		}		
	}
	
	//Set START button
	private void setStartBtn(){
		
		btnStart = new JButton(START);
		btnStart.setBounds(30, 424, 90, 23);
		btnStart.setName(START + " " + BTN);
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());

				//TODO:
			}
						
		});
		getContentPane().add(btnStart);
	}
	
	//Set ComboBox
	private void setComboBox(){
		
		comboBox = new JComboBox();
		comboBox.setBounds(30, 390, 90, 20);
		getContentPane().add(comboBox);
	}
		
	//Set "Score" label
	private void setHeaderLbl(){
		
		lblHeader = new JLabel(SCORE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(150, 390, 90, 23);
		getContentPane().add(lblHeader);
	}
	
	//Set "Score" label
	private void setScoreLbl(){
		
		lblScore = new JLabel(zeroLbl);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(270, 390, 90, 20);
		getContentPane().add(lblScore);
	}
	
	
	
	//END OF CLASS	
}
