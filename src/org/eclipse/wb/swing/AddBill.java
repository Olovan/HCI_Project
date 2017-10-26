package org.eclipse.wb.swing;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddBill extends JFrame{
	private JTextField txtWalmart;
	private JTextField paidByField;
	private JTextField textField;
	public AddBill() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) northPanel.getLayout();
		flowLayout_2.setVgap(10);
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JLabel lblAddANew = new JLabel("Add\r\n New Bill");
		lblAddANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew.setFont(new Font("Tahoma", Font.BOLD, 18));
		northPanel.add(lblAddANew);
		
		JPanel centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titleTagsPanel = new JPanel();
		centerPanel.add(titleTagsPanel, BorderLayout.WEST);
		titleTagsPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblBillTitle = new JLabel("  Bill Title : ");
		lblBillTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleTagsPanel.add(lblBillTitle);
		
		JLabel lblBillType = new JLabel("  Bill Type :");
		lblBillType.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleTagsPanel.add(lblBillType);
		
		JLabel lblNewLabel = new JLabel("  Currency :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleTagsPanel.add(lblNewLabel);
		
		JLabel lblPaidBy = new JLabel("  Paid By :");
		lblPaidBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaidBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleTagsPanel.add(lblPaidBy);
		
		JLabel lblSplitMethod = new JLabel("  Split Method :");
		lblSplitMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblSplitMethod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleTagsPanel.add(lblSplitMethod);
		
		JLabel lblAmount = new JLabel("  Amount : ");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		titleTagsPanel.add(lblAmount);
		
		JPanel southCenterPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) southCenterPanel.getLayout();
		flowLayout_1.setVgap(15);
		centerPanel.add(southCenterPanel, BorderLayout.SOUTH);
		
		JPanel eastCenterPanel = new JPanel();
		centerPanel.add(eastCenterPanel, BorderLayout.EAST);
		eastCenterPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel uselesspanel_1 = new JPanel();
		eastCenterPanel.add(uselesspanel_1, BorderLayout.NORTH);
		
		JPanel uselesspanel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) uselesspanel_2.getLayout();
		flowLayout_3.setHgap(60);
		flowLayout_3.setVgap(10);
		eastCenterPanel.add(uselesspanel_2, BorderLayout.SOUTH);
		
		JPanel uselesspanel_3 = new JPanel();
		eastCenterPanel.add(uselesspanel_3, BorderLayout.WEST);
		
		JPanel uselesspanel_4 = new JPanel();
		eastCenterPanel.add(uselesspanel_4, BorderLayout.EAST);
		
		JPanel btnPanel = new JPanel();
		eastCenterPanel.add(btnPanel, BorderLayout.CENTER);
		btnPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnSaveBill = new JButton("Save Bill");
		btnPanel.add(btnSaveBill);
		
		JPanel centerCenterPanel = new JPanel();
		centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
		centerCenterPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		txtWalmart = new JTextField();
		txtWalmart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtWalmart.setHorizontalAlignment(SwingConstants.CENTER);
		txtWalmart.setText("Walmart");
		centerCenterPanel.add(txtWalmart);
		txtWalmart.setColumns(10);
		
		JComboBox billTypeComboBox = new JComboBox();
		//((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
		billTypeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		billTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Grocery", "Food", "Shopping", "Other"}));
		centerCenterPanel.add(billTypeComboBox);
		
		JComboBox currencyTypeComboBox = new JComboBox();
		currencyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"US Dollars", "Pounds", "Euros", "Australian Dollars"}));
		currencyTypeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		centerCenterPanel.add(currencyTypeComboBox);
		
		paidByField = new JTextField();
		paidByField.setHorizontalAlignment(SwingConstants.CENTER);
		paidByField.setText("Micah");
		paidByField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		centerCenterPanel.add(paidByField);
		paidByField.setColumns(10);
		
		JComboBox splitComboBox = new JComboBox();
		splitComboBox.setModel(new DefaultComboBoxModel(new String[] {"Equally", "Percentage Wise", "By Amount"}));
		splitComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		centerCenterPanel.add(splitComboBox);
		
		textField = new JTextField();
		textField.setText("50");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		centerCenterPanel.add(textField);
		textField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Add New Bill");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Save ");
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("Save As");
		menu.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Excel Spreadsheet");
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem(".txt File");
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Log Out");
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Exit");
		menu.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("Edit");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_6 = new JMenuItem("Edit Bill");
		menu_2.add(menuItem_6);
		
		JMenu menu_3 = new JMenu("Help");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_7 = new JMenuItem("About Us");
		menu_3.add(menuItem_7);
	}

}
