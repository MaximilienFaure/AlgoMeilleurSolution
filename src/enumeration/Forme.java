package enumeration;

public enum Forme 
{
  CARRE,
  ROND,
  TRIANGLE;
  
  public static Forme intTo(int x)
	{
		switch(x) 
		{
		case 0:
			return CARRE;
		case 1:
			return ROND;
		case 2:
			return TRIANGLE;
		default:
			return null;
		}
	}
}
