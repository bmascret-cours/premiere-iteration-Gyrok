package model;

public class Roi extends AbstractPiece{

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		
		if (this.OoB(xFinal, yFinal)){
			return false;
		}
		else {
			int deltaX = xFinal - this.x;
			int deltaY = yFinal - this.y;
			
			// comme la reine mais condition supplémentaire: limite de distance à 1
			if ((deltaX > 1) || (deltaY > 1)) {
				return false;
			}
			
			// On commence par les déplacements en droite
			else if((xFinal == this.x) && (yFinal != this.y)) {
				return true;
			}
			else if ((yFinal == this.y) && (xFinal != this.x)) {
				return true;
			}
			
			// déplacements en diagonale
			else if (deltaX == deltaY){
				return true;
			}
			else {
				return false;
			}
		}
	}
}
