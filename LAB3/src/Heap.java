public class Heap<T extends Comparable<T>> { 
    private int default_size = 10; 
    
    private T[] array;
    private int size; 

    public Heap() { 
        array = (T[]) new Comparable[default_size];
        size  = 0;
    }

    boolean isRoot(int index) {	return (index == 0);   }
    int leftChild(int index)  { return 2 * index + 1;  }
    int parent(int index)     { return (int)((index - 1) / 2); }
    int rightChild(int index) { return 2 * index + 2;   }
    T myParent(int index) { return array[parent(index)]; }
    boolean hasLeftChild(int i) { return leftChild(i) < size; } 
    boolean hasRightChild(int i){ return rightChild(i) < size; } 

    private void swap(int a, int b) { 
        T tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public boolean isEmpty() { return (size == 0); } 


    /* adding heap */
    public void add(T value) { 
        if(size == default_size) throw new IllegalStateException("Full array");
        array[size++] = value;
        bubbleUp();
    }

    public void bubbleUp() { 
        if(size == 0) throw new IllegalStateException("Shape error");
        int index = size - 1;
        while(!isRoot(index)) {
            if(myParent(index).compareTo(array[index]) <= 0) break;
            /* else part */
            swap(parent(index), index);
            index = parent(index);
        }
    }  

    /* removing */

    public T remove() {
        if(isEmpty()) return null;
        T res = array[0]; /* root */
        array[0] = array[size-1];
        size --;
        bubbleDown();
        return res;
    }

    private void bubbleDown() {
        int index = 0;
        while (hasLeftChild(index) || hasRightChild(index)){
            if (hasLeftChild(index) && hasRightChild(index)){
                if(array[leftChild(index)].compareTo(array[index]) < 0) {
                    if(array[rightChild(index)].compareTo(array[index]) < 0) {
                        if (array[rightChild(index)].compareTo(array[leftChild(index)]) < 0){
                            swap(rightChild(index),index);
                            index = rightChild(index);
                        }
                        else {
                            swap(leftChild(index),index);
                            index = leftChild(index);
                        }
                    }
                    else {
                        swap(leftChild(index),index);
                        index = leftChild(index);
                    }
                }
                else if(array[rightChild(index)].compareTo(array[index]) < 0) {
                    swap(rightChild(index),index);
                    index = rightChild(index);
                }
                else {
                    break;
                }
            }
            else if (hasLeftChild(index)){
                if(array[leftChild(index)].compareTo(array[index]) < 0) {
                    swap(leftChild(index),index);
                    index = leftChild(index);
                }
                else {
                    break;
                }
            }
            else if (hasRightChild(index)){
                if(array[rightChild(index)].compareTo(array[index]) < 0) {
                    swap(rightChild(index),index);
                    index = rightChild(index);
                }
                else {
                    break;
                }
            }
        }
    }


    public void show() {
        for(int i=0; i<size; i++)
            System.out.print(array[i] + " ");
        System.out.println("=======");
    }


    public static void main(String [] args) {
        Heap heap = new Heap<Integer>();
        for(int i=0; i<10; i++) {
            heap.add((int) (Math.random() * 10));
            heap.show();
        }


        System.out.println("You should see sorted numbers");
        while(!heap.isEmpty()) {
            System.out.print(heap.remove());
            /*heap.remove();
            heap.show();*/
        }
	
    }
       

}
	