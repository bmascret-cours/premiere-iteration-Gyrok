package model;

public class Fou extends AbstractPiece{


	public Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		this.nom = "Fou";
	}
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		int deltaX = xFinal - this.x;
		int deltaY = yFinal - this.y;
		if (this.OoB(xFinal, yFinal)) {
			return false;
		}
		else if(deltaX == deltaY) {
			return true;
		}
		else {
			return false;
		}
	}
}
