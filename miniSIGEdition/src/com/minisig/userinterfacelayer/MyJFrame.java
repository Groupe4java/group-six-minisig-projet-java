package com.minisig.userinterfacelayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.minisig.businesslayer.processus.LieuProcessus;
import com.minisig.businesslayer.processus.ParcoursProcessus;
import com.minisig.businesslayer.processus.PoiProcessus;
import com.minisig.businesslayer.table.Lieu;
import com.minisig.businesslayer.table.Parcours;
import com.minisig.businesslayer.table.Poi;

public class MyJFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelMAP;
	
	String pathFound;
	JPanel panelTitle;
	JPanel panelDescription;
	JLabel lblTitre;
	JLabel lblDescription;
	JComboBox comboBoxLieu;
	JComboBox comboBoxParcours;
	JButton btnGoLieu;
	JButton btnGoParcours;
	JButton btnPrevious;
	JButton btnNext;
	JButton btnRemove;
	JLabel labelPosX;
	JLabel labelPosY;
	JLabel labelSeparator;
	JButton buttonValidate;
	JButton buttonCancel;
	JButton btnSearchImage;
	
	JLabel labelChoixPOI;
	JComboBox comboBoxChoixPOI;
	JButton buttonPlus;
	JLabel labelTypeEDIT;
	JLabel labelFirstCombobox;
	JComboBox comboBoxFirst;
	JLabel labelSecondComboBox;
	JComboBox comboBoxSecond;
	
	JButton btnPosition;
	
	JButton btnLieu;
	JButton btnParcours;
	JButton btnPoi;
	
	JButton btnMODIF;
	JButton btnDELETE;
	JButton btnADD;
	
	JLabel labelLibelle;
	JLabel labelDescription;
	JLabel labelImage;
	
	
	
	int typeSelected;		//1 = Lieu, 2 = Parcours, 3 = POI
	int actionSelected;		//1 = ADD, 2 = MODIF, 3 = DELETE
	
	

	int originWidht = 512;
	int originHeight = 408;
	int widthPanelMap;
	int heightPanelMap;

	private JTextField textFieldLibelle;
	private JTextField textFieldDescription;
	private JTextField textFieldImage;
	
	boolean boutonParcoursClicked;
	ArrayList<Integer> listX;
	ArrayList<Integer> listY;
	
	ArrayList<Integer> listIdPOI;
	ArrayList<String> listNamePoi;
	ArrayList<String> listDescriptionPoi;
	ArrayList<Boolean> listIsInParcours;
	ArrayList<Boolean> listPopUpOn;
	
	List<Poi> listPOI;
	PoiProcessus poiProc;
	LieuProcessus lieuProc;
	ParcoursProcessus parcoursProc;
	
	Image img;
	
	boolean lieuSelected = false;
	boolean parcoursSelected = false;
	
	

	
	public MyJFrame() {//Constructeur
		panelMAP = new MyJPanelMap();
		newComponents();
		newListeners();
	}

	public void setTypeSelected(int typeSelected) {
		this.typeSelected = typeSelected;
	}

	
	public void setEtatComponent(String textTitle, boolean bLblFirstCombobox, boolean bFirstCombobox,
			boolean bLblSecondCombobox, boolean bSecondCombobox, boolean bLblLibelle, boolean bTFLibelle, 
			boolean bLblDescription, boolean bTFDescription, boolean bLblImage, boolean bTFImage,
			boolean bBtnPosition, boolean bLblPosX, boolean bLblSeparator, boolean bLblposY, 
			boolean bLblChoixPOI, boolean bComboBoxChoixPOI, boolean bBtnPlus,
			boolean bBtnRemove, boolean bBtnValidate, boolean bBtnCancel, boolean bBtnSearchImage)
	{
		labelTypeEDIT.setText(textTitle);
		labelFirstCombobox.setEnabled(bLblFirstCombobox);
		labelFirstCombobox.setVisible(bLblFirstCombobox);
		comboBoxFirst.setEnabled(bFirstCombobox);
		comboBoxFirst.setVisible(bFirstCombobox);
		
		labelSecondComboBox.setEnabled(bLblSecondCombobox);
		labelSecondComboBox.setVisible(bLblSecondCombobox);
		comboBoxSecond.setEnabled(bSecondCombobox);
		comboBoxSecond.setVisible(bSecondCombobox);
		
		labelLibelle.setEnabled(bLblLibelle);
		labelLibelle.setVisible(bLblLibelle);
		textFieldLibelle.setEnabled(bTFLibelle);
		textFieldLibelle.setVisible(bTFLibelle);
		
		labelDescription.setEnabled(bLblDescription);
		labelDescription.setVisible(bLblDescription);
		textFieldDescription.setEnabled(bTFDescription);
		textFieldDescription.setVisible(bTFDescription);
		
		labelImage.setEnabled(bLblImage);
		labelImage.setVisible(bLblImage);
		textFieldImage.setEnabled(bTFImage);
		textFieldImage.setVisible(bTFImage);
		
		btnSearchImage.setEnabled(bBtnSearchImage);
		btnSearchImage.setVisible(bBtnSearchImage);
		
		btnPosition.setEnabled(bBtnPosition);
		btnPosition.setVisible(bBtnPosition);
		labelPosX.setEnabled(bLblPosX);
		labelPosX.setVisible(bLblPosX);
		labelSeparator.setEnabled(bLblSeparator);
		labelSeparator.setVisible(bLblSeparator);
		labelPosY.setEnabled(bLblposY);
		labelPosY.setVisible(bLblposY);
		
		labelChoixPOI.setEnabled(bLblChoixPOI);
		labelChoixPOI.setVisible(bLblChoixPOI);
		comboBoxChoixPOI.setEnabled(bComboBoxChoixPOI);
		comboBoxChoixPOI.setVisible(bComboBoxChoixPOI);
		buttonPlus.setEnabled(bBtnPlus);
		buttonPlus.setVisible(bBtnPlus);
		
		btnRemove.setEnabled(bBtnRemove);
		btnRemove.setVisible(bBtnRemove);
		buttonValidate.setEnabled(bBtnValidate);
		buttonValidate.setVisible(bBtnValidate);
		buttonCancel.setEnabled(bBtnCancel);
		buttonCancel.setVisible(bBtnCancel);
	}
	
	public void setEtatEditComponent(String actionSelected, String typeSelected) {//GERE L'AFFICHAGE DES ELEMENTS EDITIONS
		String action = actionSelected + typeSelected;
		System.out.println(action);
		
		switch(action)
		{
		case "11": //LIEU - ADD
			setEtatComponent("LIEU - AJOUT", false,false,false,false,true,true,true,true,true,true,false,false,false,false,false,false,false,false,true,true, true);
			break;
		case "12": //LIEU - MODIF
			setEtatComponent("LIEU - MODIFICATION", true,true,false,false,true,true,true,true,true,true,false,false,false,false,false,false,false,false,true,true, true);
			break;
		case "13": //LIEU - DELETE
			setEtatComponent("LIEU - SUPPRESSION", true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true, false);
			break;
		case "21": //PARCOURS - ADD
			setEtatComponent("PARCOURS - AJOUT", true,true,false,false,true,true,true,true,false,false,false,false,false,false,true,true,true,true,true,true, false);
			break;
		case "22": //PARCOURS - MODIF
			setEtatComponent("PARCOURS - MODIFICATION", true,true,true,true,true,true,true,true,false,false,false,false,false,false,true,true,true,true,true,true, false);
			break;
		case "23": //PARCOURS - DELETE
			setEtatComponent("PARCOURS - SUPPRESSION", true,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true, false);
			break;
		case "31": //POI - ADD
			setEtatComponent("POI - AJOUT", true,true,false,false,true,true,true,true,true,true,true,true,false,false,false,false,false,false,true,true, true);
			break;
		case "32": //POI - MODIF
			setEtatComponent("POI - MODIFICATION", true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,false,false,false,true,true, true);
			break;
		case "33": //POI - DELETE
			setEtatComponent("POI - SUPPRESSION", true,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true, false);
			break;
		case "99":
			setButtonAction(false);
			setEtatComponent("EDITION", false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false, false);
		
			break;
		case "90":
			
			setEtatComponent("EDITION", false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true, false);
		break;
		
		}
	}
	
	public void setButtonAction(boolean etat)
	{
		btnADD.setEnabled(etat);
		btnMODIF.setEnabled(etat);
		btnDELETE.setEnabled(etat);
	}
	
	public void newComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		
		
		panelMAP = new MyJPanelMap();
		

		panelMAP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCenter.add(panelMAP, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(400);
		panelMAP.add(horizontalStrut);
		
		JPanel panelDroite = new JPanel();
		panelCenter.add(panelDroite, BorderLayout.EAST);
		panelDroite.setLayout(new BoxLayout(panelDroite, BoxLayout.LINE_AXIS));
		
		JPanel panelPOI = new JPanel();
		panelDroite.add(panelPOI);
		panelPOI.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPOI.setLayout(new BoxLayout(panelPOI, BoxLayout.PAGE_AXIS));
		
		JPanel panelPoiNORTH = new JPanel();
		panelPOI.add(panelPoiNORTH);
		panelPoiNORTH.setLayout(new BoxLayout(panelPoiNORTH, BoxLayout.PAGE_AXIS));
		
		JPanel panelPusher = new JPanel();
		panelPoiNORTH.add(panelPusher);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(150);
		panelPusher.add(horizontalStrut_1);
		
		JPanel panelNavigate = new JPanel();
		panelPoiNORTH.add(panelNavigate);
		
		btnPrevious = new JButton("<");
		
		panelNavigate.add(btnPrevious);
		
		btnNext = new JButton(">");
		
		panelNavigate.add(btnNext);
		
		JPanel panelPoiCENTER = new JPanel();
		panelPOI.add(panelPoiCENTER);
		panelPoiCENTER.setLayout(new BoxLayout(panelPoiCENTER, BoxLayout.PAGE_AXIS));
		
		JPanel panelTitle = new JPanel();
		panelPoiCENTER.add(panelTitle);
		
		lblTitre = new JLabel("Titre");
		lblTitre.setPreferredSize(new Dimension(150,50));
		lblTitre.setVerticalAlignment(SwingConstants.TOP);
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitle.add(lblTitre);
		
		JPanel panelDescription = new JPanel();
		panelPoiCENTER.add(panelDescription);
		
		lblDescription = new JLabel("Description");
		lblDescription.setPreferredSize(new Dimension(150,50));
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		panelDescription.add(lblDescription);
		
		JPanel panelImage = new JPanel();
		panelPoiCENTER.add(panelImage);
		
		JPanel panelPoiSOUTH = new JPanel();
		panelPOI.add(panelPoiSOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelPoiSOUTH.add(verticalStrut);
		
		//Panel Edition
		JPanel panelEdition = new JPanel();
		panelEdition.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDroite.add(panelEdition);
		panelEdition.setLayout(new BoxLayout(panelEdition, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditTitle = new JPanel();
		panelEditTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEdition.add(panelEditTitle);
		
		labelTypeEDIT = new JLabel("EDITION");
		panelEditTitle.add(labelTypeEDIT);
		
		JPanel panelEditButtonTopType = new JPanel();
		//panelEditButtonTopType.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEdition.add(panelEditButtonTopType);
		
		btnLieu = new JButton("LIEU");
		panelEditButtonTopType.add(btnLieu);
		
		btnParcours = new JButton("PARCOURS");
		panelEditButtonTopType.add(btnParcours);
		
		btnPoi = new JButton("POI");
		panelEditButtonTopType.add(btnPoi);
		
		JPanel panelEditButtonAction = new JPanel();
		panelEdition.add(panelEditButtonAction);
		
		btnADD = new JButton("ADD");
		btnADD.setEnabled(false);
		panelEditButtonAction.add(btnADD);
		
		btnMODIF = new JButton("MODIF");
		btnMODIF.setEnabled(false);
		panelEditButtonAction.add(btnMODIF);
		
		btnDELETE = new JButton("DELETE");
		btnDELETE.setEnabled(false);
		panelEditButtonAction.add(btnDELETE);
		
		JPanel panelEditPart = new JPanel();
		panelEdition.add(panelEditPart);
		panelEditPart.setLayout(new BoxLayout(panelEditPart, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditComboBox = new JPanel();
		panelEditPart.add(panelEditComboBox);
		panelEditComboBox.setLayout(new BoxLayout(panelEditComboBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditChoixLieu = new JPanel();
		panelEditComboBox.add(panelEditChoixLieu);
		
		labelFirstCombobox = new JLabel("Choix Lieu :");
		labelFirstCombobox.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditChoixLieu.add(labelFirstCombobox);
		
		comboBoxFirst = new JComboBox();
		panelEditChoixLieu.add(comboBoxFirst);
		
		JPanel panelEditChoixType = new JPanel();
		panelEditComboBox.add(panelEditChoixType);
		
		labelSecondComboBox = new JLabel("Choix [Type] :");
		labelSecondComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditChoixType.add(labelSecondComboBox);
		
		comboBoxSecond = new JComboBox();
		panelEditChoixType.add(comboBoxSecond);
		
		JPanel panelEditTextBox = new JPanel();
		panelEditPart.add(panelEditTextBox);
		panelEditTextBox.setLayout(new BoxLayout(panelEditTextBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditTextBoxLibelle = new JPanel();
		panelEditTextBox.add(panelEditTextBoxLibelle);
		
		labelLibelle = new JLabel("Libelle :");
		labelLibelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxLibelle.add(labelLibelle);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		panelEditTextBoxLibelle.add(textFieldLibelle);
		
		JPanel panelEditTextBoxDescription = new JPanel();
		panelEditTextBox.add(panelEditTextBoxDescription);
		
		labelDescription = new JLabel("Description :");
		labelDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxDescription.add(labelDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		panelEditTextBoxDescription.add(textFieldDescription);
		
		JPanel panelEditTextBoxImage = new JPanel();
		panelEditTextBox.add(panelEditTextBoxImage);
		
		labelImage = new JLabel("Image :");
		labelImage.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxImage.add(labelImage);
		
		textFieldImage = new JTextField();
		textFieldImage.setColumns(10);
		panelEditTextBoxImage.add(textFieldImage);
		
		btnSearchImage = new JButton("Search");
		
		panelEditTextBoxImage.add(btnSearchImage);
		
		JPanel panelEditPosition = new JPanel();
		panelEditPart.add(panelEditPosition);
		
		btnPosition = new JButton("POSITION");
		panelEditPosition.add(btnPosition);
		
		labelPosX = new JLabel("X");
		labelPosX.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEditPosition.add(labelPosX);
		
		labelSeparator = new JLabel("-");
		labelSeparator.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditPosition.add(labelSeparator);
		
		labelPosY = new JLabel("Y");
		labelPosY.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEditPosition.add(labelPosY);
		
		JPanel panelEditChoixPOI = new JPanel();
		panelEditPart.add(panelEditChoixPOI);
		
		labelChoixPOI = new JLabel("Choix POI :");
		labelChoixPOI.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditChoixPOI.add(labelChoixPOI);
		
		comboBoxChoixPOI = new JComboBox();
		panelEditChoixPOI.add(comboBoxChoixPOI);
		
		buttonPlus = new JButton("+");
		buttonPlus.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditChoixPOI.add(buttonPlus);
		
		JPanel panelEditListPOI = new JPanel();
		panelEditPart.add(panelEditListPOI);
		
		
		btnRemove = new JButton("REMOVE");
		panelEditListPOI.add(btnRemove);
		
		JPanel panelEditButtonBot = new JPanel();
		panelEdition.add(panelEditButtonBot);
		panelEditButtonBot.setLayout(new BoxLayout(panelEditButtonBot, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditButtonValidate = new JPanel();
		panelEditButtonBot.add(panelEditButtonValidate);
		
		buttonValidate = new JButton("VALIDER");
		buttonValidate.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditButtonValidate.add(buttonValidate);
		
		JPanel panelEditButtonCancel = new JPanel();
		panelEditButtonBot.add(panelEditButtonCancel);
		
		buttonCancel = new JButton("ANNULER");
		panelEditButtonCancel.add(buttonCancel);

		//FIN
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMode = new JPanel();
		panelNorth.add(panelMode, BorderLayout.NORTH);
		
		JLabel lblModeConsultation = new JLabel("Mode Edition");
		panelMode.add(lblModeConsultation);
		
		JPanel panelMenu = new JPanel();
		panelNorth.add(panelMenu, BorderLayout.SOUTH);
		
		comboBoxLieu = new JComboBox();
		comboBoxLieu.setModel(new DefaultComboBoxModel(new String[] {""}));
		panelMenu.add(comboBoxLieu);
		
		List<Lieu> listLieu = null;
		LieuProcessus lieuProc = new LieuProcessus();
		listLieu = lieuProc.ListAllLieu();
		for(Lieu e : listLieu)comboBoxLieu.addItem(e.getNameLieu());
		
		
		btnGoLieu = new JButton("Go");
		
		btnGoLieu.setEnabled(false);
		panelMenu.add(btnGoLieu);
		
		comboBoxParcours = new JComboBox();
		comboBoxParcours.setModel(new DefaultComboBoxModel(new String[] {"Maisons \u00E0 paris"}));
		comboBoxParcours.setEnabled(false);
		panelMenu.add(comboBoxParcours);
		
		btnGoParcours = new JButton("Go");
		
		panelMenu.add(btnGoParcours);
		
		setButtonAction(false);
		setEtatEditComponent("9","9");
	}

	public void afficherPOI()
	{
		
		listX = new ArrayList<>();
		listY = new ArrayList<>();
		listIsInParcours = new ArrayList<>();
		listPopUpOn = new ArrayList<>();
		listIdPOI = new ArrayList<>();
		listNamePoi = new ArrayList<>();
		listDescriptionPoi = new ArrayList<>();
		
		listPOI = null;
		poiProc = new PoiProcessus();
		lieuProc = new LieuProcessus();

		parcoursProc = new ParcoursProcessus();
		listPOI = poiProc.listAllPoiForLieu(lieuProc.getIdForNameLieu(comboBoxLieu.getSelectedItem().toString()));
		
		for(Poi p: listPOI){

			listX.add(p.getXPOI());
			listY.add(p.getYPOI());
			listIdPOI.add(p.getIdPOI());
			listNamePoi.add(p.getLibellePOI());
			listDescriptionPoi.add(p.getDescriptionPOI());
			
			if(boutonParcoursClicked)
			{

				int parcoursId = parcoursProc.getIdForNameParcours(comboBoxParcours.getSelectedItem().toString());
				int poiId = p.getIdPOI();
				if (poiProc.checkPoiForParcours(parcoursId, poiId)) //SELECT * FROM fait_partie WHERE ID_Parcours = ? AND ID_POI = ?
				{
					listIsInParcours.add(true);
				}
				else {
					listIsInParcours.add(false);
				}
			}
			else {
				listIsInParcours.add(false);
			}
		}

		listX.size();
		((MyJPanelMap) panelMAP).removeArrayList(); 			//VIDE L'ARRAYLIST DE MyJPANELMAP
		((MyJPanelMap) panelMAP).setBoutonGoLieuClicked(true); 	//SET BOUTONGOLIEUCLICKED TO TRUE
		((MyJPanelMap) panelMAP).setNombrePOI(listX.size());	//ENVOI LE NOMBRE DE POI, GRACE A SIZE()
		
		for(int i = 0; i < listX.size(); i++)
		{
			//REMPLISSAGE DE L'ARRAYLIST DE MyJPANELMAP
			((MyJPanelMap) panelMAP).setArrayPositionPOI(listX.get(i), listY.get(i), listIsInParcours.get(i));
		}
		repaint();
	}
	
	public void newListeners()
	{
		
	//PARTIE CONSULTATION ################################
	//LISTENERS - ItemStateChanged
		//ComboBoxLieu
		comboBoxLieu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lieuSelected = true;
				btnGoLieu.setEnabled(true);
			}
		});
		
		//ComboBoxParcours
		comboBoxParcours.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		
	//LISTENERS - ActionPerformed (Bouton)
		//Bouton Go Lieu
		btnGoLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxParcours.setEnabled(true);
				boutonParcoursClicked = false;
				afficherPOI();
				
				comboBoxParcours.removeAllItems();
				List<Parcours> listParcours = null;
				listParcours = lieuProc.ListAllParcoursOfLieu(comboBoxLieu.getSelectedItem().toString());
				for(Parcours e: listParcours) comboBoxParcours.addItem(e.getLibelleParcours());
				((MyJPanelMap) panelMAP).setMapLieu(lieuProc.getImageForLieu(comboBoxLieu.getSelectedItem().toString()));

			}
		});
		//Bouton Go Parcours
		btnGoParcours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boutonParcoursClicked = true;
				afficherPOI();
			}
		});
		
		//Bouton Flèche Précédent POI
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		//Bouton Flèche Suivant POI
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	//LISTENERS - MouseClicked on MAP
		panelMAP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ArrayList<Ellipse2D> listOval = new ArrayList<>();
				listOval = ((MyJPanelMap) panelMAP).getListOval();
				

				for(int i = 0; i < listX.size(); i++)
				{
					if ((e.getButton() == 1) && listOval.get(i).contains(e.getX(), e.getY()))
					{
						System.out.println(listDescriptionPoi.get(i));
						System.out.println(listNamePoi.get(i));
						lblTitre.setText(listNamePoi.get(i));
						lblDescription.setText(listDescriptionPoi.get(i));
					}
				}
			}
		});
		
	//LISTENERS - MouseMotion on MAP
		panelMAP.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}
		});
		//PARTIE EDITION ##########################################################
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setButtonAction(false);
				setEtatEditComponent("9","9");
				labelTypeEDIT.setText("EDITION");
			}
		});
		
		//STEP 1
		btnLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTypeSelected(1);
				setButtonAction(true);
				setEtatEditComponent("9","0");
				labelTypeEDIT.setText("LIEU");
			}
		});
		
		btnParcours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeSelected(2);
				setButtonAction(true);
				setEtatEditComponent("9","0");
				labelTypeEDIT.setText("PARCOURS");
			}
		});
		btnPoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeSelected(3);
				setButtonAction(true);
				setEtatEditComponent("9","0");
				labelTypeEDIT.setText("POI");
			}
		});
		
		//STEP 2
		
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEtatEditComponent(Integer.toString(typeSelected), Integer.toString(1));
			}
		});
		btnMODIF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEtatEditComponent(Integer.toString(typeSelected), Integer.toString(2));
				
			}
		});
		btnDELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEtatEditComponent(Integer.toString(typeSelected), Integer.toString(3));
			}
		});
		
		btnSearchImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.showOpenDialog(null);
				File selectedPfile = chooser.getSelectedFile();
				System.out.println(selectedPfile.getAbsolutePath());
				pathFound = selectedPfile.getAbsolutePath();
				textFieldImage.setText(selectedPfile.getAbsolutePath());
			}
		});
		
		
	}

	
}
