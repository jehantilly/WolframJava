import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		getContentPane().add(BorderLayout.NORTH, new NorthPanel( true ) );	// True indicates 'Is Home Screen'
		getContentPane().add(BorderLayout.CENTER, new CenterPanel() );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	private class CenterPanel extends myPanel {
		CenterPanel() {
			setLayout( new GridLayout(3,5) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new GlossaryPanel() );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
			add( new EmptyPanel( getW(), getH() ) );
		}
	}
	
	private class GlossaryPanel extends myPanel {		// Displays the "WolframJava" title and the search bar	
		private Object[] glossary = Database.getVocab();
		private String[] glossaryStrings = new String[ glossary.length ];
		private ArrayList<VocabFrame2> selectedVocab = new ArrayList<VocabFrame2>();
		JList list;
		
		GlossaryPanel() {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
			for( int i = 0; i < glossary.length; ++i ) {
				Vocab V = (Vocab) glossary[i];
				glossaryStrings[i] = V.getName();
			}
			add( new JLabel( "Glossary" ) );
			list = new JList( glossaryStrings );
			list.addListSelectionListener( new GlossaryListListener() );
			add( new MyScrollPane( list ) );
		}
		
		private class GlossaryListListener implements ListSelectionListener {
			public void valueChanged( ListSelectionEvent lse ) {
				if ( !lse.getValueIsAdjusting() )	{	// So this function is not called twice
					String chosenString = ( String ) list.getSelectedValue();	// Store the "Player vs Player" option chosen by the user
					int i;
					for( i = 0; i < glossaryStrings.length; ++i ) {
						if( chosenString.equals( glossaryStrings[i] ) ) {
							break;
						}
					}
					Vocab chosenVocab = (Vocab) (glossary[i]);
					VocabFrame2 VF = new VocabFrame2( getW()/3 + 50, getH()/3 ); 
					selectedVocab.add( VF );
					VF.go( chosenVocab );
				}
			}
		}
	}
}

 class VocabFrame2 extends WolframJavaFrame {

	VocabFrame2( int w, int h ) {
		super("", w, h );
	}
	
	void go( Vocab V ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.CENTER, new CenterPanel( V, getWidth(), getHeight() ) );
		setVisible( true );
	}
	
	class CenterPanel extends myPanel {
		private NamePanel NP;
		
		CenterPanel( Vocab V, int w, int h ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			NP = new NamePanel( w, h, V );
			add( image );
			add( NP );
		}
	}
	
	class NamePanel extends myPanel {
		private String name;
		private String desc;
		
		NamePanel( int w, int h, Vocab V ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
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
