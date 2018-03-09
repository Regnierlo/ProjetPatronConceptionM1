package angryballs.vues.DP_Visitor;

import angryballs.vues.Billard;

public class PassiveVisitor implements Visitor{
	
	/*
	 * Classe implementant le DP Visitor et donnant lieu a une animation basique via le paint
	 * Elle appelle la methode repaint
	 */
	@Override
	public void visite(Billard billard) {
		billard.repaint();
	}
}
