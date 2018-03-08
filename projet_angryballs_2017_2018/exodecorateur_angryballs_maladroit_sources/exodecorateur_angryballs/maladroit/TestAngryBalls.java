package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;
import exodecorateur_angryballs.maladroit.modele.Billeable;
import exodecorateur_angryballs.maladroit.modele.Frottement;
import exodecorateur_angryballs.maladroit.modele.Newton;
import exodecorateur_angryballs.maladroit.modele.PasseMuraille;
import exodecorateur_angryballs.maladroit.modele.Pesanteur;
import exodecorateur_angryballs.maladroit.modele.Arret;
import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.Rebond;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * différent
 * 
 */
public class TestAngryBalls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// création de la liste (pour l'instant vide) des billes
		
		Vector<Billeable> billes = new Vector<Billeable>();
		double xMax, yMax;
		double vMax = 0.1;
	
		// création de la vue responsable du dessin des billes

		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls","Animation de billes ayant des comportements différents. Version finale du projet.",billes);

		// on rend visible la vue	
		cadre.montrer(); 
		xMax = cadre.largeurBillard(); // abscisse maximale
		yMax = cadre.hauteurBillard(); // ordonnée maximale

		//rayon des billes : ici toutes les billes ont le même rayon, mais ce n'est pas obligatoire
		double rayon = 0.05 * Math.min(xMax, yMax); 
		
		// les positions des centres des billes et les vecteurs vitesse au démarrage. Elles vont être choisies aléatoirement
		Vecteur p0, p1, p2, p3, p4, v0, v1, v2, v3, v4; 
		
		// création des vecteurs position des billes

		p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

		// création des vecteurs vitesse des billes

		v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

		
		//création des billes avec le DP decorator
		
		billes.add(new Rebond(new Bille(p0, rayon, v0, Color.red)));
		billes.add(new Pesanteur(new Frottement(new Rebond(new Bille(p1, rayon, v1, Color.yellow))),new Vecteur(0, 0.001)));
		billes.add(new Newton(new Frottement(new Rebond(new Bille(p2, rayon, v2, Color.green)))));
		billes.add(new PasseMuraille(new Bille(p3, rayon, v3, Color.cyan)));
		billes.add(new Newton(new Arret(new Bille(p4, rayon, v4, Color.black))));	
	}
}