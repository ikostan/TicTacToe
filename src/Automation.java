import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Automation {

	
	//Automation - EASY level (random moves, no logic at all)
	int compEasy(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o){
			
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
		
		return comp_moves;
	}

	//Automation - MEDIUM level
	int compMedium(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o) {
		// TODO Auto-generated method stub
		
		return comp_moves;
	}
		
	//Automation - HARD level
	int compHard(ArrayList<JButton> btnArray, JComboBox comboBox, int comp_moves, ImageIcon x, ImageIcon o) {

		comboBox.setEnabled(false);
		comboBox.setSelectedIndex(2);
			
		if(comp_moves == 0){
				
			btnArray.get(4).setIcon(x);
			btnArray.get(4).setName(LableList.comboItems[1]);
			comp_moves++;
		}
		else{
				
				
		}
		
		return comp_moves;
	}
	
	
	//END OF CLASS
}
