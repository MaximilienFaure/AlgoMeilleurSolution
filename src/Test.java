
public class Test {

	public static void main(String[] args) {
		Plateau p = new Plateau(4,4);
		p.setXiang(1, 4, new Xiang());
		//p.setXiang(2, 4, new Xiang());
		p.setXiang(2, 3, new Xiang());
		
		System.out.println(p.existeChemin(1, 4, 2, 3));

	}

}
