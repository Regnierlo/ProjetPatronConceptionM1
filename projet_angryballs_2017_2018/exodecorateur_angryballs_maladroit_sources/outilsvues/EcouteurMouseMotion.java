package outilsvues;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.Billeable;
import mesmaths.geometrie.base.Vecteur;

public class EcouteurMouseMotion implements MouseMotionListener {
	
	private Vector<Billeable> billes;
	public EcouteurMouseMotion(Vector<Billeable> billes) {
		super();
		this.billes=billes;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<billes.size();i++) {
			if(billes.elementAt(i).getState()!=null) {
				billes.elementAt(i).setPosition(new Vecteur(e.getX(),e.getY()));
			}
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
}