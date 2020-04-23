package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	
	Couleur couleurJeu = Couleur.BLANC;
	List<Pieces> pieces;
	int xFinalPrevious = -1;
	int yFinalPrevious = -1;
	int xInitPrevious = -1;
	int yInitPrevious = -1;
	public Jeu(Couleur couleur) {
		Couleur pieceCouleur = couleur;
		this.couleurJeu = couleur;
		this.pieces = ChessPiecesFactory.newPieces(pieceCouleur);
	}

	// Test main
	public static void main(String[] args) {
		Jeu testConstruction = new Jeu(Couleur.NOIR);
		List<Pieces> listPieces = ChessPiecesFactory.newPieces(Couleur.NOIR);
		testConstruction.toString(listPieces);
	}
	
	public boolean isPieceHere(int x,int y) {
		for (Pieces piece : this.pieces) {
			if ((piece.getX() == x) && (piece.getY() == y)){
				return true; // true si une pièce se trouve aux coordonnées indiquées
			}
		}
		return false;
	}
	
	public boolean isMoveOk(int xInit, int yInit,int xFinal,int yFinal) {
		return this.findPiece(xInit, yInit).isMoveOk(xFinal,yFinal); // true si déplacement possible
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {

		// on commence par chercher quelle pièce est à l'endroit init
		Pieces pieceInit = this.findPiece(xInit, yInit);
		// Maintenant on vérifie si on capture
		if ((pieceInit != null) && this.isMoveOk(xInit ,yInit ,xFinal ,yFinal)) {
			
			// met  à jour dernier mvt pour pouvoir revenir en arrière
			// ptet ajouter un objet move
			this.xFinalPrevious = xFinal;
			this.yFinalPrevious = yFinal;
			this.xInitPrevious = xInit;
			this.yInitPrevious = yInit;
			
			return true;
		}
		 return false;
	}
		
	public void toString(List<Pieces> pieces) {
		
		// itérer sur les pieces pour call les toString
		for (Pieces piece : this.pieces) {
		   String testString = piece.toString(); 
		   System.out.println(testString);
		}
	}
	
	public Couleur getPieceColor(int x,int y) {
		return this.findPiece(x, y).getCouleur();
		
	}
	
	public java.lang.String getPieceType(int x,int y){
		return this.findPiece(x, y).getClass().getSimpleName();
	}
	
	private Pieces findPiece(int x, int y) {
		Pieces pieceTrouvee = null;
		for (Pieces piece : this.pieces) {
			
			/* On compare une seule fois vu que de toute façon si chevauchement
			*	c'est que cette méthode a déjà mal fait son travail
			*/
			if ((piece.getX() == x) && (piece.getY() == y)){
				pieceTrouvee = piece;
			}
		}
		return pieceTrouvee;
	}
	
	public Couleur getCouleur() {
		return this.couleurJeu;
	}

	public Coord getKingCoord() {
		
		Coord returnPlaceholder = new Coord(-1,-1);
		for (Pieces piece : this.pieces) {
			
			if (this.getPieceType(piece.getX(), piece.getY()) == "Roi"){
				
				Coord coordRoi = new Coord(piece.getX(),piece.getY());
				return coordRoi;
				
			}
		}
		return returnPlaceholder;
	}

	public void undoMove() {
		this.move(this.xFinalPrevious, this.yFinalPrevious, this.xInitPrevious, this.yInitPrevious);
	}
}
