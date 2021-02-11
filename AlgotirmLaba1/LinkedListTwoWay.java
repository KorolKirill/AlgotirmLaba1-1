package AlgotirmLaba1;

public class LinkedListTwoWay<E> implements MegaInterface{
    NodeTwoWay lastNode;
    NodeTwoWay firstNode;
    int size = -1;

    boolean isEmpty() {
        if (firstNode == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void add(Object data) {
        addLast(data);
    }

    @Override
    public void remove(int index) throws Exception {
        if (index>size) {
            throw new Exception("Индекс выходит за рамки массива");
        }
        NodeTwoWay tempNode = findNodeByIndex(index-1);
        tempNode.setNextNode(tempNode.getNextNode().getNextNode()); // Записываем след. вершину
        tempNode.getNextNode().getNextNode().setPrevNote(tempNode); // записываем прошлую вершину
        size--;
    }
    public void remove(E data) throws Exception {
        NodeTwoWay tempNode = findNodeByIndex(findIndexByValue(data)) ;
        tempNode.setNextNode(tempNode.getNextNode().getNextNode()); // Записываем след. вершину
        tempNode.getNextNode().getNextNode().setPrevNote(tempNode); // записываем прошлую вершину
        size--;
    }

    @Override
    public int getSize() {
        // returns -1 if empty
        return size;
    }

    @Override
    public void removeFirst() throws Exception {
        if (size == -1) {
            throw new Exception("Нету элементов");
        }
        else if (size == 0) {
            firstNode = null;
        }
        else {
            NodeTwoWay temp = firstNode;
            firstNode = firstNode.getNextNode();
            firstNode.setPrevNote(null);
        }
        size--;
    }

    @Override
    public void removeLast() throws Exception {
        if (size == -1) {
            throw new Exception("Нету элементов");
        }
        else if (size == 0 ) {
            removeFirst();
        }
        else {
            NodeTwoWay tempNode = findNodeByIndex(size - 1);
            tempNode.setNextNode(null);
            size--;
        }
    }

    public void add( E data, int index) throws Exception {
        if (index > size) {
            throw new Exception("Индекс выходит за границы.");
        }
        else {
            NodeTwoWay temp = findNodeByIndex(index);
            temp.setNextNode(new NodeTwoWay(data,temp.getNextNode(),temp));
        }
    }

    @Override
    public void addFirst(Object data) {
        if (isEmpty()) {
            firstNode = new NodeTwoWay(data);
            lastNode = firstNode;
        }
        else {
            NodeTwoWay newFirstNode = new NodeTwoWay(data);
            newFirstNode.setNextNode(firstNode);
            firstNode = newFirstNode;
        }
        size++;
    }

    @Override
    public void addLast(Object data) {
        if (isEmpty()) {
            addFirst(data);
        }
        else {
            NodeTwoWay newLastNode = new NodeTwoWay(data);
            lastNode.setNextNode(newLastNode);
            newLastNode.setPrevNote(lastNode);
            lastNode = newLastNode;
            size++;
        }
    }

    // Можно еще подумать.
    public int findIndexByValue(E data ) throws Exception {
        int index = -1;
        NodeTwoWay tempNode  = firstNode;
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
        NodeTwoWay tempNode = firstNode;
        int tempIndex= -1;
        for ( ;tempIndex!=index; tempIndex++) {
            tempNode = firstNode.getNextNode();
        }
        return (E) tempNode.getData();

    }
    private NodeTwoWay<E> findNodeByIndex(int index) throws Exception {
        if (index>size) {
            throw new Exception("Индекс выходит за текущие размеры: "+size);
        }
        NodeTwoWay tempNode = firstNode;
        int tempIndex= -1;
        for ( ;tempIndex!=index; tempIndex++) {
            tempNode = firstNode.getNextNode();
        }
        return tempNode;

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
