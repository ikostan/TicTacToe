import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;


public class GameUI extends JFrame{
	
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	private JButton[] btnArray;
	
	private ImageIcon x, o;
	
	private JButton btnClose, btnReset, btnStart;
	private JLabel lblScore, lblHeader;
	private JComboBox comboBox;
	
	private final int btnSize = 90;
	private final int btnSpace = 30;
	private int X, Y;
	
	private boolean isGameStarted;
	
	public GameUI() {
		
		this.setSize((4 * btnSpace) + (3 * btnSize), (4 * btnSpace) + (3 * btnSize) + (4 * btnSpace));
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(LableList.TITLE);
		getContentPane().setLayout(null);
		
		btnArray = new JButton[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
		
		isGameStarted = false;
		
		setIcons();
		setBtns();
		setCloseBtn();
		setResetBtn();
		setStartBtn();
		setComboBox();
		setHeaderLbl();
		setScoreLbl();
				
		this.setVisible(true);
	}
	
	//Set image icons
	private void setIcons(){
		
		x = new ImageIcon(getClass().getResource("images/x.png"));
		o = new ImageIcon(getClass().getResource("images/o.png"));
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
			btn.setBackground(Color.WHITE);
			btn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					System.out.println(((JButton) arg0.getSource()).getName());
					
					if(!isGameStarted){
						
						info(LableList.startMessage);
					}
					else{
						
						//TODO:
					}
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
		
		btnClose = new JButton(LableList.CLOSE);
		btnClose.setBounds(270, 425, 90, 25);
		btnClose.setName(LableList.CLOSE + " " + LableList.BTN);
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

		int dialogButton = JOptionPane.showConfirmDialog(this, LableList.closeMessage, "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
		
		if(dialogButton == 0){
			
			System.exit(0);
		}		
	}

	//Set CLOSE button
	private void setResetBtn(){
			
		btnReset = new JButton(LableList.RESET);
		btnReset.setBounds(150, 425, 90, 25);
		btnReset.setName(LableList.RESET  + " " + LableList.BTN);
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());
				if(isGameStarted){
					
					reset();
				} 
				else{
					
					info(LableList.startMessage);
				}
			}
						
		});
		getContentPane().add(btnReset);
	}
	
	//Reset dialog
	private void reset() {
		
		int dialogButton = JOptionPane.showConfirmDialog(this, LableList.resetMessage, "Confirmation Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if(dialogButton == 0){
			
			setBtns();
		}		
	}
	
	//Info dialog
	private void info(String message) {
			
		JOptionPane.showMessageDialog(this, message, "Information Dialog", JOptionPane.INFORMATION_MESSAGE);			
	}

	//Set START button
	private void setStartBtn(){
		
		btnStart = new JButton(LableList.START);
		btnStart.setBounds(30, 425, 90, 25);
		btnStart.setName(LableList.START + " " + LableList.BTN);
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());
				
				//TODO:
				
				if(isGameStarted){
					
					reset();
				}
				else{
					
					isGameStarted = true;
				}
			
			}
						
		});
		getContentPane().add(btnStart);
	}
	
	//Set ComboBox
	private void setComboBox(){
		
		comboBox = new JComboBox();
		comboBox.setBounds(30, 390, 90, 25);
		getContentPane().add(comboBox);
	}
		
	//Set "Score" label
	private void setHeaderLbl(){
		
		lblHeader = new JLabel(LableList.SCORE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(150, 390, 90, 25);
		getContentPane().add(lblHeader);
	}
	
	//Set "Score" label
	private void setScoreLbl(){
		
		lblScore = new JLabel(LableList.zeroLbl);
		lblScore.setBackground(SystemColor.controlHighlight);
		lblScore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblScore.setOpaque(true); //Otherwise the background is not painted, since the default of opaque is false for JLabel.
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(270, 390, 90, 25);
		getContentPane().add(lblScore);
	}
	
	
	
	//END OF CLASS	
}
