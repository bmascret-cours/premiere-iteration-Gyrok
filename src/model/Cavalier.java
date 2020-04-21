package model;

public class Cavalier extends AbstractPiece {

	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal,int yFinal) {
		
		// vérification que on est toujours dans la grille
		
		if (this.OoB(xFinal, yFinal)) {
			return false;
		}
		else {
		int deltaX = xFinal - this.x;
		int deltaY = yFinal - this.y;
		
		if ((deltaX == 1) && (deltaY == 2)) {
			return true;
		}
		
		else if ((deltaX == -1) && (deltaY == 2)) {
			return true;
		}
		
		else if ((deltaX == 1) && (deltaY == -2)) {
			return true;
		}
		
		else if ((deltaX == -1) && (deltaY == -2)) {
			return true;
		}
		
		else if ((deltaX == 2) && (deltaY == 1)) {
			return true;
		}
		
		else if ((deltaX == 2) && (deltaY == -1)) {
			return true;
		}
		
		else if ((deltaX == -2) && (deltaY == 1)) {
			return true;
		}
		
		else if ((deltaX == -2) && (deltaY == -1)) {
			return true;
		}
		
		else {
			return false;
		}
		}
	}
}
