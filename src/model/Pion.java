package model;

public class Pion extends AbstractPiece{

	

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.nom = "Pion";
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		if (this.OoB(xFinal, yFinal)){
			return false;
		}
		else {
			if ((xFinal == this.x)&&(yFinal == this.y + 1)) {
				return true;
			}
			
			// pour le saut possible au départ => implique que y = hauteur plateau
			else if ((xFinal == this.x) && (yFinal == 3)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		if (this.OoB(xFinal, yFinal)){
			return false;
		}
		else {
			return true;
		}
	}
}



          
