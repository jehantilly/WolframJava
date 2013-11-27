import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class QueryHandler {
	
//	public static void main(String[] args) {
//		QueryHandler.query( "vec add(e)" );
//	}
	
	public static Searchable query( String s ) {
		Object[] topResults = top10Results( s );
		System.out.println( "Length: " + topResults.length );
		Searchable result = toSearchable( ( (myPair) topResults[0]).getName() );
		System.out.println( "Result: " + result );
		return result;
	}
	
	private static Object[] top10Results( String s ) {
		ArrayList<myPair> Pairs = new ArrayList<myPair>();
		formPairs( Pairs, classes, s );
		formPairs( Pairs, abstractcollectionMethods, s );
		formPairs( Pairs, arraylistMethods, s );
		formPairs( Pairs, byteMethods, s );
		formPairs( Pairs, doubleMethods, s );
		formPairs( Pairs, integerMethods, s );
		formPairs( Pairs, mathMethods, s );
		formPairs( Pairs, numberMethods, s );
		formPairs( Pairs, stringMethods, s );
		formPairs( Pairs, vectorMethods, s );
		formPairs( Pairs, vocab, s );
		
		Collections.sort( Pairs, new qComp( s ) );
		
		return Pairs.subList(0,10).toArray();
	}
	
	private static void formPairs( ArrayList<myPair> mP, String[] searchables, String s ) {
		for( int i = 0; i < searchables.length; ++i ) {
			int dist = Similarity.getDistance( s, searchables[i] );
			mP.add( new myPair( dist, searchables[i] ) );
		}
	}
	
	private static Searchable toSearchable( String s ) {
		System.out.println( "S == " + s );
		if( "abstractcollection.add(e)" == s ) { return new clAdd(); }
		if( "abstractcollection.addall(collection<? extends e>)" == s ) { return new clAddAll(); }
		if( "abstractcollection.clear()" == s ) { return new clClear(); }
		if( "abstractcollection.containsall(collection<?>)" == s ) { return new clContainsAll(); }
		if( "abstractcollection.isempty()" == s ) { return new clIsEmpty(); }
		if( "abstractcollection.iterator()" == s ) { return new clIterator(); }
		if( "abstractcollection.remove(object)" == s ) { return new clRemove(); }
		if( "abstractcollection.removeall(collection<?>)" == s ) { return new clRemoveAll(); }
		if( "abstractcollection.retainall(collection<?>)" == s ) { return new clRetainAll(); }
		if( "abstractcollection.size()" == s ) { return new clSize(); }
		if ( "abstractcollection.toarray()" == s ) { return new clToArray(); }
		if( "abstractcollection.toarray(t[])" == s ) { return new clToArray2(); }
		if( "abstractcollection.tostring()" == s ) { return new clToString(); }
		if( "arraylist()" == s ) { return new ArrayList1(); }
		if( "arraylist(collection<?>)" == s ) { return new ArrayList2(); }
		if( "arraylist(int)" == s ) { return new ArrayList3(); }
		if( "arraylist.add(e)" == s ) { return new arrAdd(); }
		if( "arraylist.add(int,e)" == s ) { return new arrAdd2(); }
		if( "arraylist.addall(collection<? extends e>)" == s ) { return new arrAddAll(); }
		if( "arraylist.addall(int,collection<? extends e>)" == s ) { return new arrAddAll2(); }
		if( "arraylist.clear()" == s ) { return new arrClear(); }
		if( "arraylist.clone()" == s ) { return new arrClone(); }
		if( "arraylist.contains(object)" == s ) { return new arrContains(); }
		if( "arraylist.ensurecapacity(int)" == s ) { return new arrEnsureCapacity(); }
		if( "arraylist.get(int)" == s ) { return new arrGet(); }
		if( "arraylist.indexof(object)" == s ) { return new arrIndexOf(); }
		if( "arraylist.isempty()" == s ) { return new arrIsEmpty(); }
		if( "arraylist.lastindexof(object)" == s ) { return new arrLastIndexOf(); }
		if( "arraylist.remove(int)" == s ) { return new arrRemove(); }
		if( "arraylist.remove(object)" == s ) { return new arrRemove2(); }
		if( "arraylist.removerange(int,int)" == s ) { return new arrRemoveRange(); }
		if( "arraylist.set(int,e)" == s ) { return new arrSet(); }
		if( "arraylist.size()" == s ) { return new arrSize(); }
		if( "arraylist.toarray()" == s ) { return new arrToArray(); }
		if( "arraylist.toarray(t[])" == s ) { return new arrToArray2(); }
		if( "arraylist.trimtosize()" == s ) { return new arrTrimToSize(); }
		if( "byte(byte)" == s ) { return new Byte1(); }
		if( "byte(string)" == s ) { return new Byte2(); }
		if( "byte.bytevalue()" == s ) { return new byteByteValue(); }
		if( "byte.compareto(byte)" == s ) { return new byteCompareTo(); }
		if( "byte.decode()" == s ) { return new byteDecode(); }
		if( "byte.doublevalue()" == s ) { return new byteDoubleValue(); }
		if( "byte.equals(object)" == s ) { return new byteEquals(); }
		if( "byte.floatvalue()" == s ) { return new byteFloatValue(); }
		if( "byte.hashcode()" == s ) { return new byteHashCode(); }
		if( "byte.intvalue()" == s ) { return new byteIntValue(); }
		if( "byte.longvalue()" == s ) { return new byteLongValue(); }
		if( "byte.parsebyte(string)" == s ) { return new byteParseByte(); }
		if( "byte.parsebyte(string,int)" == s ) { return new byteParseByte2(); }
		if( "byte.shortvalue()" == s ) { return new byteShortValue(); }
		if( "byte.tostring()" == s ) { return new byteToString(); }
		if( "byte.tostring(byte)" == s ) { return new byteToString2(); }
		if( "byte.valueof(byte)" == s ) { return new byteValueOf(); }
		if( "byte.valueof(string)" == s ) { return new byteValueOf2(); }
		if( "byte.valueof(string,int)" == s ) { return new byteValueOf3(); }
		if( "abstractcollection" == s ) { return new abstractCollection(); }
		if( "abstractlist" == s ) { return new abstractList(); }
		if( "arraylist" == s ) { return new arrayList(); }
		if( "byte" == s ) { return new Byte(); }
		if( "double" == s ) { return new Double(); }
		if( "integer" == s ) { return new integer(); }
		if( "math" == s ) { return new math(); }
		if( "number" == s ) { return new number(); }
		if( "string" == s ) {  return new string(); }
		if( "vector" == s ) { return new vector(); }
		if( "double(double)" == s ) { return new Double1(); }
		if( "double(string)" == s ) { return new Double2(); }
		if( "double.bytevalue()" == s ) { return new doubleByteValue(); }
		if( "double.compare(double,double)" == s ) { return new doubleCompare(); }
		if( "double.compareto(double)" == s ) { return new doubleCompareTo(); }
		if( "double.doubletolongbits(double)" == s ) { return new doubleDoubleToLongBits(); }
		if( "double.doubletorawlongbits(double)" == s ) { return new doubleDoubleToRawLongBits(); }
		if( "double.doublevalue()" == s ) { return new doubleDoubleValue(); }
		if( "double.equals(object)" == s ) { return new doubleEquals(); }
		if( "double.floatvalue()" == s ) { return new doubleFloatValue(); }
		if( "double.hashcode()" == s ) { return new doubleHashCode(); }
		if( "double.intvalue()" == s ) { return new doubleIntValue(); }
		if( "double.isinfinite()" == s ) { return new doubleIsInfinite(); }
		if( "double.isinfinite(double)" == s ) { return new doubleIsInfinite2(); }
		if( "double.isnan()" == s ) { return new doubleIsNaN(); }
		if( "double.isnan(double)" == s ) { return new doubleIsNaN2(); }
		if( "double.longbitstodouble(long)" == s ) { return new doubleLongBitsToDouble(); }
		if( "double.longvalue()" == s ) { return new doubleLongValue(); }
		if( "double.parsedouble(string)" == s ) { return new doubleParseDouble(); }
		if( "double.shortvalue()" == s ) { return new doubleShortValue(); }
		if( "double.tohexstring(double)" == s ) { return new doubleToHexString(); }
		if( "double.tostring()" == s ) { return new doubleToString(); }
		if( "double.tostring(double)" == s ) { return new doubleToString2(); }
		if( "double.valueof(double)" == s ) { return new doubleValueOf(); }
		if( "double.valueof(string)" == s ) { return new doubleValueOf2(); }
		if( "integer(int)" == s ) { return new Integer1(); }
		if( "integer(string)" == s ) { return new Integer2(); }
		if( "integer.bitcount(int)" == s ) { return new intBitCount(); }
		if( "integer.bytevalue()" == s ) {  return new intByteValue(); }
		if( "integer.compare(int,int)" == s ) { return new intCompare(); }
		if( "integer.compareto(integer)" == s ) { return new intCompareTo(); }
		if( "integer.decode(string)" == s ) { return new intDecode(); }
		if( "integer.doublevalue()" == s ) { return new intDoubleValue(); }
		if( "integer.equals(object)" == s ) { return new intEquals(); }
		if( "integer.floatvalue()" == s ) { return new intFloatValue(); }
		if( "integer.getinteger(string)" == s ) { return new intGetInteger(); }
		if( "integer.getinteger(string,int)" == s ) { return new intGetInteger2(); }
		if( "integer.getinteger(string,integer)" == s ) { return new intGetInteger3(); }
		if( "integer.hashcode()" == s ) { return new intHashCode(); }
		if( "integer.highestonebit(int)" == s ) { return new intHighestOneBit(); }
		if( "integer.longvalue()" == s ) { return new intLongValue(); }
		if( "integer.intvalue()" == s ) { return new intIntValue(); }
		if( "integer.lowestonebit(int)" == s ) { return new intLowestOneBit();  }
		if( "integer.numberofleadingzeros(int)" == s ) { return new intNumberOfLeadingZeros(); }
		if( "integer.numberoftrailingzeros(int)" == s ) { return new intNumberOfTrailingZeros(); }
		if( "integer.parseint(string)" == s ) { return new intParseInt(); }
		if( "integer.parseint(string,int)" == s ) { return new intParseInt(); }
		if( "integer.reverse(int)" == s ) { return new intReverse(); }
		if( "integer.reversebytes(int)" == s ) { return new intReverseBytes(); }
		if( "integer.rotateleft(int,int)" == s ) { return new intRotateLeft(); }
		if( "integer.rotateright(int,int)" == s ) { return new intRotateRight(); }
		if( "integer.shortvalue()" == s ) { return new intShortValue(); }
		if( "integer.signum(int)" == s ) { return new intSigNum(); }
		if( "integer.tobinarystring(int)" == s ) { return new intToBinaryString(); }
		if( "integer.tohexstring(int)" == s ) { return new intToHexString(); }
		if( "integer.tooctalstring(int)" == s ) { return new intToOctalString(); }
		if( "integer.tostring()" == s ) { return new intToString(); }
		if( "integer.tostring(int)" == s ) { return new intToString2(); }
		if( "integer.tostring(int,int)" == s ) { return new intToString3(); }
		if( "integer.valueof(int)" == s ) { return new intValueOf(); }
		if( "integer.valueof(string)" == s ) { return new intValueOf2(); }
		if( "integer.valueof(string,int)" == s ) { return new intValueOf3(); }
		if( "math.abs(static double)" == s ) { return new mathAbs(); }
		if( "math.abs(static float)" == s ) { return new mathAbs2(); }
		if( "math.abs(static int)" == s ) { return new mathAbs3(); }
		if( "math.abs(static long)" == s ) { return new mathAbs4(); }
		if( "math.acos(long)" == s ) { return new mathAcos(); }
		if( "math.asin(double)" == s ) { return new mathAsin(); }
		if( "math.atan(double)" == s ) { return new mathAtan(); }
		if( "math.atan(double,double)" == s ) { return new mathAtan2(); }
		if( "math.cbrt(double)" == s ) { return new mathCbrt(); }
		if( "math.ceil(double)" == s ) { return new mathCeil(); }
		if( "math.copysign(double,double)" == s ) { return new mathCopySign(); }
		if( "math.copysign(float,float)" == s ) { return new mathCopySign2(); }
		if( "math.cos(double)" == s ) { return new mathCos(); }
		if( "math.cosh(double)" == s ) { return new mathCosh(); }
		if( "math.exp(double)" == s ) { return new mathExp(); }
		if( "math.expm1(double)" == s ) { return new mathExpm1(); }
		if( "math.floor(double)" == s ) { return new mathFloor(); }
		if( "math.getexponent(double)" == s ) { return new mathGetExponent(); }
		if( "math.getexponent(float)" == s ) { return new mathGetExponent2(); }
		if( "math.hypot(double,double)" == s ) { return new mathHypot(); }
		if( "math.ieeeremainder(double,double)" == s ) { return new mathIEEEremainder(); }
		if( "math.log(double)" == s ) { return new mathLog(); }
		if( "math.log10(double)" == s ) { return new mathLog10(); }
		if( "math.log1p(double)" == s ) { return new mathLog1p(); }
		if( "math.max(double,double)" == s ) { return new mathMax(); }
		if( "math.max(float,float)" == s ) { return new mathMax2(); }
		if( "math.max(int,int)" == s ) { return new mathMax3(); }
		if( "math.max(long,long)" == s ) { return new mathMax4(); }
		if( "math.min(double,double)" == s ) { return new mathMin(); }
		if( "math.min(float,float)" == s ) { return new mathMin2(); }
		if( "math.min(int,int)" == s ) { return new mathMin3(); }
		if( "math.min(long,long)" == s ) { return new mathMin4(); }
		if( "math.nextafter(double,double)" == s ) { return new mathNextAfter(); }
		if( "math.nextafter(float,double)" == s ) { return new mathNextAfter2(); }
		if( "math.nextup(double)" == s ) { return new mathNextUp(); }
		if( "math.nextup(float)" == s ) { return new mathNextUp2(); }
		if( "math.pow(double,double)" == s ) { return new mathPow(); }
		if( "math.random()" == s ) { return new mathRandom(); }
		if( "math.rint(double)" == s ) { return new mathRint(); }
		if( "math.round(double)" == s ) { return new mathRound(); }
		if( "math.round(float)" == s ) { return new mathRound2(); }
		if( "math.scalb(double,int)" == s ) { return new mathscalb(); }
		if( "math.scalb(float,int)" == s ) { return new mathScalb2(); }
		if( "math.signum(double)" == s ) { return new mathSignum(); }
		if( "math.signum(float)" == s ) { return new mathSignum2(); }
		if( "math.sin(double)" == s ) { return new mathSin(); }
		if( "math.sinh(double)" == s ) { return new mathSinh(); }
		if( "math.sqrt(double)" == s ) { return new mathSqrt(); }
		if( "math.tan(double)" == s ) { return new mathTan(); }
		if( "math.tanh(double)" == s ) { return new mathTanh(); }
		if( "math.todegrees(double)" == s ) { return new mathToDegrees(); }
		if( "math.toradians(double)" == s ) { return new mathToRadians(); }
		if( "math.ulp(double)" == s ) { return new mathUlp(); }
		if( "math.ulp(float)" == s ) { return new mathUlp2(); }
		if( "number()" == s ) { return new Number1(); }
		if( "number.bytevalue()" == s ) { return new numByteValue(); }
		if( "number.doublevalue()" == s ) { return new numDoubleValue(); }
		if( "number.floatvalue()" == s ) { return new numFloatValue(); }
		if( "number.intvalue()" == s ) { return new numIntValue(); }
		if( "number.shortvalue()" == s ) { return new numShortValue(); }
		if( "string()" == s ) { return new String1(); }
		if( "string(byte[])" == s ) { return new String2(); }
		if( "string(byte[],charset)" == s ) { return new String3(); }
		if( "string(byte[],int)" == s ) { return new String4(); }
		if( "string(byte[],int,int,charset)" == s ) { return new String5(); }
		if( "string(byte[],int,int,int)" == s ) { return new String6(); }
		if( "string(byte[],int,int,string)" == s ) { return new String7(); }
		if( "string(byte[],string)" == s ) { return new String8(); }
		if( "string(char[])" == s ) { return new String9(); }
		if( "string(char[],int,int)" == s ) { return new String10(); }
		if( "string(int[],int,int)" == s ) { return new String11(); }
		if( "string(byte[],int,int)" == s ) { return new String12(); }
		if( "string(string)" == s ) { return new String13(); }
		if( "string(stringbuffer)" == s ) { return new String14(); }
		if( "string(stringbuilder)" == s ) { return new String15(); }
		if( "string.charat(int)" == s ) {  return new strCharAt(); }
		if( "string.codepointat(int)" == s ) { return new strCodePointAt(); }
		if( "string.codepointbefore(int)" == s ) { return new strCodePointBefore(); }
		if( "string.codepointcount(int,int)" == s ) { return new strCodePointCount(); }
		if( "string.compareto(string)" == s ) { return new strCompareTo(); }
		if( "string.contentequals(charsequence)" == s ) { return new strContentEquals(); }
		if( "string.contentequals(stringbuffer)" == s ) { return new strContentEquals2(); }
		if( "string.equalisignorecase(string)" == s ) { return new strEqualsIgnoreCase(); }
		if( "string.equals(object)" == s ) { return new strEquals(); }
		if( "string.getbytes()" == s ) { return new strGetBytes(); }
		if( "string.getbytes(charset)" == s ) { return new strGetBytes2(); }
		if( "string.getbytes(string)" == s ) { return new strGetBytes3(); }
		if( "string.getchars(int,int,char[],int)" == s ) { return new strGetChars(); }
		if( "string.isempty()" == s ) { return new strIsEmpty(); }
		if( "string.offsetbycodepoints(int,int)" == s ) { return new strOffsetByCodePoints(); }
		if( "string.comparetoignorecase(string)" == s ) { return new strCompareToIgnoreCase(); }
		if( "string.concat(string)" == s ) { return new strConcat(); }
		if( "string.contains(charsequence)" == s ) { return new strContains(); }
		if( "string.copyvalueof(char[])" == s ) { return new strCopyValueOf(); }
		if( "string.copyvalueof(char[],int,int)" == s ) { return new strCopyValueOf(); }
		if( "string.endswith(string)" == s ) { return new strEndsWith(); }
		if( "string.format(locale,string,object...)" == s ) { return new strFormat(); }
		if( "string.format(string,object...)" == s ) { return new strFormat2(); }
		if( "string.hashcode()" == s ) { return new strHashCode(); }
		if( "string.indexof(int)" == s ) { return new strIndexOf(); }
		if( "string.indexof(int,int)" == s ) { return new strIndexOf2(); }
		if( "string.indexof(string)" == s ) { return new strIndexOf3(); }
		if( "string.indexof(string,int)" == s ) { return new strIndexOf4(); }
		if( "string.intern()" == s ) { return new strIntern(); }
		if( "string.lastindexof(int)" == s ) { return new strLastIndexOf(); }
		if( "string.lastindexof(int,int)" == s ) { return new strLastIndexOf2(); }
		if( "string.lastindexof(string)" == s ) { return new strLastIndexOf3(); }
		if( "string.lastindexof(string,int)" == s ) { return new strLastIndexOf4(); }
		if( "string.length()" == s ) { return new strLength(); }
		if( "string.matches(string)" == s ) { return new strMatches(); }
		if( "string.regionmatches(boolean,int,int,string,int)" == s ) { return new strRegionMatches(); }
		if( "string.regionmatches(int,string,int,int)" == s ) { return new strRegionMatches2(); }
		if( "string.replace(char,char)" == s ) { return new strReplace(); }
		if( "string.replace(charsequence,charsequence)" == s ) { return new strReplace2(); }
		if( "string.replaceall(string,string)" == s ) { return new strReplaceAll(); }
		if( "string.replacefirst(string,string)" == s ) { return new strReplaceFirst(); }
		if( "string.split(string)" == s ) { return new strSplit(); }
		if( "string.split(string,int)" == s ) { return new strSplit2(); }
		if( "string.startswith(string)" == s ) { return new strStartsWith(); }
		if( "string.startswith(string,int)" == s ) { return new strStartsWith2(); }
		if( "string.subsequence(int,int)" == s ) { return new strSubSequence(); }
		if( "string.substring(int)" == s ) { return new strSubstring(); }
		if( "string.substring(int,int)" == s ) { return new strSubstring2(); }
		if( "string.tochararray()" == s ) { return new strToCharArray(); }
		if( "string.tolowercase()" == s ) { return new strToLowerCase(); }
		if( "string.tolowercase(locale)" == s ) { return new strToLowerCase2(); }
		if( "string.tostring()" == s ) { return new strToString(); }
		if( "string.touppercase()" == s ) { return new strToUpperCase(); }
		if( "string.touppercase(locale)" == s ) { return new strToUpperCase2(); }
		if( "string.trim()" == s ) { return new strTrim(); }
		if( "string.valueof(boolean)" == s ) { return new strValueOf(); }
		if( "string.valueof(char)" == s ) { return new strValueOf2(); }
		if( "string.valueof(char[])" == s ) { return new strValueOf3(); }
		if( "string.valueof(char[],int,int)" == s ) { return new strValueOf4(); }
		if( "string.valueof(double)" == s ) { return new strValueOf5(); }
		if( "string.valueof(float)" == s ) { return new strValueOf6(); }
		if( "string.valueof(int)" == s ) { return new strValueOf7(); }
		if( "string.valueof(long)" == s ) { return new strValueOf8(); }
		if( "string.valueof(object)" == s ) { return new strValueOf9(); }
		if( "vector()" == s ) { return new Vector1(); }
		if( "vector(collection<? extends e>)" == s ) { return new Vector2(); }
		if( "vector(int)" == s ) { return new Vector3(); }
		if( "vector(int,int)" == s ) { return new Vector4(); }
		if( "vector.add(e)" == s ) { return new vecAdd(); }
		if( "vector.add(int,e)" == s ) { return new vecAdd2(); }
		if( "vector.addall(collection<? extends e>)" == s ) { return new vecAddAll(); }
		if( "vector.addall(int, collection<? extends e>)" == s ) { return new vecAddAll2(); }
		if( "vector.addelement(e)" == s ) { return new vecAddElement(); }
		if( "vector.capacity()" == s ) { return new vecCapacity(); }
		if( "vector.clear()" == s ) { return new vecClear(); }
		if( "vector.clone()" == s ) { return new vecClone(); }
		if( "vector.contains(object)" == s ) { return new vecContains(); }
		if( "vector.containsall(collection<?>)" == s ) { return new veccontainsAll(); }
		if( "vector.copyinto(object[])" == s ) { return new vecCopyInto(); }
		if( "vector.elementat(int)" == s ) { return new vecElementAt(); }
		if( "vector.elements()" == s ) { return new vecElements(); }
		if( "vector.ensurecapacity(int)" == s ) { return new vecEnsureCapacity(); }
		if( "vector.equals(object)" == s ) { return new vecequals(); }
		if( "vector.firstelement()" == s ) { return new vecFirstElement(); }
		if( "vector.get(int)" == s ) { return new vecGet(); }
		if( "vector.hashcode()" == s ) { return new vechashCode(); }
		if( "vector.indexof(object)" == s ) { return new vecIndexOf(); }
		if( "vector.indexof(object,int)" == s ) { return new vecIndexOf2(); }
		if( "vector.insertelementat(e,int)" == s ) { return new vecInsertElementAt(); }
		if( "vector.isempty()" == s ) { return new vecisEmpty(); }
		if( "vector.lastelement()" == s ) { return new vecLastElement(); }
		if( "vector.lastindexof(object)" == s ) { return new vecLastIndexOf(); }
		if( "vector.lastindexof(object,int)" == s ) { return new vecLastIndexOf2(); }
		if( "vector.remove(int)" == s ) { return new vecRemove(); }
		if( "vector.remove(object)" == s ) { return new vecRemove2(); }
		if( "vector.removeall(collection<?>)" == s ) { return new vecRemoveAll(); }
		if( "vector.removeallelements()" == s ) { return new vecRemoveAllElements(); }
		if( "vector.removeelement(object)" == s ) { return new vecRemoveElement(); }
		if( "vector.removeelementat(int)" == s ) { return new vecRemoveElementAt(); }
		if( "vector.removerange(int,int)" == s ) { return new vecRemoveRange(); }
		if( "vector.retainall(collection<?>)" == s ) { return new vecRetainAll(); }
		if( "vector.set(int,e)" == s ) { return new vecSet(); }
		if( "vector.setelementat(e,int)" == s ) { return new vecSetElementAt(); }
		if( "vector.setsize(int)" == s ) { return new vecSetSize(); }
		if( "vector.size()" == s ) { return new vecSize(); }
		if( "vector.sublist(int,int)" == s ) { return new vecSubList(); }
		if( "vector.toarray()" == s ) { return new vecToArray(); }
		if( "vector.toarray(t[])" == s ) { return new vecToArray2(); }
		if( "vector.tostring()" == s ) { return new vecToString(); }
		if( "vector.trimtosize()" == s ) { return new vecTrimToSize(); } 
		if( "abstract" == s ) { return new Abstract(); }
		if( "abstract class" == s ) { return new AbstractClass(); }
		if( "abstract method" == s ) { return new AbstractMethod(); }
		return null;
	}
	
	
	private static String[] classes = {"abstractcollection", "abstractlist", "arraylist", "byte", "double", "integer", "math", "number", "string", "vector", };
	private static String[] abstractcollectionMethods = {"abstractcollection.add(e)", "abstractcollection.addall(collection<? extends e>)", "abstractcollection.clear()", "abstractcollection.containsall(collection<?>)", "abstractcollection.isempty()", "abstractcollection.iterator()", "abstractcollection.remove(object)", "abstractcollection.removeall(collection<?>)", "abstractcollection.retainall(collection<?>)", "abstractcollection.size()", "abstractcollection.toarray()", "abstractcollection.toarray(t[])", "abstractcollection.tostring()", };
	private static String[] arraylistMethods = {"arraylist()", "arraylist(collection<?>)", "arraylist(int)", "arraylist.add(e)", "arraylist.add(int,e)", "arraylist.addall(collection<? extends e>)", "arraylist.addall(int,collection<? extends e>)", "arraylist.clear()", "arraylist.clone()", "arraylist.contains(object)", "arraylist.ensurecapacity(int)", "arraylist.get(int)", "arraylist.indexof(object)", "arraylist.isempty()", "arraylist.lastindexof(object)", "arraylist.remove(int)", "arraylist.remove(object)", "arraylist.removerange(int,int)", "arraylist.set(int,e)", "arraylist.size()", "arraylist.toarray()", "arraylist.toarray(t[])", "arraylist.trimtosize()", };
	private static String[] byteMethods = {"byte(byte)", "byte(string)", "byte.bytevalue()", "byte.compareto(byte)", "byte.decode()", "byte.doublevalue()", "byte.equals(object)", "byte.floatvalue()", "byte.hashcode()", "byte.intvalue()", "byte.longvalue()", "byte.parsebyte(string)", "byte.parsebyte(string,int)", "byte.shortvalue()", "byte.tostring()", "byte.tostring(byte)", "byte.valueof(byte)", "byte.valueof(string)", "byte.valueof(string,int)", };
	private static String[] doubleMethods = {"double(double)", "double(string)", "double.bytevalue()", "double.compare(double,double)", "double.compareto(double)", "double.doubletolongbits(double)", "double.doubletorawlongbits(double)", "double.doublevalue()", "double.equals(object)", "double.floatvalue()", "double.hashcode()", "double.intvalue()", "double.isinfinite()", "double.isinfinite(double)", "double.isnan()", "double.isnan(double)", "double.longbitstodouble(long)", "double.longvalue()", "double.parsedouble(string)", "double.shortvalue()", "double.tohexstring(double)", "double.tostring()", "double.tostring(double)", "double.valueof(double)", "double.valueof(string)", };
	private static String[] integerMethods = {"integer()", "integer(int)", "integer(string)", "integer.bitcount(int)", "integer.bytevalue()", "integer.compare(int,int)", "integer.compareto(integer)", "integer.decode(string)", "integer.doublevalue()", "integer.equals(object)", "integer.floatvalue()", "integer.getinteger(string)", "integer.getinteger(string,int)", "integer.getinteger(string,integer)", "integer.hashcode()", "integer.highestonebit(int)", "integer.longvalue()", "integer.intvalue()", "integer.lowestonebit(int)", "integer.numberofleadingzeros(int)", "integer.numberoftrailingzeros(int)", "integer.parseint(string)", "integer.parseint(string,int)", "integer.reverse(int)", "integer.reversebytes(int)", "integer.rotateleft(int,int)", "integer.rotateright(int,int)", "integer.shortvalue()", "integer.signum(int)", "integer.tobinarystring(int)", "integer.tohexstring(int)", "integer.tooctalstring(int)", "integer.tostring()", "integer.tostring(int)", "integer.tostring(int,int)", "integer.valueof(int)", "integer.valueof(string)", "integer.valueof(string,int)", };
	private static String[] mathMethods = {"math.abs(static double)", "math.abs(static float)", "math.abs(static int)", "math.abs(static long)", "math.acos(long)", "math.asin(double)", "math.atan(double)", "math.atan(double,double)", "math.cbrt(double)", "math.ceil(double)", "math.copysign(double,double)", "math.copysign(float,float)", "math.cos(double)", "math.cosh(double)", "math.exp(double)", "math.expm1(double)", "math.floor(double)", "math.getexponent(double)", "math.getexponent(float)", "math.hypot(double,double)", "math.IEEEremainder(double,double)", "math.log(double)", "math.log10(double)", "math.log1p(double)", "math.max(double,double)", "math.max(float,float)", "math.max(int,int)", "math.max(long,long)", "math.min(double,double)", "math.min(float,float)", "math.min(int,int)", "math.min(long,long)", "math.nextafter(double,double)", "math.nextafter(float,double)", "math.nextup(double)", "math.nextup(float)", "math.pow(double,double)", "math.random()", "math.rint(double)", "math.round(double)", "math.round(float)", "math.scalb(double,int)", "math.scalb(float,int)", "math.signum(double)", "math.signum(float)", "math.sin(double)", "math.sinh(double)", "math.sqrt(double)", "math.tan(double)", "math.tanh(double)", "math.todegrees(double)", "math.toradians(double)", "math.ulp(double)", "math.ulp(float)", };
	private static String[] numberMethods = {"number()", "number.bytevalue()", "number.doublevalue()", "number.floatvalue()", "number.intvalue()", "number.shortvalue()",  };
	private static String[] stringMethods = {"string()", "string(byte[])", "string(byte[],charset)", "string(byte[],int)", "string(byte[],int,int,charset)", "string(byte[],int,int,int)", "string(byte[],int,int,string)", "string(byte[],string)", "string(char[])", "string(char[],int,int)", "string(int[],int,int)", "string(string)", "string(stringbuffer)", "string(stringbuilder)", "string.charat(int)", "string.codepointat(int)", "string.codepointbefore(int)", "string.codepointcount(int,int)", "string.compareto(string)", "string.contentequals(charsequence)", "string.contentequals(stringbuffer)", "string.equalisignorecase(string)", "string.equals(object)", "string.getbytes()", "string.getbytes(charset)", "string.getbytes(string)", "string.getchars(int,int,char[],int)", "string.isempty()", "string.offsetbycodepoints(int,int)", "string(byte[],int,int)", "string.comparetoignorecase(string)", "string.concat(string)", "string.contains(charsequence)", "string.copyvalueof(char[])", "string.copyvalueof(char[],int,int)", "string.endswith(string)", "string.format(locale,string,object...)", "string.format(string,object...)", "string.hashcode()", "string.indexof(int)", "string.indexof(int,int)", "string.indexof(string)", "string.indexof(string,int)", "string.intern()", "string.lastindexof(int)", "string.lastindexof(int,int)", "string.lastindexof(string)", "string.lastindexof(string,int)", "string.length()", "string.matches(string)", "string.regionmatches(boolean,int,int,string,int)", "string.regionmatches(int,string,int,int)", "string.replace(char,char)", "string.replace(charsequence,charsequence)", "string.replaceall(string,string)", "string.replacefirst(string,string)", "string.split(string)", "string.split(string,int)", "string.startswith(string)", "string.startswith(string,int)", "string.subsequence(int,int)", "string.substring(int)", "string.substring(int,int)", "string.tochararray()", "string.tolowercase()", "string.tolowercase(locale)", "string.tostring()", "string.touppercase()", "string.touppercase(locale)", "string.trim()", "string.valueof(boolean)", "string.valueof(char)", "string.valueof(char[])", "string.valueof(char[],int,int)", "string.valueof(double)", "string.valueof(float)", "string.valueof(int)", "string.valueof(long)", "string.valueof(object)", };
	private static String[] vectorMethods = {"vector()", "vector(collection<? extends e>)", "vector(int)", "vector(int,int)", "vector.add(e)", "vector.add(int,e)", "vector.addall(collection<? extends e>)", "vector.addall(int, collection<? extends e>)", "vector.addelement(e)", "vector.capacity()", "vector.clear()", "vector.clone()", "vector.contains(object)", "vector.containsall(collection<?>)", "vector.copyinto(object[])", "vector.elementat(int)", "vector.elements()", "vector.ensurecapacity(int)", "vector.equals(object)", "vector.firstelement()", "vector.get(int)", "vector.hashcode()", "vector.indexof(object)", "vector.indexof(object,int)", "vector.insertelementat(e,int)", "vector.isempty()", "vector.lastelement()", "vector.lastindexof(object)", "vector.lastindexof(object,int)", "vector.remove(int)", "vector.remove(object)", "vector.removeall(collection<?>)", "vector.removeallelements()", "vector.removeelement(object)", "vector.removeelementat(int)", "vector.removerange(int,int)", "vector.retainall(collection<?>)", "vector.set(int,e)", "vector.setelementat(e,int)", "vector.setsize(int)", "vector.size()", "vector.sublist(int,int)", "vector.toarray()", "vector.toarray(t[])", "vector.tostring()", "vector.trimtosize()", };
	private static String[] vocab = {"abstract", "abstract class", "abstract method", };
	
}

class myPair {
	int value;
	String s;
	myPair( int v, String ss ) {
		value = v;
		s = ss;
	}
	public int getVal() { return value; }
	public String getName() { return s; }
}


class qComp implements Comparator<myPair> {
	private String query;
	
	qComp( String q ) {
		query = q;
	}
	
	public int compare( myPair p1, myPair p2 ) {
		return p1.getVal() - p2.getVal();
	}
	
	public boolean equals( Object o ) {
		return ( this == o );
	}
}
