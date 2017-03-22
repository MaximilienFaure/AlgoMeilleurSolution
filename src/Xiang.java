import enumeration.*;

class Xiang
{
	private Couleur coul;
	private Symbole symb;
	private Forme forme;
	private int bord;
   
   Xiang()
   {
      	bord = -1;
   }
   
	Xiang(Couleur c, Symbole s, Forme f)
	{
		coul = c;
		symb = s;
		forme = f;
      	bord = 0;
	}
	
	boolean egal(Xiang x)
	{
		return x.coul == coul && x.symb == symb && x.forme == forme;
	}
	
	int val()
	{
		return coul.ordinal() + (int)Math.pow(symb.ordinal(),2) + (int)Math.pow(forme.ordinal(),3);
	}
	
	
	
	public Couleur getCouleur() {
		return coul;
	}

	public void setCouleur(Couleur coul) {
		this.coul = coul;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public Symbole getSymbole() {
		return symb;
	}

	public void setSymbole(Symbole symb) {
		this.symb = symb;
	}
	
	public int hashCode()
	{
		return symb.ordinal()*100 + coul.ordinal() *10 + forme.ordinal();
	}

	public String toString()
	{
		return " " + coul+ " " + symb+ " " + forme;
	}
}
