
class Vocab extends Searchable {
	public String getType() { return "Vocab"; }
}

class Abstract extends Vocab {
	Abstract() {
		setName( "abstract" );
		setDesc( "A Java(TM) programming language keyword used in a class definition to specify that a class is not to be instantiated, but rather inherited by other classes." );
	}
}

class AbstractClass extends Vocab {
	AbstractClass() {
		setName( "abstract class" );
		setDesc( "A class that contains one or more abstract methods, and therefore can never be instantiated." );
	}
}

class AbstractMethod extends Vocab {
	AbstractMethod() {
		setName( "abstract method" );
		setDesc( "A method that has no implementation." );
	}
}
