package AlgotirmLaba1;

public class NodeOneWay<E> {
    private E data;
    private NodeOneWay nextNode;

    public NodeOneWay(E data, NodeOneWay nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public NodeOneWay(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeOneWay getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeOneWay nextNode) {
        this.nextNode = nextNode;
    }
}
