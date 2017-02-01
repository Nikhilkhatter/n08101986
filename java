
OO design Principles :
Encapsulate what varies.
Favor composition over inheritance.
Program to interfaces, not implementations.
Strive for loosely coupled designs between objects that interact.
Classes should be open for extension but closed for modification.
Depend upon abstractions. Do not depend upon concrete classes.

Decorator - Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

*When you see “new”, think “concrete”.
*All factory patterns encapsulate object creation.The Factory Method Pattern encapsulates object creation by letting subclasses decide what objects to create.
The Factory Method Pattern defi nes an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

Design Principle : Dependency Inversion Principle
Depend upon abstractions. Do not depend upon concrete classes. It suggests that our high-level components should not depend on our low-level components; rather, they should both depend on abstractions.

Factory Method relies on inheritance: object creation is delegated to subclasses which implement the factory method to create objects.
Factory Method - Define an  interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to the subclasses.
Abstract Factory relies on object composition: object creation is implemented in methods exposed in the factory interface.
Abstract Factory - Provide an interface for creating families of related or depedent objects without specifying their concrete classes.

-------------------------------------------------------------------------------------------------------------

Aggregation : A class has setB(B b) function in which object b's state is updated, when A is eligible for garbage collection, B can be still in use and accessed from outside .
Class C{  A a = new A(); B b = new B(); a.setB(B b)}

Composition : has composite obeject and constituent object, eg(A has b) when a is eligible for garbage collection, b will automatically be the same eligible for garbage collection.
-------------------------------------------------------------------------------------------------------------
Array elements are always, always, always given default values, regardless of where the array itself is declared or instantiated.
Local variables, including primitives, always, always, always must be initialized before you attempt to use them, otherwise when u try to use them, compile error.
Java is actually pass-by-value for all variables running within a single VM.
All of the wrapper classes except Character provide two constructors.
Integer i1 = new Integer(42);   // take primitive
Integer i2 = new Integer("42"); // take String as primitive


primitive to wrapper : Integer i2 = Integer.valueOf("101011", 2); // takes string argument
wrapper to primitive : xxxValue();
Integer i2 = new Integer(42); 
byte b = i2.byteValue();
short s = i2.shortValue();
double d = i2.doubleValue();

Integer and Long wrapper classes:toXxxString() (Binary, Hexadecimal, Octal)
String s3 = Integer.toHexString(254); // convert 254 to hex, result: "254 is fe"
String s4 = Long.toOctalString(254); // convert 254 to octal, result: "376"

primitive xxxValue() - to convert a Wrapper to a primitive
primitive parseXxx(String) - to convert a String to a primitive
Wrapper valueOf(String) - to convert a String to a Wrapper

In order to save memory, two instances of the  following wrapper objects (created through boxing), will always be == when their primitive values are the same.
Boolean
Byte 
Character from \u0000 to \u007f (7f is 127 in decimal)
Short and Integer from -128 to 127

When == is used to compare a primitive to a wrapper, the wrapper will be unwrapped and the comparison will be primitive to primitive.

Widening > Boxing > Var Args
but u can Box then widen

class Vararg {
	static void test(long... x)
	{ System.out.println("long..."); }
	
	static void test(Integer... x)
	{ System.out.println("Integer..."); }

	public static void main(String [] args) {
		int i = 5;
		test(i,i); // needs to widen and use var-args
	}
}
-------------------------------------------------------------------------------------------------------------


an object is eligible for garbage collection when no live thread can access it.
Java provides you a mechanism to run some code just before your object is deleted by the garbage collector.
The problem is that, as you may have gathered by now, you can't count on the garbage collector to ever delete an object. So, any code that you put into your class's overridden finalize() method is not guaranteed to run. The finalize() method for any given object might run, but you can't count on it, so don't put any essential code into your finalize() method.
1. For any given object, finalize() will be called only once (at most) by the garbage collector.
2. Calling finalize() can actually result in saving an object from deletion.

-------------------------------------------------------------------------------------------------------------

Strings are immutable, Once you have assigned a String a value, that value can never change 
java.lang.StringBuffer and java.lang.StringBuilder classes should be used when you have to make a lot of modifications to strings of characters. A common use for StringBuffers and StringBuilders is file I/O when large, ever-changing streams of input are being handled by the program.
StringBUffer : threadsafe
StringBuilder : new class same as StringBuffer with mutable Objects

If either operand is a String, the + operator becomes a String concatenation operator. If both operands are numbers, the + operator is the addition operator.
final variables can't be changed, the increment and decrement, operators can't be used with them, Compile error
Each method must either handle all checked exceptions by supplying a catch clause or list each unhandled checked exception as a thrown exception.
Assertions are typically enabled when an application is being tested and debugged, but disabled when the application is deployed.
If you use an optional finally block, it will always be invoked, regardless of whether an exception in the corresponding try is thrown or not, and regardless of whether a thrown exception is caught or not.
The only exception to the finally-will-always-be-called rule is that a finally will not be invoked if the JVM shuts down. That could happen if code from the try or catch blocks calls System.exit().
overriding function can have only checked ChildException or ParentException, or NO exception at all.
When an assert statement has two expressions, the second expression must return a value.

why strings have been made immutable in java?
a) Immutable strings increase security. As they can’t be modified once they are created, so we can use them to store sensitive data like username, password etc.
b) Immutable strings are thread safe. So, we can use them in a multi threaded code without synchronization.
c) String objects are used in class loading. If strings are mutable, it is possible that wrong class is being loaded as mutable objects are modifiable.

String intern or simply intern refers to string object in the String Constant Pool. Interning is the process of creating a string object in String Constant Pool which will be exact copy of string object in heap memory.
intern() method of java.lang.String class is used to perform interning i.e creating an exact copy of heap string object in string constant pool. When you call this method on a string object, first it checks whether there exist an object with the same content in the String Constant Pool. If object does not exist in the pool, it will create an object with the same content in the string constant pool and returns the reference of that object. If object exist in the pool than it returns reference of that object without creating a new object.
String s1 = "JAVA";
String s2 = new String("JAVA");
String s3 = s2.intern();       //Creating String Intern
System.out.println(s1 == s3);       //Output : true
-------------------------------------------------------------------------------------------------------------

