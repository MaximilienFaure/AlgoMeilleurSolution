import java.awt.BorderLayout;
import java.awt.Button;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Principale {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Xian-xiang");

		int a = 7, b = 4;
		Plateau plateau = new Plateau(a, b);
		plateau.init();
		LesXiangRange lxr = new LesXiangRange(plateau);
		System.out.println("score : " + lxr.calculScoreEstime());
		PileDeCoup enCours = new PileDeCoup(), fin = new PileDeCoup();
		ConfigurationExistante hash = new ConfigurationExistante();

		AireDeDessin aire = new AireDeDessin(plateau);

		Button bouttonCalcul = new Button("Calcul");
		Button bouttonAvance = new Button("Coup suivant");
		bouttonAvance.setEnabled(false);

		JLabel infos = new JLabel("aucune");
		DepilerSolution depileSolution = new DepilerSolution(aire, plateau, infos);

		bouttonAvance.addActionListener(depileSolution);

		JPanel bas = new JPanel();
		bas.add(bouttonCalcul, BorderLayout.WEST);
		bas.add(bouttonAvance, BorderLayout.EAST);
		bas.add(infos, BorderLayout.SOUTH);

		frame.add(aire);
		frame.add(bas, BorderLayout.SOUTH);

		// Un clic sur le bouton de fermeture clos l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// On fixe la taille et on demarre
		frame.setSize(500, 500);
		frame.setVisible(true);

		Plateau plateauAAnaliser = plateau.copie();

		// l'algo principale qui calacul le score avec une pile de coup à faire
		PileDeCoup chemin = new PileDeCoup();
		int temps = (int) (System.currentTimeMillis()/1000);
		prog(plateauAAnaliser, enCours, fin, lxr, chemin, hash);
		temps = (int) (System.currentTimeMillis()/1000 -temps) ;
		infos.setText(""+temps);

		depileSolution.setSolution(chemin);
		bouttonAvance.setEnabled(true);

		//peut être marrant de voir les différentes possibilités
		/*Collection<ElementDeConfiguration> values = hash.values();
		Iterator<ElementDeConfiguration> it = values.iterator();
		while (it.hasNext()) {
				aire.setPlateau(it.next().getPlateau());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}*/

		System.out.println(chemin);
		System.out.println(fin.getScore());

	}

	static void prog(Plateau p, PileDeCoup ec, PileDeCoup f, LesXiangRange lxr, PileDeCoup parent,
			ConfigurationExistante hash) {
		CoupleCoordoneeXiang c;
		Stack<CoupleCoordoneeXiang> ensemble = p.lesLiens();
		PileDeCoup maxEnfant = new PileDeCoup();

		if (!ensemble.isEmpty()) {
			if (lxr.calculScoreEstime() + ec.getScore() > f.getScore()) {				
				int hashcode = p.hashCode();
				boolean configurationDejaAnalyse = hash.containsKey(hashcode);
				
				ElementDeConfiguration memeConfiguration = null;
				
				if(configurationDejaAnalyse)
				{
					boolean egal = false;
					
					ArrayList<ElementDeConfiguration> liste = hash.get(hashcode);
					if(liste.size()>1)
					{
						System.out.println("au moins 1 colisions !");
					}
					Iterator<ElementDeConfiguration> it = liste.iterator();
					
					memeConfiguration = null;
					while(it.hasNext() && !egal)
					{
						memeConfiguration = it.next();
						egal = p.egal(memeConfiguration.getPlateau());
					}
					
					// on verifie qu'il n'y a pas eu de collision
					if (!egal) {
						configurationDejaAnalyse = false;
					}
				}
				
				if (!configurationDejaAnalyse) {
					while (!ensemble.isEmpty()) {
						// on initialise enfant dans la boucle au cas ou dans la
						// fonction fille :
						// on ne passe pas par parent.copy(maxEnfant)
						PileDeCoup enfant = new PileDeCoup();

						// prendre un coup
						c = ensemble.pop();

						// ajouter le coup à la liste des coups de la liste
						// actuelle et ajouter le score du coup au score de la
						// pile (si les
						// deux pions du coup sont identique on ajoute 1000 par
						// exemple)
						ec.push(c);

						// on supprime les deux pions du plateau
						p.del(c);

						// on supprime les deux pions du rangement des pions
						lxr.supprimer(c);

						// on rappel le programme avec les objets utilisé pour
						// fabriqué le meilleur chemin de coup possible
						prog(p, ec, f, lxr, enfant, hash);

						enfant.push(c);
						if (enfant.getScore() > maxEnfant.getScore()) {
							maxEnfant.copy(enfant);
						}
						enfant.pop();

						// on remet l'ensemble des objets dans l'états avant
						// l'appel a "prog" de sorte qu'on soit dans le même
						// état qu'avant de faire le premier coup
						// on peut donc choisir un nouveau coup et donc faire
						// une autre branche dans l'arbre des choix
						lxr.ajouter(c);
						p.add(c);
						ec.pop();

					}
					// Si on arrive ici c'est que la position actuelle du
					// plateau n'a jamais été rencontré
					
					ArrayList<ElementDeConfiguration> array = new ArrayList<ElementDeConfiguration>();
					ElementDeConfiguration elem = new ElementDeConfiguration(p, maxEnfant);
					array.add(elem);
					
					// on ajoute donc cette position dans la map
					hash.put(hashcode, array);
				} else {
					// ici la position a déjà été ajouté dans la map on recupère
					// donc le plateau et la pileDeCoup
					maxEnfant.copyAtEnd(memeConfiguration.getPileDeCoup());
					if(ec.getScore() + memeConfiguration.getPileDeCoup().getScore() > f.getScore())
					{
						f.copy(ec);
						f.copyAtEnd(memeConfiguration.getPileDeCoup());
					}

				}
				parent.copy(maxEnfant);
			}
		} else {
			if (ec.getScore() > f.getScore()) {
				f.copy(ec);
			}
		}
	}
}
