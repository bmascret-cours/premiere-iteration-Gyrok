package model;

public class Tour extends AbstractPiece{
	public int x, y;
	public Couleur couleur;
	public String name = "Tour";
	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}


	
	public boolean isMoveOk(int x, int y) {
		// pas bouger si pas de déplacement ou déplacement sur les 2 axes en même temps
		if (((x != y) & (x == 0)) ^ ((x != y) & (y == 0))) { // and xor and
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
