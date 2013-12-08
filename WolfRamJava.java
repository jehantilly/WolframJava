import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WolfRamJava {
	private HomeFrame HF = new HomeFrame( 1450, 725 );
	private ClassFrame CF = new ClassFrame( 1450, 725 );
	private MethodFrame MF = new MethodFrame( 1450, 725 );
	private VocabFrame VF = new VocabFrame( 1450, 725 );
	private EmptyFrame EF = new EmptyFrame( 1450, 725 );
	
	public static void main(String[] args) {
		WolfRamJava WJ = new WolfRamJava();
		WJ.go();
	}
	
	void go() {
		initButtonsListeners();
		HF.go();
	}
	
	private void openNextFrame( Searchable S ) {
		if( S.getType().equals( "Class" ) ) {
			CF.go( ( Class ) S );
		}
		if( S.getType().equals( "Method" ) ) {
			MF.go( ( Method ) S );
		}
		if( S.getType().equals( "Vocab" ) ) {
			VF.go( ( Vocab ) S );
		}
		if( S.getType().equals( "No Result" ) ) {	// No matches found
			EF.go( S.getName() );
		}
	}
	
	void initButtonsListeners() {
		HF.addSearchListener( new HFSearchButtonListener() );
		CF.addSearchListener( new CFSearchButtonListener() );
		MF.addSearchListener( new MFSearchButtonListener() );
		VF.addSearchListener( new VFSearchButtonListener() );
		EF.addSearchListener( new EFSearchButtonListener() );
		CF.addHomeListener( new CFHomeButtonListener() );
		VF.addHomeListener( new VFHomeButtonListener() );
		MF.addHomeListener( new MFHomeButtonListener() );
		EF.addHomeListener( new EFHomeButtonListener() );
	}
	
	private class HFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = HF.getQuery();
			// Remove extra whitespace, outside and inside the String
			query = query.trim().replaceAll( "\\s{2,}", " " );
			Searchable result = QueryHandler.query( query );
			HF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class CFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = CF.getQuery();
			// Remove extra whitespace, outside and inside the String
			query = query.trim().replaceAll( "\\s{2,}", " " );
			Searchable result = QueryHandler.query( query );
			CF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class MFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = MF.getQuery();
			// Remove extra whitespace, outside and inside the String
			query = query.trim().replaceAll( "\\s{2,}", " " );			
			Searchable result = QueryHandler.query( query );
			MF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class VFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = VF.getQuery();
			// Remove extra whitespace, outside and inside the String
			query = query.trim().replaceAll( "\\s{2,}", " " );				
			Searchable result = QueryHandler.query( query );
			VF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class EFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = EF.getQuery();
			// Remove extra whitespace, outside and inside the String
			query = query.trim().replaceAll( "\\s{2,}", " " );				
			Searchable result = QueryHandler.query( query );
			EF.setInvisible();
			openNextFrame( result );
		}
	}	
	
	private class CFHomeButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			CF.setInvisible();
			HF.go();
		}
	}
	
	private class MFHomeButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			MF.setInvisible();
			HF.go();
		}
	}
	
	private class VFHomeButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			VF.setInvisible();
			HF.go();
		}
	}
	
	private class EFHomeButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			EF.setInvisible();
			HF.go();
		}
	}
}
