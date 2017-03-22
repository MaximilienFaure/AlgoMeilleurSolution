import java.util.Stack;

import enumeration.*;

class Plateau {
	int i;// nombre de lignes
	int j;// nombre de colonnes
	private Xiang tab[/* nombre de lignes */][/* nombre de colonnes */];

	/*
	 * 
	 * 
	 * //Xiang[7][6] Plateau(int x, int y) { i = x; j = y; tab = new
	 * Xiang[x+2][y+2]; for(int i = 0;i<tab.length;i++) { tab[i][y+1]=new
	 * Xiang(); tab[i][0]=new Xiang(); } for(int i = 0;i<tab[0].length;i++) {
	 * tab[x+1][i]=new Xiang(); tab[0][i]=new Xiang(); }
	 * 
	 * tab[1][1] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.ROND); tab[1][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND); tab[1][3] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[1][4] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[1][5] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[1][6] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE);
	 * 
	 * tab[2][1] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE); tab[2][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[2][3] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE); tab[2][4] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.ROND); tab[2][5] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.TRIANGLE); tab[2][6] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.POINTS,enumeration.
	 * Forme.ROND);
	 * 
	 * tab[3][1] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND); tab[3][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[3][3] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); tab[3][4] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[3][5] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.CARRE,enumeration.
	 * Forme.ROND); tab[3][6] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE);
	 * 
	 * tab[4][1] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND); tab[4][2] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE); tab[4][3] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[4][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE); tab[4][5] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[4][6] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.CROIX,enumeration.
	 * Forme.TRIANGLE);
	 * 
	 * tab[5][1] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CROIX,enumeration.
	 * Forme.TRIANGLE); tab[5][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.POINTS,enumeration.
	 * Forme.ROND); tab[5][3] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); tab[5][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE); tab[5][5] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.POINTS,enumeration.
	 * Forme.ROND); tab[5][6] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE);
	 * 
	 * tab[6][1] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.ROND); tab[6][2] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[6][3] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[6][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.TRIANGLE); tab[6][5] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[6][6] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.TRIANGLE);
	 * 
	 * tab[7][1] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); tab[7][2] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[7][3] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.CARRE,enumeration.
	 * Forme.ROND); tab[7][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[7][5] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[7][6] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); } //
	 */

	/*
	 * 
	 * //Xiang[7][6] Plateau(int x, int y) { i = x; j = y; tab = new
	 * Xiang[x+2][y+2]; for(int i = 0;i<tab.length;i++) { tab[i][y+1]=new
	 * Xiang(); tab[i][0]=new Xiang(); } for(int i = 0;i<tab[0].length;i++) {
	 * tab[x+1][i]=new Xiang(); tab[0][i]=new Xiang(); }
	 * 
	 * tab[1][1] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE); tab[1][2] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[1][3] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[1][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE); tab[1][5] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[1][6] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.ROND);
	 * 
	 * tab[2][1] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE); tab[2][2] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[2][3] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.TRIANGLE); tab[2][4] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[2][5] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE); tab[2][6] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND);
	 * 
	 * tab[3][1] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); tab[3][2] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[3][3] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[3][4] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.ROND); tab[3][5] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.POINTS,enumeration.
	 * Forme.ROND); tab[3][6] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.TRIANGLE);
	 * 
	 * tab[4][1] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[4][2] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE); tab[4][3] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[4][4] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE); tab[4][5] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.TRIANGLE); tab[4][6] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND);
	 * 
	 * tab[5][1] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.ROND); tab[5][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); tab[5][3] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.ROND); tab[5][4] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.ROND); tab[5][5] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.ROND); tab[5][6] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE);
	 * 
	 * tab[6][1] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.POINTS,enumeration.
	 * Forme.TRIANGLE); tab[6][2] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[6][3] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.CARRE); tab[6][4] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.ROND); tab[6][5] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND); tab[6][6] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.POINTS,enumeration.
	 * Forme.CARRE);
	 * 
	 * tab[7][1] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.ROND); tab[7][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.CARRE); tab[7][3] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CROIX,enumeration.
	 * Forme.ROND); tab[7][4] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CARRE,enumeration.
	 * Forme.TRIANGLE); tab[7][5] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND); tab[7][6] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.ROND); } //
	 */

