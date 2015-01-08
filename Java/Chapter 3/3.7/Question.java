/* Question 3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
They cannot select which specific animal they would like.
Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
You may use the built-in LinkedList data structure.
 */


public class Question {
    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        System.out.println("Dequeue: "+animals.dequeueAny().name());
        System.out.println("Dequeue: "+animals.dequeueAny().name());
        System.out.println("Dequeue: "+animals.dequeueAny().name());

        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());
        }
    }
}

