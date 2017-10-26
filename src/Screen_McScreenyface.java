import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen_McScreenyface extends JFrame {
	public Screen_McScreenyface(Dashboard callbackNumberYouAreTryingToReachIsBusy) {
		this.setSize(640, 480);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel muhPanel = new JPanel();
		getContentPane().add(muhPanel, BorderLayout.CENTER);
		muhPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel banner = new JLabel("<html><h1>Euler's Abacus</h1></html>");
		c.gridx = 0;
		c.gridy = 0;
		muhPanel.add(banner, c);
				
		JLabel bannerJr = new JLabel("Probably better than beads on a stick...");
		c.gridx = 0;
		c.gridy = 1;
		muhPanel.add(bannerJr, c);
		
		JPanel doNotWantShitTonight = new JPanel();
		doNotWantShitTonight.setLayout(new FlowLayout());
		c.gridx = 0;
		c.gridy = 2;
		muhPanel.add(doNotWantShitTonight, c);
		
		JButton tweedleLogin = new JButton("Login");
		JButton tweedleRegister = new JButton("Register");
		doNotWantShitTonight.add(tweedleLogin);
		doNotWantShitTonight.add(tweedleRegister);
		
		tweedleLogin.addActionListener((e) -> {this.setVisible(false); callbackNumberYouAreTryingToReachIsBusy.setVisible(true);});
		tweedleRegister.addActionListener((e) -> {this.setVisible(false); callbackNumberYouAreTryingToReachIsBusy.setVisible(true);});
	}
}
