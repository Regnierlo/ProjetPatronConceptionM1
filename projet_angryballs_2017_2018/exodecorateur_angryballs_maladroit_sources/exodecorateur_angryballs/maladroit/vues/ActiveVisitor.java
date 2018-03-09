package exodecorateur_angryballs.maladroit.vues;

public class ActiveVisitor implements Visitor{

	@Override
	public void visite(Billard billard) {
		billard.redessine();
		
	}
}
