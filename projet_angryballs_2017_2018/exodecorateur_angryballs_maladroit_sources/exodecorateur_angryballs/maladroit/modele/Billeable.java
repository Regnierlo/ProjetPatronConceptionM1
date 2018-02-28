package exodecorateur_angryballs.maladroit.modele;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public interface Billeable extends CollisionContourable, GestionAccelerationable {
	public int getClef();
	public double masse();
	public boolean gestionCollisionBilleBille(Vector<Billeable> billes);
	public void déplacer(double deltaT);
	public void dessine(Graphics g);
	public void clic();
	public void deClic();
	public void setPosition(Vecteur pos);
	public BilleState getState();
	public void setVitesse(Vecteur vit);
	public void setAcceleration(Vecteur accel);
}