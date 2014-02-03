package projet.java.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projet.java.modele.Processus;

public class Fenetre {
	
	JFrame oFrame;
	
	JPanel oPanelMain;
	JPanel oPanelGauche;
	JPanel oPanelDroite;
	
	JButton oBouton01;
	JButton oBouton02;
	
	public Fenetre() {
		m_BuildJFrame();
		m_BuildComponent();
		m_BuildJPanel();
		m_Merging();
	}
	
	public void m_BuildJFrame() {
		//Instance JFrame
		oFrame = new JFrame();
		//Configuration JFrame
		oFrame.setVisible(true);
		oFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oFrame.setLocationRelativeTo(null);
		oFrame.setTitle("Yo");
		oFrame.setSize(400,200);
	}
	
	public void m_BuildComponent() {
	//Instance
		//JButton
		oBouton01 = new JButton();
		oBouton02 = new JButton();
		
	//Configuration
		//JButton
			//oBouton01
		oBouton01.setBackground(Color.RED);
		oBouton01.setText("WWWWWWWWWWWWW");
		oBouton01.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				System.out.printf("Pushed");
				Processus oProc = new Processus();
				System.out.println("\n avant m_AffichageResultQuery");
				oProc.m_AffichageResultQuery();
			} 
		});
			//oBouton02
		oBouton02.setBackground(Color.RED);
		oBouton02.setText("Bouton à droite");
		
	}
		
	public void m_BuildJPanel() {
		//Instance
		//JPanel
		oPanelMain = new JPanel();
		oPanelGauche = new JPanel();
		oPanelDroite = new JPanel();

		//Configuration
		//PanelMain
		oPanelMain.setLayout(new BoxLayout(oPanelMain, BoxLayout.LINE_AXIS));
		oPanelMain.setBackground(Color.ORANGE);
		
		//PanelGauche
		oPanelGauche.setBackground(Color.BLUE);
		oPanelGauche.add(oBouton01);
		//PanelDroite
		oPanelDroite.setBackground(Color.PINK);
		oPanelDroite.add(oBouton02);
}	
	
	public void m_Merging(){
		
		//Merging Panel - Component
		oPanelGauche.add(oBouton01);
		oPanelDroite.add(oBouton02);
		
		
		//Merging JPanel - JPanel
		oPanelMain.add(oPanelGauche);
		oPanelMain.add(oPanelDroite);
		
		//Merging JFrame - JPanel
		oFrame.setContentPane(oPanelMain);
	}

}