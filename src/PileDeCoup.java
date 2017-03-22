import java.util.Stack;
import java.util.Iterator;

class PileDeCoup extends Stack<CoupleCoordoneeXiang>
{
	private int score;
	
	PileDeCoup()
	{
		score = 0;
	}
	
	public CoupleCoordoneeXiang push(CoupleCoordoneeXiang item)
	{
		super.push(item);
		modifierScore(item,1);
		return item;
	}
	
	public CoupleCoordoneeXiang pop()
	{
		CoupleCoordoneeXiang c = super.pop();
		modifierScore(c,-1);
		return c;
		
	}
	
	public void copy(PileDeCoup p)
	{
		clear();
		addAll(p);
		score = p.getScore();
	}
	
	private void modifierScore(CoupleCoordoneeXiang c,int signe)
	{
		int cpt = 0,somme = 0;
		if(c.getCoordonnee1().getXiang().getCouleur() == c.getCoordonnee2().getXiang().getCouleur())
			cpt++;
		if(c.getCoordonnee1().getXiang().getSymbole() == c.getCoordonnee2().getXiang().getSymbole())
			cpt++;
		if(c.getCoordonnee1().getXiang().getForme()== c.getCoordonnee2().getXiang().getForme())
			cpt++;
		if(cpt == 3)
			somme += 1000;
		else if(cpt==2)
			somme += 300;
		else if(cpt==1)
			somme += 50;
		else if(cpt==0)
			somme += 1;
		score += somme*signe;
	}
	
	public int getScore() {
		return score;
	}

	public String toString()
	{
		String s = "";
		Iterator<CoupleCoordoneeXiang> it = this.iterator();
		while(it.hasNext())
		{
			s += it.next().toString() + "\n\n";
		}
		s += "score = " + score;
		return s;
	}

	public void copyAtEnd(PileDeCoup pileDeCoup) {
		super.addAll(pileDeCoup);
		score += pileDeCoup.getScore();
		
	}
}
