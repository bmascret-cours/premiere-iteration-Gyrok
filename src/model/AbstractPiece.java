package model;

public abstract class AbstractPiece implements Pieces{
	public int x, y;
	public Couleur couleur;
	public String nom;
	public AbstractPiece(Couleur couleur,Coord coord) {
		this.x = coord.x;
		this.y = coord.y;
	}
	 @Override
	 public java.lang.String toString() {
		 // retourne le nom et les coordonnées x et y de la pièce
		  
		 String nomCoord = "nom = " + this.nom +  " x = " + Integer.toString(this.getX()) + " y = " + Integer.toString(this.getY());
		 
		 return nomCoord;
	}
	 public int getX() {
		 return this.x;
	 }
	 public int getY() {
		 return this.y;
	 }
	 public Couleur getCouleur() {
		 return this.couleur;
	 }
	 
	 public boolean move(int x,int y) {
	
	if (this.isMoveOk(x,y)) {
		this.x = x;
		this.y = y;
		return true;
	}
	
	else {
		return false;
	}
	
	}
		
	public boolean capture() {
		this.x = -1;
		this.y = -1;
		return true;
	}
	public abstract boolean isMoveOk(int xFinal,int yFinal);
}
