import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VocabFrame extends WolframJavaFrame {

	VocabFrame( int w, int h ) {
		super("", w, h );
	}
	
	void go( Vocab V ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.NORTH, new NorthPanel() );
		getContentPane().add( BorderLayout.EAST, new EmptyPanel( getWidth()/4, 100 ) );
		getContentPane().add( BorderLayout.WEST, new EmptyPanel( getWidth()/4, 100 ) );
		getContentPane().add( BorderLayout.CENTER, new CenterPanel( V, getWidth()/2, 1120 ) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	class CenterPanel extends myPanel {
		private NamePanel NP;
		
		CenterPanel( Vocab V, int w, int h ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			NP = new NamePanel( w, h, V );
			add( NP );
		}
	}
	
	class NamePanel extends myPanel {
		private String name;
		private String desc;
		
		NamePanel( int w, int h, Vocab V ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			searchbar.setText( V.getName() );
			setPreferredSize( new Dimension( w, h ) );
			name = V.getName();
			desc = V.getDesc();
			ArrayList<String> lines = getLines( "Definition: " + desc );	// Split description up into individual lines
			add( new JLabel(" ") );
			add( new JLabel( "Term: " + name ) );
			add( new JLabel(" ") );
			for( int i = 0; i < lines.size(); ++i ) {
				add( new JLabel( lines.get( i ) ) );
			}
		}
		
		ArrayList<String> getLines( String desc ) {   // Divide string into multiple strings with 100 characters or less
			ArrayList<String> lines = new ArrayList<String>();
			for( int i = 0; i < desc.length(); ++i ) {
				String line = "";
				int j = 0;
				while( j < 85 && j < desc.length() && i < desc.length() ) {
					line = concat( line, desc.charAt(i) );	// Concatenate next character
					++j; ++i;
				}
				--i;
				if( i < desc.length() - 1 ) {		// Prevent lines from stopping inside of a word
					if ( desc.charAt( i ) != ' ' && desc.charAt( i + 1 ) != ' ' ) {		
						while( desc.charAt( i ) != ' ' ) {
							--i;
							--j;
						}
					}
				}
				lines.add( line.substring( 0, j ) );
			}
			
			return lines;
		}
		

		String concat( String s, char c ) {	// Concatenate 'c' onto 's'
			return new StringBuilder( s ).append( c ).toString();
		}
	}

}
