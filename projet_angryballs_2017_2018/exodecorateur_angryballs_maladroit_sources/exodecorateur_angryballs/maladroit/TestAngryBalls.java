package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;
import exodecorateur_angryballs.maladroit.modele.Billeable;
import exodecorateur_angryballs.maladroit.modele.Frottement;
import exodecorateur_angryballs.maladroit.modele.Newton;
import exodecorateur_angryballs.maladroit.modele.PasseMuraille;
import exodecorateur_angryballs.maladroit.modele.Pesanteur;
import exodecorateur_angryballs.maladroit.modele.Pilotee;
import exodecorateur_angryballs.maladroit.modele.Arret;
import exodecorateur_angryballs.maladroit.modele.Bille;
import exodecorateur_angryballs.maladroit.modele.Rebond;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement different
 */
public class TestAngryBalls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// creation de la liste (pour l'instant vide) des billes
		
		Vector<Billeable> billes = new Vector<Billeable>();
		double xMax = 0, yMax=0;
		double vMax = 0.1;
		
		// creation de la vue responsable du dessin des billes

		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls","Animation de billes ayant des comportements differents. Version finale du projet.",billes);

		// on rend visible la vue	
		cadre.montrer(); 
		xMax = cadre.largeurBillard(); // abscisse maximale
		yMax = cadre.hauteurBillard(); // ordonnee maximale

		//rayon des billes 
		double rayon = 0.05 * Math.min(xMax, yMax);
		double rayon2 = 0.08 * Math.min(xMax, yMax);
		double rayon3 = 0.03 * Math.min(xMax, yMax); 
		
		//creationd des differents vecteurs
		Vecteur p0, p1, p2, p3, p4, p5, v0, v1, v2, v3, v4, v5; 
		
		//les positions des centres des billes et les vecteurs vitesse au demarrage. Elles vont etre choisies de maniere aleatoire
		//creation des vecteurs position des billes

		p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

		//creation des vecteurs vitesse des billes

		v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v5 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		
		//creation des billes avec le DP decorator
		
		billes.add(new Rebond(new Bille(p0, rayon, v0, Color.red)));
		billes.add(new Pesanteur(new Frottement(new Rebond(new Bille(p1, rayon2, v1, Color.yellow))),new Vecteur(0, 0.001)));
		billes.add(new Newton(new Frottement(new Rebond(new Bille(p2, rayon, v2, Color.green)))));
		billes.add(new PasseMuraille(new Bille(p3, rayon3, v3, Color.cyan)));
		billes.add(new Newton(new Arret(new Bille(p4, rayon3, v4, Color.black))));	
		billes.add(new Pilotee(new Rebond(new Pesanteur(new Bille(p5, rayon2, v5, Color.pink),new Vecteur(0, 0.001)))));
	}
}