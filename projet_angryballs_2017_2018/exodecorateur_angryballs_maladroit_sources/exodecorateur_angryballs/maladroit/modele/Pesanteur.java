package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
import mesmaths.geometrie.base.Vecteur;

public class Pesanteur extends Decorator {

	Vecteur pesanteur;
	
	public Pesanteur(Billeable bille, Vecteur pesanteur) {
		super(bille);
		this.pesanteur = pesanteur;
	}

	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#gestionAcceleration(java.util.Vector)
	 */
	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise a zero du vecteur acceleration
		this.getAcceleration().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}
}