package com.minisig.userinterfacelayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyJPanelMap extends JPanel {
	
	public MyJPanelMap(){
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	
	public boolean boutonGoLieuClicked;
	
	String mapLieu = null;
	int nombrePOI;
	int originWidht = 512;
	int originHeight = 408;
	Graphics2D g2d;
	public Graphics2D getG2d() {
		return g2d;
	}

	Ellipse2D oval;
	
	public Ellipse2D getOval() {
		return oval;
	}

	ArrayList<Ellipse2D> listOval = new ArrayList<>();
	
	public ArrayList<Ellipse2D> getListOval() {
		return listOval;
	}

	ArrayList<Integer> listX = new ArrayList<>();
	ArrayList<Integer> listY = new ArrayList<>();
	ArrayList<Boolean> listIsInParcours = new ArrayList<>();
	ArrayList<Boolean> listPopUpOn = new ArrayList<>();
		
	public void setListPopUpOn(int numList, boolean PopUpOn) {
		listPopUpOn.set(numList, PopUpOn);
	}
	
	public boolean changeBoolean(boolean bool) {
		if(bool){bool = false;}
		else{bool = true;}
		return bool;
	}
	
	public void setBoutonGoLieuClicked(boolean boutonGoLieuClicked) {
		this.boutonGoLieuClicked = boutonGoLieuClicked;
	}

	public void removeArrayList()
	{
		listX.removeAll(listX);
		listY.removeAll(listY);
		listIsInParcours.removeAll(listIsInParcours);
	}
	
	public void setArrayPositionPOI(int newX, int newY, boolean isInParcours)
	{
		listX.add(newX);
		listY.add(newY);
		listIsInParcours.add(isInParcours);
	}
	
	public void setIsInParcours(boolean isInParcours)
	{
		listIsInParcours.add(isInParcours);
	}
	
	public void setNombrePOI(int nbrPOI)
	{
		nombrePOI = nbrPOI;
	}
	
	public void setMapLieu(String mapLieu)
	{
		this.mapLieu = mapLieu;
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
		g2d = (Graphics2D) g;
		try 
		{
			
			if(mapLieu != null){
			//Création de l'objet Image
			Image img = ImageIO.read(new File(mapLieu));
			//Draw l'image avec comme taille, la taille du panel
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			} 
		}
		catch (IOException e) 
		{
		e.printStackTrace();
		}
		if(boutonGoLieuClicked == true)
		{
			listOval.removeAll(listOval);
			for(int i = 0; i < listX.size() ; i++)
			{
				if(listIsInParcours.get(i)){g.setColor(Color.red);}
				else{g.setColor(Color.blue);}

				oval = new Ellipse2D.Double(listX.get(i) * getWidth()/originWidht, listY.get(i) * getHeight()/originHeight, 20, 20);
				g2d.fill(oval);
				listOval.add(oval);
			}
		}
	}
}