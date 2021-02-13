package AlgotirmLaba1;

public class LinkListOneWay <E> implements MegaInterface<E> {
     int size = -1;
     NodeOneWay firstNode;
     NodeOneWay lastNode;

     public int findSum() {
         if (firstNode == lastNode) {
             return (int) firstNode.getData();
         }
         else if (firstNode == null) {
             return 0;
         }

         int result = 0;
         NodeOneWay temp = firstNode;

         while (temp!=lastNode) {
             result += (int) temp.getData();
             temp = temp.getNextNode();
         }
         result += (int) temp.getData();
         return result;
     }

    public void addFirst (E data) {
        if (isEmpty()) {
            firstNode = new NodeOneWay(data);
            lastNode = firstNode;
        }
        else {
            NodeOneWay newFirstNode = new NodeOneWay(data);
            newFirstNode.setNextNode(firstNode);
            firstNode = newFirstNode;
        }
        size++;
    }

    public void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        }
        else {
            NodeOneWay newLastNode = new NodeOneWay(data);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
            size++;
        }
    }

    boolean isEmpty() {
        if (firstNode == null || size==-1) {
            return true;
        }
        else {
            return false;
        }
    }

    // Можно еще подумать.
    public int findIndexByValue(E data ) throws Exception {
        int index = -1;
        NodeOneWay tempNode  = firstNode;
        while (tempNode.getNextNode()!=null) {
            if (tempNode.getData().equals(data)) {
                return index;
            }
            tempNode = tempNode.getNextNode();
            index++;
        }
        if (index == -1) {
            throw new Exception("Нету такого элемента");
        }
        return index;
    }

    public E findDataByIndex(int index) throws Exception {
        if (index>size) {
            throw new Exception("Индекс выходит за текущие размеры: "+size);
        }
        NodeOneWay tempNode = firstNode;
        int tempIndex= -1;
        for ( ;tempIndex!=index; tempIndex++) {
            tempNode = firstNode.getNextNode();
        }
        return (E) tempNode.getData();

    }
    private NodeOneWay<E> findNodeByIndex(int index) throws Exception {
        if (index>size) {
            throw new Exception("Индекс выходит за текущие размеры: "+size);
        }
        NodeOneWay tempNode = firstNode;
        int tempIndex= -1;
        for ( ;tempIndex!=index; tempIndex++) {
            tempNode = firstNode.getNextNode();
        }
        return tempNode;

    }

    public void add( E data ) {
        addLast(data);
    }
    public void add( E data, int index) throws Exception {
        if (index > size) {
            throw new Exception("Индекс выходит за границы.");
        }
        else {
            NodeOneWay temp = findNodeByIndex(index); //Получили вершину
            NodeOneWay temp2 = temp.getNextNode();
            temp.setNextNode(new NodeOneWay(data,temp2));
        }
    }
    public void removeFirst() throws Exception {
        if (size == -1) {
            throw new Exception("Нету элементов");
        }
        NodeOneWay temp = firstNode;
        firstNode = firstNode.getNextNode();
        size--;
    }

    public void removeLast() throws Exception {
        if (size == -1) {
            throw new Exception("Нету элементов");
        }
        else if (size == 0 ) {
            removeFirst();

        }
        else {
            NodeOneWay tempNode = findNodeByIndex(size - 1);
            tempNode.setNextNode(null);
            size--;
        }
    }

    public void remove(int index) throws Exception {
        if (index>size) {
            throw new Exception("Индекс выходит за рамки массива");
        }
        NodeOneWay tempNode = findNodeByIndex(index-1);
        tempNode.setNextNode(tempNode.getNextNode().getNextNode());
        size--;
    }

    public void remove(E data) throws Exception {
        NodeOneWay tempNode = findNodeByIndex(findIndexByValue(data)) ;
        tempNode.setNextNode(tempNode.getNextNode().getNextNode());
        size--;
    }

    public int getSize() {
        // returns -1 if empty
        return size;
    }
    public void replaceFirst(E data) {
        firstNode.setData(data);
    }
    public void replaceLast(E data) {
        lastNode.setData(data);
    }
    public void replace(E data, int index) throws Exception {
        findNodeByIndex(index).setData(data);
    }

}
