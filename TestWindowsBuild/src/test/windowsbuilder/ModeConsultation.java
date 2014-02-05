package test.windowsbuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class ModeConsultation extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeConsultation frame = new ModeConsultation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModeConsultation() {
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
		
		JPanel panel = new JPanel();
		panelPoiNORTH.add(panel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(150);
		panel.add(horizontalStrut_1);
		
		JPanel panel_1 = new JPanel();
		panelPoiNORTH.add(panel_1);
		
		JButton btnPrevious = new JButton("<");
		panel_1.add(btnPrevious);
		
		JButton btnNext = new JButton(">");
		panel_1.add(btnNext);
		
		JPanel panelPoiCENTER = new JPanel();
		panelPOI.add(panelPoiCENTER, BorderLayout.CENTER);
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
		panelPOI.add(panelPoiSOUTH, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelPoiSOUTH.add(verticalStrut);
		
		JPanel panelMAP = new JPanel()
		{
			//Taille d'origine de la carte.
			int originWidht = 512;
			int originHeight = 408;
			
			//PARTIE DRAW
			public void paintComponent(Graphics g){
				try 
				{
					//Création de l'objet Image
				Image img = ImageIO.read(new File("D:\\Users\\Gaëtan\\Pictures\\map.png"));
					//Draw l'image avec comme taille, la taille du panel
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				} 
				catch (IOException e) 
				{
				e.printStackTrace();
				}
				
				//Draw un rond (position X, position Y, largeur, hauteur);
				g.fillOval(300 * getWidth()/originWidht, 300 * getHeight()/originHeight, 10, 10);
			}
		};
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
		
		JComboBox comboBoxLieu = new JComboBox();
		comboBoxLieu.setModel(new DefaultComboBoxModel(new String[] {"Paris", "Marraqu\u00E8che", "Alger"}));
		panelMenu.add(comboBoxLieu);
		
		JButton btnGoLieu = new JButton("Go");
		panelMenu.add(btnGoLieu);
		
		JComboBox comboBoxParcours = new JComboBox();
		comboBoxParcours.setModel(new DefaultComboBoxModel(new String[] {"Maisons \u00E0 paris"}));
		panelMenu.add(comboBoxParcours);
		
		JButton btnGoParcours = new JButton("Go");
		panelMenu.add(btnGoParcours);
	}
}
