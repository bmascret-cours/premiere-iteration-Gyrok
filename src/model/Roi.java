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
			
			// comme la reine mais condition suppl�mentaire: limite de distance � 1
			if ((deltaX > 1) || (deltaY > 1)) {
				return false;
			}
			
			// On commence par les d�placements en droite
			else if((xFinal == this.x) && (yFinal != this.y)) {
				return true;
			}
			else if ((yFinal == this.y) && (xFinal != this.x)) {
				return true;
			}
			
			// d�placements en diagonale
			else if (deltaX == deltaY){
				return true;
			}
			else {
				return false;
			}
		}
	}
}
