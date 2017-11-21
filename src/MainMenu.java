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
	private JButton debtBtn;
	private JButton paymentBtn;
	private JButton addPersonBtn;
	private JLabel subjectName;
	private JLabel subjectDebt;

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

		debtBtn = new JButton("Add Debt");
		paymentBtn = new JButton("Add Payment");
		addPersonBtn = new JButton("Add Person");
		subjectName = new JLabel("Micah");
		subjectDebt = new JLabel("$9000");

		panel.add(new LeftButtonPanel(debtBtn, paymentBtn, addPersonBtn));

		//Build Right Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(600, 600));
		panel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		rightPanel.add(new InfoPanel(subjectName, subjectDebt));

		Component horizontalStrut = Box.createHorizontalStrut(20);

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

	private class LeftButtonPanel extends JPanel{
		private JButton debtBtn;
		private JButton paymentBtn;
		private JButton addPersonBtn;
		public LeftButtonPanel(JButton debtBtn, JButton paymentBtn, JButton addPersonBtn) {
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			setPreferredSize(new Dimension(200, 10));
			setMaximumSize(new Dimension(300, 32767));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			debtBtn.setMinimumSize(new Dimension(200, 23));
			debtBtn.setMaximumSize(new Dimension(200, 23));
			debtBtn.setPreferredSize(new Dimension(200, 23));
			debtBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			paymentBtn.setPreferredSize(new Dimension(200, 23));
			paymentBtn.setMinimumSize(new Dimension(200, 23));
			paymentBtn.setMaximumSize(new Dimension(200, 23));
			paymentBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			addPersonBtn.setPreferredSize(new Dimension(200, 23));
			addPersonBtn.setMinimumSize(new Dimension(200, 23));
			addPersonBtn.setMaximumSize(new Dimension(200, 23));
			addPersonBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

			add(debtBtn);
			add(paymentBtn);
			add(addPersonBtn);

			this.debtBtn = debtBtn;
			this.paymentBtn = paymentBtn;
			this.addPersonBtn = addPersonBtn;
		}
	}
	private class InfoPanel extends JPanel{
		JLabel name;
		JLabel debt;
		public InfoPanel(JLabel name, JLabel debt) {
			setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			setAlignmentY(Component.TOP_ALIGNMENT);
			setMaximumSize(new Dimension(32767, 100));
			setPreferredSize(new Dimension(570, 100));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		}
	}


}
