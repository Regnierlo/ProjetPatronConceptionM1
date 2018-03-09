package exodecorateur_angryballs.maladroit;

import exodecorateur_angryballs.maladroit.vues.Visitor;
import exodecorateur_angryballs.maladroit.vues.VueBillard;

public class VueBillardFactice implements VueBillard {

	@Override
	public double largeurBillard() {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public double hauteurBillard() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public void montrer() {
		// TODO Auto-generated method stub
	}

	@Override
	public void accepte(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}