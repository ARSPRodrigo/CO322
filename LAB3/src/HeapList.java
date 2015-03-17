import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Prasanna on 3/14/2015.
 * Min heap for linked storage
 */
public class HeapList <T extends Comparable<T>> implements Interface {

    private ArrayList<T> a_list;

    public HeapList() {
        a_list = new ArrayList<T>();
    }
    
    public boolean isEmpty(){ return  (a_list.size() == 0);}

    public T root() {
        if (a_list.size() == 0) {
            throw new NoSuchElementException();
        }
        return a_list.get(0);
    }

    // return the indexes
    int leftChild(int index)  { return 2 * index + 1;  }
    int parent(int index)     { return ((index - 1) / 2); }
    int rightChild(int index) { return 2 * index + 2;   }

    // return what the heap has
    boolean hasLeftChild(int i) { return leftChild(i) < a_list.size(); }
    boolean hasRightChild(int i){ return rightChild(i) < a_list.size(); }
    
    // add element
    public void addElement(Comparable value){
        a_list.add((T)value);
        bubbleUp((T)value);
    }
    
    public void bubbleUp(T value){
        int index = a_list.size()-1;

        while (index > 0) {
            if (value.compareTo(a_list.get(parent(index))) < 0) {
                a_list.set(index, a_list.get(parent(index)));
                index = parent(index);
            }
            else {
                break;
            }
        }
        a_list.set(index, value);
    }

    // remove element
    public void removeElement() {
        T value = a_list.remove(a_list.size()-1);
        int index = 0;

        if (a_list.size() > 0) {
            while (hasLeftChild(index)) {
                int minChild = leftChild(index);
                if (hasRightChild(index) && a_list.get(rightChild(index)).compareTo(a_list.get(leftChild(index))) < 0) {
                    minChild = rightChild(index);
                }

                if (value.compareTo(a_list.get(minChild)) > 0) {
                    a_list.set(index, a_list.get(minChild));
                    index = minChild;
                } else {
                    break;
                }
            }
            a_list.set(index, value);
        }
    }

    public static void main(String [] args) {

        HeapList<Integer> heap = new HeapList<Integer>();
        for(int i=0; i<10; i++) {
            heap.addElement((int) (Math.random() * 10));
        }

        while(!heap.isEmpty()) {
            System.out.print(heap.root().toString());
            heap.removeElement();
        }

    }
}
