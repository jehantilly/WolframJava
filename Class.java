import java.util.ArrayList;


abstract class Class extends Searchable {
	private String parent = new String("Object");
	private ArrayList<Method> methods = new ArrayList<Method>();
	private ArrayList<Constructor> constructors = new ArrayList<Constructor>();
	private String[] similarClasses;
	
	void setParent( String p ) { parent = p; }
	void addConstruct( Constructor c ) { 
		try {
			if ( isMyConstructor( c ).equals( false ) ) {
				throw new NotMyConstructor( getName(), c.getName() );
			}
		} catch( NotMyConstructor N ) {
			System.out.println( N.getMess() );
		}
		constructors.add(c); 
	}
	void addMethod( Method m ) { 
		try {
			if ( isMyMethod( m ).equals( false ) ) {
				throw new NotMyMethod( getName(), m.getName() );
			}
		} catch( NotMyMethod N ) {
			System.out.println( N.getMess() );
		}
		methods.add(m); 
	}
	String getParent() { return parent; }
	ArrayList<Method> getMethods() { return methods; }
	ArrayList<Constructor> getConstructors() { return constructors; }
	public String toString() { return getName(); }
	public String getType() { return "Class"; }
	String[] getComparableNames() {
		String s1 = getName().toLowerCase();
		String s2 = "class " + getName().toLowerCase();
		String[] array = { s1, s2 };
		return array;
	}
	
	void setSimilarClasses( String[] classes ) {
		similarClasses = classes;
	}
	
	Boolean hasSimilarClasses() {
		return similarClasses != null;
	}
	
	String getSimilarClasses() {
		if (similarClasses == null ) {
			return "";
		}
		else {
			String s = "";
			for( int i = 0; i < similarClasses.length; ++i ) {
				s += similarClasses[i];
				if ( i < similarClasses.length - 1 ) {
					s += ", ";
				}
			}
			return s;
		}
	}
	
	class NotMyMethod extends Throwable{
		String className;
		String methodName;
		
		NotMyMethod( String cN, String mN ) {
			className = cN;
			methodName = mN;
		}
		String getMess() { return className + ": " + methodName + " is not my method."; }
	}
	
	class NotMyConstructor extends Throwable{
		String className;
		String methodName;
		
		NotMyConstructor( String cN, String mN ) {
			className = cN;
			methodName = mN;
		}
		String getMess() { return className + ": " + methodName + " is not my constructor."; }
	}
	
	
	abstract String myMethod();
	abstract String myConstructor();
	Boolean isMyMethod( Method m ) {
		String superClass = m.getClass().getSuperclass().getCanonicalName();
		
		return superClass.equals( myMethod() );
	}
	Boolean isMyConstructor( Constructor c ) {
		String superClass = c.getClass().getSuperclass().getCanonicalName();
		
		return superClass.equals( myConstructor() );
	}
}

class object extends Class {
	String myMethod() { return "objectMethod"; }
	String myConstructor() { return "ObjectConstructor"; }
	object() {
		setName("Object");
		setDesc("Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.");
		setParent( "None" );
		addConstruct( new Object1() );
		addMethod( new objectClone() );
		addMethod( new objectEquals() );
		addMethod( new objectFinalize() );
		addMethod( new objectGetClass() );
		addMethod( new objectHashCode() );
		addMethod( new objectNotify() );
		addMethod( new objectNotifyAll() );
		addMethod( new objectToString() );
		addMethod( new objectWait() );
		addMethod( new objectWait2() );
		addMethod( new objectWait3() );
	}
}


/*************************************************************
*******************COLLECTION CLASSES*************************
**************************************************************/


abstract class collectionClass extends Class {	// All classes that extend from AbstractCollection will inherit from this class
	collectionClass() {
		setParent( "AbstractCollection" );
	}
}

abstract class abstractListClass extends Class {	// All classes that extend from AbstractCollection will inherit from this class
	abstractListClass() {
		setParent( "AbstractList" );
	}
}

abstract class abstractSequentialListClass extends Class {
	abstractSequentialListClass() {
		setParent( "AbstractSequentialList" );
	}
}

abstract class abstractQueueClass extends Class {
	abstractQueueClass() {
		setParent( "AbstractQueue" );
	}
}

class abstractCollection extends Class {
	String myMethod() { return "clMethod"; }
	String myConstructor() { return "clConstructor"; }
	abstractCollection() {
		setName( "AbstractCollection" );
		setParent( "Object" );
		setDesc( "A collection represents a group of objects. Some collections allow duplicate elements and others do not. Some are ordered and others unordered. This interface is typically used to pass collections around and manipulate them where maximum generality is desired." );
		setSimilarClasses( new String[]{ "AbstractList, AbstractSequentialList", "AbstractQueue"} );
		addMethod( new clAdd() );
		addMethod( new clAddAll() );
		addMethod( new clClear() );
		addMethod( new clContains() );
		addMethod( new clContainsAll() );
		addMethod( new clIsEmpty() );
		addMethod( new clIterator() );
		addMethod( new clRemove() );
		addMethod( new clRemoveAll() );
		addMethod( new clSize() );
		addMethod( new clToArray() );
		addMethod( new clToArray2() );
	}
}

class abstractList extends collectionClass {
	String myMethod() { return "ablMethod"; }
	String myConstructor() { return "ablConstructor"; }
	abstractList() {
		setName( "AbstractList" );
		setDesc( "This class provides a skeletal implementation of the List interface to minimize the effort required to implement this interface backed by a \"random access\" data store (such as an array). " );
		setSimilarClasses( new String[]{ "AbstractCollection, AbstractSequentialList", "AbstractQueue"} );
		addMethod( new ablAdd() );
		addMethod( new ablAdd2() );
		addMethod( new ablAddAll() );
		addMethod( new ablClear() );
		addMethod( new ablEquals() );
		addMethod( new ablGet() );
		addMethod( new ablHashcode() );
		addMethod( new ablIndexOf() );
		addMethod( new ablIterator() );
		addMethod( new ablLastIndexOf() );
		addMethod( new ablListIterator() );
		addMethod( new ablListIterator2() );
		addMethod( new ablRemove() );
		addMethod( new ablRemoveRange() );
		addMethod( new ablSet() );
		addMethod( new ablSublist() );
	}
}

