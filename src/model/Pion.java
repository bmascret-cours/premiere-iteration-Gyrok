package model;

class Pion extends AbstractPiece{

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		
		if ((xFinal == this.x + 1) && (yFinal == this.y)){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return true;
	}
}



          
