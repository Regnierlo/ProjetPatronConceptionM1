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
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * diffï¿½rent
 * 
 * Idï¿½al pour mettre en place le DP decorator
 */
public class TestAngryBalls {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ------------------- crï¿½ation de la liste (pour l'instant vide) des billes
		// -----------------------

		Vector<Billeable> billes = new Vector<Billeable>();

		// ---------------- crï¿½ation de la vue responsable du dessin des billes
		// -------------------------

		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls","Animation de billes ayant des comportements diffï¿½rents. Situation idï¿½ale pour mettre en place le DP Decorator",billes);

		cadre.montrer(); // on rend visible la vue

		// ------------- remplissage de la liste avec 4 billes
		// -------------------------------

		double xMax, yMax;
		double vMax = 0.1;
		xMax = cadre.largeurBillard(); // abscisse maximal
		yMax = cadre.hauteurBillard(); // ordonnï¿½e maximale

		double rayon = 0.05 * Math.min(xMax, yMax); 
		//rayon des billes : ici toutes les billes ont le mï¿½me rayon, mais ce n'est pas obligatoire

		Vecteur p0, p1, p2, p3, p4, p5, v0, v1, v2, v3, v4, v5; 
		// les positions des centres des billes et les vecteurs vitesse au dï¿½marrage. Elles vont ï¿½tre choisies alï¿½atoirement

		// ------------------- crï¿½ation des vecteurs position des billes
		// ---------------------------------

		p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

		// ------------------- crï¿½ation des vecteurs vitesse des billes
		// ---------------------------------

		v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v5 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

		// --------------- ici commence la partie ï¿½ changer
		// ---------------------------------

		billes.add(new Rebond(new Bille(p0, rayon, v0, Color.red)));
		billes.add(new Pesanteur(new Frottement(new Rebond(new Bille(p1, rayon, v1, Color.yellow))),new Vecteur(0, 0.001)));
		billes.add(new Newton(new Frottement(new Rebond(new Bille(p2, rayon, v2, Color.green)))));
		billes.add(new PasseMuraille(new Bille(p3, rayon, v3, Color.cyan)));
		//billes.add(new Newton(new Arret(new Bille(p4, rayon, v4, Color.black))));
		billes.add(new Pilotee(new Rebond(new Pesanteur(new Bille(p5, rayon, v5, Color.pink),new Vecteur(0, 0.001)))));


		// ---------------------- ici finit la partie ï¿½ changer
		// -------------------------------------------------------------

		System.out.println("billes = " + billes);

		// -------------------- crï¿½ation de l'objet responsable de l'animation (c'est un
		// thread sï¿½parï¿½) -----------------------

		AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

		// ----------------------- mise en place des ï¿½couteurs de boutons qui permettent
		// de contrï¿½ler (un peu...) l'application -----------------

		EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
		EcouteurBoutonArreter écouteurBoutonArréter = new EcouteurBoutonArreter(animationBilles);

		// ------------------------- activation des ï¿½couteurs des boutons et ï¿½a tourne
		// tout seul ------------------------------

		cadre.lancerBilles.addActionListener(écouteurBoutonLancer); // maladroit : ï¿½ changer
		cadre.arrêterBilles.addActionListener(écouteurBoutonArréter); // maladroit : ï¿½ changer
	}
}