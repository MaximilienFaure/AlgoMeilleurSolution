package enumeration;
public enum Couleur 
{
	ROUGE,
	VERT,
	JAUNE,
	BLEU;
  
	public static Couleur intTo(int x)
	{
		switch(x) 
		{
		case 0:
			return ROUGE;
		case 1:
			return VERT;
		case 2:
			return JAUNE;
		case 3:
			return BLEU;
		default:
			return null;
		}
	}
}
