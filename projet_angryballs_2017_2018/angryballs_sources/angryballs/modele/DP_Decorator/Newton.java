package angryballs.modele.DP_Decorator;

import java.util.Vector;

import angryballs.modele.Billeable;
import angryballs.modele.OutilsBille;

public class Newton extends Decorator{

	public Newton(Billeable bille) {
		super(bille);
	}

	@Override
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes)); 

		// contribution de l'acceleration due à l'attraction des autres billes
	}
}