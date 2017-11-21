import javax.swing.UIManager;

class Main  {
	public static void main (String[] args) throws Exception{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		MainMenu frame = new MainMenu();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
