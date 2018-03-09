package exodecorateur_angryballs.maladroit;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import exodecorateur_angryballs.maladroit.modele.Billeable;
import exodecorateur_angryballs.maladroit.vues.ActiveVisitor;
import exodecorateur_angryballs.maladroit.vues.CadreState;
import exodecorateur_angryballs.maladroit.vues.PassiveVisitor;
import exodecorateur_angryballs.maladroit.vues.VueBillard;

/**
 * responsable de l'animation des billes, c-ï¿½-d responsable du mouvement de la
 * liste des billes. met perpï¿½tuellement ï¿½ jour les billes. gï¿½re le dï¿½lai entre
 * 2 mises ï¿½ jour (deltaT) et prï¿½vient la vue responsable du dessin des billes
 * qu'il faut mettre ï¿½ jour la scï¿½ne
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 */
public class AnimationBilles implements Runnable, Observer {

	Vector<Billeable> billes; // la liste de toutes les billes en mouvement
	VueBillard vueBillard; // la vue responsable du dessin des billes
	private Thread thread; // pour lancer et arrï¿½ter les billes
	private static final double COEFF = 0.5;

	/**
	 * @param billes
	 * @param vueBillard
	 */
	public AnimationBilles(Vector<Billeable> billes, VueBillard vueBillard) {
		this.billes = billes;
		this.vueBillard = vueBillard;
		this.thread = null; // est-ce utile ?
	}

	@Override
	public void run() {
		try {
			double deltaT; // dï¿½lai entre 2 mises ï¿½ jour de la liste des billes
			Billeable billeCourante;
			double minRayons = AnimationBilles.minRayons(billes); // nï¿½cessaire au calcul de deltaT
			double minRayons2 = minRayons * minRayons; // nï¿½cessaire au calcul de deltaT

			while (!Thread.interrupted()) // gestion du mouvement
			{
				// deltaT = COEFF*minRayons2/(1+maxVitessesCarrï¿½es(billes)); // mise ï¿½ jour
				// deltaT. L'addition + 1 est une astuce pour ï¿½viter les divisions par zï¿½ro
				// System.err.println("deltaT = " + deltaT);
				deltaT = 10;
				int i;
				
				for (i = 0; i < billes.size(); ++i) // mise ï¿½ jour de la liste des billes
				{
					billeCourante = billes.get(i);
					billeCourante.deplacer(deltaT); // mise ï¿½ jour position et vitesse de cette bille
					billeCourante.gestionAcceleration(billes); // calcul de l'accï¿½lï¿½ration subie par cette bille
					billeCourante.gestionCollisionBilleBille(billes);
					billeCourante.collisionContour(0, 0, vueBillard.largeurBillard(), vueBillard.hauteurBillard()); 
				}
				vueBillard.accepte(new ActiveVisitor());
				Thread.sleep((int) deltaT); // deltaT peut etre considï¿½rï¿½ comme le delai entre 2 flashes d'un stroboscope qui eclairerait la scene
			}
		}
		catch (InterruptedException e){}
	}

	/**
	 * calcule le maximum de de la norme carrï¿½e (pour faire moins de calcul) des
	 * vecteurs vitesse de la liste de billes
	 * 
	 */
	static double maxVitessesCarrées(Vector<Billeable> billes) {
		double vitesse2Max = 0;
		int i;
		double vitesse2Courante;

		for (i = 0; i < billes.size(); ++i)
		{	
			if ((vitesse2Courante = billes.get(i).getVitesse().normeCarrée()) > vitesse2Max)
			{
				vitesse2Max = vitesse2Courante;
			}			
		}
		return vitesse2Max;
	}

	/**
	 * calcule le minimum des rayons de a liste des billes
	 * 
	 */
	static double minRayons(Vector<Billeable> billes) {
		double rayonMin, rayonCourant;
		rayonMin = Double.MAX_VALUE;

		int i;
		for (i = 0; i < billes.size(); ++i)
		{
			if ((rayonCourant = billes.get(i).getRayon()) < rayonMin)
			{
				rayonMin = rayonCourant;
			}
		}
		return rayonMin;
	}

	public void lancerAnimation() {
		if (this.thread == null) {
			
			this.thread = new Thread(this);
			thread.start();
		}
	}

	public void arreterAnimation() {
		if (thread != null) {
			this.thread.interrupt();
			this.thread = null;
		}
	}

	/***
	 * Mise ï¿½ jour des donnï¿½es via les observateurs en rï¿½cupï¿½rant l'ï¿½tat de CadreState.
	 * On lance ainsi l'animation si le bouton Lancer est cliquï¿½ sinon on l'arrï¿½te.
	 */
	@Override
	public void update(Observable o, Object obj) {
		if(o instanceof CadreState)
		{
			CadreState c = (CadreState) o;
			if(c.getCadreState() == true)
			{
				lancerAnimation();
			}
			else
			{
				arreterAnimation();
			}
		}
	}
}