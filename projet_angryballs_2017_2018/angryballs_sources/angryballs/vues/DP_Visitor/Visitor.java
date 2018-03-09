package angryballs.vues.DP_Visitor;

import angryballs.vues.Billard;

/*
 * Interface du DP Visitor
 * Contient une seule fonction qui va interargir avec le billard
 */
public interface Visitor {
	void visite(Billard billard);
}
