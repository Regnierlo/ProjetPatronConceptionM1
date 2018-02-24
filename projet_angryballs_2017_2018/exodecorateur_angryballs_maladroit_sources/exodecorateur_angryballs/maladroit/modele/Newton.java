package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class Newton extends Decorator{

	public Newton(Billeable bille) {
		super(bille);
	}

	@Override
	public void gestionAccélération(Vector<Billeable> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes)); // contribution de
																							// l'accélération due à
																							// l'attraction des autres
																							// billes
	}
}
