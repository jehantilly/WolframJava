import java.util.ArrayList;




abstract class Method extends Searchable {
	class ParameterList {
		ParameterList() {
			types = new ArrayList<String>();
			names = new ArrayList<String>();
		}
		private ArrayList<String> types;
		private ArrayList<String> names;
		
		public void addParam( String type, String name ) {
			types.add( type );
			names.add( name );
		}
		
		public String toString() {
			String s = "( ";
			for( int i = 0; i < types.size(); ++i ) {
				s += types.get(i);
				s += " " + names.get(i);
				if ( i != types.size() - 1 ) {
					s += ", ";
				}
			}
			s += " )";
			return s;
		}
		public String toString2() {
			String s = "(";
			for( int i = 0; i < types.size(); ++i ) {
				s += types.get(i);
				if ( i != types.size() - 1 ) {
					s += ",";
				}
			}
			s += ")";
			return s;
		}
	}
	
	class ReturnType {
		private String accessProperty;
		private String type;
		ReturnType( String access, String typ ) {
			accessProperty = access;
			type = typ;
		}
		public String toString() {
			return accessProperty + " " + type;
		}
	}
	
	String[] getComparableNames() {
		String enclosing = new String( enclosingClass ).toLowerCase();
		String s1 = new String( enclosing + "." + getName() + PL.toString2() ).toLowerCase();
		String s2 = new String( enclosing + "." + getName() ).toLowerCase();
		String s3 = new String( enclosing + " " + getName() ).toLowerCase();
		
		String[] array = { s1, s2, s3 };
		return array;
	}
	
	protected ParameterList PL = new ParameterList();
	private ReturnType returnType = null;
	private String returns = null;
	private String enclosingClass = null;
	void addParam( String type, String name ) {
		PL.addParam( type, name );
	}
	void setReturnType( String access, String type ) {
		returnType = new ReturnType( access, type );
	}
	void setReturns( String r ) {
		returns = r;
	}
	void setEnclosingClass( String S ) {
		enclosingClass = S;
	}
	String getReturnType() { return returnType.toString(); }
	String getReturns() { return returns; }
	String getEnclosing() { return enclosingClass; }
	String getParameters() { return PL.toString(); }
	public String toString() {
		return returnType + " " + getName() + PL.toString();
	}
	public String getType() { return "Method"; }
}

abstract class Constructor extends Method {
	Constructor() {
		setReturnType( "Public",  null );
	}
	
	public String toString() {
		return getName() + getParameters();
	}
	
	String[] getComparableNames() {
		String s1 = getName() + PL.toString2();
		String s2 = getName() + " constructor";
		String s3 = "constructor " + getName();
		
		String[] array = { s1, s2, s3 };
		return array;
	}
}

/*************************************************************
**********************OBJECT METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class ObjectConstructor extends Constructor {
	ObjectConstructor() { 
		setName( "Object" );
		setEnclosingClass( "Object" );
	}
}

class Object1 extends ObjectConstructor {
	Object1() {
		setDesc( "Constructs a new Object" );
	}
}

/**************************METHODS**************************/

abstract class objectMethod extends Method {
	objectMethod() {
		setEnclosingClass( "Object" );
	}
}

class objectClone extends objectMethod {
	objectClone() {
		setName( "clone" );
		setDesc( "Creates and returns a copy of this object." );
		setReturnType( "Protected", "Object" );
		setReturns( "a clone of this instance." );
	}
}

class objectEquals extends objectMethod {
	objectEquals() {
		setName( "equals" );
		setDesc( "Indicates whether some other object is 'equal to' this one." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "obj"  );
		setReturns( "true if this object is the same as the obj argument; false otherwise" );
	}
}

class objectFinalize extends objectMethod {
	objectFinalize() {
		setName( "finalize" );
		setDesc( "Called by the garbage collector on an object when garbage collection determines that there are no more references to the object." );
		setReturnType( "Protected", "void" );
	}
}

class objectGetClass extends objectMethod {
	objectGetClass() {
		setName( "getClass" );
		setDesc( "Returns the runtime class of this object." );
		setReturnType( "Public final", "Class<?>" );
		setReturns( "The Class object that represents the runtime class of this object." );
	}
}

class objectHashCode extends objectMethod {
	objectHashCode() {
		setName( "hashCode" );
		setDesc( "Returns the hash code value for the object." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class objectNotify extends objectMethod {
	objectNotify() {
		setName( "notify" );
		setDesc( "Wakes up a single thread that is waiting on this object's monitor." );
		setReturnType( "Public final", "void" );
	}
}

class objectNotifyAll extends objectMethod {
	objectNotifyAll() {
		setName( "notifyAll" );
		setDesc( "Wakes up all threads that are waiting on this object's monitor." );
		setReturnType( "Public final", "void" );
	}
}

class objectToString extends objectMethod {
	objectToString() {
		setName( "toString" );
		setDesc( "Returns a string representation of the object. In general, the toString method returns a string that 'textually represents' this object." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of the object." );
	}
}

class objectWait extends objectMethod {
	objectWait() {
		setName( "wait" );
		setDesc( "Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object. In other words, this method behaves exactly as if it simply performs the call wait(0)." );
		setReturnType( "Public final", "void" );
	}
}

class objectWait2 extends objectMethod {
	objectWait2() {
		setName( "wait" );
		setDesc( "Causes the current thread to wait until either another thread invokes the notify() method or the notifyAll() method for this object, or a specified amount of time has elapsed." );
		setReturnType( "Public final", "void" );
		addParam( "long", "timeout" );
	}
}

class objectWait3 extends objectMethod {
	objectWait3() {
		setName( "wait" );
		setDesc( "Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object, or some other thread interrupts the current thread, or a certain amount of real time has elapsed." );
		setReturnType( "Public final", "void" );
		addParam( "long", "timeout" );
		addParam( "int", "nanos" );
	}
}


/*************************************************************
*******************ABSTRACTCOLLECTION METHODS*************************
**************************************************************/

abstract class clMethod extends Method {
	clMethod() {
		setEnclosingClass("AbstractCollection");
	}
}

class clAdd extends clMethod {
	clAdd() {
		setName( "add" );
		setDesc( "Ensures that this collection contains the specified element (optional operation)." );
		addParam("E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class clAddAll extends clMethod {
	clAddAll() {
		setName( "addAll" );
		setDesc( "Adds all of the elements in the specified collection to this collection (optional operation)." );
		addParam("Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class clClear extends clMethod {
	clClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this collection(optional operation)." );
		setReturnType( "Public", "void" );
	}
}

class clContains extends clMethod {
	clContains() {
		setName( "contains" );
		setDesc( "Returns true if this collection contains the specified element." );
		addParam("Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection contains the specified element." );
	}
}

class clContainsAll extends clMethod {
	clContainsAll() {
		setName( "containsAll" );
		setDesc( "Returns true if this collection contains all of the elements in the specified collection." );
		addParam("Collection<?>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection contains all of the elements in the specified collection." );
	}
}

class clIsEmpty extends clMethod {
	clIsEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns 'true' if this collection contains no elements." );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection contains no elements." );
	}
}

class clIterator extends clMethod {
	clIterator() {
		setName( "iterator" );
		setDesc( "Returns an iterator over the elements in this collection." );
		setReturnType( "Abstract", "Iterator<E>" );
		setReturns( "an Iterator over the elements in this collection." );
	}
}

class clRemove extends clMethod {
	clRemove() {
		setName( "remove" );
		setDesc( "Removes a single instance of the specified element from this collection, if it is present (optional operation)." );
		addParam("Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if an element was removed as a result of this call." );
	}
}

class clRemoveAll extends clMethod {
	clRemoveAll() {
		setName( "removeAll" );
		setDesc( "Removes all of this collection's elements that are also contained in the specified collection (optional operation)." );
		addParam("Collection<?>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the collection changes as a result of the call." );
	}
}

class clRetainAll extends clMethod {
	clRetainAll() {
		setName( "retainAll" );
		setDesc( "Retains only the elements in this collection that are contained in the specified collection (optional operation)." );
		addParam("Collection<?>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class clSize extends clMethod {
	clSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this collection. If the size is larger than 'Integer.MAX_VALUE', then 'Integer.MAX_VALUE' is returned." );
		setReturnType( "Abstract", "int" );
		setReturns( "the number of elements in this collection." );
	}
}

class clToArray extends clMethod {
	clToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this collection." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array containing all of the elements in this collection." );
	}
}

class clToArray2 extends clMethod {
	clToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this collection. If the collection fits in the array that is passed as an argument, then that same array will be returned. Otherwise, a new array is allocated and returned storing all of the elements in the collection." );
		addParam("T[]", "a");
		setReturnType( "Public", "T[]" );
		setReturns( "an array containing all of the elements in this collection." );
	}
}

class clToString extends clMethod {
	clToString() {
		setName( "toString" );
		setDesc( "Returns a string representation of this collection." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of this collection." );
	}
}


/*************************************************************
*******************ABSTRACTLIST METHODS***********************
**************************************************************/


abstract class ablMethod extends Method {
	ablMethod() {
		setEnclosingClass("AbstractList");
	}
}

class ablAdd extends ablMethod {
	ablAdd() {
		setName( "add" );
		setDesc( "Appends the specified element to the end of this list (optional operation)." );
		addParam("E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class ablAdd2 extends ablMethod {
	ablAdd2() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this list (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices)." );
		addParam("int", "index");
		addParam("E", "e");
		setReturnType( "Public", "void" );
	}
}

class ablAddAll extends ablMethod {
	ablAddAll() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified collection into this list at the specified position (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices)." );
		addParam("int", "index");
		addParam("Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class ablClear extends ablMethod {
	ablClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this list (optional operation). The list will be empty after this call returns." );
		setReturnType( "Public", "void" );
	}
}

class ablEquals extends ablMethod {
	ablEquals() {
		setName( "equals" );
		setDesc( "Compares the specified object with this list for equality. Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal." );
		addParam("Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the specified object is equal to this list." );
	}
}

class ablGet extends ablMethod {
	ablGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this list." );
		addParam("int", "index");
		setReturnType( "Public Abstract", "E" );
		setReturns( "the element at the specified position in this list" );
	}
}


class ablHashcode extends ablMethod {
	ablHashcode() {
		setName( "hashcode" );
		setDesc( "Returns the hash code value for this list." );
		setReturnType( "Public", "int" );
		setReturns( "the hash code value for this list" );
	}
}

class ablIndexOf extends ablMethod {
	ablIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element." );
		addParam("Object", "o");
		setReturnType( "Public", "int" );
		setReturns( "the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element." );
	}
}

class ablIterator extends ablMethod {
	ablIterator() {
		setName( "iterator" );
		setDesc( "Returns an iterator over the elements in this list in proper sequence." );
		setReturnType( "Public", "Iterator<E>" );
		setReturns( "an iterator over the elements in this list in proper sequence." );
	}
}

class ablLastIndexOf extends ablMethod {
	ablLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element." );
		addParam("Object", "o");
		setReturnType( "Public", "int" );
		setReturns( "the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element." );
	}
}

class ablListIterator extends ablMethod {
	ablListIterator() {
		setName( "listIterator" );
		setDesc( "Returns a list iterator over the elements in this list (in proper sequence)." );
		setReturnType( "Public", "ListIterator<E>" );
		setReturns( "a list iterator over the elements in this list (in proper sequence)." );
	}
}

class ablListIterator2 extends ablMethod {
	ablListIterator2() {
		setName( "listIterator" );
		setDesc( "Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list. The specified index indicates the first element that would be returned by an initial call to next. An initial call to previous would return the element with the specified index minus one." );
		addParam( "int", "index" );
		setReturnType( "Public", "ListIterator<E>" );
		setReturns( "a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list." );
	}
}

class ablRemove extends ablMethod {
	ablRemove() {
		setName( "remove" );
		setDesc( "Removes the element at the specified position in this list (optional operation). Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list." );
		addParam("int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class ablRemoveRange extends ablMethod {
	ablRemoveRange() {
		setName( "removeRange" );
		setDesc( "Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive. Shifts any succeeding elements to the left (reduces their index)." );
		addParam("int", "fromIndex");
		addParam("int", "toIndex");
		setReturnType( "Protected", "void" );
	}
}

class ablSet extends ablMethod {
	ablSet() {
		setName( "set" );
		setDesc( "Replaces the element at the specified position in this list with the specified element (optional operation)." );
		addParam("int", "index");
		addParam("E", "element");
		setReturnType( "Public", "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class ablSublist extends ablMethod {
	ablSublist() {
		setName( "subList" );
		setDesc( "Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.)" );
		addParam("int", "fromIndex");
		addParam("int", "toIndex");
		setReturnType( "Public", "List<E>" );
		setReturns( "a view of the specified range within this list." );
	}
}

/*************************************************************
**************ABSTRACTSEQUENTIALLIST METHODS******************
**************************************************************/

abstract class asqlMethod extends Method {
	asqlMethod() {
		setEnclosingClass( "AbstractSequentialList" );
	}
}

class asqlAdd extends asqlMethod {
	asqlAdd() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this list (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices)." );
		addParam("int", "index");
		addParam("E", "element");
		setReturnType( "Public", "void" );
	}
}

class asqlAddAll extends asqlMethod {
	asqlAddAll() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified collection into this list at the specified position (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). The new elements will appear in this list in the order that they are returned by the specified collection's iterator." );
		addParam("int", "index");
		addParam("Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this list changed as a result of the call" );
	}
}

class asqlGet extends asqlMethod {
	asqlGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this list." );
		addParam("int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the element at the specified position in this list" );
	}
}

class asqlIterator extends asqlMethod {
	asqlIterator() {
		setName( "iterator" );
		setDesc( "Returns an iterator over the elements in this list (in proper sequence)." );
		setReturnType( "Public", "Iterator<E>" );
		setReturns( "an iterator over the elements in this list in proper sequence." );
	}
}

class asqlListIterator extends asqlMethod {
	asqlListIterator() {
		setName( "listIterator" );
		setDesc( "Returns a list iterator over the elements in this list (in proper sequence)." );
		addParam( "int", "index" );
		setReturnType( "Public Abstract", "ListIterator<E>" );
		setReturns( "a list iterator over the elements in this list (in proper sequence)." );
	}
}


/*************************************************************
***********************VECTOR METHODS*************************
**************************************************************/

/***********************CONSTRUCTORS**************************/

abstract class vecConstructor extends Constructor {
	vecConstructor() {
		setName( "Vector" );
		setEnclosingClass( "Vector" );
	}
}

class Vector1 extends vecConstructor {
	Vector1() {
		setDesc( "Constructs an empty vector so that its internal data array has size 10 and its standard capacity increment is zero." );
	}
}

class Vector2 extends vecConstructor {
	Vector2() {
		setDesc( "Constructs a vector containing the elements of the specified collection." );
		addParam( "Collection<? extends E>", "c" );
	}
}

class Vector3 extends vecConstructor {
	Vector3() {
		setDesc( "Constructs an empty vector with the specified initial capacity and with its capacity increment equal to zero." );
		addParam( "int", "initialCapacity" );
	}
}

class Vector4 extends vecConstructor {
	Vector4() {
		setDesc( "Constructs an empty vector with the specified initial capacity and capacity increment." );
		addParam( "int", "initialCapacity" );
		addParam( "int", "capacityIncrement" );
	}
}

/*****************************METHODS******************************/

abstract class vecMethod extends Method {
	vecMethod() {
		setEnclosingClass("Vector");
	}
}

class vecAdd extends vecMethod {
	vecAdd() {
		setName( "add" );
		setDesc( "Appends the specified element to the end of this Vector." );
		addParam("E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this Vector changes as a result of the call." );
	}
}

class vecAdd2 extends vecMethod {
	vecAdd2() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this Vector. Shifts all subsequent elements to the right." );
		addParam("int", "index");
		addParam("E", "element");
		setReturnType( "Public", "void" );
	}
}

class vecAddAll extends vecMethod {
	vecAddAll() {
		setName( "addAll" );
		setDesc( "Appends all of the elements in the specified collection to the end of this Vector." );
		addParam("Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class vecAddAll2 extends vecMethod {
	vecAddAll2() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified Collection into this Vector at the specified position. Shifts all subsequent elements to the right." );
		addParam("int", "index");
		addParam("Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class vecAddElement extends vecMethod {
	vecAddElement() {
		setName( "addElement" );
		setDesc( "Adds the specified component to the end of this vector." );
		addParam("E", "obj");
		setReturnType( "Public", "void" );
	}
}

class vecCapacity extends vecMethod {
	vecCapacity() {
		setName( "capacity" );
		setDesc( "Returns the current capacity of this vector." );
		setReturnType( "Public", "int" );
		setReturns( "the current capacity" );
	}
}

class vecClear extends vecMethod {
	vecClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this Vector." );
		setReturnType( "Public", "void" );
	}
}

class vecClone extends vecMethod {
	vecClone() {
		setName( "clone" );
		setDesc( "Returns a clone of this vector. Copy will refer to a new internal data array, not the original." );
		setReturnType( "Public", "Object" );
		setReturns( "a clone of this vector." );
	}
}


class vecContains extends vecMethod {
	vecContains() {
		setName( "contains" );
		setDesc( "Returns true if this Vector contains the specified element." );
		addParam("Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this Vector contains the specified element." );
	}
}

class veccontainsAll extends vecMethod {
	veccontainsAll() {
		setName( "containsAll" );
		setDesc( "Returns true if this Vector contains all of the elements in the specified collection." );
		addParam("Collection<?>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this Vector contains all of the elements in the specified collection." );
	}
}

class vecCopyInto extends vecMethod {
	vecCopyInto() {
		setName( "copyInto" );
		setDesc( "Copies the components of this vector into the specified array." );
		addParam("Object[]", "anArray");
		setReturnType( "Public", "void" );
	}
}

class vecElementAt extends vecMethod {
	vecElementAt() {
		setName( "elementAt" );
		setDesc( "Returns the component at the specified index." );
		addParam("int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the component at the specified index." );
	}
}

class vecElements extends vecMethod {
	vecElements() {
		setName( "elements" );
		setDesc( "Returns an enumeration of the components of this vector." );
		setReturnType( "Public", "Enumeration<E>" );
		setReturns( "an enumeration of the components of this vector." );
	}
}

class vecEnsureCapacity extends vecMethod {
	vecEnsureCapacity() {
		setName( "ensureCapacity" );
		setDesc( "Increases the capacity of this vector, if necessary, to ensure that it can hold at least the number of components specified by the minimum capacity argument." );
		addParam("int", "minCapacity");
		setReturnType( "Public", "void" );
	}
}

class vecequals extends vecMethod {
	vecequals() {
		setName( "equals" );
		setDesc( "Compares the specified object with this Vector for equality." );
		addParam("Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if specified object is equal to this Vector." );
	}
}

class vecFirstElement extends vecMethod {
	vecFirstElement() {
		setName( "firstElement" );
		setDesc( "Returns the first component (the item at index 0) of this vector." );
		setReturnType( "Public", "E" );
		setReturns( "the first component of this vector." );
	}
}

class vecGet extends vecMethod {
	vecGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this Vector." );
		addParam("int", "index");
		setReturnType( "Public", "E" );
		setReturns( "object at the specified index." );
	}
}

class vechashCode extends vecMethod {
	vechashCode() {
		setName( "hashCode" );
		setDesc( "Returns the hash code value for this Vector." );
		setReturnType( "Public", "int" );
		setReturns( "the hash code value for this Vector." );
	}
}

class vecIndexOf extends vecMethod {
	vecIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
		addParam("Object", "o");
		setReturnType( "Public", "int" );
		setReturns( "the index of the first occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
	}
}

class vecIndexOf2 extends vecMethod {
	vecIndexOf2() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this vector, searching forward from index, or returns -1 if this vector does not contain the element." );
		addParam("Object", "o");
		addParam( "int", "index");
		setReturnType( "Public", "int" );
		setReturns( "the index of the first occurrence of the specified element in this vector at position 'index' or later, or -1 if this vector does not contain the element." );
	}
}

class vecInsertElementAt extends vecMethod {
	vecInsertElementAt() {
		setName( "insertElementAt" );
		setDesc( "Inserts the specified object as a component in this vector at the specified index." );
		addParam("E", "obj");
		addParam("int", "index");
		setReturnType( "Public", "void" );
	}
}

class vecisEmpty extends vecMethod {
	vecisEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns 'true' if this Vector contains no elements." );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this Vector contains no elements." );
	}
}

class vecLastElement extends vecMethod {
	vecLastElement() {
		setName( "lastElement" );
		setDesc( "Returns the last component of the vector." );
		setReturnType( "Public", "E" );
		setReturns( "the last component of this vector." );
	}
}

class vecLastIndexOf extends vecMethod {
	vecLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index of the last occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
		addParam( "Object", "o" );
		setReturnType( "Public", "int" );
		setReturns( "the index of the last occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
	}
}

class vecLastIndexOf2 extends vecMethod {
	vecLastIndexOf2() {
		setName( "lastIndexOf2" );
		setDesc( "Returns the index of the last occurrence of the specified element in this vector, searching backwards from 'index', or returns -1 if the element is not found." );
		addParam( "Object", "o" );
		addParam( "int", "index" );
		setReturnType( "Public", "int" );
		setReturns( "the index of the last occurrence of the specified element as position 'index' or less, or -1 if this vector does not contain the element." );
	}
}

class vecRemove extends vecMethod {
	vecRemove() {
		setName( "remove" );
		setDesc( "Removes the first occurrence of the specified element in this Vector, if it is present." );
		addParam("Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the vector contains the specified element." );
	}
}

class vecRemove2 extends vecMethod {
	vecRemove2() {
		setName( "remove" );
		setDesc( "Removes the element at the specified position in this Vector." );
		addParam("int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the element that was removed." );
	}
}

class vecRemoveAll extends vecMethod {
	vecRemoveAll() {
		setName( "removeAll" );
		setDesc( "Removes from this Vector all of the elements that are also contained in the specified collection." );
		addParam("Collection<?>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the Vector changes as a result of the call." );
	}
}

class vecRemoveAllElements extends vecMethod {
	vecRemoveAllElements() {
		setName( "removeAllElements" );
		setDesc( "Removes all components from this vector and sets its size to zero." );
		setReturnType( "Public", "void" );
	}
}

class vecRemoveElement extends vecMethod {
	vecRemoveElement() {
		setName( "removeElement" );
		setDesc( "Removes the first occurrence of the argument from this vector." );
		addParam( "Object", "obj" );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the argument was in this vector. 'false' otherwise." );
	}
}

class vecRemoveElementAt extends vecMethod {
	vecRemoveElementAt() {
		setName( "removeElementAt" );
		setDesc( "Deletes the component at the specified index." );
		addParam( "int", "index" );
		setReturnType( "Public", "void" );
	}
}

class vecRemoveRange extends vecMethod {
	vecRemoveRange() {
		setName( "removeRange" );
		setDesc( "Removes all of the elements whose index is between 'fromIndex' (inclusive) and 'toIndex' (exclusive)." );
		addParam( "int", "fromIndex" );
		addParam( "int", "toIndex" );
		setReturnType( "Protected", "void" );
	}
}

class vecRetainAll extends vecMethod {
	vecRetainAll() {
		setName( "retainAll" );
		setDesc( "Retains only the elements in this Vectorn that are contained in the specified collection (optional operation)." );
		addParam( "Collection<?>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this Vector changes as a result of the call." );
	}
}

class vecSet extends vecMethod {
	vecSet() {
		setName( "set" );
		setDesc( "Replaces the element at the specified position in this Vector with the specified element." );
		addParam( "int", "index" );
		addParam( "E", "element" );
		setReturnType( "Public", "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class vecSetElementAt extends vecMethod {
	vecSetElementAt() {
		setName( "setElementAt" );
		setDesc( "Sets the component at the specified index of this vector to be the specified object." );
		addParam( "E", "obj" );
		addParam( "int", "index" );
		setReturnType( "Public", "void" );
	}
}

class vecSetSize extends vecMethod {
	vecSetSize() {
		setName( "setSize" );
		setDesc( "Sets the size of this vector." );
		addParam( "int", "newSize" );
		setReturnType( "Public", "void" );
	}
}

class vecSize extends vecMethod {
	vecSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this Vector." );
		setReturnType( "Public", "int" );
		setReturns( "the number of elements in this Vector." );
	}
}

class vecSubList extends vecMethod {
	vecSubList() {
		setName( "subList" );
		setDesc( "Returns a list of the portion of this Vector between 'fromIndex' (inclusive) and 'toIndex' (exclusive)." );
		addParam( "int", "fromIndex" );
		addParam( "int", "toIndex" );
		setReturnType( "Public", "List<E>" );
		setReturns( "a list of the specified range within this Vector." );
	}
}

class vecToArray extends vecMethod {
	vecToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this Vector." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array containing all of the elements in this Vector." );
	}
}

class vecToArray2 extends vecMethod {
	vecToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this Vector." );
		addParam("T[]", "a");
		setReturnType( "Public", "T[]" );
		setReturns( "an array containing all of the elements in this Vector." );
	}
}

class vecToString extends vecMethod {
	vecToString() {
		setName( "toString" );
		setDesc( "Returns a String representation of this Vector, containing the String representation of each element." );
		setReturnType( "Public", "String" );
		setReturns( "a String representation of this Vector." );
	}
}

class vecTrimToSize extends vecMethod {
	vecTrimToSize() {
		setName( "trimToSize" );
		setDesc( "Trims the capacity of this vector to be the vector's current size." );
		setReturnType( "Public", "void" );
	}
}


/*************************************************************
**********************LIST METHODS****************************
**************************************************************/

/*********************CONSTRUCTORS****************************/

abstract class listConstructor extends Constructor {
	listConstructor() {
		setName( "List" );
		setEnclosingClass( "List" );
	}
}

class List1 extends listConstructor {
	List1() {	
		setDesc( "Creates a new scrolling list. By default, there are four visible lines and multiple selections are not allowed." );
	}
}

class List2 extends listConstructor {
	List2() {
		setDesc( "Creates a new scrolling list initialized with the specified number of visible lines. By default, multiple selections are not allowed." );
		addParam( "int", "rows" );
	}	
}

class List3 extends listConstructor {
	List3() {
		setDesc( "Creates a new scrolling list initialized to display the specified number of rows. Note that if zero rows are specified, then the list will be created with a default of four rows. Also note that the number of visible rows in the list cannot be changed after it has been created. If the value of multipleMode is true, then the user can select multiple items from the list. If it is false, only one item at a time can be selected." );
		addParam( "int", "rows" );
		addParam( "boolean", "multipleMode");
	}
}

/**************************METHODS**************************/

abstract class listMethod extends Method {
	listMethod() {
		setEnclosingClass("List");
	}
}

class listAdd extends listMethod {
	listAdd() {
		setName( "add" );
		setDesc( "Adds the specified item to the end of scrolling list." );
		addParam( "String", "item");
		setReturnType( "Public", "void" );
	}
}

class listAdd2 extends listMethod {
	listAdd2() {
		setName( "add" );
		setDesc( "Adds the specified item to the the scrolling list at the position indicated by the index. The index is zero-based. If the value of the index is less than zero, or if the value of the index is greater than or equal to the number of items in the list, then the item is added to the end of the list." );
		addParam( "String", "item");
		addParam( "int", "index" );
		setReturnType( "Public", "void" );
	}
}

class listAddActionListener extends listMethod {
	listAddActionListener() {
		setName( "addActionListener" );
		setDesc( "Adds the specified action listener to receive action events from this list." );
		addParam( "ActionListener", "l");
		setReturnType( "Public", "void" );
	}
}

class listAddItemListener extends listMethod {
	listAddItemListener() {
		setName( "addItemListener" );
		setDesc( "Adds the specified item listener to receive item events from this list." );
		addParam( "ItemListener", "l");
		setReturnType( "Public", "void" );
	}
}

class listAddNotify extends listMethod {
	listAddNotify() {
		setName( "addNotify" );
		setDesc( "Creates the peer for the list. The peer allows us to modify the list's appearance without changing its functionality." );
		setReturnType( "Public", "void" );
	}
}

class listDeselect extends listMethod {
	listDeselect() {
		setName( "deselect" );
		setDesc( "Deselects the item at the specified index." );
		addParam( "int", "index");
		setReturnType( "Public", "void" );
	}
}

class listGetAccessibleContext extends listMethod {
	listGetAccessibleContext() {
		setName( "getAccessibleContext" );
		setDesc( "Gets the AccessibleContext associated with this List. For lists, the AccessibleContext takes the form of an AccessibleAWTList. A new AccessibleAWTList instance is created, if necessary." );
		setReturnType( "Public", "AccesibleContext" );
		setReturns( "an AccessibleAWTList that serves as the AccessibleContext of this List." );
	}
}

class listGetActionListeners extends listMethod {
	listGetActionListeners() {
		setName( "getActionListeners" );
		setDesc( "Returns an array of all the action listeners registered on this list." );
		setReturnType( "Public", "ActionListener[]" );
		setReturns( "all of this list's ActionListeners or an empty array if no action listeners are currently registered." );
	}
}

class listGetItem extends listMethod {
	listGetItem() {
		setName( "getItem" );
		setDesc( "Gets the item associated with the specified index." );
		addParam( "int", "index" );
		setReturnType( "Public", "String" );
		setReturns( "an item that is associated with the specified index." );
	}
}

class listGetItems extends listMethod {
	listGetItems() {
		setName( "getItems" );
		setDesc( "Gets the items in the list." );
		setReturnType( "Public", "String[]" );
		setReturns( "a string array containing items of the list." );
	}
}

class listGetItemCount extends listMethod {
	listGetItemCount() {
		setName( "getItemCount" );
		setDesc( "Gets the number of items in the list." );
		setReturnType( "Public", "int" );
		setReturns( "the number of items in the list." );
	}
}

class listGetItemListeners extends listMethod {
	listGetItemListeners() {
		setName( "getItemListeners" );
		setDesc( "Returns an array of all the item listeners registered on this list." );
		setReturnType( "Public", "ItemListener[]" );
		setReturns( "all of this list's ItemListeners or an empty array if no item listeners are currently registered." );
	}
}

class listGetListeners extends listMethod {
	listGetListeners() {
		setName( "getListeners" );
		setDesc( "Returns an array of all the objects currently registered as FooListeners upon this List. FooListeners are registered using the addFooListener method. You can specify the listenerType argument with a class literal, such as FooListener.class." );
		addParam( "Class<T>", "listenerType" );
		setReturnType( "Public", "<T extends EventListener> T[]" );
		setReturns( "an array of all objects registered as FooListeners on this list, or an empty array if no such listeners have been added." );
	}
}

class listGetMinimumSize extends listMethod {
	listGetMinimumSize() {
		setName( "getMinimumSize" );
		setDesc( "Determines the minimum size of this scrolling list." );
		setReturnType( "Public", "Dimension" );
		setReturns( "the minimum dimensions needed to display this scrolling list." );
	}
}

