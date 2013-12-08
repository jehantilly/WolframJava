import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.Iterator;


public class QueryHandler {	
	public static Searchable query( String s ) {
		myPair topResult = getTopResult( s.toLowerCase() );
		if ( topResult == null ) {	// Indicates no match found
			return new NoResult( s );
		}
		
		return topResult.getSearchable();
	}

	
	private static myPair getTopResult( String s) {
		Object[] ourClasses = Database.getClasses();
		Object[] ourMethods = Database.getMethods();
		Object[] ourVocab = Database.getVocab();
		
		ArrayList<myPair> PQ = new ArrayList<myPair>();
		
		double maxSim = 0;
		myPair maxPair = null;
		for( int i = 0; i < ourClasses.length; ++i ) {
			Class C = (Class) ourClasses[i];
			String[] names = C.getComparableNames();
			for( int j = 0; j < names.length; ++j ) {
				double sim = Similarity.getSimilarity( s, names[j] );
				// PQ.add( new myPair( sim, C ) );
				if ( sim == 1.0 ) {
					return new myPair( sim, C );	// Perfect match found, end early
				}
				if( sim > maxSim ) {
					maxSim = sim;
					maxPair = new myPair( sim, C );
				}
			}
		}
		
		for( int i = 0; i < ourMethods.length; ++i ) {
			Method M = (Method) ourMethods[i];
			String[] names = M.getComparableNames();
			for( int j = 0; j < names.length; ++j ) {
				double sim = Similarity.getSimilarity( s, names[j] );
				// PQ.add( new myPair( sim, M ) );
				if ( sim == 1.0 ) {
					return new myPair( sim, M );	// Perfect match found, end early
				}
				if( sim > maxSim ) {
					maxSim = sim;
					maxPair = new myPair( sim, M );
				}
			}
		}
		
		for( int i = 0; i < ourVocab.length; ++i ) {
			Vocab V = (Vocab) ourVocab[i];
			String[] names = V.getComparableNames();
			for( int j = 0; j < names.length; ++j ) {
				double sim = Similarity.getSimilarity( s, names[j] );
				// PQ.add( new myPair( sim, V ) );
				if ( sim == 1.0 ) {
					return new myPair( sim, V );	// Perfect match found, end early
				}
				if( sim > maxSim ) {
					maxSim = sim;
					maxPair = new myPair( sim, V );
				}
			}
		}
		
	//	Collections.sort( PQ, new qComp() );
	//	for( int i = 0; i < 10; ++i ) {
	//		System.out.println( "" + i + ": " + PQ.get(i).getVal() + "| " + PQ.get(i).getSearchable().getName() );
	//	}
		
		return maxPair;
	}
}

class myPair {
	Double value;
	Searchable searchable;
	
	myPair( Double v, Searchable s ) {
		value = v;
		searchable = s;
	}
	public Double getVal() { return value; }
	public Searchable getSearchable() { return searchable; }
}


class qComp implements Comparator<myPair> {	
	public int compare( myPair p1, myPair p2 ) {
		double val1 = p1.getVal(), val2 = p2.getVal();
		if ( val1 > val2 ) {
			return -1;
		}
		else if ( val1 == val2 ) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public boolean equals( Object o ) {
		return ( this == o );
	}
}
