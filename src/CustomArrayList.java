import java.lang.reflect.Array;

/**
 * A custom implementation of an ArrayList with a fixed capacity
 *
 * @param <T> the type of elements stored, constrained to Comparable types
 */
public class CustomArrayList<T extends Comparable<T>> {

    private T[] array;
    private int size;
    private final int capacity;
    private final Class<T> clazz;

    /**
     * Constructor for CustomArrayList.
     *
     * @param clazz the class type of the elements
     * @param capacity the maximum number of elements this array can hold
     */
    public CustomArrayList(Class<T> clazz, int capacity) {
        this.array = (T[])  Array.newInstance(clazz, capacity);
        this.size = 0;
        this.capacity = capacity;
        this.clazz = clazz;
    }

    /**
     * Adds an element to the array if it has not reached its capacity.
     *
     * @param element the element to add
     */
    public void addElement(T element) {
        if(this.size < this.capacity) {
            this.array[this.size] = element;
            this.size++;
        }
    }

    /**
     * Retrieves an element at a specified index.
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified index or null if the index is out of bounds
     */
    public T getElement(int index) {
        if(index < 0 || index >= this.size) {
            return null;
        }
        return this.array[index];
    }

    /**
     * Finds the index of the specified value in the array.
     *
     * @param value the value to find
     * @return the index of the value, or -1 if not found
     */
    public int indexOf(T value) {
        for(int i = 0; i < this.size; i++) {
            if(this.array[i].equals(value)) {
                return i;
            }
        }

        return -1; // Value not found
    }

    /**
     * Reverses the elements in the array.
     */
    public void revert() {
        T[] tempArray = (T[])  Array.newInstance(this.clazz, this.size);
        int tempSize = this.size;

        for(int i = 0; i < this.size; i++) {
            tempArray[tempSize - 1] = this.array[i];
            tempSize--;
        }

        this.array = tempArray;
    }

    /**
     * Sorts the elements in the array in ascending order.
     */
    public void sort() {

        for(int i = 0; i < this.size; i++) {
            for(int j = i+1; j < this.size; j++) {
                T temp = null;
                if(this.array[j].compareTo(this.array[i]) < 0) {
                    temp = this.array[i];
                    this.array[i] = this.array[j];
                    this.array[j] = temp;
                }
            }
        }
    }

    /**
     * Converts the elements in the array to a string representation.
     *
     * @return a string representation of the array elements
     */
    @Override
    public String toString() {
        String finalString = "";
        for(int i = 0; i < size; i++) {
            finalString += this.array[i] + ", ";
        }

        return finalString;
    }
}