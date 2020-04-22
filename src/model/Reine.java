package model;

public class Reine extends AbstractPiece{

	
	String nom ="Reine";
	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		
		if (this.OoB(xFinal, yFinal)){
			return false;
		}
		else {
			int deltaX = xFinal - this.x;
			int deltaY = yFinal - this.y;
			// On commence par les d�placements en droite
			if((xFinal == this.x) && (yFinal != this.y)) {
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
