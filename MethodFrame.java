import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MethodFrame extends WolframJavaFrame {
	
	MethodFrame( int w, int h ) {
		super("", w, h );
	}
	
	void go( Method M ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.NORTH, new NorthPanel( false ) ); 	// False indicates 'Not Home Screen'
		getContentPane().add( BorderLayout.EAST, new EmptyPanel( getWidth()/4, 100 ) );
		getContentPane().add( BorderLayout.WEST, new EmptyPanel( getWidth()/4, 100 ) );
		getContentPane().add( BorderLayout.CENTER, new CenterPanel( M, getWidth()/2, 1120 ) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );
	}
	
	class CenterPanel extends myPanel {
		private NamePanel NP;
		
		CenterPanel( Method M, int w, int h ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			searchbar.setText( M.getEnclosing() + "." + M.getName() );
			NP = new NamePanel( w, h, M );
			add( NP );
		}
	}
	
	class NamePanel extends myPanel {
		private String name;
		private String desc;
		private String enclosing;	// Enclosing Class
		private String returns;		// Describes the return-type
		
		NamePanel( int w, int h, Method M ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			setPreferredSize( new Dimension( w, h ) );
			name = M.getName();
			desc = M.getDesc();
			enclosing = M.getEnclosing();
			returns = M.getReturns();
			ArrayList<String> lines = getLines( "Description: " + desc );	// Split description up into individual lines
			add( new JLabel(" ") );
			add( new JLabel( "Name: " + enclosing + "." + name ) );
			add( new JLabel(" ") );
			add( new JLabel( M.toString() ) );
			add( new JLabel(" ") );
			add( new JLabel( "Enclosing Class: " + enclosing ) );
			add( new JLabel(" ") );
			for( int i = 0; i < lines.size(); ++i ) {
				add( new JLabel( lines.get( i ) ) );
			}
			if ( returns != null ) {
				add( new JLabel(" ") );
				ArrayList<String> lines2 = getLines( "Returns: " + returns );
				for( int i = 0; i < lines2.size(); ++i ) {
					add( new JLabel( lines2.get( i ) ) );
				}
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
	
	/*class MethodPanel extends myPanel {		// Organizes the methods properly
		private MethodListPanel MLP;
		
		
		MethodPanel( int w, int h, Class C ) {
			MLP = new MethodListPanel( w/2, h, C );
			setLayout( new BoxLayout( this, BoxLayout.X_AXIS) );	// Display components from left to right
			add( new EmptyPanel( w/4, h ) );
			add( MLP );
			add( new EmptyPanel( w/4, h ) );
		}
	}*/

}