class listGetMinimumSize2 extends listMethod {
	listGetMinimumSize2() {
		setName( "getMinimumSize" );
		setDesc( "Gets the minumum dimensions for a list with the specified number of rows." );
		addParam( "int", "rows" );
		setReturnType( "Public", "Dimension" );
		setReturns( "the minimum dimensions for displaying this scrolling list given that the specified number of rows must be visible." );
	}
}

class listGetPreferredSize extends listMethod {
	listGetPreferredSize() {
		setName( "getMinimumSize" );
		setDesc( "Gets the preferred size of this scrolling list." );
		setReturnType( "Public", "Dimension" );
		setReturns( "the preferred dimensions for displaying this scrolling list." );
	}
}

class listGetPreferredSize2 extends listMethod {
	listGetPreferredSize2() {
		setName( "getPreferredSize" );
		setDesc( "Gets the preferred dimensions for a list with the specified number of rows." );
		addParam( "int", "rows" );
		setReturnType( "Public", "Dimension" );
		setReturns( "the preferred dimensions for displaying this scrolling list given that the specified number of rows must be visible." );
	}
}

class listGetRows extends listMethod {
	listGetRows() {
		setName( "getRows" );
		setDesc( "Gets the number of visible lines in this list. Note that once the List has been created, this number will never change." );
		setReturnType( "Public", "int" );
		setReturns( "the number of visible lines in this scrolling list." );
	}
}

class listGetSelectedIndex extends listMethod {
	listGetSelectedIndex() {
		setName( "getSelectedIndex" );
		setDesc( "Gets the index of the selected item on the list." );
		setReturnType( "Public", "int" );
		setReturns( "the index of the selected item; if no item is selected, or if multiple items are selected, -1 is returned." );
	}
}

class listGetSelectedIndexes extends listMethod {
	listGetSelectedIndexes() {
		setName( "getSelectedIndexes" );
		setDesc( "Gets the selected indexes on the list." );
		setReturnType( "Public", "int[]" );
		setReturns( "an array of the selected indexes on this scrolling list; if no item is selected, a zero-length array is returned." );
	}
}

class listGetSelectedItem extends listMethod {
	listGetSelectedItem() {
		setName( "getSelectedItem" );
		setDesc( "Gets the selected item on this scrolling list." );
		setReturnType( "Public", "String" );
		setReturns( "the selected item on the list; if no item is selected, or if multiple items are selected, null is returned." );
	}
}

class listGetSelectedItems extends listMethod {
	listGetSelectedItems() {
		setName( "getSelectedItems" );
		setDesc( "Gets the selected items on this scrolling list." );
		setReturnType( "Public", "String[]" );
		setReturns( "an array of the selected items on this scrolling list; if no item is selected, a zero-length array is returned." );
	}
}

class listGetSelectedObjects extends listMethod {
	listGetSelectedObjects() {
		setName( "getSelectedObjects" );
		setDesc( "Gets the selected items on this scrolling list in an array of Objects." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array of Objects representing the selected items on this scrolling list; if no item is selected, a zero-length array is returned." );
	}
}

class listGetVisibleIndex extends listMethod {
	listGetVisibleIndex() {
		setName( "getVisibleIndex" );
		setDesc( "Gets the index of the item that was last made visible by the method makeVisible." );
		setReturnType( "Public", "int" );
		setReturns( "the index of the item that was last made visible." );
	}
}

class listIsIndexSelected extends listMethod {
	listIsIndexSelected() {
		setName( "getIsIndexSelected" );
		setDesc( "Determines if the specified item in this scrolling list is selected." );
		addParam( "int", "index" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the specified item has been selected; false otherwise." );
	}
}

class listIsMultipleMode extends listMethod {
	listIsMultipleMode() {
		setName( "getIsMultipleMode" );
		setDesc( "Determines whether this list allows multiple selections." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if this list allows multiple selections; otherwise, false." );
	}
}

class listMakeVisible extends listMethod {
	listMakeVisible() {
		setName( "makeVisible" );
		setDesc( "Makes the item at the specified index visible." );
		setReturnType( "Public", "void" );
	}
}

class listParamString extends listMethod {
	listParamString() {
		setName( "paramString" );
		setDesc( "Returns the parameter string representing the state of this scrolling list. This string is useful for debugging." );
		setReturnType( "Protected", "String" );
		setReturns( "the parameter string of this scrolling list." );
	}
}

class listProcessActionEvent extends listMethod {
	listProcessActionEvent() {
		setName( "processActionEvent" );
		setDesc( "Processes action events occurring on this component by dispatching them to any registered ActionListener objects." );
		addParam( "ActionEvent", "e" );
		setReturnType( "Protected", "void" );
	}
}

class listProcessEvent extends listMethod {
	listProcessEvent() {
		setName( "processEvent" );
		setDesc( "Processes events on this scrolling list. If an event is an instance of ItemEvent, it invokes the processItemEvent method. Else, if the event is an instance of ActionEvent, it invokes processActionEvent. If the event is not an item event or an action event, it invokes processEvent on the superclass." );
		addParam( "AWTEvent", "e" );
		setReturnType( "Protected", "void" );
	}
}

class listProcessItemEvent extends listMethod {
	listProcessItemEvent() {
		setName( "processItemEvent" );
		setDesc( "Processes item events occurring on this list by dispatching them to any registered ItemListener objects." );
		addParam( "ItemEvent", "e" );
		setReturnType( "Protected", "void" );
	}
}

class listRemove extends listMethod {
	listRemove() {
		setName( "remove" );
		setDesc( "Removes the item at the specified position from this scrolling list. If the item with the specified position is selected, and is the only selected item in the list, the list is set to have no selection." );
		addParam( "int", "position" );
		setReturnType( "Public", "void" );
	}
}

class listRemove2 extends listMethod {
	listRemove2() {
		setName( "remove" );
		setDesc( "Removes the first occurrence of an item from the list. If the specified item is selected, and is the only selected item in the list, the list is set to have no selection." );
		addParam( "String", "item" );
		setReturnType( "Public", "void" );
	}
}

class listRemoveActionListener extends listMethod {
	listRemoveActionListener() {
		setName( "removeActionListener" );
		setDesc( "Removes the specified Action listener so that it no longer receives Action events from this list." );
		addParam( "ActionListener", "l");
		setReturnType( "Public", "void" );
	}
}

class listRemoveItemListener extends listMethod {
	listRemoveItemListener() {
		setName( "removeItemListener" );
		setDesc( "Removes the specified item listener so that it no longer receives item events from this list." );
		addParam( "ItemListener", "l");
		setReturnType( "Public", "void" );
	}
}

class listRemoveAll extends listMethod {
	listRemoveAll() {
		setName( "removeAll" );
		setDesc( "Removes all items from this list." );
		setReturnType( "Public", "void" );
	}
}

class listRemoveNotify extends listMethod {
	listRemoveNotify() {
		setName( "removeNotify" );
		setDesc( "Removes the peer for this list. The peer allows us to modify the list's appearance without changing its functionality." );
		setReturnType( "Public", "void" );
	}
}

class listReplaceItem extends listMethod {
	listReplaceItem() {
		setName( "replaceItem" );
		setDesc( "Replaces the item at the specified index in the scrolling list with the new string." );
		addParam( "String", "newValue" );
		addParam( "int", "index" );
		setReturnType( "Public", "void" );
	}
}

class listSelect extends listMethod {
	listSelect() {
		setName( "select" );
		setDesc( "Selects the item at the specified index in the scrolling list." );
		addParam( "int", "index" );
		setReturnType( "Public", "void" );
	}
}

class listSetMultipleMode extends listMethod {
	listSetMultipleMode() {
		setName( "setMultipleMode" );
		setDesc( "Sets the flag that determines whether this list allows multiple selections. When the selection mode is changed from multiple-selection to single-selection, the selected items change as follows: If a selected item has the location cursor, only that item will remain selected. If no selected item has the location cursor, all items will be deselected." );
		addParam( "boolean", "flag" );
		setReturnType( "Public", "void" );
	}
}


/*************************************************************
*******************ARRAYLIST METHODS*************************
**************************************************************/

/***********************CONSTRUCTORS**************************/

abstract class arrConstructor extends Constructor {
	arrConstructor() {
		setName( "ArrayList" );
		setEnclosingClass( "ArrayList" );
	}
}

class ArrayList1 extends arrConstructor {
	ArrayList1() {
		setDesc( "Constructs an empty list with an intitial capacity of ten." );
	}
}

class ArrayList2 extends arrConstructor {
	ArrayList2() {
		setDesc( "Constructs a list containing the elements of the specified collection." );
		addParam( "Collection<? extends E>", "c" );
	}
}

class ArrayList3 extends arrConstructor {
	ArrayList3() {
		setDesc( "Constructs an empty list with the specified initial capacity." );
		addParam( "int", "initialCapacity" );
	}
}

/**************************METHODS**************************/

abstract class arrMethod extends Method {
	arrMethod() {
		setEnclosingClass("ArrayList");
	}
}

class arrAdd extends arrMethod {
	arrAdd() {
		setName( "add" );
		setDesc( "Appends the specified element to the end of this ArrayList." );
		addParam( "E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this ArrayList changes as a result of the call." );
	}
}

class arrAdd2 extends arrMethod {
	arrAdd2() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this ArrayList." );
		addParam( "int", "index");
		addParam( "E", "element");
		setReturnType( "Public", "void" );
	}
}

class arrAddAll extends arrMethod {
	arrAddAll() {
		setName( "addAll" );
		setDesc( "Appends all of the elements in the specified collection to the end of this ArrayList." );
		addParam( "Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this ArrayList changes as a result of the call." );
	}
}

class arrAddAll2 extends arrMethod {
	arrAddAll2() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified Collection into this ArrayList at the specified position." );
		addParam( "int", "index");
		addParam( "Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this ArrayList changes as a result of the call." );
	}
}

class arrClear extends arrMethod {
	arrClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this ArrayList." );
		setReturnType( "Public", "void" );
	}
}

class arrClone extends arrMethod {
	arrClone() {
		setName( "clone" );
		setDesc( "Returns a shallow copy of this ArrayList instance." );
		setReturnType( "Public", "Object" );
		setReturns( "a clone of this ArrayList." );
	}
}


class arrContains extends arrMethod {
	arrContains() {
		setName( "contains" );
		setDesc( "Returns true if this ArrayList contains the specified element." );
		addParam( "Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this ArrayList contains the specified element." );
	}
}

class arrEnsureCapacity extends arrMethod {
	arrEnsureCapacity() {
		setName( "ensureCapacity" );
		setDesc( "Increases the capacity of this ArrayList, if necessary, to ensure that it can hold at least the number of components specified by the minimum capacity argument." );
		addParam( "int", "minCapacity");
		setReturnType( "Public", "void" );
	}
}

class arrGet extends arrMethod {
	arrGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this ArrayList." );
		addParam( "int", "index");
		setReturnType( "Public", "E" );
		setReturns( "object at the specified index." );
	}
}

class arrIndexOf extends arrMethod {
	arrIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
		addParam("Object", "o");
		setReturnType( "Public", "int" );
		setReturns( "the index of the first occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
	}
}

class arrIsEmpty extends arrMethod {
	arrIsEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns 'true' if this ArrayList contains no elements." );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this ArrayList contains no elements." );
	}
}

class arrLastIndexOf extends arrMethod {
	arrLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index of the last occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
		addParam( "Object", "o" );
		setReturnType( "Public", "int" );
		setReturns( "the index of the last occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
	}
}

class arrRemove extends arrMethod {
	arrRemove() {
		setName( "remove" );
		setDesc( "Removes the first occurrence of the specified element in this ArrayList, if it is present." );
		addParam( "Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the ArrayList contains the specified element." );
	}
}

class arrRemove2 extends arrMethod {
	arrRemove2() {
		setName( "remove" );
		setDesc( "Removes the element at the specified position in this ArrayList." );
		addParam( "int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the element that was removed." );
	}
}

class arrRemoveRange extends arrMethod {
	arrRemoveRange() {
		setName( "removeRange" );
		setDesc( "Removes all of the elements whose index is between 'fromIndex' (inclusive) and 'toIndex' (exclusive)." );
		addParam( "int", "fromIndex" );
		addParam( "int", "toIndex" );
		setReturnType( "Protected", "void" );
	}
}

class arrSet extends arrMethod {
	arrSet() {
		setName( "set" );
		setDesc( "Replaces the element at the specified position in this ArrayList with the specified element." );
		addParam( "int", "index" );
		addParam( "E", "element" );
		setReturnType( "Public", "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class arrSize extends arrMethod {
	arrSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this ArrayList." );
		setReturnType( "Public", "int" );
		setReturns( "the number of elements in this ArrayList." );
	}
}

class arrToArray extends arrMethod {
	arrToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this ArrayList." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array containing all of the elements in this ArrayList." );
	}
}

class arrToArray2 extends arrMethod {
	arrToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in the ArrayList." );
		addParam("T[]", "a");
		setReturnType( "Public", "T[]" );
		setReturns( "an array containing all of the elements in the ArrayList." );
	}
}

class arrTrimToSize extends arrMethod {
	arrTrimToSize() {
		setName( "trimToSize" );
		setDesc( "Trims the capacity of this ArrayList to be the ArrayList's current size." );
		setReturnType( "Public", "void" );
	}
}


/*************************************************************
*******************LINKEDLIST METHODS*************************
**************************************************************/

/***********************CONSTRUCTORS**************************/

abstract class llistConstructor extends Constructor {
	llistConstructor() {
		setName( "LinkedList" );
		setEnclosingClass( "LinkedList" );
	}
}

class LinkedList1 extends llistConstructor {
	LinkedList1() {
		setDesc( "Constructs an empty list." );
	}
}

class LinkedList2 extends llistConstructor {
	LinkedList2() {
		setDesc( "Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator." );
		addParam( "Collection<? extends E>", "c" );
	}
}


/**************************METHODS**************************/

abstract class llistMethod extends Method {
	llistMethod() {
		setEnclosingClass("LinkedList");
	}
}

class llistAdd extends llistMethod {
	llistAdd() {
		setName( "add" );
		setDesc( "Appends the specified element to the end of this LinkedList." );
		addParam( "E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this LinkedList changes as a result of the call." );
	}
}

class llistAdd2 extends llistMethod {
	llistAdd2() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this LinkedList. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices)." );
		addParam( "int", "index");
		addParam( "E", "element");
		setReturnType( "Public", "void" );
	}
}

class llistAddAll extends llistMethod {
	llistAddAll() {
		setName( "addAll" );
		setDesc( "Appends all of the elements in the specified collection to the end of this LinkedList, in the order that they are returned by the specified collection's iterator." );
		addParam( "Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this LinkedList changes as a result of the call." );
	}
}

class llistAddAll2 extends llistMethod {
	llistAddAll2() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified collection into this LinkedList, starting at the specified position. Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices)." );
		addParam( "int", "index");
		addParam( "Collection<? extends E>", "c");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this LinkedList changes as a result of the call." );
	}
}

class llistAddFirst extends llistMethod {
	llistAddFirst() {
		setName( "addFirst" );
		setDesc( "Inserts the specified element at the beginning of this LinkedList." );
		addParam( "E", "e");
		setReturnType( "Public", "void" );
	}
}

class llistAddLast extends llistMethod {
	llistAddLast() {
		setName( "addLast" );
		setDesc( "Inserts the specified element at the end of this LinkedList." );
		addParam( "E", "e");
		setReturnType( "Public", "void" );
	}
}


class llistClear extends llistMethod {
	llistClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this LinkedList." );
		setReturnType( "Public", "void" );
	}
}

class llistClone extends llistMethod {
	llistClone() {
		setName( "clone" );
		setDesc( "Returns a shallow copy of this LinkedList." );
		setReturnType( "Public", "Object" );
		setReturns( "a shallow copy of this LinkedList instance." );
	}
}


class llistContains extends llistMethod {
	llistContains() {
		setName( "contains" );
		setDesc( "Returns true if this LinkedList contains the specified element." );
		addParam( "Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this LinkedList contains the specified element." );
	}
}

class llistDescendingIterator extends llistMethod {
	llistDescendingIterator() {
		setName( "descendingIterator" );
		setDesc( "Returns an iterator over the elements in this LinkedList in reverse sequential order. The elements will be returned in order from last (tail) to first (head)." );
		setReturnType( "Public", "Iterator<E>" );
		setReturns( "an iterator over the elements in this LinkedList in reverse sequence." );
	}
}

class llistElement extends llistMethod {
	llistElement() {
		setName( "element" );
		setDesc( "Retrieves, but does not remove, the head (first element) of this list." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this list." );
	}
}

class llistGet extends llistMethod {
	llistGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this LinkedList." );
		addParam( "int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the element at the specified position in this LinkedList." );
	}
}

class llistGetFirst extends llistMethod {
	llistGetFirst() {
		setName( "getFirst" );
		setDesc( "Returns the first element in this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the first element in this LinkedList." );
	}
}

class llistGetLast extends llistMethod {
	llistGetLast() {
		setName( "getLast" );
		setDesc( "Returns the last element in this LinkedList" );
		setReturnType( "Public", "E" );
		setReturns( "the last element in this LinkedList." );
	}
}

class llistIndexOf extends llistMethod {
	llistIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this LinkedList, or -1 if this LinkedList does not contain the element." );
		addParam("Object", "o");
		setReturnType( "Public", "int" );
		setReturns( "the index of the first occurrence of the specified element in this LinkedList, or -1 if this LinkedList does not contain the element." );
	}
}

class llistLastIndexOf extends llistMethod {
	llistLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index of the last occurrence of the specified element in this LinkedList, or -1 if this LinkedList does not contain the element." );
		addParam( "Object", "o" );
		setReturnType( "Public", "int" );
		setReturns( "the index of the last occurrence of the specified element in this LinkedList, or -1 if this LinkedList does not contain the element." );
	}
}

class llistListIterator extends llistMethod {
	llistListIterator() {
		setName( "listIterator" );
		setDesc( "Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list." );
		addParam( "int", "index" );
		setReturnType( "Public", "ListIterator<E>" );
		setReturns( "a ListIterator of the elements in this list (in proper sequence), starting at the specified position in the list." );
	}
}

class llistOffer extends llistMethod {
	llistOffer() {
		setName( "offer" );
		setDesc( "Adds the specified element as the tail (last element) of this Linkedlist." );
		addParam( "E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the element was added to this LinkedList, else fals.e" );
	}
}

class llistOfferFirst extends llistMethod {
	llistOfferFirst() {
		setName( "offerFirst" );
		setDesc( "Inserts the specified element at the front of this LinkedList." );
		addParam( "E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the element was added to this LinkedList, else false." );
	}
}

class llistOfferLast extends llistMethod {
	llistOfferLast() {
		setName( "offerLast" );
		setDesc( "Inserts the specified element at the end of this LinkedList." );
		addParam( "E", "e");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the element was added to this LinkedList, else false." );
	}
}

class llistPeek extends llistMethod {
	llistPeek() {
		setName( "peek" );
		setDesc( "Retrieves, but does not remove, the head (first element) of this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this list, or null if this LinkedList is empty." );
	}
}

class llistPeekFirst extends llistMethod {
	llistPeekFirst() {
		setName( "peekFirst" );
		setDesc( "Retrieves, but does not remove, the first element of this LinkedList, or returns null if this LinkedList is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this LinkedList, or null if this LinkedList is empty." );
	}
}

class llistPeekLast extends llistMethod {
	llistPeekLast() {
		setName( "peekLast" );
		setDesc( "Retrieves, but does not remove, the last element of this LinkedList, or returns null if this LinkedList is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the last element this LinkedList, or null if this LinkedList is empty." );
	}
}

class llistPoll extends llistMethod {
	llistPoll() {
		setName( "poll" );
		setDesc( "Retrieves and removes the head (first element) of this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this list, or null if this LinkedList is empty." );
	}
}

class llistPollFirst extends llistMethod {
	llistPollFirst() {
		setName( "pollFirst" );
		setDesc( "Retrieves and removes the first element of this LinkedList, or returns null if this LinkedList is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this LinkedList, or null if this LinkedList is empty." );
	}
}

class llistPollLast extends llistMethod {
	llistPollLast() {
		setName( "pollLast" );
		setDesc( "Retrieves and removes the last element of this LinkedList, or returns null if this LinkedList is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the last element this LinkedList, or null if this LinkedList is empty." );
	}
}

class llistPop extends llistMethod {
	llistPop() {
		setName( "pop" );
		setDesc( "Pops an element from the stack represented by this LinkedList. In other words, removes and returns the first element of this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the element at the front of this LinkedList (which is the top of the stack represented by this LinkedList)" );
	}
}

class llistPush extends llistMethod {
	llistPush() {
		setName( "push" );
		setDesc( "Pushes an element onto the stack represented by this LinkedList. In other words, inserts the element at the front of this LinkedList." );
		setReturnType( "Public", "void" );
	}
}

class llistRemove extends llistMethod {
	llistRemove() {
		setName( "remove" );
		setDesc( "Retrieves and removes the head (first element) of this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the head (first element) of this LinkedList." );
	}
}

class llistRemove2 extends llistMethod {
	llistRemove2() {
		setName( "remove" );
		setDesc( "Removes the first occurrence of the specified element in this LinkedList, if it is present." );
		addParam( "Object", "o");
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the LinkedList contains the specified element." );
	}
}

class llistRemove3 extends llistMethod {
	llistRemove3() {
		setName( "remove" );
		setDesc( "Removes the element at the specified position in this LinkedList." );
		addParam( "int", "index");
		setReturnType( "Public", "E" );
		setReturns( "the element that was removed." );
	}
}

class llistRemoveFirst extends llistMethod {
	llistRemoveFirst() {
		setName( "removeFirst" );
		setDesc( "Removes and returns the first element from this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the first element from this LinkedList." );
	}
}

class llistRemoveFirstOccurrence extends llistMethod {
	llistRemoveFirstOccurrence() {
		setName( "removeFirstOccurrence" );
		setDesc( "Removes the first occurrence of the specified element in this LinkedList (when traversing the LinkedList from head to tail). If the LinkedList does not contain the element, it is unchanged." );
		addParam( "Object", "o" );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the LinkedList contained the specified element." );
	}
}

class llistRemoveLast extends llistMethod {
	llistRemoveLast() {
		setName( "removeLast" );
		setDesc( "Removes and returns the last element from this LinkedList." );
		setReturnType( "Public", "E" );
		setReturns( "the last element from this LinkedList." );
	}
}

class llistRemoveLastOccurrence extends llistMethod {
	llistRemoveLastOccurrence() {
		setName( "removeLastOccurrence" );
		setDesc( "Removes the last occurrence of the specified element in this LinkedList (when traversing the LinkedList from head to tail). If the LinkedList does not contain the element, it is unchanged." );
		addParam( "Object", "o" );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if the LinkedList contained the specified element." );
	}
}

class llistSet extends llistMethod {
	llistSet() {
		setName( "set" );
		setDesc( "Replaces the element at the specified position in this LinkedList with the specified element." );
		addParam( "int", "index" );
		addParam( "E", "element" );
		setReturnType( "Public", "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class llistSize extends llistMethod {
	llistSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this LinkedList." );
		setReturnType( "Public", "int" );
		setReturns( "the number of elements in this LinkedList." );
	}
}

class llistToArray extends llistMethod {
	llistToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this LinkedList." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array containing all of the elements in this LinkedList." );
	}
}

class llistToArray2 extends llistMethod {
	llistToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in the LinkedList." );
		addParam("T[]", "a");
		setReturnType( "Public", "T[]" );
		setReturns( "an array containing all of the elements in the LinkedList." );
	}
}


/*************************************************************
**********************NUMBER METHODS**************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

class numConstructor extends Constructor {
	numConstructor() {
		setName( "Number" );
		setEnclosingClass( "Number" );
	}
}

class Number1 extends numConstructor {
	Number1() { 
		setDesc( "None" );
	}
}

/**************************METHODS**************************/

abstract class numMethod extends Method {
	numMethod() {
		setEnclosingClass( "Number" );
	}
}

class numByteValue extends numMethod {
	numByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of the specified number as a byte." );
		setReturnType( "Public", "byte" );
		setReturns( "the numeric value represented by this object after conversion to type byte." );
	}
}

class numDoubleValue extends numMethod {
	numDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of the specified number as a double." );
		setReturnType( "Abstract", "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class numFloatValue extends numMethod {
	numFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of the specified number as a float." );
		setReturnType( "Abstract", "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class numIntValue extends numMethod {
	numIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of the specified number as an int." );
		setReturnType( "Abstract", "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class numShortValue extends numMethod {
	numShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of the specified number as a short." );
		setReturnType( "Abstract", "short" );
		setReturns( "the numeric value represented by this object after conversion to type short." );
	}
}

/*************************************************************
**********************INTEGER METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class intConstructor extends Constructor {
	intConstructor() { 
		setName( "Integer" );
		setEnclosingClass( "Integer" );
	}
}

class Integer1 extends intConstructor {
	Integer1() {
		setDesc( "Constructs a newly allocated Integer object that represents the specified int value." );
		addParam( "int", "value" );
	}
}

class Integer2 extends intConstructor {
	Integer2() {
		setDesc( "Constructs a newly allocated Integer object that represents the int value indicated by the String parameter." );
		addParam( "String", "s" );
	}
}

/**************************METHODS**************************/

abstract class intMethod extends Method {
	intMethod() {
		setEnclosingClass( "Integer" );
	}
}

class intBitCount extends intMethod {
	intBitCount() {
		setName( "bitCount" );
		setDesc( "Returns the number of one-bits in the two's complement binary representation of the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "the number of one-bits in the two's complement binary representation of the specified int value." );
	}
}

class intByteValue extends intMethod {
	intByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Integer as a byte." );
		setReturnType( "Public", "byte" );
		setReturns( "the numeric value represented by this Integer after conversion to type byte." );
	}
}

class intCompare extends intMethod {
	intCompare() {
		setName( "compare" );
		setDesc( "Compares two ints numerically." );
		addParam( "int", "x" );
		addParam( "int", "y" );
		setReturnType( "Static", "int" );
		setReturns( "the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y." );
	}
}

class intCompareTo extends intMethod {
	intCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Integer objects numerically." );
		addParam( "Integer", "anotherInteger" );
		setReturnType( "Public", "int" );
		setReturns( "the value 0 if this Integer is equal to the argument Integer; a value less than 0 if this Integer is numerically less than the argument Integer; and a value greater than 0 if this Integer is numerically greater than the argument Integer (signed comparison)." );
	}
}

class intDecode extends intMethod {
	intDecode() {
		setName( "decode" );
		setDesc( "Decodes a String into an Integer." );
		addParam( "String", "nm" );
		setReturnType( "Static", "Integer" );
		setReturns( "an Integer object holding the int value represented by nm," );
	}
}

class intDoubleValue extends intMethod {
	intDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of this Integer as a double." );
		setReturnType( "Public", "double" );
		setReturns( "the numeric value represented by this Integer after conversion to type double." );
	}
}

class intEquals extends intMethod {
	intEquals() {
		setName( "equals" );
		setDesc( "Compares this Integer to the specified object." );
		addParam( "Object", "obj" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class intFloatValue extends intMethod {
	intFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of this Integer as a float." );
		setReturnType( "Public", "float" );
		setReturns( "the numeric value represented by this Integer after conversion to type float." );
	}
}

class intGetInteger extends intMethod {
	intGetInteger() {
		setName( "getInteger" );
		setDesc( "Determines the integer value of the system property with the specified name." );
		addParam( "String", "nm" );
		setReturnType( "Static", "Integer" );
		setReturns( "the Integer value of the property." );
	}
}

class intGetInteger2 extends intMethod {
	intGetInteger2() {
		setName( "getInteger" );
		setDesc( "Determines the integer value of the system property with the specified name. The second argument is the default value. The default value is returned if there is no property of the specified name, if the property does not have the correct numeric format, or if the specified name is empty or null." );
		addParam( "String", "nm" );
		addParam( "int", "val" );
		setReturnType( "Static", "Integer" );
		setReturns( "the Integer value of the property." );
	}
}

class intGetInteger3 extends intMethod {
	intGetInteger3() {
		setName( "getInteger" );
		setDesc( "Determines the integer value of the system property with the specified name. The second argument is the default value. The default value is returned if there is no property of the specified name, if the property does not have the correct numeric format, or if the specified name is empty or null." );
		addParam( "String", "nm" );
		addParam( "Integer", "val" );
		setReturnType( "Static", "Integer" );
		setReturns( "the Integer value of the property." );
	}
}

class intHashCode extends intMethod {
	intHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Integer." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object, equal to the primitive int value represented by this Integer object." );
	}
}

class intHighestOneBit extends intMethod {
	intHighestOneBit() {
		setName( "highestOneBit" );
		setDesc( "Returns an int value with at most a single one-bit, in the position of the highest-order (\"leftmost\") one-bit in the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "an int value with a single one-bit, in the position of the highest-order one-bit in the specified value, or zero if the specified value is itself equal to zero." );
	}
}

class intIntValue extends intMethod {
	intIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Integer as an int." );
		setReturnType( "Public", "int" );
		setReturns( "the numeric value represented by this Integer after conversion to type int." );
	}
}

class intLongValue extends intMethod {
	intLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Integer as a long." );
		setReturnType( "Public", "long" );
		setReturns( "the numeric value represented by this Integer after conversion to type long." );
	}
}

