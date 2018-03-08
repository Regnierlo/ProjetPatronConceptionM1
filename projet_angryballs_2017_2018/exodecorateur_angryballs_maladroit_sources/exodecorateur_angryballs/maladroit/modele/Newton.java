package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class Newton extends Decorator{

	public Newton(Billeable bille) {
		super(bille);
	}

	@Override
<<<<<<< HEAD
	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise à zéro du vecteur accélération
		this.getAcceleration().ajoute(OutilsBille.gestionAccélérationNewton(this, billes)); 
=======
	public void gestionAccélération(Vector<Billeable> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes)); 
>>>>>>> DP_Decorator
		// contribution de l'accélération due à l'attraction des autres billes
	}
}