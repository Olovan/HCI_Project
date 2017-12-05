import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

class Main  {
	public static void main (String[] args) throws Exception{
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }   
		
		MainMenu frame = new MainMenu();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
