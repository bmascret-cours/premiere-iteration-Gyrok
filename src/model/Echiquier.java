package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Echiquier implements BoardGames{
	
	// On initialise les 2 jeux.
	private Jeu jeuCourant = null;
	private Jeu jeuAttente = null;
	
	// Message
	private String message = "message placeholder";
	
	public Echiquier() {
		this.jeuCourant = new Jeu(Couleur.BLANC);
		this.jeuAttente = new Jeu(Couleur.NOIR);
	}
	
	public static void main(String[] args) {
		Echiquier test = new Echiquier();
		String ficelleTest = test.toString();
		System.out.println(ficelleTest);
	}
	/**
	 * @param message the message to set
	 */
	private void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	
	public String toString() {
		String jeuC = this.jeuCourant.toString(jeuCourant.pieces);
		String jeuA = this.jeuAttente.toString(jeuCourant.pieces);
		String strFinal = jeuC + jeuA;
		return strFinal;
	}

	public void switchJoueur() {
		
		// On échange les 2 jeux
		Jeu tempStorage = this.jeuCourant;
		this.jeuCourant = this.jeuAttente;
		this.jeuAttente = tempStorage;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		return this.jeuCourant.move(xInit, yInit, xFinal, yFinal);
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		return this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal);
	}
	public List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> partie1 = this.jeuCourant.getPiecesIHM();
		List<PieceIHM> partie2 = this.jeuAttente.getPiecesIHM();
		partie1.addAll(partie2);
		return partie1;
	}
}
