package ihm.mainframe;

import business.modele.*;
import business.processus.LieuDAO;
import business.table.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class WindowsBuilderTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilderTest frame = new WindowsBuilderTest();
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
	public WindowsBuilderTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 371);
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
		panelPOI.setLayout(new BoxLayout(panelPOI, BoxLayout.PAGE_AXIS));
		
		JPanel panel_5 = new JPanel();
		panelPOI.add(panel_5);
		
		JButton button = new JButton("<");
		panel_5.add(button);
		
		JButton button_1 = new JButton(">");
		panel_5.add(button_1);
		
		JPanel panel_6 = new JPanel();
		panelPOI.add(panel_6);
		
		JLabel lblTitre = new JLabel("Titre");
		panel_6.add(lblTitre);
		
		JPanel panel_7 = new JPanel();
		panelPOI.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();
		panel_7.add(panel);
		
		JLabel lblDescription = new JLabel("Description");
		panel.add(lblDescription);
		
		JPanel panel_1 = new JPanel();
		panel_7.add(panel_1);
		
		JPanel panelMove = new JPanel();
		panelPOI.add(panelMove);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(100);
		panelMove.add(horizontalStrut_4);
		
		JPanel panelMAP = new JPanel()
		{
			public void paintComponent(Graphics g){
				try 
				{
				Image img = ImageIO.read(new File("C:\\Users\\Nico\\Desktop\\stationnement-payant-paris.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				} 
				catch (IOException e) 
				{
				e.printStackTrace();
				}
				
				g.fillOval(0,0, 10, 10);
				System.out.println(getWidth());
				g.fillOval(150 * getWidth()/326, 150 * getHeight()/259, 10, 10);
			}
		};
		panelMAP.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCenter.add(panelMAP, BorderLayout.CENTER);

		
		
//		
		
//		Graphics g = null;
//		try{
//		Image img = ImageIO.read(new File("D:\\Users\\Gaëtan\\Pictures\\map.png"));
//		g.drawImage(img, 0, 0, panelMAP.getWidth(), panelMAP.getHeight(), panelMAP);
//		}
//		catch (Exception e)
//		{
//			
//		}
		
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paris", "Marraqu\u00E8che", "Alger"}));
		panelMenu.add(comboBox);
		
		List<Lieu> lieus = null;
		ProcessusLieu li = new ProcessusLieu();
		lieus = li.ListAllLieu();
		for(Lieu e : lieus){
			comboBox.addItem(e.getNameLieu());
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Maisons \u00E0 paris"}));
		panelMenu.add(comboBox_1);
	}
}
