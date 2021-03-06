package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;
import mesmaths.mecanique.MecaniquePoint;

public class Frottement extends Decorator{

	public Frottement(Billeable bille) {
		super(bille);
	}

	public void gestionAcceleration(Vector<Billeable> billes) {
		super.gestionAcceleration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); 

		// contribution de l'acc�l�ration due au frottement dans l'air
	}
}