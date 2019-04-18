package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageViewer extends JPanel{
	
	public ImageIcon image;	
	final int SIZE = 32;
	
	JLabel lbl;
	
	BufferedImage mainImage;
	BufferedImage subImage;	
	
	File tileSetImage;
	
	
	public ImageViewer() {	
		
		try {
			loadMainImage();
		}
		catch(Exception ex) {	
			
			Window.getComps().say(ex.getMessage());
		}		
	
		setBounds(350, 550, 160, 160);					
		setVisible(true);						
	}
	
	private void loadMainImage() throws IOException {					
		tileSetImage = new File(Constants.resPath + "MainTileSet.png");		
		mainImage = ImageIO.read(tileSetImage);	
		subImage = mainImage;
	}
	
	public void paint(Graphics g) {		
		g.drawImage(subImage, 0, 0, this);		
	}
	
	public void getSubImage(int id) {
		Graphics g = mainImage.getGraphics();
		int x = id / 40;
		int y = id % 40;
		System.out.println(x + " : "+ y);
		subImage = mainImage.getSubimage(x, y, SIZE, SIZE);	
		
		g.drawImage(subImage, 0, 0, this);
		
		Program.mainWindow.repaint();
	}
	
	
	

}