inner class:
just as classes have member variables and methods, a class can also have member classes
The only way you can access the inner class is through a live instance of the outer class.
Instantiating an Inner Class : you must have an instance of the outer class to tie to the inner class.
Instantiating an Inner Class from Within the Outer Class and outside the outer class:
Referencing the Inner or Outer Instance from Within the Inner Class : this and MyOuter.this ( MyOuter is outer class )
What a Method-Local Inner Object Can and Can't Do : A method-local inner class can be instantiated only within the method where the inner
class is defined. the method local inner class object cannot use the local variables of the method the inner class is in unless the local variables are marked final!.
Method Local Inner Class : can only be Abstract or final. ( can not be public, private, protected because it is in local scope )

Anonymous Inner Classes : the whole point of making an anonymous inner class—to override one or more methods of the superclass.
Note : anonymous interface implementers can implement only one interface.
Static nested class : The class itself isn't really "static"; there's no such thing as a static class. The static modifier in this case says that the nested class is a static member of the outer class. That means it can be accessed, as with other static members, without having
an instance of the outer class.
------------------------------------------------------------------------------------------------------------
public int hashCode() :
If you look at that method's documentation, the return values are "[...] distinct integers for distinct objects. 
(This is typically implemented by converting the internal address of the object into an integer [...])".
The method in java.lang.Object is declared as native, which means the implementation is provided by the JVM and may vary depending on 
your runtime environment.

public boolean equals(Object obj)
if you don't override a class's equals()  method, you won't be able to use those objects as a key in a hashtable and you
probably won't get accurate Sets, such that there are no conceptual duplicates.
String and wrapper classes work well as keys in hashtables—they override the equals() method.
If you override equals, override hashcode method also.
Lists Lists of things (classes that implement List). ordered by index
Sets Unique things (classes that implement Set).
Maps Things with a unique ID (classes that implement Map).
Queues Things arranged by the order in which they are to be processed.
------------------------------------------------------------------------------------------------------------
Collections :
list:
ArrayList : like a growable array, fast iteration and fast random access, 
Vector : Vector methods are synchronized for thread safety.
LinkedList: elements are doubly-linked to one another,This linkage gives you new methods (beyond what you get from the List interface) for adding and removing from the beginning or end, which makes it an easy choice for implementing a stack or queue.
LinkedList may iterate more slowly than an ArrayList, but it's a good choice when you need fast insertion and deletion.

SET: unique things, doesn't allow duplicates.
HashSet A HashSet is an unsorted, unordered Set, It uses the hashcode of the object being inserted, so the more efficient your hashCode() implementation the better access performance you'll get.
LinkedHashSet A LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements. LinkedHashSet lets you iterate through the elements in the order in which they were inserted.
When using HashSet or LinkedHashSet, the objects you add to them must override hashCode().
TreeSet : elements will be in ascending order, according to natural order.

Maps : Things with a unique ID.
HashMap : unsorted, unordered Map. HashMap allows one null key and multiple null values in a collection.
Hashtable : ( t small in Hashtable ), Synchronised counterpart of HashMap.
when we say that Vector and Hashtable are synchronized, we just mean that the key methods of the class are synchronized. Hashtable doesn't let you have anything that's null.
LinkedHashMap :LinkedHashMap collection maintains insertion order, slower than HashMap for adding and removing elements, you can
expect faster iteration with a LinkedHashMap.
TreeMap : sorted by the natural order of the elements. Like TreeSet, TreeMap lets you define a custom sort order (via a
Comparable or Comparator) when you construct a TreeMap, that specifies how the elements should be compared to one another when they're being ordered.

Queue : or according to a Comparator. In either case, the elements' ordering
represents their relative priority.
PriorityQueue :purpose of a PriorityQueue is to create a "priority-in, priority out" queue as opposed to a typical FIFO queue. A PriorityQueue's elements are ordered either by natural ordering or according to a Comparator. In either case, the elements' ordering
represents their relative priority.
 
MAP: HAshMap : any classes that you use as a part of the keys for that map must override the hashCode() and equals() methods.

Navigating (Searching) TreeSets and TreeMaps
TREESET : java6 methods added are :
lower() returns the element less than the given element, and floor() returns the element less than or equal to the given element.
higher() returns the element greater than the given element, and ceiling() returns the element greater than or equal to the given element.

TreeSet.ceiling(e) Returns the lowest element >= e
TreeMap.ceilingKey(key) Returns the lowest key >= key
TreeSet.higher(e) Returns the lowest element > e
TreeMap.higherKey(key) Returns the lowest key > key
TreeSet.floor(e) Returns the highest element <= e
TreeMap.floorKey(key) Returns the highest key <= key
TreeSet.lower(e) Returns the highest element < e
TreeMap.lowerKey(key) Returns the highest key < key
TreeSet.pollFirst() Returns and removes the first entry
TreeMap.pollFirstEntry() Returns and removes the first key-value pair
TreeSet.pollLast() Returns and removes the last entry
TreeMap.pollLastEntry() Returns and removes the last key-value pair
TreeSet.descendingSet() Returns a NavigableSet in reverse order
TreeMap.descendingMap() Returns a NavigableMap in reverse order

TreeSet—(headSet(), subSet(), and tailSet())
TreeMap (headMap(), subMap(), and tailMap())
spaces sort before characters and that uppercase letters sort before lowercase characters,
------------------------------------------------------------------------------------------------------------
CopyOnWriteArrayList : ThreadSafe version of ArrayList.
read operation can be done by any no of threads.
For every write operation : seprate cloned copy will be created and these two objects( cloned and original ) will be synced by JVM. For 1000 update opearations are needed to be done, 100o copies created which is a performance issue.
So it is recommend to use CopyOnWriteARrayList where more read opearations are there with very less write operations.

1. Insertion Order is preserved in CopyOnWriteArrayList.
2. Heterogeneous objects are allowed.
3. Duplicates objects are allowed.
4. Null insertion is allowed.
5. implements Serializable, Clonable, RandomAccess Interface.
6. No ConcurrentModificationException comes. (  COWAL Iterator is Fail Safe )
7. ArrayList iterator can perform remove operation but COWAL Iterator can not perform remove operation and gives UnsupportedOperationException.

