import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Font;

public class Dashboard extends JFrame {
	private JTable expenseTable;
	public Dashboard() {
		this.setSize(640, 480);
		
		getContentPane().setLayout(new BorderLayout(5, 0));
		
		JPanel northPanel = new JPanel();
		getContentPane().add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		northPanel.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAddNewBill = new JMenuItem("Add New Bill");
		mnFile.add(mntmAddNewBill);
		
		JMenuItem mntmSave = new JMenuItem("Save ");
		mnFile.add(mntmSave);
		
		JMenu mnSaveAs = new JMenu("Save As");
		mnFile.add(mnSaveAs);
		
		JMenuItem mntmExcelSpreadsheet = new JMenuItem("Excel Spreadsheet");
		mnSaveAs.add(mntmExcelSpreadsheet);
		
		JMenuItem mntmtxtFile = new JMenuItem(".txt File");
		mnSaveAs.add(mntmtxtFile);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnFile.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEditBill = new JMenuItem("Edit Bill");
		mnEdit.add(mntmEditBill);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mnHelp.add(mntmAboutUs);
		
		JPanel westPanel = new JPanel();
		getContentPane().add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(3, 1, 40, 10));
		Dimension pref=new Dimension(110,50);
		westPanel.setPreferredSize(pref);
		
		JLabel userlbl = new JLabel("Hello user!");
		userlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userlbl.setHorizontalAlignment(SwingConstants.CENTER);
		westPanel.add(userlbl);
		
		JScrollPane scrollPane = new JScrollPane();
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(Color.WHITE);
		list.setValueIsAdjusting(true);
		list.setVisibleRowCount(3);
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Group 1", "Group 2", "Group 3", "Group 4", "Group 5", "Group 6", "Group 7"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		westPanel.add(scrollPane);
		
		JPanel optionPanelWest = new JPanel();
		westPanel.add(optionPanelWest);
		optionPanelWest.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnNewGroup = new JButton("New Group");
		optionPanelWest.add(btnNewGroup);
		
		JButton btnDeleteGroup = new JButton("Delete Group");
		optionPanelWest.add(btnDeleteGroup);
		
		JPanel southPanel = new JPanel();
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(0, 3, 0, 0));
		southPanel.setPreferredSize(new Dimension(southPanel.getSize().width,50));
		
		JLabel lbltotalExpns = new JLabel("Total Expenses : ");
		lbltotalExpns.setHorizontalAlignment(SwingConstants.CENTER);
		lbltotalExpns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		southPanel.add(lbltotalExpns);
		
		JLabel lblMonthlyExpns = new JLabel("Montly Expenses : ");
		lblMonthlyExpns.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonthlyExpns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		southPanel.add(lblMonthlyExpns);
		
		JLabel lblTotalDebts = new JLabel("Total Debts  :");
		lblTotalDebts.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDebts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		southPanel.add(lblTotalDebts);
		
		JPanel eastPanel = new JPanel();
		getContentPane().add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel label=new JLabel();
		ImageIcon image = new ImageIcon(new ImageIcon("images.jpg").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
			
		JPanel overallGraphPanel = new JPanel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("images.jpg").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		
		//label.setIcon(image);
		
		FlowLayout flowLayout_1 = (FlowLayout) overallGraphPanel.getLayout();
		flowLayout_1.setVgap(50);
		flowLayout_1.setHgap(70);
		overallGraphPanel.add(label);
		eastPanel.add(overallGraphPanel);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(20, 30));
		
		expenseTable = new JTable();
		expenseTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		expenseTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"Title", "Paid By", "Expense", "Debt "},
				{"Walmart", "Micah", "$50", "+$25"},
				{"CVS", "Aneesh", "$10", "-5"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Title", "Paid By", "Expense", "Debt"
			}
		));
		centerPanel.add(expenseTable, BorderLayout.CENTER);
		
		JLabel lblExpenseTable = new JLabel("Expense Table");
		lblExpenseTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpenseTable.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lblExpenseTable, BorderLayout.NORTH);
		centerPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{expenseTable}));
		setVisible(true);
	}
	public static void main(String[]args){
		new Dashboard();
	}
}
