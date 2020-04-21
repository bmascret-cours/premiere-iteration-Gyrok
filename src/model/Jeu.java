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
		// itérer sur les pieces pour call les toString
	}
	public boolean isPieceHere(int x,int y) {
		// boucle sur les 2 listes de pièces (?)
		return true; // true si une pièce se trouve aux coordonnées indiquées
	}
	
	public boolean isMoveOk(int xInit, int yInit,int xFinal,int yFinal) {
		return true; // true si déplacement possible
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {
		// appelle is moveOk puis collision
		return true; // true si déplacement effectué
	}
}
