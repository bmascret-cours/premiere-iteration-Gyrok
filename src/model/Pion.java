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
			if (this.couleur == Couleur.BLANC) {
				if ((xFinal == this.x) && (yFinal == this.y - 1)) {
	
					return true;
				}
				
				// pour le saut possible au départ => implique que y = hauteur plateau
				else if ((xFinal == this.x) && (yFinal == 4)) {
					return true;
				}
				else {
					return this.isMoveDiagOk(xFinal, yFinal);
				}
			}
			else if (this.couleur == Couleur.NOIR) {
				if ((xFinal == this.x) && (yFinal == this.y + 1)) {
					
					return true;
				}
				
				// pour le saut possible au départ => implique que y = hauteur plateau
				else if ((xFinal == this.x) && (yFinal == 3)) {
					return true;
				}
				else {
					return this.isMoveDiagOk(xFinal, yFinal);
				}
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
			if (this.couleur == Couleur.BLANC) {
				if ((xFinal == this.x + 1) && (yFinal == this.y - 1)) {
	
					return true;
				}
				else if ((xFinal == this.x - 1) && (yFinal == this.y - 1)) {
					
					return true;
				}
			}
			else if (this.couleur == Couleur.NOIR) {
				if ((xFinal == this.x + 1) && (yFinal == this.y + 1)) {
	
					return true;
				}
				else if ((xFinal == this.x - 1) && (yFinal == this.y + 1)) {
					
					return true;
				}
			}
			else {
				return false;
			}
				
				
		}
		return false;
	}
}


          