class abstractSequentialList extends abstractListClass {
	String myMethod() { return "asqlMethod"; }
	String myConstructor() { return "asqlConstructor"; }
	abstractSequentialList() {
		setName( "AbstractSequentialList" );
		setDesc( "This class provides a skeletal implementation of the List interface to minimize the effort required to implement this interface backed by a \"sequential access\" data store (such as a linked list). For random access data (such as an array), AbstractList should be used in preference to this class." );
		setSimilarClasses( new String[]{ "AbstractCollection, AbstractList", "AbstractQueue" } );
		addMethod( new asqlAdd() );
		addMethod( new asqlAddAll() );
		addMethod( new asqlGet() );
		addMethod( new asqlIterator() );
		addMethod( new asqlListIterator() );
	}
}

class abstractQueue extends collectionClass {
	String myMethod() { return "abstractQueueMethod"; }
	String myConstructor() { return "abstractQueueConstructor"; }
	abstractQueue() {
		setName("AbstractQueue");
		setDesc("This class provides skeletal implementations of some Queue operations. The implementations in this class are appropriate when the base implementation does not allow null elements. Methods add, remove, and element are based on offer, poll, and peek, respectively but throw exceptions instead of indicating failure via false or null returns.");
		setSimilarClasses( new String[]{ "AbstractCollection, AbstractList", "AbstractSequentialList" } );
		//addConstruct( new AbstractQueue1() );
		addMethod( new aqAdd() );
		addMethod( new aqAddAll() );
		addMethod( new aqClear() );
		addMethod( new aqElement() );
		addMethod( new aqRemove() ) ;
	}
}

class vector extends abstractListClass {
	String myMethod() { return "vecMethod"; }
	String myConstructor() { return "vecConstructor"; }
	vector() {
		setName( "Vector" );
		setDesc("The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.");
		setSimilarClasses( new String[]{ "ArrayList", "LinkedList", "ArrayDeque", "PriorityQueue" } );
		addConstruct( new Vector1() );
		addConstruct( new Vector2() );
		addConstruct( new Vector3() );
		addConstruct( new Vector4() );
		addMethod( new vecAdd() );
		addMethod( new vecAdd2() );
		addMethod( new vecAddAll() );
		addMethod( new vecAddAll2() );
		addMethod( new vecAddElement() );
		addMethod( new vecCapacity() );
		addMethod( new vecClear() );
		addMethod( new vecClone() );
		addMethod( new vecContains() );
		addMethod( new veccontainsAll() );
		addMethod( new vecCopyInto() );
		addMethod( new vecElementAt() );
		addMethod( new vecElements() );
		addMethod( new vecEnsureCapacity() );
		addMethod( new vecequals() );
		addMethod( new vecFirstElement() );
		addMethod( new vecGet() );
		addMethod( new vecIndexOf() );
		addMethod( new vecIndexOf2() );
		addMethod( new vecInsertElementAt() );
		addMethod( new vecisEmpty() );
		addMethod( new vecLastElement() );
		addMethod( new vecLastIndexOf() );
		addMethod( new vecLastIndexOf2() );
		addMethod( new vecRemove() );
		addMethod( new vecRemove2() );
		addMethod( new vecRemoveAll() );
		addMethod( new vecRemoveAllElements() );
		addMethod( new vecRemoveElement() );
		addMethod( new vecRemoveElementAt() );
		addMethod( new vecRemoveRange() );
		addMethod( new vecSet() );
		addMethod( new vecSetElementAt() );
		addMethod( new vecSetSize() );
		addMethod( new vecSize() );
		addMethod( new vecSubList() );
		addMethod( new vecToArray() );
		addMethod( new vecToArray2() );
		addMethod( new vecToString() );
		addMethod( new vecTrimToSize() );
	}
}

class List extends Class {
	String myMethod() { return "listMethod"; }
	String myConstructor() { return "listConstructor"; }
	List() {
		setName( "List" );
		setParent( "Component" );
		setDesc( "The List component presents the user with a scrolling list of text items. The list can be set up so that the user can choose either one item or multiple items." );
		addConstruct( new List1() );
		addConstruct( new List2() );
		addConstruct( new List3() );
		addMethod( new listAdd() );
		addMethod( new listAdd2() );
		addMethod( new listAddActionListener() );
		addMethod( new listAddItemListener() );
		addMethod( new listAddNotify() );
		addMethod( new listDeselect() );
		addMethod( new listGetAccessibleContext() );
		addMethod( new listGetActionListeners() );
		addMethod( new listGetItem() );
		addMethod( new listGetItems() );
		addMethod( new listGetItemCount() );
		addMethod( new listGetItemListeners() );
		addMethod( new listGetListeners() );
		addMethod( new listGetMinimumSize() );
		addMethod( new listGetMinimumSize2() );
		addMethod( new listGetPreferredSize() );
		addMethod( new listGetPreferredSize2() );
		addMethod( new listGetRows() );
		addMethod( new listGetSelectedIndex() );
		addMethod( new listGetSelectedIndexes() );
		addMethod( new listGetSelectedItem() );
		addMethod( new listGetSelectedItems() );
		addMethod( new listGetSelectedObjects() );
		addMethod( new listGetVisibleIndex() );
		addMethod( new listIsIndexSelected() );
		addMethod( new listIsMultipleMode() );
		addMethod( new listMakeVisible() );
		addMethod( new listParamString() );
		addMethod( new listProcessActionEvent() );
		addMethod( new listProcessEvent() );
		addMethod( new listProcessItemEvent() );
		addMethod( new listRemove() );
		addMethod( new listRemove2() );
		addMethod( new listRemoveActionListener() );
		addMethod( new listRemoveItemListener() );
		addMethod( new listRemoveAll() );
		addMethod( new listRemoveNotify() );
		addMethod( new listReplaceItem() );
		addMethod( new listSelect() );
		addMethod( new listSetMultipleMode() );
	}
}

