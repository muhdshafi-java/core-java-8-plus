# Java-8
## Interfaces
### default method
### static method
## Lambda Expression
 * Comparison between Anonymous class and Lambda expression 
 * Lambdas implement a functional interface. 
 * Anonymous Inner Classes can extend a class or implement an interface with any number of methods. 
 * Variables – Lambdas can only access final or effectively final. 
 * State – Anonymous inner classes can use instance variables and thus can have state, lambdas cannot. 
 * Scope – Lambdas can't define a variable with the same name as a variable in enclosing scope.
 * Compilation – Anonymous compiles to a class, while lambda is an invokedynamic instruction.
 
 ### Inner Classes Scope
 #### Regular Class
 ```java
public class InnerClassScope {
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		r.run();
	}
	
}

class MyRunnable implements Runnable{
	String test = "Hello";
	@Override
	public void run() {
		System.out.println("MyRunnable.run() "+test);
		
	}
	
}
``` 

 #### Inner Class
 Lexical Scope
 ```java
public class InnerClassScope {
	
	String test = "Hello A";
	
	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		MyRunnable r = driver.new MyRunnable();
		r.run();
	}
	
	class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("MyRunnable.run() "+test);//MyRunnable.run() Hello A
		}
	}
	
}
``` 
 Lexical Scope Shadowing
 ```java
public class InnerClassScope {
	String test = "Hello A";
	
	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		MyRunnable r = driver.new MyRunnable();
		r.run();
	}
	
	class MyRunnable implements Runnable{
		String test = "Hello B";
		@Override
		public void run() {
			String test = "Hello C";
			System.out.println("MyRunnable.run() "+test);//MyRunnable.run() Hello B
		}
	}
}
``` 

 Method Local Inner class -  Local Variable
 ```java
public class InnerClassScope {

	public void test() {
		String test = "Hello A";
		Runnable r = new Runnable() {
			@Override
			public void run() {
				test = "Modified"; //Local variable test defined in an enclosing scope must be final or effectively final
				System.out.println("MyRunnable.run() :"+test);
			}
		};
		r.run();
	}
	
	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		driver.test();
	}
}
``` 

Lambda
 ```java
public class InnerClassScope {
	String test = "Hello A";

	public void test() {
		String test = "Hello A";
		
		Runnable r = () -> {
			test = "Modifed";
			System.out.println("MyRunnable.run() :" + test);
		};
		r.run();
	}

	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		driver.test();
	}
}
``` 
Lambda vs Anonymous Local Variable with same name as that in enclosing scope
 ```java
public class InnerClassScope {

	public void test() {
		String test = "Hello A";
		Runnable r = new Runnable() {
			@Override
			public void run() {
				String test = "Hello B";//Allowed
				System.out.println("MyRunnable.run() :"+test);
			}
		};
		r.run();
	}
	
	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		driver.test();
	}
}

VS

public class InnerClassScope {
	public void test() {
		String test = "Hello A";
		Runnable r = () -> {
			String test = "Hello B";// Not Allowed, Lambda expression in Java doesn't have a scope of its own
			System.out.println("MyRunnable.run() :" + test);
		};
		r.run();
	}

	public static void main(String[] args) {
		InnerClassScope driver = new InnerClassScope();
		driver.test();
	}
}

		int i=0;
		
		{
			int i=0;
		}

``` 

## Method Reference
## Stream

