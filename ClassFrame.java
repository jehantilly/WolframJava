import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


public class ClassFrame extends WolframJavaFrame {
	
	ClassFrame( int w, int h ) {
		super("", w, h );
	}
	
	public void go( Class query ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.NORTH, new NorthPanel() );
		getContentPane().add( BorderLayout.EAST, new EmptyPanel( getWidth()/4, 100 ) );
		getContentPane().add( BorderLayout.WEST, new EmptyPanel( getWidth()/4, 100 ) );
		getContentPane().add( BorderLayout.CENTER, new CenterPanel( query , getWidth()/2, 1120 ) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	/*******************PANELS*************************/
	
	class CenterPanel extends myPanel {
		private NamePanel NP;
		private MethodPanel MP;
		
		CenterPanel( Class C, int w, int h ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			searchbar.setText( C.getName() );
			NP = new NamePanel( w, h/4, C );
			add( NP );
			MP = new MethodPanel( w/2, 3*h/4, C );
			add( MP );
		}
	}
	
	class NamePanel extends myPanel {
		private String name;
		private String desc;
		private String parent;
		
		NamePanel( int w, int h, Class C ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			setPreferredSize( new Dimension( w, h ) );
			name = C.getName();
			desc = C.getDesc();
			parent = C.getParent();
			ArrayList<String> lines = getLines( "Description: " + desc );	// Split description up into individual lines
			add( new JLabel(" ") );
			add( new JLabel( "Name: " + name ) );
			add( new JLabel(" ") );
			add( new JLabel( "Parent: " + parent ) );
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
	
	class MethodPanel extends myPanel {		// Organizes the methods properly
		private MethodListPanel MLP;
		
		
		MethodPanel( int w, int h, Class C ) {
			MLP = new MethodListPanel( w/2, h, C );
			setLayout( new BoxLayout( this, BoxLayout.X_AXIS) );	// Display components from left to right
			add( new EmptyPanel( w/4, h ) );
			add( MLP );
			add( new EmptyPanel( w/4, h ) );
		}
	}
	
	class MethodListPanel extends myPanel {		// Displays the list of methods
		private Object[] methods;
		private String[] methodStrings;
		private JList list;
		
		
		MethodListPanel( int w, int h, Class C ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );	// Stack the components
			setPreferredSize( new Dimension( w, h ) );
			methods = (Object[]) C.getMethods().toArray();
			methodStrings = new String[ methods.length ];
			
			// Display methods in a scroll-up/scroll-down bar
			for( int i = 0; i < methods.length; ++i ) {
				Method md = (Method) methods[i];
				String s = md.getReturnType();
				s += " " + md.getName();
				s += md.getParameters();
				methodStrings[i] = s;
			}
			list = new JList( methodStrings );
			add( new JLabel("Method List (Click for description):") );
			add( new MyScrollPane( list ) );
		}
	}
}




enum myFont { Bold, Italic, BoldItalic }

class MyScrollPane extends JScrollPane {
	/**
	 * JScrollpane for when one option can be selected (Example: Time Limit)
	 */
	MyScrollPane( JList JL ) {
		super( JL );
		setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		JL.setVisibleRowCount( 5 );
		JL.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
	}
	

}
