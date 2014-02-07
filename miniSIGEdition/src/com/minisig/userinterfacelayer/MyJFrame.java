package com.minisig.userinterfacelayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	
	

	//Constructeur
	public MyJFrame() {
		panelMAP = new MyJPanelMap();
		newComponents();
		newListeners();
	}
	

	public void newComponents()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 535);
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
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setVerticalAlignment(SwingConstants.TOP);
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitle.add(lblTitre);
		
		JPanel panelDescription = new JPanel();
		panelPoiCENTER.add(panelDescription);
		
		JLabel lblDescription = new JLabel("Description");
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
		
		JLabel label = new JLabel("EDIT Type");
		panelEditTitle.add(label);
		
		JPanel panelEditButtonTopType = new JPanel();
		panelEditButtonTopType.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEdition.add(panelEditButtonTopType);
		
		JButton btnLieu = new JButton("LIEU");
		panelEditButtonTopType.add(btnLieu);
		
		JButton btnParcours = new JButton("PARCOURS");
		panelEditButtonTopType.add(btnParcours);
		
		JButton btnPoi = new JButton("POI");
		panelEditButtonTopType.add(btnPoi);
		
		JPanel panelEditButtonAction = new JPanel();
		panelEdition.add(panelEditButtonAction);
		
		JButton button = new JButton("MODIF");
		panelEditButtonAction.add(button);
		
		JButton button_1 = new JButton("DELETE");
		panelEditButtonAction.add(button_1);
		
		JButton button_2 = new JButton("ADD");
		panelEditButtonAction.add(button_2);
		
		JPanel panelEditPart = new JPanel();
		panelEdition.add(panelEditPart);
		panelEditPart.setLayout(new BoxLayout(panelEditPart, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditComboBox = new JPanel();
		panelEditPart.add(panelEditComboBox);
		panelEditComboBox.setLayout(new BoxLayout(panelEditComboBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditChoixLieu = new JPanel();
		panelEditComboBox.add(panelEditChoixLieu);
		
		JLabel label_1 = new JLabel("Choix Lieu :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditChoixLieu.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		panelEditChoixLieu.add(comboBox);
		
		JPanel panelEditChoixType = new JPanel();
		panelEditComboBox.add(panelEditChoixType);
		
		JLabel label_2 = new JLabel("Choix [Type] :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditChoixType.add(label_2);
		
		JComboBox comboBox_1 = new JComboBox();
		panelEditChoixType.add(comboBox_1);
		
		JPanel panelEditTextBox = new JPanel();
		panelEditPart.add(panelEditTextBox);
		panelEditTextBox.setLayout(new BoxLayout(panelEditTextBox, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditTextBoxLibelle = new JPanel();
		panelEditTextBox.add(panelEditTextBoxLibelle);
		
		JLabel labelLibelle = new JLabel("Libelle :");
		labelLibelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxLibelle.add(labelLibelle);
		
		textFieldLibelle = new JTextField();
		textFieldLibelle.setColumns(10);
		panelEditTextBoxLibelle.add(textFieldLibelle);
		
		JPanel panelEditTextBoxDescription = new JPanel();
		panelEditTextBox.add(panelEditTextBoxDescription);
		
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxDescription.add(labelDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		panelEditTextBoxDescription.add(textFieldDescription);
		
		JPanel panelEditTextBoxImage = new JPanel();
		panelEditTextBox.add(panelEditTextBoxImage);
		
		JLabel labelImage = new JLabel("Image :");
		labelImage.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditTextBoxImage.add(labelImage);
		
		textFieldImage = new JTextField();
		textFieldImage.setColumns(10);
		panelEditTextBoxImage.add(textFieldImage);
		
		JPanel panelEditPosition = new JPanel();
		panelEditPart.add(panelEditPosition);
		
		JButton btnPosition = new JButton("POSITION");
		panelEditPosition.add(btnPosition);
		
		JLabel label_6 = new JLabel("X");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEditPosition.add(label_6);
		
		JLabel label_7 = new JLabel("-");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditPosition.add(label_7);
		
		JLabel label_8 = new JLabel("Y");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelEditPosition.add(label_8);
		
		JPanel panelEditChoixPOI = new JPanel();
		panelEditPart.add(panelEditChoixPOI);
		
		JLabel label_9 = new JLabel("Choix POI :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditChoixPOI.add(label_9);
		
		JComboBox comboBoxChoixPOI = new JComboBox();
		panelEditChoixPOI.add(comboBoxChoixPOI);
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelEditChoixPOI.add(buttonPlus);
		
		JPanel panelEditListPOI = new JPanel();
		panelEditPart.add(panelEditListPOI);
		
		
		JButton btnRemove = new JButton("REMOVE");
		panelEditListPOI.add(btnRemove);
		
		JPanel panelEditButtonBot = new JPanel();
		panelEdition.add(panelEditButtonBot);
		panelEditButtonBot.setLayout(new BoxLayout(panelEditButtonBot, BoxLayout.PAGE_AXIS));
		
		JPanel panelEditButtonValidate = new JPanel();
		panelEditButtonBot.add(panelEditButtonValidate);
		
		JButton button_6 = new JButton("VALIDER");
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEditButtonValidate.add(button_6);
		
		JPanel panelEditButtonCancel = new JPanel();
		panelEditButtonBot.add(panelEditButtonCancel);
		
		JButton button_7 = new JButton("ANNULER");
		panelEditButtonCancel.add(button_7);

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
//						listIdPOI.get(i);
//						listNamePoi.get(i);
//						listDescriptionPoi.get(i);
						//((MyJPanelMap) panelMAP).setListPopUpOn(i, changeBoolean(listPopUpOn.get(i)));
						System.out.println("YO");
						lblTitre.setText(listNamePoi.get(i));
						lblDescription.setText(listDescriptionPoi.get(i));
					}
				}
				
				
//				double ratioX = (double) ((MyJPanelMap) panelMAP).getWidthPanelMap()/originWidht;
//				double ratioY = (double) ((MyJPanelMap) panelMAP).getHeightPanelMap()/originHeight;
//				
//				double newX = e.getX() / ratioX;
//				double newY = e.getY() / ratioY;
//				
//				//((MyJPanelMap) panelMAP).getHeightPanelMap();
//				System.out.println("widthPanelMap = "+widthPanelMap);
//				System.out.println("originWidht = "+originWidht);
//				System.out.println("ratio = "+ratioX);
//				System.out.println("newX = "+(int)newX+" : ");
//				
//				((MyJPanelMap) panelMAP).setPositionMouse((int)newX, (int) newY);
//				//panelMAP.paintComponents(getGraphics());
//				repaint();s
			}
		});
		
	//LISTENERS - MouseMotion on MAP
		panelMAP.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				
			}
		});
	}
}
