import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Automation {

	private ImageIcon compIcon, userIcon;
	private String compName;
	
	//Automation - EASY level (random moves, no logic at all)
	int compEasy(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o){
			
		boolean isMoved = false;
		Random rnd = new Random();	
		
		while(!isMoved){
					
			int i = rnd.nextInt(btnArray.size());
			System.out.println("i: " + i);
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
			
			System.out.println("looping");
		}
		
		return comp_moves;
	}

	//Automation - MEDIUM level
	int compMedium(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o) {

		// TODO Auto-generated method stub
		
		return comp_moves;
	}
		
	//Automation - HARD level
	int compHard(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o) {
		
		String method = "compHard";
		
		if(comboBox.getSelectedIndex() == 1){
			
			compIcon = o;
			userIcon = x;
			compName = "O";
		}
		else{
			
			compIcon = x;
			userIcon = o;
			compName = "X";
		}
		
		if(comp_moves == 0){
			
			if(btnArray.get(0).getIcon() == null){
								
				int i = 0;
				btnArray.get(0).setIcon(compIcon);
				btnArray.get(0).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(4).getIcon() == null){
				
				int i = 4;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			
		}
		else if(comp_moves == 1){
			
			if(compIcon == x){
				
				comp_moves = compCrazy(btnArray, comboBox, comp_moves, x, o);
			}
			else if(compIcon == o){
				
				if(btnArray.get(0).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == userIcon &&
					btnArray.get(4).getIcon() == compIcon && 
					btnArray.get(3).getIcon() == null){ //Case #
						
						int i = 3;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
				}
				else if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(2).getIcon() == userIcon &&
						btnArray.get(4).getIcon() == compIcon && 
						btnArray.get(1).getIcon() == null){ //Case #
						
						int i = 1;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
				}
				else if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(1).getIcon() == userIcon &&
						btnArray.get(4).getIcon() == compIcon && 
						btnArray.get(2).getIcon() == null){ //Case #
						
						int i = 2;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
				}
				else{
				
					error(method, comp_moves);
				}
			}
		}
		else if(comp_moves == 2){
	
			if(compIcon == x){
				
				comp_moves = compCrazy(btnArray, comboBox, comp_moves, x, o);
			}
			else if(compIcon == o){
				
				if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(6).getIcon() == userIcon &&
						btnArray.get(4).getIcon() == compIcon && 
						btnArray.get(3).getIcon() == compIcon &&
						(btnArray.get(1).getIcon() == null && btnArray.get(7).getIcon() == null)){ //Case #
					
					if(btnArray.get(1).getIcon() == null){
						
						int i = 1;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
					}
					else if(btnArray.get(7).getIcon() == null){
						
						int i = 7;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
					}					

						
				}
				else if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(2).getIcon() == userIcon &&
						btnArray.get(4).getIcon() == compIcon && 
						btnArray.get(1).getIcon() == compIcon){ //Case #
							
					if(btnArray.get(3).getIcon() == null){
						
						int i = 3;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
					}
					else if(btnArray.get(5).getIcon() == null){
						
						int i = 5;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
					}
						
				}
				else if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(1).getIcon() == userIcon &&
						btnArray.get(4).getIcon() == compIcon && 
						btnArray.get(2).getIcon() == compIcon){ //Case #
						
					
					if(btnArray.get(6).getIcon() == null){
						
						int i = 2;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
						
					}
					else if(btnArray.get(3).getIcon() == null){
						
						int i = 3;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
						
					}
						
				}
				else{
					
					error(method, comp_moves);
				}			
			}		
		}
		else if(comp_moves == 3){
						
			if(compIcon == x){
				
				comp_moves = compCrazy(btnArray, comboBox, comp_moves, x, o);
			}
			else if(compIcon == o){
				
				if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(6).getIcon() == userIcon &&
						btnArray.get(4).getIcon() == compIcon && 
						btnArray.get(3).getIcon() == compIcon &&
						(btnArray.get(7).getIcon() == null || btnArray.get(2).getIcon() == null || btnArray.get(8).getIcon() == null)){ //Case #
					
					if(btnArray.get(6).getIcon() == userIcon && btnArray.get(7).getIcon() == userIcon && btnArray.get(8).getIcon() == null){
						
						int i = 8;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
					}
					else if(btnArray.get(7).getIcon() == null){
						
						int i = 7;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
					}					

						
				}
				else if(btnArray.get(0).getIcon() == userIcon &&
						btnArray.get(2).getIcon() == userIcon &&
						btnArray.get(5).getIcon() == userIcon &&
						btnArray.get(1).getIcon() == compIcon && 
						btnArray.get(4).getIcon() == compIcon &&
						btnArray.get(3).getIcon() == compIcon){ //Case #
						
					
					if(btnArray.get(7).getIcon() == null){
						
						int i = 7;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
						
					}
					else if(btnArray.get(8).getIcon() == null){
						
						int i = 8;
						btnArray.get(i).setIcon(compIcon);
						btnArray.get(i).setName(compName);
						log(method, comp_moves, i);
						comp_moves++;
						
					}
					
				}
				else{
					
					error(method, comp_moves);
				}	
			}
			
		}
		else if(comp_moves == 4){
			
			int counter = 0;
			
			for(JButton btn : btnArray){
				
				if(btn.getIcon() == null){
					
					counter++;
				}
			}
			
			if(counter == 1){
				
				for(JButton btn : btnArray){
					
					if(btn.getIcon() == null){
						
						btn.setIcon(x);
						btn.setName(LableList.comboItems[1]);
						comp_moves++;
						break;
					}
				}
			}
		}	
		else{
			
			error(method, comp_moves);
		}
		
		
		return comp_moves;
	}
	
	
	//Automation - CRAZY level
	int compCrazy(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o) {

		String method = "compCrazy";
		compIcon = x;
		userIcon = o;
		compName = LableList.comboItems[1];
			
		if(comp_moves == 0){
				
			if(btnArray.get(0).getIcon() == null){
				
				int i = 0;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}			
			else{
				
				error(method, comp_moves);
			}
			
		}
		else if(comp_moves == 1){
				
			if(btnArray.get(0).getIcon() == compIcon &&
				btnArray.get(1).getIcon() == userIcon && 
				btnArray.get(6).getIcon() == null){ //Case #0
				
				int i = 6;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == userIcon &&
					btnArray.get(8).getIcon() == null){ //Case #1
				
				int i = 8;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(3).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #2
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(5).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #3
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(6).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #4
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(7).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #5
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == null){ //Case #6
				
				int i = 6;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(8).getIcon() == null){ //Case #7
				
				int i = 8;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(5).getIcon() == null){ //Case #8
				
				int i = 5;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(7).getIcon() == null){ //Case #9
				
				int i = 7;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else{
				
				error(method, comp_moves);
			}
			
		}
		else if(comp_moves == 2){
					
			if(btnArray.get(0).getIcon() == compIcon && 
				btnArray.get(6).getIcon() == compIcon &&
				btnArray.get(1).getIcon() == userIcon &&
				btnArray.get(3).getIcon() == userIcon &&
				(btnArray.get(4).getIcon() == null || btnArray.get(3).getIcon() == null)){ //Case #0
				
				if(btnArray.get(4).getIcon() == null){
					
					int i = 4;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(3).getIcon() == null){
					
					int i = 3;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == userIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == null){ //Case #1
				
				int i = 6;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(3).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon &&
					btnArray.get(8).getIcon() == null){ //Case #2
				
				int i = 8;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(5).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == null){ //Case #3
				
				int i = 6;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(6).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon &&
					btnArray.get(8).getIcon() == null){ //Case #4				
				
				int i = 8;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(7).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon &&
					btnArray.get(4).getIcon() == null){ //Case #5
				
				int i = 4;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(6).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == userIcon &&
					btnArray.get(3).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #6
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == null){ //Case #7
				
				int i = 6;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(5).getIcon() == compIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #8
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(7).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == null){ //Case #9
				
				int i = 6;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == null){ //Case #10
				
				int i = 2;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon &&
					btnArray.get(7).getIcon() == null){ //Case #11
				
				int i = 7;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(7).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == null){ //Case #12
				
				int i = 1;
				btnArray.get(i).setIcon(compIcon);
				btnArray.get(i).setName(compName);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else{
				
				error(method, comp_moves);
			}
			
		}
		else if(comp_moves == 3){
						
			if(btnArray.get(0).getIcon() == compIcon && 
				btnArray.get(4).getIcon() == compIcon &&
				btnArray.get(6).getIcon() == compIcon && 
				btnArray.get(1).getIcon() == userIcon &&
				btnArray.get(3).getIcon() == userIcon){ //Case #0
								
				if(btnArray.get(2).getIcon() == null){
					
					int i = 2;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(8).getIcon() == null){
					
					int i = 8;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}				
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(6).getIcon() == compIcon &&
					btnArray.get(2).getIcon() == userIcon &&
					btnArray.get(4).getIcon() == userIcon){ //Case #1
				
				
				if(btnArray.get(3).getIcon() == null){
					
					int i = 3;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(7).getIcon() == null){
					
					int i = 7;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(8).getIcon() == compIcon &&
					btnArray.get(3).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon ){ //Case #2
				
				
				if(btnArray.get(5).getIcon() == null){
					
					int i = 5;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(4).getIcon() == null){
					
					int i = 4;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(6).getIcon() == compIcon &&
					btnArray.get(1).getIcon() == userIcon &&
					btnArray.get(5).getIcon() == userIcon){ //Case #3
				
				if(btnArray.get(3).getIcon() == null){
					
					int i = 3;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(4).getIcon() == null){
					
					int i = 4;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(8).getIcon() == compIcon &&
					btnArray.get(6).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon){ //Case #4
				
				if(btnArray.get(5).getIcon() == null){
					
					int i = 5;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(4).getIcon() == null){
					
					int i = 4;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(4).getIcon() == compIcon &&
					btnArray.get(7).getIcon() == userIcon &&
					btnArray.get(1).getIcon() == userIcon){ //Case #5
				
				if(btnArray.get(8).getIcon() == null){
					
					int i = 8;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(6).getIcon() == null){
					
					int i = 6;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(6).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == userIcon &&
					btnArray.get(3).getIcon() == userIcon){ //Case #6
				
				if(btnArray.get(1).getIcon() == null){
					
					int i = 1;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(4).getIcon() == null){
					
					int i = 4;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon &&
					btnArray.get(6).getIcon() == compIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == userIcon){ //Case #7
				
				if(btnArray.get(3).getIcon() == null){
					
					int i = 3;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(7).getIcon() == null){
					
					int i = 7;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(5).getIcon() == compIcon &&
					btnArray.get(2).getIcon() == compIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == userIcon){ //Case #8
				
				if(btnArray.get(8).getIcon() == null){
					
					int i = 8;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(1).getIcon() == null){
					
					int i = 1;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(7).getIcon() == compIcon && 
					btnArray.get(6).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(2).getIcon() == userIcon){ //Case #9
								
				if(btnArray.get(8).getIcon() == null){
					
					int i = 8;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(3).getIcon() == null){
					
					int i = 3;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == compIcon && 
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(6).getIcon() == userIcon){ //Case #10
				
				if(btnArray.get(1).getIcon() == null){
					
					int i = 1;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(5).getIcon() == null){
					
					int i = 5;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(8).getIcon() == compIcon &&
					btnArray.get(7).getIcon() == compIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					(btnArray.get(6).getIcon() == userIcon || btnArray.get(2).getIcon() == userIcon || btnArray.get(3).getIcon() == userIcon || btnArray.get(5).getIcon() == userIcon) &&
					btnArray.get(1).getIcon() == userIcon){ //Case #11

				if(btnArray.get(6).getIcon() == null){
					
					int i = 6;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(2).getIcon() == null){
					
					int i = 2;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				
			}
			else if(btnArray.get(0).getIcon() == compIcon && 
					btnArray.get(1).getIcon() == compIcon &&
					btnArray.get(8).getIcon() == compIcon && 
					btnArray.get(2).getIcon() == userIcon &&
					btnArray.get(4).getIcon() == userIcon &&
					btnArray.get(7).getIcon() == userIcon){ //Case #12
				
				if(btnArray.get(6).getIcon() == null){
					
					int i = 6;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}
				else if(btnArray.get(3).getIcon() == null){
					
					int i = 3;
					btnArray.get(i).setIcon(compIcon);
					btnArray.get(i).setName(compName);
					log(method, comp_moves, i);
					comp_moves++;
				}				
				
			}
			else{
				
				error(method, comp_moves);
			}
			
		}
		else{
			
			for(JButton btn : btnArray){
				
				if(btn.getIcon() == null){
					
					btn.setIcon(x);
					btn.setName(LableList.comboItems[1]);
					comp_moves++;
					break;
				}
			}
		}
		
		return comp_moves;
	}
	
	//Error dialog
	private void error(String method, int comp_moves) {
					
		System.out.println(String.format("ERROR: computer does not know what to do. Method name: %s. Index: %d", method, comp_moves));			
	}
	
	//Error dialog
	private void log(String method, int comp_moves, int i) {
		
		System.out.println(String.format("LOG: Method name: %s. Move: %d. Index: %d", method, comp_moves, i));			
	}

	
	
	//END OF CLASS
}