class arrayList extends abstractListClass {
	String myMethod() { return "arrMethod"; }
	String myConstructor() { return "arrConstructor"; }
	arrayList() {
		setName("ArrayList");
		setDesc("Resizeable-array implementation of the \"List\" interface. Implements all optional list operations, and permits all elements, including null.");
		setSimilarClasses( new String[]{ "Vector", "LinkedList", "ArrayDeque", "PriorityQueue" } );
		addConstruct( new ArrayList1() );
		addConstruct( new ArrayList2() );
		addConstruct( new ArrayList3() );
		addMethod( new arrAdd() );
		addMethod( new arrAdd2() );
		addMethod( new arrAddAll() );
		addMethod( new arrAddAll2() );
		addMethod( new arrClear() );
		addMethod( new arrClone() );
		addMethod( new arrContains() );
		addMethod( new arrEnsureCapacity() );
		addMethod( new arrGet() );
		addMethod( new arrIndexOf() );
		addMethod( new arrIsEmpty() );
		addMethod( new arrLastIndexOf() );
		addMethod( new arrRemove() );
		addMethod( new arrRemove2() );
		addMethod( new arrRemoveRange() );
		addMethod( new arrSet() );
		addMethod( new arrSize() );
		addMethod( new arrToArray() );
		addMethod( new arrToArray2() );
		addMethod( new arrTrimToSize() );		
	}
}

class linkedList extends abstractSequentialListClass {
	String myMethod() { return "llistMethod"; }
	String myConstructor() { return "llistConstructor"; }
	linkedList() {
		setName( "LinkedList" );
		setDesc( "Linked list implementation of the List interface. Implements all optional list operations, and permits all elements (including null). In addition to implementing the List interface, the LinkedList class provides uniformly named methods to get, remove and insert an element at the beginning and end of the list. These operations allow linked lists to be used as a stack, queue, or double-ended queue." );
		setSimilarClasses( new String[]{ "Vector", "ArrayList", "ArrayDeque", "PriorityQueue" } );
		addConstruct( new LinkedList1() );
		addConstruct( new LinkedList2() );
		addMethod( new llistAdd() );
		addMethod( new llistAdd2() );
		addMethod( new llistAddAll() );
		addMethod( new llistAddAll2() );
		addMethod( new llistAddFirst() );
		addMethod( new llistAddLast() );
		addMethod( new llistClear() );
		addMethod( new llistClone() );
		addMethod( new llistContains() );
		addMethod( new llistDescendingIterator() );
		addMethod( new llistElement() );
		addMethod( new llistGet() );
		addMethod( new llistGetFirst() );
		addMethod( new llistGetLast() );
		addMethod( new llistIndexOf() );
		addMethod( new llistLastIndexOf() );
		addMethod( new llistListIterator() );
		addMethod( new llistOffer() );
		addMethod( new llistOfferFirst() );
		addMethod( new llistOfferLast() );
		addMethod( new llistPeek() );
		addMethod( new llistPeekFirst() );
		addMethod( new llistPeekLast() );
		addMethod( new llistPoll() );
		addMethod( new llistPollFirst() );
		addMethod( new llistPollLast() );
		addMethod( new llistPop() );
		addMethod( new llistPush() );
		addMethod( new llistRemove() );
		addMethod( new llistRemove2() );
		addMethod( new llistRemove3() );
		addMethod( new llistRemoveFirst() );
		addMethod( new llistRemoveFirstOccurrence() );
		addMethod( new llistRemoveLast() );
		addMethod( new llistRemoveLastOccurrence() );
		addMethod( new llistSet() );
		addMethod( new llistSize() );
		addMethod( new llistToArray() );
		addMethod( new llistToArray2() );
	}
}

class priorityQueue extends abstractQueueClass {
	String myMethod() { return "PriorityQueueMethod"; }
	String myConstructor() { return "PriorityQueueConstructor"; }
	priorityQueue() {
		setName("PriorityQueue");
		setDesc("An unbounded priority queue based on a priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used. A priority queue does not permit null elements. A priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in ClassCastException).");
		setSimilarClasses( new String[]{ "Vector", "ArrayList", "LinkedList", "ArrayDeque" } );
		addConstruct( new PriorityQueue1() );
		addConstruct( new PriorityQueue2() );
		addConstruct( new PriorityQueue3() );
		addConstruct( new PriorityQueue4() );
		addConstruct( new PriorityQueue5() );
		addConstruct( new PriorityQueue6() );
		addMethod( new pqAdd() );
		addMethod( new pqClear() );
		addMethod( new pqComparator() );
		addMethod( new pqContains() );
		addMethod( new pqIterator() ) ;
		addMethod( new pqOffer() );
		addMethod( new pqPeek() );
		addMethod( new pqPoll() );
		addMethod( new pqRemove() );
		addMethod( new pqSize() );
		addMethod( new pqToArray() );
		addMethod( new pqToArray2() );
	}
}

class arrayDeque extends collectionClass {
	String myMethod() { return "arrayDequeMethod"; }
	String myConstructor() { return "arrayDequeConstructor"; }
	arrayDeque() {
		setName("ArrayDeque");
		setDesc("Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. They are not thread-safe; in the absence of external synchronization, they do not support concurrent access by multiple threads. Null elements are prohibited. This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.");
		setSimilarClasses( new String[]{ "Vector", "ArrayList", "LinkedList", "PriorityQueue" } );
		addConstruct( new ArrayDeque1() );
		addConstruct( new ArrayDeque2() );
		addConstruct( new ArrayDeque3() );
		addMethod( new adAdd() );
		addMethod( new adAddFirst() );
		addMethod( new adAddLast() );
		addMethod( new adClear() );
		addMethod( new adClone() );
		addMethod( new adContains() );
		addMethod( new adDescendingIterator() );
		addMethod( new adElement() );
		addMethod( new adGetFirst() );
		addMethod( new adGetLast() );
		addMethod( new adIsEmpty() );
		addMethod( new adIterator() );
		addMethod( new adOffer() );
		addMethod( new adOfferFirst() );
		addMethod( new adOfferLast() );
		addMethod( new adPeek() );
		addMethod( new adPeekFirst() );
		addMethod( new adPeekLast() );
		addMethod( new adPoll() );
		addMethod( new adPollFirst() );
		addMethod( new adPollLast() );
		addMethod( new adPop() );
		addMethod( new adPush() );
		addMethod( new adRemove() );
		addMethod( new adRemoveFirst() );
		addMethod( new adRemoveFirstOccurrence() );
		addMethod( new adRemoveLast() );
		addMethod( new adRemoveLastOccurrence() );
		addMethod( new adSize() );
		addMethod( new adToArray() );
		addMethod( new adToArray2() );
	}
}

