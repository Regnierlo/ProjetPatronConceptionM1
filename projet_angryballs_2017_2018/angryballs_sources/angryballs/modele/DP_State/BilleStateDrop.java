package angryballs.modele.DP_State;

import angryballs.modele.Billeable;
import mesmaths.geometrie.base.Vecteur;

public class BilleStateDrop implements BilleState {

	/*
	 * (non-Javadoc)
	 * @see exodecorateur_angryballs.maladroit.modele.BilleState#mouvement(mesmaths.geometrie.base.Vecteur, exodecorateur_angryballs.maladroit.modele.Billeable)
	 * affecte a la bille ça position actuelle
	 */
	public void mouvement(Vecteur pos, Billeable bille) {
		bille.setPosition(bille.getPosition());
	}

}
