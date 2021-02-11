package AlgotirmLaba1;

public class NodeTwoWay <E>{

    private E data;
    private NodeTwoWay nextNode;
    private NodeTwoWay prevNote;

    public NodeTwoWay(E data, NodeTwoWay nextNode, NodeTwoWay prevNote) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNote = prevNote;
    }

    public NodeTwoWay(E data, NodeTwoWay nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public NodeTwoWay(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeTwoWay getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeTwoWay nextNode) {
        this.nextNode = nextNode;
    }

    public NodeTwoWay getPrevNote() {
        return prevNote;
    }

    public void setPrevNote(NodeTwoWay prevNote) {
        this.prevNote = prevNote;
    }
}
