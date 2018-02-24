package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{

	public Frottement(Billeable bille) {
		super(bille);
	}
	
	public void gestionAccélération(Vector<Billeable> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution
																											// de
																											// l'accélération
																											// due au
																											// frottement
																											// dans
																											// l'air
	}
}