	// *

	// Xiang[][]
	Plateau(int x, int y) {
		i = x;
		j = y;
		tab = new Xiang[x + 2][y + 2];
	}// */

	/*
	 * 
	 * //Xiang[3][4] Plateau(int x, int y) { i = x; j = y; tab = new
	 * Xiang[x+2][y+2]; for(int i = 0;i<tab.length;i++) { tab[i][y+1]=new
	 * Xiang(); tab[i][0]=new Xiang(); } for(int i = 0;i<tab[0].length;i++) {
	 * tab[x+1][i]=new Xiang(); tab[0][i]=new Xiang(); }
	 * 
	 * tab[1][1] = new
	 * Xiang(enumeration.Couleur.ROUGE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[1][2] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.TRIANGLE); tab[1][3] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[1][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.TRIANGLE);
	 * 
	 * tab[2][1] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CROIX,enumeration.
	 * Forme.TRIANGLE); tab[2][2] = new
	 * Xiang(enumeration.Couleur.BLEU,enumeration.Symbole.TRIANGLE,enumeration.
	 * Forme.TRIANGLE); tab[2][3] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[2][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE);
	 * 
	 * tab[3][1] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[3][2] = new
	 * Xiang(enumeration.Couleur.JAUNE,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); tab[3][3] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.VAGUES,enumeration.
	 * Forme.CARRE); tab[3][4] = new
	 * Xiang(enumeration.Couleur.VERT,enumeration.Symbole.CROIX,enumeration.
	 * Forme.CARRE); }//
	 */

	public void init() {

		for (int i = 0; i < tab.length; i++) {
			tab[i][this.j + 1] = new Xiang();
			tab[i][0] = new Xiang();
		}

		for (int i = 0; i < tab[0].length; i++) {
			tab[this.i + 1][i] = new Xiang();
			tab[0][i] = new Xiang();
		}

		/*
		 * tab[1][1] = new Xiang(Couleur.JAUNE,Symbole.CARRE,Forme.TRIANGLE);
		 * tab[1][2] = new Xiang(Couleur.JAUNE,Symbole.VAGUES,Forme.ROND);
		 * 
		 * tab[2][1] = new Xiang(Couleur.ROUGE,Symbole.TRIANGLE,Forme.ROND);
		 * tab[2][2] = new Xiang(Couleur.BLEU,Symbole.VAGUES,Forme.CARRE);
		 * 
		 * tab[3][1] = new Xiang(Couleur.ROUGE,Symbole.CROIX,Forme.TRIANGLE);
		 * tab[3][2] = new Xiang(Couleur.JAUNE,Symbole.CARRE,Forme.TRIANGLE);
		 * 
		 * tab[4][1] = new Xiang(Couleur.JAUNE,Symbole.VAGUES,Forme.ROND);
		 * tab[4][2] = new Xiang(Couleur.JAUNE,Symbole.TRIANGLE,Forme.ROND);
		 */

		for (int i = 1; i <= this.i; i++) {
			for (int j = 1; j <= this.j; j++) {
				tab[i][j] = new Xiang(Couleur.intTo((int) (Math.random() * 4)),
						Symbole.intTo((int) (Math.random() * 5)), Forme.intTo((int) (Math.random() * 3)));
			}
		}
	}

	Xiang getXiang(int i, int j) {
		return tab[i][j];
	}

	public void setXiang(int i, int j, Xiang x) {
		tab[i][j] = x;
	}