/*************************************************************
**********************NUMBER CLASSES**************************
**************************************************************/

class number extends Class {
	String myMethod() { return "numMethod"; }
	String myConstructor() { return "numConstructor"; }
	number() {
		setName( "Number" );
		setParent( "Object" );
		setDesc( "The abstract class Number is the superclass of classes BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, and Short." );
		setSimilarClasses( new String[]{ "AtomicInteger", "AtomicLong", "BigDecimal", "BigInteger", "Byte", "Double", "Float", "Integer", "Long", "Short" } );
		//addConstruct( new Number1() );
		addMethod( new numByteValue() );
		addMethod( new numDoubleValue() );
		addMethod( new numFloatValue() );
		addMethod( new numIntValue() );
		addMethod( new numShortValue() );
	}
}

abstract class numClass extends Class {
	numClass() {
		setParent( "Number" );
	}
}

class integer extends numClass {
	String myMethod() { return "intMethod"; }
	String myConstructor() { return "intConstructor"; }
	integer() {
		setName( "Integer" );
		setDesc( "The Integer class wraps a value of the primitive type int in an object. In addition, this class provides several methods for converting an int to a String and a String to an int, as well as other constants and methods useful when dealing with an int." );
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong",  "BigDecimal", "BigInteger", "Byte", "Double", "Float", "Long", "Short" } );
		addConstruct( new Integer1() );
		addConstruct( new Integer2() );
		addMethod( new intBitCount() );
		addMethod( new intByteValue() );
		addMethod( new intCompare() );
		addMethod( new intCompareTo() );
		addMethod( new intDecode() );
		addMethod( new intDoubleValue() );
		addMethod( new intEquals() );
		addMethod( new intFloatValue() );
		addMethod( new intGetInteger() );
		addMethod( new intGetInteger2() );
		addMethod( new intGetInteger3() );
		addMethod( new intHashCode() );
		addMethod( new intHighestOneBit() );
		addMethod( new intIntValue() );
		addMethod( new intLongValue() );
		addMethod( new intLowestOneBit() );
		addMethod( new intNumberOfLeadingZeros() );
		addMethod( new intNumberOfTrailingZeros () );
		addMethod( new intParseInt() );
		addMethod( new intParseInt2() );
		addMethod( new intReverse() );
		addMethod( new intReverseBytes() );
		addMethod( new intRotateLeft() );
		addMethod( new intRotateRight() );
		addMethod( new intShortValue() );
		addMethod( new intSigNum() );
		addMethod( new intToBinaryString() );
		addMethod( new intToHexString() );
		addMethod( new intToOctalString() );
		addMethod( new intToString() );
		addMethod( new intToString2() );
		addMethod( new intToString3() );
		addMethod( new intValueOf() );
		addMethod( new intValueOf2() );
		addMethod( new intValueOf3() );
	}
}

class Byte extends numClass {
	String myMethod() { return "byteMethod"; }
	String myConstructor() { return "byteConstructor"; }
	Byte() {
		setName("Byte");
		setDesc("The Byte class wraps a value of primitive type byte in an object. An object of type Byte contains a single field whose type is byte.");
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong",  "BigDecimal", "BigInteger", "Double", "Float", "Integer", "Long", "Short" } );
		addConstruct( new Byte1() );
		addConstruct( new Byte2() );
		addMethod( new byteByteValue() );
		addMethod( new byteCompareTo() );
		addMethod( new byteDecode() );
		addMethod( new byteDoubleValue() );
		addMethod( new byteEquals() );
		addMethod( new byteFloatValue() );
		addMethod( new byteHashCode() );
		addMethod( new byteIntValue() );
		addMethod( new byteLongValue() );
		addMethod( new byteParseByte() );
		addMethod( new byteParseByte2() );
		addMethod( new byteShortValue() );
		addMethod( new byteToString() );
		addMethod( new byteToString2() );
		addMethod( new byteValueOf() );
		addMethod( new byteValueOf2() );
		addMethod( new byteValueOf3() );
	}
}

class myDouble extends numClass {
	String myMethod() { return "doubleMethod"; }
	String myConstructor() { return "doubleConstructor"; }
	myDouble() {
		setName("Double");
		setDesc("The Double class wraps a value of the primitive type double in an object. An object of type Double contains a single field whose type is double.");
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong",  "BigDecimal", "BigInteger", "Byte", "Float", "Integer", "Long", "Short" } );
		addConstruct( new Double1() );
		addConstruct( new Double2() );
		addMethod( new doubleByteValue() );
		addMethod( new doubleCompare() );
		addMethod( new doubleCompareTo() );
		addMethod( new doubleDoubleToLongBits() );
		addMethod( new doubleDoubleToRawLongBits() );
		addMethod( new doubleDoubleValue() );
		addMethod( new doubleEquals() );
		addMethod( new doubleFloatValue() );
		addMethod( new doubleHashCode() );
		addMethod( new doubleIntValue() );
		addMethod( new doubleIsInfinite() );
		addMethod( new doubleIsInfinite2() );
		addMethod( new doubleIsNaN() );
		addMethod( new doubleIsNaN2() );
		addMethod( new doubleLongBitsToDouble() );
		addMethod( new doubleLongValue() );
		addMethod( new doubleParseDouble() );
		addMethod( new doubleShortValue() );
		addMethod( new doubleToHexString() );
		addMethod( new doubleToString() );
		addMethod( new doubleToString2() );
		addMethod( new doubleValueOf() );
		addMethod( new doubleValueOf2() );
	}
}

class Float extends numClass {
	String myMethod() { return "floatMethod"; }
	String myConstructor() { return "floatConstructor"; }
	Float() {
		setName( "Float" );
		setDesc( "The Float class wraps a value of primitive type float in an object. An object of type Float contains a single field whose type is float." );
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong",  "BigDecimal", "BigInteger", "Byte", "Double", "Integer", "Long", "Short" } );
		addConstruct( new Float1() );
		addConstruct( new Float2() );
		addConstruct( new Float3() );
		addMethod( new floatByteValue() );
		addMethod( new floatCompare() );
		addMethod( new floatCompareTo() );
		addMethod( new floatDoubleValue() );
		addMethod( new floatEquals() );
		addMethod( new floatFloatToIntBits() );
		addMethod( new floatFloatToRawIntBits() );
		addMethod( new floatFloatValue() );
		addMethod( new floatHashCode() );
		addMethod( new floatIntBitsToFloat() );
		addMethod( new floatIntValue() );
		addMethod( new floatIsInfinite() );
		addMethod( new floatIsInfinite2() );
		addMethod( new floatIsNaN() );
		addMethod( new floatIsNaN2() );
		addMethod( new floatLongValue() );
		addMethod( new floatParseFloat() );
		addMethod( new floatShortValue() );
		addMethod( new floatToHexString() );
		addMethod( new floatToString() );
		addMethod( new floatToString2() );
		addMethod( new floatValueOf() );
		addMethod( new floatValueOf2() );
	}
}

