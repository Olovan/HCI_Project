import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class DebtCreationWindow extends JFrame {

	private JPanel contentPane;
	private JTextField debtLabelTextField;
	private JTextField debtAmountTextField;
	private JPanel peoplePanel;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JComboBox debtPayerComboBox;
	private MainMenu mainMenu;

	/**
	 * Create the frame.
	 */
	public DebtCreationWindow(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
		setTitle("Create New Debt");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDebtLabel = new JLabel("Debt Label");
		GridBagConstraints gbc_lblDebtLabel = new GridBagConstraints();
		gbc_lblDebtLabel.anchor = GridBagConstraints.EAST;
		gbc_lblDebtLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebtLabel.gridx = 0;
		gbc_lblDebtLabel.gridy = 0;
		contentPane.add(lblDebtLabel, gbc_lblDebtLabel);
		
		debtLabelTextField = new JTextField();
		GridBagConstraints gbc_debtLabelTextField = new GridBagConstraints();
		gbc_debtLabelTextField.weightx = 1.0;
		gbc_debtLabelTextField.insets = new Insets(0, 0, 5, 0);
		gbc_debtLabelTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_debtLabelTextField.gridx = 1;
		gbc_debtLabelTextField.gridy = 0;
		contentPane.add(debtLabelTextField, gbc_debtLabelTextField);
		debtLabelTextField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.anchor = GridBagConstraints.EAST;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 0;
		gbc_lblAmount.gridy = 1;
		contentPane.add(lblAmount, gbc_lblAmount);
		
		debtAmountTextField = new JTextField();
		GridBagConstraints gbc_debtAmountTextField = new GridBagConstraints();
		gbc_debtAmountTextField.insets = new Insets(0, 0, 5, 0);
		gbc_debtAmountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_debtAmountTextField.gridx = 1;
		gbc_debtAmountTextField.gridy = 1;
		contentPane.add(debtAmountTextField, gbc_debtAmountTextField);
		debtAmountTextField.setColumns(10);
		
		peoplePanel = new JPanel();
		peoplePanel.setLayout(new BoxLayout(peoplePanel, BoxLayout.Y_AXIS));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Lowell", "Monica", "Ian", "Micah", "Isaac"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnAddPersonTo = new JButton("Add Person to Debt");
		btnAddPersonTo.addActionListener(arg0 -> {
			if(comboBox.getSelectedItem() == null) 
				return;
			if(comboBox.getSelectedItem().equals("All")) {
				for(int i = 1; i < comboBox.getItemCount();) {
					JPanel newPanel = new JPanel();
		            newPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		            newPanel.setBackground(new Color(0xE3E3E3));
		            newPanel.add(new JLabel((String)comboBox.getItemAt(i)));
		            newPanel.setMaximumSize(new Dimension(2000, 30));
		            peoplePanel.add(newPanel);
		            comboBox.removeItemAt(i);
		            scrollPane.revalidate();
		            scrollPane.repaint();
				}
			} else {
	            JPanel newPanel = new JPanel();
	            newPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	            newPanel.setBackground(new Color(0xE3E3E3));
	            newPanel.add(new JLabel((String)comboBox.getSelectedItem()));
	            newPanel.setMaximumSize(new Dimension(2000, 30));
	            peoplePanel.add(newPanel);
	            comboBox.removeItem(comboBox.getSelectedItem());
	            scrollPane.revalidate();
	            scrollPane.repaint();
			}
        });
		GridBagConstraints gbc_btnAddPersonTo = new GridBagConstraints();
		gbc_btnAddPersonTo.anchor = GridBagConstraints.WEST;
		gbc_btnAddPersonTo.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddPersonTo.gridx = 1;
		gbc_btnAddPersonTo.gridy = 2;
		contentPane.add(btnAddPersonTo, gbc_btnAddPersonTo);
		
		scrollPane = new JScrollPane(peoplePanel);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JLabel lblPeopleAddedTo = new JLabel("People Added To Debt:");
		GridBagConstraints gbc_lblPeopleAddedTo = new GridBagConstraints();
		gbc_lblPeopleAddedTo.insets = new Insets(0, 0, 5, 0);
		gbc_lblPeopleAddedTo.gridwidth = 2;
		gbc_lblPeopleAddedTo.gridx = 0;
		gbc_lblPeopleAddedTo.gridy = 3;
		contentPane.add(lblPeopleAddedTo, gbc_lblPeopleAddedTo);
		
		JButton btnCreateDebt = new JButton("Create Debt");
		btnCreateDebt.addActionListener(arg0 -> {
			setVisible(false);
			mainMenu.addDebt(debtLabelTextField.getText(), Float.parseFloat(debtAmountTextField.getText()));
			});
		
		debtPayerComboBox = new JComboBox();
		debtPayerComboBox.setModel(new DefaultComboBoxModel(new String[] {"You", "Lowell", "Monica", "Ian", "Micah", "Isaac"}));
		GridBagConstraints gbc_debtPayerComboBox = new GridBagConstraints();
		gbc_debtPayerComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_debtPayerComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_debtPayerComboBox.gridx = 1;
		gbc_debtPayerComboBox.gridy = 5;
		contentPane.add(debtPayerComboBox, gbc_debtPayerComboBox);
		GridBagConstraints gbc_btnCreateDebt = new GridBagConstraints();
		gbc_btnCreateDebt.fill = GridBagConstraints.BOTH;
		gbc_btnCreateDebt.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateDebt.gridx = 0;
		gbc_btnCreateDebt.gridy = 6;
		contentPane.add(btnCreateDebt, gbc_btnCreateDebt);
		
		JButton btnCancell = new JButton("Cancel");
		btnCancell.addActionListener(e -> setVisible(false));
		GridBagConstraints gbc_btnCancell = new GridBagConstraints();
		gbc_btnCancell.anchor = GridBagConstraints.EAST;
		gbc_btnCancell.fill = GridBagConstraints.VERTICAL;
		gbc_btnCancell.gridx = 1;
		gbc_btnCancell.gridy = 6;
		contentPane.add(btnCancell, gbc_btnCancell);
		
		JLabel lblNewLabel = new JLabel("Who Is Paying?");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
	}

	public void clearInfo() {
		debtLabelTextField.setText("");
		debtAmountTextField.setText("");
		peoplePanel.removeAll();
		scrollPane.revalidate();
		scrollPane.repaint();
		comboBox.removeAllItems();
		for(String name : new String[] {"All", "You", "Lowell", "Monica", "Ian", "Micah", "Isaac"}) {
			comboBox.addItem(name);
		}
	}
}
