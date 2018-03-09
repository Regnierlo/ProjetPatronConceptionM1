package exodecorateur_angryballs.maladroit.modele;

import java.awt.*;
import java.util.Vector;
import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Cas general d'une bille de billard
 */
public class Bille implements Billeable{
	// ----------------- classe Bille-------------------------------------

	public Vecteur position; // centre de la bille
	public double rayon; // rayon > 0
	public Vecteur vitesse;
	public Vecteur acceleration;
	public int clef; // identifiant unique de cette bille
	private Color couleur;
	private static int prochaineClef = 0;

	public static double ro = 1; // masse volumique

	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acceleration
	 * @param couleur
	 */
	protected Bille(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur) {
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acceleration = acceleration;
		this.couleur = couleur;
		this.clef = Bille.prochaineClef++;
	}

	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public Bille(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}

	/**
	 * @return the position
	 */
	public Vecteur getPosition() {
		return this.position;
	}
	/**
	 * 
	 * @param pos nouvelle position
	 */
	public void setPosition(Vecteur pos) {
		this.position=pos;
	}

	/**
	 * @return the rayon
	 */
	public double getRayon() {
		return this.rayon;
	}

	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse() {
		return this.vitesse;
	}

	/**
	 * @return the acceleration
	 */
	public Vecteur getAcceleration() {
		return this.acceleration;
	}

	/**
	 * @return the clef
	 */
	public int getClef() {
		return this.clef;
	}

	public double masse() {
		return ro * Geop.volumeSphère(rayon);
	}

	/**
	 * mise a jour de position et vitesse a t+deltaT a partir de position et vitesse
	 * a l'instant t
	 * modifie le vecteur position et le vecteur vitesse
	 * laisse le vecteur acceleration intact
	 * La bille subit par defaut un mouvement uniformement accelere
	 */
	public void deplacer(double deltaT) {
		Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAcceleration(),
				deltaT);
	}

	/**
	 * calcul (c-a-d mise a jour) eventuel du vecteur acceleration. billes est la
	 * liste de toutes les billes en mouvement Cette methode peut avoir besoin de
	 * "billes" si this subit l'attraction gravitationnelle des autres billes La
	 * nature du calcul du vecteur acceleration de la bille est definie dans les
	 * classes derivees A ce niveau le vecteur acceleration est mis a zero (c'est a
	 * dire pas d'acceleration)
	 */
	public void gestionAcceleration(Vector<Billeable> billes) {
		this.getAcceleration().set(Vecteur.VECTEURNUL);
	}

	/**
	 * gestion de l'eventuelle collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par defaut est le choc parfaitement elastique (c-a-d rebond
	 * sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs
	 *         vitesses des 2 billes impliquees dans le choc sont modifiees si
	 *         renvoie false, il n'y a pas de collision et les billes sont laissees
	 *         intactes
	 */
	public boolean gestionCollisionBilleBille(Vector<Billeable> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

	/**
	 * gestion de l'eventuelle collision de la bille (this) avec le contour
	 * rectangulaire de l'ecran defini par (abscisseCoinHautGauche,
	 * ordonneeCoinHautGauche, largeur, hauteur)
	 * 
	 * detecte si il y a collision et le cas echeant met a jour position et vitesse
	 * 
	 * La nature du comportement de la bille en reponse a cette collision est
	 * definie dans les classes derivees
	 */
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,double hauteur) {}

	public void dessine(Graphics g) {
		int width, height;
		int xMin, yMin;

		xMin = (int) Math.round(position.x - rayon);
		yMin = (int) Math.round(position.y - rayon);

		width = height = 2 * (int) Math.round(rayon);

		g.setColor(couleur);
		g.fillOval(xMin, yMin, width, height);
		g.setColor(Color.CYAN);
		g.drawOval(xMin, yMin, width, height);
	}

	public String toString() {
		return "centre = " + position + " rayon = " + rayon + " vitesse = " + vitesse + " acceleration = "
				+ acceleration + " couleur = " + couleur + "clef = " + clef;
	}

	@Override
	public void clic() {
		// TODO Auto-generated method stub
	}
	@Override
	public void deClic() {
		// TODO Auto-generated method stub
	}

	@Override
	public BilleState getState() {
		return null;
		
	}

	@Override
	public void setVitesse(Vecteur vit) {
		// TODO Auto-generated method stub
		vitesse=vit;
	}

	@Override
	public void setAcceleration(Vecteur accel) {
		// TODO Auto-generated method stub
		acceleration=accel;
	}

	// ----------------- classe Bille -------------------------------------
}