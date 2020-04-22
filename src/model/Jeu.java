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
		List<Pieces> listPieces = ChessPiecesFactory.newPieces(Couleur.NOIR);
		testConstruction.toString(listPieces);
	}
	
	public void toString(List<Pieces> pieces) {
		
		// it�rer sur les pieces pour call les toString
		for (Pieces piece : this.pieces) {
		   String testString = piece.toString(); 
		   System.out.println(testString);
		}
	}
	
	private Pieces findPiece(int x, int y) {
		Pieces pieceTrouvee = null;
		for (Pieces piece : this.pieces) {
			
			/* On compare une seule fois vu que de toute fa�on si chevauchement
			*	c'est que cette m�thode a d�j� mal fait son travail
			*/
			if ((piece.getX() == x) && (piece.getY() == y)){
				pieceTrouvee = piece;
			}
		}
		return pieceTrouvee;
	}
	
	
	public boolean isPieceHere(int x,int y) {
		for (Pieces piece : this.pieces) {
			if ((piece.getX() == x) && (piece.getY() == y)){
				return true; // true si une pi�ce se trouve aux coordonn�es indiqu�es
			}
		}
		return false;
	}

	
	public boolean isMoveOk(int xInit, int yInit,int xFinal,int yFinal) {
		return true; // true si d�placement possible
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {
		// appelle is moveOk puis collision
		// on commence par chercher quelle pi�ce est � l'endroit init
		// puis si le mvt est ok pour elle, ensuite on v�rifie si il y a une pi�ce � l'endroit
		//o� on arrive
		//ensuite pour tour/reine/fou si il y a une pi�ce entre init et arriv�e
		return true; // true si d�placement effectu�
	}
}
