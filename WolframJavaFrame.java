import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;


public abstract class WolframJavaFrame extends JFrame {
	protected JLabel image = new JLabel(new ImageIcon(getClass().getResource("title.PNG")));
	private JLabel label = new JLabel( "Search:" );
	protected JTextField searchbar = new JTextField( 10 );
	protected JButton search = new JButton( "Search" );
	protected JButton home = new JButton( "Home" );
	
	WolframJavaFrame() {
		super("");
	}
	WolframJavaFrame( String title, int w, int h ) {
		super( title );
		setSize( w, h );
	}
	
	public void addSearchListener( ActionListener AL ) {
		search.addActionListener( AL );
	}
	
	public void addHomeListener( ActionListener AL ) {
		home.addActionListener( AL );
	}
	
	public String getQuery() {
		return searchbar.getText();
	}
	
	public void setInvisible() {
		setVisible( false );
		getContentPane().removeAll();
	}
	
	public void setVisible() {
		setVisible( true );
	}
	
	protected int getW() {
		return getWidth();
	}
	
	protected int getH() {
		return getHeight();
	}
	
	
/*******************************PANELS*******************************/
	
	class myPanel extends JPanel {			// All my panels will have a light gray background
		protected void paintComponent( Graphics g ) {		// Color background light gray
			g.setColor( new Color(222,222,222) );
			g.fillRect( 0, 0, getWidth(), getHeight() );
		}
	}
	
	class TitlePanel extends myPanel {		// Displays the "WolframJava" title and the search bar	
		TitlePanel( int w, int h, Boolean isHome ) {
			setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );		// Stack the title on top of the search bar
			setPreferredSize( new Dimension( w, h) );
			add( image );
			add( new searchPanel( isHome ) );
		}
	}

	class searchPanel extends myPanel {		// Displays the search bar
		searchPanel( Boolean isHome ) {
			setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );		// Place 'search' label and search bar next to one another
			searchbar.setText( "" );
			add( label );
			add( searchbar );
			add( search );
			if ( isHome.equals( false ) ) {
				add( home );
			}
		}
	}

	class EmptyPanel extends myPanel {						
		EmptyPanel( int w, int h) {
			setPreferredSize( new Dimension( w, h ) );
		}
	}
	
	class NorthPanel extends myPanel {					// Organizes the title panels with the empty panels so that everything looks structured
		NorthPanel( Boolean isHome ) {
			setLayout( new GridLayout(1,3) );
			add( new EmptyPanel( getWidth()/3, 90 ) );
			add( new TitlePanel( getWidth()/3, 90, isHome ) );
			add( new EmptyPanel( getWidth()/3, 90 ) );
		}
	}
}

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
