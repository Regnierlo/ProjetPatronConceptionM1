package exodecorateur_angryballs.maladroit.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface Billeable extends CollisionContourable, GestionAccelerationable {
	public int getClef();
	public double masse();
	public boolean gestionCollisionBilleBille(Vector<Billeable> billes);
	public void d�placer(double deltaT);
	public void dessine(Graphics g);
}