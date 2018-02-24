package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{
	Vecteur pesanteur;

	public Frottement(Billable bille, Vecteur pesanteur) {
		super(bille);
		this.pesanteur = pesanteur;
		// TODO Auto-generated constructor stub
	}
	public void gestionAccélération(Vector<Billable> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
		this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution
																											// de
																											// l'accélération
																											// due au
																											// frottement
																											// dans
																											// l'air
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
				abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
}
