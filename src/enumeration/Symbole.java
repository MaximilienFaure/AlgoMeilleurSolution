package enumeration;

public enum Symbole
{
	CROIX,
	CARRE,
	POINTS,
	VAGUES,
	TRIANGLE;
  
	public static Symbole intTo(int x)
	{
		switch(x) 
		{
		case 0:
			return CROIX;
		case 1:
			return CARRE;
		case 2:
			return POINTS;
		case 3:
			return VAGUES;
		case 4:
			return TRIANGLE;
		default:
			return null;
		}
	}
}