COWAL contructors : 
CopyOnWriteArrayList cowAl = new CopyOnWriteArrayList();
CopyOnWriteArrayList cowAl = new CopyOnWriteArrayList(collection);
CopyOnWriteArrayList cowAl = new CopyOnWriteArrayList(objectArray);

methods :
boolean addIfAbsent(Object o)
int addAllAbsent(Collection c)

Difference b/w ArrayList and CopyOnWriteArrayList
1. ArrayList : NOT threadsafe , CopyOnWriteArrayList: threadsafe 
2. ArrayList throws ConcurrentModificationException while modification by other thread.
3. ArrayList iterator can perform remove operation but COWAL Iterator can not perform remove operation and gives UnsupportedOperationException.
4. ArrayList version java 1.2 but CopyOnWriteArrayList java 1.5 version.
5. ArrayList : java.util package but CopyOnWriteArrayList : java.util.concurrent package.
6. ArrayList iterator is Fail Fast but CopyOnWriteArrayList iterator is FAIL SAFE.
---------------------------------------------------------------------------------------------------------

CopyOnWriteArraySet : ThreadSafe version of set.
backed collection for CopyOnWriteArraySet is CopyOnWriteArrayList.
For every update/write operation : seprate cloned copy will be created and these two objects( cloned and original ) will be synced by JVM.For 1000 update opearations are needed to be done, 100o copies created which is a performance issue.
So it is recommend to use CopyOnWriteARraySet where more read opearations are there with very less write operations.

1. Duplicates objects are NOT allowed.
2. Insertion Order is preserved as it internally works on CopyOnWriteArrayList.
3. Heterogeneous objects are allowed. ( means u can add integer as well string in same set) 
4. Null insertion is allowed.
5. No ConcurrentModificationException comes. (  COWAL Iterator is Fail Safe )
6. Iterator can not perform remove operation and gives UnsupportedOperationException.

CopyOnWriteArraySet contructors :
CopyOnWriteArraySet cowAS = new CopyOnWriteArraySet();
CopyOnWriteArraySet cowAS = new CopyOnWriteArraySet(collection);

methods : no new mothods as it's elements are already unique.

Difference b/w CopyOnWriteArrayList and SynchronizedSet:
1. CopyOnWriteArrayList : for any update operation, seprate cloned copy will be created . but in SynchronizedSet only 1 thread can access at a time while performing any operation.
2. SynchronizedSet throws ConcurrentModificationException.
3. COWAS Iterator can not perform remove operation and gives UnsupportedOperationException but normal SynchronizedSet can perform remove operation. 
4. Iterator is FAIL SAFE in COWAS but FAIL FAST in SynchronizedSet.
5. came in java1.5 COWAS  but SynchronizedSet comes in java 1.2 version.

---------------------------------------------------------------------------------------------------------

GENERICS: All the generic code is strictly for the compiler. SO The compiler even inserts the casts for you when required and JVM does not know any generics at runtime. Think of generics as strictly a compile-time protection. This is a little different from arrays, which give you BOTH compile-time protection and runtime protection.
List<Parent> myList = new ArrayList<Child>();  // DOES NOT WORK
because : the type of the variable declaration must match the type you pass to the actual object type.
Generic type of the reference and the generic type of the object must be identical.

In case of arrays, it works. like Parent[] myArray = new Child[3]; // yes  
So polymorphism does not work the same way for generics as it does with arrays.

but u can do this : as this part works with both arrays and generic collections similarly
List<Animal> animals = new ArrayList<Animal>();
animals.add(new Cat()); // OK
animals.add(new Dog()); // OK

why it was not allowed :
public void foo() {
Cat[] cats = {new Cat(), new Cat()};
addAnimal(cats); // no problem, send the Cat[] to the method
}

public void addAnimal(Animal[] animals) {
animals[0] = new Dog(); // oops! We just put a Dog but it still compiles, later will throw ArrayStoreException
// in a Cat array!
}


why it is allowed with arrays but not with collections?
because there is runtime exception (ArrayStoreException) that will prevent you from putting the wrong type of object into an array for arrays so compiler is just fine with it. But there IS no equivalent exception for generics, because of type erasure. So compiler does not allow this while using generics.
Also at runtime the JVM KNOWS the type of arrays, but does NOT know the type of a collection so JVM throws exeception in case of arrays but not in case of collections.

public void addAnimal(List<? super Dog> animal){
		animal.add(new Dog());
	}
//please accept any List with a generic type that is of type Dog, or a supertype of Dog. ( Dog or super of DOg )


<? extends Animal> means that you can take any subtype of Animal; ( only subType )
For interfaces also, same syntax 
void foo(List<? extends Serializable> list) // odd, but correct, means that you can take any subtype of Serialization Interface
eg.
public class GenericsTest {
	public static void main(String[] args) {
		List<Animal> animal = new ArrayList<Animal>();
//		List<Object> ObjectList = new ArrayList<Object>();
		animal.add(new MyDog());
		animal.add(new Dog());
		
		new GenericsTest().addAnimal(animal);
		// new GenericsTest().addAnimal(ObjectList);

	}
	
	public void addAnimal(List<? super Dog> animal){ // accepts List anything that either is Dog or a super type of Dog
		animal.add(new Dog());
// 		animal.add(new Animal()); // bcos it can be a list of Dog references, so can not add Animal here, compile error
		animal.add(new MyDog());
	}

}

---------------------------------------------------------------------------------------------------------
THREADS:
What is a thread :  1. An instance of class java.lang.Thread 2. A thread of execution
Thread class methods:
public static void sleep(long millis) throws InterruptedException - sleeps current thread for minimum specified time in ms
public static void yield() :cause the currently running thread to move back to runnable and allows other threads of same priotity to run.
public final void join() throws InterruptedException : t0.join(); // join main/current thread after t0 finished 
public final void setPriority(int newPriority)

