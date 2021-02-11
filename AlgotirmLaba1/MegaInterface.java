package AlgotirmLaba1;

public interface MegaInterface<E> {
    public void add(E data) throws Exception;
    public void remove(int index) throws Exception;
    public int getSize();
    public void removeFirst() throws Exception;
    public void removeLast() throws Exception;
    public void addFirst(E data) throws Exception;
    public void addLast(E data) throws Exception;

}
