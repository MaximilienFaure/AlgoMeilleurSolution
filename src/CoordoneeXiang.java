import enumeration.*;

class CoordoneeXiang
{
	private int x;
	private int y;
	private Xiang xiang;

	public CoordoneeXiang(int i, int j, Couleur c, Forme f, Symbole s)
	{
		x = i;
		y = j;
		xiang = new Xiang(c,s,f);
	}
	
	public CoordoneeXiang(int i, int j, Xiang xi)
	{
		x = i;
		y = j;
		xiang = xi;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Xiang getXiang() {
		return xiang;
	}

	public void setXiang(Xiang xiang) {
		this.xiang = xiang;
	}
	
	public String toString()
	{
		return "x = " + x + ", y = " + y + xiang.toString();
	}
}
