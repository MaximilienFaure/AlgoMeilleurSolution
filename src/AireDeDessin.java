import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;

class AireDeDessin extends JComponent {
	private Plateau plateau;
	private int width;
	private int height;

	private Image images[][][];

	public AireDeDessin(Plateau p) {
		plateau = p;
		images = new Image[5][4][3];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 3; k++) {
					try {
						images[i][j][k] = ImageIO.read(
								new File("images/" + getSymbole(i) + "" + getCouleur(j) + "" + getForme(k) + ".png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		// Graphics 2D est le vrai type de l'objet passe en parametre
		// Le cast permet d'avoir acces a un peu plus de primitives de dessin
		Graphics2D drawable = (Graphics2D) g;

		int nbColonne = plateau.getNbColonnes(), nbLigne = plateau.getNbLignes();
		int i, j;
		width = getSize().width;
		height = getSize().height;

		// On efface tout
		drawable.setPaint(Color.white);
		drawable.fillRect(0, 0, width, height);
		drawable.setPaint(Color.black);

		for (i = 0; i <= nbColonne; i++) {
			drawable.drawLine(i * width / nbColonne, 0, i * width / nbColonne, height);
		}
		for (i = 0; i <= nbLigne; i++) {
			drawable.drawLine(0, i * height / nbLigne, width, i * height / nbLigne);
		}

		for (i = 1; i <= nbLigne; i++) {
			for (j = 1; j <= nbColonne; j++) {
				Xiang x = plateau.getXiang(i, j);
				if (x != null) {
					Image image = images[x.getSymbole().ordinal()][x.getCouleur().ordinal()][x.getForme().ordinal()];
					drawable.drawImage(image, (j - 1) * (width / nbColonne), (i - 1) * (height / nbLigne),
							width / nbColonne, height / nbLigne, this);
				}
			}
		}
	}
	
	public void setPlateau(Plateau p)
	{
		this.plateau = p;
		this.repaint();
	}

	private char getSymbole(int i) {
		char monChar = 'n';
		switch (i) {
		case 0:
			monChar = 'c';
			break;
		case 1:
			monChar = 'r';
			break;
		case 2:
			monChar = 'p';
			break;
		case 3:
			monChar = 'v';
			break;
		case 4:
			monChar = 't';
			break;
		}
		return monChar;
	}

	private char getForme(int i) {
		char monChar = 'n';
		switch (i) {
		case 0:
			monChar = 'c';
			break;
		case 1:
			monChar = 'r';
			break;
		case 2:
			monChar = 't';
			break;
		}
		return monChar;
	}

	private char getCouleur(int i) {
		char monChar = 'n';
		switch (i) {
		case 0:
			monChar = 'r';
			break;
		case 1:
			monChar = 'v';
			break;
		case 2:
			monChar = 'j';
			break;
		case 3:
			monChar = 'b';
			break;
		}
		return monChar;
	}

}