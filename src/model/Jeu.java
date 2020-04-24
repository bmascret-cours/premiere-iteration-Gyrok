package model;

import java.util.LinkedList;
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
		if (this.findPiece(xInit, yInit) == null) {
			return false;
		}
		else {
			return this.findPiece(xInit, yInit).isMoveOk(xFinal,yFinal); // true si déplacement possible
		}
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
		
	public String toString(List<Pieces> pieces) {
		
		String returnString = "";
		// itérer sur les pieces pour call les toString
		for (Pieces piece : this.pieces) {
		   String testString = piece.toString(); 
		   System.out.println(testString);
		   returnString = returnString + testString + " ";
		}
		return returnString;
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

	/**
	* @return une vue de la liste des pièces en cours
	* ne donnant que des accès en lecture sur des PieceIHM
	* (type piece + couleur + liste de coordonnées)
	*/
	public List<PieceIHM> getPiecesIHM(){
	PieceIHM newPieceIHM = null;
	List<PieceIHM> list = new LinkedList<PieceIHM>();
	for (Pieces piece : pieces){
		boolean existe = false;
		// si le type de piece existe déjà dans la liste de PieceIHM
		// ajout des coordonnées de la pièce dans la liste de Coord de ce type
		// si elle est toujours en jeu (x et y != -1)
		for ( PieceIHM pieceIHM : list){
			if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
				existe = true;
				if (piece.getX() != -1){
					pieceIHM.add(new Coord(piece.getX(), piece.getY()));
				}
			}
		}
		// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
		if (! existe) {
			if (piece.getX() != -1){
				newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
						piece.getCouleur());
						newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
						list.add(newPieceIHM);
			}
		}
	}
	return list;
	}

}
