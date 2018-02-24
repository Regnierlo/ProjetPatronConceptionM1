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
	public void gestionAcc�l�ration(Vector<Billable> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
		this.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution
																											// de
																											// l'acc�l�ration
																											// due au
																											// frottement
																											// dans
																											// l'air
	}
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur,
			double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(),
				abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
}
