package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	List<Pieces> pieces;
	public Jeu(Couleur couleur) {
		Couleur pieceCouleur = couleur;
		this.pieces = ChessPiecesFactory.newPieces(pieceCouleur);
	}

	// Test main
	public static void main(String[] args) {
		Jeu testConstruction = new Jeu(Couleur.NOIR);
		testConstruction.toString();
	}
	
	public void toString(List<Pieces> pieces) {
		// it�rer sur les pieces pour call les toString
	}
	public boolean isPieceHere(int x,int y) {
		// boucle sur les 2 listes de pi�ces (?)
		return true; // true si une pi�ce se trouve aux coordonn�es indiqu�es
	}
	
	public boolean isMoveOk(int xInit, int yInit,int xFinal,int yFinal) {
		return true; // true si d�placement possible
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {
		// appelle is moveOk puis collision
		return true; // true si d�placement effectu�
	}
}
