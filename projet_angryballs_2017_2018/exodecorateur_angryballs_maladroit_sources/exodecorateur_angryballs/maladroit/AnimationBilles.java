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
 * responsable de l'animation des billes, c'est-a-dire responsable du mouvement de la
 * liste des billes. Met perpetuellement a jour les billes. gere le delai entre
 * 2 mises a jour (deltaT) et previent la vue responsable du dessin des billes
 * qu'il faut mettre a jour la scene
 */
public class AnimationBilles implements Runnable, Observer {

	Vector<Billeable> billes; // la liste de toutes les billes en mouvement
	VueBillard vueBillard; // la vue responsable du dessin des billes
	private Thread thread; // pour lancer et arreter les billes
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

	/**
	 * Fonction principale permettant de lancer l'animation
	 */
	@Override
	public void run() {
		try {
			double deltaT; // delai entre 2 mises a jour de la liste des billes
			Billeable billeCourante;
			double minRayons = AnimationBilles.minRayons(billes); // necessaire au calcul de deltaT
			double minRayons2 = minRayons * minRayons; // necessaire au calcul de deltaT

			while (!Thread.interrupted()) // gestion du mouvement
			{
				deltaT = 10;
				int i;
				
				for (i = 0; i < billes.size(); ++i) // mise a jour de la liste des billes
				{
					billeCourante = billes.get(i);
					billeCourante.deplacer(deltaT); // mise a jour position et vitesse de cette bille
					billeCourante.gestionAcceleration(billes); // calcul de l'acceleration subie par cette bille
					billeCourante.gestionCollisionBilleBille(billes);
					billeCourante.collisionContour(0, 0, vueBillard.largeurBillard(), vueBillard.hauteurBillard()); 
				}
				
				//DP visitor lancant l'animation de maniere fluide
				vueBillard.accepte(new ActiveVisitor());
				
				//DP visitor lancant l'animation via la methode paint
				//vueBillard.accepte(new PassiveVisitor());
				Thread.sleep((int) deltaT); // deltaT peut etre considere comme le delai entre 2 flashes d'un stroboscope qui eclairerait la scene
			}
		}
		catch (InterruptedException e){}
	}

	/**
	 * calcule le maximum de de la norme carree (pour faire moins de calcul) des
	 * vecteurs vitesse de la liste de billes
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

	/**
	 * Permet de lancer l'animation via la creation d'un thread
	 */
	public void lancerAnimation() {
		if (this.thread == null) {			
			this.thread = new Thread(this);
			thread.start();
		}
	}

	/**
	 * Permet d'arreter l'animation via l'interruption de ce thread
	 */
	public void arreterAnimation() {
		if (thread != null) {
			this.thread.interrupt();
			this.thread = null;
		}
	}

	/***
	 * Mise a jour des donnees via les observateurs en recuperant l'etat de CadreState.
	 * On lance ainsi l'animation si le bouton Lancer est clique sinon on l'arrete.
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