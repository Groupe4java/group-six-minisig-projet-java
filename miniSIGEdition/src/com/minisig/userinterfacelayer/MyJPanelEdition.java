package com.minisig.userinterfacelayer;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MyJPanelEdition extends JPanel {
	private JTextField textFieldLibelle;
	private JTextField textFieldDescription;
	private JTextField textFieldImage;

	/**
	 * Create the panel.
	 */
	public MyJPanelEdition() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditTitle = new JPanel();
		add(panelEditTitle);
		
		JLabel lblEditType = new JLabel("EDIT Type");
		panelEditTitle.add(lblEditType);
		
		JPanel panelEditButtonTop = new JPanel();
		add(panelEditButtonTop);
		
		JButton btnNewButton = new JButton("MODIF");
		panelEditButtonTop.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		panelEditButtonTop.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD");
		panelEditButtonTop.add(btnNewButton_2);
		
		JPanel panelEditBox = new JPanel();
		add(panelEditBox);
		panelEditBox.setLayout(new BoxLayout(panelEditBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditComboBox = new JPanel();
		panelEditBox.add(panelEditComboBox);
		panelEditComboBox.setLayout(new BoxLayout(panelEditComboBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditComboBoxFirst = new JPanel();
		panelEditComboBox.add(panelEditComboBoxFirst);
		
		JLabel lblComboBoxFirst = new JLabel("Choix Lieu :");
		lblComboBoxFirst.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditComboBoxFirst.add(lblComboBoxFirst);
		
		JComboBox comboBox = new JComboBox();
		panelEditComboBoxFirst.add(comboBox);
		
		JPanel panelEditComboBoxSecond = new JPanel();
		panelEditComboBox.add(panelEditComboBoxSecond);
		
		JLabel lblComboBoxSecond = new JLabel("Choix [Type] :");
		lblComboBoxSecond.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditComboBoxSecond.add(lblComboBoxSecond);
		
		JComboBox comboBox_1 = new JComboBox();
		panelEditComboBoxSecond.add(comboBox_1);
		
		JPanel panelEditTextBox = new JPanel();
		panelEditBox.add(panelEditTextBox);
		panelEditTextBox.setLayout(new BoxLayout(panelEditTextBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditTextBoxLibelle = new JPanel();
		panelEditTextBox.add(panelEditTextBoxLibelle);
		
		JLabel lblLibelle = new JLabel("Libelle :");
		lblLibelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxLibelle.add(lblLibelle);
		
		textFieldLibelle = new JTextField();
		panelEditTextBoxLibelle.add(textFieldLibelle);
		textFieldLibelle.setColumns(10);
		
		JPanel panelEditTextBoxDescription = new JPanel();
		panelEditTextBox.add(panelEditTextBoxDescription);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxDescription.add(lblDescription);
		
		textFieldDescription = new JTextField();
		panelEditTextBoxDescription.add(textFieldDescription);
		textFieldDescription.setColumns(10);
		
		JPanel panelEditTextBoxImage = new JPanel();
		panelEditTextBox.add(panelEditTextBoxImage);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxImage.add(lblImage);
		
		textFieldImage = new JTextField();
		panelEditTextBoxImage.add(textFieldImage);
		textFieldImage.setColumns(10);
		
		JPanel panelEditPosition = new JPanel();
		panelEditBox.add(panelEditPosition);
		
		JButton btnPosition = new JButton("POSITION");
		panelEditPosition.add(btnPosition);
		
		JLabel lblposX = new JLabel("X");
		lblposX.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEditPosition.add(lblposX);
		
		JLabel lblSeparator = new JLabel("-");
		lblSeparator.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditPosition.add(lblSeparator);
		
		JLabel lblposY = new JLabel("Y");
		lblposY.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEditPosition.add(lblposY);
		
		JPanel panelEditChoixPOI = new JPanel();
		panelEditBox.add(panelEditChoixPOI);
		
		JLabel lblChoixPOIForParcours = new JLabel("Choix POI :");
		lblChoixPOIForParcours.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditChoixPOI.add(lblChoixPOIForParcours);
		
		JComboBox comboBoxChoixPOIForParcours = new JComboBox();
		panelEditChoixPOI.add(comboBoxChoixPOIForParcours);
		
		JButton button = new JButton("+");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditChoixPOI.add(button);
		
		JPanel panelEditListPOI = new JPanel();
		panelEditBox.add(panelEditListPOI);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test1"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panelEditListPOI.add(list);
		
		JButton btnSuprFromList = new JButton("REMOVE");
		panelEditListPOI.add(btnSuprFromList);
		
		JPanel panelEditButtonBot = new JPanel();
		panelEditButtonBot.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelEditButtonBot);
		panelEditButtonBot.setLayout(new BoxLayout(panelEditButtonBot, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditButtonValidate = new JPanel();
		panelEditButtonBot.add(panelEditButtonValidate);
		
		JButton btnValidate = new JButton("VALIDER");
		btnValidate.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditButtonValidate.add(btnValidate);
		
		JPanel panelEditButtonCancel = new JPanel();
		panelEditButtonBot.add(panelEditButtonCancel);
		
		JButton btnCancel = new JButton("ANNULER");
		panelEditButtonCancel.add(btnCancel);

	}
}
