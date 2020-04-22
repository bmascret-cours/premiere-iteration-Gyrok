package model;

public class Reine extends AbstractPiece{

	

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.nom = "Reine";
	}
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		
		if (this.OoB(xFinal, yFinal)){
			return false;
		}
		else {
			int deltaX = xFinal - this.x;
			int deltaY = yFinal - this.y;
			// On commence par les déplacements en droite
			if((xFinal == this.x) && (yFinal != this.y)) {
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