class Long extends numClass {
	String myMethod() { return "longMethod"; }
	String myConstructor() { return "longConstructor"; }
	Long() {
		setName("Long");
		setDesc("The Long class wraps a value of the primitive type long in an object. An object of type Long contains a single field whose type is long.");
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong",  "BigDecimal", "BigInteger", "Byte", "Double", "Float", "Integer", "Short" } );
		addConstruct( new Long1() );
		addConstruct( new Long2() );
		addMethod( new longBitCount() );
		addMethod( new longByteValue() );
		addMethod( new longCompareTo() );
		addMethod( new longDecode() );
		addMethod( new longDoubleValue() );
		addMethod( new longEquals() );
		addMethod( new longFloatValue() );
		addMethod( new longGetLong() );
		addMethod( new longGetLong2() );
		addMethod( new longHashCode() );
		addMethod( new longHighestOneBit() );
		addMethod( new longIntValue() );
		addMethod( new longLongValue() );
		addMethod( new longLowestOneBit() );
		addMethod( new longNumberOfLeadingZeros() );
		addMethod( new longNumberOfTrailingZeros() );
		addMethod( new longParseLong() );
		addMethod( new longParseLong2() );
		addMethod( new longReverse() );
		addMethod( new longReverseBytes() );
		addMethod( new longRotateLeft() );
		addMethod( new longRotateRight() );
		addMethod( new longShortValue() );
		addMethod( new longSignum() );
		addMethod( new longToBinaryString() );
		addMethod( new longToHexString() );
		addMethod( new longToOctalString() );
		addMethod( new longToString() );
		addMethod( new longToString2() );
		addMethod( new longValueOf() );
		addMethod( new longValueOf2() );
		addMethod( new longValueOf3() );
	}
}

class Short extends numClass {
	String myMethod() { return "shortMethod"; }
	String myConstructor() { return "shortConstructor"; }
	Short() {
		setName( "Short" );
		setDesc( "The Short class wraps a value of primitive type short in an object. An object of type Short contains a single field whose type is short." );
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong",  "BigDecimal", "BigInteger", "Byte", "Double", "Float", "Integer", "Long" } );
		addConstruct( new Short1() );
		addConstruct( new Short2() );
		addMethod( new shortByteValue() );
		addMethod( new shortCompareTo() );
		addMethod( new shortDecode() );
		addMethod( new shortDoubleValue() );
		addMethod( new shortEquals() );
		addMethod( new shortFloatValue() );
		addMethod( new shortHashCode() );
		addMethod( new shortIntValue() );
		addMethod( new shortLongValue() );
		addMethod( new shortParseShort() );
		addMethod( new shortParseShort2() );
		addMethod( new shortReverseBytes() );
		addMethod( new shortShortValue() );
		addMethod( new shortToString() );
		addMethod( new shortToString2() );
		addMethod( new shortValueOf() );
		addMethod( new shortValueOf2() );
		addMethod( new shortValueOf3() );
	}
}

class atomicInteger extends numClass {
	String myMethod() { return "ATIMethod"; }
	String myConstructor() { return "ATIConstructor"; }
	atomicInteger() {
		setName( "AtomicInteger" );
		setDesc( "An int value that may be updated atomically. An AtomicInteger is used in applications such as atomically incremented counters, and cannot be used as a replacement for an Integer. However, this class does extend Number to allow uniform access by tools and utilities that deal with numerically-based classes." );
		setSimilarClasses( new String[]{ "Number", "AtomicLong", "BigDecimal", "BigInteger", "Byte", "Double", "Float", "Integer", "Long", "Short" } );
		addConstruct( new AtomicInteger1() );
		addConstruct( new AtomicInteger2() );
		addMethod( new atiAddAndGet() );
		addMethod( new atiCompareAndSet() );
		addMethod( new atiDecrementAndGet() );
		addMethod( new atiDoubleValue() );
		addMethod( new atiFloatValue() );
		addMethod( new atiGet() );
		addMethod( new atiGetAndAdd() );
		addMethod( new atiGetAndDecrement() );
		addMethod( new atiGetAndIncrement() );
		addMethod( new atiGetAndSet() );
		addMethod( new atiIncrementAndGet() );
		addMethod( new atiIntValue() );
		addMethod( new atiLazySet() );
		addMethod( new atiLongValue() );
		addMethod( new atiSet() );
		addMethod( new atiToString() );
		addMethod( new atiWeakCompareAndSet() );
	}
}

class atomicLong extends numClass {
	String myMethod() { return "ATLMethod"; }
	String myConstructor() { return "ATLConstructor"; }
	atomicLong() {
		setName( "AtomicLong" );
		setDesc( "An long value that may be updated atomically. n AtomicLong is used in applications such as atomically incremented sequence numbers, and cannot be used as a replacement for a Long. However, this class does extend Number to allow uniform access by tools and utilities that deal with numerically-based classes." );
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "BigDecimal", "BigInteger", "Byte", "Double", "Float", "Integer", "Long", "Short" } );
		addConstruct( new AtomicLong1() );
		addConstruct( new AtomicLong2() );
		addMethod( new atlAddAndGet() );
		addMethod( new atlCompareAndSet() );
		addMethod( new atlDecrementAndGet() );
		addMethod( new atlDoubleValue() );
		addMethod( new atlFloatValue() );
		addMethod( new atlGet() );
		addMethod( new atlGetAndAdd() );
		addMethod( new atlGetAndDecrement() );
		addMethod( new atlGetAndIncrement() );
		addMethod( new atlGetAndSet() );
		addMethod( new atlIncrementAndGet() );
		addMethod( new atlIntValue() );
		addMethod( new atlLazySet() );
		addMethod( new atlLongValue() );
		addMethod( new atlSet() );
		addMethod( new atlToString() );
		addMethod( new atlWeakCompareAndSet() );
	}
}

