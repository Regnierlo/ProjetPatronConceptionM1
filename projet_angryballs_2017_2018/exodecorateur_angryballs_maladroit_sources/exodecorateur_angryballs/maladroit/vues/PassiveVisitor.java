package exodecorateur_angryballs.maladroit.vues;

public class PassiveVisitor implements Visitor{
	
	@Override
	public void visite(Billard billard) {
		billard.repaint();
	}
}
