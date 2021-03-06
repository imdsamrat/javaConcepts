<h1>Main thread in java</h1>

Java provides built-in support for multithreaded programming. A multi-threaded program contains two or more parts that can run concurrently. Each part of such a program is called a thread, and each thread defines a separate path of execution.

<h2>Main Thread</h2>

When a Java program starts up, one thread begins running immediately. This is usually called the main thread of our program, because it is the one that is executed when our program begins.

Properties :

It is the thread from which other “child” threads will be spawned.
Often, it must be the last thread to finish execution because it performs various shutdown actions
Flow diagram :

main thread in java

How to control Main thread

The main thread is created automatically when our program is started. To control it we must obtain a reference to it. This can be done by calling the method currentThread( ) which is present in Thread class. This method returns a reference to the thread on which it is called. The default priority of Main thread is 5 and for all remaining user threads priority will be inherited from parent to child.

```java
// Java program to control the Main Thread 
public class Test extends Thread 
{ 
    public static void main(String[] args) 
    { 
        // getting reference to Main thread 
        Thread t = Thread.currentThread(); 
          
        // getting name of Main thread 
        System.out.println("Current thread: " + t.getName()); 
          
        // changing the name of Main thread 
        t.setName("Geeks"); 
        System.out.println("After name change: " + t.getName()); 
          
        // getting priority of Main thread 
        System.out.println("Main thread priority: "+ t.getPriority()); 
          
        // setting priority of Main thread to MAX(10) 
        t.setPriority(MAX_PRIORITY); 
          
        System.out.println("Main thread new priority: "+ t.getPriority()); 
          
          
        for (int i = 0; i < 5; i++) 
        { 
            System.out.println("Main thread"); 
        } 
          
        // Main thread creating a child thread 
        ChildThread ct = new ChildThread(); 
          
        // getting priority of child thread 
        // which will be inherited from Main thread 
        // as it is created by Main thread 
        System.out.println("Child thread priority: "+ ct.getPriority()); 
          
        // setting priority of Main thread to MIN(1) 
        ct.setPriority(MIN_PRIORITY); 
          
        System.out.println("Child thread new priority: "+ ct.getPriority()); 
          
        // starting child thread 
        ct.start(); 
    } 
} 
  
// Child Thread class 
class ChildThread extends Thread 
{ 
    @Override
    public void run()  
    { 
        for (int i = 0; i < 5; i++) 
        { 
            System.out.println("Child thread"); 
        } 
    } 
} 
```
```text 
Output:

Current thread: main
After name change: Geeks
Main thread priority: 5
Main thread new priority: 10
Main thread
Main thread
Main thread
Main thread
Main thread
Child thread priority: 10
Child thread new priority: 1
Child thread
Child thread
Child thread
Child thread
Child thread
```

Relation between the main() method and main thread in Java

For each program, a Main thread is created by JVM(Java Virtual Machine). The “Main” thread first verifies the existence of the main() method, and then it initializes the class. Note that from JDK 6, main() method is mandatory in a standalone java application.

Deadlocking with use of Main Thread(only single thread)

We can create a deadlock by just using Main thread, i.e. by just using a single thread. The following java program demonstrate this.

```java
// Java program to demonstrate deadlock 
// using Main thread 
public class Test  
{ 
    public static void main(String[] args) 
    { 
        try
        { 
              
            System.out.println("Entering into Deadlock"); 
              
            Thread.currentThread().join(); 
              
            // the following statement will never execute 
            System.out.println("This statement will never execute"); 
              
        }  
          
        catch (InterruptedException e)  
        { 
            e.printStackTrace(); 
        } 
    } 
} 
```
Output:

Entering into Deadlock
Explanation :
The statement “Thread.currentThread().join()”, will tell Main thread to wait for this thread(i.e. wait for itself) to die. Thus Main thread wait for itself to die, which is nothing but a deadlock.