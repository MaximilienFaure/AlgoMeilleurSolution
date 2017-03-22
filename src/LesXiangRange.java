/*l'ensemble des pions qui sont rangés par forme, symbole et couleur*/

class LesXiangRange
{
	int tab[][][];
	int nbCouple;
	
	//Création du tableau contenant les pions triés à partir du plateau de jeu
	LesXiangRange(Plateau p)
	{
		Xiang x;
		nbCouple = p.i*p.j/2;
		
		//le tableau qu'il faut initialiser : 
		//premiere dimension = Symbol
		//deuxieme dimension = Couleur
		//troisieme dimension = Forme
		tab = new int[5][4][3];
		
		//on initialise le tableau à zero (il n y a en effet 0 pions de chaques)
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				for(int k = 0; k < 3; k++)
				{
					tab[i][j][k] = 0;
				}
			}
		}
		
		//on incrémente de 1 le nombre du pion récupéré sur le plateau
		for(int i = 1; i <= p.i; i++)
		{
			for(int j = 1; j <= p.j; j++)
			{
				x = p.getXiang(i,j);
				tab[x.getSymbole().ordinal()][x.getCouleur().ordinal()][x.getForme().ordinal()]++;
			}
		}
		/*for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				for(int k = 0; k < 3; k++)
				{
					System.out.println("tab["+i+"]["+j+"]["+k+"] = " + tab[i][j][k]);
				}
			}
		}*/ 
		
	}
	
	//on supprime du tableau un couple de pion
	void supprimer(CoupleCoordoneeXiang couple)
	{
		Xiang x;
		nbCouple -= 1;
		x = couple.getCoordonnee1().getXiang();
		tab[x.getSymbole().ordinal()][x.getCouleur().ordinal()][x.getForme().ordinal()]--;
		x = couple.getCoordonnee2().getXiang();
		tab[x.getSymbole().ordinal()][x.getCouleur().ordinal()][x.getForme().ordinal()]--;
	}
	
	//on ajoute au tableau un couple de pion
	void ajouter(CoupleCoordoneeXiang couple)
	{
		Xiang x;
		nbCouple += 1;
		x = couple.getCoordonnee1().getXiang();
		tab[x.getSymbole().ordinal()][x.getCouleur().ordinal()][x.getForme().ordinal()]++;
		x = couple.getCoordonnee2().getXiang();
		tab[x.getSymbole().ordinal()][x.getCouleur().ordinal()][x.getForme().ordinal()]++;
	}
	
	//on calcul un score hypothétique dans le but de pouvoir couper des branches. 
	//Exemple : si la branche sur laquelle on calcul le score à un score hypothétique inferieur au score maximal trouvé pour l'instant, 
	//alors on coupe la branche en cours (on ne calcul pas plus loins.
	
	//La technique et de prendre tout les couples parfaitement identique, les multipliers par 1000, 
	//et avec tout les couples restant faire comme si il n'y avait qu'une seul différence dans chaques couple. On a donc une estimation supérieur ou égal au maximum de la branche.
	int calculScoreEstime()
	{
		int val;
		int nbPiece = nbCouple*2;
		int somme = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				for(int k = 0; k < 3; k++)
				{
					val = tab[i][j][k];
					if(val >= 2)
					{
						nbPiece -= (val/2)*2;
						somme += 1000* (val/2);
					}
				}
			}
		}
		somme += 300*(nbPiece/2);
		return somme;
	}
}
