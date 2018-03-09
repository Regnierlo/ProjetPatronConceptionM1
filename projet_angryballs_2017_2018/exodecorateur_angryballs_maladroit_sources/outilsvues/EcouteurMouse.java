package outilsvues;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import exodecorateur_angryballs.maladroit.modele.Billeable;

public class EcouteurMouse implements MouseListener {

	private Vector<Billeable> billes;
	public EcouteurMouse(Vector<Billeable> billes) {
		this.billes=billes;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<billes.size();i++) {
			if(e.getPoint().getX()>billes.elementAt(i).getPosition().x - billes.elementAt(i).getRayon()&&
					e.getPoint().getX()<billes.elementAt(i).getPosition().x + billes.elementAt(i).getRayon() &&
					e.getPoint().getX()>billes.elementAt(i).getPosition().y - billes.elementAt(i).getRayon()&&
					e.getPoint().getY()<billes.elementAt(i).getPosition().y+billes.elementAt(i).getRayon()){
				billes.elementAt(i).clic();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<billes.size();i++) {
			if(e.getPoint().getX()>billes.elementAt(i).getPosition().x - billes.elementAt(i).getRayon() && 
					e.getPoint().getX()<billes.elementAt(i).getPosition().x+billes.elementAt(i).getRayon() &&
					e.getPoint().getX()>billes.elementAt(i).getPosition().y - billes.elementAt(i).getRayon() && 
					e.getPoint().getY()<billes.elementAt(i).getPosition().y+billes.elementAt(i).getRayon()){
				billes.elementAt(i).deClic();
			}
		}
	}

}