Object class methods:
public final void wait() throws InterruptedException
public final void notify()
public final void notifyAll()
wait(), notify(), and notifyAll() must be called from within a synchronized context! 
A thread can't invoke a wait or notify method on an object unless it owns that object's lock.
Note that if the thread calling wait() does not own the lock, it will throw an IllegalMonitorStateException. This exception is not a checked exception, so you don't have to catch it explicitly.

wait() : It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().
The wait() method releases the lock prior to waiting and reacquires the lock prior to returning from the wait() method.

notify() : It wakes up one single thread that called wait() on the same object. It should be noted that calling notify() does not actually give up a lock on a resource. It tells a waiting thread that that thread can wake up. However, the lock is not actually given up until the notifier’s synchronized block has completed. So, if a notifier calls notify() on a resource but the notifier still needs to perform 10 seconds of actions on the resource within its synchronized block, the thread that had been waiting will need to wait at least another additional 10 seconds for the notifier to release the lock on the object, even though notify() had been called.

notifyAll() : It wakes up all the threads that called wait() on the same object. The highest priority thread will run first in most of the situation, though not guaranteed. 

Daemon : Java garbage collector is daemon thread
Normally program terminates when all its threads exited their run() method. Daemon threads do not prevent program to terminate 
even if they are still running, i.e. executing run(). So, you should use daemon thread if you wish not to prevent program 
termination when the thread is still running.

---------------------------------------------------------------------------------------------------------
InterruptingAThread :
The Thread class has another method to check whether Thread has been interrupted or not. It's the static method, interrupted(), 
that checks whether the current executing thread has been interrupted or not. There is an important difference between the 
isInterrupted() and the interrupted() methods. The first one doesn't change the value of the interrupted attribute, 
but the second one sets it to false. As the  interrupted() method is a static method, the utilization of the isInterrupted() 
method is recommended.

---------------------------------------------------------------------------------------------------------
Thread Safety important points:
1) Immutable objects are by default thread-safe because there state can not be modified once created. Since String is immutable in Java, its inherently thread-safe.
2) Read only or final variables in Java are also thread-safe in Java.
3) Locking is one way of achieving thread-safety in Java.
4) Static variables if not synchronized properly becomes major cause of thread-safety issues.
5) Example of thread-safe class in Java: Vector, Hashtable, ConcurrentHashMap, String etc.
6) Atomic operations in Java are thread-safe e.g. reading a 32 bit int from memory because its an atomic operation it can't interleave with other thread.
7) local variables are also thread-safe because each thread has there own copy and using local variables is good way to writing thread-safe code in Java.
8) In order to avoid thread-safety issue minimize sharing of objects between multiple thread.
9) Volatile keyword in Java can also be used to instruct thread not to cache variables and read from main memory and can also instruct JVM not to reorder or optimize code from threading perspective.

1. A class is threadsafe when it continues to behave correctly when accessed from multiple threads.
A good example of thread safe class is java servlets which have no fields and references, no fields from other classes etc. They are stateless. Since the actions of a thread accessing a stateless object cannot affect the correctness of operations in other threads, stateless objects are threadsafe.
2. Java Synchronization will throw NullPointerException if object used in java synchronized block is null. For example, in code sample if lock is initialized as null, the synchronized (lock) will throw NullPointerException.

---------------------------------------------------------------------------------------------------------

ThradPool ( Executor Framework ):
why database conection pool is needed : to improve performance. same concept is used for threadpool.
1. creating a new thread for every job may create memory and performance pblms, to overcome this, we should go for threadPool.
2. ThreadPool is a pool of already created threads, ready to jo our job.
3. Java 1.5 version introduces threadpool framework to implement thread pools.
4. ThreadPool Framework( Executor Framework)

eg.
ExecutorService service = Executors.newFixedThreadPool(3);
service.submit(job); // runnable job
service.shutdown();
Default threadPool size is 200 for tomcat. 400 for weblogic Server and 60 for websphere
While designing the webServers and application servers, we can use thread pool concept.

Callable and Future : In the case of runnable job, thread wont return anything after completing the job.
If a thread is required to return some result after execution of the job, then we should go for Callable.
Callable Interface contains only 1 method :  public abstract Object call() throws Exception;
If we submit a callable object to executor, then after completing the job, thread returns an object of the type Future ie. Future Object can be used to retrieve the result from callable job.

Diff b/w Runnable and callable interface:
Runnable :  run method, void run() , dont return anything. package : java.lang.runnable
Callable :  call method, Future call() , throws exception already, java 1.5, package : java.util.concurrent

Submit vs Execute:
1) The submit() can accept both Runnable and Callable task but execute() can only accept the Runnable task.
2.The submit() method is declared in ExecutorService interface while execute() method is declared in the Executor interface.
3. The return type of submit() method is a Future object but return type of execute() method is void.
4.ExecutorService.submit() can accept Runnable task. However the returned Future object will return null when you tried to call get() method

Concurrency vs. Parallelism :
Concurrency is about dealing with lots of things at once. Parallelism is about doing lots of things at once.
Concurrency is when two tasks can start, run, and complete in overlapping time periods. Parallelism is when tasks literally run at the same time, eg. on a multi-core processor.
Concurrency is the composition of independently executing processes, while parallelism is the simultaneous execution of (possibly related) computations.
lock and monitors : locks provide necessary support for implementing monitors. This wait-set helps in building monitors with additional help of lock.

ScheduledThreadPoolExecutor :when You may want to execute a task after a period of time or to execute a task periodically.
ThreadPoolExecutor + Callable + Future : 

