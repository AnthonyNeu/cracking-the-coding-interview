/*Question 16.5 Suppose we have the following code:
public class Foo {
    public Foo(){ ... }
    public void first() { ... }
    public void second() { ... }
    public void third() { ... }
    }

The same instance of Foo will be passed to three different threads.
ThreadA will call first, threadB will call second, and threadC will call third.
Design a mechanism to ensure that first is called before second and second is called before third.
*/

/*
Answer:
Semaphore s_a(0);
Semaphore s_b(0);
Semaphore s_c(1);
A {
    s_c.acquire(1);
    ***
    s_a.release(1);
        }
B {
    s_a.acquire(1);
    ****
    s_b.release(1);
        }
C {
    s_b.acquire(1);
        ******
    s_c.release(1);
        }

 */
public class Question {
    public static void main(String[] args) {
        Foo foo = new Foo();

        MyThread thread1 = new MyThread(foo, "first");
        MyThread thread2 = new MyThread(foo, "second");
        MyThread thread3 = new MyThread(foo, "third");

        thread3.start();
        thread2.start();
        thread1.start();
    }
}