class intLowestOneBit extends intMethod {
	intLowestOneBit() {
		setName( "lowestOneBit" );
		setDesc( "Returns an int value with at most a single one-bit, in the position of the lowest-order (\"rightmost\") one-bit in the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "an int value with a single one-bit, in the position of the lowest-order one-bit in the specified value, or zero if the specified value is itself equal to zero." );
	}
}

class intNumberOfLeadingZeros extends intMethod {
	intNumberOfLeadingZeros() {
		setName( "numberOfLeadingZeros" );
		setDesc( "Returns the number of zero bits preceding the highest-order (\"leftmost\") one-bit in the two's complement binary representation of the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "the number of zero bits preceding the highest-order (\"leftmost\") one-bit in the two's complement binary representation of the specified int value, or 32 if the value is equal to zero." );
	}
}

class intNumberOfTrailingZeros extends intMethod {
	intNumberOfTrailingZeros() {
		setName( "numberOfTrailingZeros" );
		setDesc( "Returns the number of zero bits following the lowest-order (\"rightmost\") one-bit in the two's complement binary representation of the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "the number of zero bits following the lowest-order (\"rightmost\") one-bit in the two's complement binary representation of the specified int value, or 32 if the value is equal to zero." );
	}
}

class intParseInt extends intMethod {
	intParseInt() {
		setName( "parseInt" );
		setDesc( "Parses the string argument as a signed decimal integer." );
		addParam( "String", "s" );
		setReturnType( "Static", "int" );
		setReturns( "the integer value represented by the argument in decimal." );
	}
}

class intParseInt2 extends intMethod {
	intParseInt2() {
		setName( "parseInt" );
		setDesc( "Parses the string argument as a signed integer in the radix specified by the second argument." );
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturnType( "Static", "int" );
		setReturns( "the integer represented by the string argument in the specified radix." );
	}
}

class intReverse extends intMethod {
	intReverse() {
		setName( "reverse" );
		setDesc( "Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "the value obtained by reversing order of the bits in the specified int value." );
	}
}

class intReverseBytes extends intMethod {
	intReverseBytes() {
		setName( "reverse" );
		setDesc( "Returns the value obtained by reversing the order of the bytes in the two's complement representation of the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "the value obtained by reversing order of the bytes in the specified int value." );
	}
}

class intRotateLeft extends intMethod {
	intRotateLeft() {
		setName( "rotateLeft" );
		setDesc( "Returns the value obtained by rotating the two's complement binary representation of the specified int value left by the specified number of bits." );
		addParam( "int", "i" );
		addParam( "int", "distance" );
		setReturnType( "Static", "int" );
		setReturns( "the value obtained by rotating the two's complement binary representation of the specified int value left by the specified number of bits." );
	}
}

class intRotateRight extends intMethod {
	intRotateRight() {
		setName( "rotateRight" );
		setDesc( "Returns the value obtained by rotating the two's complement binary representation of the specified int value right by the specified number of bits." );
		addParam( "int", "i" );
		addParam( "int", "distance" );
		setReturnType( "Static", "int" );
		setReturns( "the value obtained by rotating the two's complement binary representation of the specified int value right by the specified number of bits." );
	}
}

class intShortValue extends intMethod {
	intShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Integer as a short." );
		setReturnType( "Public", "short" );
		setReturns( "the numeric value represented by this Integer after conversion to type short." );
	}
}

class intSigNum extends intMethod {
	intSigNum() {
		setName( "sigNum" );
		setDesc( "Returns the signum function of the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "int" );
		setReturns( "the signum function of the specified int value." );
	}
}

class intToBinaryString extends intMethod {
	intToBinaryString() {
		setName( "toBinaryString" );
		setDesc( "Returns a string representation of the integer argument as an unsigned integer in base 2." );
		addParam( "int", "i" );
		setReturnType( "Static", "String" );
		setReturns( "the string representation of the unsigned integer value represented by the argument in binary (base 2)." );
	}
}

class intToHexString extends intMethod {
	intToHexString() {
		setName( "toHexString" );
		setDesc( "Returns a string representation of the integer argument as an unsigned integer in base 16." );
		addParam( "int", "i" );
		setReturnType( "Static", "String" );
		setReturns( "the string representation of the unsigned integer value represented by the argument in hexadecimal (base 16)." );
	}
}

class intToOctalString extends intMethod {
	intToOctalString() {
		setName( "toOctalString" );
		setDesc( "Returns a string representation of the integer argument as an unsigned integer in base 8." );
		addParam( "int", "i" );
		setReturnType( "Static", "String" );
		setReturns( "the string representation of the unsigned integer value represented by the argument in Octal (base 8)." );
	}
}

class intToString extends intMethod {
	intToString() {
		setName( "toString" );
		setDesc( "Returns a String object representing this Integer's value." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of the value of this object in base 10." );
	}
}

class intToString2 extends intMethod {
	intToString2() {
		setName( "toString" );
		setDesc( "Returns a String object representing the specified integer." );
		addParam( "int", "i" );
		setReturnType( "Static", "String" );
		setReturns( "a string representation of the value of the specified integer in base 10." );
	}
}

class intToString3 extends intMethod {
	intToString3() {
		setName( "toString" );
		setDesc( "Returns a string representation of the first argument in the radix specified by the second argument." );
		addParam( "int", "i" );
		addParam( "int", "radix" );
		setReturnType( "Static", "String" );
		setReturns( "a string representation of the argument in the specified radix." );
	}
}

class intValueOf extends intMethod {
	intValueOf() {
		setName( "valueOf" );
		setDesc( "Returns an Integer instance representing the specified int value." );
		addParam( "int", "i" );
		setReturnType( "Static", "Integer" );
		setReturns( "an Integer instance representing i." );
	}
}

class intValueOf2 extends intMethod {
	intValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns an Integer instance holding the value of the specified String." );
		addParam( "String", "s" );
		setReturnType( "Static", "Integer" );
		setReturns( "an Integer object holding the value represented by the string argument." );
	}
}

class intValueOf3 extends intMethod {
	intValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns an Integer object holding the value extracted from the specified String when parsed with the radix given by the second argument." );
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturnType( "Static", "Integer" );
		setReturns( "an Integer object holding the value represented by the string argument in the specified radix." );
	}
}

/*************************************************************
**********************BYTE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class byteConstructor extends Constructor {
	byteConstructor() { 
		setName( "Byte" );
		setEnclosingClass( "Byte" );
	}
}

class Byte1 extends byteConstructor {
	Byte1() {
		setDesc( "Constructs a newly allocated Byte object that represents the specified byte value." );
		addParam( "byte", "value" );
	}
}

class Byte2 extends byteConstructor {
	Byte2() {
		setDesc( "Constructs a newly allocated Byte object that represents the byte value indicated by the String parameter." );
		addParam( "String", "s" );
	}
}

/**************************METHODS**************************/

abstract class byteMethod extends Method {
	byteMethod() {
		setEnclosingClass( "Byte" );
	}
}

class byteByteValue extends byteMethod {
	byteByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Byte as a byte." );
		setReturnType( "Public", "byte" );
		setReturns( "the numeric value represented by this object after conversion to type byte." );
	}
}

class byteShortValue extends byteMethod {
	byteShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Byte as a short." );
		setReturnType( "Public", "short" );
		setReturns( "the numeric value represented by this object after conversion to type short." );
	}
}

class byteIntValue extends byteMethod {
	byteIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Byte as an int." );
		setReturnType( "Public", "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class byteLongValue extends byteMethod {
	byteLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Byte as a long." );
		setReturnType( "Public", "long" );
		setReturns( "the numeric value represented by this object after conversion to type long." );
	}
}

class byteFloatValue extends byteMethod {
	byteFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of this Byte as a float." );
		setReturnType( "Public", "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class byteDoubleValue extends byteMethod {
	byteDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of this Byte as a double." );
		setReturnType( "Public", "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class byteToString extends byteMethod {
	byteToString() {
		setName( "toString" );
		setDesc( "Returns a String object representing this Byte's value. The value is converted to signed decimal representation and returned as a string, exactly as if the byte value were given as an argument to the toString(byte) method." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of the value of this object in base 10." );
	}
}

class byteToString2 extends byteMethod {
	byteToString2() {
		setName( "toString" );
		setDesc( "Returns a new String object representing the specified byte. The radix is assumed to be 10." );
		addParam( "byte", "b" );
		setReturnType( "Static", "String" );
		setReturns( "the string representation of the specified byte." );
	}
}

class byteHashCode extends byteMethod {
	byteHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Byte." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class byteEquals extends byteMethod {
	byteEquals() {
		setName( "equals" );
		setDesc( "Compares this object to the specified object. The result is true if and only if the argument is not null and is a Byte object that contains the same byte value as this object." );
		addParam( "Object", "obj" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class byteCompareTo extends byteMethod {
	byteCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Byte objects numerically." );
		addParam( "Byte", "anotherByte" );
		setReturnType( "Public", "int" );
		setReturns( "the value 0 if this Byte is equal to the argument Byte; a value less than 0 if this Byte is numerically less than the argument Byte; and a value greater than 0 if this Byte is numerically greater than the argument Byte (signed comparison)." );
	}
}

class byteValueOf extends byteMethod {
	byteValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Byte instance representing the specified byte value. If a new Byte instance is not required, this method should generally be used in preference to the constructor Byte(byte), as this method is likely to yield significantly better space and time performance by caching frequently requested values." );
		addParam( "byte", "b" );
		setReturnType( "Static", "Byte" );
		setReturns( "a Byte instance representing b." );
	}
}

class byteValueOf2 extends byteMethod {
	byteValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns a Byte object holding the value extracted from the specified String when parsed with the radix given by the second argument. The first argument is interpreted as representing a signed byte in the radix specified by the second argument, exactly as if the argument were given to the parseByte(java.lang.String, int) method. The result is a Byte object that represents the byte value specified by the string.");
		addParam( "String", "s");
		setReturnType( "Static", "Byte" );
		setReturns( "a Byte object holding the value represented by the string argument." );
	}
}

class byteValueOf3 extends byteMethod {
	byteValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns a Byte object holding the value extracted from the specified String when parsed with the radix given by the second argument. The first argument is interpreted as representing a signed byte in the radix specified by the second argument, exactly as if the argument were given to the parseByte(java.lang.String, int) method. The result is a Byte object that represents the byte value specified by the string." );
		addParam( "String", "s");
		addParam( "int", "radix" );
		setReturnType( "Static", "Byte" );
		setReturns( "a Byte object holding the value represented by the string argument in the specified radix." );
	}
}

class byteParseByte extends byteMethod {
	byteParseByte() {
		setName( "parseByte" );
		setDesc( "Parses the string argument as a signed decimal byte. The characters in the string must all be decimal digits, except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value. The resulting byte value is returned, exactly as if the argument and the radix 10 were given as arguments to the parseByte(java.lang.String, int) method." );
		addParam( "String", "s" );
		setReturnType( "Static", "byte" );
		setReturns( "the byte value represented by the argument in decimal.");
	}
}

class byteParseByte2 extends byteMethod {
	byteParseByte2() {
		setName( "parseByte" );
		setDesc( "Parses the string argument as a signed byte in the radix specified by the second argument. The characters in the string must all be digits, of the specified radix (as determined by whether Character.digit(char, int) returns a nonnegative value) except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value. The resulting byte value is returned.");
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturnType( "Static", "byte" );
		setReturns( "the byte value represented by the string argument in the specified radix.");
	}
}

class byteDecode extends byteMethod {
	byteDecode() {
		setName( "decode" );
		setDesc( "Decodes a String into a Byte. Accepts decimal, hexadecimal, and octal numbers." );
		setReturnType( "Static", "Byte" );
		setReturns( "a Byte object holding the byte value represented by 'nm'" );
	}
}

/*************************************************************
**********************DOUBLE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class doubleConstructor extends Constructor {
	doubleConstructor() { 
		setName( "Double" );
		setEnclosingClass( "Double" );
	}
}

class Double1 extends doubleConstructor {
	Double1() {
		setDesc( "Constructs a newly allocated Double object that represents the primitive double argument." );
		addParam( "Double", "value" );
	}
}

class Double2 extends doubleConstructor {
	Double2() {
		setDesc( "Constructs a newly allocated Double object that represents the floating-point value of type double represented by the string." );
		addParam( "String", "s" );
	}
}

/**************************METHODS**************************/

abstract class doubleMethod extends Method {
	doubleMethod() {
		setEnclosingClass( "Double" );
	}
}

class doubleByteValue extends doubleMethod {
	doubleByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Double as a byte (by casting to a byte)." );
		setReturnType( "Public", "byte" );
		setReturns( "the double value represented by this object converted to type byte." );
	}
}

class doubleCompare extends doubleMethod {
	doubleCompare() {
		setName( "compare" );
		setDesc( "Compares the two specified double values. The sign of the integer value returned is the same as that of the integer that would be returned by the call." );
		addParam( "Double", "d1" );
		addParam( "Double", "d2" );
		setReturnType( "Static", "int" );
		setReturns( "the value 0 if d1 is numerically equal to d2; a value less than 0 if d1 is numerically less than d2; and a value greater than 0 if d1 is numerically greater than d2." );
	}
}

class doubleCompareTo extends doubleMethod {
	doubleCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Double objects numerically. There are two ways in which comparisons performed by this method differ from those performed by the Java language numerical comparison operators (<, <=, ==, >= >) when applied to primitive double values." );
		addParam( "Double", "anotherDouble" );
		setReturnType( "Public", "int" );
		setReturns( "the value 0 if anotherDouble is numerically equal to this Double; a value less than 0 if this Double is numerically less than anotherDouble; and a value greater than 0 if this Double is numerically greater than anotherDouble." );
	}
}

class doubleDoubleToLongBits extends doubleMethod {
	doubleDoubleToLongBits() {
		setName( "doubleToLongBits" );
		setDesc( "Returns a representation of the specified floating-point value according to the IEEE 754 floating-point 'double format' bit layout." );
		addParam( "Double", "value" );
		setReturnType( "Static", "long" );
		setReturns( "the bits that represent the floating-point number." );
	}
}

class doubleDoubleToRawLongBits extends doubleMethod {
	doubleDoubleToRawLongBits() {
		setName( "doubleToRawLongBits" );
		setDesc( "Returns a representation of the specified floating-point value according to the IEEE 754 floating-point 'double format' bit layout, preserving Not-a-Number (NaN) values." );
		addParam( "Double", "value" );
		setReturnType( "Static", "long" );
		setReturns( "the bits that represent the floating-point number." );
	}
}

class doubleDoubleValue extends doubleMethod {
	doubleDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the double value of this Double object." );
		setReturnType( "Public", "double" );
		setReturns( "the double value represented by this object." );
	}
}

class doubleEquals extends doubleMethod {
	doubleEquals() {
		setName( "equals" );
		setDesc( "Compares this object against the specified object. The result is true if and only if the argument is not null and is a Double object that represents a double that has the same value as the double represented by this object. For this purpose, two double values are considered to be the same if and only if the method doubleToLongBits(double) returns the identical long value when applied to each." );
		addParam( "Object", "obj" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class doubleFloatValue extends doubleMethod {
	doubleFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the float value of this Double object." );
		setReturnType( "Public", "float" );
		setReturns( "the double value represented by this object converted to type float." );
	}
}

class doubleHashCode extends doubleMethod {
	doubleHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Double object. The result is the exclusive OR of the two halves of the long integer bit representation, exactly as produced by the method doubleToLongBits(double), of the primitive double value represented by this Double object." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class doubleIntValue extends doubleMethod {
	doubleIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Double as an int (by casting to type int)." );
		setReturnType( "Public", "int" );
		setReturns( "the double value represented by this object converted to type int." );
	}
}

class doubleIsInfinite extends doubleMethod {
	doubleIsInfinite() {
		setName( "isInfinite" );
		setDesc( "Returns true if this Double value is infinitely large in magnitude, false otherwise." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the value represented by this object is positive infinity or negative infinity; false otherwise." );
	}
}

class doubleIsInfinite2 extends doubleMethod {
	doubleIsInfinite2() {
		setName( "isInfinite" );
		setDesc( "Returns true if the specified number is infinitely large in magnitude, false otherwise." );
		addParam( "Double", "v" );
		setReturnType( "Static", "boolean" );
		setReturns( "true if the value of the argument is positive infinity or negative infinity; false otherwise." );
	}
}

class doubleIsNaN extends doubleMethod {
	doubleIsNaN() {
		setName( "isNaN" );
		setDesc( "Returns true if this Double value is a Not-a-Number (NaN), false otherwise." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the value represented by this object is NaN; false otherwise." );
	}
}

class doubleIsNaN2 extends doubleMethod {
	doubleIsNaN2() {
		setName( "isNaN" );
		setDesc( "Returns true if the specified number is a Not-a-Number (NaN) value, false otherwise." );
		addParam( "Double", "v" );
		setReturnType( "Static", "boolean" );
		setReturns( "true if the value of the argument is NaN; false otherwise." );
	}
}

class doubleLongBitsToDouble extends doubleMethod {
	doubleLongBitsToDouble() {
		setName( "longBitsToDouble" );
		setDesc( "Returns the double value corresponding to a given bit representation. The argument is considered to be a representation of a floating-point value according to the IEEE 754 floating-point 'double format' bit layout." );
		addParam( "long", "bits" );
		setReturnType( "Static", "double" );
		setReturns( "the double floating-point value with the same bit pattern." );
	}
}

class doubleLongValue extends doubleMethod {
	doubleLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Double as a long (by casting to type long)." );
		setReturnType( "Public", "long" );
		setReturns( "the double value represented by this object converted to type long." );
	}
}

class doubleParseDouble extends doubleMethod {
	doubleParseDouble() {
		setName( "parseDouble" );
		setDesc( "Returns a new double initialized to the value represented by the specified String, as performed by the valueOf method of class Double." );
		addParam( "String", "s" );
		setReturnType( "Static", "double" );
		setReturns( "the double value represented by the string argument." );
	}
}

class doubleShortValue extends doubleMethod {
	doubleShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Double as a short (by casting to a short)." );
		setReturnType( "Public", "short" );
		setReturns( "the double value represented by this object converted to type short." );
	}
}

class doubleToHexString extends doubleMethod {
	doubleToHexString() {
		setName( "toHexString" );
		setDesc( "Returns a hexadecimal string representation of the double argument. All characters mentioned below are ASCII characters." );
		addParam( "Double", "d" );
		setReturnType( "Static", "String" );
		setReturns( "a hex string representation of the argument." );
	}
}

class doubleToString extends doubleMethod {
	doubleToString() {
		setName( "toString" );
		setDesc( "Returns a string representation of this Double object. The primitive double value represented by this object is converted to a string exactly as if by the method toString of one argument." );
		setReturnType( "Public", "String" );
		setReturns( "a String representation of this object." );
	}
}

class doubleToString2 extends doubleMethod {
	doubleToString2() {
		setName( "toString" );
		setDesc( "Returns a string representation of the Double object." );
		addParam( "Double", "d" );
		setReturnType( "Public", "String" );
		setReturns( "a String representation of the argument." );
	}
}

class doubleValueOf extends doubleMethod {
	doubleValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Double instance representing the specified double value. If a new Double instance is not required, this method should generally be used in preference to the constructor Double(double), as this method is likely to yield significantly better space and time performance by caching frequently requested values." );
		addParam( "Double", "d" );
		setReturnType( "Static", "Double" );
		setReturns( "a Double instance representing 'd'." );
	}
}

class doubleValueOf2 extends doubleMethod {
	doubleValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns a Double object holding the double value represented by the argument string s." );
		addParam( "String", "s" );
		setReturnType( "Static", "Double" );
		setReturns( "a Double object holding the value represented by the String argument." );
	}
}

/*************************************************************
**********************MATH METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class mathConstructor extends Constructor {
	mathConstructor() { 
		setName( "Math" );
		setEnclosingClass( "Math" );
	}
}

/**************************METHODS**************************/

abstract class mathMethod extends Method {
	mathMethod() {
		setEnclosingClass( "Math" );
	}
}

class mathAbs extends mathMethod {
	mathAbs() {
		setName( "abs" );
		setDesc( "Returns the absolute value of a double value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a");
		setReturns( "the absolute value of the argument." );
	}
}

