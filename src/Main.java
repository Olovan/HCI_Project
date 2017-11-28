import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

class Main  {
	public static void main (String[] args) throws Exception{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		/*
		try {
	        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
			 //UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
			//UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
			
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }   
		*/
		MainMenu frame = new MainMenu();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
