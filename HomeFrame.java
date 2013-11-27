import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;


public class HomeFrame extends WolframJavaFrame {
	HomeFrame( int w, int h ) {
		super( "Home", w, h );
	}
	
//	public static void main(String[] args) {
//		HomeFrame H = new HomeFrame( 1300, 600 );
//		H.go();
//	}
	
	public void go() {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add(BorderLayout.NORTH, new NorthPanel() );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
}
