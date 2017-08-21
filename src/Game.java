import javax.swing.JOptionPane;

public class Game {

	public static void main(String[] args){
		
		try{
			
			GameUI game = new GameUI();
		}
		catch(Exception ex){
			
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);			
		}
		
	}
	
}
