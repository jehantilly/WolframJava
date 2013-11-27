import java.util.ArrayList;


abstract class Method extends Searchable {
	class ParameterList {
		ParameterList() {
			parameters = new ArrayList<String>();
		}
		ArrayList<String> parameters;
		
		public String toString() {
			String s = "(  ";
			for( int i = 0; i < parameters.size(); ++i ) {
				s += parameters.get(i);
				if ( i != parameters.size() - 1 ) {
					s += ",  ";
				}
			}
			s += "  )";
			return s;
		}
	}
	private ParameterList PL = new ParameterList();
	private String returnType;
	private String returns;
	private String enclosingClass;
	void addParam( String s ) {
		PL.parameters.add(s);
	}
	void setReturnType( String s ) {
		returnType = s;
	}
	void setReturns( String r ) {
		returns = r;
	}
	void setEnclosingClass( String S ) {
		enclosingClass = S;
	}
	String getReturnType() { return returnType; }
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
		setReturnType( null );
		setReturns( null );
	}
	
	public String toString() {
		return getName() + getParameters();
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
		addParam("E e");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class clAddAll extends clMethod {
	clAddAll() {
		setName( "addAll" );
		setDesc( "Adds all of the elements in the specified collection to this collection (optional operation)." );
		addParam("Collection<? extends E> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class clClear extends clMethod {
	clClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this collection(optional operation)." );
		setReturnType( "void" );
		setReturns( null );
	}
}

class clContains extends clMethod {
	clContains() {
		setName( "contains" );
		setDesc( "Returns true if this collection contains the specified element." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection contains the specified element." );
	}
}

class clContainsAll extends clMethod {
	clContainsAll() {
		setName( "containsAll" );
		setDesc( "Returns true if this collection contains all of the elements in the specified collection." );
		addParam("Collection<?> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection contains all of the elements in the specified collection." );
	}
}

class clIsEmpty extends clMethod {
	clIsEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns 'true' if this collection contains no elements." );
		setReturnType( "boolean" );
		setReturns( "'true' if this collection contains no elements." );
	}
}

class clIterator extends clMethod {
	clIterator() {
		setName( "iterator" );
		setDesc( "Returns an iterator over the elements in this collection." );
		setReturnType( "Iterator<E>" );
		setReturns( "an Iterator over the elements in this collection." );
	}
}

class clRemove extends clMethod {
	clRemove() {
		setName( "remove" );
		setDesc( "Removes a single instance of the specified element from this collection, if it is present (optional operation)." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if an element was removed as a result of this call." );
	}
}

class clRemoveAll extends clMethod {
	clRemoveAll() {
		setName( "removeAll" );
		setDesc( "Removes all of this collection's elements that are also contained in the specified collection (optional operation)." );
		addParam("Collection<?> c");
		setReturnType( "boolean" );
		setReturns( "'true' if the collection changes as a result of the call." );
	}
}

class clRetainAll extends clMethod {
	clRetainAll() {
		setName( "retainAll" );
		setDesc( "Retains only the elements in this collection that are contained in the specified collection (optional operation)." );
		addParam("Collection<?> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class clSize extends clMethod {
	clSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this collection. If the size is larger than 'Integer.MAX_VALUE', then 'Integer.MAX_VALUE' is returned." );
		setReturnType( "int" );
		setReturns( "the number of elements in this collection." );
	}
}

class clToArray extends clMethod {
	clToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this collection." );
		setReturnType( "Object[]" );
		setReturns( "an array containing all of the elements in this collection." );
	}
}

class clToArray2 extends clMethod {
	clToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this collection. If the collection fits in the array that is passed as an argument, then that same array will be returned. Otherwise, a new array is allocated and returned storing all of the elements in the collection." );
		addParam("T[] a");
		setReturnType( "T[]" );
		setReturns( "an array containing all of the elements in this collection." );
	}
}

class clToString extends clMethod {
	clToString() {
		setName( "toString" );
		setDesc( "Returns a string representation of this collection." );
		setReturnType( "String" );
		setReturns( "a string representation of this collection." );
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
		addParam( "Collection<? extends E> c" );
	}
}

class Vector3 extends vecConstructor {
	Vector3() {
		setDesc( "Constructs an empty vector with the specified initial capacity and with its capacity increment equal to zero." );
		addParam( "int initialCapacity" );
	}
}

class Vector4 extends vecConstructor {
	Vector4() {
		setDesc( "Constructs an empty vector with the specified initial capacity and capacity increment." );
		addParam( "int initialCapacity" );
		addParam( "int capacityIncrement" );
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
		addParam("E e");
		setReturnType( "boolean" );
		setReturns( "'true' if this Vector changes as a result of the call." );
	}
}

class vecAdd2 extends vecMethod {
	vecAdd2() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this Vector. Shifts all subsequent elements to the right." );
		addParam("int index");
		addParam("E element");
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecAddAll extends vecMethod {
	vecAddAll() {
		setName( "addAll" );
		setDesc( "Appends all of the elements in the specified collection to the end of this Vector." );
		addParam("Collection<? extends E> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class vecAddAll2 extends vecMethod {
	vecAddAll2() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified Collection into this Vector at the specified position. Shifts all subsequent elements to the right." );
		addParam("int index");
		addParam("Collection<? extends E> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this collection changes as a result of the call." );
	}
}

class vecAddElement extends vecMethod {
	vecAddElement() {
		setName( "addElement" );
		setDesc( "Adds the specified component to the end of this vector." );
		addParam("E obj");
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecCapacity extends vecMethod {
	vecCapacity() {
		setName( "capacity" );
		setDesc( "Returns the current capacity of this vector." );
		setReturnType( "int" );
		setReturns( "the current capacity" );
	}
}



class vecClear extends vecMethod {
	vecClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this Vector." );
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecClone extends vecMethod {
	vecClone() {
		setName( "clone" );
		setDesc( "Returns a clone of this vector. Copy will refer to a new internal data array, not the original." );
		setReturnType( "Object" );
		setReturns( "a clone of this vector." );
	}
}


class vecContains extends vecMethod {
	vecContains() {
		setName( "contains" );
		setDesc( "Returns true if this Vector contains the specified element." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if this Vector contains the specified element." );
	}
}

class veccontainsAll extends vecMethod {
	veccontainsAll() {
		setName( "containsAll" );
		setDesc( "Returns true if this Vector contains all of the elements in the specified collection." );
		addParam("Collection<?> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this Vector contains all of the elements in the specified collection." );
	}
}

class vecCopyInto extends vecMethod {
	vecCopyInto() {
		setName( "copyInto" );
		setDesc( "Copies the components of this vector into the specified array." );
		addParam("Object[] anArray");
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecElementAt extends vecMethod {
	vecElementAt() {
		setName( "elementAt" );
		setDesc( "Returns the component at the specified index." );
		addParam("int index");
		setReturnType( "E" );
		setReturns( "the component at the specified index." );
	}
}

class vecElements extends vecMethod {
	vecElements() {
		setName( "elements" );
		setDesc( "Returns an enumeration of the components of this vector." );
		setReturnType( "Enumeration<E>" );
		setReturns( "an enumeration of the components of this vector." );
	}
}

class vecEnsureCapacity extends vecMethod {
	vecEnsureCapacity() {
		setName( "ensureCapacity" );
		setDesc( "Increases the capacity of this vector, if necessary, to ensure that it can hold at least the number of components specified by the minimum capacity argument." );
		addParam("int minCapacity");
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecequals extends vecMethod {
	vecequals() {
		setName( "equals" );
		setDesc( "Compares the specified object with this Vector for equality." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if specified object is equal to this Vector." );
	}
}

class vecFirstElement extends vecMethod {
	vecFirstElement() {
		setName( "firstElement" );
		setDesc( "Returns the first component (the item at index 0) of this vector." );
		setReturnType( "E" );
		setReturns( "the first component of this vector." );
	}
}

class vecGet extends vecMethod {
	vecGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this Vector." );
		addParam("int index");
		setReturnType( "E" );
		setReturns( "object at the specified index." );
	}
}

class vechashCode extends vecMethod {
	vechashCode() {
		setName( "hashCode" );
		setDesc( "Returns the hash code value for this Vector." );
		setReturnType( "int" );
		setReturns( "the hash code value for this Vector." );
	}
}

class vecIndexOf extends vecMethod {
	vecIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
		addParam("Object o");
		setReturnType( "int" );
		setReturns( "the index of the first occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
	}
}

class vecIndexOf2 extends vecMethod {
	vecIndexOf2() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this vector, searching forward from index, or returns -1 if this vector does not contain the element." );
		addParam("Object o");
		addParam( "int index");
		setReturnType( "int" );
		setReturns( "the index of the first occurrence of the specified element in this vector at position 'index' or later, or -1 if this vector does not contain the element." );
	}
}

class vecInsertElementAt extends vecMethod {
	vecInsertElementAt() {
		setName( "insertElementAt" );
		setDesc( "Inserts the specified object as a component in this vector at the specified index." );
		addParam("E obj");
		addParam("int index");
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecisEmpty extends vecMethod {
	vecisEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns 'true' if this Vector contains no elements." );
		setReturnType( "boolean" );
		setReturns( "'true' if this Vector contains no elements." );
	}
}

class vecLastElement extends vecMethod {
	vecLastElement() {
		setName( "lastElement" );
		setDesc( "Returns the last component of the vector." );
		setReturnType( "E" );
		setReturns( "the last component of this vector." );
	}
}

class vecLastIndexOf extends vecMethod {
	vecLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index of the last occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
		addParam( "Object o" );
		setReturnType( "int" );
		setReturns( "the index of the last occurrence of the specified element in this vector, or -1 if this vector does not contain the element." );
	}
}

class vecLastIndexOf2 extends vecMethod {
	vecLastIndexOf2() {
		setName( "lastIndexOf2" );
		setDesc( "Returns the index of the last occurrence of the specified element in this vector, searching backwards from 'index', or returns -1 if the element is not found." );
		addParam( "Object o" );
		addParam( "int index" );
		setReturnType( "int" );
		setReturns( "the index of the last occurrence of the specified element as position 'index' or less, or -1 if this vector does not contain the element." );
	}
}

class vecRemove extends vecMethod {
	vecRemove() {
		setName( "remove" );
		setDesc( "Removes the first occurrence of the specified element in this Vector, if it is present." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if the vector contains the specified element." );
	}
}

class vecRemove2 extends vecMethod {
	vecRemove2() {
		setName( "remove" );
		setDesc( "Removes the element at the specified position in this Vector." );
		addParam("int index");
		setReturnType( "E" );
		setReturns( "the element that was removed." );
	}
}

class vecRemoveAll extends vecMethod {
	vecRemoveAll() {
		setName( "removeAll" );
		setDesc( "Removes from this Vector all of the elements that are also contained in the specified collection." );
		addParam("Collection<?> c");
		setReturnType( "boolean" );
		setReturns( "'true' if the Vector changes as a result of the call." );
	}
}

class vecRemoveAllElements extends vecMethod {
	vecRemoveAllElements() {
		setName( "removeAllElements" );
		setDesc( "Removes all components from this vector and sets its size to zero." );
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecRemoveElement extends vecMethod {
	vecRemoveElement() {
		setName( "removeElement" );
		setDesc( "Removes the first occurrence of the argument from this vector." );
		addParam( "Object obj" );
		setReturnType( "boolean" );
		setReturns( "'true' if the argument was in this vector. 'false' otherwise." );
	}
}

class vecRemoveElementAt extends vecMethod {
	vecRemoveElementAt() {
		setName( "removeElementAt" );
		setDesc( "Deletes the component at the specified index." );
		addParam( "int index" );
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecRemoveRange extends vecMethod {
	vecRemoveRange() {
		setName( "removeRange" );
		setDesc( "Removes all of the elements whose index is between 'fromIndex' (inclusive) and 'toIndex' (exclusive)." );
		addParam( "int fromIndex" );
		addParam( "int toIndex" );
		setReturnType( "protected void" );
		setReturns( null );
	}
}

class vecRetainAll extends vecMethod {
	vecRetainAll() {
		setName( "retainAll" );
		setDesc( "Retains only the elements in this Vectorn that are contained in the specified collection (optional operation)." );
		addParam("Collection<?> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this Vector changes as a result of the call." );
	}
}

class vecSet extends vecMethod {
	vecSet() {
		setName( "set" );
		setDesc( "Replaces the element at the specified position in this Vector with the specified element." );
		addParam( "int index" );
		addParam( "E element" );
		setReturnType( "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class vecSetElementAt extends vecMethod {
	vecSetElementAt() {
		setName( "setElementAt" );
		setDesc( "Sets the component at the specified index of this vector to be the specified object." );
		addParam( "E obj" );
		addParam( "int index" );
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecSetSize extends vecMethod {
	vecSetSize() {
		setName( "setSize" );
		setDesc( "Sets the size of this vector." );
		addParam( "int newSize" );
		setReturnType( "void" );
		setReturns( null );
	}
}

class vecSize extends vecMethod {
	vecSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this Vector." );
		setReturnType( "int" );
		setReturns( "the number of elements in this Vector." );
	}
}

class vecSubList extends vecMethod {
	vecSubList() {
		setName( "subList" );
		setDesc( "Returns a list of the portion of this Vector between 'fromIndex' (inclusive) and 'toIndex' (exclusive)." );
		addParam( "int fromIndex" );
		addParam( "int toIndex" );
		setReturnType( "List<E>" );
		setReturns( "a list of the specified range within this Vector." );
	}
}

class vecToArray extends vecMethod {
	vecToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this Vector." );
		setReturnType( "Object[]" );
		setReturns( "an array containing all of the elements in this Vector." );
	}
}

class vecToArray2 extends vecMethod {
	vecToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this Vector." );
		addParam("T[] a");
		setReturnType( "T[]" );
		setReturns( "an array containing all of the elements in this Vector." );
	}
}

class vecToString extends vecMethod {
	vecToString() {
		setName( "toString" );
		setDesc( "Returns a String representation of this Vector, containing the String representation of each element." );
		setReturnType( "String" );
		setReturns( "a String representation of this Vector." );
	}
}

class vecTrimToSize extends vecMethod {
	vecTrimToSize() {
		setName( "trimToSize" );
		setDesc( "Trims the capacity of this vector to be the vector's current size." );
		setReturnType( "void" );
		setReturns( null );
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
		addParam( "Collection<? extends E> c" );
	}
}

class ArrayList3 extends arrConstructor {
	ArrayList3() {
		setDesc( "Constructs an empty list with the specified initial capacity." );
		addParam( "int initialCapacity" );
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
		addParam("E e");
		setReturnType( "boolean" );
		setReturns( "'true' if this ArrayList changes as a result of the call." );
	}
}

class arrAdd2 extends arrMethod {
	arrAdd2() {
		setName( "add" );
		setDesc( "Inserts the specified element at the specified position in this ArrayList." );
		addParam("int index");
		addParam("E element");
		setReturnType( "void" );
		setReturns( null );
	}
}

class arrAddAll extends arrMethod {
	arrAddAll() {
		setName( "addAll" );
		setDesc( "Appends all of the elements in the specified collection to the end of this ArrayList." );
		addParam("Collection<? extends E> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this ArrayList changes as a result of the call." );
	}
}

class arrAddAll2 extends arrMethod {
	arrAddAll2() {
		setName( "addAll" );
		setDesc( "Inserts all of the elements in the specified Collection into this ArrayList at the specified position." );
		addParam("int index");
		addParam("Collection<? extends E> c");
		setReturnType( "boolean" );
		setReturns( "'true' if this ArrayList changes as a result of the call." );
	}
}

class arrClear extends arrMethod {
	arrClear() {
		setName( "clear" );
		setDesc( "Removes all of the elements from this ArrayList." );
		setReturnType( "void" );
		setReturns( null );
	}
}

class arrClone extends arrMethod {
	arrClone() {
		setName( "clone" );
		setDesc( "Returns a shallow copy of this ArrayList instance." );
		setReturnType( "Object" );
		setReturns( "a clone of this ArrayList." );
	}
}


class arrContains extends arrMethod {
	arrContains() {
		setName( "contains" );
		setDesc( "Returns true if this ArrayList contains the specified element." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if this ArrayList contains the specified element." );
	}
}

class arrEnsureCapacity extends arrMethod {
	arrEnsureCapacity() {
		setName( "ensureCapacity" );
		setDesc( "Increases the capacity of this ArrayList, if necessary, to ensure that it can hold at least the number of components specified by the minimum capacity argument." );
		addParam("int minCapacity");
		setReturnType( "void" );
		setReturns( null );
	}
}

class arrGet extends arrMethod {
	arrGet() {
		setName( "get" );
		setDesc( "Returns the element at the specified position in this ArrayList." );
		addParam("int index");
		setReturnType( "E" );
		setReturns( "object at the specified index." );
	}
}

class arrIndexOf extends arrMethod {
	arrIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index of the first occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
		addParam("Object o");
		setReturnType( "int" );
		setReturns( "the index of the first occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
	}
}

class arrIsEmpty extends arrMethod {
	arrIsEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns 'true' if this ArrayList contains no elements." );
		setReturnType( "boolean" );
		setReturns( "'true' if this ArrayList contains no elements." );
	}
}

class arrLastIndexOf extends arrMethod {
	arrLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index of the last occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
		addParam( "Object o" );
		setReturnType( "int" );
		setReturns( "the index of the last occurrence of the specified element in this ArrayList, or -1 if this ArrayList does not contain the element." );
	}
}

class arrRemove extends arrMethod {
	arrRemove() {
		setName( "remove" );
		setDesc( "Removes the first occurrence of the specified element in this ArrayList, if it is present." );
		addParam("Object o");
		setReturnType( "boolean" );
		setReturns( "'true' if the ArrayList contains the specified element." );
	}
}

class arrRemove2 extends arrMethod {
	arrRemove2() {
		setName( "remove" );
		setDesc( "Removes the element at the specified position in this ArrayList." );
		addParam("int index");
		setReturnType( "E" );
		setReturns( "the element that was removed." );
	}
}

class arrRemoveRange extends arrMethod {
	arrRemoveRange() {
		setName( "removeRange" );
		setDesc( "Removes all of the elements whose index is between 'fromIndex' (inclusive) and 'toIndex' (exclusive)." );
		addParam( "int fromIndex" );
		addParam( "int toIndex" );
		setReturnType( "protected void" );
		setReturns( null );
	}
}

class arrSet extends arrMethod {
	arrSet() {
		setName( "set" );
		setDesc( "Replaces the element at the specified position in this ArrayList with the specified element." );
		addParam( "int index" );
		addParam( "E element" );
		setReturnType( "E" );
		setReturns( "the element previously at the specified position." );
	}
}

class arrSize extends arrMethod {
	arrSize() {
		setName( "size" );
		setDesc( "Returns the number of elements in this ArrayList." );
		setReturnType( "int" );
		setReturns( "the number of elements in this ArrayList." );
	}
}

class arrToArray extends arrMethod {
	arrToArray() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this ArrayList." );
		setReturnType( "Object[]" );
		setReturns( "an array containing all of the elements in this ArrayList." );
	}
}

class arrToArray2 extends arrMethod {
	arrToArray2() {
		setName( "toArray" );
		setDesc( "Returns an array containing all of the elements in this ArrayList." );
		addParam("T[] a");
		setReturnType( "T[]" );
		setReturns( "an array containing all of the elements in this ArrayList." );
	}
}

class arrTrimToSize extends arrMethod {
	arrTrimToSize() {
		setName( "trimToSize" );
		setDesc( "Trims the capacity of this ArrayList to be the ArrayList's current size." );
		setReturnType( "void" );
		setReturns( null );
	}
}

/*************************************************************
**********************NUMBER METHODS**************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

class Number1 extends Constructor {
	Number1() { 
		setName( "Number" );
		setEnclosingClass( "Number" );
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
		setReturnType( "byte" );
		setReturns( "the numeric value represented by this object after conversion to type byte." );
	}
}

class numDoubleValue extends numMethod {
	numDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of the specified number as a double." );
		setReturnType( "abstract double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class numFloatValue extends numMethod {
	numFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of the specified number as a float." );
		setReturnType( "abstract float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class numIntValue extends numMethod {
	numIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of the specified number as an int." );
		setReturnType( "abstract int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class numShortValue extends numMethod {
	numShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of the specified number as a short." );
		setReturnType( "abstract short" );
		setReturns( "the numeric value represented by this object after conversion to type short." );
	}
}

/*************************************************************
**********************INTEGER METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class IntConstructor extends Constructor {
	IntConstructor() { 
		setName( "Integer" );
		setEnclosingClass( "Integer" );
	}
}

class Integer1 extends IntConstructor {
	Integer1() {
		setDesc( "Constructs a newly allocated Integer object that represents the specified int value." );
		addParam( "int value" );
	}
}

class Integer2 extends IntConstructor {
	Integer2() {
		setDesc( "Constructs a newly allocated Integer object that represents the int value indicated by the String parameter." );
		addParam( "String s" );
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
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "the number of one-bits in the two's complement binary representation of the specified int value." );
	}
}

class intByteValue extends intMethod {
	intByteValue() {
		setName( "byteValue" );
		setDesc( "Returns the value of this Integer as a byte." );
		setReturnType( "byte" );
		setReturns( "the numeric value represented by this Integer after conversion to type byte." );
	}
}

class intCompare extends intMethod {
	intCompare() {
		setName( "compare" );
		setDesc( "Compares two ints numerically." );
		addParam( "int x" );
		addParam( "int y" );
		setReturnType( "static int" );
		setReturns( "the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y." );
	}
}

class intCompareTo extends intMethod {
	intCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Integer objects numerically." );
		addParam( "Integer anotherInteger" );
		setReturnType( "int" );
		setReturns( "the value 0 if this Integer is equal to the argument Integer; a value less than 0 if this Integer is numerically less than the argument Integer; and a value greater than 0 if this Integer is numerically greater than the argument Integer (signed comparison)." );
	}
}

class intDecode extends intMethod {
	intDecode() {
		setName( "decode" );
		setDesc( "Decodes a String into an Integer." );
		addParam( "String nm" );
		setReturnType( "static Integer" );
		setReturns( "an Integer object holding the int value represented by nm," );
	}
}

class intDoubleValue extends intMethod {
	intDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of this Integer as a double." );
		setReturnType( "double" );
		setReturns( "the numeric value represented by this Integer after conversion to type double." );
	}
}

class intEquals extends intMethod {
	intEquals() {
		setName( "equals" );
		setDesc( "Compares this Integer to the specified object." );
		addParam( "Object obj" );
		setReturnType( "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class intFloatValue extends intMethod {
	intFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of this Integer as a float." );
		setReturnType( "float" );
		setReturns( "the numeric value represented by this Integer after conversion to type float." );
	}
}

class intGetInteger extends intMethod {
	intGetInteger() {
		setName( "getInteger" );
		setDesc( "Determines the integer value of the system property with the specified name." );
		addParam( "String nm" );
		setReturnType( "static Integer" );
		setReturns( "the Integer value of the property." );
	}
}

class intGetInteger2 extends intMethod {
	intGetInteger2() {
		setName( "getInteger" );
		setDesc( "Determines the integer value of the system property with the specified name. The second argument is the default value. The default value is returned if there is no property of the specified name, if the property does not have the correct numeric format, or if the specified name is empty or null." );
		addParam( "String nm" );
		addParam( "int val" );
		setReturnType( "static Integer" );
		setReturns( "the Integer value of the property." );
	}
}

class intGetInteger3 extends intMethod {
	intGetInteger3() {
		setName( "getInteger" );
		setDesc( "Determines the integer value of the system property with the specified name. The second argument is the default value. The default value is returned if there is no property of the specified name, if the property does not have the correct numeric format, or if the specified name is empty or null." );
		addParam( "String nm" );
		addParam( "Integer val" );
		setReturnType( "static Integer" );
		setReturns( "the Integer value of the property." );
	}
}

class intHashCode extends intMethod {
	intHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Integer." );
		setReturnType( "int" );
		setReturns( "a hash code value for this object, equal to the primitive int value represented by this Integer object." );
	}
}

class intHighestOneBit extends intMethod {
	intHighestOneBit() {
		setName( "highestOneBit" );
		setDesc( "Returns an int value with at most a single one-bit, in the position of the highest-order (\"leftmost\") one-bit in the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "an int value with a single one-bit, in the position of the highest-order one-bit in the specified value, or zero if the specified value is itself equal to zero." );
	}
}

class intIntValue extends intMethod {
	intIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Integer as an int." );
		setReturnType( "int" );
		setReturns( "the numeric value represented by this Integer after conversion to type int." );
	}
}

class intLongValue extends intMethod {
	intLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Integer as a long." );
		setReturnType( "long" );
		setReturns( "the numeric value represented by this Integer after conversion to type long." );
	}
}

class intLowestOneBit extends intMethod {
	intLowestOneBit() {
		setName( "lowestOneBit" );
		setDesc( "Returns an int value with at most a single one-bit, in the position of the lowest-order (\"rightmost\") one-bit in the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "an int value with a single one-bit, in the position of the lowest-order one-bit in the specified value, or zero if the specified value is itself equal to zero." );
	}
}

class intNumberOfLeadingZeros extends intMethod {
	intNumberOfLeadingZeros() {
		setName( "numberOfLeadingZeros" );
		setDesc( "Returns the number of zero bits preceding the highest-order (\"leftmost\") one-bit in the two's complement binary representation of the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "the number of zero bits preceding the highest-order (\"leftmost\") one-bit in the two's complement binary representation of the specified int value, or 32 if the value is equal to zero." );
	}
}

class intNumberOfTrailingZeros extends intMethod {
	intNumberOfTrailingZeros() {
		setName( "numberOfTrailingZeros" );
		setDesc( "Returns the number of zero bits following the lowest-order (\"rightmost\") one-bit in the two's complement binary representation of the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "the number of zero bits following the lowest-order (\"rightmost\") one-bit in the two's complement binary representation of the specified int value, or 32 if the value is equal to zero." );
	}
}

class intParseInt extends intMethod {
	intParseInt() {
		setName( "parseInt" );
		setDesc( "Parses the string argument as a signed decimal integer." );
		addParam( "String s" );
		setReturnType( "static int" );
		setReturns( "the integer value represented by the argument in decimal." );
	}
}

class intParseInt2 extends intMethod {
	intParseInt2() {
		setName( "parseInt" );
		setDesc( "Parses the string argument as a signed integer in the radix specified by the second argument." );
		addParam( "String s" );
		addParam( "int radix" );
		setReturnType( "static int" );
		setReturns( "the integer represented by the string argument in the specified radix." );
	}
}

class intReverse extends intMethod {
	intReverse() {
		setName( "reverse" );
		setDesc( "Returns the value obtained by reversing the order of the bits in the two's complement binary representation of the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "the value obtained by reversing order of the bits in the specified int value." );
	}
}

class intReverseBytes extends intMethod {
	intReverseBytes() {
		setName( "reverse" );
		setDesc( "Returns the value obtained by reversing the order of the bytes in the two's complement representation of the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "the value obtained by reversing order of the bytes in the specified int value." );
	}
}

class intRotateLeft extends intMethod {
	intRotateLeft() {
		setName( "rotateLeft" );
		setDesc( "Returns the value obtained by rotating the two's complement binary representation of the specified int value left by the specified number of bits." );
		addParam( "int i" );
		addParam( "int distance" );
		setReturnType( "static int" );
		setReturns( "the value obtained by rotating the two's complement binary representation of the specified int value left by the specified number of bits." );
	}
}

class intRotateRight extends intMethod {
	intRotateRight() {
		setName( "rotateRight" );
		setDesc( "Returns the value obtained by rotating the two's complement binary representation of the specified int value right by the specified number of bits." );
		addParam( "int i" );
		addParam( "int distance" );
		setReturnType( "static int" );
		setReturns( "the value obtained by rotating the two's complement binary representation of the specified int value right by the specified number of bits." );
	}
}

class intShortValue extends intMethod {
	intShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Integer as a short." );
		setReturnType( "short" );
		setReturns( "the numeric value represented by this Integer after conversion to type short." );
	}
}

class intSigNum extends intMethod {
	intSigNum() {
		setName( "sigNum" );
		setDesc( "Returns the signum function of the specified int value." );
		addParam( "int i" );
		setReturnType( "static int" );
		setReturns( "the signum function of the specified int value." );
	}
}

class intToBinaryString extends intMethod {
	intToBinaryString() {
		setName( "toBinaryString" );
		setDesc( "Returns a string representation of the integer argument as an unsigned integer in base 2." );
		addParam( "int i" );
		setReturnType( "static String" );
		setReturns( "the string representation of the unsigned integer value represented by the argument in binary (base 2)." );
	}
}

class intToHexString extends intMethod {
	intToHexString() {
		setName( "toHexString" );
		setDesc( "Returns a string representation of the integer argument as an unsigned integer in base 16." );
		addParam( "int i" );
		setReturnType( "static String" );
		setReturns( "the string representation of the unsigned integer value represented by the argument in hexadecimal (base 16)." );
	}
}

class intToOctalString extends intMethod {
	intToOctalString() {
		setName( "toOctalString" );
		setDesc( "Returns a string representation of the integer argument as an unsigned integer in base 8." );
		addParam( "int i" );
		setReturnType( "static String" );
		setReturns( "the string representation of the unsigned integer value represented by the argument in Octal (base 8)." );
	}
}

class intToString extends intMethod {
	intToString() {
		setName( "toString" );
		setDesc( "Returns a String object representing this Integer's value." );
		setReturnType( "String" );
		setReturns( "a string representation of the value of this object in base 10." );
	}
}

class intToString2 extends intMethod {
	intToString2() {
		setName( "toString" );
		setDesc( "Returns a String object representing the specified integer." );
		addParam( "int i" );
		setReturnType( "static String" );
		setReturns( "a string representation of the value of the specified integer in base 10." );
	}
}

class intToString3 extends intMethod {
	intToString3() {
		setName( "toString" );
		setDesc( "Returns a string representation of the first argument in the radix specified by the second argument." );
		addParam( "int i" );
		addParam( "int radix" );
		setReturnType( "static String" );
		setReturns( "a string representation of the argument in the specified radix." );
	}
}

class intValueOf extends intMethod {
	intValueOf() {
		setName( "valueOf" );
		setDesc( "Returns an Integer instance representing the specified int value." );
		addParam( "int i" );
		setReturnType( "static Integer" );
		setReturns( "an Integer instance representing i." );
	}
}

class intValueOf2 extends intMethod {
	intValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns an Integer instance holding the value of the specified String." );
		addParam( "String s" );
		setReturnType( "static Integer" );
		setReturns( "an Integer object holding the value represented by the string argument." );
	}
}

class intValueOf3 extends intMethod {
	intValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns an Integer object holding the value extracted from the specified String when parsed with the radix given by the second argument." );
		addParam( "String s" );
		addParam( "int radix" );
		setReturnType( "static Integer" );
		setReturns( "an Integer object holding the value represented by the string argument in the specified radix." );
	}
}

/*************************************************************
**********************BYTE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class ByteConstructor extends Constructor {
	ByteConstructor() { 
		setName( "Byte" );
		setEnclosingClass( "Byte" );
	}
}

class Byte1 extends ByteConstructor {
	Byte1() {
		setDesc( "Constructs a newly allocated Byte object that represents the specified byte value." );
		addParam( "byte value" );
	}
}

class Byte2 extends ByteConstructor {
	Byte2() {
		setDesc( "Constructs a newly allocated Byte object that represents the byte value indicated by the String parameter." );
		addParam( "String s" );
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
		setReturnType( "byte" );
		setReturns( "the numeric value represented by this object after conversion to type byte." );
	}
}

class byteShortValue extends byteMethod {
	byteShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Byte as a short." );
		setReturnType( "short" );
		setReturns( "the numeric value represented by this object after conversion to type short." );
	}
}

class byteIntValue extends byteMethod {
	byteIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Byte as an int." );
		setReturnType( "int" );
		setReturns( "the numeric value represented by this object after conversion to type int." );
	}
}

class byteLongValue extends byteMethod {
	byteLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Byte as a long." );
		setReturnType( "long" );
		setReturns( "the numeric value represented by this object after conversion to type long." );
	}
}

class byteFloatValue extends byteMethod {
	byteFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the value of this Byte as a float." );
		setReturnType( "float" );
		setReturns( "the numeric value represented by this object after conversion to type float." );
	}
}

class byteDoubleValue extends byteMethod {
	byteDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the value of this Byte as a double." );
		setReturnType( "double" );
		setReturns( "the numeric value represented by this object after conversion to type double." );
	}
}

class byteToString extends byteMethod {
	byteToString() {
		setName( "toString" );
		setDesc( "Returns a String object representing this Byte's value. The value is converted to signed decimal representation and returned as a string, exactly as if the byte value were given as an argument to the toString(byte) method." );
		setReturnType( "String" );
		setReturns( "a string representation of the value of this object in base 10." );
	}
}

class byteToString2 extends byteMethod {
	byteToString2() {
		setName( "toString" );
		setDesc( "Returns a new String object representing the specified byte. The radix is assumed to be 10." );
		addParam( "byte b" );
		setReturnType( "static String" );
		setReturns( "the string representation of the specified byte." );
	}
}

class byteHashCode extends byteMethod {
	byteHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Byte." );
		setReturnType( "int" );
		setReturns( "a hash code value for this object." );
	}
}

class byteEquals extends byteMethod {
	byteEquals() {
		setName( "equals" );
		setDesc( "Compares this object to the specified object. The result is true if and only if the argument is not null and is a Byte object that contains the same byte value as this object." );
		addParam( "Object obj" );
		setReturnType( "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class byteCompareTo extends byteMethod {
	byteCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Byte objects numerically." );
		addParam( "Byte anotherByte" );
		setReturnType( "int" );
		setReturns( "the value 0 if this Byte is equal to the argument Byte; a value less than 0 if this Byte is numerically less than the argument Byte; and a value greater than 0 if this Byte is numerically greater than the argument Byte (signed comparison)." );
	}
}

class byteValueOf extends byteMethod {
	byteValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Byte instance representing the specified byte value. If a new Byte instance is not required, this method should generally be used in preference to the constructor Byte(byte), as this method is likely to yield significantly better space and time performance by caching frequently requested values." );
		addParam( "byte b" );
		setReturnType( "static Byte" );
		setReturns( "a Byte instance representing b." );
	}
}

class byteValueOf2 extends byteMethod {
	byteValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns a Byte object holding the value extracted from the specified String when parsed with the radix given by the second argument. The first argument is interpreted as representing a signed byte in the radix specified by the second argument, exactly as if the argument were given to the parseByte(java.lang.String, int) method. The result is a Byte object that represents the byte value specified by the string.");
		addParam( "String s");
		setReturnType( "static Byte" );
		setReturns( "a Byte object holding the value represented by the string argument." );
	}
}

class byteValueOf3 extends byteMethod {
	byteValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns a Byte object holding the value extracted from the specified String when parsed with the radix given by the second argument. The first argument is interpreted as representing a signed byte in the radix specified by the second argument, exactly as if the argument were given to the parseByte(java.lang.String, int) method. The result is a Byte object that represents the byte value specified by the string." );
		addParam( "String s");
		addParam( "int radix" );
		setReturnType( "static Byte" );
		setReturns( "a Byte object holding the value represented by the string argument in the specified radix." );
	}
}

class byteParseByte extends byteMethod {
	byteParseByte() {
		setName( "parseByte" );
		setDesc( "Parses the string argument as a signed decimal byte. The characters in the string must all be decimal digits, except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value. The resulting byte value is returned, exactly as if the argument and the radix 10 were given as arguments to the parseByte(java.lang.String, int) method." );
		addParam( "String s" );
		setReturnType( "static byte" );
		setReturns( "the byte value represented by the argument in decimal.");
	}
}

class byteParseByte2 extends byteMethod {
	byteParseByte2() {
		setName( "parseByte" );
		setDesc( "Parses the string argument as a signed byte in the radix specified by the second argument. The characters in the string must all be digits, of the specified radix (as determined by whether Character.digit(char, int) returns a nonnegative value) except that the first character may be an ASCII minus sign '-' ('\u002D') to indicate a negative value. The resulting byte value is returned.");
		addParam( "String s" );
		addParam( "int radix" );
		setReturnType( "static byte" );
		setReturns( "the byte value represented by the string argument in the specified radix.");
	}
}

class byteDecode extends byteMethod {
	byteDecode() {
		setName( "decode" );
		setDesc( "Decodes a String into a Byte. Accepts decimal, hexadecimal, and octal numbers." );
		setReturnType( "static Byte" );
		setReturns( "a Byte object holding the byte value represented by 'nm'" );
	}
}

/*************************************************************
**********************DOUBLE METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class DoubleConstructor extends Constructor {
	DoubleConstructor() { 
		setName( "Double" );
		setEnclosingClass( "Double" );
	}
}

class Double1 extends DoubleConstructor {
	Double1() {
		setDesc( "Constructs a newly allocated Double object that represents the primitive double argument." );
		addParam( "double value" );
	}
}

class Double2 extends DoubleConstructor {
	Double2() {
		setDesc( "Constructs a newly allocated Double object that represents the floating-point value of type double represented by the string." );
		addParam( "String s" );
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
		setReturnType( "byte" );
		setReturns( "the double value represented by this object converted to type byte." );
	}
}

class doubleCompare extends doubleMethod {
	doubleCompare() {
		setName( "compare" );
		setDesc( "Compares the two specified double values. The sign of the integer value returned is the same as that of the integer that would be returned by the call." );
		addParam( "double d1" );
		addParam( "double d2" );
		setReturnType( "static int" );
		setReturns( "the value 0 if d1 is numerically equal to d2; a value less than 0 if d1 is numerically less than d2; and a value greater than 0 if d1 is numerically greater than d2." );
	}
}

class doubleCompareTo extends doubleMethod {
	doubleCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two Double objects numerically. There are two ways in which comparisons performed by this method differ from those performed by the Java language numerical comparison operators (<, <=, ==, >= >) when applied to primitive double values." );
		addParam( "Double anotherDouble" );
		setReturnType( "int" );
		setReturns( "the value 0 if anotherDouble is numerically equal to this Double; a value less than 0 if this Double is numerically less than anotherDouble; and a value greater than 0 if this Double is numerically greater than anotherDouble." );
	}
}

class doubleDoubleToLongBits extends doubleMethod {
	doubleDoubleToLongBits() {
		setName( "doubleToLongBits" );
		setDesc( "Returns a representation of the specified floating-point value according to the IEEE 754 floating-point 'double format' bit layout." );
		addParam( "double value" );
		setReturnType( "static long" );
		setReturns( "the bits that represent the floating-point number." );
	}
}

class doubleDoubleToRawLongBits extends doubleMethod {
	doubleDoubleToRawLongBits() {
		setName( "doubleToRawLongBits" );
		setDesc( "Returns a representation of the specified floating-point value according to the IEEE 754 floating-point 'double format' bit layout, preserving Not-a-Number (NaN) values." );
		addParam( "double value" );
		setReturnType( "static long" );
		setReturns( "the bits that represent the floating-point number." );
	}
}

class doubleDoubleValue extends doubleMethod {
	doubleDoubleValue() {
		setName( "doubleValue" );
		setDesc( "Returns the double value of this Double object." );
		setReturnType( "double" );
		setReturns( "the double value represented by this object." );
	}
}

class doubleEquals extends doubleMethod {
	doubleEquals() {
		setName( "equals" );
		setDesc( "Compares this object against the specified object. The result is true if and only if the argument is not null and is a Double object that represents a double that has the same value as the double represented by this object. For this purpose, two double values are considered to be the same if and only if the method doubleToLongBits(double) returns the identical long value when applied to each." );
		addParam( "Object obj" );
		setReturnType( "boolean" );
		setReturns( "true if the objects are the same; false otherwise." );
	}
}

class doubleFloatValue extends doubleMethod {
	doubleFloatValue() {
		setName( "floatValue" );
		setDesc( "Returns the float value of this Double object." );
		setReturnType( "float" );
		setReturns( "the double value represented by this object converted to type float." );
	}
}

class doubleHashCode extends doubleMethod {
	doubleHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this Double object. The result is the exclusive OR of the two halves of the long integer bit representation, exactly as produced by the method doubleToLongBits(double), of the primitive double value represented by this Double object." );
		setReturnType( "int" );
		setReturns( "a hash code value for this object." );
	}
}

class doubleIntValue extends doubleMethod {
	doubleIntValue() {
		setName( "intValue" );
		setDesc( "Returns the value of this Double as an int (by casting to type int)." );
		setReturnType( "int" );
		setReturns( "the double value represented by this object converted to type int." );
	}
}

class doubleIsInfinite extends doubleMethod {
	doubleIsInfinite() {
		setName( "isInfinite" );
		setDesc( "Returns true if this Double value is infinitely large in magnitude, false otherwise." );
		setReturnType( "boolean" );
		setReturns( "true if the value represented by this object is positive infinity or negative infinity; false otherwise." );
	}
}

class doubleIsInfinite2 extends doubleMethod {
	doubleIsInfinite2() {
		setName( "isInfinite" );
		setDesc( "Returns true if the specified number is infinitely large in magnitude, false otherwise." );
		addParam( "double v" );
		setReturnType( "static boolean" );
		setReturns( "true if the value of the argument is positive infinity or negative infinity; false otherwise." );
	}
}

class doubleIsNaN extends doubleMethod {
	doubleIsNaN() {
		setName( "isNaN" );
		setDesc( "Returns true if this Double value is a Not-a-Number (NaN), false otherwise." );
		setReturnType( "boolean" );
		setReturns( "true if the value represented by this object is NaN; false otherwise." );
	}
}

class doubleIsNaN2 extends doubleMethod {
	doubleIsNaN2() {
		setName( "isNaN" );
		setDesc( "Returns true if the specified number is a Not-a-Number (NaN) value, false otherwise." );
		addParam( "double v" );
		setReturnType( "static boolean" );
		setReturns( "true if the value of the argument is NaN; false otherwise." );
	}
}

class doubleLongBitsToDouble extends doubleMethod {
	doubleLongBitsToDouble() {
		setName( "longBitsToDouble" );
		setDesc( "Returns the double value corresponding to a given bit representation. The argument is considered to be a representation of a floating-point value according to the IEEE 754 floating-point 'double format' bit layout." );
		addParam( "long bits" );
		setReturnType( "static double" );
		setReturns( "the double floating-point value with the same bit pattern." );
	}
}

class doubleLongValue extends doubleMethod {
	doubleLongValue() {
		setName( "longValue" );
		setDesc( "Returns the value of this Double as a long (by casting to type long)." );
		setReturnType( "long" );
		setReturns( "the double value represented by this object converted to type long." );
	}
}

class doubleParseDouble extends doubleMethod {
	doubleParseDouble() {
		setName( "parseDouble" );
		setDesc( "Returns a new double initialized to the value represented by the specified String, as performed by the valueOf method of class Double." );
		addParam( "String s" );
		setReturnType( "static double" );
		setReturns( "the double value represented by the string argument." );
	}
}

class doubleShortValue extends doubleMethod {
	doubleShortValue() {
		setName( "shortValue" );
		setDesc( "Returns the value of this Double as a short (by casting to a short)." );
		setReturnType( "short" );
		setReturns( "the double value represented by this object converted to type short." );
	}
}

class doubleToHexString extends doubleMethod {
	doubleToHexString() {
		setName( "toHexString" );
		setDesc( "Returns a hexadecimal string representation of the double argument. All characters mentioned below are ASCII characters." );
		addParam( "double d" );
		setReturnType( "static String" );
		setReturns( "a hex string representation of the argument." );
	}
}

class doubleToString extends doubleMethod {
	doubleToString() {
		setName( "toString" );
		setDesc( "Returns a string representation of this Double object. The primitive double value represented by this object is converted to a string exactly as if by the method toString of one argument." );
		setReturnType( "String" );
		setReturns( "a String representation of this object." );
	}
}

class doubleToString2 extends doubleMethod {
	doubleToString2() {
		setName( "toString" );
		setDesc( "Returns a string representation of the Double object." );
		addParam( "double d" );
		setReturnType( "String" );
		setReturns( "a String representation of the argument." );
	}
}

class doubleValueOf extends doubleMethod {
	doubleValueOf() {
		setName( "valueOf" );
		setDesc( "Returns a Double instance representing the specified double value. If a new Double instance is not required, this method should generally be used in preference to the constructor Double(double), as this method is likely to yield significantly better space and time performance by caching frequently requested values." );
		addParam( "double d" );
		setReturnType( "static Double" );
		setReturns( "a Double instance representing 'd'." );
	}
}

class doubleValueOf2 extends doubleMethod {
	doubleValueOf2() {
		setName( "valueOf" );
		setDesc( "Leading and trailing whitespace characters in s are ignored. Whitespace is removed as if by the String.trim() method; that is, both ASCII space and control characters are removed." );
		addParam( "String s" );
		setReturnType( "String s" );
		setReturns( "a Double object holding the value represented by the String argument." );
	}
}

/*************************************************************
**********************MATH METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class MathConstructor extends Constructor {
	MathConstructor() { 
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
		setReturnType( "static double" );
		addParam("double a");
		setReturns( "the absolute value of the argument." );
	}
}

class mathAbs2 extends mathMethod {
	mathAbs2() {
		setName( "abs" );
		setDesc( "Returns the absolute value of a float value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "static float" );
		addParam( "float a" );
		setReturns( "the absolute value of the argument." );
	}
}

class mathAbs3 extends mathMethod {
	mathAbs3() {
		setName( "abs" );
		setDesc( "Returns the absolute value of an int value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "static int" );
		addParam( "int a" );
		setReturns( "the absolute value of the argument." );
	}
}

class mathAbs4 extends mathMethod {
	mathAbs4() {
		setName( "abs" );
		setDesc( "Returns the absolute value of a long value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned." );
		setReturnType( "static long" );
		addParam( "long a" );
		setReturns( "the absolute vaue of the argument." );
	}
}

class mathAcos extends mathMethod {
	mathAcos() {
		setName( "acos" );
		setDesc( "Returns the arc cosine of a value; the returned angle is in the range 0.0 through pi." );
		setReturnType( "static double" );
		addParam( "long a" );
		setReturns( "the arc cosine of the argument." );
	}
}

class mathAsin extends mathMethod {
	mathAsin() {
		setName( "asin" );
		setDesc( "Returns the arc sine of a value; the returned angle is in the range -pi/2 through pi/2." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the arc sine of the argument." );
	}
}

class mathAtan extends mathMethod {
	mathAtan() {
		setName( "atan" );
		setDesc( "Returns the arc tangent of a value; the returned angle is in the range -pi/2 through pi/2." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the arc tangent of the argument." );
	}
}

class mathAtan2 extends mathMethod {
	mathAtan2() {
		setName( "atan2" );
		setDesc( "Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta). This method computes the phase theta by computing an arc tangent of y/x in the range of -pi to pi." );
		setReturnType( "static double" );
		addParam( "double y" );
		addParam( "double x" );
		setReturns( "the theta component of the point (r, theta) in polar coordinates that corresponds to the point (x, y) in Cartesian coordinates." );
	}
}

class mathCbrt extends mathMethod {
	mathCbrt() {
		setName( "cbrt" );
		setDesc( "Returns the cube root of a double value. For positive finite x, cbrt(-x) == -cbrt(x); that is, the cube root of a negative value is the negative of the cube root of that value's magnitude." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the cube root of 'a'" );
	}
}

class mathCeil extends mathMethod {
	mathCeil() {
		setName( "ceil" );
		setDesc( "Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the smallest (closest to negative infinity) floating-point value that is greater than or equal to the argument and is equal to a mathematical integer." );
	}
}

class mathCopySign extends mathMethod {
	mathCopySign() {
		setName( "copySign" );
		setDesc( "Returns the first floating-point argument with the sign of the second floating-point argument. Note that unlike the StrictMath.copySign method, this method does not require NaN sign arguments to be treated as positive values; implementations are permitted to treat some NaN arguments as positive and other NaN arguments as negative to allow greater performance." );
		setReturnType( "static double" );
		addParam( "double magnitude" );
		addParam( "double sign" );
		setReturns( "a value with the magnitude of magnitude and the sign of sign." );
	}
}

class mathCopySign2 extends mathMethod {
	mathCopySign2() {
		setName( "copySign2" );
		setDesc( "Returns the first floating-point argument with the sign of the second floating-point argument. Note that unlike the StrictMath.copySign method, this method does not require NaN sign arguments to be treated as positive values; implementations are permitted to treat some NaN arguments as positive and other NaN arguments as negative to allow greater performance." );
		setReturnType( "static float" );
		addParam( "float magnitude" );
		addParam( "float sign" );
		setReturns( "a value with the magnitude of magnitude and the sign of sign." );
	}
}

class mathCos extends mathMethod {
	mathCos() {
		setName( "cos" );
		setDesc( "Returns the trigonometric cosine of an angle." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the cosine of the argument." );
	}
}

class mathCosh extends mathMethod {
	mathCosh() {
		setName( "cosh" );
		setDesc( "Returns the hyperbolic cosine of a double value. The hyperbolic cosine of x is defined to be (ex + e-x)/2 where e is Euler's number." );
		setReturnType( "static double" );
		addParam( "double x" );
		setReturns( "The hyperbolic cosine of x." );
	}
}

class mathExp extends mathMethod {
	mathExp() {
		setName( "exp" );
		setDesc( "Returns Euler's number e raised to the power of a double value." );
		setReturnType( "static double" );
		addParam( "double a");
		setReturns( "the value e^a, where e is the base of the natural logarithms." );
	}
}

class mathExpm1 extends mathMethod {
	mathExpm1() {
		setName( "expm1" );
		setDesc( "Returns e^x -1. Note that for values of x near 0, the exact sum of expm1(x) + 1 is much closer to the true result of e^x than exp(x)." );
		setReturnType( "static double" );
		addParam( "double x" );
		setReturns( "the value e^x-1." );
	}
}

class mathFloor extends mathMethod {
	mathFloor() {
		setName( "floor" );
		setDesc( "Returns the largest (closest to positive infinity) double value that is less than or equal to the argument and is equal to a mathematical integer." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the largest (closest to positive infinity) floating-point value that less than or equal to the argument and is equal to a mathematical integer." );
	}
}

class mathGetExponent extends mathMethod {
	mathGetExponent() {
		setName( "getExponent" );
		setDesc( "Returns the unbiased exponent used in the representation of a double." );
		setReturnType( "static int" );
		addParam( "double d" );
		setReturns( "the unbiased exponent of the argument." );
	}
}

class mathGetExponent2 extends mathMethod {
	mathGetExponent2() {
		setName( "getExponent" );
		setDesc( "Returns the unbiased exponent used in the representation of a float." );
		setReturnType( "static int" );
		addParam( "float f" );
		setReturns( "the unbiased exponent of the argument" );
	}
}

class mathHypot extends mathMethod {
	mathHypot() {
		setName( "hypot" );
		setDesc( "Returns sqrt(x^2 +y^2) without intermediate overflow or underflow." );
		setReturnType( "static double" );
		addParam( "double x" );
		addParam( "double y" );
		setReturns( "sqrt(x^2 + y^2) without intermediate overflow or underflow." );
	}
}

class mathIEEEremainder extends mathMethod {
	mathIEEEremainder() {
		setName( "IEEEremainder" );
		setDesc( "Computes the remainder operation on two arguments as prescribed by the IEEE 754 standard." );
		setReturnType( "static double" );
		addParam( "double f1" );
		addParam( "double f2" );
		setReturns( "the remainder when f1 is divided by f2." );
	}
}

class mathLog extends mathMethod {
	mathLog() {
		setName( "log" );
		setDesc( "Returns the natural logarithm (base e) of a double value." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the value ln 'a', the natural logarithm of 'a'." );
	}
}

class mathLog10 extends mathMethod {
	mathLog10() {
		setName( "log10" );
		setDesc( "Returns the base 10 logarithm of a double value." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the base 10 logarithm of 'a'" );
	}
}

class mathLog1p extends mathMethod {
	mathLog1p() {
		setName( "log1p" );
		setDesc( "Returns the natural logarithm of the sum of the argument and 1." );
		setReturnType( "static double" );
		addParam( "double x" );
		setReturns( "the value ln(x + 1), the natural log of x + 1" );
	}
}

class mathMax extends mathMethod {
	mathMax() {
		setName( "max" );
		setDesc( "Returns the greater of two double values." );
		setReturnType( "static double" );
		addParam( "double a" );
		addParam( "double b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMax2 extends mathMethod {
	mathMax2() {
		setName( "max" );
		setDesc( "Returns the greater of two float values." );
		setReturnType( "static float" );
		addParam( "float a" );
		addParam( "float b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMax3 extends mathMethod {
	mathMax3() {
		setName( "max" );
		setDesc( "Returns the greater of two int values." );
		setReturnType( "static int" );
		addParam( "int a" );
		addParam( "int b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMax4 extends mathMethod {
	mathMax4() {
		setName( "max" );
		setDesc( "Returns the greater of two long values." );
		setReturnType( "static long" );
		addParam( "long a" );
		addParam( "long b" );
		setReturns( "the larger of 'a' and 'b'." );
	}
}

class mathMin extends mathMethod {
	mathMin() {
		setName( "min" );
		setDesc( "Returns the smaller of two double values." );
		setReturnType( "static double" );
		addParam( "double a" );
		addParam( "double b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathMin2 extends mathMethod {
	mathMin2() {
		setName( "min" );
		setDesc( "Returns the smaller of two float values." );
		setReturnType( "static float" );
		addParam( "float a" );
		addParam( "float b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathMin3 extends mathMethod {
	mathMin3() {
		setName( "min" );
		setDesc( "Returns the smaller of two int values." );
		setReturnType( "static int" );
		addParam( "int a" );
		addParam( "int b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathMin4 extends mathMethod {
	mathMin4() {
		setName( "min" );
		setDesc( "Returns the smaller of two long values." );
		setReturnType( "static long" );
		addParam( "long a" );
		addParam( "long b" );
		setReturns( "the smaller of 'a' and 'b'." );
	}
}

class mathNextAfter extends mathMethod {
	mathNextAfter() {
		setName( "nextAfter" );
		setDesc( "Returns the floating-point number adjacent to the first argument in the direction of the second argument." );
		setReturnType( "static double" );
		addParam( "double start" );
		addParam( "double direction" );
		setReturns( "The floating-point number adjacent to start in the direction of direction." );
	}
}

class mathNextAfter2 extends mathMethod {
	mathNextAfter2() {
		setName( "nextAfter" );
		setDesc( "Returns the floating-point number adjacent to the first argument in the direction of the second argument." );
		setReturnType( "static float" );
		addParam( "float start" );
		addParam( "double direction" );
		setReturns( "The floating-point number adjacent to start in the direction of direction." );
	}
}

class mathNextUp extends mathMethod {
	mathNextUp() {
		setName( "nextUp" );
		setDesc( "Returns the floating-point value adjacent to d in the direction of positive infinity." );
		setReturnType( "static double" );
		addParam( "double d" );
		setReturns( "The adjacent floating-point value closer to positive infinity." );
	}
}

class mathNextUp2 extends mathMethod {
	mathNextUp2() {
		setName( "nextUp" );
		setDesc( "Returns the floating-point value adjacent to f in the direction of positive infinity." );
		setReturnType( "static float" );
		addParam( "float f" );
		setReturns( "The adjacent floating-point value closer to positive infinity." );
	}
}

class mathPow extends mathMethod {
	mathPow() {
		setName( "pow" );
		setDesc( "Returns the value of the first argument raised to the power of the second argument." );
		setReturnType( "static double" );
		addParam( "double a" );
		addParam( "double b" );
		setReturns( "the value a^b." );
	}
}

class mathRandom extends mathMethod {
	mathRandom() {
		setName( "random" );
		setDesc( "Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0." );
		setReturnType( "static double" );
		setReturns( "a pseudorandom double greater than or equal to 0.0 and less than 1.0." );
	}
}

class mathRint extends mathMethod {
	mathRint() {
		setName( "rint" );
		setDesc( "Returns the double value that is closest in value to the argument and is equal to a mathematical integer." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the closest floating-point value to a that is equal to a mathematical integer." );
	}
}

class mathRound extends mathMethod {
	mathRound() {
		setName( "round" );
		setDesc( "Returns the closest long to the argument." );
		setReturnType( "static long" );
		addParam( "double a" );
		setReturns( "the value of the argument rounded to the nearest long value." );
	}
}

class mathRound2 extends mathMethod {
	mathRound2() {
		setName( "round" );
		setDesc( "Returns the closest int to the argument." );
		setReturnType( "static float" );
		addParam( "float a" );
		setReturns( "the value of the argument rounded to the nearest int value." );
	}
}

class mathscalb extends mathMethod {
	mathscalb() {
		setName( "scalb" );
		setDesc( "Return f × 2^scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the double value set." );
		setReturnType( "static double" );
		addParam( "double d" );
		addParam( "int scaleFactor" );
		setReturns( "d x 2^scaleFactor." );
	}
}

class mathScalb2 extends mathMethod {
	mathScalb2() {
		setName( "scalb" );
		setDesc( "Return f × 2^scaleFactor rounded as if performed by a single correctly rounded floating-point multiply to a member of the float value set." );
		setReturnType( "static float" );
		addParam( "float f" );
		addParam( "int scaleFactor" );
		setReturns( "f x 2^scaleFactor." );
	}
}

class mathSignum extends mathMethod {
	mathSignum() {
		setName( "signum" );
		setDesc( "Returns the signum function of the argument; zero if the argument is zero, 1.0 if the argument is greater than zero, -1.0 if the argument is less than zero." );
		setReturnType( "static double" );
		addParam( "double d" );
		setReturns( "the signum function of the argument." );
	}
}

class mathSignum2 extends mathMethod {
	mathSignum2() {
		setName( "signum" );
		setDesc( "Returns the signum function of the argument; zero if the argument is zero, 1.0 if the argument is greater than zero, -1.0 if the argument is less than zero." );
		setReturnType( "static float" );
		addParam( "float f" );
		setReturns( "the signum function of the argument." );
	}
}

class mathSin extends mathMethod {
	mathSin() {
		setName( "sin" );
		setDesc( "Returns the trigonometric sine of an angle." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the sine of the argument." );
	}
}

class mathSinh extends mathMethod {
	mathSinh() {
		setName( "sinh" );
		setDesc( "Returns the hyperbolic sine of a double value." );
		setReturnType( "static double" );
		addParam( "double x" );
		setReturns( "The hyperbolic sine of x." );
	}
}

class mathSqrt extends mathMethod {
	mathSqrt() {
		setName( "sqrt" );
		setDesc( "Returns the correctly rounded positive square root of a double value." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the positive square root of a. If the argument is NaN or less than zero, the result is NaN." );
	}
}

class mathTan extends mathMethod {
	mathTan() {
		setName( "tan" );
		setDesc( "Returns the trigonometric tangent of an angle." );
		setReturnType( "static double" );
		addParam( "double a" );
		setReturns( "the tangent of the argument." );
	}
}

class mathTanh extends mathMethod {
	mathTanh() {
		setName( "tanh" );
		setDesc( "Returns the hyperbolic tangent of a double value." );
		setReturnType( "static double" );
		addParam( "double x" );
		setReturns( "The hyperbolic tangent of x." );
	}
}

class mathToDegrees extends mathMethod {
	mathToDegrees() {
		setName( "toDegrees" );
		setDesc( "Converts an angle measured in radians to an approximately equivalent angle measured in degrees." );
		setReturnType( "static double" );
		addParam( "double angrad" );
		setReturns( "the measurement of the angle angrad in degrees." );
	}
}

class mathToRadians extends mathMethod {
	mathToRadians() {
		setName( "toRadians" );
		setDesc( "Converts an angle measured in degrees to an approximately equivalent angle measured in radians." );
		setReturnType( "static double" );
		addParam( "double andeg" );
		setReturns( "the measurement of the angle angdeg in radians." );
	}
}

class mathUlp extends mathMethod {
	mathUlp() {
		setName( "ulp" );
		setDesc( "Returns the size of an ulp of the argument. An ulp of a double value is the positive distance between this floating-point value and the double value next larger in magnitude." );
		setReturnType( "static float" );
		addParam( "double d" );
		setReturns( "the size of an ulp of the argument" );
	}
}

class mathUlp2 extends mathMethod {
	mathUlp2() {
		setName( "ulp" );
		setDesc( "Returns the size of an ulp of the argument. An ulp of a float value is the positive distance between this floating-point value and the float value next larger in magnitude." );
		setReturnType( "static float" );
		addParam( "float f" );
		setReturns( "the size of an ulp of the argument" );
	}
}

/*************************************************************
**********************STRING METHODS*************************
**************************************************************/

/**********************CONSTRUCTORS*************************/

abstract class StringConstructor extends Constructor {
	StringConstructor() { 
		setName( "String" );
		setEnclosingClass( "String" );
	}
}

class String1 extends StringConstructor {
	String1() {	
		setDesc("Initializes a newly created String object so that it represents an empty character sequence. Note that use of this constructor is unnecessary since Strings are immutable." );
	}
}

class String2 extends StringConstructor {
	String2(){
		setDesc( "Initializes a newly created String object so that it represents the same sequence of characters as the argument; in other words, the newly created string is a copy of the argument string." );
		addParam( "String original" );
	}
}

class String3 extends StringConstructor {
	String3(){
		setDesc( "Allocates a new String so that it represents the sequence of characters currently contained in the character array argument." );
		addParam( "char[] value" );
	}
}

class String4 extends StringConstructor {
	String4(){
		setDesc( "Allocates a new String that contains characters from a subarray of the character array argument. The offset argument is the index of the first character of the subarray and the count argument specifies the length of the subarray." );
		addParam( "char[] value" );
		addParam( "int offset" );
		addParam( "int count" );
	}
}

class String5 extends StringConstructor {
	String5(){
		setDesc( "Allocates a new String that contains characters from a subarray of the Unicode code point array argument. The offset argument is the index of the first code point of the subarray and the count argument specifies the length of the subarray." );
		addParam( "int[] codePoints" );
		addParam( "int offset" );
		addParam( "int count" );
	}
}

class String6 extends StringConstructor {
	String6(){
		setDesc( "Allocates a new String constructed from a subarray of an array of 8-bit integer values. The offset argument is the index of the first byte of the subarray, and the count argument specifies the length of the subarray." );
		addParam( "byte[] ascii" );
		addParam( "int hibyte" );
		addParam( "int offset" );
		addParam( "int count" );
	}
}

class String7 extends StringConstructor {
	String7(){
		setDesc( "Allocates a new String containing characters constructed from an array of 8-bit integer values. Each character in the resulting string is constructed from the corresponding component b in the byte array." );
		addParam( "byte[] ascii" );
		addParam( "int hibyte" );
	}
}

class String8 extends StringConstructor {
	String8(){
		setDesc( "Constructs a new String by decoding the specified subarray of bytes using the specified charset." );
		addParam( "byte[] bytes" );
		addParam( "int offset" );
		addParam( "int length" );
		addParam( "String charsetName" );
	}
}

class String9 extends StringConstructor {
	String9(){
		setDesc( "Constructs a new String by decoding the specified subarray of bytes using the specified charset." );
		addParam( "byte[] bytes" );
		addParam( "int offset" );
		addParam( "int length" );
		addParam( "Charset charsetName" );		
	}
}

class String10 extends StringConstructor {
	String10(){
		setDesc( "Constructs a new String by decoding the specified array of bytes using the specified charset." );
		addParam( "byte[] bytes" );
		addParam( "String charsetName" );
	}
}

class String11 extends StringConstructor {
	String11(){
		setDesc( "Constructs a new String by decoding the specified array of bytes using the specified charset." );
		addParam( "byte[] bytes" );
		addParam( "Charset charsetName" );
	}
}

class String12 extends StringConstructor {
	String12(){
		setDesc( "Constructs a new String by decoding the specified subarray of bytes using the platform's default charset." );
		addParam( "byte[] bytes" );
		addParam( "int offset" );
		addParam( "int length" );
	}
}

class String13 extends StringConstructor {
	String13(){
		setDesc( "Constructs a new String by decoding the specified array of bytes using the platform's default charset." );
		addParam( "byte[] bytes" );
	}
}

class String14 extends StringConstructor {
	String14(){
		setDesc( "Allocates a new string that contains the sequence of characters currently contained in the string buffer argument." );
		addParam( "StringBuffer buffer" );
	}
}

class String15 extends StringConstructor {
	String15(){
		setDesc( "Allocates a new string that contains the sequence of characters currently contained in the string builder argument." );
		addParam( "StringBuilder builder" );
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
		setReturnType( "char" );
		addParam( "int index" );
		setReturns( "the char value at the specified index of this string. The first char value is at index 0." );
	}
}

class strIsEmpty extends stringMethod {
	strIsEmpty() {
		setName( "isEmpty" );
		setDesc( "Returns true if, and only if, length() is 0." );
		setReturnType( "boolean" );
		setReturns( "true if length() is 0, otherwise false." );
	}
}

class strCodePointAt extends stringMethod {
	strCodePointAt() {
		setName( "codePointAt" );
		setDesc( "Returns the character (Unicode code point) at the specified index. The index refers to char values (Unicode code units) and ranges from 0 to length() - 1." );
		setReturnType( "int" );
		addParam( "int index" );
		setReturns( "the code point value of the character at the index." );
	}
}
class strCodePointBefore extends stringMethod {
	strCodePointBefore() {
		setName( "codePointBefore" );
		setDesc( "Returns the character (Unicode code point) before the specified index. The index refers to char values (Unicode code units) and ranges from 1 to length." );
		setReturnType( "int" );
		addParam( "int index" );
		setReturns( "the Unicode code point value before the given index." );
	}
}

class strCodePointCount extends stringMethod {
	strCodePointCount() {
		setName( "codePointCount" );
		setDesc( "Returns the number of Unicode code points in the specified text range of this String. The text range begins at the specified beginIndex and extends to the char at index endIndex - 1. Thus the length (in chars) of the text range is endIndex-beginIndex. Unpaired surrogates within the text range count as one code point each." );
		setReturnType( "int" );
		addParam( "int beginIndex" );
		addParam( "int endIndex" );
		setReturns( "the number of Unicode code points in the specified text range." );
	}
}

class strOffsetByCodePoints extends stringMethod {
	strOffsetByCodePoints() {
		setName( "offsetByCodePoints" );
		setDesc( "Returns the index within this String that is offset from the given index by codePointOffset code points. Unpaired surrogates within the text range given by index and codePointOffset count as one code point each." );
		setReturnType( "int" );
		addParam( "int index" );
		addParam( "int codePointOffset" );
		setReturns( "the index within this String." );
	}
}

class strGetChars extends stringMethod {
	strGetChars() {
		setName( "getChars" );
		setDesc( "Copies characters from this string into the destination character array." );
		setReturnType( "void" );
		addParam( "int srcBegin" );
		addParam( "int srcEnd" );
		addParam( "char[] dst" );
		addParam( "int dstBegin" );
	}
}

class strGetBytes extends stringMethod {
	strGetBytes() {
		setName( "getBytes" );
		setDesc( "Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array." );
		setReturnType( "byte[]" );
		addParam( "String charsetName" );
		setReturns( "The resultant byte array." );
	}
}

class strGetBytes2 extends stringMethod {
	strGetBytes2() {
		setName( "getBytes" );
		setDesc( "Encodes this String into a sequence of bytes using the given charset, storing the result into a new byte array." );
		setReturnType( "byte[]" );
		addParam( "Charset charset" );
		setReturns( "The resultant byte array." );
	}
}

class strGetBytes3 extends stringMethod {
	strGetBytes3() {
		setName( "getBytes" );
		setDesc( "Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array." );
		setReturnType( "byte[]" );
		setReturns( "The resultant byte array." );
	}
}

class strEquals extends stringMethod {
	strEquals() {
		setName( "equals" );
		setDesc( "Compares this string to the specified object. The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as this object." );
		setReturnType( "boolean" );
		addParam( "Object anObject" );
		setReturns( "true if the given object represents a String equivalent to this string, false otherwise." );
	}
}

class strContentEquals extends stringMethod {
	strContentEquals() {
		setName( "contentEquals" );
		setDesc( "Compares this string to the specified StringBuffer. The result is true if and only if this String represents the same sequence of characters as the specified StringBuffer." );
		setReturnType( "" );
		addParam( "StringBuffer sb" );
		setReturns( "true if this String represents the same sequence of characters as the specified StringBuffer, false otherwise." );
	}
}

class strContentEquals2 extends stringMethod {
	strContentEquals2() {
		setName( "contentEquals" );
		setDesc( "Compares this string to the specified CharSequence. The result is true if and only if this String represents the same sequence of char values as the specified sequence." );
		setReturnType( "boolean" );
		addParam( "CharSequence cs" );
		setReturns( "true if this String represents the same sequence of char values as the specified sequence, false otherwise." );
	}
}

class strEqualsIgnoreCase extends stringMethod {
	strEqualsIgnoreCase() {
		setName( "equalsIgnoreCase" );
		setDesc( "Compares this String to another String, ignoring case considerations. Two strings are considered equal ignoring case if they are of the same length and corresponding characters in the two strings are equal ignoring case." );
		setReturnType( "boolean" );
		addParam( "String anotherString" );
		setReturns( "true if the argument is not null and it represents an equivalent String ignoring case; false otherwise." );
	}
}

class strCompareTo extends stringMethod {
	strCompareTo() {
		setName( "compareTo" );
		setDesc( "Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. The character sequence represented by this String object is compared lexicographically to the character sequence represented by the argument string. The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true." );
		setReturnType( "int" );
		addParam( "String anotherString" );
		setReturns( "the value 0 if the argument string is equal to this string; a value less than 0 if this string is lexicographically less than the string argument; and a value greater than 0 if this string is lexicographically greater than the string argument." );
	}
}

class strCompareToIgnoreCase extends stringMethod {
	strCompareToIgnoreCase() {
		setName( "compareToIgnoreCase" );
		setDesc( "Compares two strings lexicographically, ignoring case differences. This method returns an integer whose sign is that of calling compareTo with normalized versions of the strings where case differences have been eliminated by calling Character.toLowerCase(Character.toUpperCase(character)) on each character." );
		setReturnType( "int" );
		addParam( "String str" );
		setReturns( "a negative integer, zero, or a positive integer as the specified String is greater than, equal to, or less than this String, ignoring case considerations." );
	}
}

class strRegionMatches extends stringMethod {
	strRegionMatches() {
		setName( "regionMatches" );
		setDesc( "A substring of this String object is compared to a substring of the argument other. The result is true if these substrings represent identical character sequences. The substring of this String object to be compared begins at index toffset and has length len. The substring of other to be compared begins at index ooffset and has length len." );
		setReturnType( "boolean" );
		addParam( "int toffset" );
		addParam( "String other" );
		addParam( "int ooffset" );
		addParam( "int len" );
		setReturns( "true if the specified subregion of this string exactly matches the specified subregion of the string argument; false otherwise." );
	}
}

class strRegionMatches2 extends stringMethod {
	strRegionMatches2() {
		setName( "regionMatches" );
		setDesc( "A substring of this String object is compared to a substring of the argument other. The result is true if these substrings represent character sequences that are the same, ignoring case if and only if ignoreCase is true. The substring of this String object to be compared begins at index toffset and has length len. The substring of other to be compared begins at index ooffset and has length len." );
		setReturnType( "boolean" );
		addParam( "boolean ignoreCase" );
		addParam( "int toffset" );
		addParam( "int ooffset" );
		addParam( "String other" );
		addParam( "int len" );
		setReturns( "true if the specified subregion of this string matches the specified subregion of the string argument; false otherwise. Whether the matching is exact or case insensitive depends on the ignoreCase argument." );
	}
}

class strStartsWith extends stringMethod {
	strStartsWith() {
		setName( "startsWith" );
		setDesc( "Tests if the substring of this string beginning at the specified index starts with the specified prefix." );
		setReturnType( "boolean" );
		addParam( "String prefix" );
		addParam( "int toffset" );
		setReturns( "true if the character sequence represented by the argument is a prefix of the substring of this object starting at index toffset; false otherwise. The result is false if toffset is negative or greater than the length of this String object." );
	}
}

class strStartsWith2 extends stringMethod {
	strStartsWith2() {
		setName( "startsWith" );
		setDesc( "Tests if this string starts with the specified prefix." );
		setReturnType( "boolean" );
		addParam( "String prefix" );
		setReturns( "true if the character sequence represented by the argument is a prefix of the character sequence represented by this string; false otherwise. Note also that true will be returned if the argument is an empty string or is equal to this String object as determined by the equals(Object) method." );
	}
}
class strEndsWith extends stringMethod {
	strEndsWith() {
		setName( "endsWith" );
		setDesc( "Tests if this string ends with the specified suffix." );
		setReturnType( "boolean" );
		addParam( "String suffix" );
		setReturns( "true if the character sequence represented by the argument is a suffix of the character sequence represented by this object; false otherwise. Note that the result will be true if the argument is the empty string or is equal to this String object as determined by the equals(Object) method." );
	}
}

class strHashCode extends stringMethod {
	strHashCode() {
		setName( "hashCode" );
		setDesc( "Returns a hash code for this string." );
		setReturnType( "int" );
		setReturns( "a hashCode in class Object." );
	}
}

class strIndexOf extends stringMethod {
	strIndexOf() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified character. If a character with value ch occurs in the character sequence represented by this String object, then the index (in Unicode code units) of the first such occurrence is returned." );
		setReturnType( "int" );
		addParam( "int ch" );
		setReturns( "the index of the first occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur." );
	}
}

class strIndexOf2 extends stringMethod {
	strIndexOf2() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index." );
		setReturnType( "int" );
		addParam( "int ch" );
		addParam( "int fromIndex" );
		setReturns( "the index of the first occurrence of the character in the character sequence represented by this object that is greater than or equal to fromIndex, or -1 if the character does not occur." );
	}
}

class strIndexOf3 extends stringMethod {
	strIndexOf3() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring." );
		setReturnType( "int" );
		addParam( "String str" );
		setReturns( "the index of the first occurrence of the specified substring, or -1 if there is no such occurrence." );
	}
}

class strIndexOf4 extends stringMethod {
	strIndexOf4() {
		setName( "indexOf" );
		setDesc( "Returns the index within this string of the first occurrence of the specified substring, starting at the specified index." );
		setReturnType( "int" );
		addParam( "String str" );
		addParam( "int fromIndex" );
		setReturns( "the index of the first occurrence of the specified substring, starting at the specified index, or -1 if there is no such occurrence." );
	}
}

class strLastIndexOf extends stringMethod {
	strLastIndexOf() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified character." );
		setReturnType( "int" );
		addParam( "int ch" );
		setReturns( "the index of the last occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur." );
	}
}

class strLastIndexOf2 extends stringMethod {
	strLastIndexOf2() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index." );
		setReturnType( "int" );
		addParam( "int ch" );
		addParam( "int fromIndex" );
		setReturns( "the index of the last occurrence of the character in the character sequence represented by this object that is less than or equal to fromIndex, or -1 if the character does not occur before that point." );
	}
}

class strLastIndexOf3 extends stringMethod {
	strLastIndexOf3() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified substring." );
		setReturnType( "int" );
		addParam( "String str" );
		setReturns( "the index of the last occurrence of the specified substring, or -1 if there is no such occurrence." );
	}
}

class strLastIndexOf4 extends stringMethod {
	strLastIndexOf4() {
		setName( "lastIndexOf" );
		setDesc( "Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index." );
		setReturnType( "int" );
		addParam( "String str" );
		addParam( "int fromIndex" );
		setReturns( "the index of the last occurrence of the specified substring, searching backward from the specified index, or -1 if there is no such occurrence." );
	}
}

class strLength extends stringMethod {
	strLength() {
		setName( "length" );
		setDesc( "Returns the length of this string.");
		setReturnType( "int" );
		setReturns( "the length of the sequence of characters represented by this object." );
	}
}

class strSubstring extends stringMethod {
	strSubstring() {
		setName( "substring" );
		setDesc( "Returns a new string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string." );
		setReturnType( "String" );
		addParam( "int beginIndex" );
		setReturns( "the specified substring." );
	}
}

class strSubstring2 extends stringMethod {
	strSubstring2() {
		setName( "substring" );
		setDesc( "Returns a new string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex." );
		setReturnType( "String" );
		addParam( "int beginIndex" );
		addParam( "int endIndex" );
		setReturns( "the specified substring." );
	}
}

class strSubSequence extends stringMethod {
	strSubSequence() {
		setName( "subSequence" );
		setDesc( "Returns a new character sequence that is a subsequence of this sequence." );
		setReturnType( "CharSequence" );
		addParam( "int beginIndex" );
		addParam( "int endIndex" );
		setReturns( "the specified subsequence." );
	}
}

class strConcat extends stringMethod {
	strConcat() {
		setName( "concat" );
		setDesc( "Concatenates the specified string to the end of this string." );
		setReturnType( "String" );
		addParam( "String str" );
		setReturns( "a string that represents the concatenation of this object's characters followed by the string argument's characters." );
	}
}

class strReplace extends stringMethod {
	strReplace() {
		setName( "replace" );
		setDesc( "Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar." );
		setReturnType( "String" );
		addParam( "char oldChar" );
		addParam( "char newChar" );
		setReturns( "a string derived from this string by replacing every occurrence of oldChar with newChar." );
	}
}

class strMatches extends stringMethod {
	strMatches() {
		setName( "matches" );
		setDesc( "Tells whether or not this string matches the given regular expression." );
		setReturnType( "boolean" );
		addParam( "String regex" );
		setReturns( "true if, and only if, this string matches the given regular expression." );
	}
}

class strContains extends stringMethod {
	strContains() {
		setName( "contains" );
		setDesc( "Returns true if and only if this string contains the specified sequence of char values." );
		setReturnType( "boolean" );
		addParam( "CharSequence s" );
		setReturns( "true if this string contains s, false otherwise." );
	}
}

class strReplaceFirst extends stringMethod {
	strReplaceFirst() {
		setName( "replaceFirst" );
		setDesc( "Replaces the first substring of this string that matches the given regular expression with the given replacement." );
		setReturnType( "String" );
		addParam( "String regex" );
		addParam( "String replacement" );
		setReturns( "the resulting String." );
	}
}

class strReplaceAll extends stringMethod {
	strReplaceAll() {
		setName( "replaceAll" );
		setDesc( "Replaces each substring of this string that matches the given regular expression with the given replacement." );
		setReturnType( "String." );
		addParam( "String regex" );
		addParam( "String replacement" );
		setReturns( "The resulting String." );
	}
}

class strReplace2 extends stringMethod {
	strReplace2() {
		setName( "replace" );
		setDesc( "Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence. The replacement proceeds from the beginning of the string to the end, for example, replacing 'aa' with 'b' in the string 'aaa' will result in 'ba' rather than 'ab'." );
		setReturnType( "String" );
		addParam( "CharSequence target" );
		addParam( "CharSequence replacement" );
		setReturns( "The resulting String." );
	}
}

class strSplit extends stringMethod {
	strSplit() {
		setName( "split" );
		setDesc( "Splits this string around matches of the given regular expression." );
		setReturnType( "String[]" );
		addParam( "String regex" );
		addParam( "int limit" );
		setReturns( "the array of strings computed by splitting this string around matches of the given regular expression." );
	}
}

class strSplit2 extends stringMethod {
	strSplit2() {
		setName( "split2" );
		setDesc( "Splits this string around matches of the given regular expression." );
		setReturnType( "String[]" );
		addParam( "String regex" );
		setReturns( "the array of strings computed by splitting this string around matches of the given regular expression." );
	}
}

class strToLowerCase extends stringMethod {
	strToLowerCase() {
		setName( "toLowerCase" );
		setDesc( "Converts all of the characters in this String to lower case using the rules of the given Locale. Case mapping is based on the Unicode Standard version specified by the Character class. Since case mappings are not always 1:1 char mappings, the resulting String may be a different length than the original String." );
		setReturnType( "String" );
		addParam( "Locale locale" );
		setReturns( "the String, converted to lowercase." );
	}
}

class strToLowerCase2 extends stringMethod {
	strToLowerCase2() {
		setName( "toLowerCase" );
		setDesc( "Converts all of the characters in this String to lower case using the rules of the default locale. This is equivalent to calling toLowerCase(Locale.getDefault())." );
		setReturnType( "String" );
		setReturns( "the String, converted to lowercase." );
	}
}

class strToUpperCase extends stringMethod {
	strToUpperCase() {
		setName( "toUpperCase" );
		setDesc( "Converts all of the characters in this String to upper case using the rules of the given Locale. Case mapping is based on the Unicode Standard version specified by the Character class. Since case mappings are not always 1:1 char mappings, the resulting String may be a different length than the original String." );
		setReturnType( "String" );
		addParam( "Locale locale" );
		setReturns( "the String, converted to lowercase." );
	}
}

class strToUpperCase2 extends stringMethod {
	strToUpperCase2() {
		setName( "toUpperCase" );
		setDesc( "Converts all of the characters in this String to upper case using the rules of the default locale. This method is equivalent to toUpperCase(Locale.getDefault())." );
		setReturnType( "String" );
		setReturns( "the String, converted to uppercase." );
	}
}

class strTrim extends stringMethod {
	strTrim() {
		setName( "trim" );
		setDesc( "Returns a copy of the string, with leading and trailing whitespace omitted." );
		setReturnType( "String" );
		setReturns( "A copy of this string with leading and trailing white space removed, or this string if it has no leading or trailing white space." );
	}
}

class strToString extends stringMethod {
	strToString() {
		setName( "toString" );
		setDesc( "This object (which is already a string!) is itself returned." );
		setReturnType( "String" );
		setReturns( "the string itself." );
	}
}

class strToCharArray extends stringMethod {
	strToCharArray() {
		setName( "toCharArray" );
		setDesc( "Converts this string to a new character array." );
		setReturnType( "char[]" );
		setReturns( "a newly allocated character array whose length is the length of this string and whose contents are initialized to contain the character sequence represented by this string." );
	}
}

class strFormat extends stringMethod {
	strFormat() {
		setName( "format" );
		setDesc( "Returns a formatted string using the specified format string and arguments." );
		setReturnType( "static String" );
		addParam( "String format" );
		addParam( "Object... args" );
		setReturns( "A formatted string" );
	}
}

class strFormat2 extends stringMethod {
	strFormat2() {
		setName( "format" );
		setDesc( "Returns a formatted string using the specified locale, format string, and arguments." );
		setReturnType( "static String" );
		addParam( "Locale 1" );
		addParam( "String format" );
		addParam( "Object... args" );
		setReturns( "A formatted string." );
	}
}

class strValueOf extends stringMethod {
	strValueOf() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the Object argument." );
		setReturnType( "static String" );
		addParam( "Object obj" );
		setReturns( "if the argument is null, then a string equal to 'null'; otherwise, the value of obj.toString() is returned." );
	}
}

class strValueOf2 extends stringMethod {
	strValueOf2() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the char array argument. The contents of the character array are copied; subsequent modification of the character array does not affect the newly created string." );
		setReturnType( "static String" );
		addParam( "char[] data" );
		setReturns( "a newly allocated string representing the same sequence of characters contained in the character array argument." );
	}
}

class strValueOf3 extends stringMethod {
	strValueOf3() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of a specific subarray of the char array argument." );
		setReturnType( "static String" );
		addParam( "char[] data" );
		addParam( "int offset" );
		addParam( "int count" );
		setReturns( "a string representing the sequence of characters contained in the subarray of the character array argument." );
	}
}

class strValueOf4 extends stringMethod {
	strValueOf4() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the boolean argument." );
		setReturnType( "static String" );
		addParam( "boolean b" );
		setReturns( "if the argument is true, a string equal to 'true' is returned; otherwise, a string equal to 'false' is returned." );
	}
}

class strValueOf5 extends stringMethod {
	strValueOf5() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the char argument. The contents of the character array are copied; subsequent modification of the character array does not affect the newly created string." );
		setReturnType( "static String" );
		addParam( "char c" );
		setReturns( "a string of length 1 containing as its single character the argument c." );
	}
}

class strValueOf6 extends stringMethod {
	strValueOf6() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of a specific subarray of the int argument." );
		setReturnType( "static String" );
		addParam( "int i" );
		setReturns( "a string representation of the int argument." );
	}
}

class strValueOf7 extends stringMethod {
	strValueOf7() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the long argument." );
		setReturnType( "static String" );
		addParam( "long l" );
		setReturns( "a string representation of the long argument." );
	}
}

class strValueOf8 extends stringMethod {
	strValueOf8() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of the float argument. The contents of the character array are copied; subsequent modification of the character array does not affect the newly created string." );
		setReturnType( "static String" );
		addParam( "float f" );
		setReturns( "a string representation of the float argument." );
	}
}

class strValueOf9 extends stringMethod {
	strValueOf9() {
		setName( "valueOf" );
		setDesc( "Returns the string representation of a specific subarray of the double argument." );
		setReturnType( "static String" );
		addParam( "double d" );
		setReturns( "a string representation of the double argument." );
	}
}

class strCopyValueOf extends stringMethod {
	strCopyValueOf() {
		setName( "copyValueOf" );
		setDesc( "Returns a String that represents the character sequence in the array specified." );
		setReturnType( "static String" );
		addParam( "char[] data" );
		addParam( "int offset" );
		addParam( "int count" );
		setReturns( "a String that contains the characters of the specified subarray of the character array." );
	}
}

class strCopyValueOf2 extends stringMethod {
	strCopyValueOf2() {
		setName( "copyValueOf" );
		setDesc( "Returns a String that represents the character sequence in the array specified." );
		setReturnType( "static String" );
		addParam( "char[] data" );
		setReturns( "a String that contains the characters of the character array." );
	}
}

class strIntern extends stringMethod {
	strIntern() {
		setName( "intern" );
		setDesc( "Returns a canonical representation for the string object." );
		setReturnType( "String" );
		setReturns( "a string that has the same contents as this string, but is guaranteed to be from a pool of unique strings." );
	}
}