class mathAbs2 extends mathMethod {
	mathAbs2() {
		setName( "abs" );
		setDesc( "Returns the absolute value of a float value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "Static", "float" );
		addParam( "Float", "a" );
		setReturns( "the absolute value of the argument." );
	}
}

class mathAbs3 extends mathMethod {
	mathAbs3() {
		setName( "abs" );
		setDesc( "Returns the absolute value of an int value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "Static", "int" );
		addParam( "int", "a" );
		setReturns( "the absolute value of the argument." );
	}
}

class mathAbs4 extends mathMethod {
	mathAbs4() {
		setName( "abs" );
		setDesc( "Returns the absolute value of a long value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "Static", "long" );
		addParam( "long", "a" );
		setReturns( "the absolute vaue of the argument." );
	}
}

class mathAcos extends mathMethod {
	mathAcos() {
		setName( "acos" );
		setDesc( "Returns the arc cosine of a value; the returned angle is in the range 0.0 through pi." );
		setReturnType( "Static", "double" );
		addParam( "long", "a" );
		setReturns( "the arc cosine of the argument." );
	}
}

class mathAsin extends mathMethod {
	mathAsin() {
		setName( "asin" );
		setDesc( "Returns the arc sine of a value; the returned angle is in the range -pi/2 through pi/2." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the arc sine of the argument." );
	}
}

class mathAtan extends mathMethod {
	mathAtan() {
		setName( "atan" );
		setDesc( "Returns the arc tangent of a value; the returned angle is in the range -pi/2 through pi/2." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the arc tangent of the argument." );
	}
}

class mathAtan2 extends mathMethod {
	mathAtan2() {
		setName( "atan2" );
		setDesc( "Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta). This method computes the phase theta by computing an arc tangent of y/x in the range of -pi to pi." );
		setReturnType( "Static", "double" );
		addParam( "Double", "y" );
		addParam( "Double", "x" );
		setReturns( "the theta component of the point (r, theta) in polar coordinates that corresponds to the point (x, y) in Cartesian coordinates." );
	}
}

class mathCbrt extends mathMethod {
	mathCbrt() {
		setName( "cbrt" );
		setDesc( "Returns the cube root of a double value. For positive finite x, cbrt(-x) == -cbrt(x); that is, the cube root of a negative value is the negative of the cube root of that value's magnitude." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the cube root of 'a'" );
	}
}

class mathCeil extends mathMethod {
	mathCeil() {
		setName( "ceil" );
		setDesc( "Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the smallest (closest to negative infinity) floating-point value that is greater than or equal to the argument and is equal to a mathematical integer." );
	}
}

class mathCopySign extends mathMethod {
	mathCopySign() {
		setName( "copySign" );
		setDesc( "Returns the first floating-point argument with the sign of the second floating-point argument. Note that unlike the StrictMath.copySign method, this method does not require NaN sign arguments to be treated as positive values; implementations are permitted to treat some NaN arguments as positive and other NaN arguments as negative to allow greater performance." );
		setReturnType( "Static", "double" );
		addParam( "Double", "magnitude" );
		addParam( "Double", "sign" );
		setReturns( "a value with the magnitude of magnitude and the sign of sign." );
	}
}

class mathCopySign2 extends mathMethod {
	mathCopySign2() {
		setName( "copySign2" );
		setDesc( "Returns the first floating-point argument with the sign of the second floating-point argument. Note that unlike the StrictMath.copySign method, this method does not require NaN sign arguments to be treated as positive values; implementations are permitted to treat some NaN arguments as positive and other NaN arguments as negative to allow greater performance." );
		setReturnType( "Static", "float" );
		addParam( "Float", "magnitude" );
		addParam( "Float", "sign" );
		setReturns( "a value with the magnitude of magnitude and the sign of sign." );
	}
}

class mathCos extends mathMethod {
	mathCos() {
		setName( "cos" );
		setDesc( "Returns the trigonometric cosine of an angle." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the cosine of the argument." );
	}
}

class mathCosh extends mathMethod {
	mathCosh() {
		setName( "cosh" );
		setDesc( "Returns the hyperbolic cosine of a double value. The hyperbolic cosine of x is defined to be (ex + e-x)/2 where e is Euler's number." );
		setReturnType( "Static", "double" );
		addParam( "Double", "x" );
		setReturns( "The hyperbolic cosine of x." );
	}
}

class mathExp extends mathMethod {
	mathExp() {
		setName( "exp" );
		setDesc( "Returns Euler's number e raised to the power of a double value." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a");
		setReturns( "the value e^a, where e is the base of the natural logarithms." );
	}
}

class mathExpm1 extends mathMethod {
	mathExpm1() {
		setName( "expm1" );
		setDesc( "Returns e^x -1. Note that for values of x near 0, the exact sum of expm1(x) + 1 is much closer to the true result of e^x than exp(x)." );
		setReturnType( "Static", "double" );
		addParam( "Double", "x" );
		setReturns( "the value e^x-1." );
	}
}

class mathFloor extends mathMethod {
	mathFloor() {
		setName( "floor" );
		setDesc( "Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the largest (closest to positive infinity) floating-point value that is less than or equal to the argument and is equal to a mathematical integer." );
	}
}

class mathGetExponent extends mathMethod {
	mathGetExponent() {
		setName( "getExponent" );
		setDesc( "Returns the unbiased exponent used in the representation of a double." );
		setReturnType( "Static", "int" );
		addParam( "Double", "d" );
		setReturns( "the unbiased exponent of the argument." );
	}
}

class mathGetExponent2 extends mathMethod {
	mathGetExponent2() {
		setName( "getExponent" );
		setDesc( "Returns the unbiased exponent used in the representation of a float." );
		setReturnType( "Static", "int" );
		addParam( "Float", "f" );
		setReturns( "the unbiased exponent of the argument" );
	}
}

class mathHypot extends mathMethod {
	mathHypot() {
		setName( "hypot" );
		setDesc( "Returns sqrt(x^2 +y^2) without intermediate overflow or underflow." );
		setReturnType( "Static", "double" );
		addParam( "Double", "x" );
		addParam( "Double", "y" );
		setReturns( "sqrt(x^2 + y^2) without intermediate overflow or underflow." );
	}
}

class mathIEEEremainder extends mathMethod {
	mathIEEEremainder() {
		setName( "IEEEremainder" );
		setDesc( "Computes the remainder operation on two arguments as prescribed by the IEEE 754 standard." );
		setReturnType( "Static", "double" );
		addParam( "Double", "f1" );
		addParam( "Double", "f2" );
		setReturns( "the remainder when f1 is divided by f2." );
	}
}

class mathLog extends mathMethod {
	mathLog() {
		setName( "log" );
		setDesc( "Returns the natural logarithm (base e) of a double value." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the value ln 'a', the natural logarithm of 'a'." );
	}
}

class mathLog10 extends mathMethod {
	mathLog10() {
		setName( "log10" );
		setDesc( "Returns the base 10 logarithm of a double value." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the base 10 logarithm of 'a'" );
	}
}

class mathLog1p extends mathMethod {
	mathLog1p() {
		setName( "log1p" );
		setDesc( "Returns the natural logarithm of the sum of the argument and 1." );
		setReturnType( "Static", "double" );
		addParam( "Double", "x" );
		setReturns( "the value ln(x + 1), the natural log of x + 1" );
	}
}

class mathMax extends mathMethod {
	mathMax() {
		setName( "max" );
		setDesc( "Returns the greater of two double values." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		addParam( "Double", "b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMax2 extends mathMethod {
	mathMax2() {
		setName( "max" );
		setDesc( "Returns the greater of two float values." );
		setReturnType( "Static", "float" );
		addParam( "Float", "a" );
		addParam( "Float", "b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMax3 extends mathMethod {
	mathMax3() {
		setName( "max" );
		setDesc( "Returns the greater of two int values." );
		setReturnType( "Static", "int" );
		addParam( "int", "a" );
		addParam( "int", "b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMax4 extends mathMethod {
	mathMax4() {
		setName( "max" );
		setDesc( "Returns the greater of two long values." );
		setReturnType( "Static", "long" );
		addParam( "long", "a" );
		addParam( "long", "b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMin extends mathMethod {
	mathMin() {
		setName( "min" );
		setDesc( "Returns the smaller of two double values." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		addParam( "Double", "b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathMin2 extends mathMethod {
	mathMin2() {
		setName( "min" );
		setDesc( "Returns the smaller of two float values." );
		setReturnType( "Static", "float" );
		addParam( "Float", "a" );
		addParam( "Float", "b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathMin3 extends mathMethod {
	mathMin3() {
		setName( "min" );
		setDesc( "Returns the smaller of two int values." );
		setReturnType( "Static", "int" );
		addParam( "int", "a" );
		addParam( "int", "b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathMin4 extends mathMethod {
	mathMin4() {
		setName( "min" );
		setDesc( "Returns the smaller of two long values." );
		setReturnType( "Static", "long" );
		addParam( "long", "a" );
		addParam( "long", "b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathNextAfter extends mathMethod {
	mathNextAfter() {
		setName( "nextAfter" );
		setDesc( "Returns the floating-point number adjacent to the first argument in the direction of the second argument." );
		setReturnType( "Static", "double" );
		addParam( "Double", "start" );
		addParam( "Double", "direction" );
		setReturns( "The floating-point number adjacent to start in the direction of direction." );
	}
}

class mathNextAfter2 extends mathMethod {
	mathNextAfter2() {
		setName( "nextAfter" );
		setDesc( "Returns the floating-point number adjacent to the first argument in the direction of the second argument." );
		setReturnType( "Static", "float" );
		addParam( "Float", "start" );
		addParam( "Double", "direction" );
		setReturns( "The floating-point number adjacent to start in the direction of direction." );
	}
}

class mathNextUp extends mathMethod {
	mathNextUp() {
		setName( "nextUp" );
		setDesc( "Returns the floating-point value adjacent to d in the direction of positive infinity." );
		setReturnType( "Static", "double" );
		addParam( "Double", "d" );
		setReturns( "The adjacent floating-point value closer to positive infinity." );
	}
}

class mathNextUp2 extends mathMethod {
	mathNextUp2() {
		setName( "nextUp" );
		setDesc( "Returns the floating-point value adjacent to f in the direction of positive infinity." );
		setReturnType( "Static", "float" );
		addParam( "Float", "f" );
		setReturns( "The adjacent floating-point value closer to positive infinity." );
	}
}

class mathPow extends mathMethod {
	mathPow() {
		setName( "pow" );
		setDesc( "Returns the value of the first argument raised to the power of the second argument." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		addParam( "Double", "b" );
		setReturns( "the value a^b." );
	}
}

class mathRandom extends mathMethod {
	mathRandom() {
		setName( "random" );
		setDesc( "Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0." );
		setReturnType( "Static", "double" );
		setReturns( "a pseudorandom double greater than or equal to 0.0 and less than 1.0." );
	}
}

class mathRint extends mathMethod {
	mathRint() {
		setName( "rint" );
		setDesc( "Returns the double value that is closest in value to the argument and is equal to a mathematical integer." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the closest floating-point value to a that is equal to a mathematical integer." );
	}
}

class mathRound extends mathMethod {
	mathRound() {
		setName( "round" );
		setDesc( "Returns the closest long to the argument." );
		setReturnType( "Static", "long" );
		addParam( "Double", "a" );
		setReturns( "the value of the argument rounded to the nearest long value." );
	}
}

class mathRound2 extends mathMethod {
	mathRound2() {
		setName( "round" );
		setDesc( "Returns the closest int to the argument." );
		setReturnType( "Static", "float" );
		addParam( "Float", "a" );
		setReturns( "the value of the argument rounded to the nearest int value." );
	}
}

class mathscalb extends mathMethod {
	mathscalb() {
		setName( "scalb" );
		setDesc( "Return f × 2^scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the double value set." );
		setReturnType( "Static", "double" );
		addParam( "Double", "d" );
		addParam( "int", "scaleFactor" );
		setReturns( "d x 2^scaleFactor." );
	}
}

class mathScalb2 extends mathMethod {
	mathScalb2() {
		setName( "scalb" );
		setDesc( "Return f × 2^scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the float value set." );
		setReturnType( "Static", "float" );
		addParam( "Float", "f" );
		addParam( "int", "scaleFactor" );
		setReturns( "f x 2^scaleFactor." );
	}
}

class mathSignum extends mathMethod {
	mathSignum() {
		setName( "signum" );
		setDesc( "Returns the signum function of the argument; zero if the argument is zero, 1.0 if the argument is greater than zero, -1.0 if the argument is less than zero." );
		setReturnType( "Static", "double" );
		addParam( "Double", "d" );
		setReturns( "the signum function of the argument." );
	}
}

class mathSignum2 extends mathMethod {
	mathSignum2() {
		setName( "signum" );
		setDesc( "Returns the signum function of the argument; zero if the argument is zero, 1.0 if the argument is greater than zero, -1.0 if the argument is less than zero." );
		setReturnType( "Static", "float" );
		addParam( "Float", "f" );
		setReturns( "the signum function of the argument." );
	}
}

class mathSin extends mathMethod {
	mathSin() {
		setName( "sin" );
		setDesc( "Returns the trigonometric sine of an angle." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the sine of the argument." );
	}
}

class mathSinh extends mathMethod {
	mathSinh() {
		setName( "sinh" );
		setDesc( "Returns the hyperbolic sine of a double value." );
		setReturnType( "Static", "double" );
		addParam( "Double", "x" );
		setReturns( "The hyperbolic sine of x." );
	}
}

class mathSqrt extends mathMethod {
	mathSqrt() {
		setName( "sqrt" );
		setDesc( "Returns the correctly rounded positive square root of a double value." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the positive square root of a. If the argument is NaN or less than zero, the result is NaN." );
	}
}

class mathTan extends mathMethod {
	mathTan() {
		setName( "tan" );
		setDesc( "Returns the trigonometric tangent of an angle." );
		setReturnType( "Static", "double" );
		addParam( "Double", "a" );
		setReturns( "the tangent of the argument." );
	}
}

class mathTanh extends mathMethod {
	mathTanh() {
		setName( "tanh" );
		setDesc( "Returns the hyperbolic tangent of a double value." );
		setReturnType( "Static", "double" );
		addParam( "Double", "x" );
		setReturns( "The hyperbolic tangent of x." );
	}
}

class mathToDegrees extends mathMethod {
	mathToDegrees() {
		setName( "toDegrees" );
		setDesc( "Converts an angle measured in radians to an approximately equivalent angle measured in degrees." );
		setReturnType( "Static", "double" );
		addParam( "Double", "angrad" );
		setReturns( "the measurement of the angle angrad in degrees." );
	}
}

class mathToRadians extends mathMethod {
	mathToRadians() {
		setName( "toRadians" );
		setDesc( "Converts an angle measured in degrees to an approximately equivalent angle measured in radians." );
		setReturnType( "Static", "double" );
		addParam( "Double", "andeg" );
		setReturns( "the measurement of the angle angdeg in radians." );
	}
}

class mathUlp extends mathMethod {
	mathUlp() {
		setName( "ulp" );
		setDesc( "Returns the size of an ulp of the argument. An ulp of a double value is the positive distance between this floating-point value and the double value next larger in magnitude." );
		setReturnType( "Static", "float" );
		addParam( "Double", "d" );
		setReturns( "the size of an ulp of the argument" );
	}
}

class mathUlp2 extends mathMethod {
	mathUlp2() {
		setName( "ulp" );
		setDesc( "Returns the size of an ulp of the argument. An ulp of a float value is the positive distance between this floating-point value and the float value next larger in magnitude." );
		setReturnType( "Static", "float" );
		addParam( "Float", "f" );
		setReturns( "the size of an ulp of the argument" );
	}
}

/*************************************************************
**********************STRING METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class stringConstructor extends Constructor {
	stringConstructor() { 
		setName( "String" );
		setEnclosingClass( "String" );
	}
}

class String1 extends stringConstructor {
	String1() {	
		setDesc("Initializes a newly created String object so that it represents an empty character sequence. Note that use of this constructor is unnecessary since Strings are immutable." );
	}
}

class String2 extends stringConstructor {
	String2(){
		setDesc( "Initializes a newly created String object so that it represents the same sequence of characters as the argument; in other words, the newly created string is a copy of the argument string." );
		addParam( "String", "original" );
	}
}

class String3 extends stringConstructor {
	String3(){
		setDesc( "Allocates a new String so that it represents the sequence of characters currently contained in the character array argument." );
		addParam( "char[]", "value" );
	}
}

class String4 extends stringConstructor {
	String4(){
		setDesc( "Allocates a new String that contains characters from a subarray of the character array argument. The offset argument is the index of the first character of the subarray and the count argument specifies the length of the subarray." );
		addParam( "char[]", "value" );
		addParam( "int", "offset" );
		addParam( "int", "count" );
	}
}

class String5 extends stringConstructor {
	String5(){
		setDesc( "Allocates a new String that contains characters from a subarray of the Unicode code point array argument. The offset argument is the index of the first code point of the subarray and the count argument specifies the length of the subarray." );
		addParam( "int[]", "codePoints" );
		addParam( "int", "offset" );
		addParam( "int", "count" );
	}
}

class String6 extends stringConstructor {
	String6(){
		setDesc( "Allocates a new String constructed from a subarray of an array of 8-bit integer values. The offset argument is the index of the first byte of the subarray, and the count argument specifies the length of the subarray." );
		addParam( "byte[]", "ascii" );
		addParam( "int", "hibyte" );
		addParam( "int", "offset" );
		addParam( "int", "count" );
	}
}

class String7 extends stringConstructor {
	String7(){
		setDesc( "Allocates a new String containing characters constructed from an array of 8-bit integer values. Each character in the resulting string is constructed from the corresponding component b in the byte array." );
		addParam( "byte[]", "ascii" );
		addParam( "int", "hibyte" );
	}
}

class String8 extends stringConstructor {
	String8(){
		setDesc( "Constructs a new String by decoding the specified subarray of bytes using the specified charset." );
		addParam( "byte[]", "bytes" );
		addParam( "int", "offset" );
		addParam( "int", "length" );
		addParam( "String", "charsetName" );
	}
}

class String9 extends stringConstructor {
	String9(){
		setDesc( "Constructs a new String by decoding the specified subarray of bytes using the specified charset." );
		addParam( "byte[]", "bytes" );
		addParam( "int", "offset" );
		addParam( "int", "length" );
		addParam( "Charset", "charsetName" );		
	}
}

class String10 extends stringConstructor {
	String10(){
		setDesc( "Constructs a new String by decoding the specified array of bytes using the specified charset." );
		addParam( "byte[]", "bytes" );
		addParam( "String", "charsetName" );
	}
}

class String11 extends stringConstructor {
	String11(){
		setDesc( "Constructs a new String by decoding the specified array of bytes using the specified charset." );
		addParam( "byte[]", "bytes" );
		addParam( "Charset", "charsetName" );
	}
}

class String12 extends stringConstructor {
	String12(){
		setDesc( "Constructs a new String by decoding the specified subarray of bytes using the platform's default charset." );
		addParam( "byte[]", "bytes" );
		addParam( "int", "offset" );
		addParam( "int", "length" );
	}
}

class String13 extends stringConstructor {
	String13(){
		setDesc( "Constructs a new String by decoding the specified array of bytes using the platform's default charset." );
		addParam( "byte[]", "bytes" );
	}
}

class String14 extends stringConstructor {
	String14(){
		setDesc( "Allocates a new string that contains the sequence of characters currently contained in the string buffer argument." );
		addParam( "StringBuffer", "buffer" );
	}
}

class String15 extends stringConstructor {
	String15(){
		setDesc( "Allocates a new string that contains the sequence of characters currently contained in the string builder argument." );
		addParam( "StringBuilder", "builder" );
	}
}
/**************************METHODS**************************/

abstract class stringMethod extends Method {
	stringMethod() {
		setEnclosingClass( "String" );
	}
}

class strCharAt extends stringMethod {
	strCharAt() {
		setName( "charAt" );
		setDesc( "Returns the char value at the specified index. An index ranges from 0 to length() - 1. The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing." );
		setReturnType( "Public", "char" );
		addParam( "int", "index" );
		setReturns( "the char value at the specified index of this string. The first char value is at index 0." );
	}
}

class strIsEmpty extends stringMethod {
	strIsEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns true if, and only if, length() is 0." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if length() is 0, otherwise false." );
	}
}

class strCodePointAt extends stringMethod {
	strCodePointAt() {
		setName( "codePointAt" );
		setDesc( "Returns the character (Unicode code point) at the specified index. The index refers to char values (Unicode code units) and ranges from 0 to length() - 1." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		setReturns( "the code point value of the character at the index." );
	}
}
class strCodePointBefore extends stringMethod {
	strCodePointBefore() {
		setName( "codePointBefore" );
		setDesc( "Returns the character (Unicode code point) before the specified index. The index refers to char values (Unicode code units) and ranges from 1 to length." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		setReturns( "the Unicode code point value before the given index." );
	}
}

class strCodePointCount extends stringMethod {
	strCodePointCount() {
		setName( "codePointCount" );
		setDesc( "Returns the number of Unicode code points in the specified text range of this String. The text range begins at the specified beginIndex and extends to the char at index endIndex - 1. Thus the length (in chars) of the text range is endIndex-beginIndex. Unpaired surrogates within the text range count as one code point each." );
		setReturnType( "Public", "int" );
		addParam( "int", "beginIndex" );
		addParam( "int", "endIndex" );
		setReturns( "the number of Unicode code points in the specified text range." );
	}
}

class strOffsetByCodePoints extends stringMethod {
	strOffsetByCodePoints() {
		setName( "offsetByCodePoints" );
		setDesc( "Returns the index within this String that is offset from the given index by codePointOffset code points. Unpaired surrogates within the text range given by index and codePointOffset count as one code point each." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		addParam( "int", "codePointOffset" );
		setReturns( "the index within this String." );
	}
}

class strGetChars extends stringMethod {
	strGetChars() {
		setName( "getChars" );
		setDesc( "Copies characters from this string into the destination character array." );
		setReturnType( "Public", "void" );
		addParam( "int", "srcBegin" );
		addParam( "int", "srcEnd" );
		addParam( "char[]", "dst" );
		addParam( "int", "dstBegin" );
	}
}

class strGetBytes extends stringMethod {
	strGetBytes() {
		setName( "getBytes" );
		setDesc( "Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array." );
		setReturnType( "Public", "byte[]" );
		addParam( "String", "charsetName" );
		setReturns( "The resultant byte array." );
	}
}

class strGetBytes2 extends stringMethod {
	strGetBytes2() {
		setName( "getBytes" );
		setDesc( "Encodes this String into a sequence of bytes using the given charset, storing the result into a new byte array." );
		setReturnType( "Public", "byte[]" );
		addParam( "Charset", "charset" );
		setReturns( "The resultant byte array." );
	}
}

class strGetBytes3 extends stringMethod {
	strGetBytes3() {
		setName( "getBytes" );
		setDesc( "Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array." );
		setReturnType( "Public", "byte[]" );
		setReturns( "The resultant byte array." );
	}
}

class strEquals extends stringMethod {
	strEquals() {
		setName( "equals" );
		setDesc( "Compares this string to the specified object. The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as this object." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "anObject" );
		setReturns( "true if the given object represents a String equivalent to this string, false otherwise." );
	}
}

class strContentEquals extends stringMethod {
	strContentEquals() {
		setName( "contentEquals" );
		setDesc( "Compares this string to the specified StringBuffer. The result is true if and only if this String represents the same sequence of characters as the specified StringBuffer." );
		setReturnType( "Public", "boolean" );
		addParam( "StringBuffer", "sb" );
		setReturns( "true if this String represents the same sequence of characters as the specified StringBuffer, false otherwise." );
	}
}

class strContentEquals2 extends stringMethod {
	strContentEquals2() {
		setName( "contentEquals" );
		setDesc( "Compares this string to the specified CharSequence. The result is true if and only if this String represents the same sequence of char values as the specified sequence." );
		setReturnType( "Public", "boolean" );
		addParam( "CharSequence", "cs" );
		setReturns( "true if this String represents the same sequence of char values as the specified sequence, false otherwise." );
	}
}

class strEqualsIgnoreCase extends stringMethod {
	strEqualsIgnoreCase() {
		setName( "equalsIgnoreCase" );
		setDesc( "Compares this String to another String, ignoring case considerations. Two strings are considered equal ignoring case if they are of the same length and corresponding characters in the two strings are equal ignoring case." );
		setReturnType( "Public", "boolean" );
		addParam( "String", "anotherString" );
		setReturns( "true if the argument is not null and it represents an equivalent String ignoring case; false otherwise." );
	}
}

class strCompareTo extends stringMethod {
	strCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. The character sequence represented by this String object is compared lexicographically to the character sequence represented by the argument string. The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true." );
		setReturnType( "Public", "int" );
		addParam( "String", "anotherString" );
		setReturns( "the value 0 if the argument string is equal to this string; a value less than 0 if this string is lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically greater than the string argument." );
	}
}

class strCompareToIgnoreCase extends stringMethod {
	strCompareToIgnoreCase() {
		setName( "compareToIgnoreCase" );
		setDesc( "Compares two strings lexicographically, ignoring case differences. This method returns an integer whose sign is that of calling compareTo with normalized versions of the strings where case differences have been eliminated by calling Character.toLowerCase(Character.toUpperCase(character)) on each character." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "a negative integer, zero, or a positive integer as the specified String is greater than, equal to, or less than this String, ignoring case considerations." );
	}
}

class strRegionMatches extends stringMethod {
	strRegionMatches() {
		setName( "regionMatches" );
		setDesc( "A substring of this String object is compared to a substring of the argument other. The result is true if these substrings represent identical character sequences. The substring of this String object to be compared begins at index toffset and has length len. The substring of other to be compared begins at index ooffset and has length len." );
		setReturnType( "Public", "boolean" );
		addParam( "int", "toffset" );
		addParam( "String", "other" );
		addParam( "int", "ooffset" );
		addParam( "int", "len" );
		setReturns( "true if the specified subregion of this string exactly matches the specified subregion of the string argument; false otherwise." );
	}
}

class strRegionMatches2 extends stringMethod {
	strRegionMatches2() {
		setName( "regionMatches" );
		setDesc( "A substring of this String object is compared to a substring of the argument other. The result is true if these substrings represent character sequences that are the same, ignoring case if and only if ignoreCase is true. The substring of this String object to be compared begins at index toffset and has length len. The substring of other to be compared begins at index ooffset and has length len." );
		setReturnType( "Public", "boolean" );
		addParam( "boolean", "ignoreCase" );
		addParam( "int", "toffset" );
		addParam( "int", "ooffset" );
		addParam( "String", "other" );
		addParam( "int", "len" );
		setReturns( "true if the specified subregion of this string matches the specified subregion of the string argument; false otherwise. Whether the matching is exact or case insensitive depends on the ignoreCase argument." );
	}
}

class strStartsWith extends stringMethod {
	strStartsWith() {
		setName( "startsWith" );
		setDesc( "Tests if the substring of this string beginning at the specified index starts with the specified prefix." );
		setReturnType( "Public", "boolean" );
		addParam( "String", "prefix" );
		addParam( "int", "toffset" );
		setReturns( "true if the character sequence represented by the argument is a prefix of the substring of this object starting at index toffset; false otherwise. The result is false if toffset is negative or greater than the length of this String object." );
	}
}

class strStartsWith2 extends stringMethod {
	strStartsWith2() {
		setName( "startsWith" );
		setDesc( "Tests if this string starts with the specified prefix." );
		setReturnType( "Public", "boolean" );
		addParam( "String", "prefix" );
		setReturns( "true if the character sequence represented by the argument is a prefix of the character sequence represented by this string; false otherwise. Note also that true will be returned if the argument is an empty string or is equal to this String object as determined by the equals(Object) method." );
	}
}
class strEndsWith extends stringMethod {
	strEndsWith() {
		setName( "endsWith" );
		setDesc( "Tests if this string ends with the specified suffix." );
		setReturnType( "Public", "boolean" );
		addParam( "String", "suffix" );
		setReturns( "true if the character sequence represented by the argument is a suffix of the character sequence represented by this object; false otherwise. Note that the result will be true if the argument is the empty string or is equal to this String object as determined by the equals(Object) method." );
	}
}

class strHashCode extends stringMethod {
	strHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this string." );
		setReturnType( "Public", "int" );
		setReturns( "a hashCode in class Object." );
	}
}

class strIndexOf extends stringMethod {
	strIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified character. If a character with value ch occurs in the character sequence represented by this String object, then the index (in Unicode code units) of the first such occurrence is returned." );
		setReturnType( "Public", "int" );
		addParam( "int", "ch" );
		setReturns( "the index of the first occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur." );
	}
}

class strIndexOf2 extends stringMethod {
	strIndexOf2() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index." );
		setReturnType( "Public", "int" );
		addParam( "int", "ch" );
		addParam( "int", "fromIndex" );
		setReturns( "the index of the first occurrence of the character in the character sequence represented by this object that is greater than or equal to fromIndex, or -1 if the character does not occur." );
	}
}

class strIndexOf3 extends stringMethod {
	strIndexOf3() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "the index of the first occurrence of the specified substring, or -1 if there is no such occurrence." );
	}
}

class strIndexOf4 extends stringMethod {
	strIndexOf4() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring, starting at the specified index." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		addParam( "int", "fromIndex" );
		setReturns( "the index of the first occurrence of the specified substring, starting at the specified index, or -1 if there is no such occurrence." );
	}
}

class strLastIndexOf extends stringMethod {
	strLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified character." );
		setReturnType( "Public", "int" );
		addParam( "int", "ch" );
		setReturns( "the index of the last occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur." );
	}
}

class strLastIndexOf2 extends stringMethod {
	strLastIndexOf2() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index." );
		setReturnType( "Public", "int" );
		addParam( "int", "ch" );
		addParam( "int", "fromIndex" );
		setReturns( "the index of the last occurrence of the character in the character sequence represented by this object that is less than or equal to fromIndex, or -1 if the character does not occur before that point." );
	}
}

class strLastIndexOf3 extends stringMethod {
	strLastIndexOf3() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified substring." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "the index of the last occurrence of the specified substring, or -1 if there is no such occurrence." );
	}
}

class strLastIndexOf4 extends stringMethod {
	strLastIndexOf4() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		addParam( "int", "fromIndex" );
		setReturns( "the index of the last occurrence of the specified substring, searching backward from the specified index, or -1 if there is no such occurrence." );
	}
}

class strLength extends stringMethod {
	strLength() {
		setName( "length" );
		setDesc( "Returns the length of this string.");
		setReturnType( "Public", "int" );
		setReturns( "the length of the sequence of characters represented by this object." );
	}
}

class strSubstring extends stringMethod {
	strSubstring() {
		setName( "substring" );
		setDesc( "Returns a new string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string." );
		setReturnType( "Public", "String" );
		addParam( "int", "beginIndex" );
		setReturns( "the specified substring." );
	}
}

class strSubstring2 extends stringMethod {
	strSubstring2() {
		setName( "substring" );
		setDesc( "Returns a new string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex." );
		setReturnType( "Public", "String" );
		addParam( "int", "beginIndex" );
		addParam( "int", "endIndex" );
		setReturns( "the specified substring." );
	}
}

class strSubSequence extends stringMethod {
	strSubSequence() {
		setName( "subSequence" );
		setDesc( "Returns a new character sequence that is a subsequence of this sequence." );
		setReturnType( "Public", "CharSequence" );
		addParam( "int", "beginIndex" );
		addParam( "int", "endIndex" );
		setReturns( "the specified subsequence." );
	}
}

class strConcat extends stringMethod {
	strConcat() {
		setName( "concat" );
		setDesc( "Concatenates the specified string to the end of this string." );
		setReturnType( "Public", "String" );
		addParam( "String", "str" );
		setReturns( "a string that represents the concatenation of this object's characters followed by the string argument's characters." );
	}
}

class strReplace extends stringMethod {
	strReplace() {
		setName( "replace" );
		setDesc( "Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar." );
		setReturnType( "Public", "String" );
		addParam( "char", "oldChar" );
		addParam( "char", "newChar" );
		setReturns( "a string derived from this string by replacing every occurrence of oldChar with newChar." );
	}
}

class strMatches extends stringMethod {
	strMatches() {
		setName( "matches" );
		setDesc( "Tells whether or not this string matches the given regular expression." );
		setReturnType( "Public", "boolean" );
		addParam( "String", "regex" );
		setReturns( "true if, and only if, this string matches the given regular expression." );
	}
}

class strContains extends stringMethod {
	strContains() {
		setName( "contains" );
		setDesc( "Returns true if and only if this string contains the specified sequence of char values." );
		setReturnType( "Public", "boolean" );
		addParam( "CharSequence", "s" );
		setReturns( "true if this string contains s, false otherwise." );
	}
}

class strReplaceFirst extends stringMethod {
	strReplaceFirst() {
		setName( "replaceFirst" );
		setDesc( "Replaces the first substring of this string that matches the given regular expression with the given replacement." );
		setReturnType( "Public", "String" );
		addParam( "String", "regex" );
		addParam( "String", "replacement" );
		setReturns( "the resulting String." );
	}
}

class strReplaceAll extends stringMethod {
	strReplaceAll() {
		setName( "replaceAll" );
		setDesc( "Replaces each substring of this string that matches the given regular expression with the given replacement." );
		setReturnType( "Public", "String." );
		addParam( "String", "regex" );
		addParam( "String", "replacement" );
		setReturns( "The resulting String." );
	}
}

class strReplace2 extends stringMethod {
	strReplace2() {
		setName( "replace" );
		setDesc( "Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence. The replacement proceeds from the beginning of the string to the end, for example, replacing 'aa' with 'b' in the string 'aaa' will result in 'ba' rather than 'ab'." );
		setReturnType( "Public", "String" );
		addParam( "CharSequence", "target" );
		addParam( "CharSequence", "replacement" );
		setReturns( "The resulting String." );
	}
}

class strSplit extends stringMethod {
	strSplit() {
		setName( "split" );
		setDesc( "Splits this string around matches of the given regular expression." );
		setReturnType( "Public", "String[]" );
		addParam( "String", "regex" );
		addParam( "int", "limit" );
		setReturns( "the array of strings computed by splitting this string around matches of the given regular expression." );
	}
}

class strSplit2 extends stringMethod {
	strSplit2() {
		setName( "split2" );
		setDesc( "Splits this string around matches of the given regular expression." );
		setReturnType( "Public", "String[]" );
		addParam( "String", "regex" );
		setReturns( "the array of strings computed by splitting this string around matches of the given regular expression." );
	}
}

class strToLowerCase extends stringMethod {
	strToLowerCase() {
		setName( "toLowerCase" );
		setDesc( "Converts all of the characters in this String to lower case using the rules of the given Locale. Case mapping is based on the Unicode Standard version specified by the Character class. Since case mappings are not always 1:1 char mappings, the resulting String may be a different length than the original String." );
		setReturnType( "Public", "String" );
		addParam( "Locale", "locale" );
		setReturns( "the String, converted to lowercase." );
	}
}

class strToLowerCase2 extends stringMethod {
	strToLowerCase2() {
		setName( "toLowerCase" );
		setDesc( "Converts all of the characters in this String to lower case using the rules of the default locale. This is equivalent to calling toLowerCase(Locale.getDefault())." );
		setReturnType( "Public", "String" );
		setReturns( "the String, converted to lowercase." );
	}
}

class strToUpperCase extends stringMethod {
	strToUpperCase() {
		setName( "toUpperCase" );
		setDesc( "Converts all of the characters in this String to upper case using the rules of the given Locale. Case mapping is based on the Unicode Standard version specified by the Character class. Since case mappings are not always 1:1 char mappings, the resulting String may be a different length than the original String." );
		setReturnType( "Public", "String" );
		addParam( "Locale", "locale" );
		setReturns( "the String, converted to lowercase." );
	}
}

class strToUpperCase2 extends stringMethod {
	strToUpperCase2() {
		setName( "toUpperCase" );
		setDesc( "Converts all of the characters in this String to upper case using the rules of the default locale. This method is equivalent to toUpperCase(Locale.getDefault())." );
		setReturnType( "Public", "String" );
		setReturns( "the String, converted to uppercase." );
	}
}

class strTrim extends stringMethod {
	strTrim() {
		setName( "trim" );
		setDesc( "Returns a copy of the string, with leading and trailing whitespace omitted." );
		setReturnType( "Public", "String" );
		setReturns( "A copy of this string with leading and trailing white space removed, or this string if it has no leading or trailing white space." );
	}
}

class strToString extends stringMethod {
	strToString() {
		setName( "toString" );
		setDesc( "This object (which is already a string!) is itself returned." );
		setReturnType( "Public", "String" );
		setReturns( "the string itself." );
	}
}

class strToCharArray extends stringMethod {
	strToCharArray() {
		setName( "toCharArray" );
		setDesc( "Converts this string to a new character array." );
		setReturnType( "Public", "char[]" );
		setReturns( "a newly allocated character array whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string." );
	}
}

class strFormat extends stringMethod {
	strFormat() {
		setName( "format" );
		setDesc( "Returns a formatted string using the specified format string and arguments." );
		setReturnType( "Static", "String" );
		addParam( "String", "format" );
		addParam( "Object...", "args" );
		setReturns( "A formatted string" );
	}
}

class strFormat2 extends stringMethod {
	strFormat2() {
		setName( "format" );
		setDesc( "Returns a formatted string using the specified locale, format string, and arguments." );
		setReturnType( "Static", "String" );
		addParam( "Locale", "l" );
		addParam( "String", "format" );
		addParam( "Object...", "args" );
		setReturns( "A formatted string." );
	}
}

class strValueOf extends stringMethod {
	strValueOf() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the Object argument." );
		setReturnType( "Static", "String" );
		addParam( "Object", "obj" );
		setReturns( "if the argument is null, then a string equal to 'null'; otherwise, the value of obj.toString() is returned." );
	}
}

class strValueOf2 extends stringMethod {
	strValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the char array argument. The contents of the character array are copied; subsequent modification of the character array does not affect the newly created string." );
		setReturnType( "Static", "String" );
		addParam( "char[]", "data" );
		setReturns( "a newly allocated string representing the same sequence of characters contained in the character array argument." );
	}
}

class strValueOf3 extends stringMethod {
	strValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of a specific subarray of the char array argument." );
		setReturnType( "Static", "String" );
		addParam( "char[]", "data" );
		addParam( "int", "offset" );
		addParam( "int", "count" );
		setReturns( "a string representing the sequence of characters contained in the subarray of the character array argument." );
	}
}

class strValueOf4 extends stringMethod {
	strValueOf4() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the boolean argument." );
		setReturnType( "Static", "String" );
		addParam( "boolean", "b" );
		setReturns( "if the argument is true, a string equal to 'true' is returned; otherwise, a string equal to 'false' is returned." );
	}
}

class strValueOf5 extends stringMethod {
	strValueOf5() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the char argument. The contents of the character array are copied; subsequent modification of the character array does not affect the newly created string." );
		setReturnType( "Static", "String" );
		addParam( "char", "c" );
		setReturns( "a string of length 1 containing as its single character the argument c." );
	}
}

class strValueOf6 extends stringMethod {
	strValueOf6() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of a specific subarray of the int argument." );
		setReturnType( "Static", "String" );
		addParam( "int", "i" );
		setReturns( "a string representation of the int argument." );
	}
}

class strValueOf7 extends stringMethod {
	strValueOf7() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the long argument." );
		setReturnType( "Static", "String" );
		addParam( "long", "l" );
		setReturns( "a string representation of the long argument." );
	}
}

class strValueOf8 extends stringMethod {
	strValueOf8() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the float argument. The contents of the character array are copied; subsequent modification of the character array does not affect the newly created string." );
		setReturnType( "Static", "String" );
		addParam( "Float", "f" );
		setReturns( "a string representation of the float argument." );
	}
}

class strValueOf9 extends stringMethod {
	strValueOf9() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of a specific subarray of the double argument." );
		setReturnType( "Static", "String" );
		addParam( "Double", "d" );
		setReturns( "a string representation of the double argument." );
	}
}

class strCopyValueOf extends stringMethod {
	strCopyValueOf() {
		setName( "copyValueOf" );
		setDesc( "Returns a String that represents the character sequence in the array specified." );
		setReturnType( "Static", "String" );
		addParam( "char[]", "data" );
		addParam( "int", "offset" );
		addParam( "int", "count" );
		setReturns( "a String that contains the characters of the specified subarray of the character array." );
	}
}

class strCopyValueOf2 extends stringMethod {
	strCopyValueOf2() {
		setName( "copyValueOf" );
		setDesc( "Returns a String that represents the character sequence in the array specified." );
		setReturnType( "Static", "String" );
		addParam( "char[]", "data" );
		setReturns( "a String that contains the characters of the character array." );
	}
}

class strIntern extends stringMethod {
	strIntern() {
		setName( "intern" );
		setDesc( "Returns a canonical representation for the string object." );
		setReturnType( "Public", "String" );
		setReturns( "a string that has the same contents as this string, but is guaranteed to be from a pool of unique strings." );
	}
}


/*************************************************************
************************FLOAT METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class floatConstructor extends Constructor {
	floatConstructor() { 
		setName( "Float" );
		setEnclosingClass( "Float" );
	}
}

class Float1 extends floatConstructor {
	Float1() {
		setDesc( "Constructs a newly allocated Float object that represents the argument converted to type float." );
		addParam( "Double", "value" );
	}
}

class Float2 extends floatConstructor {
	Float2() {
		setDesc( "Constructs a newly allocated Float object that represents the primitive float argument." );
		addParam( "Float", "value" );
	}
}

class Float3 extends floatConstructor {
	Float3() {
		setDesc( "Constructs a newly allocated Float object that represents the floating-point value of type float represented by the string." );
		addParam( "String", "s" );
	}
}

/**************************METHODS**************************/

abstract class floatMethod extends Method {
	floatMethod() {
		setEnclosingClass( "Float" );
	}
}

class floatByteValue extends floatMethod {
	floatByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Float as a byte (by casting to a byte)." );
		setReturnType( "Public", "byte" );
		setReturns( "the float value represented by this object converted to type byte." );
	}
}

class floatCompare extends floatMethod {
	floatCompare() {
		setName( "compare" );
		setDesc( "Compares the two specified float values. The sign of the integer value returned is the same as that of the integer that would be returned by the call." );
		addParam( "Float", "f1" );
		addParam( "Float", "f2" );
		setReturnType( "Static", "int" );
		setReturns( "the value 0 if f1 is numerically equal to f2; a value less than 0 if f1 is numerically less than f2; and a value greater than 0 if f1 is numerically greater than f2." );
	}
}

class floatCompareTo extends floatMethod {
	floatCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Float objects numerically." );
		addParam( "Float", "anotherFloat" );
		setReturnType( "Public", "int" );
		setReturns( "the value 0 if anotherFloat is numerically equal to this Float; a value less than 0 if this Float is numerically less than anotherFloat; and a value greater than 0 if this Float is numerically greater than anotherFloat." );
	}
}

class floatDoubleValue extends floatMethod {
	floatDoubleValue() {
		setName( "doubleValue");
		setDesc( "Returns the double value of this Float object." );
		setReturnType( "Public", "double" );
		setReturns( "the float value represented by this object is converted to type double and the result of the conversion is returned." );
	}
	
	
}

class floatEquals extends floatMethod {
	floatEquals() {
		setName( "equals" );
		setDesc( "Compares this object against the specified object. The result is true if and only if the argument is not null and is a Float object that represents a float that has the same value as the float represented by this object. For this purpose, two float values are considered to be the same if and only if the method floatToLongBits(float) returns the identical long value when applied to each." );
		addParam( "Object", "obj" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class floatFloatToIntBits extends floatMethod {
	floatFloatToIntBits() {
		setName( "floatToIntBits" );
		setDesc( "Returns a representation of the specified floating-point value according to the IEEE 754 floating-point \"single format\" bit layout." );
		addParam( "Float", "value");
		setReturnType( "Static", "int" );
		setReturns( "the bits that represent the floating-point number." );
	}
}

class floatFloatToRawIntBits extends floatMethod {
	floatFloatToRawIntBits() {
		setName( "floatToRawIntBits" );
		setDesc( "Returns a representation of the specified floating-point value according to the IEEE 754 floating-point \"single format\" bit layout, preserving Not-a-Number (NaN) values." );
		addParam( "Float", "value");
		setReturnType( "Static", "int" );
		setReturns( "the bits that represent the floating-point number." );
	}
}

class floatFloatValue extends floatMethod {
	floatFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the float value of this Float object." );
		setReturnType( "Public", "float" );
		setReturns( "the float value represented by this object converted to type float." );
	}
}

class floatHashCode extends floatMethod {
	floatHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Float object. The result is the exclusive OR of the two halves of the long integer bit representation, exactly as produced by the method floatToLongBits(float), of the primitive float value represented by this Float object." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class floatIntBitsToFloat extends floatMethod {
	floatIntBitsToFloat() {
		setName( "intBitsToFloat" );
		setDesc( "Returns the float value corresponding to a given bit representation. The argument is considered to be a representation of a floating-point value according to the IEEE 754 floating-point \"single format\" bit layout." );
		addParam( "int", "bits" );
		setReturnType( "Static", "float" );
		setReturns( "the float floating-point value with the same bit pattern." );
	}
}

class floatIntValue extends floatMethod {
	floatIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Float as an int (by casting to type int)." );
		setReturnType( "Public", "int" );
		setReturns( "the float value represented by this object converted to type int." );
	}
}

class floatIsInfinite extends floatMethod {
	floatIsInfinite() {
		setName( "isInfinite" );
		setDesc( "Returns true if this Float value is infinitely large in magnitude, false otherwise." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the value represented by this object is positive infinity or negative infinity; false otherwise." );
	}
}

class floatIsInfinite2 extends floatMethod {
	floatIsInfinite2() {
		setName( "isInfinite" );
		setDesc( "Returns true if the specified number is infinitely large in magnitude, false otherwise." );
		addParam( "Float", "v" );
		setReturnType( "Static", "boolean" );
		setReturns( "true if the value of the argument is positive infinity or negative infinity; false otherwise." );
	}
}

class floatIsNaN extends floatMethod {
	floatIsNaN() {
		setName( "isNaN" );
		setDesc( "Returns true if this Float value is a Not-a-Number (NaN), false otherwise." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the value represented by this object is NaN; false otherwise." );
	}
}

class floatIsNaN2 extends floatMethod {
	floatIsNaN2() {
		setName( "isNaN" );
		setDesc( "Returns true if the specified number is a Not-a-Number (NaN) value, false otherwise." );
		addParam( "Float", "v" );
		setReturnType( "Static", "boolean" );
		setReturns( "true if the value of the argument is NaN; false otherwise." );
	}
}

class floatLongValue extends floatMethod {
	floatLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Float as a long (by casting to type long)." );
		setReturnType( "Public", "long" );
		setReturns( "the float value represented by this object converted to type long." );
	}
}

class floatParseFloat extends floatMethod {
	floatParseFloat() {
		setName( "parseFloat" );
		setDesc( "Returns a new float initialized to the value represented by the specified String, as performed by the valueOf method of class Float." );
		addParam( "String", "s" );
		setReturnType( "Static", "float" );
		setReturns( "the float value represented by the string argument." );
	}
}

class floatShortValue extends floatMethod {
	floatShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Float as a short (by casting to a short)." );
		setReturnType( "Public", "short" );
		setReturns( "the float value represented by this object converted to type short." );
	}
}

class floatToHexString extends floatMethod {
	floatToHexString() {
		setName( "toHexString" );
		setDesc( "Returns a hexadecimal string representation of the float argument. All characters mentioned below are ASCII characters." );
		addParam( "Float", "f" );
		setReturnType( "Static", "String" );
		setReturns( "a hex string representation of the argument." );
	}
}

class floatToString extends floatMethod {
	floatToString() {
		setName( "toString" );
		setDesc( "Returns a string representation of this Float object. The primitive float value represented by this object is converted to a string exactly as if by the method toString of one argument." );
		setReturnType( "Public", "String" );
		setReturns( "a String representation of this object." );
	}
}

class floatToString2 extends floatMethod {
	floatToString2() {
		setName( "toString" );
		setDesc( "Returns a string representation of the Float object." );
		addParam( "Float", "f" );
		setReturnType( "Public", "String" );
		setReturns( "a String representation of the argument." );
	}
}

class floatValueOf extends floatMethod {
	floatValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Float instance representing the specified double value. If a new Float instance is not required, this method should generally be used in preference to the constructor Float(float), as this method is likely to yield significantly better space and time performance by caching frequently requested values." );
		addParam( "Float", "f" );
		setReturnType( "Static", "Float" );
		setReturns( "a Float instance representing 'f'." );
	}
}

class floatValueOf2 extends floatMethod {
	floatValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns a Float object holding the float value represented by the argument string s." );
		addParam( "String", "s" );
		setReturnType( "Static", "Float" );
		setReturns( "a Float object holding the value represented by the String argument." );
	}
}

/*************************************************************
************************Big METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class dateConstructor extends Constructor {
	dateConstructor() { 
		setName( "Date" );
		setEnclosingClass( "Date" );
	}
}

class Date1 extends dateConstructor {
	Date1() {
		setDesc( "Constructs a Date object using the given milliseconds time value." );
		addParam( "Long", "date");
	}
}

/**************************METHODS**************************/

abstract class dateMethod extends Method {
	dateMethod() {
		setEnclosingClass( "Date" );
	}
}

class dateAfter extends dateMethod {
	dateAfter() {
		setName( "after" );
		setDesc( "Tests if this date is after the specified date." );
		addParam( "Date", "when" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if and only if the instant represented by this Date object is strictly later than the instant represented by when; false otherwise." );
	}
}

class dateBefore extends dateMethod {
	dateBefore() {
		setName( "before" );
		setDesc( "Tests if this date is before the specified date." );
		addParam( "Date", "when" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if and only if the instant represented by this Date object is strictly before than the instant represented by when; false otherwise." );
	}
}

class dateClone extends dateMethod {
	dateClone() {
		setName( "clone" );
		setDesc( "Return a copy of this object." );
		setReturnType( "Public", "Object" );
		setReturns( "a clone of this instance." );
	}
}

class dateCompareTo extends dateMethod {
	dateCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Dates for ordering." );
		addParam( "Date", "anotherDate" );
		setReturnType( "Public", "int" );
		setReturns( "the value 0 if the argument Date is equal to this Date; a value less than 0 if this Date is before the Date argument; and a value greater than 0 if this Date is after the Date argument." );
	}
}

class dateEquals extends dateMethod {
	dateEquals() {
		setName( "equals" );
		setDesc( "Compares two dates for equality. The result is true if and only if the argument is not null and is a Date object that represents the same point in time, to the millisecond, as this object." );
		addParam( "Object", "obj" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class dateGetTime extends dateMethod {
	dateGetTime() {
		setName( "getTime" );
		setDesc( "Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object." );
		setReturnType( "Public", "long" );
		setReturns( "the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this date." );
	}
}

class dateHashCode extends dateMethod {
	dateHashCode() {
		setName( "hashcode" );
		setDesc( "Returns a hash code value for this object. The result is the exclusive OR of the two halves of the primitive long value returned by the getTime() method." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class dateSetTime extends dateMethod {
	dateSetTime() {
		setName( "setTime" );
		setDesc( "Sets this Date object to represent a point in time that is time milliseconds after January 1, 1970 00:00:00 GMT." );
		addParam( "long", "time" );
		setReturnType( "Public", "void" );
	}
}

class dateToString extends dateMethod {
	dateToString() {
		setName( "toString" );
		setDesc( "Converts this Date object to a String of the form: \"(dow mon dd hh:mm:ss zzz yyyy)\" where 'dow' means 'day of week', 'mon' is 'month', 'dd' is 'day of the month', 'hh' is the 'hour of the day', 'mm' is the 'minute within the hour', 'ss' is the 'second within the minute', 'zzz' is the 'time zone', and 'yyyy' is the 'year'." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of this date." );
	}
}

/*************************************************************
******************ATOMICINTEGER METHODS***********************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class ATIConstructor extends Constructor {
	ATIConstructor() {
		setName( "AtomicInteger" );
		setEnclosingClass( "AtomicInteger" );
	}
}

class AtomicInteger1 extends ATIConstructor {
	AtomicInteger1() { 
		setDesc( "Creates a new AtomicInteger with initial value 0." );
	}
}

class AtomicInteger2 extends ATIConstructor {
	AtomicInteger2() { 
		setDesc( "Creates a new AtomicInteger with the given initial value." );
		addParam( "int", "initialValue" );
	}
}

/**************************METHODS**************************/

abstract class ATIMethod extends Method {
	ATIMethod() {
		setEnclosingClass( "AtomicInteger" );
	}
}

class atiAddAndGet extends ATIMethod {
	atiAddAndGet() {
		setName( "addAndGet" );
		setDesc( "Atomically adds the given value to the current value." );
		addParam( "int", "delta" );
		setReturnType( "Public Final", "int" );
		setReturns( "the updated value" );
	}
}

class atiCompareAndSet extends ATIMethod {
	atiCompareAndSet() {
		setName( "compareAndSet" );
		setDesc( "Atomically sets the value to the given updated value if the current value == the expected value." );
		addParam( "int", "expect" );
		addParam( "int", "update" );
		setReturnType( "Public Final", "boolean" );
		setReturns( "true if successful. False return indicates that the actual value was not equal to the expected value." );
	}
}

class atiDecrementAndGet extends ATIMethod {
	atiDecrementAndGet() {
		setName( "decrementAndGet" );
		setDesc( "Atomically decrements by one the current value." );
		setReturnType( "Public Final", "int" );
		setReturns( "the updated value." );
	}
}

class atiDoubleValue extends ATIMethod {
	atiDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of the specified number as a double." );
		setReturnType( "Public", "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class atiFloatValue extends ATIMethod {
	atiFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of the specified number as a float." );
		setReturnType( "Public", "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class atiGet extends ATIMethod {
	atiGet() {
		setName( "get" );
		setDesc( "Gets the current value." );
		setReturnType( "Public Final", "int" );
		setReturns( "the current value." );
	}
}

class atiGetAndAdd extends ATIMethod {
	atiGetAndAdd() {
		setName( "getAndAdd" );
		setDesc( "Atomically adds the given value to the current value." );
		addParam( "int", "delta" );
		setReturnType( "Public Final", "int" );
		setReturns( "the previous value." );
	}
}

class atiGetAndDecrement extends ATIMethod {
	atiGetAndDecrement() {
		setName( "getAndDecrement" );
		setDesc( "Atomically decrements by one the current value." );
		setReturnType( "Public Final", "int" );
		setReturns( "the previous value." );
	}
}

class atiGetAndIncrement extends ATIMethod {
	atiGetAndIncrement() {
		setName( "getAndDecrement" );
		setDesc( "Atomically increments by one the current value." );
		setReturnType( "Public Final", "int" );
		setReturns( "the previous value." );
	}
}

class atiGetAndSet extends ATIMethod {
	atiGetAndSet() {
		setName( "getAndSet" );
		setDesc( "Atomically sets to the given value and returns the old value." );
		addParam( "int", "newValue" );
		setReturnType( "Public Final", "int" );
		setReturns( "the previous value." );
	}
}

class atiIncrementAndGet extends ATIMethod {
	atiIncrementAndGet() {
		setName( "IncrementAndGet" );
		setDesc( "Atomically increments by one the current value." );
		setReturnType( "Public Final", "int" );
		setReturns( "the updated value." );
	}
}

class atiIntValue extends ATIMethod {
	atiIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of the specified number as an int." );
		setReturnType( "Public", "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class atiLazySet extends ATIMethod {
	atiLazySet() {
		setName( "lazySet" );
		setDesc( "Eventually sets to the given value." );
		addParam( "int", "newValue" );
		setReturnType( "Public Final", "void" );
	}
}

class atiLongValue extends ATIMethod {
	atiLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of the specified number as a long." );
		setReturnType( "Public", "long" );
		setReturns( "the numeric value represented by this object after conversion to type long." );
	}
}

class atiSet extends ATIMethod {
	atiSet() {
		setName( "set" );
		setDesc( "Sets to the given value." );
		addParam( "int", "newValue" );
		setReturnType( "Public Final", "void" );
	}
}

class atiToString extends ATIMethod {
	atiToString() {
		setName( "toString" );
		setDesc( "Returns the String representation of the current value." );
		setReturnType( "Public", "String" );
		setReturns( "the String representation of the current value." );
	}
}

class atiWeakCompareAndSet extends ATIMethod {
	atiWeakCompareAndSet() {
		setName( "weakCompareAndSet" );
		setDesc( "Atomically sets the value to the given updated value if the current value == the expected value." );
		addParam( "int", "expect" );
		addParam( "int", "update" );
		setReturnType( "Public Final", "boolean" );
		setReturns( "'true' if successful." );
	}
}

/*************************************************************
********************ATOMICLONG METHODS************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class ATLConstructor extends Constructor {
	ATLConstructor() {
		setName( "AtomicLong" );
		setEnclosingClass( "AtomicLong" );
	}
}

class AtomicLong1 extends ATLConstructor {
	AtomicLong1() { 
		setDesc( "Creates a new AtomicLong with initial value 0." );
	}
}

class AtomicLong2 extends ATLConstructor {
	AtomicLong2() { 
		setDesc( "Creates a new AtomicLong with the given initial value." );
		addParam( "int", "initialValue" );
	}
}

/**************************METHODS**************************/

abstract class ATLMethod extends Method {
	ATLMethod() {
		setEnclosingClass( "AtomicLong" );
	}
}

class atlAddAndGet extends ATLMethod {
	atlAddAndGet() {
		setName( "addAndGet" );
		setDesc( "Atomically adds the given value to the current value." );
		addParam( "long", "delta" );
		setReturnType( "Public Final", "long" );
		setReturns( "the updated value" );
	}
}

class atlCompareAndSet extends ATLMethod {
	atlCompareAndSet() {
		setName( "compareAndSet" );
		setDesc( "Atomically sets the value to the given updated value if the current value == the expected value." );
		addParam( "long", "expect" );
		addParam( "long", "update" );
		setReturnType( "Public Final", "boolean" );
		setReturns( "true if successful. False return indicates that the actual value was not equal to the expected value." );
	}
}

class atlDecrementAndGet extends ATLMethod {
	atlDecrementAndGet() {
		setName( "decrementAndGet" );
		setDesc( "Atomically decrements by one the current value." );
		setReturnType( "Public Final", "long" );
		setReturns( "the updated value." );
	}
}

class atlDoubleValue extends ATLMethod {
	atlDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of the specified number as a double." );
		setReturnType( "Public", "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class atlFloatValue extends ATLMethod {
	atlFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of the specified number as a float." );
		setReturnType( "Public", "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class atlGet extends ATLMethod {
	atlGet() {
		setName( "get" );
		setDesc( "Gets the current value." );
		setReturnType( "Public Final", "long" );
		setReturns( "the current value." );
	}
}

class atlGetAndAdd extends ATLMethod {
	atlGetAndAdd() {
		setName( "getAndAdd" );
		setDesc( "Atomically adds the given value to the current value." );
		addParam( "long", "delta" );
		setReturnType( "Public Final", "long" );
		setReturns( "the previous value." );
	}
}

class atlGetAndDecrement extends ATLMethod {
	atlGetAndDecrement() {
		setName( "getAndDecrement" );
		setDesc( "Atomically decrements by one the current value." );
		setReturnType( "Public Final", "long" );
		setReturns( "the previous value." );
	}
}

class atlGetAndIncrement extends ATLMethod {
	atlGetAndIncrement() {
		setName( "getAndDecrement" );
		setDesc( "Atomically increments by one the current value." );
		setReturnType( "Public Final", "long" );
		setReturns( "the previous value." );
	}
}

class atlGetAndSet extends ATLMethod {
	atlGetAndSet() {
		setName( "getAndSet" );
		setDesc( "Atomically sets to the given value and returns the old value." );
		addParam( "long", "newValue" );
		setReturnType( "Public Final", "long" );
		setReturns( "the previous value." );
	}
}

class atlIncrementAndGet extends ATLMethod {
	atlIncrementAndGet() {
		setName( "IncrementAndGet" );
		setDesc( "Atomically increments by one the current value." );
		setReturnType( "Public Final", "long" );
		setReturns( "the updated value." );
	}
}

class atlIntValue extends ATLMethod {
	atlIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of the specified number as an int." );
		setReturnType( "Public", "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class atlLazySet extends ATLMethod {
	atlLazySet() {
		setName( "lazySet" );
		setDesc( "Eventually sets to the given value." );
		addParam( "long", "newValue" );
		setReturnType( "Public Final", "void" );
	}
}

class atlLongValue extends ATLMethod {
	atlLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of the specified number as a long." );
		setReturnType( "Public", "long" );
		setReturns( "the numeric value represented by this object after conversion to type long." );
	}
}

class atlSet extends ATLMethod {
	atlSet() {
		setName( "set" );
		setDesc( "Sets to the given value." );
		addParam( "long", "newValue" );
		setReturnType( "Public Final", "void" );
	}
}

class atlToString extends ATLMethod {
	atlToString() {
		setName( "toString" );
		setDesc( "Returns the String representation of the current value." );
		setReturnType( "Public", "String" );
		setReturns( "the String representatlon of the current value." );
	}
}

class atlWeakCompareAndSet extends ATLMethod {
	atlWeakCompareAndSet() {
		setName( "weakCompareAndSet" );
		setDesc( "Atomically sets the value to the given updated value if the current value == the expected value." );
		addParam( "long", "expect" );
		addParam( "long", "update" );
		setReturnType( "Public Final", "boolean" );
		setReturns( "'true' if successful." );
	}
}

/*************************************************************
**********************LONG METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class longConstructor extends Constructor {
	longConstructor() { 
		setName( "Long" );
		setEnclosingClass( "Long" );
	}
}

class Long1 extends longConstructor {
	Long1() {
		setDesc( "Constructs a newly allocated Long object that represents the specified long argument." );
		addParam( "long", "value" );
	}
}

class Long2 extends longConstructor {
	Long2() {
		setDesc( "Constructs a newly allocated Long object that represents the long value indicated by the String parameter." );
		addParam( "String", "s" );
	}
}

/**************************METHODS**************************/

abstract class longMethod extends Method {
	longMethod() {
		setEnclosingClass( "Long" );
	}
}

class longBitCount extends longMethod {
	longBitCount() {
		setName( "bitCount" );
		setDesc( "Returns the number of one-bits in the two's complement binary representation of the specified long value." );
		setReturnType( "Static", "int" );
		addParam( "long", "i" );
		setReturns( "the double value represented by this object converted to type byte." );
	}
}

class longByteValue extends longMethod {
	longByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Long as a byte." );
		setReturnType( "Public", "byte" );
		setReturns( "the numeric value represented by this object after conversion to type byte." );
	}
}

class longCompareTo extends longMethod {
	longCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Long objects numerically." );
		setReturnType( "Public", "int" );
		addParam( "Long", "anotherLong" );
		setReturns( "the value 0 if this Long is equal to the argument Long; a value less than 0 if this Long is numerically less than the argument Long; and a value greater than 0 if this Long is numerically greater than the argument Long (signed comparison)." );
	}
}

class longDecode extends longMethod {
	longDecode() {
		setName( "decode" );
		setDesc( "Decodes a String into a Long." );
		setReturnType( "Static", "Long" );
		addParam( "String", "nm" );
		setReturns( "a Long object holding the long value represented by nm" );
	}
}

class longDoubleValue extends longMethod {
	longDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of this Long as a double." );
		setReturnType( "Public", "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class  longEquals extends longMethod {
	longEquals() {
		setName( "equals" );
		setDesc( "Compares this object to the specified object." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "obj" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class  longFloatValue extends longMethod {
	longFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of this Long as a float." );
		setReturnType( "Public", "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class  longGetLong extends longMethod {
	longGetLong() {
		setName( "getLong" );
		setDesc( "Determines the long value of the system property with the specified name." );
		setReturnType( "Static", "Long" );
		addParam( "String", "nm" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class  longGetLong2 extends longMethod {
	longGetLong2() {
		setName( "getLong" );
		setDesc( "Determines the long value of the system property with the specified name." );
		setReturnType( "Static", "Long" );
		addParam( "String", "nm" );
		addParam( "long", "val" );
		setReturns( "the long value of the property." );
	}
}

class  longGetLong3 extends longMethod {
	longGetLong3() {
		setName( "getLong" );
		setDesc( "Returns the long value of the system property with the specified name." );
		setReturnType( "Static", "Long" );
		addParam( "String", "nm" );
		addParam( "Long", "val" );
		setReturns( "the long value of the property." );
	}
}

class longHashCode extends longMethod {
	longHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Long. The result is the exclusive OR of the two halves of the primitive long value held by this Long object." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class  longHighestOneBit extends longMethod {
	longHighestOneBit() {
		setName( "highestOneBit" );
		setDesc( "Returns a long value with at most a single one-bit, in the position of the highest-order ('leftmost') one-bit in the specified long value. Returns zero if the specified value has no one-bits in its two's complement binary representation, that is, if it is equal to zero." );
		setReturnType( "Static", "long" );
		addParam( "long", "i" );
		setReturns( "a long value with a single one-bit, in the position of the highest-order one-bit in the specified value, or zero if the specified value is itself equal to zero." );
	}
}

class  longIntValue extends longMethod {
	longIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Long as an int." );
		setReturnType( "Public", "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class  longLongValue extends longMethod {
	longLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Long as a long value." );
		setReturnType( "Public", "long" );
		setReturns( "the numeric value represented by this object after conversion to type long." );
	}
}

class  longLowestOneBit extends longMethod {
	longLowestOneBit() {
		setName( "lowestOneBit" );
		setDesc( "Returns a long value with at most a single one-bit, in the position of the lowest-order ('rightmost') one-bit in the specified long value." );
		setReturnType( "Static", "long" );
		addParam( "long", "i" );
		setReturns( "a long value with a single one-bit, in the position of the lowest-order one-bit in the specified value, or zero if the specified value is itself equal to zero." );
	}
}

class  longNumberOfLeadingZeros extends longMethod {
	longNumberOfLeadingZeros() {
		setName( "numberOfLeadingZeros" );
		setDesc( "Returns the number of zero bits preceding the highest-order (\"leftmost\") one-bit in the two's complement binary representation of the specified long value." );
		setReturnType( "Static", "int" );
		addParam( "long", "i" );
		setReturns( "the number of zero bits preceding the highest-order (\"leftmost\") one-bit in the two's complement binary representation of the specified long value, or 64 if the value is equal to zero." );
	}
}

class  longNumberOfTrailingZeros extends longMethod {
	longNumberOfTrailingZeros() {
		setName( "numberOfTrailingZeros" );
		setDesc( "Returns the number of zero bits following the lowest-order (\"rightmost\") one-bit in the two's complement binary representation of the specified long value." );
		setReturnType( "Static", "int" );
		addParam( "long", "i" );
		setReturns( "the number of zero bits following the lowest-order (\"rightmost\") one-bit in the two's complement binary representation of the specified long value, or 64 if the value is equal to zero." );
	}
}

class  longParseLong extends longMethod {
	longParseLong() {
		setName( "parseLong" );
		setDesc( "Parses the string argument as a signed decimal long." );
		setReturnType( "Static", "long" );
		addParam( "String", "s" );
		setReturns( "the long represented by the argument in decimal." );
	}
}

class  longParseLong2 extends longMethod {
	longParseLong2() {
		setName( "parseLong" );
		setDesc( "Parses the string argument as a signed long in the radix specified by the second argument." );
		setReturnType( "Static", "long" );
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturns( "the long represented by the string argument in the specified radix." );
	}
}

class  longReverse extends longMethod {
	longReverse() {
		setName( "reverse" );
		setDesc( "Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the specified long value." );
		setReturnType( "Static", "long" );
		addParam( "long", "i" );
		setReturns( "Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the specified long value." );
	}
}

class  longReverseBytes extends longMethod {
	longReverseBytes() {
		setName( "reverseBytes" );
		setDesc( "Returns the value obtained by reversing the order of the bytes in the two's complement representation of the specified long value." );
		setReturnType( "Static", "long" );
		addParam( "long", "i" );
		setReturns( "the value obtained by reversing the bytes in the specified long value." );
	}
}

class  longRotateLeft extends longMethod {
	longRotateLeft() {
		setName( "rotateLeft" );
		setDesc( "Returns the value obtained by rotating the two's complement binary representation of the specified long value left by the specified number of bits." );
		setReturnType( "Static", "long" );
		addParam( "long", "i" );
		addParam( "int", "distance" );
		setReturns( "the value obtained by rotating the two's complement binary representation of the specified long value left by the specified number of bits." );
	}
}

class  longRotateRight extends longMethod {
	longRotateRight() {
		setName( "rotateRight" );
		setDesc( "Returns the value obtained by rotating the two's complement binary representation of the specified long value right by the specified number of bits." );
		setReturnType( "Static", "long" );
		addParam( "long", "i" );
		addParam( "int", "distance" );
		setReturns( "the value obtained by rotating the two's complement binary representation of the specified long value right by the specified number of bits." );
	}
}

class  longShortValue extends longMethod {
	longShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Long as a short." );
		setReturnType( "Public", "short" );
		setReturns( "the numeric value represented by this object after conversion to type short." );
	}
}

class  longSignum extends longMethod {
	longSignum() {
		setName( "signum" );
		setDesc( "Returns the signum function of the specified long value." );
		setReturnType( "Static", "int" );
		addParam( "long", "i" );
		setReturns( "the signum function of the specified long value." );
	}
}

class  longToBinaryString extends longMethod {
	longToBinaryString() {
		setName( "toBinaryString" );
		setDesc( "Returns a string representation of the long argument as an unsigned integer in base 2." );
		setReturnType( "Static", "String" );
		addParam( "long", "i" );
		setReturns( "the string representation of the unsigned long value represented by the argument in binary (base 2)." );
	}
}

class  longToHexString extends longMethod {
	longToHexString() {
		setName( "toHexString" );
		setDesc( "Returns a string representation of the long argument as an unsigned integer in base 16." );
		setReturnType( "Static", "String" );
		addParam( "long", "i" );
		setReturns( "the string representation of the unsigned long value represented by the argument in hexadecimal (base 16)." );
	}
}

class  longToOctalString extends longMethod {
	longToOctalString() {
		setName( "toOctalString" );
		setDesc( "Returns a string representation of the long argument as an unsigned integer in base 8." );
		setReturnType( "Static", "String" );
		addParam( "long", "i" );
		setReturns( "the string representation of the unsigned long value represented by the argument in octal (base 8)." );
	}
}

class  longToString extends longMethod {
	longToString() {
		setName( "toString" );
		setDesc( "Returns a String object representing this Long's value." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of the value of this object in base 10." );
	}
}

class  longToString2 extends longMethod {
	longToString2() {
		setName( "toString" );
		setDesc( "Returns a String object representing the specified long." );
		setReturnType( "Static", "String" );
		addParam( "long", "i" );
		setReturns( "the long represented by the string argument in the specified radix." );
	}
}

class  longToString3 extends longMethod {
	longToString3() {
		setName( "toString" );
		setDesc( "Returns a string representation of the first argument in the radix specified by the second argument." );
		setReturnType( "Static", "String" );
		addParam( "long", "i" );
		addParam( "int", "radix" );
		setReturns( "a string representation of the argument in the specified radix." );
	}
}

class  longValueOf extends longMethod {
	longValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Long instance representing the specified long value." );
		setReturnType( "Static", "Long" );
		addParam( "long", "l" );
		setReturns( "a Long instance representing l." );
	}
}

class  longValueOf2 extends longMethod {
	longValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns a Long object holding the value of the specified String." );
		setReturnType( "Static", "Long" );
		addParam( "String", "s" );
		setReturns( "a Long object holding the value represented by the string argument." );
	}
}

class  longValueOf3 extends longMethod {
	longValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns a Long object holding the value extracted from the specified String when parsed with the radix given by the second argument." );
		setReturnType( "Static", "Long" );
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturns( "a Long object holding the value represented by the string argument in the specified radix." );
	}
}

/*************************************************************
**********************BIGDECIMAL METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class BigDConstructor extends Constructor {
	BigDConstructor() { 
		setName( "BigDecimal" );
		setEnclosingClass( "BigDecimal" );
	}
}

class BigDecimal1 extends BigDConstructor {
	BigDecimal1() {
		setDesc( "Translates a BigInteger into a BigDecimal. The scale of the BigDecimal is zero." );
		addParam( "BigInteger", "val" );
	}
}

class BigDecimal2 extends BigDConstructor {
	BigDecimal2() {
		setDesc( "Translates a BigInteger unscaled value and an int scale into a BigDecimal." );
		addParam( "BigInteger", "unscaledVal" );
		addParam( "int", "scale" );
	}
}

class BigDecimal3 extends BigDConstructor {
	BigDecimal3() {
		setDesc( "Translates a BigInteger unscaled value and an int scale into a BigDecimal, with rounding according to the context settings." );
		addParam( "BigInteger", "unscaledVal" );
		addParam( "int", "scale" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal4 extends BigDConstructor {
	BigDecimal4() {
		setDesc( "Translates a BigInteger into a BigDecimal rounding according to the context settings." );
		addParam( "BigInteger", "val" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal5 extends BigDConstructor {
	BigDecimal5() {
		setDesc( "Translates a character array representation of a BigDecimal into a BigDecimal, accepting the same sequence of characters as the BigDecimal(String) constructor." );
		addParam( "char[]", "in" );
	}
}

class BigDecimal6 extends BigDConstructor {
	BigDecimal6() {
		setDesc( "Translates a character array representation of a BigDecimal into a BigDecimal, accepting the same sequence of characters as the BigDecimal(String) constructor, while allowing a sub-array to be specified." );
		addParam( "char[]", "in" );
		addParam( "int", "offset" );
		addParam( "int", "len" );
	}
}

class BigDecimal7 extends BigDConstructor {
	BigDecimal7() {
		setDesc( "Translates a character array representation of a BigDecimal into a BigDecimal, accepting the same sequence of characters as the BigDecimal(String) constructor, while allowing a sub-array to be specified and with rounding according to the context settings." );
		addParam( "char[]", "in" );
		addParam( "int", "offset" );
		addParam( "int", "len" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal8 extends BigDConstructor {
	BigDecimal8() {
		setDesc( "Translates a character array representation of a BigDecimal into a BigDecimal, accepting the same sequence of characters as the BigDecimal(String) constructor and with rounding according to the context settings." );
		addParam( "char[]", "in" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal9 extends BigDConstructor {
	BigDecimal9() {
		setDesc( "Translates a double into a BigDecimal which is the exact decimal representation of the double's binary floating-point value." );
		addParam( "double", "val" );
	}
}

class BigDecimal10 extends BigDConstructor {
	BigDecimal10() {
		setDesc( "Translates a double into a BigDecimal, with rounding according to the context settings." );
		addParam( "double", "val" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal11 extends BigDConstructor {
	BigDecimal11() {
		setDesc( "Translates an int into a BigDecimal. The scale of the BigDecimal is zero." );
		addParam( "int", "val" );
	}
}

class BigDecimal12 extends BigDConstructor {
	BigDecimal12() {
		setDesc( "Translates an int into a BigDecimal, with rounding according to the context settings. The scale of the BigDecimal, before any rounding, is zero." );
		addParam( "int", "val" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal13 extends BigDConstructor {
	BigDecimal13() {
		setDesc( "Translates an long into a BigDecimal. The scale of the BigDecimal is zero." );
		addParam( "long", "val" );
	}
}

class BigDecimal14 extends BigDConstructor {
	BigDecimal14() {
		setDesc( "Translates a long into a BigDecimal, with rounding according to the context settings. The scale of the BigDecimal, before any rounding, is zero." );
		addParam( "long", "val" );
		addParam( "MathContext", "mc" );
	}
}

class BigDecimal15 extends BigDConstructor {
	BigDecimal15() {
		setDesc( "Translates the string representation of a BigDecimal into a BigDecimal. The string representation consists of an optional sign, '+' ('\u002B') or '-' ('\u002D'), followed by a sequence of zero or more decimal digits (\"the integer\"), optionally followed by a fraction, optionally followed by an exponent." );
		addParam( "String", "val" );
	}
}

class BigDecimal16 extends BigDConstructor {
	BigDecimal16() {
		setDesc( "Translates the string representation of a BigDecimal into a BigDecimal, accepting the same strings as the BigDecimal(String) constructor, with rounding according to the context settings." );
		addParam( "String", "val" );
		addParam( "MathContext", "mc" );
	}
}

/**************************METHODS**************************/

abstract class BigDMethod extends Method {
	BigDMethod() {
		setEnclosingClass( "BigDecimal" );
	}
}

class bdAbs extends BigDMethod {
	bdAbs() {
		setName( "abs" );
		setDesc( "Returns a BigDecimal whose value is the absolute value of this BigDecimal, and whose scale is this.scale()." );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "abs(this)." );
	}
}

class bdAbs2 extends BigDMethod {
	bdAbs2() {
		setName( "abs" );
		setDesc( "Returns a BigDecimal whose value is the absolute value of this BigDecimal, with rounding according to the context settings." );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "abs(this), rounded as necessary." );
	}
}

class bdAdd extends BigDMethod {
	bdAdd() {
		setName( "add" );
		setDesc( "Returns a BigDecimal whose value is (this + augend), and whose scale is max(this.scale(), augend.scale())." );
		addParam( "BigDecimal", "augend" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this + augend." );
	}
}

class bdAdd2 extends BigDMethod {
	bdAdd2() {
		setName( "add" );
		setDesc( "Returns a BigDecimal whose value is (this + augend), with rounding according to the context settings. If either number is zero and the precision setting is nonzero then the other number, rounded if necessary, is used as the result." );
		addParam( "BigDecimal", "augend" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this + augend, rounded as necessary." );
	}
}

class bdByteValueExact extends BigDMethod {
	bdByteValueExact() {
		setName( "byteValueExact" );
		setDesc( "Converts this BigDecimal to a byte, checking for lost information." );
		setReturnType( "Public", "byte" );
		setReturns( "this BigDecimal converted to an byte." );
	}
}

class bdCompareTo extends BigDMethod {
	bdCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares this BigDecimal with the specified BigDecimal. Two BigDecimal objects that are equal in value but have a different scale (like 2.0 and 2.00) are considered equal by this method. This method is provided in preference to individual methods for each of the six boolean comparison operators (<, ==, >, >=, !=, <=)." );
		addParam( "BigDecimal", "val" );
		setReturnType( "Public", "int" );
		setReturns( "-1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val." );
	}
}

class bdDivide extends BigDMethod {
	bdDivide() {
		setName( "divide" );
		setDesc( "Returns a BigDecimal whose value is (this / divisor), and whose preferred scale is (this.scale() - divisor.scale())." );
		addParam( "BigDecimal", "divisor" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this / divisor." );
	}
}

class bdDivide2 extends BigDMethod {
	bdDivide2() {
		setName( "divide" );
		setDesc( "Returns a BigDecimal whose value is (this / divisor), and whose scale is this.scale(). If rounding must be performed to generate a result with the given scale, the specified rounding mode is applied." );
		addParam( "BigDecimal", "divisor" );
		addParam( "int", "roundingMode" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this / divisor." );
	}
}

class bdDivide3 extends BigDMethod {
	bdDivide3() {
		setName( "divide" );
		setDesc( "Returns a BigDecimal whose value is (this / divisor), and whose scale is as specified. If rounding must be performed to generate a result with the specified scale, the specified rounding mode is applied." );
		addParam( "BigDecimal", "divisor" );
		addParam( "int", "scale" );
		addParam( "int", "roundingMode" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this / divisor." );
	}
}

class bdDivide4 extends BigDMethod {
	bdDivide4() {
		setName( "divide" );
		setDesc( "Returns a BigDecimal whose value is (this / divisor), and whose scale is as specified. If rounding must be performed to generate a result with the specified scale, the specified rounding mode is applied." );
		addParam( "BigDecimal", "divisor" );
		addParam( "int", "scale" );
		addParam( "RoundingMode", "roundingMode" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this / divisor." );
	}
}

class bdDivide5 extends BigDMethod {
	bdDivide5() {
		setName( "divide" );
		setDesc( "Returns a BigDecimal whose value is (this / divisor), with rounding according to the context settings." );
		addParam( "BigDecimal", "divisor" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this / divisor, rounded as necessary." );
	}
}

class bdDivide6 extends BigDMethod {
	bdDivide6() {
		setName( "divide" );
		setDesc( "Returns a BigDecimal whose value is (this / divisor), and whose scale is this.scale(). If rounding must be performed to generate a result with the given scale, the specified rounding mode is applied." );
		addParam( "BigDecimal", "divisor" );
		addParam( "RoundingMode", "roundingMode" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this / divisor." );
	}
}

class bdDivideAndRemainder extends BigDMethod {
	bdDivideAndRemainder() {
		setName( "divideAndRemainder" );
		setDesc( "Returns a two-element BigDecimal array containing the result of divideToIntegralValue followed by the result of remainder on the two operands." );
		addParam( "BigDecimal", "divisor" );
		setReturnType( "Public", "BigDecimal[]" );
		setReturns( "a two element BigDecimal array: the quotient (the result of divideToIntegralValue) is the initial element and the remainder is the final element." );
	}
}

class bdDivideAndRemainder2 extends BigDMethod {
	bdDivideAndRemainder2() {
		setName( "divideAndRemainder" );
		setDesc( "Returns a two-element BigDecimal array containing the result of divideToIntegralValue followed by the result of remainder on the two operands calculated with rounding according to the context settings." );
		addParam( "BigDecimal", "divisor" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal[]" );
		setReturns( "a two element BigDecimal array: the quotient (the result of divideToIntegralValue) is the initial element and the remainder is the final element." );
	}
}

class bdDivideToIntegralValue extends BigDMethod {
	bdDivideToIntegralValue() {
		setName( "divideToIntegralValue" );
		setDesc( "Returns a BigDecimal whose value is the integer part of the quotient (this / divisor) rounded down. The preferred scale of the result is (this.scale() - divisor.scale())." );
		addParam( "BigDecimal", "divisor" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "The integer part of this / divisor." );
	}
}

class bdDivideToIntegralValue2 extends BigDMethod {
	bdDivideToIntegralValue2() {
		setName( "divideToIntegralValue" );
		setDesc( "Returns a BigDecimal whose value is the integer part of (this / divisor). Since the integer part of the exact quotient does not depend on the rounding mode, the rounding mode does not affect the values returned by this method. The preferred scale of the result is (this.scale() - divisor.scale())." );
		addParam( "BigDecimal", "divisor" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "The integer part of this / divisor." );
	}
}

class bdDoubleValue extends BigDMethod {
	bdDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Converts this BigDecimal to a double. This conversion is similar to the narrowing primitive conversion from double to float as defined in the Java Language Specification: if this BigDecimal has too great a magnitude represent as a double, it will be converted to Double.NEGATIVE_INFINITY or Double.POSITIVE_INFINITY as appropriate. Note that even when the return value is finite, this conversion can lose information about the precision of the BigDecimal value." );
		setReturnType( "Public", "double" );
		setReturns( "this BigDecimal converted to a double." );
	}
}

class bdEquals extends BigDMethod {
	bdEquals() {
		setName( "equals" );
		setDesc( "Compares this BigDecimal with the specified Object for equality. Unlike compareTo, this method considers two BigDecimal objects equal only if they are equal in value and scale (thus 2.0 is not equal to 2.00 when compared by this method)." );
		addParam( "Object", "x" );
		setReturnType( "Public", "boolean" );
		setReturns( "true if and only if the specified Object is a BigDecimal whose value and scale are equal to this BigDecimal's." );
	}
}

class bdFloatValue extends BigDMethod {
	bdFloatValue() {
		setName( "floatValue" );
		setDesc( "Converts this BigDecimal to a float. This conversion is similar to the narrowing primitive conversion from double to float defined in the Java Language Specification: if this BigDecimal has too great a magnitude to represent as a float, it will be converted to Float.NEGATIVE_INFINITY or Float.POSITIVE_INFINITY as appropriate. Note that even when the return value is finite, this conversion can lose information about the precision of the BigDecimal value." );
		setReturnType( "Public", "float" );
		setReturns( "this BigDecimal converted to a float." );
	}
}

class bdHashCode extends BigDMethod {
	bdHashCode() {
		setName( "hashCode" );
		setDesc( "Returns the hash code for this BigDecimal. Note that two BigDecimal objects that are numerically equal but differ in scale (like 2.0 and 2.00) will generally not have the same hash code." );
		setReturnType( "Public", "int" );
		setReturns( "hash code for this BigDecimal." );
	}
}

class bdIntValue extends BigDMethod {
	bdIntValue() {
		setName( "intValue" );
		setDesc( "Converts this BigDecimal to an int. This conversion is analogous to a narrowing primitive conversion from double to short as defined in the Java Language Specification: any fractional part of this BigDecimal will be discarded, and if the resulting \"BigInteger\" is too big to fit in an int, only the low-order 32 bits are returned. Note that this conversion can lose information about the overall magnitude and precision of this BigDecimal value as well as return a result with the opposite sign." );
		setReturnType( "Public", "int" );
		setReturns( "this BigDecimal converted to a int." );
	}
}

class bdIntValueExact extends BigDMethod {
	bdIntValueExact() {
		setName( "intValueExact" );
		setDesc( "Converts this BigDecimal to an int, checking for lost information." );
		setReturnType( "Public", "int" );
		setReturns( "this BigDecimal converted to a int." );
	}
}

class bdLongValue extends BigDMethod {
	bdLongValue() {
		setName( "longValue" );
		setDesc( "Converts this BigDecimal to a long. This conversion is analogous to a narrowing primitive conversion from double to short as defined in the Java Language Specification: any fractional part of this BigDecimal will be discarded, and if the resulting \"BigInteger\" is too big to fit in a long, only the low-order 64 bits are returned. Note that this conversion can lose information about the overall magnitude and precision of this BigDecimal value as well as return a result with the opposite sign." );
		setReturnType( "Public", "long" );
		setReturns( "this BigDecimal converted to a long." );
	}
}

class bdLongValueExact extends BigDMethod {
	bdLongValueExact() {
		setName( "longValueExact" );
		setDesc( "Converts this BigDecimal to an long, checking for lost information." );
		setReturnType( "Public", "long" );
		setReturns( "this BigDecimal converted to a long." );
	}
}

class bdMax extends BigDMethod {
	bdMax() {
		setName( "max" );
		setDesc( "Returns the maximum of this BigDecimal and val." );
		addParam( "BigDecimal", "val" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "the BigDecimal whose value is the greater of this BigDecimal and val. If they are equal, as defined by the compareTo method, this is returned." );
	}
}

class bdMin extends BigDMethod {
	bdMin() {
		setName( "min" );
		setDesc( "Returns the minimum of this BigDecimal and val." );
		addParam( "BigDecimal", "val" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "the BigDecimal whose value is the lesser of this BigDecimal and val. If they are equal, as defined by the compareTo method, this is returned." );
	}
}

class bdMovePointLeft extends BigDMethod {
	bdMovePointLeft() {
		setName( "movePointLeft" );
		setDesc( "Returns a BigDecimal which is equivalent to this one with the decimal point moved n places to the left. If n is non-negative, the call merely adds n to the scale. If n is negative, the call is equivalent to movePointRight(-n)." );
		addParam( "int", "n" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a BigDecimal which is equivalent to this one with the decimal point moved n places to the left." );
	}
}

class bdMovePointRight extends BigDMethod {
	bdMovePointRight() {
		setName( "movePointRight" );
		setDesc( "Returns a BigDecimal which is equivalent to this one with the decimal point moved n places to the right. If n is non-negative, the call merely subtracts n from the scale. If n is negative, the call is equivalent to movePointLeft(-n)." );
		addParam( "int", "n" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a BigDecimal which is equivalent to this one with the decimal point moved n places to the right." );
	}
}

class bdMultiply extends BigDMethod {
	bdMultiply() {
		setName( "multiply" );
		setDesc( "Returns a BigDecimal whose value is (this × multiplicand), and whose scale is (this.scale() + multiplicand.scale())." );
		addParam( "BigDecimal", "multiplicand" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this * multiplicand." );
	}
}

class bdMultiply2 extends BigDMethod {
	bdMultiply2() {
		setName( "multiply" );
		setDesc( "Returns a BigDecimal whose value is (this × multiplicand), with rounding according to the context settings." );
		addParam( "BigDecimal", "multiplicand" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this * multiplicand, rounded as necessary." );
	}
}

class bdNegate extends BigDMethod {
	bdNegate() {
		setName( "negate" );
		setDesc( "Returns a BigDecimal whose value is (-this), and whose scale is this.scale()." );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "-this." );
	}
}

class bdNegate2 extends BigDMethod {
	bdNegate2() {
		setName( "negate" );
		setDesc( "Returns a BigDecimal whose value is (-this), with rounding according to the context settings." );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "-this, rounded as necessary." );
	}
}

class bdPlus extends BigDMethod {
	bdPlus() {
		setName( "plus" );
		setDesc( "Returns a BigDecimal whose value is (+this), and whose scale is this.scale()." );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this." );
	}
}

class bdPlus2 extends BigDMethod {
	bdPlus2() {
		setName( "plus" );
		setDesc( "Returns a BigDecimal whose value is (+this), with rounding according to the context settings." );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this, rounded as necessary. A zero result will have a scale of 0." );
	}
}

class bdPow extends BigDMethod {
	bdPow() {
		setName( "pow" );
		setDesc( "Returns a BigDecimal whose value is (this^n), The power is computed exactly, to unlimited precision." );
		addParam( "int", "n" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this^n." );
	}
}

class bdPow2 extends BigDMethod {
	bdPow2() {
		setName( "plus" );
		setDesc( "Returns a BigDecimal whose value is (this^n). The current implementation uses the core algorithm defined in ANSI standard X3.274-1996 with rounding according to the context settings." );
		addParam( "int", "n" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this^n, using the ANSI standard X3.274-1996 algorithm." );
	}
}

class bdPrecision extends BigDMethod {
	bdPrecision() {
		setName( "precision" );
		setDesc( "Returns the precision of this BigDecimal. (The precision is the number of digits in the unscaled value.)" );
		setReturnType( "Public", "int" );
		setReturns( "the precision of this BigDecimal." );
	}
}

class bdRemainder extends BigDMethod {
	bdRemainder() {
		setName( "remainder" );
		setDesc( "Returns a BigDecimal whose value is (this % divisor)." );
		addParam( "BigDecimal", "divisor" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this % divisor." );
	}
}

class bdRemainder2 extends BigDMethod {
	bdRemainder2() {
		setName( "remainder" );
		setDesc( "Returns a BigDecimal whose value is (this % divisor), with rounding according to the context settings. The MathContext settings affect the implicit divide used to compute the remainder. The remainder computation itself is by definition exact. Therefore, the remainder may contain more than mc.getPrecision() digits." );
		addParam( "BigDecimal", "divisor" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this % divisor, rounded as necessary." );
	}
}

class bdRound extends BigDMethod {
	bdRound() {
		setName( "round" );
		setDesc( "Returns a BigDecimal rounded according to the MathContext settings. If the precision setting is 0 then no rounding takes place." );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a BigDecimal rounded according to the MathContext settings." );
	}
}

class bdScale extends BigDMethod {
	bdScale() {
		setName( "scale" );
		setDesc( "Returns the scale of this BigDecimal. If zero or positive, the scale is the number of digits to the right of the decimal point. If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale. For example, a scale of -3 means the unscaled value is multiplied by 1000." );
		setReturnType( "Public", "int" );
		setReturns( "the scale of this BigDecimal." );
	}
}

class bdScaleByPowerOfTen extends BigDMethod {
	bdScaleByPowerOfTen() {
		setName( "scaleByPowerOfTen" );
		setDesc( "Returns a BigDecimal whose numerical value is equal to (this * 10^n). The scale of the result is (this.scale() - n)." );
		setReturnType( "Public", "BigDecimal" );
	}
}

class bdSetScale extends BigDMethod {
	bdSetScale() {
		setName( "setScale" );
		setDesc( "Returns a BigDecimal whose scale is the specified value, and whose value is numerically equal to this BigDecimal's." );
		addParam( "int", "newScale" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a BigDecimal whose scale is the specified value, and whose unscaled value is determined by multiplying or dividing this BigDecimal's unscaled value by the appropriate power of ten to maintain its overall value." );
	}
}

class bdSetScale2 extends BigDMethod {
	bdSetScale2() {
		setName( "setScale" );
		setDesc( "Returns a BigDecimal whose scale is the specified value, and whose unscaled value is determined by multiplying or dividing this BigDecimal's unscaled value by the appropriate power of ten to maintain its overall value. If the scale is reduced by the operation, the unscaled value must be divided (rather than multiplied), and the value may be changed; in this case, the specified rounding mode is applied to the division." );
		addParam( "int", "newScale" );
		addParam( "int", "roundingMode" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a BigDecimal whose scale is the specified value, and whose unscaled value is determined by multiplying or dividing this BigDecimal's unscaled value by the appropriate power of ten to maintain its overall value." );
	}
}

class bdSetScale3 extends BigDMethod {
	bdSetScale3() {
		setName( "setScale" );
		setDesc( "Returns a BigDecimal whose scale is the specified value, and whose unscaled value is determined by multiplying or dividing this BigDecimal's unscaled value by the appropriate power of ten to maintain its overall value. If the scale is reduced by the operation, the unscaled value must be divided (rather than multiplied), and the value may be changed; in this case, the specified rounding mode is applied to the division." );
		addParam( "int", "newScale" );
		addParam( "RoundingMode", "roundingMode" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a BigDecimal whose scale is the specified value, and whose unscaled value is determined by multiplying or dividing this BigDecimal's unscaled value by the appropriate power of ten to maintain its overall value." );
	}
}

class bdShortValueExact extends BigDMethod {
	bdShortValueExact() {
		setName( "shortValueExact" );
		setDesc( "Converts this BigDecimal to a short, checking for lost information." );
		setReturnType( "Public", "short" );
		setReturns( "this BigDecimal converted to a short." );
	}
}

class bdSigNum extends BigDMethod {
	bdSigNum() {
		setName( "sigNum" );
		setDesc( "Returns the signum function of this BigDecimal." );
		setReturnType( "Public", "int" );
		setReturns( "-1, 0, or 1 as the value of this BigDecimal is negative, zero, or positive." );
	}
}

class bdStripTrailingZeros extends BigDMethod {
	bdStripTrailingZeros() {
		setName( "stripTrailingZeros" );
		setDesc( "Returns a BigDecimal which is numerically equal to this one but with any trailing zeros removed from the representation. For example, stripping the trailing zeros from the BigDecimal value 600.0, which has [BigInteger, scale] components equals to [6000, 1], yields 6E2 with [BigInteger, scale] components equals to [6, -2]." );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "a numerically equal BigDecimal with any trailing zeros removed." );
	}
}

class bdSubtract extends BigDMethod {
	bdSubtract() {
		setName( "subtract" );
		setDesc( "Returns a BigDecimal whose value is (this - augend), and whose scale is max(this.scale(), augend.scale())." );
		addParam( "BigDecimal", "subtrahend" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this - subtrahend." );
	}
}

class bdSubtract2 extends BigDMethod {
	bdSubtract2() {
		setName( "subtract" );
		setDesc( "Returns a BigDecimal whose value is (this - subtrahend), with rounding according to the context settings. If subtrahend is zero then this, rounded if necessary, is used as the result. If this is zero then the result is subtrahend.negate(mc)." );
		addParam( "BigDecimal", "subtrahend" );
		addParam( "MathContext", "mc" );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "this - subtrahend, rounded as necessary." );
	}
}

class bdToBigInteger extends BigDMethod {
	bdToBigInteger() {
		setName( "toBigInteger" );
		setDesc( "Converts this BigDecimal to a BigInteger. This conversion is analogous to a narrowing primitive conversion from double to long as defined in the Java Language Specification: any fractional part of this BigDecimal will be discarded. Note that this conversion can lose information about the precision of the BigDecimal value." );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this BigDecimal converted to a BigInteger." );
	}
}

class bdToBigIntegerExact extends BigDMethod {
	bdToBigIntegerExact() {
		setName( "toBigIntegerExact" );
		setDesc( "Converts this BigDecimal to a BigInteger, checking for lost information." );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this BigDecimal converted to a BigInteger." );
	}
}

class bdToEngineeringString extends BigDMethod {
	bdToEngineeringString() {
		setName( "toEngineeringString" );
		setDesc( "Returns a string representation of this BigDecimal, using engineering notation if an exponent is needed." );
		setReturnType( "Public", "String" );
		setReturns( "string representation of this BigDecimal, using engineering notation if an exponent is needed." );
	}
}

class bdToPlainString extends BigDMethod {
	bdToPlainString() {
		setName( "toPlainString" );
		setDesc( "Returns a string representation of this BigDecimal without an exponent field." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of this BigDecimal without an exponent field." );
	}
}

class bdToString extends BigDMethod {
	bdToString() {
		setName( "toString" );
		setDesc( "Returns the string representation of this BigDecimal, using scientific notation if an exponent is needed." );
		setReturnType( "Public", "String" );
		setReturns( "string representation of this BigDecimal." );
	}
}

class bdULP extends BigDMethod {
	bdULP() {
		setName( "ulp" );
		setDesc( "Returns the size of an ulp, a unit in the last place, of this BigDecimal." );
		setReturnType( "Public", "BigDecimal" );
		setReturns( "the size of an ulp of this." );
	}
}

class bdUnscaledValue extends BigDMethod {
	bdUnscaledValue() {
		setName( "unscaledValue" );
		setDesc( "Returns a BigInteger whose value is the unscaled value of this BigDecimal." );
		setReturnType( "Public", "BigInteger" );
		setReturns( "the unscaled value of this BigDecimal." );
	}
}

class bdValueOf extends BigDMethod {
	bdValueOf() {
		setName( "valueOf" );
		setDesc( "Translates a double into a BigDecimal, using the double's canonical string representation provided by the Double.toString(double) method." );
		addParam( "double", "val" );
		setReturnType( "Public Static", "BigDecimal" );
		setReturns( "a BigDecimal whose value is equal to or approximately equal to the value of val." );
	}
}

class bdValueOf2 extends BigDMethod {
	bdValueOf2() {
		setName( "valueOf" );
		setDesc( "Translates a long value into a BigDecimal with a scale of zero. This \"static factory method\" is provided in preference to a (long) constructor because it allows for reuse of frequently used BigDecimal values." );
		addParam( "long", "val" );
		setReturnType( "Public Static", "BigDecimal" );
		setReturns( "a BigDecimal whose value is equal to or approximately equal to the value of val." );
	}
}

class bdValueOf3 extends BigDMethod {
	bdValueOf3() {
		setName( "valueOf" );
		setDesc( "Translates a long unscaled value and an int scale into a BigDecimal. This \"static factory method\" is provided in preference to a (long, int) constructor because it allows for reuse of frequently used BigDecimal values." );
		addParam( "long", "unscaledVal" );
		addParam( "int", "scale" );
		setReturnType( "Public Static", "BigDecimal" );
		setReturns( "a BigDecimal whose value is (unscaledVal � 10^-scale)." );
	}
}

/*************************************************************
**********************SHORT METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class shortConstructor extends Constructor {
	shortConstructor() { 
		setName( "Short" );
		setEnclosingClass( "Short" );
	}
}

class Short1 extends shortConstructor {
	Short1() {
		setDesc( "Constructs a newly allocated Short object that represents the specified short value." );
		addParam( "short", "value" );
	}
}

class Short2 extends shortConstructor {
	Short2() {
		setDesc( "Constructs a newly allocated Short object that represents the short value indicated by the String parameter." );
		addParam( "String", "s" );
	}
}

/**************************METHODS**************************/

abstract class shortMethod extends Method {
	shortMethod() {
		setEnclosingClass( "Short" );
	}
}

class shortByteValue extends shortMethod {
	shortByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Short as a byte." );
		setReturnType( "Public", "byte" );
		setReturns( "the numeric value represented by this object after conversion to type byte." );
	}
}

class shortCompareTo extends shortMethod {
	shortCompareTo() {
		setName( "byteValue" );
		setDesc( "Compares two Short objects numerically." );
		setReturnType( "Public", "int" );
		addParam( "Short", "anotherShort" );
		setReturns( "the value 0 if this Short is equal to the argument Short; a value less than 0 if this Short is numerically less than the argument Short; and a value greater than 0 if this Short is numerically greater than the argument Short (signed comparison)." );
	}
}

class shortDecode extends shortMethod {
	shortDecode() {
		setName( "decode" );
		setDesc( "Decodes a String into a Short." );
		setReturnType( "Static", "Short" );
		addParam( "String", "nm" );
		setReturns( "a Short object holding the short value represented by nm" );
	}
}

class shortDoubleValue extends shortMethod {
	shortDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of this Short as a double." );
		setReturnType( "Public", "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class shortEquals extends shortMethod {
	shortEquals() {
		setName( "equals" );
		setDesc( "Compares this object to the specified object." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "obj" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class shortFloatValue extends shortMethod {
	shortFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of this Short as a float." );
		setReturnType( "Public", "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class shortHashCode extends shortMethod {
	shortHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Short." );
		setReturnType( "Public", "int" );
		setReturns( "a hash code value for this object." );
	}
}

class shortIntValue extends shortMethod {
	shortIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Short as an int." );
		setReturnType( "Public", "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class shortLongValue extends shortMethod {
	shortLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Short as a long." );
		setReturnType( "Public", "long" );
		setReturns( "the numeric value represented by this object after conversion to type long." );
	}
}

class shortParseShort extends shortMethod {
	shortParseShort() {
		setName( "parseShort" );
		setDesc( "Parses the string argument as a signed decimal short." );
		setReturnType( "Static", "short" );
		addParam( "String", "s" );
		setReturns( "the short value represented by the argument in decimal." );
	}
}

class shortParseShort2 extends shortMethod {
	shortParseShort2() {
		setName( "parseShort" );
		setDesc( "Parses the string argument as a signed short in the radix specified by the second argument." );
		setReturnType( "Static", "short" );
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturns( "the short represented by the string argument in the specified radix." );
	}
}

class shortReverseBytes extends shortMethod {
	shortReverseBytes() {
		setName( "reverseBytes" );
		setDesc( "Returns the value obtained by reversing the order of the bytes in the two's complement representation of the specified short value." );
		setReturnType( "Static", "short" );
		addParam( "short", "i" );
		setReturns( "the value 0 if this Short is equal to the argument Short; a value less than 0 if this Short is numerically less than the argument Short; and a value greater than 0 if this Short is numerically greater than the argument Short (signed comparison)." );
	}
}

class shortShortValue extends shortMethod {
	shortShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Short as a short." );
		setReturnType( "Static", "short" );
		addParam( "short", "i" );
		setReturns( "the numeric value represented by this object after conversion to type short." );
	}
}

class shortToString extends shortMethod {
	shortToString() {
		setName( "toString" );
		setDesc( "Returns a String object representing this Short's value." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of the value of this object in base 10." );
	}
}

class shortToString2 extends shortMethod {
	shortToString2() {
		setName( "toString" );
		setDesc( "Returns the value of this Short as a byte." );
		setReturnType( "Static", "String" );
		addParam( "short", "s" );
		setReturns( "the string representation of the specified short" );
	}
}

class shortValueOf extends shortMethod {
	shortValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Short instance representing the specified short value." );
		setReturnType( "Static", "Short" );
		addParam( "short", "s" );
		setReturns( "a Short instance representing s." );
	}
}

class shortValueOf2 extends shortMethod {
	shortValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns a Short object holding the value given by the specified String." );
		setReturnType( "Static", "short" );
		addParam( "String", "s" );
		setReturns( "a Short object holding the value represented by the string argument" );
	}
}

class shortValueOf3 extends shortMethod {
	shortValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns a Short object holding the value extracted from the specified String when parsed with the radix given by the second argument." );
		setReturnType( "Static", "Short" );
		addParam( "String", "s" );
		addParam( "int", "radix" );
		setReturns( "a Short object holding the value represented by the string argument in the specified radix." );
	}
}

/*************************************************************
**********************BIGINTEGER METHODS**********************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class BigIConstructor extends Constructor {
	BigIConstructor() { 
		setName( "BigInteger" );
		setEnclosingClass( "BigInteger" );
	}
}

class BigInteger1 extends BigIConstructor {
	BigInteger1() {
		setDesc( "Translates a byte array containing the two's-complement binary representation of a BigInteger into a BigInteger. The input array is assumed to be in big-endian byte-order: the most significant byte is in the zeroth element." );
		addParam( "byte[]", "val" );
	}
}

class BigInteger2 extends BigIConstructor {
	BigInteger2() {
		setDesc( "Translates the sign-magnitude representation of a BigInteger into a BigInteger. The sign is represented as an integer signum value: -1 for negative, 0 for zero, or 1 for positive. The magnitude is a byte array in big-endian byte-order: the most significant byte is in the zeroth element. A zero-length magnitude array is permissible, and will result in a BigInteger value of 0, whether signum is -1, 0 or 1." );
		addParam( "int", "signum" );
		addParam( "byte[]", "magnitude" );
	}
}

class BigInteger3 extends BigIConstructor {
	BigInteger3() {
		setDesc( "Constructs a randomly generated positive BigInteger that is probably prime, with the specified bitLength." );
		addParam( "int", "bitLength" );
		addParam( "int", "certainty");
		addParam( "Random", "rnd" );
	}
}

class BigInteger4 extends BigIConstructor {
	BigInteger4() {
		setDesc( "Constructs a randomly generated BigInteger, uniformly distributed over the range 0 to (2^numBits - 1), inclusive. The uniformity of the distribution assumes that a fair source of random bits is provided in rnd. Note that this constructor always constructs a non-negative BigInteger." );
		addParam( "int", "numBits" );
		addParam( "Random", "rnd" );
	}
}

class BigInteger5 extends BigIConstructor {
	BigInteger5() {
		setDesc( "Translates the decimal String representation of a BigInteger into a BigInteger. The String representation consists of an optional minus sign followed by a sequence of one or more decimal digits. The character-to-digit mapping is provided by Character.digit. The String may not contain any extraneous characters (whitespace, for example)." );
		addParam( "String", "val" );
	}
}

class BigInteger6 extends BigIConstructor {
	BigInteger6() {
		setDesc( "Translates the String representation of a BigInteger in the specified radix into a BigInteger. The String representation consists of an optional minus sign followed by a sequence of one or more digits in the specified radix. The character-to-digit mapping is provided by Character.digit. The String may not contain any extraneous characters (whitespace, for example)." );
		addParam( "String", "val" );
		addParam( "int", "radix" );
	}
}

/**********************METHODS*************************/

abstract class BigIMethod extends Method {
	BigIMethod() {
		setEnclosingClass( "BigInteger" );
	}
}

class biAbs extends BigIMethod {
	biAbs() {
		setName( "abs" );
		setDesc( "Returns a BigInteger whose value is the absolute value of this BigInteger." );
		setReturnType( "Public", "BigInteger" );
		setReturns( "abs(this)." );
	}
}

class biAdd extends BigIMethod {
	biAdd() {
		setName( "add" );
		setDesc( "Returns a BigInteger whose value is (this + val)." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this + val." );
	}
}

class biAnd extends BigIMethod {
	biAnd() {
		setName( "and" );
		setDesc( "Returns a BigInteger whose value is (this & val). (This method returns a negative BigInteger if and only if this and val are both negative.)" );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this & val." );
	}
}

class biAndNot extends BigIMethod {
	biAndNot() {
		setName( "andNot" );
		setDesc( "Returns a BigInteger whose value is (this & ~val). This method, which is equivalent to and(val.not()), is provided as a convenience for masking operations. (This method returns a negative BigInteger if and only if this is negative and val is positive.)" );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this & ~val." );
	}
}

class biBitCount extends BigIMethod {
	biBitCount() {
		setName( "bitCount" );
		setDesc( "Returns the number of bits in the two's complement representation of this BigInteger that differ from its sign bit. This method is useful when implementing bit-vector style sets atop BigIntegers." );
		setReturnType( "Public", "int" );
		setReturns( "number of bits in the two's complement representation of this BigInteger that differ from its sign bit." );
	}
}

class biBitLength extends BigIMethod {
	biBitLength() {
		setName( "bitLength" );
		setDesc( "Returns the number of bits in the minimal two's-complement representation of this BigInteger, excluding a sign bit. For positive BigIntegers, this is equivalent to the number of bits in the ordinary binary representation. (Computes (ceil(log2(this < 0 ? -this : this+1))).)" );
		setReturnType( "Public", "int" );
		setReturns( "number of bits in the minimal two's-complement representation of this BigInteger, excluding a sign bit." );
	}
}

class biClearBit extends BigIMethod {
	biClearBit() {
		setName( "clearBit" );
		setDesc( "Returns a BigInteger whose value is equivalent to this BigInteger with the designated bit cleared. (Computes (this & ~(1<<n)).)" );
		addParam( "int", "n" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this & ~(1<<n)" );
	}
}

class biCompareTo extends BigIMethod {
	biCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares this BigInteger with the specified BigInteger. This method is provided in preference to individual methods for each of the six boolean comparison operators (<, ==, >, >=, !=, <=). The suggested idiom for performing these comparisons is: (x.compareTo(y) <op> 0), where <op> is one of the six comparison operators." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "int" );
		setReturns( "-1, 0 or 1 as this BigInteger is numerically less than, equal to, or greater than val." );
	}
}

class biDivide extends BigIMethod {
	biDivide() {
		setName( "divide" );
		setDesc( "Returns a BigInteger whose value is (this / val)." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this/val." );
	}
}

class biDivideAndRemainder extends BigIMethod {
	biDivideAndRemainder() {
		setName( "divideAndRemainder" );
		setDesc( "Returns an array of two BigIntegers containing (this / val) followed by (this % val)." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger[]" );
		setReturns( "an array of two BigIntegers: the quotient (this / val) is the initial element, and the remainder (this % val) is the final element." );
	}
}

class biDoubleValue extends BigIMethod {
	biDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Converts this BigInteger to a double. This conversion is similar to the narrowing primitive conversion from double to float defined in the Java Language Specification: if this BigInteger has too great a magnitude to represent as a double, it will be converted to Double.NEGATIVE_INFINITY or Double.POSITIVE_INFINITY as appropriate. Note that even when the return value is finite, this conversion can lose information about the precision of the BigInteger value." );
		setReturnType( "Public", "double" );
		setReturns( "this BigInteger converted to a double." );
	}
}

class biEquals extends BigIMethod {
	biEquals() {
		setName( "equals" );
		setDesc( "Compares this BigInteger with the specified Object for equality." );
		addParam( "Object", "x" );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if and only if the specified Object is a BigInteger whose value is numerically equal to this BigInteger." );
	}
}

class biFlipBit extends BigIMethod {
	biFlipBit() {
		setName( "flipBit" );
		setDesc( "Returns a BigInteger whose value is equivalent to this BigInteger with the designated bit flipped. (Computes (this ^ (1<<n)).)" );
		addParam( "int", "n" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this ^ (1<<n)" );
	}
}

class biFloatValue extends BigIMethod {
	biFloatValue() {
		setName( "floatValue" );
		setDesc( "Converts this BigInteger to a float. This conversion is similar to the narrowing primitive conversion from double to float defined in the Java Language Specification: if this BigInteger has too great a magnitude to represent as a float, it will be converted to Float.NEGATIVE_INFINITY or Float.POSITIVE_INFINITY as appropriate. Note that even when the return value is finite, this conversion can lose information about the precision of the BigInteger value." );
		setReturnType( "Public", "float" );
		setReturns( "this BigInteger converted to a float." );
	}
}

class biGcd extends BigIMethod {
	biGcd() {
		setName( "gcd" );
		setDesc( "Returns a BigInteger whose value is the greatest common divisor of abs(this) and abs(val). Returns 0 if this==0 && val==0." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "GCD(abs(this), abs(val))" );
	}
}

class biGetLowestSetBit extends BigIMethod {
	biGetLowestSetBit() {
		setName( "getLowestSetBit" );
		setDesc( "Returns the index of the rightmost (lowest-order) one bit in this BigInteger (the number of zero bits to the right of the rightmost one bit). Returns -1 if this BigInteger contains no one bits. (Computes (this==0? -1 : log2(this & -this)).)" );
		setReturnType( "Public", "int" );
		setReturns( "index of the rightmost one bit in this BigInteger." );
	}
}

class biHashCode extends BigIMethod {
	biHashCode() {
		setName( "hashCode" );
		setDesc( "Returns the hash code for this BigInteger." );
		setReturnType( "Public", "int" );
		setReturns( "hash code for this BigInteger." );
	}
}

class biIntValue extends BigIMethod {
	biIntValue() {
		setName( "intValue" );
		setDesc( "Converts this BigInteger to an int. This conversion is analogous to a narrowing primitive conversion from long to int as defined in the Java Language Specification: if this BigInteger is too big to fit in an int, only the low-order 32 bits are returned. Note that this conversion can lose information about the overall magnitude of the BigInteger value as well as return a result with the opposite sign." );
		setReturnType( "Public", "int" );
		setReturns( "this BigInteger converted to an int." );
	}
}

class biIsProbablePrime extends BigIMethod {
	biIsProbablePrime() {
		setName( "isProbablePrime" );
		setDesc( "Returns true if this BigInteger is probably prime, false if it's definitely composite. If certainty is <= 0, true is returned." );
		addParam( "int", "certainty" );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if this BigInteger is probably prime, false if it's definitely composite." );
	}
}

class biLongValue extends BigIMethod {
	biLongValue() {
		setName( "longValue" );
		setDesc( "Converts this BigInteger to a long. This conversion is analogous to a narrowing primitive conversion from long to int as defined in the Java Language Specification: if this BigInteger is too big to fit in a long, only the low-order 64 bits are returned. Note that this conversion can lose information about the overall magnitude of the BigInteger value as well as return a result with the opposite sign." );
		setReturnType( "Public", "long" );
		setReturns( "this BigInteger converted to a long." );
	}
}

class biMax extends BigIMethod {
	biMax() {
		setName( "max" );
		setDesc( "Returns the maximum of this BigInteger and val." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "the BigInteger whose value is the greater of this and val. If they are equal, either may be returned." );
	}
}

class biMin extends BigIMethod {
	biMin() {
		setName( "min" );
		setDesc( "Returns the minimum of this BigInteger and val." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "the BigInteger whose value is the lesser of this BigInteger and val. If they are equal, either may be returned." );
	}
}

class biMod extends BigIMethod {
	biMod() {
		setName( "mod" );
		setDesc( "Returns a BigInteger whose value is (this mod m). This method differs from remainder in that it always returns a non-negative BigInteger." );
		addParam( "BigInteger", "m" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this mod m" );
	}
}

class biModInverse extends BigIMethod {
	biModInverse() {
		setName( "modInverse" );
		setDesc( "Returns a BigInteger whose value is (this^-1 mod m)." );
		addParam( "BigInteger", "m" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this^-1 mod m." );
	}
}

class biModPow extends BigIMethod {
	biModPow() {
		setName( "modPow" );
		setDesc( "Returns a BigInteger whose value is (this^exponent mod m). (Unlike pow, this method permits negative exponents.)" );
		addParam( "BigInteger", "exponent" );
		addParam( "BigInteger", "m" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this^exponent mod m" );
	}
}

class biMultiply extends BigIMethod {
	biMultiply() {
		setName( "multiply" );
		setDesc( "Returns a BigInteger whose value is (this * val)." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this * val." );
	}
}

class biNegate extends BigIMethod {
	biNegate() {
		setName( "negate" );
		setDesc( "Returns a BigInteger whose value is (-this)." );
		setReturnType( "Public", "BigInteger" );
		setReturns( "-this." );
	}
}

class biNextProbablePrime extends BigIMethod {
	biNextProbablePrime() {
		setName( "nextProbablePrime" );
		setDesc( "Returns the first integer greater than this BigInteger that is probably prime. The probability that the number returned by this method is composite does not exceed 2^-100. This method will never skip over a prime when searching: if it returns p, there is no prime q such that this < q < p." );
		setReturnType( "Public", "BigInteger" );
		setReturns( "the first integer greater than this BigInteger that is probably prime." );
	}
}

class biNot extends BigIMethod {
	biNot() {
		setName( "not" );
		setDesc( "Returns a BigInteger whose value is (~this). (This method returns a negative value if and only if this BigInteger is non-negative.)" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "~this." );
	}
}

class biOr extends BigIMethod {
	biOr() {
		setName( "or" );
		setDesc( "Returns a BigInteger whose value is (this | val). (This method returns a negative BigInteger if and only if either this or val is negative.)" );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this | val." );
	}
}

class biPow extends BigIMethod {
	biPow() {
		setName( "pow" );
		setDesc( "Returns a BigInteger whose value is (this^exponent). Note that exponent is an integer rather than a BigInteger." );
		addParam( "int", "exponent" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this^exponent" );
	}
}

class biProbablePrime extends BigIMethod {
	biProbablePrime() {
		setName( "probablePrime" );
		setDesc( "Returns a positive BigInteger that is probably prime, with the specified bitLength. The probability that a BigInteger returned by this method is composite does not exceed 2^-100." );
		addParam( "int", "bitLength" );
		addParam( "Random", "rnd" );
		setReturnType( "Public Static", "BigInteger" );
		setReturns( "a BigInteger of bitLength bits that is probably prime" );
	}
}

class biRemainder extends BigIMethod {
	biRemainder() {
		setName( "remainder" );
		setDesc( "Returns a BigInteger whose value is (this % val)." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this % val." );
	}
}

class biSetBit extends BigIMethod {
	biSetBit() {
		setName( "setBit" );
		setDesc( "Returns a BigInteger whose value is equivalent to this BigInteger with the designated bit set. (Computes (this | (1<<n)).)" );
		addParam( "int", "n" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this | (1<<n)." );
	}
}

class biShiftLeft extends BigIMethod {
	biShiftLeft() {
		setName( "shiftLeft" );
		setDesc( "Returns a BigInteger whose value is (this << n). The shift distance, n, may be negative, in which case this method performs a right shift. (Computes floor(this * 2^n).)" );
		addParam( "int", "n" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this << n)" );
	}
}

class biShiftRight extends BigIMethod {
	biShiftRight() {
		setName( "shiftRight" );
		setDesc( "Returns a BigInteger whose value is (this >> n). Sign extension is performed. The shift distance, n, may be negative, in which case this method performs a left shift. (Computes floor(this / 2^n).)" );
		addParam( "int", "n" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this >> n." );
	}
}

class biSignum extends BigIMethod {
	biSignum() {
		setName( "signum" );
		setDesc( "Returns the signum function of this BigInteger." );
		setReturnType( "Public", "int" );
		setReturns( "-1, 0 or 1 as the value of this BigInteger is negative, zero or positive." );
	}
}

class biSubtract extends BigIMethod {
	biSubtract() {
		setName( "subtract" );
		setDesc( "Returns a BigInteger whose value is (this - val)." );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this - val" );
	}
}

class biTestBit extends BigIMethod {
	biTestBit() {
		setName( "testBit" );
		setDesc( "Returns true if and only if the designated bit is set. (Computes ((this & (1<<n)) != 0).)" );
		addParam( "int", "n" );
		setReturnType( "Public", "boolean" );
		setReturns( "'true' if and only if the designated bit is set." );
	}
}

class biToByteArray extends BigIMethod {
	biToByteArray() {
		setName( "toByteArray" );
		setDesc( "Returns a byte array containing the two's-complement representation of this BigInteger. The byte array will be in big-endian byte-order: the most significant byte is in the zeroth element. The array will contain the minimum number of bytes required to represent this BigInteger, including at least one sign bit, which is (ceil((this.bitLength() + 1)/8)). (This representation is compatible with the (byte[]) constructor.)" );
		setReturnType( "Public", "byte[]" );
		setReturns( "a byte array containing the two's-complement representation of this BigInteger." );
	}
}

class biToString extends BigIMethod {
	biToString() {
		setName( "toString" );
		setDesc( "Returns the decimal String representation of this BigInteger. The digit-to-character mapping provided by Character.forDigit is used, and a minus sign is prepended if appropriate. (This representation is compatible with the (String) constructor, and allows for String concatenation with Java's + operator.)" );
		setReturnType( "Public", "String" );
		setReturns( "decimal String representation of this BigInteger." );
	}
}

class biToString2 extends BigIMethod {
	biToString2() {
		setName( "toString" );
		setDesc( "Returns the String representation of this BigInteger in the given radix. If the radix is outside the range from Character.MIN_RADIX to Character.MAX_RADIX inclusive, it will default to 10 (as is the case for Integer.toString). The digit-to-character mapping provided by Character.forDigit is used, and a minus sign is prepended if appropriate. (This representation is compatible with the (String, int) constructor.)" );
		addParam( "int", "radix" );
		setReturnType( "Public", "String" );
		setReturns( "String representation of this BigInteger in the given radix" );
	}
}

class biValueOf extends BigIMethod {
	biValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a BigInteger whose value is equal to that of the specified long. This \"static factory method\" is provided in preference to a (long) constructor because it allows for reuse of frequently used BigIntegers." );
		addParam( "long", "val" );
		setReturnType( "Public Static", "BigInteger" );
		setReturns( "a BigInteger with the specified value." );
	}
}

class biXor extends BigIMethod {
	biXor() {
		setName( "xor" );
		setDesc( "Returns a BigInteger whose value is (this ^ val). (This method returns a negative BigInteger if and only if exactly one of this and val are negative.)" );
		addParam( "BigInteger", "val" );
		setReturnType( "Public", "BigInteger" );
		setReturns( "this ^ val" );
	}
}

/*************************************************************
**********************ABSTRACTQUEUE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class abstractQueueConstructor extends Constructor {
	abstractQueueConstructor() { 
		setName( "AbstractQueue" );
		setEnclosingClass( "AbstractQueue" );
	}
}

class AbstractQueue1 extends abstractQueueConstructor {
	AbstractQueue1() {
		setDesc( "This class provides skeletal implementations of some Queue operations. The implementations in this class are appropriate when the base implementation does not allow null elements. Methods add, remove, and element are based on offer, poll, and peek, respectively but throw exceptions instead of indicating failure via false or null returns." );
	}
}

/**************************METHODS**************************/

abstract class abstractQueueMethod extends Method {
	abstractQueueMethod() {
		setEnclosingClass( "AbstractQueue" );
	}
}

class aqAdd extends abstractQueueMethod {
	aqAdd() {
		setName( "add" );
		setDesc( "Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Collection.add(E))" );
	}
}

class aqAddAll extends abstractQueueMethod {
	aqAddAll() {
		setName( "addAll" );
		setDesc( "Adds all of the elements in the specified collection to this queue. Attempts to addAll of a queue to itself result in IllegalArgumentException. Further, the behavior of this operation is undefined if the specified collection is modified while the operation is in progress." );
		setReturnType( "Public", "boolean" );
		addParam( "Collection<? extends E>", "c"  );
		setReturns( "true if this queue changed as a result of the call" );
	}
}

class aqClear extends abstractQueueMethod {
	aqClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this queue. The queue will be empty after this call returns." );
		setReturnType( "Public", "void" );
	}
}

class aqElement extends abstractQueueMethod {
	aqElement() {
		setName( "element" );
		setDesc( "Retrieves, but does not remove, the head of this queue. This method differs from peek only in that it throws an exception if this queue is empty." );
		setReturns( "the head of this queue" );
		setReturnType( "Public", "E" );
	}
}

class aqRemove extends abstractQueueMethod {
	aqRemove() {
		setName( "remove" );
		setDesc( "Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this queue" );
	}
}

/*************************************************************
**********************PRIORITYQUEUE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class PriorityQueueConstructor extends Constructor {
	PriorityQueueConstructor() { 
		setName( "PriorityQueue" );
		setEnclosingClass( "PriorityQueue" );
	}
}

class PriorityQueue1 extends PriorityQueueConstructor {
	PriorityQueue1() {
		setDesc( "Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering." );
	}
}

class PriorityQueue2 extends PriorityQueueConstructor {
	PriorityQueue2() {
		setDesc( "Creates a PriorityQueue containing the elements in the specified collection. If the specified collection is an instance of a SortedSet or is another PriorityQueue, this priority queue will be ordered according to the same ordering. Otherwise, this priority queue will be ordered according to the natural ordering of its elements." );
		addParam( "Collection<? extends E>", "c" );
	}
}

class PriorityQueue3 extends PriorityQueueConstructor {
	PriorityQueue3() {
		setDesc( "Creates a PriorityQueue with the specified initial capacity that orders its elements according to their natural ordering." );
		addParam( "int", "initialCapacity");	
	}
}

class PriorityQueue4 extends PriorityQueueConstructor {
	PriorityQueue4() {
		setDesc( "Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator." );
		addParam( "int", "initialCapacity" );
		addParam( "Comparator<? super E>", "comparator" );
	}
}

class PriorityQueue5 extends PriorityQueueConstructor {
	PriorityQueue5() {
		setDesc( "Creates a PriorityQueue containing the elements in the specified priority queue. This priority queue will be ordered according to the same ordering as the given priority queue." );
		addParam( "PriorityQueue<? extends E>", "c" );
	}
}

class PriorityQueue6 extends PriorityQueueConstructor {
	PriorityQueue6() {
		setDesc( "Creates a PriorityQueue containing the elements in the specified sorted set. This priority queue will be ordered according to the same ordering as the given sorted set." );
		addParam( "SortedSet<? extends E>", "c" );
	}
}

/**************************METHODS**************************/

abstract class PriorityQueueMethod extends Method {
	PriorityQueueMethod() {
		setEnclosingClass( "PriorityQueue" );
	}
}

class pqAdd extends PriorityQueueMethod {
	pqAdd() {
		setName( "add" );
		setDesc( "Inserts the specified element into this priority queue." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Collection.add(E))" );
	}
}

class pqClear extends PriorityQueueMethod {
	pqClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this priority queue. The queue will be empty after this call returns." );
		setReturnType( "Public", "void" );
	}
}

class pqComparator extends PriorityQueueMethod {
	pqComparator() {
		setName( "comparator" );
		setDesc( "Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements." );
		setReturnType( "Public", "Comparator<? super E>" );
		setReturns( "the comparator used to order this queue, or null if this queue is sorted according to the natural ordering of its elements" );
	}
}

class pqContains extends PriorityQueueMethod {
	pqContains() {
		setName( "contains" );
		setDesc( "Returns true if this queue contains the specified element. More formally, returns true if and only if this queue contains at least one element e such that o.equals(e)." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "o" );
		setReturns( "true if this queue contains the specified element" );
	}
}

class pqIterator extends PriorityQueueMethod {
	pqIterator() {
		setName( "Iterator" );
		setDesc( "Returns an iterator over the elements in this queue. The iterator does not return the elements in any particular order." );
		setReturnType( "Public", "Iterator<E>" );
		setReturns( "an iterator over the elements in this queue" );
	}
}

class pqOffer extends PriorityQueueMethod {
	pqOffer() {
		setName( "offer" );
		setDesc( "Inserts the specified element into this priority queue." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Queue.offer(E))" );
	}
}

class pqPeek extends PriorityQueueMethod {
	pqPeek() {
		setName( "peek" );
		setDesc( "Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this queue, or null if this queue is empty" );
	}
}

class pqPoll extends PriorityQueueMethod {
	pqPoll() {
		setName( "poll" );
		setDesc( "Retrieves and removes the head of this queue, or returns null if this queue is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this queue, or null if this queue is empty" );
	}
}

class pqRemove extends PriorityQueueMethod {
	pqRemove() {
		setName( "remove" );
		setDesc( "Removes a single instance of the specified element from this queue, if it is present. More formally, removes an element e such that o.equals(e), if this queue contains one or more such elements. Returns true if and only if this queue contained the specified element (or equivalently, if this queue changed as a result of the call)." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "o" );
		setReturns( "true if this queue changed as a result of the call" );
	}
}

class pqSize extends PriorityQueueMethod {
	pqSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE." );
		setReturnType( "Public", "int" );
		setReturns( "the number of elements in this collection" );
	}
}

class pqToArray extends PriorityQueueMethod {
	pqToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this queue. The elements are in no particular order." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array containing all of the elements in this queue" );
	}
}

class pqToArray2 extends PriorityQueueMethod {
	pqToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array. The returned array elements are in no particular order. If the queue fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this queue." );
		setReturnType( "<T>", "T[]" );
		addParam( "T[]", "a" );
		setReturns( "an array containing all of the elements in this queue" );
	}
}

/*************************************************************
**********************ARRAYDEQUE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class arrayDequeConstructor extends Constructor {
	arrayDequeConstructor() { 
		setName( "ArrayDeque" );
		setEnclosingClass( "ArrayDeque" );
	}
}

class ArrayDeque1 extends arrayDequeConstructor {
	ArrayDeque1() {
		setDesc( "Constructs an empty array deque with an initial capacity sufficient to hold 16 elements." );
	}
}

class ArrayDeque2 extends arrayDequeConstructor {
	ArrayDeque2() {
		addParam( "Collection<? extends E>", "c" );
		setDesc( "Constructs a deque containing the elements of the specified collection, in the order they are returned by the collection's iterator. (The first element returned by the collection's iterator becomes the first element, or front of the deque.)" );
	}
}

class ArrayDeque3 extends arrayDequeConstructor {
	ArrayDeque3() {
		setDesc( "Constructs a deque containing the elements of the specified collection, in the order they are returned by the collection's iterator. (The first element returned by the collection's iterator becomes the first element, or front of the deque.)" );
		addParam( "int", "numElements");	
	}
}

/**************************METHODS**************************/

abstract class arrayDequeMethod extends Method {
	arrayDequeMethod() {
		setEnclosingClass( "ArrayDeque" );
	}
}

class adAdd extends arrayDequeMethod {
	adAdd() {
		setName( "add" );
		setDesc( "Inserts the specified element at the end of this deque." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Collection.add(E))" );
	}
}


class adAddFirst extends arrayDequeMethod {
	adAddFirst() {
		setName( "addFirst" );
		setDesc( "Inserts the specified element at the front of this deque." );
		setReturnType( "Public", "void" );
		addParam( "E", "e" );
	}
}


class adAddLast extends arrayDequeMethod {
	adAddLast() {
		setName( "addLast" );
		setDesc( "Inserts the specified element at the end of this deque." );
		setReturnType( "Public", "void" );
		addParam( "E", "e" );
	}
}


class adClear extends arrayDequeMethod {
	adClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this deque. The deque will be empty after this call returns." );
		setReturnType( "Public", "void" );
	}
}


class adClone extends arrayDequeMethod {
	adClone() {
		setName( "clone" );
		setDesc( "Returns a copy of this deque." );
		setReturnType( "Public", "ArrayDeque<E>" );
		setReturns( "a copy of this deque" );
	}
}


class adContains extends arrayDequeMethod {
	adContains() {
		setName( "contains" );
		setDesc( "Returns true if this deque contains the specified element. More formally, returns true if and only if this deque contains at least one element e such that o.equals(e)." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "o" );
		setReturns( "true if this deque contains the specified element" );
	}
}


class adDescendingIterator extends arrayDequeMethod {
	adDescendingIterator() {
		setName( "descendingIterator" );
		setDesc( "Returns an iterator over the elements in this deque in reverse sequential order. The elements will be returned in order from last (tail) to first (head)." );
		setReturnType( "Public", "Iterator<E>" );
		setReturns( "an iterator over the elements in this deque in reverse sequence" );
	}
}


class adElement extends arrayDequeMethod {
	adElement() {
		setName( "element" );
		setDesc( "Retrieves, but does not remove, the head of the queue represented by this deque. This method differs from peek only in that it throws an exception if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of the queue represented by this deque" );
	}
}


class adGetFirst extends arrayDequeMethod {
	adGetFirst() {
		setName( "getFirst" );
		setDesc( "Retrieves, but does not remove, the first element of this deque. This method differs from peekFirst only in that it throws an exception if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this deque" );
	}
}


class adGetLast extends arrayDequeMethod {
	adGetLast() {
		setName( "getLast" );
		setDesc( "Retrieves, but does not remove, the last element of this deque. This method differs from peekLast only in that it throws an exception if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the tail of this deque" );
	}
}


class adIsEmpty extends arrayDequeMethod {
	adIsEmpty() {
		setName( "adIsEmpty" );
		setDesc( "Returns true if this deque contains no elements." );
		setReturnType( "Public", "boolean" );
		setReturns( "true if this deque contains no elements" );
	}
}


class adIterator extends arrayDequeMethod {
	adIterator() {
		setName( "iterator" );
		setDesc( "Returns an iterator over the elements in this deque. The elements will be ordered from first (head) to last (tail). This is the same order that elements would be dequeued (via successive calls to remove() or popped (via successive calls to pop())." );
		setReturnType( "Public", "Iterator<E>" );
		setReturns( "an iterator over the elements in this deque" );
	}
}


class adOffer extends arrayDequeMethod {
	adOffer() {
		setName( "offer" );
		setDesc( "Inserts the specified element at the end of this deque." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Queue.offer(E))" );
	}
}


class adOfferFirst extends arrayDequeMethod {
	adOfferFirst() {
		setName( "offerFirst" );
		setDesc( "Inserts the specified element at the front of this deque." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Deque.offerFirst(E))" );
	}
}


class adOfferLast extends arrayDequeMethod {
	adOfferLast() {
		setName( "offerLast" );
		setDesc( "Inserts the specified element at the end of this deque." );
		setReturnType( "Public", "boolean" );
		addParam( "E", "e" );
		setReturns( "true (as specified by Deque.offerLast(E))" );
	}
}


class adPeek extends arrayDequeMethod {
	adPeek() {
		setName( "peek" );
		setDesc( "Retrieves, but does not remove, the head of the queue represented by this deque, or returns null if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of the queue represented by this deque, or null if this deque is empty" );
	}
}


class adPeekFirst extends arrayDequeMethod {
	adPeekFirst() {
		setName( "peekFirst" );
		setDesc( "Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this deque, or null if this deque is empty" );
	}
}


class adPeekLast extends arrayDequeMethod {
	adPeekLast() {
		setName( "peekLast" );
		setDesc( "Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the tail of this deque, or null if this deque is empty" );
	}
}


class adPoll extends arrayDequeMethod {
	adPoll() {
		setName( "poll" );
		setDesc( "Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of the queue represented by this deque, or null if this deque is empty" );
	}
}


class adPollFirst extends arrayDequeMethod {
	adPollFirst() {
		setName( "pollFirst" );
		setDesc( "Retrieves and removes the first element of this deque, or returns null if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this deque, or null if this deque is empty" );
	}
}


class adPollLast extends arrayDequeMethod {
	adPollLast() {
		setName( "pollLast" );
		setDesc( "Retrieves and removes the last element of this deque, or returns null if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the tail of this deque, or null if this deque is empty" );
	}
}


class adPop extends arrayDequeMethod {
	adPop() {
		setName( "pop" );
		setDesc( "Pops an element from the stack represented by this deque. In other words, removes and returns the first element of this deque." );
		setReturnType( "Public", "E" );
		setReturns( "the element at the front of this deque (which is the top of the stack represented by this deque)" );
	}
}


class adPush extends arrayDequeMethod {
	adPush() {
		setName( "push" );
		setDesc( "Pushes an element onto the stack represented by this deque. In other words, inserts the element at the front of this deque." );
		setReturnType( "Public", "void" );
		addParam( "E", "e" );
	}
}


class adRemove extends arrayDequeMethod {
	adRemove() {
		setName( "remove" );
		setDesc( "Retrieves and removes the head of the queue represented by this deque. This method differs from poll only in that it throws an exception if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of the queue represented by this deque" );
	}
}


class adRemove2 extends arrayDequeMethod {
	adRemove2() {
		setName( "remove" );
		setDesc( "Removes a single instance of the specified element from this deque. If the deque does not contain the element, it is unchanged. More formally, removes the first element e such that o.equals(e) (if such an element exists). Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call)." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "o" );
		setReturns( "true if this deque contained the specified element (as specified by Queue.offer(E))" );
	}
}


class adRemoveFirst extends arrayDequeMethod {
	adRemoveFirst() {
		setName( "removeFirst" );
		setDesc( "Retrieves and removes the first element of this deque. This method differs from pollFirst only in that it throws an exception if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the head of this deque" );
	}
}


class adRemoveFirstOccurrence extends arrayDequeMethod {
	adRemoveFirstOccurrence() {
		setName( "removeFirstOccurrence" );
		setDesc( "Removes the first occurrence of the specified element in this deque (when traversing the deque from head to tail). If the deque does not contain the element, it is unchanged. More formally, removes the first element e such that o.equals(e) (if such an element exists). Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call)." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "o" );
		setReturns( "true if the deque contained the specified element" );
	}
}

class adRemoveLast extends arrayDequeMethod {
	adRemoveLast() {
		setName( "removeLast" );
		setDesc( "Retrieves and removes the last element of this deque. This method differs from pollLast only in that it throws an exception if this deque is empty." );
		setReturnType( "Public", "E" );
		setReturns( "the tail of the deque" );
	}
}

class adRemoveLastOccurrence extends arrayDequeMethod {
	adRemoveLastOccurrence() {
		setName( "removeLastOccurrence" );
		setDesc( "Removes the last occurrence of the specified element in this deque (when traversing the deque from head to tail). If the deque does not contain the element, it is unchanged. More formally, removes the last element e such that o.equals(e) (if such an element exists). Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call)." );
		setReturnType( "Public", "boolean" );
		addParam( "Object", "o" );
		setReturns( "true if the deque contained the specified element" );
	}
}

class adSize extends arrayDequeMethod {
	adSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this deque" );
		setReturnType( "Public", "int" );
		setReturns( "the number of elements in this deque" );
	}
}

class adToArray extends arrayDequeMethod {
	adToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this deque in proper sequence (from first to last element)." );
		setReturnType( "Public", "Object[]" );
		setReturns( "an array containing all of the elements in this deque" );
	}
}

class adToArray2 extends arrayDequeMethod {
	adToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this deque in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array. If the deque fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this deque." );
		setReturnType( "Public", "<T> T[]" );
		addParam( "T[]", "a" );
		setReturns( "an array containing all of the elements in this deque" );
	}
}

/*************************************************************
**********************STRINGBUILDER METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class stringBuilderConstructor extends Constructor {
	stringBuilderConstructor() { 
		setName( "StringBuilder" );
		setEnclosingClass( "StringBuilder" );
	}
}

class StringBuilder1 extends stringBuilderConstructor {
	StringBuilder1() {
		setDesc( "Constructs a string builder with no characters in it and an initial capacity of 16 characters." );
	}
}

class StringBuilder2 extends stringBuilderConstructor {
	StringBuilder2() {
		addParam( "CharSequence", "seq" );
		setDesc( "Constructs a string builder that contains the same characters as the specified CharSequence." );
	}
}

class StringBuilder3 extends stringBuilderConstructor {
	StringBuilder3() {
		addParam( "int", "capacity" );
		setDesc( "Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument." );
	}
}

class StringBuilder4 extends stringBuilderConstructor {
	StringBuilder4() {
		addParam( "String", "str" );
		setDesc( "Constructs a string builder initialized to the contents of the specified string." );
	}
}

/**************************METHODS**************************/

abstract class stringBuilderMethod extends Method {
	stringBuilderMethod() {
		setEnclosingClass( "StringBuilder" );
	}
}

class sbAppend extends stringBuilderMethod {
	sbAppend() {
		setName( "append" );
		setDesc( "Appends the string representation of the boolean argument to the sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "boolean", "b" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend2 extends stringBuilderMethod {
	sbAppend2() {
		setName( "append" );
		setDesc( "Appends the string representation of the char argument to the sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "char", "c" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend3 extends stringBuilderMethod {
	sbAppend3() {
		setName( "append" );
		setDesc( "Appends the string representation of the char array argument to the sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "char[]", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend4 extends stringBuilderMethod {
	sbAppend4() {
		setName( "append" );
		setDesc( "Appends the string representation of a subarray of the char array argument to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "char[]", "str" );
		addParam( "int", "offset" );
		addParam( "int", "len" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend5 extends stringBuilderMethod {
	sbAppend5() {
		setName( "append" );
		setDesc( "Appends the specified character sequence to this Appendable." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "CharSequence", "s" );
		setReturns( "a reference to this Appendable" );
	}
}

class sbAppend6 extends stringBuilderMethod {
	sbAppend6() {
		setName( "append" );
		setDesc( "Appends a subsequence of the specified CharSequence to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "CharSequence", "s" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend7 extends stringBuilderMethod {
	sbAppend7() {
		setName( "append" );
		setDesc( "Appends the string representation of the double argument to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "double", "d" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend8 extends stringBuilderMethod {
	sbAppend8() {
		setName( "append" );
		setDesc( "Appends the string representation of the float argument to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "float", "f" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend9 extends stringBuilderMethod {
	sbAppend9() {
		setName( "append" );
		setDesc( "Appends the string representation of the int argument to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "i" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend10 extends stringBuilderMethod {
	sbAppend10() {
		setName( "append" );
		setDesc( "Appends the string representation of the long argument to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "long", "lng" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend11 extends stringBuilderMethod {
	sbAppend11() {
		setName( "append" );
		setDesc( "Appends the string representation of the Object argument." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "Object", "obj" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend12 extends stringBuilderMethod {
	sbAppend12() {
		setName( "append" );
		setDesc( "Appends the specified string to this character sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "String", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbAppend13 extends stringBuilderMethod {
	sbAppend13() {
		setName( "append" );
		setDesc( "Appends the specified StringBuffer to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "StringBuffer", "sb" );
		setReturns( "a reference to this object" );
	}
}

class sbAppendCodePoint extends stringBuilderMethod {
	sbAppendCodePoint() {
		setName( "append" );
		setDesc( "Appends the string representation of the codePoint argument to this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "codePoint" );
		setReturns( "a reference to this object" );
	}
}

class sbCapacity extends stringBuilderMethod {
	sbCapacity() {
		setName( "capacity" );
		setDesc( "Returns the current capacity. The capacity is the amount of storage available for newly inserted characters, beyond which an allocation will occur." );
		setReturnType( "Public", "int" );
		setReturns( "the current capacity" );
	}
}

class sbCharAt extends stringBuilderMethod {
	sbCharAt() {
		setName( "charAt" );
		setDesc( "Returns the char value in this sequence at the specified index. The first char value is at index 0, the next at index 1, and so on, as in array indexing." );
		setReturnType( "Public", "char" );
		addParam( "int", "index" );
		setReturns( "the char value at the specified index" );
	}
}

class sbCodePointAt extends stringBuilderMethod {
	sbCodePointAt() {
		setName( "codePointAt" );
		setDesc( "Returns the character (Unicode code point) at the specified index. The index refers to char values (Unicode code units) and ranges from 0 to length() - 1." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		setReturns( "the code point value of the character at the index" );
	}
}

class sbCodePointBefore extends stringBuilderMethod {
	sbCodePointBefore() {
		setName( "codePointBefore" );
		setDesc( "Returns the character (Unicode code point) before the specified index. The index refers to char values (Unicode code units) and ranges from 1 to length()." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		setReturns( "the Unicode code point value before the given index." );
	}
}

class sbCodePointCount extends stringBuilderMethod {
	sbCodePointCount() {
		setName( "codePointCount" );
		setDesc( "Returns the number of Unicode code points in the specified text range of this sequence. The text range begins at the specified beginIndex and extends to the char at index endIndex - 1. Thus the length (in chars) of the text range is endIndex-beginIndex. Unpaired surrogates within this sequence count as one code point each." );
		setReturnType( "Public", "int" );
		addParam( "int", "beginIndex" );
		addParam( "int", "endIndex" );
		setReturns( "the number of Unicode code points in the specified text range" );
	}
}

class sbDelete extends stringBuilderMethod {
	sbDelete() {
		setName( "delete" );
		setDesc( "Removes the characters in a substring of this sequence. The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists. If start is equal to end, no changes are made." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "This object" );
	}
}

class sbDeleteCharAt extends stringBuilderMethod {
	sbDeleteCharAt() {
		setName( "deleteCharAt" );
		setDesc( "Removes the char at the specified position in this sequence. This sequence is shortened by one char." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "index" );
		setReturns( "This object" );
	}
}

class sbEnsureCapacity extends stringBuilderMethod {
	sbEnsureCapacity() {
		setName( "ensureCapacity" );
		setDesc( "Ensures that the capacity is at least equal to the specified minimum. If the current capacity is less than the argument, then a new internal array is allocated with greater capacity. The new capacity is the larger of:" );
		setReturnType( "Public", "void" );
		addParam( "int", "minimumCapacity" );
	}
}

class sbGetChars extends stringBuilderMethod {
	sbGetChars() {
		setName( "getChars" );
		setDesc( "Characters are copied from this sequence into the destination character array dst. The first character to be copied is at index srcBegin; the last character to be copied is at index srcEnd-1. The total number of characters to be copied is srcEnd-srcBegin." );
		setReturnType( "Public", "void" );
		addParam( "int", "srcBegin" );
		addParam( "int", "srcEnd" );
		addParam( "char[]", "dst" );
		addParam( "int", "dstBegin" );
	}
}

class sbIndexOf extends stringBuilderMethod {
	sbIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "if the string argument occurs as a substring within this object, then the index of the first character of the first such substring is returned; if it does not occur as a substring, -1 is returned." );
	}
}

class sbIndexOf2 extends stringBuilderMethod {
	sbIndexOf2() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring, starting at the specified index." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		addParam( "int", "fromIndex" );
		setReturns( "the index within this string of the first occurrence of the specified substring, starting at the specified index." );
	}
}

class sbInsert extends stringBuilderMethod {
	sbInsert() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the boolean argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "boolean", "b" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert2 extends stringBuilderMethod {
	sbInsert2() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the char argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "char", "c" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert3 extends stringBuilderMethod {
	sbInsert3() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the char array argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "char[]", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert4 extends stringBuilderMethod {
	sbInsert4() {
		setName( "insert" );
		setDesc( "Inserts the string representation of a subarray of the str array argument into this sequence. The subarray begins at the specified offset and extends len chars. The characters of the subarray are inserted into this sequence at the position indicated by index. The length of this sequence increases by len chars." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "index" );
		addParam( "char[]", "str" );
		addParam( "int", "offset" );
		addParam( "int", "len" );
		setReturns( "This object");
	}
}

class sbInsert5 extends stringBuilderMethod {
	sbInsert5() {
		setName( "insert" );
		setDesc( "Inserts the specified CharSequence into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "CharSequence", "s" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert6 extends stringBuilderMethod {
	sbInsert6() {
		setName( "insert" );
		setDesc( "Inserts a subsequence of the specified CharSequence into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "dstOffset" );
		addParam( "CharSequence", "s" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert7 extends stringBuilderMethod {
	sbInsert7() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the double argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "double", "d" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert8 extends stringBuilderMethod {
	sbInsert8() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the float argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "float", "f" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert9 extends stringBuilderMethod {
	sbInsert9() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the second int argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "int", "i" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert10 extends stringBuilderMethod {
	sbInsert10() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the long argument into this sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "long", "l" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert11 extends stringBuilderMethod {
	sbInsert11() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the Object argument into this character sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "Object", "Obj" );
		setReturns( "a reference to this object" );
	}
}

class sbInsert12 extends stringBuilderMethod {
	sbInsert12() {
		setName( "insert" );
		setDesc( "Inserts the string into this character sequence." );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "offset" );
		addParam( "String", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbLastIndexOf extends stringBuilderMethod {
	sbLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the rightmost occurrence of the specified substring. The rightmost empty string \"\" is considered to occur at the index value this.length(). The returned index is the largest value k such that" );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "if the string argument occurs one or more times as a substring within this object, then the index of the first character of the last such substring is returned. If it does not occur as a substring, -1 is returned." );
	}
}

class sbLastIndexOf2 extends stringBuilderMethod {
	sbLastIndexOf2() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified substring." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		addParam( "int", "fromIndex" );
		setReturns( "the index within this sequence of the last occurrence of the specified substring." );
	}
}

class sbLength extends stringBuilderMethod {
	sbLength() {
		setName( "length" );
		setDesc( "Returns the length (character count)." );
		setReturnType( "Public", "int" );
		setReturns( "the length of the sequence of characters currently represented by this object" );
	}
}

class sbOffsetByCodePoints extends stringBuilderMethod {
	sbOffsetByCodePoints() {
		setName( "offsetByCodePoints" );
		setDesc( "Returns the index within this sequence that is offset from the given index by codePointOffset code points. Unpaired surrogates within the text range given by index and codePointOffset count as one code point each." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		addParam( "int", "codePointOffset" );
		setReturns( "the index within this sequence" );
	}
}

class sbReplace extends stringBuilderMethod {
	sbReplace() {
		setName( "replace" );
		setDesc( "Replaces the characters in a substring of this sequence with characters in the specified String. The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists. First the characters in the substring are removed and then the specified String is inserted at start. (This sequence will be lengthened to accommodate the specified String if necessary.)" );
		setReturnType( "Public", "StringBuilder" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		addParam( "String", "str" );
		setReturns( "This object" );
	}
}

class sbReverse extends stringBuilderMethod {
	sbReverse() {
		setName( "reverse" );
		setDesc( "Causes this character sequence to be replaced by the reverse of the sequence. If there are any surrogate pairs included in the sequence, these are treated as single characters for the reverse operation. Thus, the order of the high-low surrogates is never reversed. Let n be the character length of this character sequence (not the length in char values) just prior to execution of the reverse method. Then the character at index k in the new character sequence is equal to the character at index n-k-1 in the old character sequence." );
		setReturnType( "Public", "StringBuilder" );
		setReturns( "a reference to this object" );
	}
}

class sbSetCharAt extends stringBuilderMethod {
	sbSetCharAt() {
		setName( "setCharAt" );
		setDesc( "The character at the specified index is set to ch. This sequence is altered to represent a new character sequence that is identical to the old character sequence, except that it contains the character ch at position index." );
		setReturnType( "Public", "void" );
		addParam( "int", "index" );
		addParam( "char", "ch" );
	}
}

class sbSetLength extends stringBuilderMethod {
	sbSetLength() {
		setName( "setLength" );
		setDesc( "Sets the length of the character sequence. The sequence is changed to a new character sequence whose length is specified by the argument. For every nonnegative index k less than newLength, the character at index k in the new character sequence is the same as the character at index k in the old sequence if k is less than the length of the old character sequence; otherwise, it is the null character '\u0000'. In other words, if the newLength argument is less than the current length, the length is changed to the specified length." );
		setReturnType( "Public", "void" );
		addParam( "int", "newLength" );
	}
}

class sbSubSequence extends stringBuilderMethod {
	sbSubSequence() {
		setName( "subSequence" );
		setDesc( "Returns a new character sequence that is a subsequence of this sequence." );
		setReturnType( "Public", "CharSequence" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "the specified subsequence" );
	}
}

class sbSubstring extends stringBuilderMethod {
	sbSubstring() {
		setName( "substring" );
		setDesc( "Returns a new String that contains a subsequence of characters currently contained in this character sequence. The substring begins at the specified index and extends to the end of this sequence." );
		setReturnType( "Public", "String" );
		addParam( "int", "start" );
		setReturns( "The new string" );
	}
}

class sbSubstring2 extends stringBuilderMethod {
	sbSubstring2() {
		setName( "substring" );
		setDesc( "Returns a new String that contains a subsequence of characters currently contained in this sequence. The substring begins at the specified start and extends to the character at index end - 1." );
		setReturnType( "Public", "String" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "The new string." );
	}
}

class sbToString extends stringBuilderMethod {
	sbToString() {
		setName( "toString" );
		setDesc( "Returns a string representing the data in this sequence. A new String object is allocated and initialized to contain the character sequence currently represented by this object. This String is then returned. Subsequent changes to this sequence do not affect the contents of the String." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of this sequence of characters." );
	}
}

class sbTrimToSize extends stringBuilderMethod {
	sbTrimToSize() {
		setName( "trimToSize" );
		setDesc( "Attempts to reduce storage used for the character sequence. If the buffer is larger than necessary to hold its current sequence of characters, then it may be resized to become more space efficient. Calling this method may, but is not required to, affect the value returned by a subsequent call to the capacity() method." );
		setReturnType( "Public", "void" );
	}
}

/*************************************************************
**********************STRINGBUFFER METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class stringBufferConstructor extends Constructor {
	stringBufferConstructor() { 
		setName( "StringBuffer" );
		setEnclosingClass( "StringBuffer" );
	}
}

class StringBuffer1 extends stringBufferConstructor {
	StringBuffer1() {
		setDesc( "Constructs a string buffer with no characters in it and an initial capacity of 16 characters." );
	}
}

class StringBuffer2 extends stringBufferConstructor {
	StringBuffer2() {
		addParam( "CharSequence", "seq" );
		setDesc( "Constructs a string builder that contains the same characters as the specified CharSequence." );
	}
}

class StringBuffer3 extends stringBufferConstructor {
	StringBuffer3() {
		addParam( "int", "capacity" );
		setDesc( "Constructs a string buffer with no characters in it and the specified initial capacity." );
	}
}

class StringBuffer4 extends stringBufferConstructor {
	StringBuffer4() {
		addParam( "String", "str" );
		setDesc( "Constructs a string buffer initialized to the contents of the specified string. The initial capacity of the string buffer is 16 plus the length of the string argument." );
	}
}

/**************************METHODS**************************/

abstract class stringBufferMethod extends Method {
	stringBufferMethod() {
		setEnclosingClass( "StringBuffer" );
	}
}

class sbufAppend extends stringBufferMethod {
	sbufAppend() {
		setName( "append" );
		setDesc( "Appends the string representation of the boolean argument to the sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "boolean", "b" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend2 extends stringBufferMethod {
	sbufAppend2() {
		setName( "append" );
		setDesc( "Appends the string representation of the char argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "char", "c" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend3 extends stringBufferMethod {
	sbufAppend3() {
		setName( "append" );
		setDesc( "Appends the string representation of the char array argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "char[]", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend4 extends stringBufferMethod {
	sbufAppend4() {
		setName( "append" );
		setDesc( "Appends the string representation of a subarray of the char array argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "char[]", "str" );
		addParam( "int", "offset" );
		addParam( "int", "len" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend5 extends stringBufferMethod {
	sbufAppend5() {
		setName( "append" );
		setDesc( "Appends the specified  CharSequence to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "CharSequence", "s" );
		setReturns( "a reference to this Appendable" );
	}
}

class sbufAppend6 extends stringBufferMethod {
	sbufAppend6() {
		setName( "append" );
		setDesc( "Appends a subsequence of the specified CharSequence to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "CharSequence", "s" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend7 extends stringBufferMethod {
	sbufAppend7() {
		setName( "append" );
		setDesc( "Appends the string representation of the double argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "double", "d" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend8 extends stringBufferMethod {
	sbufAppend8() {
		setName( "append" );
		setDesc( "Appends the string representation of the float argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "float", "f" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend9 extends stringBufferMethod {
	sbufAppend9() {
		setName( "append" );
		setDesc( "Appends the string representation of the int argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "i" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend10 extends stringBufferMethod {
	sbufAppend10() {
		setName( "append" );
		setDesc( "Appends the string representation of the long argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "long", "lng" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend11 extends stringBufferMethod {
	sbufAppend11() {
		setName( "append" );
		setDesc( "Appends the string representation of the Object argument." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "Object", "obj" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend12 extends stringBufferMethod {
	sbufAppend12() {
		setName( "append" );
		setDesc( "Appends the specified string to this character sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "String", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppend13 extends stringBufferMethod {
	sbufAppend13() {
		setName( "append" );
		setDesc( "Appends the specified StringBuffer to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "StringBuffer", "sb" );
		setReturns( "a reference to this object" );
	}
}

class sbufAppendCodePoint extends stringBufferMethod {
	sbufAppendCodePoint() {
		setName( "append" );
		setDesc( "Appends the string representation of the codePoint argument to this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "codePoint" );
		setReturns( "a reference to this object" );
	}
}

class sbufCapacity extends stringBufferMethod {
	sbufCapacity() {
		setName( "capacity" );
		setDesc( "Returns the current capacity. The capacity is the amount of storage available for newly inserted characters, beyond which an allocation will occur." );
		setReturnType( "Public", "int" );
		setReturns( "the current capacity" );
	}
}

class sbufCharAt extends stringBufferMethod {
	sbufCharAt() {
		setName( "charAt" );
		setDesc( "Returns the char value in this sequence at the specified index. The first char value is at index 0, the next at index 1, and so on, as in array indexing." );
		setReturnType( "Public", "char" );
		addParam( "int", "index" );
		setReturns( "the char value at the specified index" );
	}
}

class sbufCodePointAt extends stringBufferMethod {
	sbufCodePointAt() {
		setName( "codePointAt" );
		setDesc( "Returns the character (Unicode code point) at the specified index. The index refers to char values (Unicode code units) and ranges from 0 to length() - 1." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		setReturns( "the code point value of the character at the index" );
	}
}

class sbufCodePointBefore extends stringBufferMethod {
	sbufCodePointBefore() {
		setName( "codePointBefore" );
		setDesc( "Returns the character (Unicode code point) before the specified index. The index refers to char values (Unicode code units) and ranges from 1 to length()." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		setReturns( "the Unicode code point value before the given index." );
	}
}

class sbufCodePointCount extends stringBufferMethod {
	sbufCodePointCount() {
		setName( "codePointCount" );
		setDesc( "Returns the number of Unicode code points in the specified text range of this sequence. The text range begins at the specified beginIndex and extends to the char at index endIndex - 1. Thus the length (in chars) of the text range is endIndex-beginIndex. Unpaired surrogates within this sequence count as one code point each." );
		setReturnType( "Public", "int" );
		addParam( "int", "beginIndex" );
		addParam( "int", "endIndex" );
		setReturns( "the number of Unicode code points in the specified text range" );
	}
}

class sbufDelete extends stringBufferMethod {
	sbufDelete() {
		setName( "delete" );
		setDesc( "Removes the characters in a substring of this sequence. The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists. If start is equal to end, no changes are made." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "This object" );
	}
}

class sbufDeleteCharAt extends stringBufferMethod {
	sbufDeleteCharAt() {
		setName( "deleteCharAt" );
		setDesc( "Removes the char at the specified position in this sequence. This sequence is shortened by one char." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "index" );
		setReturns( "This object" );
	}
}

class sbufEnsureCapacity extends stringBufferMethod {
	sbufEnsureCapacity() {
		setName( "ensureCapacity" );
		setDesc( "Ensures that the capacity is at least equal to the specified minimum. If the current capacity is less than the argument, then a new internal array is allocated with greater capacity. The new capacity is the larger of:" );
		setReturnType( "Public", "void" );
		addParam( "int", "minimumCapacity" );
	}
}

class sbufGetChars extends stringBufferMethod {
	sbufGetChars() {
		setName( "getChars" );
		setDesc( "Characters are copied from this sequence into the destination character array dst. The first character to be copied is at index srcBegin; the last character to be copied is at index srcEnd-1. The total number of characters to be copied is srcEnd-srcBegin." );
		setReturnType( "Public", "void" );
		addParam( "int", "srcBegin" );
		addParam( "int", "srcEnd" );
		addParam( "char[]", "dst" );
		addParam( "int", "dstBegin" );
	}
}

class sbufIndexOf extends stringBufferMethod {
	sbufIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "if the string argument occurs as a substring within this object, then the index of the first character of the first such substring is returned; if it does not occur as a substring, -1 is returned." );
	}
}

class sbufIndexOf2 extends stringBufferMethod {
	sbufIndexOf2() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring, starting at the specified index." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		addParam( "int", "fromIndex" );
		setReturns( "the index within this string of the first occurrence of the specified substring, starting at the specified index." );
	}
}

class sbufInsert extends stringBufferMethod {
	sbufInsert() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the boolean argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "boolean", "b" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert2 extends stringBufferMethod {
	sbufInsert2() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the char argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "char", "c" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert3 extends stringBufferMethod {
	sbufInsert3() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the char array argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "char[]", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert4 extends stringBufferMethod {
	sbufInsert4() {
		setName( "insert" );
		setDesc( "Inserts the string representation of a subarray of the str array argument into this sequence. The subarray begins at the specified offset and extends len chars. The characters of the subarray are inserted into this sequence at the position indicated by index. The length of this sequence increases by len chars." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "index" );
		addParam( "char[]", "str" );
		addParam( "int", "offset" );
		addParam( "int", "len" );
		setReturns( "This object");
	}
}

class sbufInsert5 extends stringBufferMethod {
	sbufInsert5() {
		setName( "insert" );
		setDesc( "Inserts the specified CharSequence into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "CharSequence", "s" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert6 extends stringBufferMethod {
	sbufInsert6() {
		setName( "insert" );
		setDesc( "Inserts a subsequence of the specified CharSequence into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "dstOffset" );
		addParam( "CharSequence", "s" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert7 extends stringBufferMethod {
	sbufInsert7() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the double argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "double", "d" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert8 extends stringBufferMethod {
	sbufInsert8() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the float argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "float", "f" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert9 extends stringBufferMethod {
	sbufInsert9() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the second int argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "int", "i" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert10 extends stringBufferMethod {
	sbufInsert10() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the long argument into this sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "long", "l" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert11 extends stringBufferMethod {
	sbufInsert11() {
		setName( "insert" );
		setDesc( "Inserts the string representation of the Object argument into this character sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "Object", "Obj" );
		setReturns( "a reference to this object" );
	}
}

class sbufInsert12 extends stringBufferMethod {
	sbufInsert12() {
		setName( "insert" );
		setDesc( "Inserts the string into this character sequence." );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "offset" );
		addParam( "String", "str" );
		setReturns( "a reference to this object" );
	}
}

class sbufLastIndexOf extends stringBufferMethod {
	sbufLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the rightmost occurrence of the specified substring. The rightmost empty string \"\" is considered to occur at the index value this.length(). The returned index is the largest value k such that" );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		setReturns( "if the string argument occurs one or more times as a substring within this object, then the index of the first character of the last such substring is returned. If it does not occur as a substring, -1 is returned." );
	}
}

class sbufLastIndexOf2 extends stringBufferMethod {
	sbufLastIndexOf2() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified substring." );
		setReturnType( "Public", "int" );
		addParam( "String", "str" );
		addParam( "int", "fromIndex" );
		setReturns( "the index within this sequence of the last occurrence of the specified substring." );
	}
}

class sbufLength extends stringBufferMethod {
	sbufLength() {
		setName( "length" );
		setDesc( "Returns the length (character count)." );
		setReturnType( "Public", "int" );
		setReturns( "the length of the sequence of characters currently represented by this object" );
	}
}

class sbufOffsetByCodePoints extends stringBufferMethod {
	sbufOffsetByCodePoints() {
		setName( "offsetByCodePoints" );
		setDesc( "Returns the index within this sequence that is offset from the given index by codePointOffset code points. Unpaired surrogates within the text range given by index and codePointOffset count as one code point each." );
		setReturnType( "Public", "int" );
		addParam( "int", "index" );
		addParam( "int", "codePointOffset" );
		setReturns( "the index within this sequence" );
	}
}

class sbufReplace extends stringBufferMethod {
	sbufReplace() {
		setName( "replace" );
		setDesc( "Replaces the characters in a substring of this sequence with characters in the specified String. The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists. First the characters in the substring are removed and then the specified String is inserted at start. (This sequence will be lengthened to accommodate the specified String if necessary.)" );
		setReturnType( "Public", "StringBuffer" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		addParam( "String", "str" );
		setReturns( "This object" );
	}
}

class sbufReverse extends stringBufferMethod {
	sbufReverse() {
		setName( "reverse" );
		setDesc( "Causes this character sequence to be replaced by the reverse of the sequence. If there are any surrogate pairs included in the sequence, these are treated as single characters for the reverse operation. Thus, the order of the high-low surrogates is never reversed. Let n be the character length of this character sequence (not the length in char values) just prior to execution of the reverse method. Then the character at index k in the new character sequence is equal to the character at index n-k-1 in the old character sequence." );
		setReturnType( "Public", "StringBuffer" );
		setReturns( "a reference to this object" );
	}
}

class sbufSetCharAt extends stringBufferMethod {
	sbufSetCharAt() {
		setName( "setCharAt" );
		setDesc( "The character at the specified index is set to ch. This sequence is altered to represent a new character sequence that is identical to the old character sequence, except that it contains the character ch at position index." );
		setReturnType( "Public", "void" );
		addParam( "int", "index" );
		addParam( "char", "ch" );
	}
}

class sbufSetLength extends stringBufferMethod {
	sbufSetLength() {
		setName( "setLength" );
		setDesc( "Sets the length of the character sequence. The sequence is changed to a new character sequence whose length is specified by the argument. For every nonnegative index k less than newLength, the character at index k in the new character sequence is the same as the character at index k in the old sequence if k is less than the length of the old character sequence; otherwise, it is the null character '\u0000'. In other words, if the newLength argument is less than the current length, the length is changed to the specified length." );
		setReturnType( "Public", "void" );
		addParam( "int", "newLength" );
	}
}

class sbufSubSequence extends stringBufferMethod {
	sbufSubSequence() {
		setName( "subSequence" );
		setDesc( "Returns a new character sequence that is a subsequence of this sequence." );
		setReturnType( "Public", "CharSequence" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "the specified subsequence" );
	}
}

class sbufSubstring extends stringBufferMethod {
	sbufSubstring() {
		setName( "insert" );
		setDesc( "Returns a new String that contains a subsequence of characters currently contained in this character sequence. The substring begins at the specified index and extends to the end of this sequence." );
		setReturnType( "Public", "String" );
		addParam( "int", "start" );
		setReturns( "The new string" );
	}
}

class sbufSubstring2 extends stringBufferMethod {
	sbufSubstring2() {
		setName( "substring" );
		setDesc( "Returns a new String that contains a subsequence of characters currently contained in this sequence. The substring begins at the specified start and extends to the character at index end - 1." );
		setReturnType( "Public", "String" );
		addParam( "int", "start" );
		addParam( "int", "end" );
		setReturns( "The new string." );
	}
}

class sbufToString extends stringBufferMethod {
	sbufToString() {
		setName( "toString" );
		setDesc( "Returns a string representing the data in this sequence. A new String object is allocated and initialized to contain the character sequence currently represented by this object. This String is then returned. Subsequent changes to this sequence do not affect the contents of the String." );
		setReturnType( "Public", "String" );
		setReturns( "a string representation of this sequence of characters." );
	}
}

class sbufTrimToSize extends stringBufferMethod {
	sbufTrimToSize() {
		setName( "trimToSize" );
		setDesc( "Attempts to reduce storage used for the character sequence. If the buffer is larger than necessary to hold its current sequence of characters, then it may be resized to become more space efficient. Calling this method may, but is not required to, affect the value returned by a subsequent call to the capacity() method." );
		setReturnType( "Public", "void" );
	}
}

