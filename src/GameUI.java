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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.SystemColor;
import javax.swing.JCheckBox;


public class GameUI extends JFrame{
	
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	private ArrayList<JButton> btnArray;
	
	private ImageIcon x, o;
	
	private JButton btnClose, btnReset, btnStart;
	private JLabel lblScore, lblHeader, lblYou;
	
	private JComboBox comboBox, comboLevel;
	private JCheckBox chckbxPreserve;
	
	private final int btnSize = 90;
	private final int btnSpace = 30;
	private int X, Y;
	
	private final int MAX_MOVES = 5;
	private int comp_moves;
	
	private int userScore, compScore;
	private String winner;
	
	private boolean isGameStarted;
	
	
	public GameUI() {
		
		this.setSize((4 * btnSpace) + (3 * btnSize), (4 * btnSpace) + (3 * btnSize) + (5 * btnSpace));
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(LableList.TITLE);
		getContentPane().setLayout(null);
				
		isGameStarted = false;
		userScore = 0; 
		compScore = 0;
		comp_moves = 0;
		winner = "";
		
		setGUI();
				
		this.setVisible(true);
	}
	
	//Set image icons
	private void setIcons(){
		
		x = new ImageIcon(getClass().getResource("images/x.png"));
		o = new ImageIcon(getClass().getResource("images/o.png"));
	}
	
	//Set all GUI objects
	private void setGUI(){
		
		setYouLbl();
		setComboLevel();
		setIcons();
		setBtns();
		setCloseBtn();
		setResetBtn();
		setStartBtn();
		setComboBox();
		setCheckBox();
		setHeaderLbl();
		setScoreLbl();
	}
	
	//Create buttons
	private void createBtns(){
		
		btn0 = new JButton("");
		btn1 = new JButton("");
		btn2 = new JButton("");
		btn3 = new JButton("");
		btn4 = new JButton("");
		btn5 = new JButton("");
		btn6 = new JButton("");
		btn7 = new JButton("");
		btn8 = new JButton("");
		
		btnArray = new ArrayList<JButton>(Arrays.asList(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8));
	}
	
