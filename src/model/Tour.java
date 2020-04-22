package model;

public class Tour extends AbstractPiece{
	
	String nom = "Tour";
	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
		
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		
		if (this.OoB(xFinal, yFinal)) {
			
			return false;
		}
		else {
			
			if ((xFinal == this.x) && (yFinal != this.y)) {
				return true;
			}
			else if ((yFinal == this.y) && (xFinal != this.x)) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
}
