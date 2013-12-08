
abstract class Searchable {
	private String name;
	private String description;
	
	Searchable() {
		name = null;
		description = null;
	}
	
	abstract String getType();
	abstract String[] getComparableNames();
	String getName() { return name; }
	String getDesc() { return description; }
	void setName( String n ) { name = n; }
	void setDesc( String d ) { description = d; }
}

class NoResult extends Searchable {	// Used to indicate no matches were found
	
	NoResult( String badQuery ) {
		setName( badQuery );
	}
	String getType() {
		return "No Result";
	}
	String[] getComparableNames() {
		return new String[]{""};
	}
}