	boolean existeChemin(int i, int j, int k, int l) {
		boolean trouve = false;
		int deplacementX = i - k, deplacementY = j - l, signeX, signeY, x, y;
		if (deplacementX > 0)
			signeX = -1;
		else if (deplacementX < 0)
			signeX = 1;
		else
			signeX = 0;
		if (deplacementY > 0)
			signeY = -1;
		else if (deplacementY < 0)
			signeY = 1;
		else
			signeY = 0;
		x = i;
		y = j;

		// du coup pas besoin de voir si il existe un chemin entre ce pions et
		// pions déjà analysé
		if (deplacementY != -1 || deplacementX != -1) {

			// on décal d'un rang pour ne pas tester le pion de départ (sinon on
			// s'arrêterait directement)
			x += signeX;
			// on vérifie si il y a un pion entre celui de départ et la ligne ou
			// se trouve le pion de fin
			while (x != k && tab[x][y] == null) {
				x += signeX;
			}

			// si x == k alors il n'y a pas de pion sur l'axe des ordonnée sur
			// le chemin
			if (x == k) {
				while (y != l && tab[x][y] == null) {
					y += signeY;
				}

				// si y == l alors on a pas de pion sur l'axe des abscice sur le
				// chemin.
				// on a donc un chemin entre les deux pions.
				if (y == l) {
					trouve = true;
				}
			}
			if (!trouve) {
				x = i;
				y = j;

				y += signeY;
				while (y != l && tab[x][y] == null) {
					y += signeY;
				}

				if (y == l) {
					while (x != k && tab[x][y] == null) {
						x += signeX;
					}

					if (x == k) {
						trouve = true;
					}
				}
			}
		}
		return trouve;
	}

	Stack<CoupleCoordoneeXiang> lesLiens() {
		int k, l;
		CoupleCoordoneeXiang c;
		Stack<CoupleCoordoneeXiang> p = new Stack<CoupleCoordoneeXiang>();
		for (int i = 1; i <= this.i; i++) {
			for (int j = 1; j <= this.j; j++) {
				// si un pion est présent
				if (tab[i][j] != null) {
					k = i;
					l = j + 1;
					if (l == this.j + 1) {
						k++;
						l = 1;
					}

					// on ne parcourt que les pions après celui selectionné car
					// on a déjà vérifier si il y a avait
					// un chemin avec celui ci quand c'était les pions
					// précédents qui était séléctionné
					while (k <= this.i) {
						if (tab[k][l] != null && existeChemin(i, j, k, l)) {
							c = new CoupleCoordoneeXiang(i, j, tab[i][j], k, l, tab[k][l]);
							p.push(c);
						}
						l++;
						if (l == this.j + 1) {
							k++;
							l = 1;
						}
					}
				}
			}
		}
		return p;
	}

	void del(CoupleCoordoneeXiang c) {
		tab[c.getCoordonnee1().getX()][c.getCoordonnee1().getY()] = null;
		tab[c.getCoordonnee2().getX()][c.getCoordonnee2().getY()] = null;
	}

	void add(CoupleCoordoneeXiang c) {
		tab[c.getCoordonnee1().getX()][c.getCoordonnee1().getY()] = c.getCoordonnee1().getXiang();
		tab[c.getCoordonnee2().getX()][c.getCoordonnee2().getY()] = c.getCoordonnee2().getXiang();
	}

	void affiche() {
		for (int i = 1; i <= this.i; i++) {
			for (int j = 1; j <= this.j; j++) {
				if (tab[i][j] == null)
					System.out.print("( NULL) ");
				else
					System.out.print("(" + tab[i][j].getCouleur() + ", " + tab[i][j].getSymbole() + ", "
							+ tab[i][j].getForme() + ") ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	Plateau copie() {
		Plateau p = new Plateau(i, j);
		for (int i = 1; i <= this.i; i++) {
			for (int j = 1; j <= this.j; j++) {
				p.tab[i][j] = tab[i][j];
			}
		}
		return p;
	}

	boolean egal(Plateau p) {
		boolean b = true;
		int i = 1;
		int j;
		while (i <= this.i && b) {
			j = 1;
			while (j <= this.j && b) {
				if(tab[i][j] != null && p.tab[i][j] != null)
					b = p.tab[i][j].egal(tab[i][j]);
				else
					b = (tab[i][j] == null)&&(p.tab[i][j] == null);
				j++;
			}
			i++;
		}
		return b;
	}

	public int getNbLignes() {
		return i;
	}

	public int getNbColonnes() {
		return j;
	}

	public int hashCode() {
		int hash = 0;
		for (int i = 1; i <= this.i; i++) {
			for (int j = 1; j <= this.j; j++) {
				if (tab[i][j] != null)
				{
					hash += tab[i][j].hashCode() * Math.pow(10, i) * j + 500009;
				}
				
			}
		}
		
		hash = hash % 1000003;
		return hash;
	}
}