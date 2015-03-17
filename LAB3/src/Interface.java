/*
 * Created by Prasanna on 3/14/2015.
 */
interface Interface<T extends Comparable<T>> {

    public void addElement(T value);

    public void removeElement();

    public T root();
}