class bigDecimal extends numClass {
	String myMethod() { return "BigDMethod"; }
	String myConstructor() { return "BigDConstructor"; }
	bigDecimal() {
		setName( "BigDecimal" );
		setDesc( "Immutable, arbitrary-precision signed decimal numbers. A BigDecimal consists of an arbitrary precision integer unscaled value and a 32-bit integer scale. If zero or positive, the scale is the number of digits to the right of the decimal point. If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale. The value of the number represented by the BigDecimal is therefore (unscaledValue × 10^-scale)." );
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong", "BigInteger", "Byte", "Double", "Float", "Integer", "Long", "Short" } );
		addConstruct(new BigDecimal1());
		addConstruct(new BigDecimal2());
		addConstruct(new BigDecimal3());
		addConstruct(new BigDecimal4());
		addConstruct(new BigDecimal5());
		addConstruct(new BigDecimal6());
		addConstruct(new BigDecimal7());
		addConstruct(new BigDecimal8());
		addConstruct(new BigDecimal9());
		addConstruct(new BigDecimal10());
		addConstruct(new BigDecimal11());
		addConstruct(new BigDecimal12());
		addConstruct(new BigDecimal13());
		addConstruct(new BigDecimal14());
		addConstruct(new BigDecimal15());
		addConstruct(new BigDecimal16());
		addMethod( new bdAbs() );
		addMethod( new bdAbs2() );
		addMethod( new bdAdd() );
		addMethod( new bdAdd2() );
		addMethod( new bdByteValueExact() );
		addMethod( new bdCompareTo() );
		addMethod( new bdDivide() );
		addMethod( new bdDivide2() );
		addMethod( new bdDivide3() );
		addMethod( new bdDivide4() );
		addMethod( new bdDivide5() );
		addMethod( new bdDivide6() );
		addMethod( new bdDivideAndRemainder() );
		addMethod( new bdDivideAndRemainder2() );
		addMethod( new bdDivideToIntegralValue() );
		addMethod( new bdDivideToIntegralValue2() );
		addMethod( new bdDoubleValue() );
		addMethod( new bdEquals() );
		addMethod( new bdFloatValue() );
		addMethod( new bdHashCode() );
		addMethod( new bdIntValue() );
		addMethod( new bdIntValueExact() );
		addMethod( new bdLongValue() );
		addMethod( new bdLongValueExact() );
		addMethod( new bdMax() );
		addMethod( new bdMin() );
		addMethod( new bdMovePointLeft() );
		addMethod( new bdMovePointRight() );
		addMethod( new bdMultiply() );
		addMethod( new bdMultiply2() );
		addMethod( new bdNegate() );
		addMethod( new bdNegate2() );
		addMethod( new bdPlus() );
		addMethod( new bdPlus2() );
		addMethod( new bdPow() );
		addMethod( new bdPow2() );
		addMethod( new bdPrecision() );
		addMethod( new bdRemainder() );
		addMethod( new bdRemainder2() );
		addMethod( new bdRound() );
		addMethod( new bdScale() );
		addMethod( new bdScaleByPowerOfTen() );
		addMethod( new bdSetScale() );
		addMethod( new bdSetScale2() );
		addMethod( new bdSetScale3() );
		addMethod( new bdShortValueExact() );
		addMethod( new bdSigNum() );
		addMethod( new bdStripTrailingZeros() );
		addMethod( new bdSubtract() );
		addMethod( new bdSubtract2() );
		addMethod( new bdToBigInteger() );
		addMethod( new bdToBigIntegerExact() );
		addMethod( new bdToEngineeringString() );
		addMethod( new bdToPlainString() );
		addMethod( new bdToString() );
		addMethod( new bdULP() );
		addMethod( new bdUnscaledValue() );
		addMethod( new bdValueOf() );
		addMethod( new bdValueOf2() );
		addMethod( new bdValueOf3() );
	}
}

class bigInteger extends numClass {
	String myMethod() { return "BigIMethod"; }
	String myConstructor() { return "BigIConstructor"; }
	bigInteger() {
		setName( "BigInteger" );
		setDesc( "Immutable arbitrary-precision integers. All operations behave as if BigIntegers were represented in two's-complement notation (like Java's primitive integer types). BigInteger provides analogues to all of Java's primitive integer operators, and all relevant methods from java.lang.Math. Additionally, BigInteger provides operations for modular arithmetic, GCD calculation, primality testing, prime generation, bit manipulation, and a few other miscellaneous operations." );
		setSimilarClasses( new String[]{ "Number", "AtomicInteger", "AtomicLong", "BigDecimal", "Byte", "Double", "Float", "Integer", "Long", "Short" } );
		addConstruct( new BigInteger1() );
		addConstruct( new BigInteger2() );
		addConstruct( new BigInteger3() );
		addConstruct( new BigInteger4() );
		addConstruct( new BigInteger5() );
		addConstruct( new BigInteger6() );
		addMethod( new biAbs() );
		addMethod( new biAdd() );
		addMethod( new biAnd() );
		addMethod( new biAndNot() );
		addMethod( new biBitCount() );
		addMethod( new biBitLength() );
		addMethod( new biClearBit() );
		addMethod( new biCompareTo() );
		addMethod( new biDivide() );
		addMethod( new biDivideAndRemainder() );
		addMethod( new biDoubleValue() );
		addMethod( new biEquals() );
		addMethod( new biFlipBit() );
		addMethod( new biFloatValue() );
		addMethod( new biGcd() );
		addMethod( new biGetLowestSetBit() );
		addMethod( new biHashCode() );
		addMethod( new biIntValue() );
		addMethod( new biIsProbablePrime() );
		addMethod( new biLongValue() );
		addMethod( new biMax() );
		addMethod( new biMin() );
		addMethod( new biMod() );
		addMethod( new biModInverse() );
		addMethod( new biModPow() );
		addMethod( new biMultiply() );
		addMethod( new biNegate() );
		addMethod( new biNextProbablePrime() );
		addMethod( new biNot() );
		addMethod( new biOr() );
		addMethod( new biPow() );
		addMethod( new biProbablePrime() );
		addMethod( new biRemainder() );
		addMethod( new biSetBit() );
		addMethod( new biShiftLeft() );
		addMethod( new biShiftRight() );
		addMethod( new biSignum() );
		addMethod( new biSubtract() );
		addMethod( new biTestBit() );
		addMethod( new biToByteArray() );
		addMethod( new biToString() );
		addMethod( new biToString2() );
		addMethod( new biValueOf() );
		addMethod( new biXor() );
	}
}
 
