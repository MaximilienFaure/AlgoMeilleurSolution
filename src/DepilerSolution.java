import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JLabel;

public class DepilerSolution implements ActionListener{
	
	private Plateau plateau;
	private AireDeDessin aire;
	private JLabel infos;
	private PileDeCoup p;
	
	public DepilerSolution(AireDeDessin aire, Plateau plateau, JLabel infos)
	{
		this.aire = aire;
		this.plateau = plateau;
		this.infos = infos;
	}
	
	public void setSolution(PileDeCoup p)
	{
		//Collections.reverse(p);
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int score = p.getScore();
		CoupleCoordoneeXiang c = p.pop();
		score -= p.getScore();
		plateau.del(c);
		infos.setText(""+score);
		aire.repaint();
	}

}
