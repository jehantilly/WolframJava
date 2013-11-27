import java.util.ArrayList;


abstract class Class extends Searchable {
	private String parent;
	private ArrayList<Method> methods = new ArrayList<Method>();
	private ArrayList<Constructor> constructors = new ArrayList<Constructor>();
	
	void setParent( String p ) { parent = p; }
	void addConstruct( Constructor c ) { constructors.add(c); }
	void addMethod( Method m ) { methods.add(m); }
	String getParent() { return parent; }
	ArrayList<Method> getMethods() { return methods; }
	ArrayList<Constructor> getConstructors() { return constructors; }
	public String toString() { return getName(); }
	public String getType() { return "Class"; }
}

class object extends Class { 
	object() {
		setName( "Object");
	}
}


/*************************************************************
*******************COLLECTION CLASSES*************************
**************************************************************/


class abstractCollection extends Class {
	abstractCollection() {
		setName( "AbstractCollection" );
		setParent( "Object" );
		setDesc( "A collection represents a group of objects. Some collections allow duplicate elements and others do not. Some are ordered and others unordered. This interface is typically used to pass collections around and manipulate them where maximum generality is desired." );
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

abstract class collectionClass extends Class {	// All classes that extend from AbstractCollection will inherit from this class
	collectionClass() {
		setParent( "AbstractCollection" );
	}
}

class vector extends collectionClass {
	vector() {
		setName( "Vector" );
		setDesc("The Vector class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.");
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

class abstractList extends collectionClass {
	abstractList() {
		setName( "AbstractList" );
		setDesc( "This class provides a skeletal implementation of the List interface to minimize the effort required to implement this interface backed by a \"random access\" data store (such as an array). " );
		//...add Methods
	}
}

class arrayList extends Class {
	arrayList() {
		setName("ArrayList");
		setParent( "AbstractList" );
		setDesc("Resizeable-array implementation of the \"List\" interface. Implements all optional list operations, and permits all elements, including null.");
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

/*************************************************************
**********************NUMBER CLASSES**************************
**************************************************************/

class number extends Class {
	number() {
		setName( "Number" );
		setParent( "Object" );
		setDesc( "The abstract class Number is the superclass of classes BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, and Short." );
		addConstruct( new Number1() );
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
	integer() {
		setName( "Integer" );
		setDesc( "The Integer class wraps a value of the primitive type int in an object. In addition, this class provides several methods for converting an int to a String and a String to an int, as well as other constants and methods useful when dealing with an int." );
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
	Byte() {
		setName("Byte");
		setDesc("The Byte class wraps a value of primitive type byte in an object. An object of type Byte contains a single field whose type is byte.");
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

class Double extends numClass {
	Double() {
		setName("Double");
		setDesc("The Double class wraps a value of the primitive type double in an object. An object of type Double contains a single field whose type is double.");
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

/*************************************************************
**********************MATH CLASSES**************************
**************************************************************/

class math extends Class {
	math() {
		setName( "Math" );
		setParent( "Object" );
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
	string() {
		setName( "String" );
		setParent( "Object" );
		setDesc( "The String class represents character strings. All string literals in Java programs, such as 'abc', are implemented as instances of this class." );
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
