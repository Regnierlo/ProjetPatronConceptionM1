package angryballs.modele;

import java.util.Vector;
import angryballs.modele.Bille;
import angryballs.modele.OutilsBille;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * Operations utiles sur les billes
 */

public class OutilsBille {
	/**
	 * @param billes
	 *            est la liste de TOUTES les billes en mouvement
	 * @param cetteBille
	 *            est l'une d'entre elles.
	 * @return la liste des autres billes que cetteBille, c'est-a-dire la liste de
	 *         toutes les billes sauf cetteBille
	 * 
	 */
	public static Vector<Billeable> autresBilles(Billeable cetteBille, Vector<Billeable> billes) {
		Vector<Billeable> autresBilles = new Vector<Billeable>();
		Billeable billeCourante;
		int i;

		for (i = 0; i < billes.size(); ++i) {
			billeCourante = billes.get(i);
			if (billeCourante.getClef() != cetteBille.getClef())
				autresBilles.add(billeCourante);
		}

		return autresBilles;
	}

	/**
	 * @param cetteBille
	 *            : une bille particuliere
	 * @param billes
	 *            : une liste de billes, cette liste peut contenir cette bille
	 *
	 *            gestion de l'eventuelle collision de cette bille avec les autres
	 *            billes
	 *
	 *            billes est la liste de toutes les billes en mouvement
	 * 
	 *            Le comportement par defaut est le choc parfaitement elastique
	 *            (c-a-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs
	 *         vitesses des 2 billes impliquees dans le choc sont modifiees si
	 *         renvoie false, il n'y a pas de collision et les billes sont laissees
	 *         intactes
	 */
	public static boolean gestionCollisionBilleBille(Bille cetteBille, Vector<Billeable> billes) {
		// on recupere d'abord dans autresBilles toutes les billes sauf cetteBille

		Vector<Billeable> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

		// on cherche a present la 1ere des autres billes avec laquelle cetteBille est en collision 
		// on suppose qu'il ne peut y avoir de collision qui implique plus de deux billes a la fois 

		Billeable billeCourante;

		int i;

		for (i = 0; i < autresBilles.size(); ++i) {
			billeCourante = autresBilles.get(i);
			if (Collisions.CollisionBilleBille(cetteBille.getPosition(), cetteBille.getRayon(), cetteBille.getVitesse(),
					cetteBille.masse(), billeCourante.getPosition(), billeCourante.getRayon(),
					billeCourante.getVitesse(), billeCourante.masse()))
				return true;
		}
		return false;
	}

	/**
	 * @param cetteBille
	 *            : une bille particuliere
	 * @param billes
	 *            : une liste de billes, cette liste peut contenir cettebille
	 * 
	 *            On suppose que cetteBille subit l'attraction gravitationnelle due
	 *            aux billes contenues dans "billes" autres que cetteBille.
	 * 
	 *            tache : calcule a, le vecteur acceleration subi par cetteBille
	 *            resultant de l'attraction par les autres billes de la liste.
	 * 
	 * @return a : le vecteur acceleration resultant
	 * 
	 */
	public static Vecteur gestionAccelerationNewton(Billeable cetteBille, Vector<Billeable> billes) {

		// on recupere d'abord dans autresBilles toutes les billes sauf celle-ci

		Vector<Billeable> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

		// a present on recupere les masses et les positions des autres billes 
		int i;
		Billeable billeCourante;

		int d = autresBilles.size();

		double masses[] = new double[d]; // les masses des autres billes
		Vecteur C[] = new Vecteur[d]; // les positions des autres billes

		for (i = 0; i < d; ++i) {
			billeCourante = autresBilles.get(i);
			masses[i] = billeCourante.masse();
			C[i] = billeCourante.getPosition();
		}

		// a present on calcule le champ de gravite exerce par les autres billes sur cette bille

		return MecaniquePoint.champGravitéGlobal(cetteBille.getPosition(), masses, C);
	}
}