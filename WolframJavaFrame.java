import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public abstract class WolframJavaFrame extends JFrame {
	private JLabel image = new JLabel(new ImageIcon(getClass().getResource("title.PNG")));
	private JLabel label = new JLabel( "Search:" );
	protected JTextField searchbar = new JTextField( 10 );
	protected JButton search = new JButton( "Search" );
	
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
	
	
/*******************************PANELS*******************************/
	
	class myPanel extends JPanel {			// All my panels will have a light gray background
		protected void paintComponent( Graphics g ) {		// Color background light gray
			g.setColor( new Color(222,222,222) );
			g.fillRect( 0, 0, getWidth(), getHeight() );
		}
	}
	
	class TitlePanel extends myPanel {		// Displays the "WolframJava" title and the search bar	
		TitlePanel( int w, int h ) {
			setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );		// Stack the title on top of the search bar
			setPreferredSize( new Dimension( w, h) );
			add( image );
			add( new searchPanel() );
		}
	}

	class searchPanel extends myPanel {		// Displays the search bar
		searchPanel() {
			setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );		// Place 'search' label and search bar next to one another
			add( label );
			add( searchbar );
			add( search );
		}
	}


	class EmptyPanel extends myPanel {						
		EmptyPanel( int w, int h) {
			setPreferredSize( new Dimension( w, h ) );
		}
	}
	
	class NorthPanel extends myPanel {					// Organizes the title panels with the empty panels so that everything looks structured
		NorthPanel() {
			setLayout( new GridLayout(1,3) );
			add( new EmptyPanel( getWidth()/3, 90 ) );
			add( new TitlePanel( getWidth()/3, 90 ) );
			add( new EmptyPanel( getWidth()/3, 90 ) );
		}
	}
}
