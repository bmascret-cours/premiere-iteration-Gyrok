package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controler.ChessGameControlers;

public class ChessGameGUI extends JFrame implements MouseListener,MouseMotionListener,Observer{
	
	  JLayeredPane layeredPane;
	  JPanel echiquierGUI;
	  JLabel pieceGUI;
	  int xAdjustment;
	  int yAdjustment;
	  
	public ChessGameGUI(String string, ChessGameControlers chessGameControler, Dimension dim) {
		
		Dimension boardSize = new Dimension(600, 600);
		 
		  //  Use a Layered Pane for this this application
		  layeredPane = new JLayeredPane();
		  getContentPane().add(layeredPane);
		  layeredPane.setPreferredSize(boardSize);
		  layeredPane.addMouseListener(this);
		  layeredPane.addMouseMotionListener(this);

		  //Add a chess board to the Layered Pane 
		 
		  echiquierGUI = new JPanel();
		  layeredPane.add(echiquierGUI, JLayeredPane.DEFAULT_LAYER);
		  echiquierGUI.setLayout( new GridLayout(8, 8) );
		  echiquierGUI.setPreferredSize( boardSize );
		  echiquierGUI.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  echiquierGUI.add( square );
		 
		  int row = (i / 8) % 2;
		  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
		  else
		  square.setBackground( i % 2 == 0 ? Color.white : Color.black );
		  }
		 

		  
	}

	@Override
	public void update(Observable arg0, Object arg1){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
