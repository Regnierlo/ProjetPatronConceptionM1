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
	public void gestionAcc�l�ration(Vector<Billeable> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}
}