The ThreadPoolExecutor class has four different constructors but, due to their complexity, the Java concurrency API provides the Executors class to construct executors and other related objects. Although we can create ThreadPoolExecutor directly using one of its constructors, it’s recommended to use the Executors class.
The cached thread pool, we have created above, creates new threads if needed to execute the new tasks, and reuses the existing ones if they have finished the execution of the task they were running, which are now available. The cached thread pool has, however, a disadvantage of constant lying threads for new tasks, so if you send too many tasks to this executor, you can overload the system. This can be overcome using fixed thread pool, which we will learn in next tutorial.
One critical aspect of the ThreadPoolExecutor class, and of the executors in general, is that you have to end it explicitly. If you don’t do this, the executor will continue its execution and the program won’t end. If the executor doesn’t have tasks to execute, it continues waiting for new tasks and it doesn’t end its execution. A Java application won’t end until all its non-daemon threads finish their execution, so, if you don’t terminate the executor, your application will never end.
To indicate to the executor that you want to finish it, you can use the shutdown() method of the ThreadPoolExecutor class. When the executor finishes the execution of all pending tasks, it finishes its execution. After you call the shutdown() method, if you try to send another task to the executor, it will be rejected and the executor will throw a RejectedExecutionException exception.
The ThreadPoolExecutor class provides a lot of methods to obtain information about its status. We used in the example the getPoolSize(), getActiveCount(), and getCompletedTaskCount() methods to obtain information about the size of the pool, the number of threads, and the number of completed tasks of the executor. You can also use the getLargestPoolSize() method that returns the maximum number of threads that has been in the pool at a time.
The ThreadPoolExecutor class also provides other methods related with the finalization of the executor. These methods are:
shutdownNow(): This method shut downs the executor immediately. It doesn’t execute the pending tasks. It returns a list with all these pending tasks. The tasks that are running when you call this method continue with their execution, but the method doesn’t wait for their finalization.
isTerminated(): This method returns true if you have called the shutdown() or shutdownNow() methods and the executor finishes the process of shutting it down.
isShutdown(): This method returns true if you have called the shutdown() method of the executor.
awaitTermination(longtimeout,TimeUnitunit): This method blocks the calling thread until the tasks of the executor have ended or the timeout occurs. The TimeUnit class is an enumeration with the following constants: DAYS, HOURS, MICROSECONDS etc.

newFixedThreadPool() method creates an executor with a maximum number of threads at any time. If you send more tasks than the number of threads, the remaining tasks will be blocked until there is a free thread to process them This method receives the maximum number of threads as a parameter you want to have in your executor.

newSingleThreadExecutor : The Executors class also provides the newSingleThreadExecutor() method. This is an extreme case of a fixed-size thread executor. It creates an executor with only one thread, so it can only execute one task at a time.


ConcurrentLinkedDeque : (Non-blocking Thread-safe List). Concurrent lists allow the various threads to add or remove elements in the list at a time without producing any data inconsistency. And non-blocking lists provide operations that, if the operation can’t be done immediately, lists throw an exception or return a null value, depending on the operation. Java 7 has introduced the ConcurrentLinkedDeque class that implements a non-blocking concurrent list
LnkedBlockingQueue : by default if we use a theread pool( this gets used in Executors class get executors method eg. newFixedThreadPool(2) )

You can control the number of tasks executing at any time parameter passes in Semaphore constructor.

---------------------------------------------------------------------------------------------------------
ThreadGroup : Based on functionality, we can group threads into a single unit which is nothing but ThreadGroup ie. ThreadGroup contains a group of threads. In addtion to threads, ThreadGroup can also contain sub-ThreadGroups. eg. all printing threads. 
Advantage : common operations becomes easily.
Every thread in java belongs to some ThreadGroup. eg. main thread belongs to main ThreadGroup. Every ThreadGroup is the child group of system directly or indirectly. Hence system group act as root of all thread groups in java. eg. garbage collectior thread and reference handler are system level threads. System group contains several system level threads. eg. finalizer, reference handler , attached listener, signal dispatcher threads.

How we can create ThreadGroups.
ThreadGroup is java class directly under Object class under java.lang package.
---------------------------------------------------------------------------------------------------------
Thread Local : Local to thread eg. request attribute in servlets have only request scope1..
The Java Concurrency API includes the InheritableThreadLocal class that provides inheritance of values for threads created from a thread. If a thread A has a value in a threadlocal variable and it creates another thread B, the thread B will have the same value as the thread A in the thread-local variable. You can override the childValue() method that is called to initialize the value of the child thread in the thread-local variable.
Go for InheritableThreadLocal when child thread wants the parent thread's threadlocal value or wants its own child Thread's threadlocal value ( by overriding childValue() ).
It is therad specific local variable.
ThreadLocal class provides thread local variables.
ThreadLocal class maintains values per thread basis.
Each thread local object maintains a seprate value like userId, transactionId etc for each thread that access that threadlocal object.
Thread can access its local value , can manilpulate its value and even can remove its value anywhere in the code where the thread is executing. eg. consider a servlet, which invokes some business methods, we have a requirement to generate a unique transaction id  for eacha nd every request and we have to pass this transaction id to business methods. For this requirement, we can use thread local to maintain a seprate transaction id for every request ie. for every thread.
Thread Local class introduced in java 1.2 version & enhanced in 1.5 version.
Thread local can be associated with thread scope ( Thread local variable can be used to define thread scope variables). 
A Thread can access its local variables but can not access the other thread's local variables.
Once a thread enters into dead state, all its local variables are by default eligible for garbage collection.

How to create thread local variable:
ThreadLocal tl = new ThreadLocal(); // thread local variable tl created 
what are various methods are related to ThreadLocal object?
1. Object get() : returns the value of threadlocal variable associated with current thread.
2. Object initialValue() : returns initial value of therad local variable associated with current thread (by default it returns null). 
Default implememtation of initialValue() returns null.
To customize our initial value, we have to override this initialValue() method.
3. void set(Object newValue ) : To set a new value to thread local object
4. void remove() : to remove the value of thread local variable associated with current thread. ( this method added in 1.5 version rest all are in 1.2 version )

The Java Concurrency API includes the InheritableThreadLocal class that provides inheritance of values for threads created 
from a thread. If a thread A has a value in a threadlocal variable and it creates another thread B, the thread B will have 
the same value as the thread A in the thread-local variable. You can override the childValue() method that is called to 
initialize the value of the child thread in the thread-local variable.
Go for InheritableThreadLocal when child thread wants the parent thread's threadlocal value or
wants its own child Thread's threadlocal value ( by overriding childValue() ).

