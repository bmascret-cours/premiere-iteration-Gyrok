package model;

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
	
	public Object getPiecesIHM() {
		// TODO Auto-generated method stub
		return null;
	}

	public void switchJoueur() {
		
		// On échange les 2 jeux
		Jeu tempStorage = this.jeuCourant;
		this.jeuCourant = this.jeuAttente;
		this.jeuAttente = tempStorage;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

}
