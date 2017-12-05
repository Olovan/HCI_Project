import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DebtCreationWindow extends JFrame {

	private JPanel contentPane;
	private JTextField debtLabelTextField;
	private JTextField debtAmountTextField;
	private JPanel peoplePanel;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JComboBox debtPayerComboBox;
	private MainMenu mainMenu;

	private ArrayList<Integer> debtParticipants;
	private ArrayList<Integer> peopleIds;
	private ArrayList<Integer> payerIds;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Create the frame.
	 */
	public DebtCreationWindow(MainMenu mainMenu) {
		peopleIds = new ArrayList<Integer>();
		payerIds = new ArrayList<Integer>();
		debtParticipants = new ArrayList<Integer>();
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
		
		comboBox = new JComboBox<String>();
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
					addDebtParticpant(i);
				}
			} else {
				addDebtParticpant(comboBox.getSelectedIndex());
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
			if(!validateInput()) {return;} //Abort if input can't be validated
			if(debtPayerComboBox.getSelectedItem() == "You") {
				for(Integer debtParticipant : debtParticipants) {
					DatabaseHandler.addDebt(debtLabelTextField.getText(), -1 * Double.parseDouble(debtAmountTextField.getText()) / peoplePanel.getComponentCount(), dateFormat.format(new Date()), debtParticipant);
				}
			} else {
				DatabaseHandler.addDebt(debtLabelTextField.getText(), Double.parseDouble(debtAmountTextField.getText()) / peoplePanel.getComponentCount(), dateFormat.format(new Date()), payerIds.get(debtPayerComboBox.getSelectedIndex()));
			}
			mainMenu.refreshDebts();
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
		debtParticipants.clear();
		payerIds.clear();
		peopleIds.clear();
		debtLabelTextField.setText("");
		debtAmountTextField.setText("");
		peoplePanel.removeAll();
		scrollPane.revalidate();
		scrollPane.repaint();
		comboBox.removeAllItems();
		comboBox.addItem("All");
		debtPayerComboBox.removeAllItems();
		peopleIds.add(-1);
		ArrayList<Object[]> people = DatabaseHandler.select("SELECT name, personId FROM people", 2);
		for(Object[] personInfo : people) {
			comboBox.addItem((String)personInfo[0]);
			debtPayerComboBox.addItem((String)personInfo[0]);
			peopleIds.add((Integer)personInfo[1]);
			payerIds.add((Integer)personInfo[1]);
		}
		debtPayerComboBox.addItem("You");
		comboBox.addItem("You");
		debtPayerComboBox.setSelectedIndex(debtPayerComboBox.getItemCount() - 1);
	}

	private boolean validateInput() {
		//Make sure the debt has a label and an amount entered
		if(debtLabelTextField.getText().isEmpty() || debtAmountTextField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "The debt must have a label and an amount", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		//Make sure someone is added to the debt
		if(peoplePanel.getComponentCount() <= 0) {
			JOptionPane.showMessageDialog(this, "The debt must have participants", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		//Make sure debt amount is a number
		try {
			Double.parseDouble(debtAmountTextField.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "The debt amount must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		//Make sure that you are involved in the debt in some way
		if(debtPayerComboBox.getSelectedItem() != "You" && comboBox.getItemAt(comboBox.getItemCount() - 1) == "You") {
			JOptionPane.showMessageDialog(this, "The debt must involve you as either a participant or the payer", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void addDebtParticpant(int index) {
		if(comboBox.getItemAt(index) != "You") {
			debtParticipants.add(peopleIds.get(index));
			peopleIds.remove(index);
		}

		JPanel newPanel = new JPanel();
		newPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		newPanel.setBackground(new Color(0xE3E3E3));
		newPanel.add(new JLabel((String)comboBox.getItemAt(index)));
		newPanel.setMaximumSize(new Dimension(2000, 30));
		peoplePanel.add(newPanel);
		comboBox.removeItemAt(index);
		scrollPane.revalidate();
		scrollPane.repaint();
	}
}
