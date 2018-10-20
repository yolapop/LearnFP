package lesson3;

public class Lesson3_A {

    public static void main(String[] args) {
        Lesson3.NonEmpty[] a = new Lesson3.NonEmpty[]{new Lesson3.NonEmpty(1, new Lesson3.Empty(), new Lesson3.Empty())};
        // Array is covariant in Java
        Lesson3.IntSet[] b = a;
        b[0] = new Lesson3.Empty(); // will throw java.lang.ArrayStoreException at runtime
        Lesson3.NonEmpty s = a[0];
    }

    // what happened?
    // Array in Java was designed to be covariant.
    // At runtime, when creating an Array, they store its type.
    // So at line 9, we can't assign Empty to a NonEmpty array.
    // Java make this kind of runtime error to bargain with method sort(Object[] arr)

}
