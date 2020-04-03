package model;

public interface Pieces {
	boolean capture(); // True if piece taken, changes x & y to -1
	int getX(); // returns index of column where piece is currently placed
	int getY(); // returns index of row where piece is currently placed
	Couleur getCouleur(); // returns color of piece
	boolean isMoveOk(int xFinal, int yFinal); // True if move okay by piece standards
	boolean move(int xFinal, int yFinal); // True if piece moved
}
