package com.minisig.userinterfacelayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics2D;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.minisig.businesslayer.table.*;
import com.minisig.businesslayer.processus.*;

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
		setBounds(100, 100, 700, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPOI = new JPanel();
		panelPOI.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCenter.add(panelPOI, BorderLayout.EAST);
		panelPOI.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPoiNORTH = new JPanel();
		panelPOI.add(panelPoiNORTH, BorderLayout.NORTH);
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
		panelPOI.add(panelPoiCENTER, BorderLayout.CENTER);
		panelPoiCENTER.setLayout(new BoxLayout(panelPoiCENTER, BoxLayout.PAGE_AXIS));
		
		panelTitle = new JPanel();
		panelPoiCENTER.add(panelTitle);
		
		lblTitre = new JLabel("Titre");
		lblTitre.setVerticalAlignment(SwingConstants.TOP);
		lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitle.add(lblTitre);
		
		panelDescription = new JPanel();
		panelPoiCENTER.add(panelDescription);
		
		lblDescription = new JLabel("Description");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		panelDescription.add(lblDescription);
		
		JPanel panelImage = new JPanel();
		panelPoiCENTER.add(panelImage);
		
		JPanel panelPoiSOUTH = new JPanel();
		panelPOI.add(panelPoiSOUTH, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelPoiSOUTH.add(verticalStrut);
		
		
		
		
		

		panelMAP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCenter.add(panelMAP, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(400);
		panelMAP.add(horizontalStrut);

		JPanel panelNorth = new JPanel();
		panelNorth.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMode = new JPanel();
		panelNorth.add(panelMode, BorderLayout.NORTH);
		
		JLabel lblModeConsultation = new JLabel("Mode Consultation");
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
		comboBoxParcours.setModel(new DefaultComboBoxModel(new String[] {""}));
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
