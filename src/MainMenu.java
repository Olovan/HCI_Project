import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JButton debtBtn;
	private JButton addPersonBtn;
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
		DatabaseHandler.connectToDatabase();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 629);
		setTitle("EulersAbacus");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		debtsPanel = new JPanel();
		totalDebtPanel = new TotalDebtPanel(215);
		scrollPane = new JScrollPane(debtsPanel);
		debtWindow = new DebtCreationWindow(this);
		debtBtn = new JButton("Add Debt");
		addPersonBtn = new JButton("Add Person");
		personDropdown = new PersonDropdown();

		contentPanel.add(new LeftButtonPanel(debtBtn, addPersonBtn));

		//Build Right Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(600, 600));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBackground(new Color(0xCCCCCC));
		debtsPanel.setLayout(new BoxLayout(debtsPanel, BoxLayout.Y_AXIS));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(rightPanel);

		rightPanel.add(personDropdown);
		rightPanel.add(scrollPane);
		rightPanel.add(totalDebtPanel);

		//Add action Listener to personDropdown
		personDropdown.box.addActionListener(personDropdown);
		refreshDebts();
	}

	public void addDebt(String label, double amount, String date, int debtId) {
		debtsPanel.add(new DebtEntry(label, amount, date, debtId));
		totalDebtPanel.addDebt(amount);
		debtsPanel.revalidate();
		scrollPane.revalidate();
		debtsPanel.repaint();
		scrollPane.repaint();
	}

	public void clearDebts() {
		debtsPanel.removeAll();
		totalDebtPanel.setDebt(0.0);
	}

	public void refreshDebts() {
		clearDebts();
		ArrayList<Object[]> debtResults;
		if(personDropdown.box.getSelectedIndex() == 0) {
			debtResults = DatabaseHandler.select("SELECT label, amount, date, debtId FROM debts", 4);
		} else {
			debtResults = DatabaseHandler.select("SELECT label, amount, date, debtId FROM debts WHERE owner=" + personDropdown.personIds.get(personDropdown.box.getSelectedIndex()) , 4);
		}

		for(Object[] debtInfo : debtResults) {
			addDebt((String)debtInfo[0], (double)debtInfo[1], (String)debtInfo[2], (int)debtInfo[3]);
		}
	}

	private class LeftButtonPanel extends JPanel{
		private JButton debtBtn;
		private JButton addPersonBtn;
		public LeftButtonPanel(JButton debtBtn, JButton addPersonBtn) {
			setBorder(BorderFactory.createEtchedBorder());
			setPreferredSize(new Dimension(200, 10));
			setMaximumSize(new Dimension(300, 32767));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			debtBtn.setMinimumSize(new Dimension(200, 23));
			debtBtn.setMaximumSize(new Dimension(200, 50));
			debtBtn.setPreferredSize(new Dimension(200, 50));
			debtBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

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
				if(name != null) {
					DatabaseHandler.addPerson(name);
					personDropdown.refreshNameList();
				}
			});

			add(debtBtn);
			add(addPersonBtn);

			this.debtBtn = debtBtn;
			this.addPersonBtn = addPersonBtn;
		}
	}
	private class PersonDropdown extends JPanel implements ActionListener{
		JComboBox<String> box;
		ArrayList<Integer> personIds;
		public PersonDropdown() {
			this.box = new JComboBox<String>();
			personIds = new ArrayList<Integer>();

			setBorder(BorderFactory.createEtchedBorder());
			setAlignmentY(Component.TOP_ALIGNMENT);
			setMaximumSize(new Dimension(32767, 50));
			setPreferredSize(new Dimension(570, 50));
			setLayout(new GridLayout(1, 1));

			refreshNameList();
			add(this.box);
		}

		public void refreshNameList() {
			box.removeAllItems();
			personIds.clear();
			box.addItem("All");
			personIds.add(-1);
			ArrayList<Object[]> people = DatabaseHandler.select("SELECT name, personId FROM people", 2);
			for(Object[] personInfo : people) {
				box.addItem((String)personInfo[0]);
				personIds.add((int)personInfo[1]);
			}
		}

		public void actionPerformed(ActionEvent e) {
			refreshDebts();
		}
	}
	private class DebtEntry extends JPanel implements ActionListener{
		JLabel date;
		JLabel name;
		JLabel amountLbl;
		int debtId;
		double amount;
		public DebtEntry(String name, double amount, String date, int debtId) {
			this.name = new JLabel(name);
			this.amount = amount;
			this.amountLbl = new JLabel("$" + Math.abs(amount));
			this.date = new JLabel(date);
			this.debtId = debtId;

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
			DatabaseHandler.modify("DELETE FROM debts WHERE debtId=" + debtId);
			refreshDebts();
		}

		private void setColor(double amount, JPanel content) {
			if(amount <= 0)
				content.setBackground(new Color(230, 250, 230));
			else
				content.setBackground(new Color(250, 230, 230));
		}
	}
	private class TotalDebtPanel extends JPanel {
		JLabel debtLabel;
		double debt;

		public TotalDebtPanel(double debt) {
			this.debt = debt;
			debtLabel = new JLabel();
			updateText();

			setLayout(new BorderLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			setAlignmentY(CENTER_ALIGNMENT);
			setPreferredSize(new Dimension(570, 50));
			setMaximumSize(new Dimension(2000, 50));

			debtLabel.setFont(new Font("Arial", Font.BOLD, 12));

			add(debtLabel);
		}

		public void addDebt(double debt) {
			this.debt += debt;
			updateText();
		}

		public void setDebt(double amount) {
			this.debt = amount;
			updateText();
		}

		private void updateText() {
			debtLabel.setText((this.debt < 0 ? "Owes You: $" + Math.abs(this.debt) : "You Owe Them: $" + Math.abs(this.debt)));
		}
	}


}
