import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClassFrame extends WolframJavaFrame {
	
	ClassFrame( int w, int h ) {
		super("", w, h );
	}
	
	public void go( Class query ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.NORTH, new NorthPanel( false ) );	// False indicates 'Not Home Screen'
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
			if ( C.hasSimilarClasses() ) {
				add( new JLabel(" ") );
				lines = getLines( "Similar Classes: " + C.getSimilarClasses() );
				for( int i = 0; i < lines.size(); ++i ) {
					add( new JLabel( lines.get( i ) ) );
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
		private Object[] constructors;
		private String[] constructorStrings;
		private Object[] methods;
		private String[] methodStrings;
		private JList listC;
		private JList listM;
		private ArrayList<ConstructorFrame> selectedConstructors;
		private ArrayList<MethodFrame2> selectedMethods;
		
		
		MethodListPanel( int w, int h, Class C ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );	// Stack the components
			setPreferredSize( new Dimension( w, h ) );
			constructors = C.getConstructors().toArray();
			constructorStrings = new String[ constructors.length ];
			selectedConstructors = new ArrayList<ConstructorFrame>();
			methods = C.getMethods().toArray();
			methodStrings = new String[ methods.length ];
			selectedMethods = new ArrayList<MethodFrame2>();
			
			if( constructors.length > 0 ) {
				// Display constructors in a scroll-up/scroll-down bar
				for( int i = 0; i < constructors.length; ++i ) {
					Constructor c = (Constructor) constructors[i];
					String s = c.getName();
					s += c.getParameters();
					constructorStrings[i] = s;
				}
				listC = new JList( constructorStrings );
				add( new JLabel("Constructor List (Click for description):") );
				add( new MyScrollPane( listC ) );
				listC.addListSelectionListener( new ConstructorListListener() );
				add( new JLabel(" ") );
			}
			
			if( methods.length > 0 ) {
				// Display methods in a scroll-up/scroll-down bar
				for( int i = 0; i < methods.length; ++i ) {
					Method md = (Method) methods[i];
					String s = md.getReturnType();
					s += " " + md.getName();
					s += md.getParameters();
					methodStrings[i] = s;
				}
				listM = new JList( methodStrings );
				add( new JLabel("Method List (Click for description):") );
				add( new MyScrollPane( listM ) );
				listM.addListSelectionListener( new MethodListListener() );
				add( new JLabel(" ") );
			}
		}
		
		private class ConstructorListListener implements ListSelectionListener {
			public void valueChanged( ListSelectionEvent lse ) {
				if ( !lse.getValueIsAdjusting() )	{	// So this function is not called twice
					String chosenString = ( String ) listC.getSelectedValue();	// Store the "Player vs Player" option chosen by the user
					int i;
					for( i = 0; i < constructorStrings.length; ++i ) {
						if( chosenString.equals( constructorStrings[i] ) ) {
							break;
						}
					}
					Constructor chosenConstruct = (Constructor) (constructors[i]);
					ConstructorFrame CF = new ConstructorFrame( getW()/3 + 50, getH()/3 ); 
					selectedConstructors.add( CF );
					CF.go( chosenConstruct );
				}
			}
		}

		
		private class MethodListListener implements ListSelectionListener {
			public void valueChanged( ListSelectionEvent lse ) {
				if ( !lse.getValueIsAdjusting() )	{	// So this function is not called twice
					String chosenString = ( String ) listM.getSelectedValue();	// Store the "Player vs Player" option chosen by the user
					int i;
					for( i = 0; i < methodStrings.length; ++i ) {
						if( chosenString.equals( methodStrings[i] ) ) {
							break;
						}
					}
					Method chosenMethod = (Method) (methods[i]);
					MethodFrame2 MF = new MethodFrame2( getW()/3 + 50, getH()/2 ); 
					selectedMethods.add( MF );
					MF.go( chosenMethod );
				}
			}
		}
	}
}

class MethodFrame2 extends WolframJavaFrame {
	
	MethodFrame2( int w, int h ) {
		super("", w, h );
	}
	
	void go( Method M ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.NORTH, image );
		getContentPane().add( BorderLayout.CENTER, new CenterPanel( M, getW(), getH() ) );
		setVisible( true );
	}
	
	class CenterPanel extends myPanel {
		private NamePanel NP;
		
		CenterPanel( Method M, int w, int h ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
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
}

class ConstructorFrame extends WolframJavaFrame {
	
	ConstructorFrame( int w, int h ) {
		super("", w, h );
	}
	
	void go( Constructor C ) {
		getContentPane().setBackground( new Color(222,222,222) );	// Set to light grey
		getContentPane().add( BorderLayout.NORTH, image );
		getContentPane().add( BorderLayout.CENTER, new CenterPanel( C, getW(), getH() ) );
		setVisible( true );
	}
	
	class CenterPanel extends myPanel {
		private NamePanel NP;
		
		CenterPanel( Constructor C, int w, int h ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			NP = new NamePanel( w, h, C );
			add( NP );
		}
	}
	
	class NamePanel extends myPanel {
		private String name;
		private String desc;
		private String enclosing;	// Enclosing Class
		
		NamePanel( int w, int h, Constructor C ) {
			setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );		// Stack the components
			setPreferredSize( new Dimension( w, h ) );
			name = C.getName();
			desc = C.getDesc();
			enclosing = C.getEnclosing();
			ArrayList<String> lines = getLines( "Description: " + desc );	// Split description up into individual lines
			add( new JLabel(" ") );
			add( new JLabel( "Name: " + enclosing + "." + name ) );
			add( new JLabel(" ") );
			add( new JLabel( C.toString() ) );
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