---------------------------------------------------------------------------------------------------------
processingExceptionsInThread :
When a checked exception is thrown inside the run() method of a Thread object, we have to catch and treat them, because the run() method doesn't accept a throws clause. 
When an unchecked exception is thrown inside the run() method of a Thread object, the default behavior is to write the stack trace in the console and exit the program.
When an uncaught exception is thrown in Thread, the JVM looks for three possible handlers for this exception.
1. First, it looks for the uncaught exception handler of the Thread objects.
2. If this handler doesn't exist, then the JVM looks for the uncaught exception handler for ThreadGroup of the Thread objects as was explained in the Processing 
uncontrolled exceptions in a group of threads recipe. 
3. If this method doesn't exist, the JVM looks for the default uncaught exception handler. 
If none of the handlers exits, the JVM writes the stack trace of the exception in the console and exits the program.
---------------------------------------------------------------------------------------------------------
Thread factory :
1. It's easy to change the way we create objects.
2. It's easy to limit the creation of objects for limited resources.
3. It's easy to generate statistical data about the creation of the objects.
---------------------------------------------------------------------------------------------------------
Future<T> result.get() thrwos CancellationException because thread is cancelled already
Future<T> result.get() throws ExecutionException if call method throws any exception
---------------------------------------------------------------------------------------------------------
CompletionService over ExecutorService:
CompletionService  is a service that decouples the production of new asynchronous tasks from the consumption of the results of completed tasks.
With ExecutorService , once you have submitted the tasks to run , you need to manually code for efficiently getting the results of the tasks completed. With CompletionService , this is pretty much automated. The difference is not very evident in the code you have presented because you are submitting just one task. However , imagine you have a list of tasks to be submitted. In the example below , multiple tasks are submitted to the CompletionService. Then , instead of trying to find out which task has completed ( to get the results ) , it just asks the CompletionService instance to return the resuts as they become available.

eg. completeion service tries to get the Future result automatically after every 20 seconds.
CompletionService<String> service = new ExecutorCompletionService<>(executor);
Future<String> result = service.poll(20, TimeUnit.SECONDS);
**Create multiple tasks with Runnable and in their run method use CompletionService.submit(pas the task u for which u want to get the result) and get the result when availble automatically instead of looking for every result manually and seprately.

Running MultiPle Tasks and process all results manually:
List<Future<Result>> resultList =  executor.invokeAll(taskList);
<Future<Result>> result = executor.invokeAny(taskList);
---------------------------------------------------------------------------------------------------------
RejectedExecutionHandler: If a task is rejeted, how to handle it. Customization handling can be done by implementing RejectedExecutionHandler interface and override rejectedExecution(Runnable r, ThreadPoolExecutor exec) method where u can restart the Task or process accordingly.
but for this to work u have to set this TaskRejectedExecutionHandler in executor or currently running thread. eg. executor.setRejectedExecutionHandler(TaskRejectedExecutionHandler);
---------------------------------------------------------------------------------------------------------
Lock :
private Lock lock = new ReentrantLock();
lock.lock(); // acquire the lock and put other threads in waiting for lock to release ( void lock(); )
boolean lock.tryLock() 
// true : current thread get the lock 
// false : current thread could not get the lock and will do other things now and will not try to get the lock again here
---------------------------------------------------------------------------------------------------------
ReadWriteLock :
private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
readWriteLock.readLock().lock(); // can access by other threads as well for reading and no wriite lock is acquired at that time.
readWriteLock.readLock().unlock();

readWriteLock.writeLock().lock();// write only when no other thread reading, no other thread is writing.
//Thus, only one thread at a time can lock the lock for writing.
readWriteLock.writeLock().unlock();
---------------------------------------------------------------------------------------------------------
Concurrent Access to Multiple Resources using Semaphore : 
A semaphore is a counter that protects the access to one or more shared resources. Semaphore acts as Locks with counter functionality.
Semaphore semaphore = new Semaphore(3); // 3 resources max can access a shared resource
semaphore.acquire(); // decrement the counter internally
semaphore.release(); // increment the counter internally
---------------------------------------------------------------------------------------------------------
synchronizing Task In Common Point using CyclicBarrier :
It is needed when some action needs to be processed after some threads do a job in parts, and completed their parts, using all job results need to perform an action eg. game start after player joined
 
static CyclicBarrier barrier = new CyclicBarrier(3); //  does not perform a predefined action when the all parties are reached at barrier. does not perform a predefined action when the barrier is tripped.

barrier.await(); // call to this function makes thread to reach barrier
barrier.await(4, TimeUnit.SECONDS); // call to this function makes thread to reach barrier before specified timeout unless java.util.concurrent.TimeoutException

if some exception occurs for a thread before reacing the barrier, then java.util.concurrent.BrokenBarrierException occurs after reaching the barrier.
---------------------------------------------------------------------------------------------------------
synchronizing Task In Common Point using CountDownLatch :
CountDownLatch controller = new CountDownLatch(n); // n members will have conference
controller.await(); // call to this function makes thread to reach sync point
controller.await(4, TimeUnit.SECONDS);
controller.getCount();// returns current count CountDownLatch has
controller.countDown(); // decrements the CountdownLatch count
---------------------------------------------------------------------------------------------------------
Countdown Latch vs Cyclic Barrier :
1. you can not reuse CountDownLatch once the count reaches zero while you can reuse CyclicBarrier by calling reset() method which resets Barrier to its initial State. 
2. What it implies that CountDownLatch is a good for one-time events like application start-up time and CyclicBarrier can be used to in case of the recurrent event e.g. concurrently calculating a solution of the big problem etc.
---------------------------------------------------------------------------------------------------------
Phaser : executing task in multiple phase using phaser.
A reusable synchronization barrier, similar in functionality to CyclicBarrier and CountDownLatch by  supporting more flexible usage.
Phaser phaser = new Phaser(3);

phaser.arriveAndAwaitAdvance(); // Arrives at this phaser and awaits for others.
phaser.getRegisteredParties() //Returns the number of parties registered at this phaser.
phaser.arriveAndDeregister(); // Arrives at this phaser and deregisters from it without waiting for others to arrive.Deregistration reduces the number of parties required to advance in future phases.

