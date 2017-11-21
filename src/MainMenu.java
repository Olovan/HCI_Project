import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JButton debtBtn;
	private JButton paymentBtn;
	private JButton addPersonBtn;
	private JComboBox<String> peopleBox;
	private DebtCreationWindow debtWindow;
	private PersonDropdown personDropdown;
	private JPanel debtsPanel;
	private JScrollPane scrollPane;
	
	TotalDebtPanel totalDebtPanel;
	JPanel debtPanel;

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 629);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		debtWindow = new DebtCreationWindow(this);
		debtBtn = new JButton("Add Debt");
		paymentBtn = new JButton("Add Payment");
		addPersonBtn = new JButton("Add Person");
		peopleBox = new JComboBox<String>(new String[]{"Micah", "Ian", "Isaac", "Lowell", "Monica"});
		personDropdown = new PersonDropdown();
		totalDebtPanel = new TotalDebtPanel(215);

		contentPanel.add(new LeftButtonPanel(debtBtn, paymentBtn, addPersonBtn));

		//Build Right Panel
		JPanel rightPanel = new JPanel();
		debtsPanel = new JPanel();
		scrollPane = new JScrollPane(debtsPanel);
		rightPanel.setPreferredSize(new Dimension(600, 600));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBackground(new Color(0xCCCCCC));
		debtsPanel.setLayout(new BoxLayout(debtsPanel, BoxLayout.Y_AXIS));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(rightPanel);

		rightPanel.add(personDropdown);
		rightPanel.add(scrollPane);

		Component horizontalStrut = Box.createHorizontalStrut(20);

		debtsPanel.add(new DebtEntry("Groceries", 50, "11/20/2017"));
		debtsPanel.add(new DebtEntry("Rent", 200, "11/20/2017"));
		debtsPanel.add(new DebtEntry("Gas", -50, "11/20/2017"));
		debtsPanel.add(new DebtEntry("Movie Tickets", 15, "11/20/2017"));
		
		rightPanel.add(totalDebtPanel);
	}
	
	public void addDebt(String label, float amount, String date) {
		debtsPanel.add(new DebtEntry(label, amount, date));
		totalDebtPanel.addDebt(amount);
		debtsPanel.revalidate();
		scrollPane.revalidate();
		debtsPanel.repaint();
		scrollPane.repaint();
	}

	private class LeftButtonPanel extends JPanel{
		private JButton debtBtn;
		private JButton paymentBtn;
		private JButton addPersonBtn;
		public LeftButtonPanel(JButton debtBtn, JButton paymentBtn, JButton addPersonBtn) {
			setBorder(BorderFactory.createEtchedBorder());
			setPreferredSize(new Dimension(200, 10));
			setMaximumSize(new Dimension(300, 32767));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			debtBtn.setMinimumSize(new Dimension(200, 23));
			debtBtn.setMaximumSize(new Dimension(200, 50));
			debtBtn.setPreferredSize(new Dimension(200, 50));
			debtBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			paymentBtn.setPreferredSize(new Dimension(200, 23));
			paymentBtn.setMinimumSize(new Dimension(200, 23));
			paymentBtn.setMaximumSize(new Dimension(200, 23));
			paymentBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			addPersonBtn.setPreferredSize(new Dimension(200, 23));
			addPersonBtn.setMinimumSize(new Dimension(200, 23));
			addPersonBtn.setMaximumSize(new Dimension(200, 23));
			addPersonBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			debtBtn.addActionListener(e -> {
                debtWindow.clearInfo();
                debtWindow.setLocation(getLocationOnScreen());
                debtWindow.setVisible(true);
            });
			addPersonBtn.addActionListener(e -> {
                String name = JOptionPane.showInputDialog(this, "Enter Name");
                personDropdown.box.addItem(name);
            });

			add(debtBtn);
			add(paymentBtn);
			add(addPersonBtn);

			this.debtBtn = debtBtn;
			this.paymentBtn = paymentBtn;
			this.addPersonBtn = addPersonBtn;
		}
	}
	private class PersonDropdown extends JPanel{
		JComboBox<String> box;
		public PersonDropdown() {
			this.box = new JComboBox<String>(new String[] {"All", "You", "Lowell", "Monica", "Ian", "Micah", "Isaac"});
			
			setBorder(BorderFactory.createEtchedBorder());
			setAlignmentY(Component.TOP_ALIGNMENT);
			setMaximumSize(new Dimension(32767, 50));
			setPreferredSize(new Dimension(570, 50));
			setLayout(new GridLayout(1, 1));

			add(this.box);
		}
	}
	private class DebtEntry extends JPanel implements ActionListener{
		JLabel date;
		JLabel name;
		JLabel amountLbl;
		float amount;
		public DebtEntry(String name, float amount, String date) {
			this.name = new JLabel(name);
			this.amount = amount;
			this.amountLbl = new JLabel("$" + Math.abs(amount));
			this.date = new JLabel(date);
			
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel content = new JPanel();
			add(content);
			add(Box.createVerticalStrut(5));

			setColor(amount, content);
			content.setBorder(new LineBorder(new Color(0, 0, 0)));
			content.setPreferredSize(new Dimension(10, 50));
			content.setMinimumSize(new Dimension(10, 50));
			content.setMaximumSize(new Dimension(32767, 50));
			content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
			
			this.amountLbl.setFont(new Font("Arial", Font.BOLD, 16));
			
			JButton pay = new JButton("Pay");
			pay.addActionListener(this);

			content.add(Box.createHorizontalStrut(20));
			content.add(this.amountLbl);
			content.add(Box.createHorizontalStrut(100 - (int)this.amountLbl.getPreferredSize().getWidth()));
			content.add(this.name);
			content.add(Box.createHorizontalGlue());
			content.add(this.date);
			content.add(Box.createHorizontalStrut(20));
			content.add(pay);
			content.add(Box.createHorizontalStrut(20));
			
			
		}
		
		public void actionPerformed(ActionEvent e) {
			debtsPanel.remove(Box.createVerticalStrut(5));
			debtsPanel.remove(this);
			debtsPanel.revalidate();
			debtsPanel.repaint();
			scrollPane.revalidate();
			scrollPane.repaint();
			totalDebtPanel.addDebt(-amount);
			
		}
		
		private void setColor(float amount, JPanel content) {
			if(amount > 0)
				content.setBackground(new Color(230, 250, 230));
			else
				content.setBackground(new Color(250, 230, 230));
		}
	}
	private class TotalDebtPanel extends JPanel {
		JLabel debtLabel;
		float debt;
		
		public TotalDebtPanel(float debt) {
			this.debt = debt;
			debtLabel = new JLabel((debt < 0 ? "Owes You: $" + Math.abs(debt) : "Is Owed: $" + Math.abs(debt)));
			
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			setAlignmentY(CENTER_ALIGNMENT);
			setPreferredSize(new Dimension(570, 50));
			setMaximumSize(new Dimension(2000, 50));
			
			debtLabel.setFont(new Font("Arial", Font.BOLD, 12));
			
			add(debtLabel);
		}
		
		public void addDebt(float debt) {
			this.debt += debt;
			debtLabel.setText((this.debt < 0 ? "Owes You: $" + Math.abs(this.debt) : "Is Owed: $" + Math.abs(this.debt)));
		}
	}


}
