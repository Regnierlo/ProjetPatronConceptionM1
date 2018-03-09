package angryballs;

import java.io.IOException;
import java.util.Vector;
import angryballs.modele.Billeable;
import angryballs.AnimationBilles;
import angryballs.VueBillardFactice;
import angryballs.vues.VueBillard;

public class TestAnimationBilles {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Vector<Billeable> billes = new Vector<Billeable>();

		double vmax2 = AnimationBilles.maxVitessesCarrées(billes);
		double rayonmin2 = AnimationBilles.minRayons(billes);

		System.out.println("vmax2 = " + vmax2 + "rayonMin2 = " + rayonmin2);
		//int c = System.in.read();

		VueBillard vueBillardFactice = new VueBillardFactice();

		AnimationBilles animation = new AnimationBilles(billes, vueBillardFactice);
		animation.lancerAnimation();
	}
}