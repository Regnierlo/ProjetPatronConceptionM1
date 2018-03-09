package angryballs.modele.DP_State;

import angryballs.modele.Billeable;
import mesmaths.geometrie.base.Vecteur;

public interface BilleState {
	public void mouvement(Vecteur pos,Billeable bille);
}