phaser.register(); // Adds a new unarrived party to this phaser
override onAdvance method of Phaser class to control the phases. // override this func to  control the phase changes 
---------------------------------------------------------------------------------------------------------
Exchanger class:
synchronization point at which threads can pair and swap elements
exhanger.exchange(V) // Waits for another thread to arrive at this exchange point and then transfers the given object to it, receiving its object in return;
exchanger.exchange(buffer, 10, TimeUnit.SECONDS) // Waits for another thread to arrive at this exchange point (unless the current thread is interrupted or the specified waiting time elapses) and then transfers the given object to it, receiving its object in return;

Whenever a thread arrives at the exchange point, it must wait for the other thread to arrive. When the other pairing thread arrives the two threads proceed to exchange their objects.

If the specified Time-out for the exchange(V x, long timeout, TimeUnit unit) method is less than or equal to zero, the thread will not wait at all at the exchange point.
 
A synchronization point at which threads can pair and swap elements within pairs. Each thread presents some object on entry to the exchange method, matches with a partner thread, and receives its partner's object on return. An Exchanger may be viewed as a bidirectional form of a SynchronousQueue. Exchangers may be useful in applications such as genetic algorithms and pipeline designs.
---------------------------------------------------------------------------------------------------------
Reflection : It provides runtime access to JVM.  Reflection is one of the most powerful API  which help to work with classes, 
methods and variables dynamically at runtime. Basically it inspects the class attributes at runtime. Also we can say it provides
a metadata about the class. 
---------------------------------------------------------------------------------------------------------

Copy Constructor is used to create and exact copy of an object with the same values of an existing object.
But both are 2 different objects and changes to the values of on object will not affect another object.
when do we use : 
1. when you have a complex object with many attributes it is much more simpler to use the copy constructor
2. if you add an attribute to your class, you just change the copy constructor to take this new attribute into account instead of changing every occurrence of the other constructor 
	
Copy constructors, by convention, should provide a deep copy of objects. As already mentioned by other answers, 
the main convenience provided by copy constructors is when your object becomes too complex. 
Note that java.lang.Cloneable provides an (almost) similar declaration.
But there are a number of advantages to using copy constructors over the Cloneable interface.

1. Cloneable as an interface does not actually provide any methods. For it to be effective, 
you still need to override the clone method of java.lang.Object. This is quite a counterintuitive use for an interface.
2. clone returns an Object. For it to be of any use, you still need to typecast. This is awkward and could lead to runtime errors.
3. The clone method is poorly documented. For clone, things can get messed up if you have final fields pointing to mutable objects.
4. Most importantly, copy constructors can take in and deep copy instances of subclasses. IMO, this is where copy constructors really shine.

Nothing in the Java language actually provides a default construct for deep copying. 
At most, objects can just tell programmers that they can be deep copied by, say, implementing Cloneable or providing a copy constructor.
---------------------------------------------------------------------------------------------------------

Deep Cloning :
The reference values of the original and the copy are two different objects (with the same value but still different object references).
What the clone method does is create a copy of the given object.
When the new object is created, its reference is different from the original. That's why equals and == yield false.

Creates and returns a copy of this object. The precise meaning of "copy" may depend on the class of the object.
The general intent is that, for any object x, the expression:
1) x.clone() != x will be true
2) x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements.
3) x.clone().equals(x) will be true, this is not an absolute requirement.

1) If the class has only primitive data type members then a completely new copy of the object will be
created and the reference to the new object copy will be returned.
2) If the class contains members of any class type then only the object references to those members are
copied and hence the member references in both the original object as well as the cloned object refer to
the same object.
---------------------------------------------------------------------------------------------------------
Serialization : ( saving the state of an object in bytes )
serialization where an object can be represented as a sequence of bytes that includes the object’s data as well as information about the object’s type and the types of data stored in the object.

for a class to be serialized successfully, two conditions must be met:

1. The class must implement the java.io.Serializable or java.io.Externalizable interface.
2. All of the fields in the class must be serializable. If a field is not serializable, it must be marked transient.

serialVersionUID : private static final long serialVersionUID

The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found.

automatically-generated UID is generated based on a class name, implemented interfaces, and all public and protected members. Changing any of these in any way will change the serialVersionUID.So use custom one.

In deserialization process, it is required that all the parent classes of instance should be Serializable; and if any super class in hirarchy is not Serializable then it must have a default constructor.

Transient and static fields are ignored in serialization. After de-serialization transient fields and non-final static fields will be null. Final static fields still have values since they are part of the class data.

ObjectOutputStream.writeObject(obj) and ObjectInputStream.readObject() are used in serialization and de-serialization.

During serialization, you need to handle IOException; 
During de-serialization, you need to handle IOException and ClassNotFoundException. So the de-serializaed class type must be in the classpath.


If I need to serialize a Serializable class Employee, but one of its super classes is not Serializable, can Employee class still be serialized and de-serialized? The answer is yes, provided that the non-serializable super-class has a no-arg constructor, which is invoked at de-serialization to initialize that super-class.

Transient variable is a variable that can not be serialized.
Variables may be marked transient to indicate that they are not part of the persistent state of an object.”


A good usecase of transient keyword in java is HashMap class.

In HashMap Class :

transient Entry           table[];
transient int             size;
transient int             modCount;
transient int             hashSeed;
private transient Set     entrySet;

With above code, HashMap still let the non-transient fields to be treated as they would normally do, but they wrote the stored key-value
pairs at the end of the byte array one after the other. While de-serializing, it let the non-transient variables to be handled 
by default de-serialization process and then read the key-value pairs one by one. For each key the hash and the index is calculated again
and is inserted to the correct position in the table so that it can be retrieved again without any error.

In case super class is Serializable than all its subclasses will be serializable by default.No need to implement serializable interface
in subclass explicitly. 


If the superclass is serializable but we don’t want the subclass to be serialized.:::

To prevent subclass from being serialized we must implement writeObject() and readObject() method and need to throw NotSerializableException from these methods. 

Externalizable interface extends the Serializable interface and provides two methods to serialize and de-serialize an object, writeExternal and readExternal.

First of all, if a class implements the Serializable interface, then the Java Virtual Machine (JVM) is responsible for its automatic serialization. Otherwise, if a class implements the Externalizable interface, the developer and maintainer of a class is responsible for its serialization.

