import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WolfRamJava {
	private HomeFrame HF = new HomeFrame( 1300, 600 );
	private ClassFrame CF = new ClassFrame( 1300, 600 );;
	private MethodFrame MF = new MethodFrame( 1300, 600 );;
	private VocabFrame VF = new VocabFrame( 1300, 600 );;
	
	public static void main(String[] args) {
		WolfRamJava WJ = new WolfRamJava();
		WJ.go();
	}
	
	void go() {
		initSearchButtons();
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
	}
	
	void initSearchButtons() {
		HF.addSearchListener( new HFSearchButtonListener() );
		CF.addSearchListener( new CFSearchButtonListener() );
		MF.addSearchListener( new MFSearchButtonListener() );
		VF.addSearchListener( new VFSearchButtonListener() );
	}
	
	private class HFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = HF.getQuery();
			Searchable result = QueryHandler.query( query );
			HF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class CFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = CF.getQuery();
			Searchable result = QueryHandler.query( query );
			CF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class MFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = MF.getQuery();
			Searchable result = QueryHandler.query( query );
			MF.setInvisible();
			openNextFrame( result );
		}
	}
	
	private class VFSearchButtonListener implements ActionListener {
		public void actionPerformed( ActionEvent event ) {
			String query = VF.getQuery();
			Searchable result = QueryHandler.query( query );
			VF.setInvisible();
			openNextFrame( result );
		}
	}
	
}
