import java.lang.reflect.Array;

public class CustomArrayList<T extends Comparable<T>> {

    private T[] array;
    private int size;
    private final int capacity;
    private final Class<T> clazz;

    public CustomArrayList(Class<T> clazz, int capacity) {
        this.array = (T[])  Array.newInstance(clazz, capacity);
        this.size = 0;
        this.capacity = capacity;
        this.clazz = clazz;
    }

    public void addElement(T element) {
        if(this.size < this.capacity) {
            this.array[this.size] = element;
            this.size++;
        }
    }

    public T getElement(int index) {
        if(index < 0 || index >= this.size) {
            return null;
        }
        return this.array[index];
    }

    public int indexOf(T value) {
        for(int i = 0; i < this.size; i++) {
            if(this.array[i].equals(value)) {
                return i;
            }
        }

        return -1; // Value not found
    }

    public void revert() {
        T[] tempArray = (T[])  Array.newInstance(this.clazz, this.size);
        int tempSize = this.size;

        for(int i = 0; i < this.size; i++) {
            tempArray[tempSize - 1] = this.array[i];
            tempSize--;
        }

        this.array = tempArray;
    }

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

    @Override
    public String toString() {
        String finalString = "";
        for(int i = 0; i < size; i++) {
            finalString += this.array[i] + ", ";
        }

        return finalString;
    }
}