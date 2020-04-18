package model;

public class Reine extends AbstractPiece{

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}
	public boolean isMoveOk(int xFinal, int yFinal) {
		// faudra faire attention à pas sortir du terrain
		if((((xFinal != yFinal) & (xFinal == 0)) ^ ((xFinal != yFinal) & (yFinal == 0)))
				^(xFinal - this.x == yFinal - this.y)) {
			return true;
		}
		else {
			return false;
		}
	}
}
