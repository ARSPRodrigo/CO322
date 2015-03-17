import java.util.NoSuchElementException;

/*
 * Created by Prasanna on 3/14/2015.
 * Min heap for array backing storage
 */
public class HeapArray<T extends Comparable<T>> implements Interface{

    private int max_size = 1000;

    private T[] array;
    private int size;

    public HeapArray() {
        array = (T[]) new Comparable[max_size];
        size  = 0;
    }

    // return the indexes
    int leftChild(int index)  { return 2 * index + 1;  }
    int parent(int index)     { return (index - 1) / 2; }
    int rightChild(int index) { return 2 * index + 2;   }
    T myParent(int index) { return array[parent(index)]; }

    // return what the heap has
    boolean isRoot(int index) {	return (index == 0);   }
    boolean hasLeftChild(int i) { return leftChild(i) < size; }
    boolean hasRightChild(int i){ return rightChild(i) < size; }

    // swapping elements
    private void swap(int p, int q) {
        T tmp = array[p];
        array[p] = array[q];
        array[q] = tmp;
    }

    // check for empty heap
    public boolean isEmpty() { return (size == 0); }

    public T root() {
        if (array.length == 0) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    // add element
    public void addElement(Comparable value) {
        if(size == max_size) throw new IllegalStateException("Array is full");
        array[size++] = (T)value;
        bubbleUp();
    }

    public void bubbleUp() {
        if(size == 0) throw new IllegalStateException("Error");
        int index = size - 1;
        while(!isRoot(index)) {
            if(myParent(index).compareTo(array[index]) <= 0) break;

            swap(parent(index), index);
            index = parent(index);
        }
    }

    // remove element
    public void removeElement() {
        array[0] = array[size-1];
        size --;
        bubbleDown();
    }

    private void bubbleDown() {
        int index = 0;
        while (hasLeftChild(index)){
            int minChild = leftChild(index);
            if (hasRightChild(index) && array[rightChild(index)].compareTo(array[leftChild(index)]) < 0){
                minChild = rightChild(index);
            }

            if(array[index].compareTo(array[minChild]) > 0){
                swap(minChild,index);
                index = minChild;
            }
            else {
                break;
            }
        }
    }

    public static void main(String [] args) {
        HeapArray<Integer> heap = new HeapArray<Integer>();
        for(int i=0; i<10; i++) {
            heap.addElement((int) (Math.random() * 10));
        }

        while(!heap.isEmpty()) {
            System.out.print(heap.root());
            heap.removeElement();
        }

    }
}
