
class Vocab extends Searchable {
	public String getType() { return "Vocab"; }
	
	String[] getComparableNames() {
		String s1 = getName().toLowerCase();
		String s2 = "term " + getName().toLowerCase();
		String s3 = "glossary " + getName().toLowerCase();
		String[] array = { s1, s2, s3 };
		return array;
	}
}

class AWT extends Vocab {
	AWT() {
		setName( "Abstract Window Toolkit" );
		setDesc( "A collection of graphical user interface (GUI) components that were implemented using native-platform versions of the components. These components provide that subset of functionality which is common to all native platforms. Largely supplanted by the Project Swing component set." );
	}
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

class APL extends Vocab {
	APL() {
		setName( "actual parameter list" );
		setDesc( "The arguments specified in a particular method call." );
	}
}

class alphaValue extends Vocab {
	alphaValue() {
		setName( "alpha value" );
		setDesc( "A value that indicates the opacity of a pixel." );
	}
}

class API extends Vocab {
	API() {
		setName( "API" );
		setDesc( "Application Programming Interface. The specification of how a programmer writing an application accesses the behavior and state of classes and objects." );
	}
}

class appliances extends Vocab {
	appliances() {
		setName( "appliances" );
		setDesc( "Networked devices such as printers, Java(TM) technology-enabled terminals, and clients, that are managed using applications built using the Java Management API (JMAPI)." );
	}
}

class applet extends Vocab {
	applet() {
		setName( "applet" );
		setDesc( "A program written in the Java(TM) programming language to run within a web browser compatible with the Java platform, such as HotJava(TM) or Netscape Navigator(TM)." );
	}
}

class argument extends Vocab {
	argument() {
		setName( "argument" );
		setDesc( "A data item specified in a method call. An argument can be a literal value, a variable, or an expression." );
	}
}

class array extends Vocab {
	array() {
		setName( "array" );
		setDesc( "A collection of data items, all of the same type, in which each item's position is uniquely designated by an integer." );
	}
}

class ASCII extends Vocab {
	ASCII() {
		setName( "ASCII" );
		setDesc( "American Standard Code for Information Interchange. A standard assignment of 7-bit numeric codes to characters." );
	}
}

class atomic extends Vocab {
	atomic() {
		setName( "atomic" );
		setDesc( "Refers to an operation that is never interrupted or left in an incomplete state under any circumstance." );
	}
}

class Bean extends Vocab {
	Bean() {
		setName( "Bean" );
		setDesc( "A reusable software component. Beans can be combined to create an application." );
	}
}

class binaryOp extends Vocab {
	binaryOp() {
		setName( "binary operator" );
		setDesc( "An operator that has two arguments." );
	}
}

class bit extends Vocab {
	bit() {
		setName( "bit" );
		setDesc( "The smallest unit of information in a computer, with a value of either 0 or 1." );
	}
}

class bitwiseOp extends Vocab {
	bitwiseOp() {
		setName( "bitwise operator" );
		setDesc( "An operator that manipulates two values comparing each bit of one value to the corresponding bit of the other value." );
	}
}

class block extends Vocab {
	block() {
		setName( "block" );
		setDesc( "In the Java(TM) programming language, any code between matching braces. Example: { x = 1; }." );
	}
}

class boolean_ extends Vocab {
	boolean_() {
		setName( "boolean" );
		setDesc( "Refers to an expression or variable that can have only a true or false value. The Java(TM) programming language provides the boolean type and the literal values true and false." );
	}
}

class boundingBox extends Vocab {
	boundingBox() {
		setName( "bounding box" );
		setDesc( "For a Raster object, the smallest rectangle that completely encloses all the pixels that are not fully transparent." );
	}
}

class break_ extends Vocab {
	break_() {
		setName( "break" );
		setDesc( "A Java(TM) programming language keyword used to resume program execution at the statement immediately following the current statement. If followed by a label, the program resumes execution at the labeled statement." );
	}
}

class byte_ extends Vocab {
	byte_() {
		setName( "byte" );
		setDesc( "A sequence of eight bits. The Java(TM) programming language provides a corresponding byte type." );
	}
}

class byteCode extends Vocab {
	byteCode() {
		setName( "bytecode" );
		setDesc( "Machine-independent code generated by the Java(TM) compiler and executed by the Java interpreter." );
	}
}

class case_ extends Vocab {
	case_() {
		setName( "case" );
		setDesc( "A Java(TM) programming language keyword that defines a group of statements to begin executing if a value specified matches the value defined by a preceding \"switch\" keyword." );
	}
}

class casting extends Vocab {
	casting() {
		setName( "casting" );
		setDesc( "Explicit conversion from one data type to another." );
	}
}

class catch_ extends Vocab {
	catch_() {
		setName( "catch" );
		setDesc( "A Java(TM) programming language keyword used to declare a block of statements to be executed in the event that a Java exception, or run time error, occurs in a preceding \"try\" block." );
	}
}

class char_ extends Vocab {
	char_() {
		setName( "char" );
		setDesc( "A Java(TM) programming language keyword used to declare a variable of type character." );
	}
}

class class_ extends Vocab {
	class_() {
		setName( "class" );
		setDesc( "In the Java(TM) programming language, a type that defines the implementation of a particular kind of object. A class definition defines instance and class variables and methods, as well as specifying the interfaces the class implements and the immediate superclass of the class. If the superclass is not explicitly specified, the superclass will implicitly be Object." );
	}
}

class classMethod extends Vocab {
	classMethod() {
		setName( "class method" );
		setDesc( "A method that is invoked without reference to a particular object. Class methods affect the class as a whole, not a particular instance of the class. Also called a static method. See also instance method." );
	}
}

class classpath extends Vocab {
	classpath() {
		setName( "classpath" );
		setDesc( "A classpath is an environmental variable which tells the Java(TM) virtual machine* and Java technology-based applications (for example, the tools located in the JDK(TM) 1.1.X\bin directory) where to find the class libraries, including user-defined class libraries." );
	}
}

class classVariable extends Vocab {
	classVariable() {
		setName( "class variable" );
		setDesc( "A data item associated with a particular class as a whole--not with particular instances of the class. Class variables are defined in class definitions. Also called a static field. See also instance variable." );
	}
}

class client extends Vocab {
	client() {
		setName( "client" );
		setDesc( "In the client/server model of communcations, the client is a process that remotely accesses resources of a compute server, such as compute power and large memory capacity." );
	}
}

class codebase extends Vocab {
	codebase() {
		setName( "codebase" );
		setDesc( "Works together with the code attribute in the <APPLET> tag to give a complete specification of where to find the main applet class file: code specifies the name of the file, and codebase specifies the URL of the directory containing the file." );
	}
}

class comment extends Vocab {
	comment() {
		setName( "comment" );
		setDesc( "In a program, explanatory text that is ignored by the compiler. In programs written in the Java(TM) programming language, comments are delimited using // or /*...*/." );
	}
}

class compUnit extends Vocab {
	compUnit() {
		setName( "compilation unit" );
		setDesc( "The smallest unit of source code that can be compiled. In the current implementation of the Java(TM) platform, the compilation unit is a file." );
	}
}

class compiler extends Vocab {
	compiler() {
		setName( "compiler" );
		setDesc( "A program to translate source code into code to be executed by a computer. The Java(TM) compiler translates source code written in the Java programming language into bytecode for the Java virtual machine*." );
	}
}

class compositing extends Vocab {
	compositing() {
		setName( "compositing" );
		setDesc( "The process of superimposing one image on another to create a single image." );
	}
}

class constructor_ extends Vocab {
	constructor_() {
		setName( "constructor" );
		setDesc( "A pseudo-method that creates an object. In the Java(TM) programming language, constructors are instance methods with the same name as their class. Constructors are invoked using the new keyword." );
	}
}

class const_ extends Vocab {
	const_() {
		setName( "const" );
		setDesc( "This is a reserved Java(TM) programming language keyword. However, it is not used by current versions of the Java programming language." );
	}
}

class continue_ extends Vocab {
	continue_() {
		setName( "continue" );
		setDesc( "A Java(TM) programming language keyword used to resume program execution at the end of the current loop. If followed by a label, \"continue\" resumes execution where the label occurs." );
	}
}

class coreClass extends Vocab {
	coreClass() {
		setName( "core class" );
		setDesc( "A public class (or interface) that is a standard member of the Java(TM) Platform. The intent is that the core classes for the Java platform, at minimum, are available on all operating systems where the Java platform runs. A program written entirely in the Java programming language relies only on core classes, meaning it can run anywhere." );
	}
}

class corePackage extends Vocab {
	corePackage() {
		setName( "Core Packages" );
		setDesc( "The required set of APIs in a Java platform edition which must be supported in any and all compatible implementations." );
	}
}

class criticalSect extends Vocab {
	criticalSect() {
		setName( "critical section" );
		setDesc( "A segment of code in which a thread uses resources (such as certain instance variables) that can be used by other threads, but that must not be used by them at the same time." );
	}
}

class declaration extends Vocab {
	declaration() {
		setName( "declaration" );
		setDesc( "A statement that establishes an identifier and associates attributes with it, without necessarily reserving its storage (for data) or providing the implementation (for methods)." );
	}
}

class default_ extends Vocab {
	default_() {
		setName( "default" );
		setDesc( "A Java(TM) programming language keyword optionally used after all \"case\" conditions in a \"switch\" statement. If all \"case\" conditions are not matched by the value of the \"switch\" variable, the \"default\" keyword will be executed." );
	}
}

class definition extends Vocab {
	definition() {
		setName( "definition" );
		setDesc( "A declaration that reserves storage (for data) or provides implementation (for methods)." );
	}
}

class deprecation extends Vocab {
	deprecation() {
		setName( "deprecation" );
		setDesc( "Refers to a class, interface, constructor, method or field that is no longer recommended, and may cease to exist in a future version." );
	}
}

class derivedFrom extends Vocab {
	derivedFrom() {
		setName( "derived from" );
		setDesc( "Class X is \"derived from\" class Y if class X extends class Y." );
	}
}

class distributed extends Vocab {
	distributed() {
		setName( "distributed" );
		setDesc( "Running in more than one address space." );
	}
}

class do_ extends Vocab {
	do_() {
		setName( "do" );
		setDesc( "A Java(TM) programming language keyword used to declare a loop that will iterate a block of statements. The loop`s exit condition can be specified with the \"while\" keyword." );
	}
}

class double_ extends Vocab {
	double_() {
		setName( "double" );
		setDesc( "A Java(TM) programming language keyword used to define a variable of type double." );
	}
}

class doublePrecision extends Vocab {
	doublePrecision() {
		setName( "double precision" );
		setDesc( "In the Java(TM) programming language specification, describes a floating point number that holds 64 bits of data." );
	}
}

class else_ extends Vocab {
	else_() {
		setName( "else" );
		setDesc( "A Java(TM) programming language keyword used to execute a block of statements in the case that the test condition with the \"if\" keyword evaluates to false." );
	}
}

class EJT extends Vocab {
	EJT() {
		setName( "EmbeddedJava(TM) Technology" );
		setDesc( "The availability of Sun's Java 2 Platform, Micro Edition technology under a restrictive license agreement that allows a licensee to leverage certain Java technologies to create and deploy a closed-box application that exposes no APIs." );
	}
}

class encapsulation extends Vocab {
	encapsulation() {
		setName( "encapsulation" );
		setDesc( "The localization of knowledge within a module. Because objects encapsulate data and implementation, the user of an object can view the object as a black box that provides services. Instance variables and methods can be added, deleted, or changed, but as long as the services provided by the object remain the same, code that uses the object can continue to use it without being rewritten." );
	}
}

class exception extends Vocab {
	exception() {
		setName( "exception" );
		setDesc( "An event during program execution that prevents the program from continuing normally; generally, an error. The Java(TM) programming language supports exceptions with the try, catch, and throw keywords." );
	}
}

class exceptionHandler extends Vocab {
	exceptionHandler() {
		setName( "exception handler" );
		setDesc( "A block of code that reacts to a specific type of exception. If the exception is for an error that the program can recover from, the program can resume executing after the exception handler has executed." );
	}
}

class executableContent extends Vocab {
	executableContent() {
		setName( "executable content" );
		setDesc( "An application that runs from within an HTML file." );
	}
}

class extends_ extends Vocab {
	extends_() {
		setName( "extends" );
		setDesc( "Class X extends class Y to add functionality, either by adding fields or methods to class Y, or by overriding methods of class Y. An interface extends another interface by adding methods. Class X is said to be a subclass of class Y." );
	}
}

class FCS extends Vocab {
	FCS() {
		setName( "FCS" );
		setDesc( "First Customer Ship. The day in which a product is released/shipped to the customer." );
	}
}

class field extends Vocab {
	field() {
		setName( "field" );
		setDesc( "A data member of a class. Unless specified otherwise, a field is not static." );
	}
}

class final_ extends Vocab {
	final_() {
		setName( "final" );
		setDesc( "A Java(TM) programming language keyword. You define an entity once and cannot change it or derive from it later. More specifically: a final class cannot be subclassed, a final method cannot be overridden and a final variable cannot change from its initialized value." );
	}
}

class finally_ extends Vocab {
	finally_() {
		setName( "finally" );
		setDesc( "A Java(TM) programming language keyword that executes a block of statements regardless of whether a Java Exception, or run time error, occurred in a block defined previously by the \"try\" keyword." );
	}
}

class float_ extends Vocab {
	float_() {
		setName( "float" );
		setDesc( "A Java(TM) programming language keyword used to define a floating point number variable." );
	}
}

class for_ extends Vocab {
	for_() {
		setName( "for" );
		setDesc( "A Java(TM) programming language keyword used to declare a loop that reiterates statements. The programmer can specify the statements to be executed, exit conditions, and initialization variables for the loop." );
	}
}

class FTP extends Vocab {
	FTP() {
		setName( "FTP" );
		setDesc( "The basic Internet File Transfer Protocol. FTP, which is based on TCP/IP, enables the fetching and storing of files between hosts on the Internet." );
	}
}

class FPL extends Vocab {
	FPL() {
		setName( "formal parameter list" );
		setDesc( "The parameters specified in the definition of a particular method." );
	}
}

class gcollection extends Vocab {
	gcollection() {
		setName( "garbage collection" );
		setDesc( "The automatic detection and freeing of memory that is no longer in use. The Java(TM) runtime system performs garbage collection so that programmers never explicitly free objects." );
	}
}

class goto_ extends Vocab {
	goto_() {
		setName( "goto" );
		setDesc( "This is a reserved Java(TM) programming language keyword. However, it is not used by current versions of the Java programming language." );
	}
}

class GUI extends Vocab {
	GUI() {
		setName( "GUI" );
		setDesc( "Graphical User Interface. Refers to the techniques involved in using graphics, along with a keyboard and a mouse, to provide an easy-to-use interface to some program." );
	}
}

class hexa extends Vocab {
	hexa() {
		setName( "hexadecimal" );
		setDesc( "The numbering system that uses 16 as its base. The marks 0-9 and a-f (or equivalently A-F) represent the digits 0 through 15. In programs written in the Java(TM) programming language, hexadecimal numbers must be preceded with 0x." );
	}
}

class hier extends Vocab {
	hier() {
		setName( "hierarchy" );
		setDesc( "A classification of relationships in which each item except the top one (known as the root) is a specialized form of the item above it. Each item can have one or more items below it in the hierarchy. In the Java(TM) class hierarchy, the root is the Object class." );
	}
}

class HJB extends Vocab {
	HJB() {
		setName( "HotJava(TM) Browser" );
		setDesc( "An easily customizable Web browser developed by Sun Microsystems, which is written in the Java(TM) programming language." );
	}
}

class HTML extends Vocab {
	HTML() {
		setName( "HTML" );
		setDesc( "HyperText Markup Language. This is a file format, based on SGML, for hypertext documents on the Internet. It is very simple and allows for the embedding of images, sounds, video streams, form fields and simple text formatting. References to other objects are embedded using URLs." );
	}
}

class HTTP extends Vocab {
	HTTP() {
		setName( "HTTP" );
		setDesc( "HyperText Transfer Protocol. The Internet protocol, based on TCP/IP, used to fetch hypertext objects from remote hosts." );
	}
}

class IDL extends Vocab {
	IDL() {
		setName( "IDL" );
		setDesc( "Interface Definition Language. APIs written in the Java(TM) programming language that provide standards-based interoperability and connectivity with CORBA (Common Object Request Broker Architecture)." );
	}
}

class identifier extends Vocab {
	identifier() {
		setName( "identifier" );
		setDesc( "The name of an item in a program written in the Java(TM) programming language." );
	}
}

class if_ extends Vocab {
	if_() {
		setName( "if" );
		setDesc( "A Java(TM) programming language keyword used to conduct a conditional test and execute a block of statements if the test evaluates to true." );
	}
}

class implements_ extends Vocab {
	implements_() {
		setName( "implements" );
		setDesc( "A Java(TM) programming language keyword optionally included in the class declaration to specify any interfaces that are implemented by the current class." );
	}
}

class imp extends Vocab {
	imp() {
		setName( "import" );
		setDesc( "A Java(TM) programming language keyword used at the beginning of a source file that can specify classes or entire packages to be referred to later without including their package names in the reference." );
	}
}

class inher extends Vocab {
	inher() {
		setName( "inheritance" );
		setDesc( "The concept of classes automatically containing the variables and methods defined in their supertypes." );
	}
}

class inst extends Vocab {
	inst() {
		setName( "instance" );
		setDesc( "An object of a particular class. In programs written in the Java(TM) programming language, an instance of a class is created using the new operator followed by the class name." );
	}
}

class instMeth extends Vocab {
	instMeth() {
		setName( "instance method" );
		setDesc( "Any method that is invoked with respect to an instance of a class. Also called simply a method." );
	}
}

class instVar extends Vocab {
	instVar() {
		setName( "instance variable" );
		setDesc( "Any item of data that is associated with a particular object. Each instance of a class has its own copy of the instance variables defined in the class. Also called a field." );
	}
}

class instOf extends Vocab {
	instOf() {
		setName( "instance of" );
		setDesc( "A two-argument Java(TM) programming language keyword that tests whether the run-time type of its first argument is assignment compatible with its second argument." );
	}
}

class int_ extends Vocab {
	int_() {
		setName( "int" );
		setDesc( "A Java(TM) programming language keyword used to define a variable of type integer." );
	}
}

class interF extends Vocab {
	interF() {
		setName( "interface" );
		setDesc( "A Java(TM) programming language keyword used to define a collection of method definitions and constant values. It can later be implemented by classes that define this interface with the \"implements\" keyword." );
	}
}

class interN extends Vocab {
	interN() {
		setName( "internet" );
		setDesc( "An enormous network consisting of literally millions of hosts from many organizations and countries around the world. It is physically put together from many smaller networks and data travels by a common set of protocols." );
	}
}

class IP extends Vocab {
	IP() {
		setName( "IP" );
		setDesc( "Internet Protocol. The basic protocol of the Internet. It enables the unreliable delivery of individual packets from one host to another. It makes no guarantees about whether or not the packet will be delivered, how long it will take, or if multiple packets will arrive in the order they were sent. Protocols built on top of this add the notions of connection and reliability." );
	}
}

class interP extends Vocab {
	interP() {
		setName( "interpreter" );
		setDesc( "A module that alternately decodes and executes every statement in some body of code. The Java(TM) interpreter decodes and executes bytecode for the Java virtual machine*." );
	}
}

class JAE extends Vocab {
	JAE() {
		setName( "JAE" );
		setDesc( "Java(TM) Application Environment. The source code release of the Java Development Kit (JDK(TM)) software." );
	}
}

class JF extends Vocab {
	JF() {
		setName( "Jar Files (jar)" );
		setDesc( "Java ARchive. A file format used for aggregating many files into one." );
	}
}

class JFF extends Vocab {
	JFF() {
		setName( "Jar file format" );
		setDesc( "JAR (Java Archive) is a platform-independent file format that aggregates many files into one. Multiple applets written in the Java(TM) programming language, and their requisite components (.class files, images, sounds and other resource files) can be bundled in a JAR file and subsequently downloaded to a browser in a single HTTP transaction. It also supports file compression and digital signatures." );
	}
}

class JTM extends Vocab {
	JTM() {
		setName( "Java(TM)" );
		setDesc( "Sun's trademark for a set of technologies for creating and safely running software programs in both stand-alone and networked environments." );
	}
}

class JAppEnv extends Vocab {
	JAppEnv() {
		setName( "Java Application Environment (JAE)" );
		setDesc( "The source code release of the Java Development Kit (JDK(TM)) software." );
	}
}

class JBTM extends Vocab {
	JBTM() {
		setName( "JavaBeans(TM)" );
		setDesc( "A portable, platform-independent reusable component model." );
	}
}

class JBlTM extends Vocab {
	JBlTM() {
		setName( "Java Blend(TM)" );
		setDesc( "A product that enables developers to simplify database application development by mapping database records to objects in the Java(TM) programming language (Java objects) and Java objects to databases." );
	}
}

class JCTM extends Vocab {
	JCTM() {
		setName( "Java Card(TM) API" );
		setDesc( "An ISO 7816-4 compliant application environment focused on smart cards." );
	}
}

class JCheck extends Vocab {
	JCheck() {
		setName( "JavaCheck(TM)" );
		setDesc( "A tool for checking compliance of applications and applets to a specification." );
	}
}

class JChip extends Vocab {
	JChip() {
		setName( "JavaChip(TM)" );
		setDesc( "Sun's processor, which executes bytecode for the Java(TM) virtual machine* natively. With a JavaChip processor, bytecode bypasses the virtual machine or just-in-time compiler stage to go directly to the processor." );
	}
}

class JKit extends Vocab {
	JKit() {
		setName( "Java(TM) Compatibility Kit (JCK)" );
		setDesc( "A test suite, a set of tools, and other requirements used to certify a Java platform implementation conformant both to the applicable Java platform specifications and to Java Software reference implementations." );
	}
}

class JConn extends Vocab {
	JConn() {
		setName( "Java Database Connectivity (JDBC(TM))" );
		setDesc( "An industry standard for database-independent connectivity between the Java(TM) platform and a wide range of databases. The JDBC(TM) provides a call-level API for SQL-based database access." );
	}
}

class JDConn extends Vocab {
	JDConn() {
		setName( "Java Developer Connection(SM)" );
		setDesc( "A service designed for individual developers, providing online training, product discounts, feature articles, bug information, and early access capabilities." );
	}
}

class JDKit extends Vocab {
	JDKit() {
		setName( "Java Development Kit (JDK(TM))");
		setDesc( "A software development environment for writing applets and applications in the Java programming language." );;
	}
}

class JECF extends Vocab {
	JECF() {
		setName( "Java(TM) Electronic Commerce Framework" );
		setDesc( "A structured architecture for the development of electronic commerce applications in the Java(TM) programming language." );
	}
}

class JEAPI extends Vocab {
	JEAPI() {
		setName( "Java(TM) Enterprise API" );
		setDesc( "This API makes it easy to create large-scale commercial and database applications that can share multimedia data with other applications within an organization or across the Internet. Four APIs have been designed within the Java(TM) Enterprise API family." );
	}
}

class JFC extends Vocab {
	JFC() {
		setName( "Java(TM) Foundation Classes (JFC)" );
		setDesc( "An extension that adds graphical user interface class libraries to the Abstract Windowing Toolkit (AWT)." );
	}
}

class JIDL extends Vocab {
	JIDL() {
		setName( "Java(TM) Interface Definition Language (IDL)" );
		setDesc( "APIs written in the Java programming language that provide standards-based interoperability and connectivity with CORBA (Common Object Request Broker Architecture)." );
	}
}

class JMAPI extends Vocab {
	JMAPI() {
		setName( "Java(TM) Media APIs" );
		setDesc( "A set of APIs that support the integration of audio and video clips, 2D fonts, graphics, and images as well as 3D models and telephony." );
	}
}

class JMF extends Vocab {
	JMF() {
		setName( "Java(TM) Media Framework" );
		setDesc( "The core framework supports clocks for synchronizing between different media (e.g., audio and video output). The standard extension framework allows users to do full audio and video streaming." );
	}
}

class JNaming extends Vocab {
	JNaming() {
		setName( "Java Naming and Directory Interface(TM) (JNDI)" );
		setDesc( "A set of APIs that assists with the interfacing to multiple naming and directory services." );
	}
}

class JOS extends Vocab {
	JOS() {
		setName( "JavaOS(TM)" );
		setDesc( "An Java(TM) technology-based operating system that is optimized to run on a variety of computing and consumer platforms. The JavaOS(TM) operating environment provides a runtime specifically tuned to run applications written in the Java programming language directly on hardware platforms without requiring a host operating system." );
	}
}

class JPlan extends Vocab {
	JPlan() {
		setName( "JavaPlan(TM)" );
		setDesc( "An object-oriented design and diagramming tool written in the Java(TM) programming language." );
	}
}

class JPlat extends Vocab {
	JPlat() {
		setName( "Java(TM) Platform" );
		setDesc( "Consists of a language for writing programs (\"the Java(TM) programming language\"); a set of APIs, class libraries, and other programs used in developing, compiling, and error-checking programs; and a virtual machine which loads and executes the class files. " );
	}
}

class JPlatEd extends Vocab {
	JPlatEd() {
		setName( "Java(TM) Platform Editions" );
		setDesc( "A Java platform \"edition\" is a definitive and agreed-upon version of the Java platform that provides the functionality needed over a broad market segment. An edition is comprised of two kinds of API sets: (i) \"core packages,\" which are essential to all implementations of a given platform edition, and (ii) \"optional packages,\" which are available for a given platform edition and which may be supported in a compatible implementation." );
	}
}

class JRMI extends Vocab {
	JRMI() {
		setName( "Java(TM) Remote Method Invocation (RMI)" );
		setDesc( "A distributed object model for Java(TM) program to Java program, in which the methods of remote objects written in the Java programming language can be invoked from other Java virtual machines*, possibly on different hosts." );
	}
}

class JRE extends Vocab {
	JRE() {
		setName( "Java(TM) Runtime Environment (JRE)" );
		setDesc( "A subset of the Java Development Kit (JDK(TM)) for end-users and developers who want to redistribute the runtime environment alone. The Java runtime environment consists of the Java virtual machine*, the Java core classes, and supporting files." );
	}
}

class JSafe extends Vocab {
	JSafe() {
		setName( "JavaSafe(TM)" );
		setDesc( "A tool for tracking and managing source file changes, written in the Java(TM) programming language." );
	}
}

class JScript extends Vocab {
	JScript() {
		setName( "JavaScript(TM)" );
		setDesc( "A Web scripting language that is used in both browsers and Web servers. Like all scripting languages, it is used primarily to tie other components together or to accept user input." );
	}
}

class JStudio extends Vocab {
	JStudio() {
		setName( "JavaStudio(TM)" );
		setDesc( "The first program that allows you to easily create Java(TM) technology-based applications and applets without having to know the Java programming language." );
	}
}

class JTech extends Vocab {
	JTech() {
		setName( "Java(TM) Technologies" );
		setDesc( "A set of technologies that enable the creation and safe running of software programs in both stand-alone and networked environments." );
	}
}

class JVM extends Vocab {
	JVM() {
		setName( "Java(TM) virtual machine (JVM)" );
		setDesc( "Sun's specification for or implementation of a software \"execution engine\" that safely and compatibly executes the byte codes in Java class files on a microprocessor (whether in a computer or in another electronic device)." );
	}
}

class JWS extends Vocab {
	JWS() {
		setName( "Java Web Server(TM)" );
		setDesc( "The easy-to-use, extensible, easy-to-administer, secure, platform-independent solution to speed and simplify the deployment and management of your Internet and Intranet Web sites. It provides immediate productivity for robust, full-featured, Java technology-based server applications." );
	}
}

class JWshop extends Vocab {
	JWshop() {
		setName( "Java Workshop(TM)" );
		setDesc( "A complete set of tools integrated into a single environment for managing programming with Java technology. The Java Workshop software uses a highly modular structure that enables you to easily plug new tools into the overall structure." );
	}
}

class JWallet extends Vocab {
	JWallet() {
		setName( "Java(TM) wallet" );
		setDesc( "A user interface, built on the Java(TM) Electronic Commerce Framework, which allows for online purchases, value transfers, and administrative functions." );
	}
}

class JSpaces extends Vocab {
	JSpaces() {
		setName( "JavaSpaces(TM)" );
		setDesc( "A technology that provides distributed persistence and data exchange mechanisms for code in the Java(TM) programming language." );
	}
}

class JSoft extends Vocab {
	JSoft() {
		setName( "JavaSoft(TM)" );
		setDesc( "A former business unit of Sun Microsystems, Inc., currently known as Sun Microsystems, Inc., Java Software division." );
	}
}

class JDBC extends Vocab {
	JDBC() {
		setName( "JDBC(TM)" );
		setDesc( "Java(TM) Database Connectivity. An industry standard for database-independent connectivity between the Java platform and a wide range of databases. The JDBC interface provides a call-level API for SQL-based database access." );
	}
}

class JDK extends Vocab {
	JDK() {
		setName( "JDK(TM)" );
		setDesc( "Java(TM) Development Kit software. A software development environment for writing applets and application in the Java programming language." );
	}
}

class JFC2 extends Vocab {
	JFC2() {
		setName( "JFC" );
		setDesc( "Java(TM) Foundation Class. An extension that adds graphical user interface class libraries to the Abstract Windowing Toolkit (AWT)." );
	}
}

class Jini extends Vocab {
	Jini() {
		setName( "Jini(TM) Technology" );
		setDesc( "Sun's Jini technology includes a set of APIs that may be incorporated an optional package for any Java 2 platform edition. This set of APIs enables transparent networking of devices and services and eliminates the need for system or network administration intervention by a user." );
	}
}

class JMap extends Vocab {
	JMap() {
		setName( "JMAPI" );
		setDesc( "Java(TM) Management API. A collection of Java programming language classes and interfaces that allow developers to build system, network, and service management applications." );
	}
}

class JNDI extends Vocab {
	JNDI() {
		setName( "JNDI" );
		setDesc( "Java Naming and Directory Interface(TM). A set of APIs that assist with the interfacing to multiple naming and directory services." );
	}
}

class JPEG extends Vocab {
	JPEG() {
		setName( "JPEG" );
		setDesc( "Joint Photographic Experts Group. An image file compression standard established by this group. It achieves tremendous compression at the cost of introducing distortions into the image which are almost always imperceptible." );
	}
}

class JRE2 extends Vocab {
	JRE2() {
		setName( "JRE" );
		setDesc( "Java(TM) runtime environment. A subset of the Java Developer Kit for end-users and developers who want to redistribute the runtime environment. The Java runtime environment consists of the Java virtual machine*, the Java core classes, and supporting files." );
	}
}

class JIT extends Vocab {
	JIT() {
		setName( "Just-in-time (JIT) Compiler" );
		setDesc( "A compiler that converts all of the bytecode into native machine code just as a Java(TM) program is run. This results in run-time speed improvements over code that is interpreted by a Java virtual machine*." );
	}
}

class JVM2 extends Vocab {
	JVM2() {
		setName( "JVM" );
		setDesc( "Java(TM) Virtual Machine*. The part of the Java Runtime Environment responsible for interpreting bytecodes." );
	}
}

class KW extends Vocab {
	KW() {
		setName( "keyword" );
		setDesc( "The Java(TM) programming language sets aside words as keywords - these words are reserved by the language itself and therefore are not available as names for variables or methods." );
	}
}

class Lex extends Vocab {
	Lex() {
		setName( "lexical" );
		setDesc( "Pertaining to how the characters in source code are translated into tokens that the compiler can understand." );
	}
}

class Link extends Vocab {
	Link() {
		setName( "linker" );
		setDesc( "A module that builds an executable, complete program from component machine code modules. The Java(TM) linker creates a runnable program from compiled classes." );
	}
}

class Lit extends Vocab {
	Lit() {
		setName( "literal" );
		setDesc( "The basic representation of any integer, floating point, or character value. For example, 3.0 is a double-precision floating point literal, and \"a\" is a character literal." );
	}
}

class LocVal extends Vocab {
	LocVal() {
		setName( "local variable" );
		setDesc( "A data item known within a block, but inaccessible to code outside the block. For example, any variable defined within a method is a local variable and can't be used outside the method." );
	}
}

class long_ extends Vocab {
	long_() {
		setName( "long" );
		setDesc( "A Java(TM) programming language keyword used to define a variable of type long." );
	}
}

class member extends Vocab {
	member() {
		setName( "member" );
		setDesc( "A field or method of a class. Unless specified otherwise, a member is not static." );
	}
}

class method_ extends Vocab {
	method_() {
		setName( "method" );
		setDesc( "A function defined in a class. Unless specified otherwise, a method is not static." );
	}
}

class mosaic extends Vocab {
	mosaic() {
		setName( "Mosaic" );
		setDesc( "A program that provides a simple GUI that enables easy access to the data stored on the Internet. These data may be simple files or hypertext documents. Mosaic was written by a team at NCSA." );
	}
}

class multiThread extends Vocab {
	multiThread() {
		setName( "multithreaded" );
		setDesc( "Describes a program that is designed to have parts of its code execute concurrently." );
	}
}

class native_ extends Vocab {
	native_() {
		setName( "native" );
		setDesc( "A Java(TM) programming language keyword that is used in method declarations to specify that the method is not implemented in the same Java source file, but rather in another language." );
	}
}

class NCSA extends Vocab {
	NCSA() {
		setName( "NCSA" );
		setDesc( "National Center for Supercomputer Applications." );
	}
}

class new_ extends Vocab {
	new_() {
		setName( "new" );
		setDesc( "A Java(TM) programming language keyword used to create an instance of a class." );
	}
}

class null_ extends Vocab {
	null_() {
		setName( "null" );
		setDesc( "A Java(TM) programming language keyword used to specify an undefined value for reference variables." );
	}
}

class object_ extends Vocab {
	object_() {
		setName( "object" );
		setDesc( "The principal building blocks of object-oriented programs. Each object is a programming unit consisting of data (instance variables) and functionality (instance methods)." );
	}
}

class OOD extends Vocab {
	OOD() {
		setName( "object-oriented design" );
		setDesc( "A software design method that models the characteristics of abstract or real objects using classes and objects." );
	}
}

class octal_ extends Vocab {
	octal_() {
		setName( "octal" );
		setDesc( "The numbering system using 8 as its base, using the numerals 0-7 as its digits. In programs written in the Java(TM) programming language, octal numbers must be preceded with 0." );
	}
}

class opPackage extends Vocab {
	opPackage() {
		setName( "Optional Packages" );
		setDesc( "The set or sets of APIs in a Java platform edition which are available with and may be supported in a compatible implementation. Over time, optional packages may become required in an edition as the marketplace requires them." );
	}
}

class ovl extends Vocab {
	ovl() {
		setName( "overloading" );
		setDesc( "Using one identifier to refer to multiple items in the same scope. In the Java(TM) programming language, you can overload methods but not variables or operators." );
	}
}

class ovr extends Vocab {
	ovr() {
		setName( "overriding" );
		setDesc( "Providing a different implementation of a method in a subclass of the class that originally defined the method." );
	}
}

class pckge extends Vocab {
	pckge() {
		setName( "package" );
		setDesc( "A group of types. Packages are declared with the package keyword." );
	}
}

class peer_ extends Vocab {
	peer_() {
		setName( "peer" );
		setDesc( "In networking, any functional unit in the same layer as another entity." );
	}
}

class PJTM extends Vocab {
	PJTM() {
		setName( "PersonalJava(TM)" );
		setDesc( "A Java runtime environment for network-connectable applications on personal consumer devices for home, office, and mobile use." );
	}
}

class pixel extends Vocab {
	pixel() {
		setName( "pixel" );
		setDesc( "The smallest addressable picture element on a display screen or printed page." );
	}
}

class POSIX extends Vocab {
	POSIX() {
		setName( "POSIX" );
		setDesc( "Portable Operating System for UNIX(TM). A standard that defines the language interface between the UNIX operating system and application programs through a minimal set of supported functions." );
	}
}

class Private extends Vocab {
	Private() {
		setName( "private" );
		setDesc( "A Java(TM) programming language keyword used in a method or variable declaration. It signifies that the method or variable can only be accessed by other elements of its class." );
	}
}

class process extends Vocab {
	process() {
		setName( "process" );
		setDesc( "A virtual address space containing one or more threads." );
	}
}

class property extends Vocab {
	property() {
		setName( "property" );
		setDesc( "Characteristics of an object that users can set, such as the color of a window." );
	}
}

class profiles extends Vocab {
	profiles() {
		setName("Profiles" );
		setDesc( "A Profile is a collection of Java APIs that complements one or more Java 2 Platform Editions by adding domain-specific capabilities. Profiles may also include other defined Profiles. A profile implementation requires a Java 2 Platform Edition to create a complete development and deployment environment in a targeted vertical market. Each profile is subject to an associated set of compatibility requirements. Profiles may be usable on one or more editions." );
	}
}

class Protected extends Vocab {
	Protected() {
		setName( "protected" );
		setDesc( "A Java(TM) programming language keyword used in a method or variable declaration. It signifies that the method or variable can only be accessed by elements residing in its class, subclasses, or classes in the same package." );
	}
}

class Public extends Vocab {
	Public() {
		setName( "public" );
		setDesc( "A Java(TM) programming language keyword used in a method or variable declaration. It signifies that the method or variable can be accessed by elements residing in other classes." );
	}
}

class raster extends Vocab {
	raster() {
		setName( "raster" );
		setDesc( "A line of pixels." );
	}
}

class reference extends Vocab {
	reference() {
		setName( "reference" );
		setDesc( "A data element whose value is an address." );
	}
}

class return_ extends Vocab {
	return_() {
		setName( "return" );
		setDesc( "A Java(TM) programming language keyword used to finish the execution of a method. It can be followed by a value required by the method definition." );
	}
}

class RFE extends Vocab {
	RFE() {
		setName( "RFE" );
		setDesc( "Request for Enhancement." );
	}
}

class RMI extends Vocab {
	RMI() {
		setName( "RMI" );
		setDesc( "See \"Java Remote Method Invocation.\"" );
	}
}

class root extends Vocab {
	root() {
		setName( "root" );
		setDesc( "In a hierarchy of items, the one item from which all other items are descended. The root item has nothing above it in the hierarchy." );
	}
}

class RPC extends Vocab {
	RPC() {
		setName( "RPC" );
		setDesc( "Remote Procedure Call. Executing what looks like a normal procedure call (or method invocation) by sending network packets to some remote host." );
	}
}

class RS extends Vocab {
	RS() {
		setName( "runtime system" );
		setDesc( "The software environment in which programs compiled for the Java(TM) virtual machine* can run. The runtime system includes all the code necessary to load programs written in the Java programming language, dynamically link native methods, manage memory, handle exceptions, and an implementation of the Java virtual machine, which may be a Java interpreter." );
	}
}

class sBox extends Vocab {
	sBox() {
		setName( "Sandbox" );
		setDesc( "Comprises a number of cooperating system components, ranging from security managers that execute as part of the application, to security measures designed into the Java(TM) virtual machine* and the language itself. The sandbox ensures that an untrusted, and possibly malicious, application cannot gain access to system resources." );
	}
}

class scope extends Vocab {
	scope() {
		setName( "scope" );
		setDesc( "A characteristic of an identifier that determines where the identifier can be used. Most identifiers in the Java(TM) programming environment have either class or local scope. Instance and class variables and methods have class scope; they can be used outside the class and its subclasses only by prefixing them with an instance of the class or (for class variables and methods) with the class name. All other variables are declared within methods and have local scope; they can be used only within the enclosing block." );
	}
}

class SSL extends Vocab {
	SSL() {
		setName( "Secure Socket Layer (SSL)" );
		setDesc( "A protocol that allows communication between a Web browser and a server to be encrypted for privacy." );
	}
}

class servlet extends Vocab {
	servlet() {
		setName( "servlet" );
		setDesc( "A server-side program that gives Java(TM) technology-enabled servers additional functionality." );
	}
}

class short_ extends Vocab {
	short_() {
		setName( "short" );
		setDesc( "A Java(TM) programming language keyword used to define a variable of type short." );
	}
}

class singlePrec extends Vocab {
	singlePrec() {
		setName( "single precision" );
		setDesc( "In the Java(TM) language specification, describes a floating point number with 32 bits of data." );
	}
}

class SGML extends Vocab {
	SGML() {
		setName( "SGML" );
		setDesc( "Standardized Generalized Markup Language. An ISO/ANSI/ECMA standard that specifies a way to annotate text documents with information about types of sections of a document." );
	}
}

class static_ extends Vocab {
	static_() {
		setName( "static" );
		setDesc( "A Java(TM) programming language keyword used to define a variable as a class variable. Classes maintain one copy of class variables regardless of how many instances exist of that class. \"static\" can also be used to define a method as a class method. Class methods are invoked by the class instead of a specific instance, and can only operate on class variables." );
	}
}

class statField extends Vocab {
	statField() {
		setName( "static field" );
		setDesc( "Another name for class variable." );
	}
}

class statMethod extends Vocab {
	statMethod() {
		setName( "static method" );
		setDesc( "Another name for class method." );
	}
}

class subArray extends Vocab {
	subArray() {
		setName( "subarray" );
		setDesc( "An array that is inside another array." );
	}
}

class subClass extends Vocab {
	subClass() {
		setName( "subclass" );
		setDesc( "A class that is derived from a particular class, perhaps with one or more classes in between." );
	}
}

class subType extends Vocab {
	subType() {
		setName( "subtype" );
		setDesc( "If type X extends or implements type Y, then X is a subtype of Y." );
	}
}

class spClass extends Vocab {
	spClass() {
		setName( "superclass" );
		setDesc( "A class from which a particular class is derived, perhaps with one or more classes in between." );
	}
}

class sper extends Vocab {
	sper() {
		setName( "super" );
		setDesc( "A Java(TM) programming language keyword used to access members of a class inherited by the class in which it appears." );
	}
}

class sperType extends Vocab {
	sperType() {
		setName( "supertype" );
		setDesc( "The supertypes of a type are all the interfaces and classes that are extended or implemented by that type." );
	}
}

class switch_ extends Vocab {
	switch_() {
		setName( "switch" );
		setDesc( "A Java(TM) programming language keyword used to evaluate a variable that can later be matched with a value specified by the \"case\" keyword in order to execute a group of statements." );
	}
}

class swSet extends Vocab {
	swSet() {
		setName( "Swing Set" );
		setDesc( "The code name for a collection of graphical user interface (GUI) components that runs uniformly on any native platform which supports the Java(TM) virtual machine*. Because they are written entirely in the Java programming language, these components may provide functionality above and beyond that provided by native-platform equivalents. (Contrast with AWT.)" );
	}
}

class synch extends Vocab {
	synch() {
		setName( "synchronized" );
		setDesc( "A keyword in the Java programming language that, when applied to a method or code block, guarantees that at most one thread at a time executes that code." );
	}
}

class TCP extends Vocab {
	TCP() {
		setName ("TCP/IP" );
		setDesc( "Transmission Control Protocol based on IP. This is an Internet protocol that provides for the reliable delivery of streams of data from one host to another." );
	}
}

class TCK extends Vocab {
	TCK() {
		setName( "Technology Compatibility Kit (TCK)" );
		setDesc( "A test suite, a set of tools, and other requirements used to certify an implementation of a particular Sun technology conformant both to the applicable specifications and to Sun or Sun-designated reference implementations." );
	}
}

class ThinC extends Vocab {
	ThinC() {
		setName( "Thin Client" );
		setDesc( "A system that runs a very light operating system with no local system administration and executes applications delivered over the network." );
	}
}

class this_ extends Vocab {
	this_() {
		setName( "this" );
		setDesc( "A Java(TM) programming language keyword that can be used to represent an instance of the class in which it appears. \"this\" can be used to access class variables and methods." );
	}
}

class thread extends Vocab {
	thread() {
		setName( "thread" );
		setDesc( "The basic unit of program execution. A process can have several threads running concurrently, each performing a different job, such as waiting for events or performing a time-consuming job that the program doesn't need to complete before going on. When a thread has finished its job, the thread is suspended or destroyed." );
	}
}

class throw_ extends Vocab {
	throw_() {
		setName( "throw" );
		setDesc( "A Java(TM) programming language keyword that allows the user to throw an exception or any class that implements the \"throwable\" interface." );
	}
}

class throws_ extends Vocab {
	throws_() {
		setName( "throws" );
		setDesc( "A Java(TM) programming language keyword used in method declarations that specify which exceptions are not handled within the method but rather passed to the next higher level of the program." );
	}
}

class trans extends Vocab {
	trans() {
		setName( "transient" );
		setDesc( "A keyword in the Java programming language that indicates that a field is not part of the serialized form of an object. When an object is serialized, the values of its transient fields are not included in the serial representation, while the values of its non-transient fields are included." );
	}
}

class try_ extends Vocab {
	try_() {
		setName( "try" );
		setDesc( "A Java(TM) programming language keyword that defines a block of statements that may throw a Java language exception. If an exception is thrown, an optional \"catch\" block can handle specific exceptions thrown within the \"try\" block. Also, an optional \"finally\" block will be executed regardless of whether an exception is thrown or not." );
	}
}

class type extends Vocab {
	type() {
		setName( "type" );
		setDesc( "A class or interface." );
	}
}

class uniC extends Vocab {
	uniC() {
		setName( "Unicode" );
		setDesc( "A 16-bit character set defined by ISO 10646. See also ASCII. All source code in the Java(TM) programming environment is written in Unicode." );
	}
}

class URL extends Vocab {
	URL() {
		setName( "URL" );
		setDesc( "Uniform Resource Locator. A standard for writing a text reference to an arbitrary piece of data in the WWW. A URL looks like \"protocol://host/localinfo\" where protocol specifies a protocol to use to fetch the object (like HTTP or FTP), host specifies the Internet name of the host on which to find it, and localinfo is a string (often a file name) passed to the protocol handler on the remote host." );
	}
}

class Var extends Vocab {
	Var() {
		setName( "variable" );
		setDesc( "An item of data named by an identifier. Each variable has a type, such as int or Object, and a scope." );
	}
}

class virtM extends Vocab {
	virtM() {
		setName( "virtual machine" );
		setDesc( "An abstract specification for a computing device that can be implemented in different ways, in software or hardware. You compile to the instruction set of a virtual machine much like you'd compile to the instruction set of a microprocessor. The Java(TM) virtual machine* consists of a bytecode instruction set, a set of registers, a stack, a garbage-collected heap, and an area for storing methods." );
	}
}

class void_ extends Vocab {
	void_() {
		setName( "void" );
		setDesc( "A Java(TM) programming language keyword used in method declarations to specify that the method does not return any value. \"void\" can also be used as a nonfunctional statement." );
	}
}

class volaT extends Vocab {
	volaT() {
		setName( "volatile" );
		setDesc( "A Java(TM) programming language keyword used in variable declarations that specifies that the variable is modified asynchronously by concurrently running threads." );
	}
}

class wait extends Vocab {
	wait() {
		setName( "wait" );
		setDesc( "A UNIX command which will wait for all background processes to complete, and report their termination status." );
	}
}

class while_ extends Vocab {
	while_() {
		setName( "while" );
		setDesc( "A Java(TM) programming language keyword used to declare a loop that iterates a block of statements. The loop`s exit condition is specified as part of the while statement." );
	}
}

class wrf extends Vocab {
	wrf() {
		setName( "world readable files" );
		setDesc( "Files on a file system that can be viewed (read) by any user. For example: files residing on web servers can only be viewed by Internet users if their permissions have been set to world readable." );
	}
}

class wrapper extends Vocab {
	wrapper() {
		setName( "wrapper" );
		setDesc( "An object that encapsulates and delegates to another object to alter its interface or behavior in some way." );
	}
}

class WWW extends Vocab {
	WWW() {
		setName( "WWW" );
		setDesc( "World Wide Web. The web of systems and the data in them that is the Internet." );
	}
}