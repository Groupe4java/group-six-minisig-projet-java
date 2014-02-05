package test.windowsbuilder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyJPanelMap extends JPanel {
	
	public MyJPanelMap(){
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	
	String mapLieu = "D:\\Users\\Gaëtan\\Pictures\\map.png";
	int nombrePOI;
	int originWidht = 512;
	int originHeight = 408;
	
	int posMouseX[];
	int posMouseY[];
	
	public void setPositionPOI(int posTableau, int newX, int newY)
	{
		posMouseX[posTableau] = newX;
		posMouseY[posTableau] = newY;
	}
	
	public void setNombrePOI(int nbrPOI)
	{
		nombrePOI = nbrPOI;
	}
	
	public void setMapLieu(String mapLieu)
	{
		mapLieu = this.mapLieu;
	}
	
	
	public int getWidthPanelMap()
	{
		int widthPanelMap;
		return widthPanelMap = getWidth();
	}
	
	public int getHeightPanelMap()
	{
		int heightPanelMap;
		return heightPanelMap = getHeight();
	}
	
	//PARTIE DRAW
	public void paintComponent(Graphics g){
		try 
		{
			System.out.println("TEST");
			//Création de l'objet Image
		Image img = ImageIO.read(new File(mapLieu));
			//Draw l'image avec comme taille, la taille du panel
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} 
		catch (IOException e) 
		{
		e.printStackTrace();
		}
		
		System.out.println("AVANT FOR");
		//Draw un rond (position X, position Y, largeur, hauteur);
		for(int i = 1; i <= nombrePOI ; i++)
		{
			System.out.println("DEBUT FOR");
			g.fillOval(posMouseX[i] * getWidth()/originWidht, posMouseY[i] * getHeight()/originHeight, 50, 50);
			System.out.println("FIN FOR");
		}
		System.out.println("TEST");
		System.out.println("y ="+posMouseY);
		System.out.println("FIN PAINT");
	}
}