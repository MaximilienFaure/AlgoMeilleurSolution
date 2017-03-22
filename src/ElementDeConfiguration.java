
public class ElementDeConfiguration {
	
	private Plateau p;
	private PileDeCoup pile;

	public ElementDeConfiguration(Plateau p, PileDeCoup pile) {
		this.p = p.copie();
		this.pile = pile;
	}
	
	public Plateau getPlateau()
	{
		return p;
	}
	
	public PileDeCoup getPileDeCoup()
	{
		return pile;
	}
}