/*************************************************************
**********************MATH CLASSES**************************
**************************************************************/

class math extends Class {
	String myMethod() { return "mathMethod"; }
	String myConstructor() { return "mathConstructor"; }
	math() {
		setName( "Math" );
		setDesc( "The class Math contains methods for performing basic numeric operations such as the elementary exponential, logarithm, square root, and trigonometric functions." );
		addMethod( new mathAbs() );
		addMethod( new mathAbs2() );
		addMethod( new mathAbs3() );
		addMethod( new mathAbs4() );
		addMethod( new mathAcos() );
		addMethod( new mathAsin() );
		addMethod( new mathAtan() );
		addMethod( new mathAtan2() );
		addMethod( new mathCbrt() );
		addMethod( new mathCeil() );
		addMethod( new mathCopySign() );
		addMethod( new mathCopySign2() );
		addMethod( new mathCos() );
		addMethod( new mathCosh() );
		addMethod( new mathExp() );
		addMethod( new mathExpm1() );
		addMethod( new mathFloor() );
		addMethod( new mathGetExponent() );
		addMethod( new mathGetExponent2() );
		addMethod( new mathHypot() );
		addMethod( new mathIEEEremainder() );
		addMethod( new mathLog() );
		addMethod( new mathLog10() );
		addMethod( new mathLog1p() );
		addMethod( new mathMax() );
		addMethod( new mathMax2() );
		addMethod( new mathMax3() );
		addMethod( new mathMax4() );
		addMethod( new mathMin() );
		addMethod( new mathMin2() );
		addMethod( new mathMin3() );
		addMethod( new mathMin4() );
		addMethod( new mathNextAfter() );
		addMethod( new mathNextAfter2() );
		addMethod( new mathNextUp() );
		addMethod( new mathNextUp2() );
		addMethod( new mathPow() );
		addMethod( new mathRandom() );
		addMethod( new mathRint() );
		addMethod( new mathRound() );
		addMethod( new mathRound2() );
		addMethod( new mathscalb() );
		addMethod( new mathScalb2() );
		addMethod( new mathSignum() );
		addMethod( new mathSignum2() );
		addMethod( new mathSin() );
		addMethod( new mathSinh() );
		addMethod( new mathSqrt() );
		addMethod( new mathTan() );
		addMethod( new mathTanh() );
		addMethod( new mathToDegrees() );
		addMethod( new mathToRadians() );
		addMethod( new mathUlp() );
		addMethod( new mathUlp2() );
	}
}

/*************************************************************
**********************STRING CLASSES**************************
**************************************************************/

class string extends Class {
	String myMethod() { return "stringMethod"; }
	String myConstructor() { return "stringConstructor"; }
	string() {
		setName( "String" );
		setDesc( "The String class represents character strings. All string literals in Java programs, such as 'abc', are implemented as instances of this class." );
		setSimilarClasses( new String[]{ "StringBuilder", "StringBuffer" } );
		addConstruct( new String1() );
		addConstruct( new String2() );
		addConstruct( new String2() );
		addConstruct( new String3() );
		addConstruct( new String4() );
		addConstruct( new String5() );
		addConstruct( new String6() );
		addConstruct( new String7() );
		addConstruct( new String8() );
		addConstruct( new String9() );
		addConstruct( new String10() );
		addConstruct( new String11() );
		addConstruct( new String12() );
		addConstruct( new String13() );
		addConstruct( new String14() );
		addConstruct( new String15() );
		addMethod( new strCharAt() );
		addMethod( new strCodePointAt() );
		addMethod( new strCodePointBefore() );
		addMethod( new strCodePointCount() );
		addMethod( new strCompareTo() );
		addMethod( new strCompareToIgnoreCase() );
		addMethod( new strConcat() );
		addMethod( new strContains() );
		addMethod( new strContentEquals() );
		addMethod( new strContentEquals2() );
		addMethod( new strCopyValueOf() );
		addMethod( new strCopyValueOf2() );
		addMethod( new strEndsWith() );
		addMethod( new strEquals() );
		addMethod( new strEqualsIgnoreCase() );
		addMethod( new strFormat() );
		addMethod( new strFormat2() );
		addMethod( new strGetBytes() );
		addMethod( new strGetBytes2() );
		addMethod( new strGetBytes3() );
		addMethod( new strGetChars() );
		addMethod( new strHashCode() );
		addMethod( new strIndexOf() );
		addMethod( new strIndexOf2() );
		addMethod( new strIndexOf3() );
		addMethod( new strIndexOf4() );
		addMethod( new strIntern() );
		addMethod( new strIsEmpty() );
		addMethod( new strLastIndexOf() );
		addMethod( new strLastIndexOf2() );
		addMethod( new strLastIndexOf3() );
		addMethod( new strLastIndexOf4() );
		addMethod( new strLength() );
		addMethod( new strMatches() );
		addMethod( new strOffsetByCodePoints() );
		addMethod( new strRegionMatches() );
		addMethod( new strReplace() );
		addMethod( new strReplace2() );
		addMethod( new strReplaceAll() );
		addMethod( new strReplaceFirst() );
		addMethod( new strSplit() );
		addMethod( new strSplit2() );
		addMethod( new strStartsWith() );
		addMethod( new strStartsWith2() );
		addMethod( new strSubSequence() );
		addMethod( new strSubstring() );
		addMethod( new strSubstring2() );
		addMethod( new strToCharArray() );
		addMethod( new strToLowerCase() );
		addMethod( new strToLowerCase2() );
		addMethod( new strToString() );
		addMethod( new strToUpperCase() );
		addMethod( new strToUpperCase2() );
		addMethod( new strTrim() );
		addMethod( new strValueOf() );
		addMethod( new strValueOf2() );
		addMethod( new strValueOf3() );
		addMethod( new strValueOf4() );
		addMethod( new strValueOf5() );
		addMethod( new strValueOf6() );
		addMethod( new strValueOf7() );
		addMethod( new strValueOf8() );
		addMethod( new strValueOf9() );
	}
}

