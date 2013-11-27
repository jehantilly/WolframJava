
abstract class Searchable {
	private String name;
	private String description;
	
	Searchable() {
		name = null;
		description = null;
	}
	
	public abstract String getType();	
	String getName() { return name; }
	String getDesc() { return description; }
	void setName( String n ) { name = n; }
	void setDesc( String d ) { description = d; }
}
