class CoupleCoordoneeXiang
{
	private CoordoneeXiang c1;
	private CoordoneeXiang c2;

	public CoupleCoordoneeXiang(int i, int j,Xiang x1, int k, int l,Xiang x2)
	{
		c1 = new CoordoneeXiang(i,j,x1);
		c2 = new CoordoneeXiang(k,l,x2);
	}
	
	public CoordoneeXiang getCoordonnee1() {
		return c1;
	}

	public void setCoordonnee1(CoordoneeXiang c1) {
		this.c1 = c1;
	}

	public CoordoneeXiang getCoordonnee2() {
		return c2;
	}

	public void setCoordonnee2(CoordoneeXiang c2) {
		this.c2 = c2;
	}
	
	public String toString()
	{
		return "Le premier xiang est : " + c1.toString() + "\nLe deuxieme xiang est : " + c2.toString();
	}
}
