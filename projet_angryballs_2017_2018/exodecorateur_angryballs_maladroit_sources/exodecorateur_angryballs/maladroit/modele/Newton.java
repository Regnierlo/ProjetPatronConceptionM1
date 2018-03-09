package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class Newton extends Decorator{

	public Newton(Billeable bille) {
		super(bille);
	}

	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.Decorator#gestionAcceleration(java.util.Vector)
	 */
	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes)); 

		// contribution de l'acceleration due à l'attraction des autres billes
	}
}