	//Set game buttons
	private void setBtns(){
		
		createBtns();
		
		X = btnSpace;
		Y = btnSpace * 2;
		
		for(int i = 0; i < btnArray.size(); i++){
			
			btnArray.get(i).setBounds(X, Y, btnSize, btnSize);
			btnArray.get(i).setName(String.format("%d", i));
			btnArray.get(i).setBackground(Color.WHITE);
			btnArray.get(i).setIcon(null);
			btnArray.get(i).addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					System.out.println("Button listener called");
					processBtn(arg0);
				}							
			});
			
			getContentPane().add(btnArray.get(i));
			
			if(X == btnSize * 3){
				
				X = btnSpace;
				Y += btnSize + btnSpace;
			}
			else{
				
				X += btnSize + btnSpace;				
			}			
		}
		
		this.validate();
		this.repaint();
	}
	
	//Set action after button was clicked
	private void processBtn(ActionEvent arg0){
		
		JButton btn = (JButton) arg0.getSource();
		System.out.println("Button clicked: " + btn.getName());
		
		if(!isGameStarted){
			
			info(LableList.startMessage);
		}
		else{
			
			if(!(btn.getName().toString().equals("X") || 
				btn.getName().toString().equals("O"))){
									
				setSingleBtn(btn);	
			}
			else{
						
				error(LableList.chooseAnotherBtn);
			}								
				
			if(testIsWin()){
				
				info(LableList.WIN);
				reset();			
			}
			else{
				
				if(isAllSet()){
					
					error(LableList.endOfGame);
					reset();
					enableBtn();
				}
				else{
					
					compGoes();
				}
				
			}		
		}
	}
	
	//Set button icon after user/computer clicks on it
	private void setSingleBtn(JButton btn){
		
		btn.setName(applayName());
		
		if(btn.getName().equals("X")){
					
			btn.setIcon(x);
		}
		else if(btn.getName().equals("O")){
					
			btn.setIcon(o);
		}
	}
	
	//Set name
	private String applayName(){

		return comboBox.getSelectedItem().toString();
	}
	
	//Set CLOSE button
	private void setCloseBtn(){
		
		btnClose = new JButton(LableList.CLOSE);
		btnClose.setBounds(270, 460, 90, 25);
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
	
	//Close application
	protected void exit() {

		int dialogButton = JOptionPane.showConfirmDialog(this, LableList.closeMessage, "Confirmation Dialog", JOptionPane.YES_NO_OPTION);
		
		if(dialogButton == 0){
			
			System.exit(0);
		}		
	}

	//Set CLOSE button
	private void setResetBtn(){
			
		btnReset = new JButton(LableList.RESET);
		btnReset.setBounds(150, 460, 90, 25);
		btnReset.setName(LableList.RESET  + " " + LableList.BTN);
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());
				
				if(isGameStarted){
					
					resetDialog();
				} 
				else{
					
					info(LableList.startMessage);
				}
			}			
		});
		
		getContentPane().add(btnReset);
	}
	
	//Show reset dialog
	private void resetDialog(){
		
		int dialogButton = JOptionPane.showConfirmDialog(this, LableList.resetMessage, "Confirmation Dialog", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if(dialogButton == 0){
			
			reset();
		}
	}
	
	//Reset dialog
	private void reset() {
		
		System.out.println("Reset all GUI objects");

		comp_moves = 0;
		
		for(int i = 0; i < btnArray.size(); i++){
				
			btnArray.get(i).setIcon(null);
			btnArray.get(i).setName(String.format("%d", i));
		}
							
		enableBtn();
				
		if(!chckbxPreserve.isSelected()){
				
			comboBox.setSelectedItem(LableList.comboItems[0]);
		}				
	}
	
	//Enable buttons
	private void enableBtn(){
		
		comboBox.setEnabled(true);
		btnStart.setEnabled(true);
		chckbxPreserve.setEnabled(true);
		comboLevel.setEnabled(true);
		isGameStarted = false;
	}
	
	//Disable buttons
	private void disableBtn(){
		
		comboBox.setEnabled(false);
		btnStart.setEnabled(false);
		chckbxPreserve.setEnabled(false);
		comboLevel.setEnabled(false);
		isGameStarted = true;
	}
	
	//Info dialog
	private void info(String message) {
			
		JOptionPane.showMessageDialog(this, message, "Information Dialog", JOptionPane.INFORMATION_MESSAGE);			
	}
	
	//Error dialog
	private void error(String message) {
				
			JOptionPane.showMessageDialog(this, message, "Information Dialog", JOptionPane.ERROR_MESSAGE);			
	}

	//Set START button
	private void setStartBtn(){
		
		btnStart = new JButton(LableList.START);
		btnStart.setBounds(30, 460, 90, 25);
		btnStart.setName(LableList.START + " " + LableList.BTN);
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(((JButton) arg0.getSource()).getName());

				if(comboLevel.getSelectedItem().toString().equals(LableList.levelItems[2])){
					
					comboBox.setEnabled(false);
					comboBox.setSelectedIndex(2);
					
					disableBtn();
					
					lblYou.setText("You: " + comboBox.getSelectedItem().toString());
									
					String btNames = "";
					for(JButton btn : btnArray){
						
						btNames += btn.getName().toString() + " ";
					}
					
					System.out.println("All buttons names: " + btNames); // DEBUG
				}
				else{
					
					if(comboBox.getSelectedItem().toString() != LableList.comboItems[0]){
						
						disableBtn();
						
						lblYou.setText("You: " + comboBox.getSelectedItem().toString());
										
						String btNames = "";
						for(JButton btn : btnArray){
							
							btNames += btn.getName().toString() + " ";
						}
						
						System.out.println("All buttons names: " + btNames); // DEBUG
						
					}
					else{
							
						comboBox.setEnabled(true);
						chckbxPreserve.setEnabled(true);
						info(LableList.comboMessage);
					}		
				}												
			}						
		});
		
		getContentPane().add(btnStart);
	}
	
	//Set ComboBox
	private void setComboBox(){
		
		comboBox = new JComboBox(LableList.comboItems);
		comboBox.setBounds(30, 420, 90, 25);
		comboBox.setEnabled(true);
		getContentPane().add(comboBox);
	}
	
	//Set CheckBox
	private void setCheckBox(){
		
		chckbxPreserve = new JCheckBox("preserve");
		chckbxPreserve.setSelected(true);
		chckbxPreserve.setBackground(Color.LIGHT_GRAY);
		chckbxPreserve.setBounds(270, 420, 90, 25);
		chckbxPreserve.setEnabled(true);
		getContentPane().add(chckbxPreserve);
	}
		
	//Set "Score" label
	private void setHeaderLbl(){
		
		lblHeader = new JLabel(LableList.SCORE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setBounds(215, 10, 45, 25);
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
		lblScore.setBounds(270, 11, 90, 25);
		getContentPane().add(lblScore);	
	}
	
	//You label
	private void setYouLbl(){
		
		lblYou = new JLabel("You:");
		lblYou.setHorizontalAlignment(SwingConstants.LEFT);
		lblYou.setBounds(30, 10, 58, 25);
		getContentPane().add(lblYou);
	}
	
	//Combo LEVEL: easy, medium, hard
	private void setComboLevel(){
		
		comboLevel = new JComboBox(LableList.levelItems);
		comboLevel.setEnabled(true);
		comboLevel.setBounds(150, 420, 90, 25);
		getContentPane().add(comboLevel);
	}
	
	//TEST CASES
	private boolean testIsWin(){
		
		boolean win = false;
				
		if(testXaxis()){
			
			win = true;
		}
		else if(testYaxis()){
			
			win = true;
		}
		else if(testDiagonal()){
			
			win = true;
		}
				
		return win;
	}
	
	//Set score
	private void setScore(String chr){
		
		if(comboBox.getSelectedItem().toString().equalsIgnoreCase(chr)){
			
			winner = comboBox.getSelectedItem().toString();
			userScore++;
		}
		else{
			
			winner = chr.toUpperCase();
			compScore++;
		}
		
		lblScore.setText(String.format("%d:%d", userScore, compScore));
		
		if(userScore > compScore){
			
			lblScore.setBackground(Color.GREEN);
		}
		else if(userScore < compScore){
			
			lblScore.setBackground(Color.RED);
		}
		else{
			
			lblScore.setBackground(SystemColor.controlHighlight);
		}
	}
	
	//X axis
	private boolean testXaxis(){
		
		boolean win = false;
				
		for(int i = 0; i < btnArray.size(); i+=3){
			
			if(btnArray.get(i).getName().toString().equals(btnArray.get(i+1).getName().toString()) && 
				btnArray.get(i).getName().toString().equals(btnArray.get(i+2).getName().toString())){
						
				win = true;
				setScore(btnArray.get(i).getName().toString());
				System.out.println("Button name: " + btnArray.get(i).getName().toString()); //DEBUG
				System.out.println("X axis wins"); //DEBUG
				break;
			}
		}
		
		return win;
	}
	
	//Y axis
	private boolean testYaxis(){
			
		boolean win = false;
					
		for(int i = 0; i < btnArray.size() / 3; i++){
			
			if(btnArray.get(i).getName().toString().equals(btnArray.get(i+3).getName().toString()) && 
				btnArray.get(i).getName().toString().equals(btnArray.get(i+6).getName().toString())){
				
				win = true;
				setScore(btnArray.get(i).getName().toString());
				System.out.println("Button name: " + btnArray.get(i).getName().toString());
				System.out.println("Y axis wins");
				break;
			}			
		}
				
		return win;
	}
	
	//Diagonals
	private boolean testDiagonal(){
		
		boolean win = false;
				
		//BUTTONS: 0,4,8					
		if(btnArray.get(0).getName().toString().equals(btnArray.get(4).getName().toString()) && 
			btnArray.get(0).getName().toString().equals(btnArray.get(8).getName().toString())){
				
			win = true;
			setScore(btnArray.get(0).getName().toString());
			System.out.println("Button name: " + btnArray.get(0).getName().toString());
			System.out.println("Diagonal axis wins");
		}
					
		//BUTTONS: 2,4,6			
		if(btnArray.get(2).getName().toString().equals(btnArray.get(4).getName().toString()) && 
			btnArray.get(2).getName().toString().equals(btnArray.get(6).getName().toString())){
						
			win = true;
			setScore(btnArray.get(2).getName().toString());
			System.out.println("Button name: " + btnArray.get(2).getName().toString());
			System.out.println("Diagonal axis wins");
		}		
						
		return win;
	}
	
	//Test is all buttons set
	private boolean isAllSet(){
		
		boolean allSet = true;
					
		for(int i = 0; i < btnArray.size(); i++){
			
			if(!(btnArray.get(i).getName().toString().equals("X") || btnArray.get(i).getName().toString().equals("O"))){
				
				allSet = false;
				break;
			}			
		}
				
		return allSet;
	}

	//Computer makes its move
	private void compGoes(){
			
		if(comboLevel.getSelectedItem().toString().equals(LableList.levelItems[0])){
			
			compEasy();
		}
		else if(comboLevel.getSelectedItem().toString().equals(LableList.levelItems[1])){
			
			compMedium();
		}
		else{
			
			compHard();
		}
			
		if(testIsWin()){
				
			if(comboBox.getSelectedItem().toString().equals(winner)){
				
				info(LableList.WIN);
			}
			else{
				
				info(LableList.LOST);
			}

			reset();		
		}
	}

	//Automation - EASY level
	private void compEasy(){
		
		boolean isMoved = false;
		
		while(!isMoved){
				
			Random rnd = new Random();
			int i = rnd.nextInt(btnArray.size() - 1) + 1;
			String name = btnArray.get(i).getName().toString();			
				
			if(!(name.equals("X") || name.equals("O"))){
					
				if(comboBox.getSelectedIndex() == 1){
						
					name = LableList.comboItems[2];
					btnArray.get(i).setIcon(o);
					System.out.println("Computer makes its move");
				}
				else if(comboBox.getSelectedIndex() == 2){
						
					name = LableList.comboItems[1];
					btnArray.get(i).setIcon(x);
					System.out.println("Computer makes its move");
				}
					
				btnArray.get(i).setName(name);
					
				isMoved = true;
				break;
			}
				
		}
	}

	//Automation - MEDIUM level
	private void compMedium() {
		// TODO Auto-generated method stub
		
	}
	
	//Automation - HARD level
	private void compHard() {

		comboBox.setEnabled(false);
		comboBox.setSelectedIndex(2);
		
		if(comp_moves == 0){
			
			btnArray.get(4).setIcon(x);
			btnArray.get(4).setName(LableList.comboItems[1]);
			comp_moves++;
		}
		else{
			
			
		}
		
	}
	
	
	//END OF CLASS
}