Second, the Externalizable interface poses the challenge of how to serialize the super type state, default values in case of transient variables and finally, static variables.

Third, in case a class implements the Externalizable inteface and a single field is changed, both the writeExternal and readExternal methods must be upgraded.


7 differences between Serializable and Externalizable interface in Java
Hitesh Garg | December 19, 2014 | io | 1 Comment
In the previous Java tutorial I have discussed about Serialization using Serializable interface and Extrenalizable interface is simply an another interface to do the same work i.e. serialize and deserialize a class and its fields but with a slight variations in its implementation and also the functionality.

Before you go if you don’t have information regarding Serialization in Java then first read a few paragraphs from the Linked article – Serialization using Serializable interface.

Serialization vs Externalization in Java
Serialization vs Externalization in Java
Jump to specific part

Difference b/w Serializable and Externalizable Interfaces

Which interface should we use

So why the hell we need Externalizable interface when we have a Serializable interface?
And yes that’s a wise question and this tells that there should be something that can not be done effectively by using the Serializable Interface and vice versa.


Difference b/w Serializable and Externalizable Interfaces :

1. Serializable Interface is based on a  recursive algorithm 
2. Serializable involves reflection mechanism to recover the object.it consumes bandwidth and a performance issue.
3.A public no-arg constructor is needed while using Externalizable
4. need to define serialVersionUID in case of Serializable Interface
5. Externalizable interface is fast and also consumes less memory

when to use Externalizable interface:
1. when needed complete control over serialization process.
2. You are very much concerned about bandwidth and time consumed.
3. Your class requires a lot of serializing and deserializing operations as it will save bandwidth.



Serialization : save this object and all of its instance variables. When you serialize an object, Java serialization takes care of saving that object's entire "object graph.
the most common reason to implement writeObject() and readObject() is when you have to save some part of an object's state manually.
when you want to do only a part of the serialization/deserialization yourself, you MUST invoke the defaultReadObject() and defaultWriteObject() methods to do the rest.
If a superclass is Serializable, then according to normal Java interface rules, all subclasses of that class automatically implement Serializable implicitly.
If you serialize a collection or an array, every element must be serializable! A single non-serializable element will cause serialization to fail. Note also that while the collection interfaces are not serializable, the concrete collection classes in
the Java API are.
As simple as serialization code is to write, versioning problems can occur in the real world. If you save a Dog object using one version of the class, but attempt to deserialize it using a newer, different version of the class, deserialization might fail.
when you deserialize an object, the non-serializable superclass must run its constructor. Remember, constructors don't run on deserialized classes that implement Serializable.

Instance Variables: These variables are serialized, so during deserialization we will get back the serialized state.
Static Variables: These variables are not serialized, So during deserialization static variable value will loaded from the class.(Current value will be loaded.)
transient Variables: transient variables are not serialized, so during deserialization those variables will be initialized with corresponding default values (ex: for objects null, int 0).
Super class variables: If super class also implemented Serializable interface then those variables will be serialized, otherwise it won't serialize the super class variables. and while deserializing, JVM will run default constructor in super class and populates the default values. Same thing will happen for all superclasses.

Suppose super class of a new class implement Serializable interface, how can you avoid new class to being serialized?
To avoid Java serialization you need to implement writeObject() and readObject() method in your Class and need to throw NotSerializableException from those method.

Externalizable interface is used to write the state of an object into a byte stream in compressed format.It is not a marker interface.
difference between Serializable and Externalizable interface : Externalizable provides us writeExternal() and readExternal() method which gives us flexibility to control java serialization mechanism instead of relying on Java's default serialization. Correct implementation of Externalizable interface can improve performance of application drastically.

What is serialVersionUID? What would happen if you don't define this? : SerialVersionUID is an ID which is stamped on object when it get serialized usually hashcode of objectSerialVersionUID is used for version control of object. you can specify serialVersionUID in your class fileConsequence of not specifying serialVersionUID is that when you add or modify any field in class then already serialized class will not be able to recover because serialVersionUID generated for new class and for old serialized object will be different.Java serialization process relies on correct serialVersionUID for recovering state of serialized object and throws java.io.InvalidClassException in case of serialVersionUID mismatch,

Customize Serialization process or can you override default Serialization process in Java? :yes
For serializing an object, ObjectOutputStream.writeObject(object) is invoked and for reading ObjectOutputStream.readObject() is invoked but there is one more thing which Java Virtual Machine provides you is to define these two method in your class. If you define these two methods in your class then JVM will invoke these two methods instead of applying default serialization mechanism.
You can customize behavior of object serialization and deserialization here by doing any kind of pre or post processing task.
Important point to note is making these methods PRIVATE to avoid being inherited, overridden or overloaded. Since only Java Virtual Machine can call private method integrity of your class will remain and Java Serialization will work as normal

How to serialize a singleton class? : readResolve method in your Singleton class 
private Object readResolve() throws ObjectStreamException {
  // instead of the object we're on, return the class variable INSTANCE
  return INSTANCE; 
 }
Even though the SIngletom class constructor is private, the serializable tools have special access to create instances of a class regardless. Serialization has a special hook it uses - a private method on the class being instantiated called readResolve() - which is meant to supply a 'hook' for a class developer to ensure that they have a say in what object is returned by serialization.
So over ride this method.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Singleton implements Serializable{

	private static Singleton instance = new Singleton();
	private int i;
	
	public static Singleton getInstance() {
	    return instance;
	}
	
	private Singleton() {
		System.out.println(" default Singleton constructor ");
		this.i = 5;
	}
	
	private Object readResolve()  {
		System.out.println(" read resolve ");
	    return Singleton.getInstance();
	}
	
	
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(" before serialization i: "+s.i);
		Singleton s2 = null;
		try {
			FileOutputStream fos = new FileOutputStream("nik.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream fis = new FileInputStream("nik.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			s2 = (Singleton)ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" after  De-serialization i: "+s.i); // 5 
		System.out.println(s2==s); //true 
	}

}
---------------------------------------------------------------------------------------------------------
