package angryballs.vues;

import java.util.Vector;

import angryballs.modele.Billeable;
import angryballs.vues.CadreAngryBalls;

public class TestCadreAngryBallsSeul {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Billeable> billes = new Vector<Billeable>();
		CadreAngryBalls cadre = new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
		cadre.montrer();
	}
}