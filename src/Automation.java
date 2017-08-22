import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Automation {

	
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
		
		return comp_moves;
	}
	
	//Automation - CRAZY level
	int compCrazy(ArrayList<JButton> btnArray, JComboBox comboBox, JCheckBox chkBoxRandom, int comp_moves, ImageIcon x, ImageIcon o) {

		String method = "compCrazy";
		
		comboBox.setEnabled(false);
		chkBoxRandom.setSelected(false);
		chkBoxRandom.setEnabled(false);
		comboBox.setSelectedIndex(2);
			
		if(comp_moves == 0){
				
			if(btnArray.get(0).getIcon() == null){
				
				int i = 0;
				btnArray.get(0).setIcon(x);
				btnArray.get(0).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}			
			else{
				
				error(method, comp_moves);
			}
		}
		else if(comp_moves == 1){
				
			if(btnArray.get(8).getIcon() == null && btnArray.get(7).getIcon() == null){
				
				int i = 8;
				btnArray.get(8).setIcon(x);
				btnArray.get(8).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(2).getIcon() == null){
				
				int i = 2;
				btnArray.get(2).setIcon(x);
				btnArray.get(2).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(6).getIcon() == null){
				
				int i = 6;
				btnArray.get(6).setIcon(x);
				btnArray.get(6).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else{
				
				error(method, comp_moves);
			}
			
		}
		else if(comp_moves == 2){
			
			if((btnArray.get(6).getIcon() == null && btnArray.get(4).getIcon() == null && btnArray.get(1).getIcon() == null) || 
				(btnArray.get(2).getIcon() == o && btnArray.get(4).getIcon() == o && btnArray.get(6).getIcon() == null) ||
				(btnArray.get(0).getIcon() == x && btnArray.get(8).getIcon() ==x && btnArray.get(6).getIcon() == null && btnArray.get(4).getIcon() != o)){
				
				int i = 6;
				btnArray.get(6).setIcon(x);
				btnArray.get(6).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(8).getIcon() == null && 
					btnArray.get(4).getIcon() == null && 
					btnArray.get(1).getIcon() == null){
				
				int i = 8;
				btnArray.get(8).setIcon(x);
				btnArray.get(8).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(4).getIcon() == null){
				
				int i = 4;
				btnArray.get(4).setIcon(x);
				btnArray.get(4).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if((btnArray.get(2).getIcon() == null && btnArray.get(1).getIcon() == null && btnArray.get(4).getIcon() != o) || 
					(btnArray.get(4).getIcon() == o && btnArray.get(6).getIcon() == o)){
				
				int i = 2;
				btnArray.get(2).setIcon(x);
				btnArray.get(2).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(1).getIcon() == null && 
					btnArray.get(4).getIcon() != o){
				
				int i = 1;
				btnArray.get(1).setIcon(x);
				btnArray.get(1).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if((btnArray.get(7).getIcon() == null && btnArray.get(4).getIcon() != o) || 
					(btnArray.get(1).getIcon() == o && btnArray.get(4).getIcon() == o)){
				
				int i = 7;
				btnArray.get(7).setIcon(x);
				btnArray.get(7).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(5).getIcon() == null && btnArray.get(6).getIcon() != o){
				
				int i = 5;
				btnArray.get(5).setIcon(x);
				btnArray.get(5).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(3).getIcon() == null){
				
				int i = 3;
				btnArray.get(3).setIcon(x);
				btnArray.get(3).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else{
				
				error(method, comp_moves);
			}
			
		}
		else if(comp_moves == 3){
			
			if(btnArray.get(0).getIcon() == x && btnArray.get(6).getIcon() == x && btnArray.get(3).getIcon() == null){
				
				int i = 3;
				btnArray.get(3).setIcon(x);
				btnArray.get(3).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(2).getIcon() == x && btnArray.get(8).getIcon() == x && btnArray.get(5).getIcon() == null){
				
				int i = 5;
				btnArray.get(5).setIcon(x);
				btnArray.get(5).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if((btnArray.get(6).getIcon() == x && btnArray.get(8).getIcon() == x && btnArray.get(7).getIcon() == null) ||
					(btnArray.get(6).getIcon() == o && btnArray.get(8).getIcon() == o && btnArray.get(7).getIcon() == null) || 
					(btnArray.get(5).getIcon() == x && btnArray.get(8).getIcon() == x && btnArray.get(2).getIcon() != o && btnArray.get(7).getIcon() == null)){
				
				int i = 7;
				btnArray.get(7).setIcon(x);
				btnArray.get(7).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == x && btnArray.get(4).getIcon() == x && btnArray.get(8).getIcon() == null){
				
				int i = 8;
				btnArray.get(8).setIcon(x);
				btnArray.get(8).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if((btnArray.get(2).getIcon() == x && btnArray.get(4).getIcon() == x && btnArray.get(6).getIcon() == null) || 
					(btnArray.get(8).getIcon() == x && btnArray.get(7).getIcon() == x && btnArray.get(6).getIcon() == null) ||
					(btnArray.get(4).getIcon() == o && btnArray.get(2).getIcon() == o && btnArray.get(6).getIcon() == null) ||
					(btnArray.get(1).getIcon() == o && btnArray.get(4).getIcon() == o && btnArray.get(7).getIcon() == null)){
				
				int i = 6;
				btnArray.get(6).setIcon(x);
				btnArray.get(6).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(2).getIcon() == x && btnArray.get(6).getIcon() == x && btnArray.get(4).getIcon() == null){
				
				int i = 4;
				btnArray.get(i).setIcon(x);
				btnArray.get(i).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(0).getIcon() == x && btnArray.get(2).getIcon() == x && btnArray.get(1).getIcon() == null){
				
				int i = 1;
				btnArray.get(i).setIcon(x);
				btnArray.get(i).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
			}
			else if(btnArray.get(2).getIcon() == null){
				
				int i = 2;
				btnArray.get(2).setIcon(x);
				btnArray.get(2).setName(LableList.comboItems[1]);
				log(method, comp_moves, i);
				comp_moves++;
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