/*************************************************************
******************STRINGBUILDER CLASSES***********************
**************************************************************/

class stringBuilder extends Class {
	String myMethod() { return "stringBuilderMethod"; }
	String myConstructor() { return "stringBuilderConstructor"; }
	stringBuilder() {
		setName("StringBuilder");
		setDesc("A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.");
		setSimilarClasses( new String[]{ "String", "StringBuffer" } );
		addConstruct( new StringBuilder1() );
		addConstruct( new StringBuilder2() );
		addConstruct( new StringBuilder3() );
		addConstruct( new StringBuilder4() );
		addMethod( new sbAppend() );
		addMethod( new sbAppend2() );
		addMethod( new sbAppend3() );
		addMethod( new sbAppend4() );
		addMethod( new sbAppend5() );
		addMethod( new sbAppend6() );
		addMethod( new sbAppend7() );
		addMethod( new sbAppend8() );
		addMethod( new sbAppend9() );
		addMethod( new sbAppend10() );
		addMethod( new sbAppend11() );
		addMethod( new sbAppend12() );
		addMethod( new sbAppend13() );
		addMethod( new sbAppendCodePoint() );
		addMethod( new sbCapacity() );
		addMethod( new sbCharAt() ); 
		addMethod( new sbCodePointAt() );
		addMethod( new sbCodePointBefore() );
		addMethod( new sbCodePointCount() );
		addMethod( new sbDelete() );
		addMethod( new sbDeleteCharAt() );
		addMethod( new sbEnsureCapacity() );
		addMethod( new sbGetChars() );
		addMethod( new sbIndexOf() );
		addMethod( new sbIndexOf2() );
		addMethod( new sbInsert() );
		addMethod( new sbInsert2() );
		addMethod( new sbInsert3() );
		addMethod( new sbInsert4() );
		addMethod( new sbInsert5() );
		addMethod( new sbInsert6() );
		addMethod( new sbInsert7() );
		addMethod( new sbInsert8() );
		addMethod( new sbInsert9() );
		addMethod( new sbInsert10() );
		addMethod( new sbInsert11() );
		addMethod( new sbInsert12() );
		addMethod( new sbLastIndexOf() );
		addMethod( new sbLastIndexOf2() );
		addMethod( new sbLength() );
		addMethod( new sbOffsetByCodePoints() );
		addMethod( new sbReplace() );
		addMethod( new sbReverse() );
		addMethod( new sbSetCharAt() );
		addMethod( new sbSetLength() );
		addMethod( new sbSubSequence() );
		addMethod( new sbSubstring() );
		addMethod( new sbSubstring2() );
		addMethod( new sbToString() );
		addMethod( new sbTrimToSize() );
	}
}

class stringBuffer extends Class {
	String myMethod() { return "stringBufferMethod"; }
	String myConstructor() { return "stringBufferConstructor"; }
	stringBuffer() {
		setName("StringBuffer");
		setDesc("A thread-safe, mutable sequence of characters. A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters, but the length and content of the sequence can be changed through certain method calls.");
		setSimilarClasses( new String[]{ "String", "StringBuilder" } );
		addConstruct( new StringBuffer1() );
		addConstruct( new StringBuffer2() );
		addConstruct( new StringBuffer3() );
		addConstruct( new StringBuffer4() );
		addMethod( new sbufAppend() );
		addMethod( new sbufAppend2() );
		addMethod( new sbufAppend3() );
		addMethod( new sbufAppend4() );
		addMethod( new sbufAppend5() );
		addMethod( new sbufAppend6() );
		addMethod( new sbufAppend7() );
		addMethod( new sbufAppend8() );
		addMethod( new sbufAppend9() );
		addMethod( new sbufAppend10() );
		addMethod( new sbufAppend11() );
		addMethod( new sbufAppend12() );
		addMethod( new sbufAppend13() );
		addMethod( new sbufAppendCodePoint() );
		addMethod( new sbufCapacity() );
		addMethod( new sbufCharAt() );
		addMethod( new sbufCodePointAt() );
		addMethod( new sbufCodePointBefore() );
		addMethod( new sbufCodePointCount() );
		addMethod( new sbufDelete() );
		addMethod( new sbufDeleteCharAt() );
		addMethod( new sbufEnsureCapacity() );
		addMethod( new sbufGetChars() );
		addMethod( new sbufIndexOf() );
		addMethod( new sbufIndexOf2() );
		addMethod( new sbufInsert() );
		addMethod( new sbufInsert2());
		addMethod( new sbufInsert3() );
		addMethod( new sbufInsert4() );
		addMethod( new sbufInsert5() );
		addMethod( new sbufInsert6() );
		addMethod( new sbufInsert7() );
		addMethod( new sbufInsert8() );
		addMethod( new sbufInsert9() );
		addMethod( new sbufInsert10() );
		addMethod( new sbufInsert11() );
		addMethod( new sbufInsert12() );
		addMethod( new sbufLastIndexOf() );
		addMethod( new sbufLastIndexOf2() );
		addMethod( new sbufLength() );
		addMethod( new sbufOffsetByCodePoints() );
		addMethod( new sbufReplace() );
		addMethod( new sbufReverse() );
		addMethod( new sbufSetCharAt() );
		addMethod( new sbufSetLength() );
		addMethod( new sbufSubSequence() );
		addMethod( new sbufSubstring() );
		addMethod( new sbufSubstring2() );
		addMethod( new sbufToString() );
		addMethod( new sbufTrimToSize() );
	}
}

/*************************************************************
 **********************DATE CLASSES**************************
 **************************************************************/

class date extends Class {
	String myMethod() { return "dateMethod"; }
	String myConstructor() { return "dateConstructor"; }
	date() {
		setName( "Date" );
		setParent( "Object" );
		setDesc( "The class Date represents a specific instant in time, with millisecond precision." );
		addConstruct( new Date1() );
        addMethod( new dateAfter() );
        addMethod( new dateBefore() );
        addMethod( new dateCompareTo() );
        addMethod( new dateEquals() );
        addMethod( new dateGetTime() );
        addMethod( new dateHashCode() );
        addMethod( new dateSetTime() );
        addMethod( new dateToString() );
    }
}