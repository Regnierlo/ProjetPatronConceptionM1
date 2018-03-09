package angryballs.modele.DP_Decorator;

import java.util.Vector;

import angryballs.modele.Billeable;
import mesmaths.geometrie.base.Vecteur;

public class Pesanteur extends Decorator {

	Vecteur pesanteur;
	
	public Pesanteur(Billeable bille, Vecteur pesanteur) {
		super(bille);
		this.pesanteur = pesanteur;
	}

	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise a zero du vecteur acceleration
		this.getAcceleration().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}
}