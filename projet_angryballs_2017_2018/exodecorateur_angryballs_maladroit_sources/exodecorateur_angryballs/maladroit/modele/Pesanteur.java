package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class Pesanteur extends Decorator {

	Vecteur pesanteur;
	
	public Pesanteur(Billeable bille, Vecteur pesanteur) {
		super(bille);
		this.pesanteur = pesanteur;
	}

	@Override
	public void gestionAccélération(Vector<Billeable> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}
}
