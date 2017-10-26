import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen_McScreenyface frame = new Screen_McScreenyface(new Dashboard());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		leftPanel.setPreferredSize(new Dimension(200, 10));
		leftPanel.setMaximumSize(new Dimension(300, 32767));
		panel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		JButton debtButton = new JButton("Add Debt");
		debtButton.setMinimumSize(new Dimension(200, 23));
		debtButton.setMaximumSize(new Dimension(200, 23));
		debtButton.setPreferredSize(new Dimension(200, 23));
		debtButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(debtButton);
		
		JButton btnAddPayment = new JButton("Add Payment");
		btnAddPayment.setPreferredSize(new Dimension(200, 23));
		btnAddPayment.setMinimumSize(new Dimension(200, 23));
		btnAddPayment.setMaximumSize(new Dimension(200, 23));
		btnAddPayment.setAlignmentX(0.5f);
		leftPanel.add(btnAddPayment);
		
		JButton btnViewStatement = new JButton("View Statement");
		btnViewStatement.setPreferredSize(new Dimension(200, 23));
		btnViewStatement.setMinimumSize(new Dimension(200, 23));
		btnViewStatement.setMaximumSize(new Dimension(200, 23));
		btnViewStatement.setAlignmentX(0.5f);
		leftPanel.add(btnViewStatement);
		
		JButton btnExportToSpreadsheet = new JButton("Export to Spreadsheet");
		btnExportToSpreadsheet.setPreferredSize(new Dimension(200, 23));
		btnExportToSpreadsheet.setMinimumSize(new Dimension(200, 23));
		btnExportToSpreadsheet.setMaximumSize(new Dimension(200, 23));
		btnExportToSpreadsheet.setAlignmentX(0.5f);
		leftPanel.add(btnExportToSpreadsheet);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(600, 600));
		panel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		JPanel userPanel = new JPanel();
		userPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		userPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		userPanel.setMaximumSize(new Dimension(32767, 150));
		userPanel.setPreferredSize(new Dimension(570, 150));
		rightPanel.add(userPanel);
		userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.X_AXIS));
		
		JLabel iconLabel = new JLabel("");
		iconLabel.setIcon(new ImageIcon("./assets/headshotSmall.png"));
		userPanel.add(iconLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		userPanel.add(horizontalStrut);
		
		JLabel lblNewLabel = new JLabel("Micah Smith");
		userPanel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setPreferredSize(new Dimension(10, 50));
		panel_1.setMinimumSize(new Dimension(10, 50));
		panel_1.setMaximumSize(new Dimension(32767, 50));
		rightPanel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Groceries");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("$50");
		panel_1.add(lblNewLabel_5);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 5));
		rightPanel.add(verticalStrut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(233, 150, 122));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setPreferredSize(new Dimension(10, 50));
		panel_2.setMinimumSize(new Dimension(10, 50));
		panel_2.setMaximumSize(new Dimension(32767, 50));
		rightPanel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Rent");
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("$200");
		panel_2.add(lblNewLabel_6);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 5));
		rightPanel.add(verticalStrut_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(233, 150, 122));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setPreferredSize(new Dimension(10, 50));
		panel_3.setMinimumSize(new Dimension(10, 50));
		panel_3.setMaximumSize(new Dimension(32767, 50));
		rightPanel.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Gas");
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("$50");
		panel_3.add(lblNewLabel_7);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setPreferredSize(new Dimension(0, 5));
		rightPanel.add(verticalStrut_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(233, 150, 122));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setPreferredSize(new Dimension(10, 50));
		panel_4.setMinimumSize(new Dimension(10, 50));
		panel_4.setMaximumSize(new Dimension(32767, 50));
		rightPanel.add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("Movie Tickets");
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("$15");
		panel_4.add(lblNewLabel_8);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setPreferredSize(new Dimension(0, 5));
		rightPanel.add(verticalStrut_3);
		
		Component verticalGlue = Box.createVerticalGlue();
		rightPanel.add(verticalGlue);
		
		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(32767, 30));
		panel_5.setPreferredSize(new Dimension(10, 30));
		rightPanel.add(panel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Owes you: $315");
		panel_5.add(lblNewLabel_9);
	}

}
