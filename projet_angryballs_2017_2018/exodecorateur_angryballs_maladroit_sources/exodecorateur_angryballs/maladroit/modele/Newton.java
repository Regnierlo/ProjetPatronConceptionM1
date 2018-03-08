package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class Newton extends Decorator{

	public Newton(Billeable bille) {
		super(bille);
	}

	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes)); 
		// contribution de l'acc�l�ration due � l'attraction des autres billes
	}
}